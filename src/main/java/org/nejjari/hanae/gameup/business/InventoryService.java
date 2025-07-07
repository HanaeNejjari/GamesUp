package org.nejjari.hanae.gameup.business;

import org.nejjari.hanae.gameup.business.base.SuperService;
import org.nejjari.hanae.gameup.dto.InventoryDto;
import org.nejjari.hanae.gameup.entity.InventoryEntity;
import org.nejjari.hanae.gameup.mapper.InventoryMapper;
import org.nejjari.hanae.gameup.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service providing business logic and CRUD operations for inventories.
 * Extends the generic SuperService for InventoryEntity and InventoryDto.
 */
@Service
@Transactional
public class InventoryService extends SuperService<InventoryEntity, InventoryDto, InventoryRepository, InventoryMapper> {

    /**
     * Constructs an InventoryService with the specified repository and mapper.
     *
     * @param repository the inventory repository to use
     * @param mapper     the inventory mapper to use
     */
    @Autowired
    public InventoryService(InventoryRepository repository, InventoryMapper mapper) {
        super(repository, mapper);
    }
}