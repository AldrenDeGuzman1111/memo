package com.aldren.memo.model.hateoas;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

public final class MemoControllerRepresentationModel extends RepresentationModel<MemoControllerRepresentationModel> {

	public MemoControllerRepresentationModel(Link initialLink) {
		super(initialLink);
	}
}
