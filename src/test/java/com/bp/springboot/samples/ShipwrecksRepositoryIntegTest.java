package com.bp.springboot.samples;

import com.bp.springboot.samples.model.Shipwreck;
import com.bp.springboot.samples.repository.ShipwreckRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShipwrecksRepositoryIntegTest {
    @Autowired
    private ShipwreckRepository dao;

    @Test
    public void testFindAll() {
        List<Shipwreck> wrecks = dao.findAll();
        Assert.assertTrue(wrecks.size()>=0);
    }
}
