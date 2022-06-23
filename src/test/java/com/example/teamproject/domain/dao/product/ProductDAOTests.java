package com.example.teamproject.domain.dao.product;

import com.example.teamproject.domain.dao.product.ProductDAO;
import com.example.teamproject.domain.dao.user.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductDAOTests {
    @Autowired
    private ProductDAO productDAO;
}
