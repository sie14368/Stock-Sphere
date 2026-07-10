package com.hpaul.stock_sphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hpaul.stock_sphere.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}