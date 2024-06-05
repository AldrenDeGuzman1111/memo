package com.aldren.memo.model.converter;

import org.springframework.stereotype.Component;

import com.aldren.memo.model.dto.MemoDTO;
import com.aldren.memo.model.entity.MemoEntity;
import com.aldren.memo.model.request.MemoRequest;

@Component
public final class MemoConverter {

	public MemoDTO toDTO(MemoEntity memo) {
		if(null == memo) {
			return null;
		} else {
			return MemoDTO.builder()
					.id(memo.getId())
					.title(memo.getTitle())
					.note(memo.getNote())
					.createdBy(memo.getCreatedBy()).build();
		}
	}
	
	public MemoEntity toEntity(MemoRequest req) {
		if(null == req) {
			return null;
		} else {
			return MemoEntity.builder()
					.id(req.getId())
					.title(req.getTitle())
					.note(req.getNote())
					.createdBy(req.getCreatedBy()).build();
		}
	}
}
