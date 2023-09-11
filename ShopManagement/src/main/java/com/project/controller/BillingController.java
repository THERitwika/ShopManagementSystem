package com.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Billing;
import com.project.service.BillingService;

@RestController
public class BillingController {
	@Autowired
    private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @PostMapping("/createbilling") // create the bill
    public Billing createBilling(@RequestBody @Valid Billing billing) {
        return billingService.createBilling(billing);
    }

    @GetMapping("/getbilling") // get all the bills
    public List<Billing> getAllBillingRecords() {
        return billingService.getAllBillingRecords();
    }

    @PutMapping("/updateBill/{id}") // update the existing bills
    public Billing updateBilling(@PathVariable Long id, @RequestBody Billing updatedBilling) {
        return billingService.updateBilling(id, updatedBilling);
    }

    @DeleteMapping("/deleteBill/{id}") // delete the existing bill
    public boolean deleteBilling(@PathVariable Long id) {
        return billingService.deleteBilling(id);
    }
    
    @PostMapping("/assignProduct/{pId}/toBill/{bId}")
	public void asssignProductToBill(@PathVariable("pId") Long pId, @PathVariable("bId") Long bId )
	{
		billingService.assignProductToBill(pId, bId);
	}
}


