package com.aldren.memo.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemoDTO implements Serializable {
	
	private Long id;
	private String title;
	private String note;
	private String createdBy;

}
