package com.bnta.chocolate.repositories;

import com.bnta.chocolate.models.CocoaOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocoaOrderRepository extends JpaRepository<CocoaOrder, Long> {
}
