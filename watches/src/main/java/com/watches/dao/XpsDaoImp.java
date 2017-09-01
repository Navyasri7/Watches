package com.watches.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.model.XMAP_Product_Supplier;

@Repository
public class XpsDaoImp implements XpsDaoInt {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addxps(XMAP_Product_Supplier xps) {
		Session ses = sessionFactory.openSession();
		xps.setPsid(generateXpsID());
		ses.save(xps);
		ses.flush();
		ses.close();
}
	public List<XMAP_Product_Supplier> getAllXps() {
		Session ses = sessionFactory.openSession();
		Query qr = ses.createQuery("from XMAP_Product_Supplier");
		List <XMAP_Product_Supplier> data = qr.list();
		ses.close();		
		return data;
	}
	public void deleteXps(String psid) {
		Session ses = sessionFactory.openSession();
		XMAP_Product_Supplier xps = (XMAP_Product_Supplier)ses.get(XMAP_Product_Supplier.class, psid);
		ses.delete(xps);
		ses.flush();
		ses.close();
	}

	public XMAP_Product_Supplier getXpsById(String psid) {
		Session ses = sessionFactory.openSession();
		XMAP_Product_Supplier xps = (XMAP_Product_Supplier)ses.get(XMAP_Product_Supplier.class, psid);		
		ses.flush();
		ses.close();
		return xps;

	}

	public void editXps(XMAP_Product_Supplier xps) {
		Session ses = sessionFactory.openSession();		
		ses.update(xps);
		ses.flush();
		ses.close();
	}

	
	
	
	
	private String generateXpsID() {

		String newXPSid = "";
		Session s = sessionFactory.openSession();
		Query qr = s.createQuery("from XMAP_Product_Supplier");
		List<XMAP_Product_Supplier> data = qr.list();
		s.close();
		if (data.size() == 0) { // if table is empty
			newXPSid = "XPS00001";
		} else { // if table is not empty
			Session ss = sessionFactory.openSession();
			Query q = ss.createQuery("select max(psid) from XMAP_Product_Supplier");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : " + prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : " + id);
			id = id + 1;
			if (id <= 9)
				newXPSid = "XPS0000" + id;
			else if (id <= 99)
				newXPSid = "XPS000" + id;
			else if (id <= 999)
				newXPSid = "XPS00" + id;
			else if (id <= 9999)
				newXPSid = "XPS0" + id;
			else
				newXPSid = "XPS" + id;
			System.out.print("\nGenerated : " + newXPSid);
			ss.close();
		}
		return newXPSid;
	}

}
