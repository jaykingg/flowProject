package com.flow.project.Extensions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface ExtensionService {
    ResponseEntity getExtensions();
    ResponseEntity updateExtensions(@RequestBody ExtensionBaseDto extensionBaseDto);
}
