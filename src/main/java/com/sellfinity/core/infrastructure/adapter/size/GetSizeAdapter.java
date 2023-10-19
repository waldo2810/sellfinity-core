package com.sellfinity.core.infrastructure.adapter.size;

import com.sellfinity.core.domain.entity.ProductSize;
import com.sellfinity.core.domain.entity.Size;
import com.sellfinity.core.domain.service.size.GetSizeService;
import com.sellfinity.core.infrastructure.adapter.product_size.GetProductSizeAdapter;
import com.sellfinity.core.infrastructure.repository.size.SizeRepository;
import com.sellfinity.core.infrastructure.repository.size.SizeRepositoryMapper;
import com.sellfinity.core.shared.exception.notfound.size.SizeNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetSizeAdapter implements GetSizeService {

  private final SizeRepository sizeRepository;
  private final SizeRepositoryMapper sizeRepositoryMapper;
  private final GetProductSizeAdapter getProductSizeAdapter;

  @Override
  public List<Size> findAllSizes() {
    return sizeRepositoryMapper.toEntity(sizeRepository.findAll());
  }

  @Override
  public Size findSizeById(Long id) {
    return sizeRepositoryMapper.toEntity(sizeRepository.findById(id)
        .orElseThrow(() -> new SizeNotFoundException(String.valueOf(id))));
  }

  @Override
  public List<Size> findAllSizesByStoreId(Long storeId) {
    return sizeRepositoryMapper.toEntity(sizeRepository.findByStore_Id(storeId));
  }

  @Override
  public List<Size> findAllSizesByProductId(Long id) {
    List<ProductSize> psList = getProductSizeAdapter.findAllProductSizesByProduct(id);
    return psList.stream().map(ProductSize::getSize).collect(Collectors.toList());
  }
}
