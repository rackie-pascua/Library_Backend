package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HRRequest {
    private String empFname;
    private String emplname;
    private int roleId;
    int bankAcctNo;
    private String nationalInsuranceNo;
    private double salary;

    @JsonCreator
    public HRRequest(
            @JsonProperty("empFname") final String empFname,
            @JsonProperty("empLname") final String emplname,
            @JsonProperty("roleId") final int roleId,
            @JsonProperty("bankAcctNo") final int bankAcctNo,
            @JsonProperty("nationalInsuranceNo")
            final String nationalInsuranceNo,
            @JsonProperty("salary") final double salary) {
        this.empFname = empFname;
        this.emplname = emplname;
        this.roleId = roleId;
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

    public String getEmplname() {
        return emplname;
    }

    public void setEmplname(final String emplname) {
        this.emplname = emplname;
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
