package com.cos731.bellisimo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import junit.framework.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BellisimoApplicationTests extends TestCase {

	protected int value1, value2;

	// assigning the values
	protected void setUp(){
		value1 = 3;
		value2 = 3;
	}

	// test method to add two values
	public void testAdd(){
		double result = value1 + value2;
		assertTrue(result == 6);
	}

}
