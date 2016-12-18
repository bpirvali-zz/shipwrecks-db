package com.bp.springboot.samples.controller;

import com.bp.springboot.samples.model.Shipwreck;
import com.bp.springboot.samples.repository.ShipwreckRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by behzad.pirvali on 11/18/16.
 */
@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {
    @Autowired
    private ShipwreckRepository repository;

    @RequestMapping( value = "shipwrecks", method = RequestMethod.GET)
    public List<Shipwreck> list() {
        return repository.findAll();
    }

    @RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
    public Shipwreck create(@RequestBody Shipwreck shipwreck) {
        return repository.saveAndFlush(shipwreck);
    }

    @RequestMapping(value="shipwrecks/{id}", method = RequestMethod.GET)
    public Shipwreck get(@PathVariable long id) {
        return repository.findOne(id);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
    public Shipwreck update(@PathVariable long id, @RequestBody Shipwreck shipwreck) {
        Shipwreck cur = repository.findOne(id);
        BeanUtils.copyProperties(shipwreck, cur);
        return repository.saveAndFlush(cur);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
    public Shipwreck delete(@PathVariable long id) {
        Shipwreck cur = repository.findOne(id);
        repository.delete(cur);
        return cur;
    }
}
