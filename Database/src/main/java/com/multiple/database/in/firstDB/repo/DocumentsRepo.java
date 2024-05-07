package com.multiple.database.in.firstDB.repo;

import com.multiple.database.in.firstDB.model.Documents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentsRepo extends JpaRepository<Documents, Integer> {
}
