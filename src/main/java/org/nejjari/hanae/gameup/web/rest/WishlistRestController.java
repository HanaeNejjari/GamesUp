package org.nejjari.hanae.gameup.web.rest;

import org.nejjari.hanae.gameup.business.WishlistService;
import org.nejjari.hanae.gameup.dto.WishlistDto;
import org.nejjari.hanae.gameup.web.SuperRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing Wishlist entities.
 * <p>
 * This controller provides endpoints for CRUD operations on Wishlist resources.
 * It extends the generic SuperRestController to inherit standard RESTful behavior.
 * </p>
 *
 * @RestController indicates that this class is a RESTful web service controller.
 * @RequestMapping("/wishlist") maps HTTP requests to /wishlist to this controller.
 */
@RestController
@RequestMapping(WishlistRestController.BASE_PATH)
public class WishlistRestController extends SuperRestController<WishlistDto, WishlistService> {


    /**
     * The base path for this controller.
     */
    public static final String BASE_PATH = "/wishlist";

    /**
     * Constructs a WishlistRestController with the specified WishlistService.
     *
     * @param service the WishlistService used to handle business logic for Wishlist entities
     */
    @Autowired
    protected WishlistRestController(WishlistService service) {
        super(service);
    }


}
