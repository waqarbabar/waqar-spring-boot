package com.waqar.waqarspringboot.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waqar.waqarspringboot.entity.CompanyRevenue;

@Repository
@Qualifier(value = "CompanyRevenueRepository")
public interface CompanyRevenueRepository extends JpaRepository<CompanyRevenue, Long> {

}
