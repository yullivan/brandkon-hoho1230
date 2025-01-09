package brandkon;

import brandkon.category.Category;
import brandkon.category.CategoryRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CategoryTest {
    @Autowired
    CategoryRepository repository;

    @Autowired
    EntityManager em;

    @Test
    void 수정시updateAtTest() {
        Category category = new Category("테스트", "test", "");
        repository.save(category);
        //System.out.println("수정된 시간:"+category.getUpdatedAt());
        LocalDateTime updatedAt = category.getUpdatedAt();

        category.setName("테스트 수정");
        repository.save(category);
        em.flush();
        //System.out.println("수정된 시간:"+category.getUpdatedAt());
        assertThat(category.getUpdatedAt()).isNotEqualTo(updatedAt);


    }
}
