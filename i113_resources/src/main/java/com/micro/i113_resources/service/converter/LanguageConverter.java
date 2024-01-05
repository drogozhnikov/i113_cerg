package com.micro.i113_resources.service.converter;

import com.micro.i113_resources.model.dto.LanguageDto;
import com.micro.i113_resources.model.entity.LanguageEntity;

import java.util.List;
import java.util.stream.Collectors;

public class LanguageConverter {

    public List<LanguageDto> convertEntitiesToDto(List<LanguageEntity> entitiesList) {
        return entitiesList.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public List<LanguageEntity> convertDtoToEntities(List<LanguageDto> dtoList) {
        return dtoList.stream()
                .map(this::convertDtoToEntity)
                .collect(Collectors.toList());
    }

    public LanguageDto convertEntityToDto(LanguageEntity inputEntity) {
        return LanguageDto.builder()
                .id(inputEntity.getId())
                .param(inputEntity.getParam())
                .type(inputEntity.getType())
                .eng(inputEntity.getEng())
                .rus(inputEntity.getRus())
                .build();
    }

    public LanguageEntity convertDtoToEntity(LanguageDto inputDto) {
        return LanguageEntity.builder()
                .param(inputDto.getParam())
                .type(inputDto.getType())
                .eng(inputDto.getEng())
                .rus(inputDto.getRus())
                .build();
    }
}
