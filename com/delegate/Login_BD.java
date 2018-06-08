	package com.app.delegate;

import org.hibernate.HibernateException;

import com.app.errors.InsertOperationProblemException;
import com.app.errors.InternalProblemException;
import com.erp.dao.EmployeeMasterDAO;
import com.erp.dao.EmployeeMasterDAOFactory;
import com.erp.domain.EmployeeMaster;

	public class Login_BD {

		public String addEmployee(String designation,String empUsername,String empPassword)throws InsertOperationProblemException,InternalProblemException{
			EmployeeMasterDAO dao=null;
			EmployeeMaster employee=null;
			int empId=0;
			//use dAO
			dao=EmployeeMasterDAOFactory.getInstance();
			
			//prepare Employee objec
			employee=new EmployeeMaster();
			employee.setName(empUsername);employee.setPassword(empPassword);employee.setRole(designation);
			String msg=null;
			//invoke method
			try{
			 empId=dao.addEmployee(employee);
			 msg=" Employee Added Succesfully with Id::"+empId;
			}
			catch(HibernateException he){
				throw new InsertOperationProblemException(he.getMessage());
			}
			catch(Exception e){
				throw new InternalProblemException(e.getMessage());
			}
			return msg;
		}//method
		
	
	}//class

