package com.xebia.shoppingcart.shippingservice.repository;

import com.xebia.shoppingcart.shippingservice.representation.ShippingRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<ShippingRequest,Integer> {

}
