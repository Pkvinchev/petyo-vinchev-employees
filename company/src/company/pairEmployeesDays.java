/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;


public class pairEmployeesDays {
    private String empIDp;
    private long days;

    public pairEmployeesDays(String empIDp, long days) {
        this.empIDp = empIDp;
        this.days = days;
    }

    public String getEmpIDp() {
        return empIDp;
    }

    public void setEmpIDp(String empIDp) {
        this.empIDp = empIDp;
    }

    public long getDays() {
        return days;
    }

    public void setDays(long days) {
        this.days = days;
    }

    @Override
    public String toString() {
         return ("EmployeeIDPair:"+this.getEmpIDp()+
                    " Days: "+ this.getDays());
    }
    
    
    
}
