package com.sellfinity.core.domain.service.color;

import com.sellfinity.core.domain.entity.Color;
import java.util.List;

public interface GetColorService {

  List<Color> findAllColors();

  Color findColorById(Long id);

  List<Color> findAllColorsByStoreId(Long storeId);

  List<Color> findAllByProductId(Long id);
}
