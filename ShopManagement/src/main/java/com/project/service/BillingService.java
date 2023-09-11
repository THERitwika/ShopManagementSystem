package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Billing;
import com.project.entity.Product;
import com.project.repository.BillingRepository;
import com.project.repository.ProductRepository;

@Service
public class BillingService {
	@Autowired
	
    private final BillingRepository billingRepository;
	@Autowired
	ProductRepository productRepository;

    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    public Billing createBilling(Billing billing) {
        return billingRepository.save(billing);
    }

    public List<Billing> getAllBillingRecords() {
        return billingRepository.findAll();
    }

    public Billing updateBilling(Long id, Billing updatedBilling) {
        Billing existingBilling = billingRepository.findById(id).orElse(null);
        if (existingBilling != null) {
            existingBilling.setCustomerName(updatedBilling.getCustomerName());
            existingBilling.setBillingAddress(updatedBilling.getBillingAddress());
            existingBilling.setTotalCost(updatedBilling.getTotalCost());
            existingBilling.setPaymentMethod(updatedBilling.getPaymentMethod());

            
            return billingRepository.save(existingBilling);
        }
        return null; 
    }

    public boolean deleteBilling(Long id) {
        Billing existingBilling = billingRepository.findById(id).orElse(null);
        if (existingBilling != null) {
            billingRepository.delete(existingBilling);
            return true;
        }
        return false; 
    }
    
    public void assignProductToBill(Long pId ,Long bId){
		
		Product product= productRepository.findById(pId).get();
		Billing billing= billingRepository.findById(bId).get();
		
		product.setBilling(billing);
	
		productRepository.save(product);
		billingRepository.save(billing);	
	}
    
}

