package com.example.mytinyurl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TinyUrlRestController {

    @Autowired
    TinyUrlResource tinyUrlResource;
    @GetMapping("url/{tinyurl}")
    public ResponseEntity<String> tinyUrl(@PathVariable String tinyurl){
        Urlmapping mapper = tinyUrlResource.converttintytobig(tinyurl);
       //return "redirect:"+bigurl;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", mapper.getBigurl());
        return new ResponseEntity<String>(headers, HttpStatus.FOUND);

    }

    @PostMapping("insert/{tinyurl}/bigurl/{bigurl}")
    public void insertMapping(@PathVariable String tinyurl,@PathVariable String bigurl) {
        Urlmapping mapping = new Urlmapping(tinyurl,bigurl);
        tinyUrlResource.insert(mapping);

    }

    @GetMapping("allurls")
    public List<Urlmapping> findAll(){
            return tinyUrlResource.findAll();
    }

}
