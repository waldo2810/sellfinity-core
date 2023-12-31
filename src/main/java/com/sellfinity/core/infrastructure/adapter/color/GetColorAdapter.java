package com.sellfinity.core.infrastructure.adapter.color;

import com.sellfinity.core.domain.entity.Color;
import com.sellfinity.core.domain.entity.ProductColor;
import com.sellfinity.core.domain.service.color.GetColorService;
import com.sellfinity.core.infrastructure.adapter.product_color.GetProductColorAdapter;
import com.sellfinity.core.infrastructure.repository.color.ColorRepository;
import com.sellfinity.core.infrastructure.repository.color.ColorRepositoryMapper;
import com.sellfinity.core.shared.exception.notfound.color.ColorNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetColorAdapter implements GetColorService {

  private final ColorRepository colorRepository;
  private final ColorRepositoryMapper colorRepositoryMapper;
  private final GetProductColorAdapter getProductColorAdapter;

  @Override
  public List<Color> findAllColors() {
    return colorRepositoryMapper.toEntity(colorRepository.findAll());
  }

  @Override
  public Color findColorById(Long id) {
    return colorRepositoryMapper.toEntity(colorRepository.findById(id)
        .orElseThrow(() -> new ColorNotFoundException(String.valueOf(id))));
  }

  @Override
  public List<Color> findAllColorsByStoreId(Long storeId) {
    return colorRepositoryMapper.toEntity(colorRepository.findByStore_Id(storeId));
  }

  @Override
  public List<Color> findAllByProductId(Long id) {
    List<ProductColor> pcList = getProductColorAdapter.findAllColorsByProductId(id);
    return pcList.stream().map(ProductColor::getColor).collect(Collectors.toList());
  }
}
