package com.aldren.memo.model.request;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemoRequest implements Serializable{

	private Long id;
	private String title;
	private String note;
	private String createdBy;
}
