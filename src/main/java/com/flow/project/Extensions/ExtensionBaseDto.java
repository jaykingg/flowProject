package com.flow.project.Extensions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExtensionBaseDto {
    private List<ExtensionBase> extensions;
}
