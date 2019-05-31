package com.lv.csvparse.dto;

public class TopUserFormsDto {
    private String grp;
    private String ogrid;
    private String type;
    private String url;
    private String ymdh;

    TopUserFormsDto() { }

    public TopUserFormsDto(String grp, String ogrid, String type, String url, String ymdh) {
        this.grp = grp;
        this.ogrid = ogrid;
        this.type = type;
        this.url = url;
        this.ymdh = ymdh;
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
    }

    public String getOgrid() {
        return ogrid;
    }

    public void setOgrid(String ogrid) {
        this.ogrid = ogrid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getYmdh() {
        return ymdh;
    }

    public void setYmdh(String ymdh) {
        this.ymdh = ymdh;
    }
}
