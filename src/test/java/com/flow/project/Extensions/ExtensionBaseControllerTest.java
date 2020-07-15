package com.flow.project.Extensions;

import com.flow.project.Common.BaseControllerTest;
import com.flow.project.Common.TestDescription;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ExtensionBaseControllerTest extends BaseControllerTest {

    @Test
    @TestDescription("확장자 조회 테스트")
    public void getExtensionsTest() throws Exception {
        this.mockMvc.perform(get("/ext_select")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("extensions").exists())
                .andExpect(jsonPath("_links").exists())
        ;
    }

    @Test
    @TestDescription("확장자 수정 테스트")
    public void updateExtensionsTest() throws Exception {
        ExtensionBase TestExtensionBase1 = ExtensionBase.builder()
                .extensionName("bat")
                .useThis(false)
                .build();
        List<ExtensionBase> testList = new ArrayList<>();
        testList.add(TestExtensionBase1);
        ExtensionBase TestExtensionBase2 = ExtensionBase.builder()
                .extensionName("test")
                .useThis(true)
                .build();
        testList.add(TestExtensionBase2);
        ExtensionBaseDto extensionBaseDto = ExtensionBaseDto.builder()
                .extensions(testList)
                .build();

        this.mockMvc.perform(put("/ext_update")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(extensionBaseDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("extensions").exists())
                .andExpect(jsonPath("_links").exists())
        ;

    }

    @Test
    @TestDescription("확장자 수정에서 잘못된 값을 넘겼을 경우 테스트")
    public void updateExtensionsWrongTest() throws Exception {
        List<String> testList = new ArrayList<>();
        testList.add("test");

        this.mockMvc.perform(put("/ext_update")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(testList)))
                .andDo(print())
                .andExpect(status().isBadRequest())
        ;
    }
}