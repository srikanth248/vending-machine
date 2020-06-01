package com.design.system.vendingmachine.service;

import com.design.system.vendingmachine.exception.RackException;
import com.design.system.vendingmachine.model.LoadRackResult;
import com.design.system.vendingmachine.model.Rack;
import com.design.system.vendingmachine.repo.RackRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RackService {

    private RackRepo rackRepo;

    public RackService(RackRepo rackRepo) {
        this.rackRepo = rackRepo;
    }

    public Rack getRack(String machineId, String rackId) throws RackException {
        Optional<Rack> optionalRack = rackRepo.findByMachineIdAndRackId(machineId, rackId);
        if(optionalRack.isPresent()) {
            return optionalRack.get();
        }
        throw new RackException("Unknown rack.");
    }

    public LoadRackResult loadRack(String machineId, String rackId, String productCode, int numProduct) {
        Optional<Rack> optionalRack = rackRepo.findByMachineIdAndRackId(machineId, rackId);
        LoadRackResult loadRackResult = new LoadRackResult();
        Rack previousRack = null;
        if(optionalRack.isPresent()) {
            previousRack = optionalRack.get();
            loadRackResult.setPreviousProductCode(previousRack.getProductCode());
            loadRackResult.setPreviousProductCount(previousRack.getNumProducts());
        }
        if(previousRack!= null && productCode.equals(previousRack.getProductCode())) {
            numProduct = numProduct + previousRack.getNumProducts();
        }
        loadRackResult.setCurrentProductCode(productCode);
        loadRackResult.setCurrentProductCount(numProduct);
        rackRepo.save(new Rack(machineId, rackId, productCode, numProduct));
        return loadRackResult;
    }

    public void updateRack(Rack rack) {
        rack.setNumProducts(rack.getNumProducts() - 1);
        rackRepo.save(rack);
    }
}
