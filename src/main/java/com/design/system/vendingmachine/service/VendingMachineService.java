package com.design.system.vendingmachine.service;

import com.design.system.vendingmachine.exception.VendingMachineException;
import com.design.system.vendingmachine.model.VendingMachine;
import com.design.system.vendingmachine.repo.VendingMachineRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendingMachineService {

    private VendingMachineRepo vendingMachineRepo;

    public VendingMachineService(VendingMachineRepo vendingMachineRepo) {
        this.vendingMachineRepo = vendingMachineRepo;
    }

    public VendingMachine saveRackRequested(String machineId, String rackId) throws VendingMachineException {
        Optional<VendingMachine> optionalVendingMachine = vendingMachineRepo.findById(machineId);
        if(!optionalVendingMachine.isPresent()) {
            throw new VendingMachineException("Vending Machine not found in the system. Please try later.");
        }
        VendingMachine vendingMachine = optionalVendingMachine.get();
        vendingMachine.setRackRequested(rackId);
        return vendingMachineRepo.save(vendingMachine);
    }

    public VendingMachine savePaymentAmount(String machineId, double paymentAmount) throws VendingMachineException {
        Optional<VendingMachine> optionalVendingMachine = vendingMachineRepo.findById(machineId);
        if(!optionalVendingMachine.isPresent()) {
            throw new VendingMachineException("Vending Machine not found in the system. Please try later.");
        }
        VendingMachine vendingMachine = optionalVendingMachine.get();
        vendingMachine.setSessionAmount(vendingMachine.getSessionAmount() + paymentAmount);
        return vendingMachineRepo.save(vendingMachine);
    }

    public double getTotalCash(String machineId) throws VendingMachineException {
        Optional<VendingMachine> optionalVendingMachine = vendingMachineRepo.findById(machineId);
        if(!optionalVendingMachine.isPresent()) {
            throw new VendingMachineException("Vending Machine not found in the system. Please try later.");
        }
        return optionalVendingMachine.get().getTotalCash();
    }

    public void saveSuccessfulTransaction(VendingMachine vendingMachine, double productPrice) {
        vendingMachine.setSessionAmount(0);
        vendingMachine.setRackRequested(null);
        vendingMachine.setTotalCash(vendingMachine.getTotalCash() + productPrice);
        vendingMachineRepo.save(vendingMachine);
    }
}
