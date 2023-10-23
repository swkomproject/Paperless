package com.paperless.services.mapper;

import org.openapitools.jackson.nullable.JsonNullable;

public interface BaseMapper<EN, DTO> {
    DTO entityToDto(EN entity);

    EN dtoToEntity(DTO dto);

    default String map(JsonNullable<String> value) {

        if(value == null || !value.isPresent()) {
            return null;
        }

        return value.get();
    }

    default JsonNullable<String> map(String value) {
        return JsonNullable.of(value);
    }
}
