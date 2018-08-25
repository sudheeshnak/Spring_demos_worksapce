package com.cg.payroll.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.daoservices.PayrollDAOServices;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;

@Component(value="payrollServices")
public class PayrollServicesImpl implements PayrollServices{
	
	@Autowired(required=true)
	PayrollDAOServices payrollDAO;

	@Override
	public Associate acceptAssociateDetails(Associate associate) {
	associate = payrollDAO.save(associate);
		return associate;
	}

	@Override
	public Associate getAssociateDetails(int associateId)  {
		Associate associate=payrollDAO.findOne(associateId);
		System.out.println(associate.getAssociateID() + associate.getFirstName());
		return associate;
	}

	@Override
	public ArrayList<Associate> getAllAssociatesDetails() {

		return (ArrayList<Associate>) payrollDAO.findAll();
	}

}
