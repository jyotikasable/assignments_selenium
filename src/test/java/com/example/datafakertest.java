package com.example;

import org.jeasy.random.EasyRandom;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class datafakertest {
	private EasyRandom easyRandom;

	@BeforeClass
	public void setUpClass() {
		// Runs once before all tests in this class
		easyRandom = new EasyRandom();
	}

	@BeforeMethod
	public void setUpMethod() {
		// Runs before each test method
	}

	@AfterMethod
	public void tearDownMethod() {
		// Runs after each test method
	}

	@AfterClass
	public void tearDownClass() {
		// Runs once after all tests in this class
		easyRandom = null;
	}

	static class Person {
		public String name;
		public int age;
		public boolean active;
	}

	@Test
	public void testRandomPersonNotNull() {
		Person person = easyRandom.nextObject(Person.class);
		Assert.assertNotNull(person, "Person object should not be null");
		Assert.assertTrue(person.name != null && !person.name.isEmpty(), "Person name should not be null or empty");
		Assert.assertTrue(person.age >= 0, "Person age should be non-negative");
		Assert.assertTrue(person.active || !person.active, "Person active should be boolean");
	}

	@Test
	public void testRandomPersonNameNotNull() {
		Person person = easyRandom.nextObject(Person.class);
		Assert.assertNotNull(person.name, "Person name should not be null");
		Assert.assertTrue(!person.name.isEmpty(), "Person name should not be empty");
	}

	@Test
	public void testRandomPersonAgeRange() {
		Person person = easyRandom.nextObject(Person.class);
		Assert.assertTrue(person.age >= 0, "Person age should be non-negative");
		Assert.assertTrue(person.age < 150, "Person age should be less than 150");
	}

	@Test
	public void testRandomPersonActiveField() {
		Person person = easyRandom.nextObject(Person.class);
		Assert.assertTrue(person.active == true || person.active == false, "Person active should be boolean");
	}

	@Test
	public void testMultiplePersons() {
		Person p1 = easyRandom.nextObject(Person.class);
		Person p2 = easyRandom.nextObject(Person.class);
		Assert.assertNotNull(p1.name, "First person name should not be null");
		Assert.assertNotNull(p2.name, "Second person name should not be null");
		Assert.assertNotEquals(p1.name, p2.name, "Names should be different for two random persons");
		Assert.assertNotEquals(p1.age, p2.age, "Ages should be different for two random persons");
	}
}
