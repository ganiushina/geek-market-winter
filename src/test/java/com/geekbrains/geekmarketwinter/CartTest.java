package com.geekbrains.geekmarketwinter;

import com.geekbrains.geekmarketwinter.entites.Product;
import com.geekbrains.geekmarketwinter.repositories.ProductRepository;
import com.geekbrains.geekmarketwinter.repositories.UserRepository;
import com.geekbrains.geekmarketwinter.services.ProductService;
import com.geekbrains.geekmarketwinter.services.ShoppingCartService;
import com.geekbrains.geekmarketwinter.utils.ShoppingCart;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpSession;

import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTest {

    ShoppingCart cart;
    Product productBeer;
    Product productWine;

//    @Autowired
//    ShoppingCartService shoppingCartService;
//
//    @MockBean
//    ProductService productService;
//
//    @MockBean
//    private ProductRepository productRepository;

    @Before
    public void init(){
        cart = new ShoppingCart();
        productBeer = new Product();
        productWine = new Product();
        productBeer.setId((long) 1);
        productBeer.setTitle("Beer");
        productBeer.setPrice(100);

        productWine.setId((long) 2);
        productWine.setTitle("Wine");
        productWine.setPrice(200);

//
//        Mockito.verify(productService, Mockito.times(1)).saveProduct(product);
    }

    @Test
    public void addCart(){
        cart.add(productBeer);
        Assert.assertEquals(java.util.Optional.of(100.0), java.util.Optional.ofNullable(cart.getItems().get(0).getItemPrice()));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void delCart(){
        cart.add(productWine);
        cart.remove(cart.getItems().get(0).getProduct());
        Assert.assertNull(cart.getItems().get(0).getItemPrice());
    }

}
