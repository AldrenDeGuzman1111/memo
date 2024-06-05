package com.aldren.memo.model.reponse;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class MemoDeleteResponse implements Serializable{

	private Long deletedMemoCount;
}
