package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

    @JsonProperty
    private String emp_fname;

    @JsonProperty
    private String emp_lname;

    @JsonProperty
    int bank_acct_no;

    @JsonProperty
    private String ni_no;


    public Employee(String emp_fname, String emp_lname, int bank_acct_no,
                    String ni_no) {
        this.emp_fname = emp_fname;
        this.emp_lname = emp_lname;
        this.bank_acct_no = bank_acct_no;
        this.ni_no = ni_no;
    }

    public String getEmp_fname() {
        return emp_fname;
    }

    public void setEmp_fname(String emp_fname) {
        this.emp_fname = emp_fname;
    }

    public String getEmp_lname() {
        return emp_lname;
    }

    public void setEmp_lname(String emp_lname) {
        this.emp_lname = emp_lname;
    }

    public int getBank_acct_no() {
        return bank_acct_no;
    }

    public void setBank_acct_no(int bank_acct_no) {
        this.bank_acct_no = bank_acct_no;
    }

    public String getNi_no() {
        return ni_no;
    }

    public void setNi_no(String ni_no) {
        this.ni_no = ni_no;
    }
}
