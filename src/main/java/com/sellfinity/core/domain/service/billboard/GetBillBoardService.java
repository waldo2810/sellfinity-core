package com.sellfinity.core.domain.service.billboard;

import com.sellfinity.core.domain.entity.Billboard;
import java.util.List;

public interface GetBillBoardService {

  List<Billboard> findAllBillBoards();

  Billboard findBillBoardById(Long id);

  List<Billboard> findAllBillboardsByStoreId(Long storeId);
}
