package com.cg.payroll.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.payroll.beans.Associate;

@Controller
public class URIController {
	@RequestMapping(value="/")
	public String getIndexPage() {
		return "indexpage";
	}
	@RequestMapping(value="addassociate")
	public String getaddAssociate() {
		return "addassociate";
	}
	
	@ModelAttribute("associate")
	public Associate getAssociate() {
		return new Associate();
	}
	@RequestMapping(value="getassociatedetails")
	public String getAssociateDetails() {
		return "getassociatedetails";
	}
	@RequestMapping(value="getallassociates")
	public String getAll() {
		return "getallassociates";
	}
	
	@RequestMapping(value="getAllAsociates")
	public String getAll1() {
		return "getAllAsociates";
	}

}
