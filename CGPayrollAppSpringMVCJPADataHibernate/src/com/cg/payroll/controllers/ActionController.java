package com.cg.payroll.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.daoservices.PayrollDAOServices;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.services.PayrollServices;

@Controller
public class ActionController {
	@Autowired	
	PayrollServices payrollService;
	@Autowired	
	PayrollDAOServices dao;
	@RequestMapping(value="/addAssociate")
	public ModelAndView addAssociate(@Valid@ModelAttribute("associate") Associate associate,BindingResult result) {
		 //if(result.hasErrors())return new ModelAndView("addassociate");
		associate=payrollService.acceptAssociateDetails(associate);
		return new ModelAndView("addsuccess","associate",associate);
	}
	@RequestMapping(value="/getAssociateDetails")
	public ModelAndView getAssociateDetails(@Valid@RequestParam("associateID") int associateID)  {
		//if(result.hasErrors())return new ModelAndView("getassociate");
		Associate associate=payrollService.getAssociateDetails(associateID);
		return new ModelAndView("addsuccess","associate",associate);
	}
	@RequestMapping(value="/getAll")
	public ModelAndView getAll() {
	ArrayList<Associate> associate =payrollService.getAllAssociatesDetails();
	return  new ModelAndView("getAllAsociates","associate",associate);
	}
}
