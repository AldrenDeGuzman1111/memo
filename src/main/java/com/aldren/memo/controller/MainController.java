package com.aldren.memo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aldren.memo.service.MemoService;
import com.aldren.memo.model.dto.MemoDTO;
import com.aldren.memo.model.reponse.MemoDeleteResponse;
import com.aldren.memo.model.reponse.MemoListResponse;
import com.aldren.memo.model.request.MemoRequest;

@RestController
public final class MainController {

	private final MemoService memoSvc;

	public MainController(MemoService memoSvc) {
		this.memoSvc = memoSvc;
	}
	
	@GetMapping("/notes/{id}")
	public ResponseEntity<MemoListResponse> getMemo(@PathVariable("id") Long id) {
		MemoListResponse resp = memoSvc.getMemo(id);
		if(CollectionUtils.isEmpty(resp.getMemos())) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
	@GetMapping("/notes")
	public  ResponseEntity<MemoListResponse> getAllMemos(){
		MemoListResponse resp = memoSvc.getAllMemo();
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
    @PostMapping("/notes")
    public ResponseEntity<MemoDTO> createMemo(@RequestBody MemoRequest request) {
        return new ResponseEntity<>(memoSvc.createMemo(request), HttpStatus.CREATED);
    }
    
    @PutMapping("/notes/{id}")
    public ResponseEntity<MemoDTO> updateMemo(@PathVariable("id") Long id, @RequestBody MemoRequest request) {
        MemoDTO memoDto = memoSvc.updateMemo(id, request);
        if (null == memoDto) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(memoDto, HttpStatus.OK);
        }
    }
    
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<MemoDeleteResponse> deleteMemo(@PathVariable("id") Long id) {
        MemoDeleteResponse response = memoSvc.deleteMemo(id);
        if (0L == response.getDeletedMemoCount()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @DeleteMapping("/notes")
    public ResponseEntity<MemoDeleteResponse> deleteAllMemo() {
        MemoDeleteResponse response = memoSvc.deleteAllMemo();
        if (0L == response.getDeletedMemoCount()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
