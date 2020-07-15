package com.flow.project.Extensions;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class ExtensionResource extends Resource<ExtensionBaseDto> {
    public ExtensionResource(ExtensionBaseDto content, Link... links) {
        super(content, links);
        add(linkTo(ExtensionController.class).slash("ext_select").withRel("[GET]확장자 조회"));
        add(linkTo(ExtensionController.class).slash("ext_update").withRel("[PUT]확장자 수정"));
    }
}
