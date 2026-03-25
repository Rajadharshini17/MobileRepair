package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.model.RepairShop;

public interface RepairShopRepository extends JpaRepository<RepairShop, Integer> {
}
