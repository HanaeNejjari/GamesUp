package org.nejjari.hanae.gameup.business;

import org.nejjari.hanae.gameup.business.base.SuperService;
import org.nejjari.hanae.gameup.dto.PurchaseDto;
import org.nejjari.hanae.gameup.entity.PurchaseEntity;
import org.nejjari.hanae.gameup.mapper.PurchaseMapper;
import org.nejjari.hanae.gameup.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service providing business logic and CRUD operations for purchases.
 * Extends the generic SuperService for PurchaseEntity and PurchaseDto.
 */
@Service
@Transactional
public class PurchaseService extends SuperService<PurchaseEntity, PurchaseDto, PurchaseRepository, PurchaseMapper> {

    /**
     * Constructs a PurchaseService with the specified repository and mapper.
     *
     * @param repository the purchase repository to use
     * @param mapper     the purchase mapper to use
     */
    @Autowired
    public PurchaseService(PurchaseRepository repository, PurchaseMapper mapper) {
        super(repository, mapper);
    }
}