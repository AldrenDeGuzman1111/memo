package com.aldren.memo.model.reponse;

import java.io.Serializable;
import java.util.List;

import com.aldren.memo.model.dto.MemoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class MemoListResponse implements Serializable {

	private List<MemoDTO> memos;
}
