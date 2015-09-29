package com.rest.service.impl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.dao.CustomerServiceDAO;
import com.rest.dto.Customer;
import com.rest.service.CustomerService;

@Component
@Path("/customerService")
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerServiceDAO customerServiceDAO;
	
	@GET
	@Path("/customerList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getAllCustomers() {
		return customerServiceDAO.getAllCustomers();
	}
}
