package com.scrolltest.api.tests;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.scrolltest.api.model.Person;
import com.scrolltest.api.tests.helpers.PersonServiceHelper;


public class TestGETPerson {
	private PersonServiceHelper personServiceHelper;
	
    @BeforeClass
    public void init() {
      personServiceHelper = new PersonServiceHelper();
    }
    @Test
    public void testGetAllPerson (){
    	List<Person>pList = personServiceHelper.getAllPersons();
    	assertNotNull(pList, "Person List is not Empty");  
    	assertFalse(pList.isEmpty(), "Person List is not true");
    }
}
