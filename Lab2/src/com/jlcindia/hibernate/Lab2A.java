package com.jlcindia.hibernate;

import org.hibernate.*;

public class Lab2A {

	public static void main(String[] args) {
		Transaction tx=null;
		try{
			SessionFactory sf=AHibernateUtil.getSessionFactory();
			Session session=sf.openSession();
			tx=session.beginTransaction();
			Customer cust=new Customer("dev","dev@jlc",12345,"blore",2500.0);
			session.save(cust);
			tx.commit();session.close();
			System.out.println("Record Inserted");
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		}

	}

}
