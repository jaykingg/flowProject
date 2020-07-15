package com.flow.project.Extensions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Service
public class ExtensionServiceImpl implements ExtensionService {

    @Autowired
    ExtensionBaseRepository extensionBaseRepository;

    @Override
    public ResponseEntity getExtensions() {
        List<ExtensionBase> extensionList = extensionBaseRepository.findAll();
        if(extensionList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        /* Self-Descriptive message(Docs-Link), HATEOAS */
        ExtensionBaseDto extensionBaseDto = ExtensionBaseDto.builder()
                .extensions(extensionList)
                .build();

        ExtensionResource extensionResource = new ExtensionResource(extensionBaseDto);
        extensionResource.add(linkTo(ExtensionController.class).slash("ext_select").withSelfRel());
        extensionResource.add(new Link("README.md").withRel("profile"));
        return ResponseEntity.ok(extensionResource);
    }

    @Transactional
    @Override
    public ResponseEntity updateExtensions(ExtensionBaseDto extensionBaseDto) {
        List<ExtensionBase> extensionList = extensionBaseDto.getExtensions();
        if(extensionList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        // 리스트를 다 돌면서 해당것이 있다면 상태값에 맞게 바꿔주고 저장
        // 없다면 true로 해놓고 저장
        for(int idx=0;idx<extensionList.size();idx++) {
            Optional<ExtensionBase> extensionBaseOptionalBase = extensionBaseRepository.findById(extensionList.get(idx).getExtensionName());
            if(extensionBaseOptionalBase.isEmpty()) {
                ExtensionBase newExtensionBase = ExtensionBase.builder()
                        .extensionName(extensionList.get(idx).getExtensionName().toLowerCase())
                        .useThis(true)
                        .build();
                extensionBaseRepository.save(newExtensionBase);
            }
            else {
                ExtensionBase extensionBase = extensionBaseOptionalBase.get();
                extensionBase.setUseThis(extensionList.get(idx).isUseThis());
                extensionBaseRepository.save(extensionBase);
            }
        }

        List<ExtensionBase> extensionResponseList = extensionBaseRepository.findAll();
        /* Self-Descriptive message(Docs-Link), HATEOAS */
        ExtensionBaseDto extensionBaseResponseDto = ExtensionBaseDto.builder()
                .extensions(extensionResponseList)
                .build();

        ExtensionResource extensionResource = new ExtensionResource(extensionBaseResponseDto);
        extensionResource.add(linkTo(ExtensionController.class).slash("ext_update").withSelfRel());
        extensionResource.add(new Link("README.md").withRel("profile"));
        return ResponseEntity.ok(extensionResource);

    }
}
