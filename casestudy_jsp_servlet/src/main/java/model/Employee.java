package model;

import java.util.Date;

public class Employee {
    private Integer employeeId;
    private String employeeName;
    private Date employeeBirthday;
    private String employeeIdCard;
    private Double employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;
    private Integer employeePositionId;
    private Integer employeeEducationDegreeId;
    private Integer employeeDivisionId;

    public Employee(Integer employeeId, String employeeName, Date employeeBirthday, String employeeIdCard, Double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, Integer employeePositionId, Integer employeeEducationDegreeId, Integer employeeDivisionId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.employeePositionId = employeePositionId;
        this.employeeEducationDegreeId = employeeEducationDegreeId;
        this.employeeDivisionId = employeeDivisionId;
    }

    public Employee() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Integer getEmployeePositionId() {
        return employeePositionId;
    }

    public void setEmployeePositionId(Integer employeePositionId) {
        this.employeePositionId = employeePositionId;
    }

    public Integer getEmployeeEducationDegreeId() {
        return employeeEducationDegreeId;
    }

    public void setEmployeeEducationDegreeId(Integer employeeEducationDegreeId) {
        this.employeeEducationDegreeId = employeeEducationDegreeId;
    }

    public Integer getEmployeeDivisionId() {
        return employeeDivisionId;
    }

    public void setEmployeeDivisionId(Integer employeeDivisionId) {
        this.employeeDivisionId = employeeDivisionId;
    }
}
