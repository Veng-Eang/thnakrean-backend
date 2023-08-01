package com.thnakrean.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.thnakrean.backend.dto.VideoDto;
import com.thnakrean.backend.entities.Video;

@Mapper
public interface VideoMapper {
	VideoMapper INSTANCE = Mappers.getMapper(VideoMapper.class);
	VideoDto toVideoDto(Video video);
	Video toVideo(VideoDto videoDto);
}
