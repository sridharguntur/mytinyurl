package com.example.mytinyurl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class TinyUrlResource {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class Urlmapper implements RowMapper<Urlmapping> {

        @Override
        public Urlmapping mapRow(ResultSet resultSet, int i) throws SQLException {

            Urlmapping mapping = new Urlmapping();
            mapping.setBigurl(resultSet.getString("bigurl"));
            mapping.setTinyurl(resultSet.getString("tinyurl"));
            return mapping;
        }
    }

    public Urlmapping converttintytobig(String tinyurl){
        //String bigUrl = "http://mybidurl.com/movies/abc";
        //ring bigUrl = "/movies/abc";


//        String converttoTiny="http://mybidurl.com/"+bigUrl.hashCode();
       //p<String,String> tinyurlmap= new HashMap<String,String>();


        //nyurlmap.put(tinyurl,bigUrl);


        String sql="select tinyurl,bigurl from urlmapping where tinyurl=?";
        return jdbcTemplate.queryForObject(sql,new Object[]{tinyurl},new Urlmapper());

        //turn tinyurlmap.get(tinyurl);

    }

    public List<Urlmapping> findAll(){
        return jdbcTemplate.query("select * from urlmapping",new Urlmapper());
    }

    public int insert(Urlmapping mapping ){

        return jdbcTemplate.update("insert into urlmapping values(?,?)",new Object[]{mapping.getTinyurl(),mapping.getBigurl()});
    }

}
