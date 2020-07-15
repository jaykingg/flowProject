package com.flow.project.Configs;

import com.flow.project.Extensions.ExtensionBase;
import com.flow.project.Extensions.ExtensionBaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Autowired
    ExtensionBaseRepository extensionBaseRepository;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
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
        };
    }

}
