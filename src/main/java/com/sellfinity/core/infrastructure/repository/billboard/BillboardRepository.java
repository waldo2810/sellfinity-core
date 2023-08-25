package com.sellfinity.core.infrastructure.repository.billboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillboardRepository extends JpaRepository<BillboardDto, Long> {

}
