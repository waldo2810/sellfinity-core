package com.sellfinity.core.shared.exception.mapper;

import java.util.List;

public interface EntityToDto<E, O> {

  O toDto(E entity);

  E toEntity(O dto);

  List<O> toDto(List<E> entity);

  List<E> toEntity(List<O> dto);

}
