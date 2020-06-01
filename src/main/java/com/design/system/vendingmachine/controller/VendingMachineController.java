package com.design.system.vendingmachine.controller;

import com.design.system.vendingmachine.exception.ProductException;
import com.design.system.vendingmachine.exception.RackException;
import com.design.system.vendingmachine.exception.VendingMachineException;
import com.design.system.vendingmachine.model.PaymentRequest;
import com.design.system.vendingmachine.model.ProductRequest;
import com.design.system.vendingmachine.model.Rack;
import com.design.system.vendingmachine.model.VendingMachine;
import com.design.system.vendingmachine.service.ProductService;
import com.design.system.vendingmachine.service.RackService;
import com.design.system.vendingmachine.service.VendingMachineService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendingMachineController {

    private VendingMachineService vendingMachineService;
    private RackService rackService;
    private ProductService productService;

    public VendingMachineController(VendingMachineService vendingMachineService, RackService rackService, ProductService productService) {
        this.vendingMachineService = vendingMachineService;
        this.rackService = rackService;
        this.productService = productService;
    }

    @PostMapping("/buy")
    public String buy(@RequestBody ProductRequest productRequest) {
        try {
            Rack rack = rackService.getRack(productRequest.getMachineId(), productRequest.getRackId());
            if(rack.getNumProducts() == 0) {
                return "Selected item out of stock. Select a different item.";
            }
            VendingMachine vendingMachine = vendingMachineService.saveRackRequested(productRequest.getMachineId(), productRequest.getRackId());
            double productPrice = productService.getProductPrice(rack.getProductCode());
            if(vendingMachine.getSessionAmount() < productPrice) {
                return "Need " + (productPrice - vendingMachine.getSessionAmount()) + " more";
            }
            double change = vendingMachine.getSessionAmount() - productPrice;
            vendingMachineService.saveSuccessfulTransaction(vendingMachine, productPrice);
            rackService.updateRack(rack);
            if(change > 0) {
                return "Please take your item. Change dispensed: " + change;
            }
            return "Please take your item.";
        } catch (VendingMachineException e) {
            return e.getMessage();
        } catch (RackException e) {
            return "Please select a valid item.";
        } catch (ProductException e) {
            return "Product details not found. Select a different item.";
        }
    }

    @PostMapping("/pay")
    public String pay(@RequestBody PaymentRequest paymentRequest) {
        try {
            VendingMachine vendingMachine = vendingMachineService.savePaymentAmount(paymentRequest.getMachineId(), paymentRequest.getPaymentAmount());
            String rackId = vendingMachine.getRackRequested();
            if(rackId == null) {
                throw new RackException("No rack selected.");
            }
            Rack rack = rackService.getRack(paymentRequest.getMachineId(), rackId);
            if(rack.getNumProducts() == 0) {
                return "Selected item out of stock. Select a different item.";
            }
            double productPrice = productService.getProductPrice(rack.getProductCode());
            if(vendingMachine.getSessionAmount() < productPrice) {
                return "Need " + (productPrice - vendingMachine.getSessionAmount()) + " more";
            }
            double change = vendingMachine.getSessionAmount() - productPrice;
            vendingMachineService.saveSuccessfulTransaction(vendingMachine, productPrice);
            rackService.updateRack(rack);
            if(change > 0) {
                return "Please take your item. Change dispensed: " + change;
            }
            return "Please take your item";
        } catch (RackException e) {
            return "Please select an item";
        } catch (VendingMachineException e) {
            return e.getMessage();
        } catch (ProductException e) {
            return "Product details not found. Select a different item.";
        }
    }
}
