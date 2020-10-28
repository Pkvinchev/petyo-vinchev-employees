/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import java.util.Date;


public class Employee {
    private int employeeID;
    private int projectID;
    private Date dateFrom;
    private Date dateTo;

    public Employee(int employeeID, int projectID, Date dateFrom, Date dateTo) {
        this.employeeID = employeeID;
        this.projectID = projectID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public String toString() {
        return ("EmployeeID:"+this.getEmployeeID()+
                    " ProjectID: "+ this.getProjectID() +
                    " DateFrom: "+ this.getDateFrom() +
                    " DateTo: " + this.getDateTo());
    }
   
       
}

