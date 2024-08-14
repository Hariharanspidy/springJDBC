package com.hari.springJDBCDemo.repo;

import com.hari.springJDBCDemo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlienRepo {
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Alien a){
        String sql="INSERT INTO aliens (id, name, tech) VALUES (?,?,?)";
        template.update(sql,a.getId(),a.getName(),a.getTech());

    }
    public List<Alien> findall(){
        String sql="SELECT * FROM aliens";
        return template.query(sql,(rs,row)->{
            Alien a=new Alien();
            a.setId(rs.getInt(1));
            a.setName(rs.getString(2));
            a.setTech(rs.getString(3));
            return a;
        });
    }
}
