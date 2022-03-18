package com.example;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientExample {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientExample.class);

    public static int get() throws IOException {

        HttpGet request = new HttpGet("https://httpbin.org/get");
        request.addHeader("x-api-key", "ganesh-key");

        System.out.println(request.getURI());
        logger.trace("sdfsd");
        logger.debug("URI: " + request.getURI());
        logger.info("URI: " + request.getURI());

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {

            System.out.println(response.getStatusLine());

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }
            return response.getStatusLine().getStatusCode();

        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error 1034" + e.getMessage(), e);
            throw e;
        }
    }

    public static int post() throws IOException {

        HttpPost request = new HttpPost("https://httpbin.org/post");
        request.addHeader("x-api-key", "ganesh-key");

        // add request parameters or form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("username", "ganesh"));
        urlParameters.add(new BasicNameValuePair("password", "password"));

        request.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {

            System.out.println(response.getStatusLine());

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }
            return response.getStatusLine().getStatusCode();
        }
    }

    public static void main(String[] args) {

        try {
            get();
            post();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
