package com.aldren.memo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aldren.memo.model.hateoas.MemoControllerRepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/")
public final class IndexController {

    @GetMapping
    public MemoControllerRepresentationModel index() {
        return new MemoControllerRepresentationModel(linkTo(MainController.class).withRel("memo"));
    }
}
