package com.flow.project.Extensions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = MediaTypes.HAL_JSON_VALUE)
public class ExtensionController {

    @Autowired
    ExtensionServiceImpl extensionServiceImpl;

    @GetMapping("/ext_select")
    public ResponseEntity getExtensions() {
        return extensionServiceImpl.getExtensions();
    }

    @PutMapping("/ext_update")
    public ResponseEntity updateExtensions(@RequestBody ExtensionBaseDto extensionBaseDto) {
        return extensionServiceImpl.updateExtensions(extensionBaseDto);
    }

}
