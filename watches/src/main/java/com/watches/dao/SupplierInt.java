package com.watches.dao;

import java.util.List;

import com.watches.model.Supplier;

public interface SupplierInt {
	void addSupplier(Supplier s);
	List<Supplier> getAllSuppliers();
	public void deleteSupplier(String sid);
	public Supplier getSupplierById(String sid);
	public void editSupplier(Supplier srd);
}
