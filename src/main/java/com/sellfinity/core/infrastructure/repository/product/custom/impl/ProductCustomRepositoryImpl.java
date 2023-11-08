package com.sellfinity.core.infrastructure.repository.product.custom.impl;

import com.sellfinity.core.infrastructure.api.product.FindProductRequest;
import com.sellfinity.core.infrastructure.repository.product.ProductDto;
import com.sellfinity.core.infrastructure.repository.product.custom.ProductCustomRepository;
import com.sellfinity.core.infrastructure.repository.product_category.ProductCategoryDto;
import com.sellfinity.core.infrastructure.repository.product_color.ProductColorDto;
import com.sellfinity.core.infrastructure.repository.product_size.ProductSizeDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProductCustomRepositoryImpl implements ProductCustomRepository {

  private final EntityManager em;
  private final CriteriaBuilder cb;

  public ProductCustomRepositoryImpl(EntityManager em) {
    this.em = em;
    this.cb = em.getCriteriaBuilder();
  }

  @Override
  public List<ProductDto> findAllProductsCriteria(FindProductRequest req) {
    Boolean isFeatured = req.getIsFeatured();
    Boolean isArchived = req.getIsArchived();
    Long categoryId = req.getCategoryId();
    Long storeId = req.getStoreId();
    Long colorId = req.getColorId();
    Long sizeId = req.getSizeId();

    CriteriaQuery<ProductDto> cq = cb.createQuery(ProductDto.class);
    Root<ProductDto> root = cq.from(ProductDto.class);
    List<Predicate> predicates = new ArrayList<>();
    predicates.add(cb.equal(root.get("store").get("id"), storeId));

    if (isArchived != null) {
      predicates.add(cb.isTrue(root.get("isArchived")));
      cq.where(cb.and(predicates.toArray(new Predicate[0])));
      TypedQuery<ProductDto> query = em.createQuery(cq);
      return query.getResultList();
    }

    if (categoryId != null) {
      Join<ProductDto, ProductCategoryDto> prodCatJoin = root.join("productCategories");
      predicates.add(cb.equal(prodCatJoin.get("category").get("id"), categoryId));
    }
    if (colorId != null) {
      Join<ProductDto, ProductColorDto> prodColorJoin = root.join("productColors");
      predicates.add(cb.equal(prodColorJoin.get("color").get("id"), colorId));
    }
    if (sizeId != null) {
      Join<ProductDto, ProductSizeDto> prodSizeJoin = root.join("productSizes");
      predicates.add(cb.equal(prodSizeJoin.get("size").get("id"), sizeId));
    }
    if (isFeatured != null) {
      predicates.add(cb.isTrue(root.get("isFeatured")));
    }

    predicates.add(cb.isFalse(
        root.get("isArchived")));
    cq.where(cb.and(predicates.toArray(new Predicate[0])));
    TypedQuery<ProductDto> query = em.createQuery(cq);
    return query.getResultList();
  }
}
