/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

/**
 *
 * @author Lenovo
 */
import java.util.Comparator;
 
public class sortEmployeeDays implements Comparator<pairEmployeesDays> 
{
    @Override
    public int compare(pairEmployeesDays o1, pairEmployeesDays o2) {
        return Long.compare(o2.getDays(),o1.getDays());
    }
}