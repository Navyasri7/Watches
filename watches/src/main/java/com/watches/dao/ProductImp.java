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

import com.watches.model.Product;

@Repository
public class ProductImp implements ProductInt {
	@Autowired
	private SessionFactory sessionFactory;


	public void addproduct(Product p) {
		Session ses = sessionFactory.openSession();
		p.setProductid(generateproductid());
		ses.save(p);
		ses.flush();
		ses.close();
		saveProductImage(p);
		
	}

	public List<Product> getAllProducts() {
	
		Session ses=sessionFactory.openSession();
		Query qr=ses.createQuery("from Product");
		List<Product> data=qr.list();
		ses.close();
		return data;
	}
	
	public void deleteProduct(String pid) {
		Session ses = sessionFactory.openSession();
		Product prd = ses.get(Product.class, pid);
		ses.delete(prd);
		ses.flush();
		ses.close();
		
	}
	

	public Product getProductById(String pid) {
		
		Session ses = sessionFactory.openSession();
		Product prd = ses.get(Product.class, pid);
		ses.close();
		return prd;
	}
	
	

	public void editProduct(Product prd) {
		Session ses = sessionFactory.openSession();
		ses.update(prd);
		ses.flush();
		ses.close();
		
	}

	private String generateproductid(){
		String newPid="";		
		Session s = sessionFactory.openSession();
		Query qr = s.createQuery("from Product");
		List<Product> data = qr.list();
		s.close();
		if(data.size()==0){ 
			newPid="PRD00001";
		}
		else {		
			Session ss = sessionFactory.openSession();		
			Query q = ss.createQuery("select max(productid) from Product");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newPid="PRD0000"+id;
			else if(id<=99)
				newPid="PRD000"+id;
			else if(id<=999)
				newPid="PRD00"+id;
			else if(id<=9999)
				newPid="PRD0"+id;
			else
				newPid="PRD"+id;		
			System.out.print("\nGenerated : "+newPid);		
			ss.close();
		}	
		return newPid;			
	}	
	private void saveProductImage(Product p){
		
		System.out.print("\nprd img : " + p.getImagefile());	
			
		try{				    	
			if (p.getImagefile() != null ) {		
				Path path=Paths.get("E:/workspace-bags/watches/src/main/webapp/resources/images/product/"+p.getProductid()+".jpg");
	           	p.getImagefile().transferTo(new File(path.toString()));                       	
	            System.out.print("\nProduct Image saved");	            
	        }				
		}
		catch(Exception ex){
			System.out.print("\nProduct Image not saved...");
		}				
	}	
	


}
