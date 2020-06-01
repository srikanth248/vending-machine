package com.design.system.vendingmachine.repo;

import com.design.system.vendingmachine.model.VendingMachine;
import org.springframework.data.repository.CrudRepository;

public interface VendingMachineRepo extends CrudRepository<VendingMachine, String> {
}
