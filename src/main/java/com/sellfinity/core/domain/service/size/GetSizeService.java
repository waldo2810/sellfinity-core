package com.sellfinity.core.domain.service.size;

import com.sellfinity.core.domain.entity.Size;
import java.util.List;

public interface GetSizeService {

  List<Size> findAllSizes();

  Size findSizeById(Long id);

  List<Size> findAllSizesByStoreId(Long storeId);
}
