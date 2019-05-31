package com.lv.csvparse.dto;

import java.util.Date;

public class TopFormsDto {
    private String ts;
    private String grp;
    private String type;
    private String url;
    private Date ymdh;

    public TopFormsDto(String ts, String grp, String type, String url, Date ymdh) {
        this.ts = ts;
        this.grp = grp;
        this.type = type;
        this.url = url;
        this.ymdh = ymdh;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
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

    public Date getYmdh() {
        return ymdh;
    }

    public void setYmdh(Date ymdh) {
        this.ymdh = ymdh;
    }
}
