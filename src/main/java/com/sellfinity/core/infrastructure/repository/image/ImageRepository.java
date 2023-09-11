package com.sellfinity.core.infrastructure.repository.image;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageDto, Long> {

  List<ImageDto> findAllByProduct_Id(Long productId);

  void deleteAllByProduct_id(Long productId);
}