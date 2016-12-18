package com.bp.springboot.samples;

import com.bp.springboot.samples.controller.ShipwreckController;
import com.bp.springboot.samples.model.Shipwreck;
import com.bp.springboot.samples.repository.ShipwreckRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * Created by behzad.pirvali on 11/20/16.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ShipwreckControllerTest {
    @Mock
    private ShipwreckRepository dao;

    @InjectMocks
    private ShipwreckController restSvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetById() throws Exception {
        Shipwreck sw = new Shipwreck();
        sw.setId(123L);
        when(dao.findOne(123L)).thenReturn(sw);

        Shipwreck sw2 = restSvc.get(123L);
        Mockito.verify(dao, times(1)).findOne(123L);
        Assert.assertEquals(123L,sw2.getId().longValue());
    }


}
