package com.flow.project.Extensions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ExtensionBaseRepository extends JpaRepository<ExtensionBase, String> {
}
