package com.watches.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.watches.model.Supplier;
import com.watches.service.SupplierServiceInt;

@Controller
public class SupplierController {
	
	@Autowired
	private SupplierServiceInt supplierService;
	
	@RequestMapping("/reqsupplier")
	public String displaysupplierpage(Model m)
	{
		m.addAttribute("supplierobject", new Supplier());
		return "supplierpage";
	}
	@RequestMapping("/reqsendsupplierdata")
	public String addsuppliertoDB(@ModelAttribute("supplierobject")Supplier s,Model m)
	{
		s.setIssupplieravailable(true);
		supplierService.addSupplier(s);
		List<Supplier> supplierdata=supplierService.getAllSuppliers();
		m.addAttribute("suppliers", supplierdata);
		System.out.println(supplierdata);
		return "displaysupplierpage";
	}
	@RequestMapping("/reqDisplaySuppliersAdmin")
	public String displaysupplier(Model m)
	{
		List<Supplier> supplierdata=supplierService.getAllSuppliers();
		m.addAttribute("suppliers", supplierdata);
		return "displaysupplierpage";
	}
	@RequestMapping("/reqDeleteSupplier")
	public String deleteProduct(@RequestParam("sid")String sid,Model m){
		
		supplierService.deleteSupplier(sid);
		
		return "redirect:reqDisplaySuppliersAdmin";
	}
	@RequestMapping("/reqEditSupplier")
	public String editSupplierPage(@RequestParam("sid")String sid,Model m){
		Supplier srd = supplierService.getSupplierById(sid);
		m.addAttribute("supplier", srd);
		return "editsupplier";
	}
	@RequestMapping("/requpdatesupplierdata")
	public String editSupplierToDB(@ModelAttribute("supplier")Supplier srd){
		supplierService.editSupplier(srd);
		return "redirect:reqDisplaySuppliersAdmin";
	}

}
