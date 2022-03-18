package com.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GreetingServiceTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void greet1() {

        String response = GreetingService.greet("Ganesh");
        Assert.assertEquals("Hello Ganesh!", response);

    }

    @Test
    public void greet2() {

        String response = GreetingService.greet("Ganesh2");
        Assert.assertEquals("Hello Ganesh2!", response);

    }

    @Test
    public void greet3() {

        String response = GreetingService.greet("Ganesh3");
        Assert.assertEquals("Hello Ganesh3!", response);

    }
}