package com.watches.service;

import java.util.List;

import com.watches.model.XMAP_Product_Supplier;

public interface XpsServiceInt {
	public void addxps(XMAP_Product_Supplier xps);
	public List<XMAP_Product_Supplier> getAllXps();
	public void deleteXps(String psid);
	public XMAP_Product_Supplier getXpsById(String psid);
	public void editXps(XMAP_Product_Supplier xps);	


}
