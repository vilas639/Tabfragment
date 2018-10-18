package com.example.hp_pc.sqllite_sharepref.TabFragment;

public class Emp {

    int empid;
    String empname,empemail;
    public Emp()
    {

    }

    public Emp(String empname, String empemail) {

        this.empname = empname;
        this.empemail = empemail;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmpemail() {
        return empemail;
    }

    public void setEmpemail(String empemail) {
        this.empemail = empemail;
    }
}
