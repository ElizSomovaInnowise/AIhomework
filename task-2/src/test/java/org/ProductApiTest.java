package org;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import org.models.Product;

import static org.junit.Assert.*;

public class ProductApiTest {

    @Test
    public void testGetProducts() {
        Response response = RestAssured.get("https://fakestoreapi.com/products");
        assertEquals(200, response.getStatusCode());

        Product[] products = response.as(Product[].class);
        for (Product product : products) {
            assertNotNull("Title should not be null", product.getTitle());
            assertFalse("Title should not be empty", product.getTitle().trim().isEmpty());
            assertTrue("Price should not be negative", product.getPrice() >= 0);
            if (product.getRating() != null) {
                assertTrue("Rating should not exceed 5", product.getRating().getRate() <= 5);
            }
        }
    }
} 