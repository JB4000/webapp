package com.danmarkmodmadspild.webapp.model;

public class HomeInfoDto {

    private String problemText;
    private String solutionText;


    public HomeInfoDto() {

    }

    public HomeInfoDto(String problemText, String solutionTest) {
        this.problemText = problemText;
        this.solutionText = solutionTest;
    }

    public String getProblemText() {
        return problemText;
    }

    public void setProblemText(String problemText) {
        this.problemText = problemText;
    }

    public String getSolutionText() {
        return solutionText;
    }

    public void setSolutionText(String solutionText) {
        this.solutionText = solutionText;
    }
}


