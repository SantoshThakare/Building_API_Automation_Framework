package com.scrolltest.api.tests;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.scrolltest.api.tests.helpers.PersonServiceHelper;

public class TestPOSTPerson {
	private PersonServiceHelper personServiceHelper;
    @BeforeClass
    public void init() {
        personServiceHelper = new PersonServiceHelper();
    }

    @Test
    public void testPOSTCreatePerson(){
        String id = personServiceHelper.createPerson().jsonPath().getString("id");
        System.out.println(id);
        assertNotNull(id,"Person id is not nill");

    }
	
}
