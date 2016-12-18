package com.bp.springboot.samples.repository;

import com.bp.springboot.samples.model.Shipwreck;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by behzad.pirvali on 11/20/16.
 */

public interface ShipwreckRepository extends JpaRepository<Shipwreck,Long> {
}
