package company;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Comparator;
 
public class projectIDSorter implements Comparator<Employee> 
{
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o2.getProjectID(),o1.getProjectID());
    }
}