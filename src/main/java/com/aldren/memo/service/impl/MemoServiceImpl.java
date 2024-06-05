package com.aldren.memo.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aldren.memo.repo.MemoRepository;
import com.aldren.memo.service.MemoService;
import com.aldren.memo.model.converter.MemoConverter;
import com.aldren.memo.model.dto.MemoDTO;
import com.aldren.memo.model.entity.MemoEntity;
import com.aldren.memo.model.reponse.MemoDeleteResponse;
import com.aldren.memo.model.reponse.MemoListResponse;
import com.aldren.memo.model.request.MemoRequest;

@Service
public class MemoServiceImpl implements MemoService {

	private final MemoRepository repo;
	private final MemoConverter convrt;
	
	public MemoServiceImpl(MemoRepository repo,MemoConverter convrt) {
		this.repo = repo;
		this.convrt = convrt;
	}

	@Override
	public MemoListResponse getMemo(Long id) {
		final MemoListResponse memo = new MemoListResponse();
		return repo.findById(id)
				.map(entity -> MemoListResponse.builder().memos(Collections.singletonList(convrt.toDTO(entity))).build())
				.orElse(memo);
	}

	@Override
	public MemoListResponse getAllMemo() {
		final List<MemoEntity> entities = repo.findAll();
		final List<MemoDTO> converted = entities
				.stream()
				.map(convrt::toDTO)
				.collect(Collectors.toList());
		return MemoListResponse.builder().memos(converted).build();
	}

	@Override
	public MemoDTO createMemo(MemoRequest req) {
		final MemoEntity memo = repo.save(convrt.toEntity(req));
		return convrt.toDTO(memo);
	}

	@Override
	public MemoDTO updateMemo(Long id, MemoRequest req) {
		final Optional<MemoEntity> optionalMemo = repo.findById(id);
		if(optionalMemo.isEmpty()) {
			return null;
		} else {
			final MemoEntity tobeUpdated = convrt.toEntity(req);
			tobeUpdated.setId(optionalMemo.get().getId());
			final MemoEntity memo = repo.save(tobeUpdated);
			return convrt.toDTO(memo);
		}
	}

	@Override
	public MemoDeleteResponse deleteMemo(Long id) {
		 if (!repo.existsById(id)) {
			 return MemoDeleteResponse.builder().deletedMemoCount(0L).build();
		 } else {
			 repo.deleteById(id);
			 return MemoDeleteResponse.builder().deletedMemoCount(1L).build();
		 }
	}

	@Override
	public MemoDeleteResponse deleteAllMemo() {
		final long count = repo.count();
		if(count == 0) {
			return MemoDeleteResponse.builder().deletedMemoCount(0L).build();
		} else {
			repo.deleteAll();
			 return MemoDeleteResponse.builder().deletedMemoCount(count).build();
		}
	}

}
