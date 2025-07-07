package org.nejjari.hanae.gameup.business;

import org.nejjari.hanae.gameup.business.base.SuperService;
import org.nejjari.hanae.gameup.dto.WishlistDto;
import org.nejjari.hanae.gameup.entity.WishlistEntity;
import org.nejjari.hanae.gameup.mapper.WishlistMapper;
import org.nejjari.hanae.gameup.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service providing business logic and CRUD operations for wishlists.
 * Extends the generic SuperService for WishlistEntity and WishlistDto.
 */
@Service
@Transactional
public class WishlistService extends SuperService<WishlistEntity, WishlistDto, WishlistRepository, WishlistMapper> {

    /**
     * Constructs a WishlistService with the specified repository and mapper.
     *
     * @param repository the wishlist repository to use
     * @param mapper     the wishlist mapper to use
     */
    @Autowired
    public WishlistService(WishlistRepository repository, WishlistMapper mapper) {
        super(repository, mapper);
    }
}