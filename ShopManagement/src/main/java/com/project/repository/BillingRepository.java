package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Billing;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {
}