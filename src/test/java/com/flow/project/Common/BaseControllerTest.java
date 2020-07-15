package com.flow.project.Common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flow.project.Extensions.ExtensionBase;
import com.flow.project.Extensions.ExtensionBaseRepository;
import com.flow.project.Extensions.ExtensionServiceImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Set;
import java.util.stream.IntStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Ignore
public class BaseControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected ModelMapper modelMapper;

    @Autowired
    protected ExtensionBaseRepository extensionBaseRepository;

    @Autowired
    protected ExtensionServiceImpl extensionServiceImpl;

    @Before
    public void createBaseExtensions() {
        ExtensionBase baseExtension = new ExtensionBase();
        baseExtension.setExtensionName("bat");
        baseExtension.setUseThis(true);
        extensionBaseRepository.save(baseExtension);
        baseExtension.setExtensionName("cmd");
        baseExtension.setUseThis(true);
        extensionBaseRepository.save(baseExtension);
        baseExtension.setExtensionName("com");
        baseExtension.setUseThis(false);
        extensionBaseRepository.save(baseExtension);
        baseExtension.setExtensionName("cpl");
        extensionBaseRepository.save(baseExtension);
        baseExtension.setExtensionName("exe");
        extensionBaseRepository.save(baseExtension);
        baseExtension.setExtensionName("scr");
        extensionBaseRepository.save(baseExtension);
        baseExtension.setExtensionName("js");
        extensionBaseRepository.save(baseExtension);
    }

}
