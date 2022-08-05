package com.scrolltest.api.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.scrolltest.api.tests.helpers.PersonServiceHelper;

public class TestDELETEPerson {
	private PersonServiceHelper personServiceHelper;
    @BeforeClass
    public void init() {

        personServiceHelper = new PersonServiceHelper();
    }

    @Test
    public void testDeletePerson(){
        personServiceHelper.deletePerson(5);
    }

}
