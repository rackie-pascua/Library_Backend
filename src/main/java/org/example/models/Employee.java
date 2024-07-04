package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

    @JsonProperty
    private String empFname;

    @JsonProperty
    private String empLname;
    @JsonProperty
    int roleId;

    @JsonProperty
    int bankAcctNo;

    @JsonProperty
    private String nationalInsuranceNo;
    @JsonProperty
    private double salary;

    public Employee(final String empFname, final String empLname,
                    final int roleId,
                    final int bankAcctNo, final String nationalInsuranceNo,
                    final double salary) {
        this.empFname = empFname;
        this.empLname = empLname;
        this.bankAcctNo = bankAcctNo;
        this.nationalInsuranceNo = nationalInsuranceNo;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(final int roleId) {
        this.roleId = roleId;
    }

    public String getEmpFname() {
        return empFname;
    }

    public void setEmpFname(final String empFname) {
        this.empFname = empFname;
    }

    public String getEmpLname() {
        return empLname;
    }

    public void setEmpLname(final String empLname) {
        this.empLname = empLname;
    }

    public int getBankAcctNo() {
        return bankAcctNo;
    }

    public void setBankAcctNo(final int bankAcctNo) {
        this.bankAcctNo = bankAcctNo;
    }

    public String getNationalInsuranceNo() {
        return nationalInsuranceNo;
    }

    public void setNationalInsuranceNo(final String nationalInsuranceNo) {
        this.nationalInsuranceNo = nationalInsuranceNo;
    }
}


