/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Company {
    
    public static long getDifferenceDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)+1;
    }

     public static void main(String[] args) throws IOException, ParseException {
        SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");  
        ArrayList<Employee> employees = new ArrayList<Employee>();
        ArrayList<pairEmployeesDays> pairEmployees = new ArrayList<pairEmployeesDays>();
        Date dateTo = new Date();
        try(BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Lenovo\\Desktop\\employess.txt"))) {
            String str;
            while ((str = in.readLine()) != null) {
                str = str.replaceAll("\\s","");
                String[] tokens = str.split(",");
                int employeeID = Integer.parseInt(tokens[0]);
                int projectID = Integer.parseInt(tokens[1]);
                Date dateFrom = date.parse(tokens[2]);
                if(tokens[3].equals("NULL")){
                    LocalDate localDate = LocalDate.now();
                    dateTo=java.sql.Date.valueOf(localDate);
                }else{
                     dateTo = date.parse(tokens[3]);
                }               
               employees.add(new Employee(employeeID,projectID,dateFrom, dateTo));
              
            }
        }catch (IOException  e) {
              System.out.println("File Read or Parse Error");
        }
          
        employees.sort(new projectIDSorter());
        
               
        int projectID = 0;
        String employeesIDs1 = null;
        String employeesIDs2 = null;
        long counterDays=0;
        Date dateFromMax = new Date();
        Date dateToMax = new Date();
        for (int i = 0; i < employees.size();i++) 
	{ 
            for(int j=0; j < employees.size(); j++){
                if((employees.get(i).getProjectID()==employees.get(j).getProjectID())&&
                        employees.get(i).getEmployeeID()!=employees.get(j).getEmployeeID()){
                        if(employees.get(i).getDateFrom().compareTo(employees.get(j).getDateFrom())>0){
                            dateFromMax=employees.get(i).getDateFrom();
                        }else{
                            dateFromMax=employees.get(j).getDateFrom();
                        }
                        
                        if(employees.get(i).getDateTo().compareTo(employees.get(j).getDateTo())<0){
                            dateToMax=employees.get(i).getDateTo();
                        }else{
                            dateToMax=employees.get(j).getDateTo();
                        }
                        
                        if(!(dateFromMax.compareTo(dateToMax)>0)){
                            counterDays=getDifferenceDays(dateFromMax, dateToMax);
                            employeesIDs1=Integer.toString(employees.get(i).getEmployeeID())+"-"+Integer.toString(employees.get(j).getEmployeeID());
                            employeesIDs2=Integer.toString(employees.get(j).getEmployeeID())+"-"+Integer.toString(employees.get(i).getEmployeeID());
                            
                            if(pairEmployees.isEmpty()){
                                projectID=employees.get(i).getProjectID();
                                pairEmployees.add(new pairEmployeesDays(employeesIDs1,counterDays));
                                break;
                            }else{
                                for(int r=0;r<pairEmployees.size();r++){
                                    if(pairEmployees.get(r).getEmpIDp().equals(employeesIDs1)||pairEmployees.get(r).getEmpIDp().equals(employeesIDs2)){
                                        if((employees.get(i).getProjectID()<projectID)){
                                            counterDays=counterDays+pairEmployees.get(r).getDays();
                                            pairEmployees.get(r).setDays(counterDays);
                                            projectID=employees.get(i).getProjectID();
                                            break;
                                        }
                                    }else{
                                        pairEmployees.add(new pairEmployeesDays(employeesIDs1,counterDays));
                                        projectID=employees.get(i).getProjectID();
                                        break;
                                    }
                                }
                            }
                        }                                           
                }                
            }
	}   
        
        pairEmployees.sort(new sortEmployeeDays());
        
        String[] employeeNumber =  pairEmployees.get(0).getEmpIDp().split("-");
        System.out.println("Employee "+employeeNumber[0]+" and employee "+employeeNumber[1]+
                " have worked "+pairEmployees.get(0).getDays()+" hours together!");
       
    }
    
}
