package com.example.mytinyurl;

public class Urlmapping {


    private String tinyurl ;
    private String bigurl;

    public String getTinyurl() {
        return tinyurl;
    }

    public void setTinyurl(String tinyurl) {
        this.tinyurl = tinyurl;
    }

    public String getBigurl() {
        return bigurl;
    }

    public void setBigurl(String bigurl) {
        this.bigurl = bigurl;
    }


    public Urlmapping(String tinyurl, String bigurl) {
        this.tinyurl = tinyurl;
        this.bigurl = bigurl;
    }

    public Urlmapping() {
    }

    @Override
    public String toString() {
        return "urlmapping{" +
                "tinyurl='" + tinyurl + '\'' +
                ", bigurl='" + bigurl + '\'' +
                '}';
    }
}
