package com.geekbrains.geekmarketwinter.aspect;
import com.geekbrains.geekmarketwinter.entites.Product;
import com.geekbrains.geekmarketwinter.utils.ShoppingCart;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSession;


@Configuration
@Aspect
public class ShoppingCartAspect {

    @AfterReturning(
            pointcut = "execution(public * com.geekbrains.geekmarketwinter.services.ShoppingCartService.getCurrentCart(..))",
            returning = "result")
    public void afterGetTotalCoast(ShoppingCart result) {
         System.out.println("Стоимость товаров в корзине : "  + result.getTotalCost());
    }

    @Before("execution(public * com.geekbrains.geekmarketwinter.services.ShoppingCartService.addToCart(..)) && args(*, product, ..)")
    public void beforeAddToCart(Product product) {
        System.out.println("Добавляем " + product.getTitle());
    }

    @Before("execution(public * com.geekbrains.geekmarketwinter.services.ShoppingCartService.removeFromCart(..)) && args(*, product, ..)")
    public void beforeRemoveFromCart(Product product) {
        System.out.println("Удалили " + product.getTitle());
    }


}
