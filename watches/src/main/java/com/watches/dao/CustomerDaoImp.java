package com.watches.dao;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.model.Customer;
import com.watches.model.UserDetails;
import com.watches.model.Vw_Prod_Supp_Xps;

@Repository
public class CustomerDaoImp implements CustomerDaoInt {
	@Autowired
	private SessionFactory sessionFactory;
	
	public String addCustomer(Customer cust) {
		
		Session ses = sessionFactory.openSession();
		cust.setCustomerid(generateCustomerID());
		cust.getUserDetails().setUserid(generateUserID());
		cust.getShippingAddress().setShippingaddressid(generateShippingAddressID());
		cust.getBillingAddress().setBillingaddressid(generateBillingAddressID());
		cust.getCart().setCartid(generateCartID());
		ses.save(cust);
		ses.flush();
		ses.close();
		saveCustomerImage(cust);
		return cust.getUserDetails().getUserid();		
	}
	
	
	public UserDetails loginCheck(UserDetails ud) {
		
		Session ses = sessionFactory.openSession();
		//String qs = "from UserDetails where userid = '"+ud.getUserid()+"' and password = '"+ud.getPassword()+"'";
		String qs = "from UserDetails where userid = ? and password = ? and enabled=true";		
		Query qr = ses.createQuery(qs);
		qr.setParameter(0, ud.getUserid());
		qr.setParameter(1, ud.getPassword());
		UserDetails result;
		result = (UserDetails)qr.uniqueResult();
		ses.close();		
		return result;
	}
	public List<Vw_Prod_Supp_Xps> getProductsForUser() {
		Session ses = sessionFactory.openSession();
		int min,max;
		min=1;
		max=11;
		Random r=new Random();
		int val=r.nextInt((max-min)+1)+min;
		//String qrs = "from Vw_Prod_Supp_Xps order by "+val;
		String qrs = "FROM Vw_Prod_Supp_Xps x1 where productsupplierprice = (select min(productsupplierprice) from Vw_Prod_Supp_Xps x2 where x1.productid = x2.productid )order by "+val;
		Query qr = ses.createQuery(qrs);
		List<Vw_Prod_Supp_Xps> data = qr.list();
		ses.close();
		return data;
	}
		
	public List<Vw_Prod_Supp_Xps> getAllSuppProd(String pid) {
		Session ses = sessionFactory.openSession();
		String qrs = "from Vw_Prod_Supp_Xps where productid = ?";
		Query qr = ses.createQuery(qrs);
		qr.setParameter(0, pid);
		List<Vw_Prod_Supp_Xps> data = qr.list();
		ses.close();
		return data;
	}
	
	
	
	
	
public Customer getCustomerByUserid(String uid) {
		Session ses=sessionFactory.openSession();
		UserDetails temp = ses.get(UserDetails.class, uid);
		ses.close();
		return temp.getCustomer();
	}


	public Customer getCustomerByID(String custid) {
		Session ses=sessionFactory.openSession();
		Customer cust=ses.get(Customer.class,custid);
		ses.close();
		return cust;
	}


private String generateCustomerID(){
		
		String newCid="";		
		Session s = sessionFactory.openSession();
		Query qr = s.createQuery("from Customer");
		List<UserDetails> data = qr.list();
		s.close();
		if(data.size()==0){ // if table is empty
			newCid="CST00001";
		}
		else {		// if table is not empty	
			Session ss = sessionFactory.openSession();		
			Query q = ss.createQuery("select max(customerid) from Customer");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newCid="CST0000"+id;
			else if(id<=99)
				newCid="CST000"+id;
			else if(id<=999)
				newCid="CST00"+id;
			else if(id<=9999)
				newCid="CST0"+id;
			else
				newCid="CST"+id;		
			System.out.print("\nGenerated : "+newCid);		
			ss.close();
		}	
		return newCid;	
	}
	
	private String generateUserID(){
	
			String newUid="";		
			Session s = sessionFactory.openSession();
			Query qr = s.createQuery("from UserDetails");
			List<UserDetails> data = qr.list();
			s.close();
			if(data.size()==0){ // if table is empty
				newUid="USR00001";
			}
			else {		// if table is not empty	
				Session ss = sessionFactory.openSession();		
				Query q = ss.createQuery("select max(userid) from UserDetails");
				String prevId = q.list().get(0).toString();
				System.out.print("\nExisting : "+prevId);
				int id = Integer.parseInt(prevId.substring(3));
				System.out.print("\nExisting id : "+id);		
				id=id+1;
				if(id<=9)
					newUid="USR0000"+id;
				else if(id<=99)
					newUid="USR000"+id;
				else if(id<=999)
					newUid="USR00"+id;
				else if(id<=9999)
					newUid="USR0"+id;
				else
					newUid="USR"+id;		
				System.out.print("\nGenerated : "+newUid);		
				ss.close();
			}	
			return newUid;			
	}
	
	private String generateShippingAddressID(){

		String newUid="";		
		Session s = sessionFactory.openSession();
		Query qr = s.createQuery("from ShippingAddress");
		List<UserDetails> data = qr.list();
		s.close();
		if(data.size()==0){ // if table is empty
			newUid="SAD00001";
		}
		else {		// if table is not empty	
			Session ss = sessionFactory.openSession();		
			Query q = ss.createQuery("select max(shippingaddressid) from ShippingAddress");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newUid="SAD0000"+id;
			else if(id<=99)
				newUid="SAD000"+id;
			else if(id<=999)
				newUid="SAD00"+id;
			else if(id<=9999)
				newUid="SAD0"+id;
			else
				newUid="SAD"+id;		
			System.out.print("\nGenerated : "+newUid);		
			ss.close();
		}	
		return newUid;	
	}
	
	private String generateBillingAddressID(){
		
		String newUid="";		
		Session s = sessionFactory.openSession();
		Query qr = s.createQuery("from BillingAddress");
		List<UserDetails> data = qr.list();
		s.close();
		if(data.size()==0){ // if table is empty
			newUid="BAD00001";
		}
		else {		// if table is not empty	
			Session ss = sessionFactory.openSession();		
			Query q = ss.createQuery("select max(billingaddressid) from BillingAddress");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newUid="BAD0000"+id;
			else if(id<=99)
				newUid="BAD000"+id;
			else if(id<=999)
				newUid="BAD00"+id;
			else if(id<=9999)
				newUid="BAD0"+id;
			else
				newUid="BAD"+id;		
			System.out.print("\nGenerated : "+newUid);		
			ss.close();
		}	
		return newUid;	
	}
	
	private String generateCartID(){
		
		
		String newUid="";		
		Session s = sessionFactory.openSession();
		Query qr = s.createQuery("from Cart");
		List<UserDetails> data = qr.list();
		s.close();
		if(data.size()==0){ // if table is empty
			newUid="CRT00001";
		}
		else {		// if table is not empty	
			Session ss = sessionFactory.openSession();		
			Query q = ss.createQuery("select max(cartid) from Cart");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newUid="CRT0000"+id;
			else if(id<=99)
				newUid="CRT000"+id;
			else if(id<=999)
				newUid="CRT00"+id;
			else if(id<=9999)
				newUid="CRT0"+id;
			else
				newUid="CRT"+id;		
			System.out.print("\nGenerated : "+newUid);		
			ss.close();
		}	
		return newUid;
	}
	
	private void saveCustomerImage(Customer cust){
		
		System.out.print("\nprd img : " + cust.getCustomerimage());	
			
		try{				    	
			if (cust.getCustomerimage() != null ) {	
				//C:\DT-22-Workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\project1\
				//C:\DT-22-Workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\project1\resources\images\products
				
	           //Path path=Paths.get("C://DT-22-Workspace//project1//src//main//webapp//resources//images//users//"+ud.getUserid()+".jpg");	
				Path path=Paths.get("E:/workspace-bags/watches/src/main/webapp/resources/images/customer/"+cust.getCustomerid()+".jpg");
				cust.getCustomerimage().transferTo(new File(path.toString()));                       	
	            System.out.print("\nUser Image saved");	            
	        }				
		}
		catch(Exception ex){
			System.out.print("\nUser Image not saved...");
		}				
	}	

}
