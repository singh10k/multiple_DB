package com.multiple.database.in;

import com.multiple.database.in.firstDB.model.Documents;
import com.multiple.database.in.firstDB.repo.DocumentsRepo;
import com.multiple.database.in.secondDB.model.Product;
import com.multiple.database.in.secondDB.repo.ProductRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DatabaseApplicationTests {

    @Autowired
    private DocumentsRepo documentsRepo;
    @Autowired
    private ProductRepo productRepo;
    @Test
    public void dbTest() {
        Documents documents=Documents.builder()
                .fileDetails("Pilog india pvt ltd")
                .fileName("pilog")
                .fileWorks("work")
                .build();
        Product product=Product.builder()
                .name("Pilog")
                .price(2)
                .details("Pilog india pvt ltd")
                .build();
        productRepo.save(product);
        documentsRepo.save(documents);
        System.out.println("testing");
    }

}
