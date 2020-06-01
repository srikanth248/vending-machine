package com.design.system.vendingmachine.repo;

import com.design.system.vendingmachine.model.Rack;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RackRepo extends CrudRepository<Rack, Integer> {
    Optional<Rack> findByMachineIdAndRackId(String machineId, String rackId);
}
