package com.rest.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.rest.dao.CustomerServiceDAO;
import com.rest.dto.Customer;

@Service
public class CustomerServiceDAOImpl implements CustomerServiceDAO{
	
	@Autowired
	DB mongoDB;
	
	public void insertDocument(Object object, String collectionDoc) {
		DBCollection collection = mongoDB.getCollection(collectionDoc);
		//DBObject myPerson = new BasicDBObject("_id", "jo").append("fname", "Abhinav").append("lname", "Kumar").append("age", "25");
		if(object instanceof Customer){
			collection.insert(toDBObject((Customer)object));
		} else {
			System.out.println("not an instance of person");
		}
	}
	
	public List getAllDocuments(String collectionDoc) {
		DBCollection collection = mongoDB.getCollection("person");
		List listOfPerson = new ArrayList();
		if(collectionDoc.equals("person")){
			DBCursor cursor = collection.find();
			try {
				while(cursor.hasNext()) {
					listOfPerson.add(cursor.next());
				}
			} finally {
				cursor.close();
			}
		} else {
			System.out.println("not an instance of person");
		}
		return listOfPerson;
	}
	
	public List<Customer> getAllCustomers(){
		Customer customer = null;
		List<Customer> listOfPerson = new ArrayList<Customer>();
		DBCollection collection = mongoDB.getCollection("person");
			DBCursor cursor = collection.find();
			try {
				while(cursor.hasNext()) {
					DBObject dbObject = cursor.next();
					customer = new Customer((String)dbObject.get("fname"), (String)dbObject.get("lname"), (Integer)dbObject.get("age"));
					listOfPerson.add(customer);
				}
			} finally {
				cursor.close();
			}
		return listOfPerson;
	}
	
	public static final DBObject toDBObject(Customer customer) {
		return new BasicDBObject()
		.append("fname", customer.getFname())
		.append("lname", customer.getLname())
		.append("age", customer.getAge());
	}
	
}
