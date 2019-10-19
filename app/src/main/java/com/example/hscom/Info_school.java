package com.example.hscom;

public class Info_school {
    private String schoolName;
    private String schoolClassification;
    private String website;

    public Info_school(String schoolName, String schoolClassification, String website) {
        this.schoolName = schoolName;
        this.schoolClassification = schoolClassification;
        this.website = website;
    }
    public String getSchoolClassification() {
        return schoolClassification;
    }

    public void setSchoolClassification(String schoolClassification) {
        this.schoolClassification = schoolClassification;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
