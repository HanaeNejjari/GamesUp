package org.nejjari.hanae.gameup.business;

import org.nejjari.hanae.gameup.business.base.SuperService;
import org.nejjari.hanae.gameup.dto.PurchaseLineDto;
import org.nejjari.hanae.gameup.entity.PurchaseLineEntity;
import org.nejjari.hanae.gameup.mapper.PurchaseLineMapper;
import org.nejjari.hanae.gameup.repository.PurchaseLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service providing business logic and CRUD operations for purchase lines.
 * Extends the generic SuperService for PurchaseLineEntity and PurchaseLineDto.
 */
@Service
@Transactional
public class PurchaseLineService extends SuperService<PurchaseLineEntity, PurchaseLineDto, PurchaseLineRepository, PurchaseLineMapper> {

    /**
     * Constructs a PurchaseLineService with the specified repository and mapper.
     *
     * @param repository the purchase line repository to use
     * @param mapper     the purchase line mapper to use
     */
    @Autowired
    public PurchaseLineService(PurchaseLineRepository repository, PurchaseLineMapper mapper) {
        super(repository, mapper);
    }
}