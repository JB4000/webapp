package com.danmarkmodmadspild.webapp.model;

public class HomeInfo {

    private String header;
    private String line1;
    private String line2;
    private String line3;
    private String line4;
    private String line5;


    public HomeInfo(String header, String line1, String line2, String line3, String line4, String line5) {
        this.header = header;
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.line4 = line4;
        this.line5 = line5;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getLine3() {
        return line3;
    }

    public void setLine3(String line3) {
        this.line3 = line3;
    }

    public String getLine4() {
        return line4;
    }

    public void setLine4(String line4) {
        this.line4 = line4;
    }

    public String getLine5() {
        return line5;
    }

    public void setLine5(String line5) {
        this.line5 = line5;
    }
}

