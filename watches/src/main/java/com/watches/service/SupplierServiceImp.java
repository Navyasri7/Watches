package com.watches.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watches.dao.SupplierInt;
import com.watches.model.Supplier;

@Service
public class SupplierServiceImp implements SupplierServiceInt {
	@Autowired
	private SupplierInt supplierDao;
	public void addSupplier(Supplier s) {
		 supplierDao.addSupplier(s);

	}
	public List<Supplier> getAllSuppliers()
	{
		return supplierDao.getAllSuppliers();
	}
	public void deleteSupplier(String sid) {
	       supplierDao.deleteSupplier(sid);
		
	}
	public Supplier getSupplierById(String sid) {
	
		return supplierDao.getSupplierById(sid);
	}
	public void editSupplier(Supplier srd) {
		supplierDao.editSupplier(srd);
		
	}
	


}
