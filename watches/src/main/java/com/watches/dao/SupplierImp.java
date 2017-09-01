package com.watches.dao;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.model.Supplier;

@Repository
public class SupplierImp implements SupplierInt {
	
	@Autowired
	private SessionFactory sessionFactory;


	public void addSupplier(Supplier s) {
		
		Session ses = sessionFactory.openSession();
		s.setSupplierid(generatesupplierid());
		ses.save(s);
		ses.flush();
		ses.close();
	    saveSupplierimage(s);
	}
	
	public List<Supplier> getAllSuppliers()
	{
		Session ses=sessionFactory.openSession();
		Query qr=ses.createQuery("from Supplier");
		List<Supplier> data=qr.list();
		ses.close();
		return data;
	}
	
	
	public void deleteSupplier(String sid) {
		Session ses = sessionFactory.openSession();
		Supplier srd = ses.get(Supplier.class, sid);
		ses.delete(srd);
		ses.flush();
		ses.close();
		
	}

	
	public Supplier getSupplierById(String sid) {
		Session ses = sessionFactory.openSession();
		Supplier srd = ses.get(Supplier.class, sid);
		ses.close();
		return srd;
		
	}
	

	public void editSupplier(Supplier srd) {
		Session ses = sessionFactory.openSession();
		ses.update(srd);
		ses.flush();
		ses.close();
		
	}

	private String generatesupplierid(){
		String newSid="";		
		Session s = sessionFactory.openSession();
		Query qr = s.createQuery("from Supplier");
		List<Supplier> data = qr.list();
		s.close();
		if(data.size()==0){ 
			newSid="SUP00001";
		}
		else {		
			Session ss = sessionFactory.openSession();		
			Query q = ss.createQuery("select max(supplierid) from Supplier");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newSid="SUP0000"+id;
			else if(id<=99)
				newSid="SUP000"+id;
			else if(id<=999)
				newSid="SUP00"+id;
			else if(id<=9999)
				newSid="SUP0"+id;
			else
				newSid="SUP"+id;		
			System.out.print("\nGenerated : "+newSid);		
			ss.close();
		}	
		return newSid;			
	}	
private void saveSupplierimage(Supplier s){
		
		System.out.print("\nprd img : " + s.getSupplierimage());	
			
		try{				    	
			if (s.getSupplierimage() != null ) {		
				Path path=Paths.get("E:/workspace-bags/watches/src/main/webapp/resources/images/supplier/"+s.getSupplierid()+".jpg");
	           	s.getSupplierimage().transferTo(new File(path.toString()));                       	
	            System.out.print("\nSupplier Image saved");	            
	        }				
		}
		catch(Exception ex){
			System.out.print("\nSupplier Image not saved...");
		}				
	}	
	

}
