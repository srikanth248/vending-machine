package com.design.system.vendingmachine.controller;

import com.design.system.vendingmachine.exception.RackException;
import com.design.system.vendingmachine.exception.VendingMachineException;
import com.design.system.vendingmachine.model.LoadRackResult;
import com.design.system.vendingmachine.model.LoadRequest;
import com.design.system.vendingmachine.service.RackService;
import com.design.system.vendingmachine.service.VendingMachineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendingMachineAdminController {

    private RackService rackService;
    private VendingMachineService vendingMachineService;

    public VendingMachineAdminController(RackService rackService, VendingMachineService vendingMachineService) {
        this.rackService = rackService;
        this.vendingMachineService = vendingMachineService;
    }

    @PostMapping("/load")
    public String loadVendingMachine(@RequestBody LoadRequest loadRequest) {
        LoadRackResult loadRackResult = rackService.loadRack(loadRequest.getMachineId(), loadRequest.getRackId(), loadRequest.getProductCode(), loadRequest.getNumProduct());
        if(loadRackResult.getCurrentProductCode().equals(loadRackResult.getPreviousProductCode())) {
            return "Loaded "+loadRequest.getNumProduct() + " new items of "+loadRequest.getProductCode() +". Total: "+loadRackResult.getCurrentProductCount();
        }
        if(loadRackResult.getPreviousProductCode() == null) {
            return "Loaded "+ loadRackResult.getCurrentProductCount()+" items of product "+loadRackResult.getCurrentProductCode();
        }
        return "Unloaded "+loadRackResult.getPreviousProductCount() + " items of "+ loadRackResult.getPreviousProductCode()+ ". Loaded "+ loadRackResult.getCurrentProductCount()+" of product "+loadRackResult.getCurrentProductCode();
    }

    @GetMapping("/cash")
    public double getTotalCash(String machineId) {
        try {
            return vendingMachineService.getTotalCash(machineId);
        } catch (VendingMachineException e) {
            return 0;
        }
    }
}
