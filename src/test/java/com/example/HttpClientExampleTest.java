package com.example;

import com.example.HttpClientExample;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class HttpClientExampleTest {

    @Test
    public void get() throws IOException {
        Assert.assertEquals(200, HttpClientExample.get());
    }

    @Test
    public void post() {
    }
}