package com.edstruments.product.repository;

import com.edstruments.product.entity.ApiReqResp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiReqRespRepository extends JpaRepository<ApiReqResp, Long> {
}
