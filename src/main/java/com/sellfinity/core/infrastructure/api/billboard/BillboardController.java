package com.sellfinity.core.infrastructure.api.billboard;

import com.sellfinity.core.application.billboard.DeleteBillboardApplication;
import com.sellfinity.core.application.billboard.GetBillboardApplication;
import com.sellfinity.core.application.billboard.SaveBillboardApplication;
import com.sellfinity.core.application.billboard.UpdateBillboardApplication;
import com.sellfinity.core.domain.entity.Billboard;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/billboards")
public class BillboardController {

  private final SaveBillboardApplication saveBillboardApplication;
  private final GetBillboardApplication getBillboardApplication;
  private final DeleteBillboardApplication deleteBillboardApplication;
  private final UpdateBillboardApplication updateBillboardApplication;
  private final BillboardRequestMapper billboardRequestMapper;
  private final BillboardResponseMapper billBoardResponseMapper;

  @PostMapping
  public ResponseEntity<BillBoardResponse> saveBillBoard(
      @Valid @RequestBody BillboardRequest billBoardRequest) {
    return ResponseEntity.ok(billBoardResponseMapper.toDto(
        saveBillboardApplication.saveBillboard(billboardRequestMapper.toEntity(billBoardRequest))));
  }

  @GetMapping
  public ResponseEntity<List<BillBoardResponse>> findAllBillboards() {
    return ResponseEntity.ok(
        billBoardResponseMapper.toDto(getBillboardApplication.findAllBillboards()));
  }

  @GetMapping("/{id}")
  public ResponseEntity<BillBoardResponse> findBillBoardById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(
        billBoardResponseMapper.toDto(getBillboardApplication.findBillBoardById(id)));
  }

  @DeleteMapping("/delete/{id}")
  public void deleteBillboard(@PathVariable("id") Long id) {
    deleteBillboardApplication.deleteBillboard(id);
  }

  @PutMapping("/update/{id}")
  public void updateCategory(@PathVariable("id") Long id,
      @RequestBody BillboardRequest billboardRequest) {
    Billboard billboard = billboardRequestMapper.toEntity(billboardRequest);
    updateBillboardApplication.updateBillboard(id, billboard);
  }
}