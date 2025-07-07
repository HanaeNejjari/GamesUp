package org.nejjari.hanae.gameup.repository.base;

import org.nejjari.hanae.gameup.base.AbstractWireMockGameServiceToFastApiTest;
import org.nejjari.hanae.gameup.entity.base.SuperEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Abstract base class for repository integration tests.
 * <p>
 * This class provides a generic structure for testing CRUD operations
 * on entities managed by Spring Data JPA repositories.
 * </p>
 *
 * @param <REPOSITORY> the type of JpaRepository being tested
 */
@SpringBootTest
public abstract class SuperRepositoryTest<REPOSITORY extends JpaRepository<ENTITY, Long>, ENTITY extends SuperEntity> extends AbstractWireMockGameServiceToFastApiTest {

    /**
     * The repository instance used for performing CRUD operations in tests.
     */
    protected final REPOSITORY repository;

    /**
     * Constructs the test class with the specified repository.
     *
     * @param repository the repository to be tested
     */
    public SuperRepositoryTest(REPOSITORY repository) {
        this.repository = repository;
    }

    public abstract void testAccessors();

    /**
     * Creates a new instance of the entity to be tested.
     *
     * @return a new SuperEntity instance
     */
    public abstract ENTITY createEntity();

    /**
     * Executes the full CRUD test cycle for the entity.
     */
    public abstract void testCRUD();
}
