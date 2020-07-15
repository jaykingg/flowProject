package com.flow.project.Extensions;

import com.flow.project.Common.BaseTimeEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "ExtensionBase")
public class ExtensionBase extends BaseTimeEntity {

    @Id
    private String extensionName;

    private boolean useThis;

}
