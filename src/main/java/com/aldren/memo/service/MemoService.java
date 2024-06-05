package com.aldren.memo.service;

import com.aldren.memo.model.dto.MemoDTO;
import com.aldren.memo.model.reponse.MemoDeleteResponse;
import com.aldren.memo.model.reponse.MemoListResponse;
import com.aldren.memo.model.request.MemoRequest;

public interface MemoService {
 
	MemoListResponse getMemo(Long id);
	MemoListResponse getAllMemo();
	MemoDTO createMemo(MemoRequest req);
	MemoDTO updateMemo(Long id,MemoRequest req);
	MemoDeleteResponse deleteMemo(Long id);
	MemoDeleteResponse deleteAllMemo();
}
