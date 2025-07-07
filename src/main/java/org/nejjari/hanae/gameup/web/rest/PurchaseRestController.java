package org.nejjari.hanae.gameup.web.rest;

import org.nejjari.hanae.gameup.business.PurchaseService;
import org.nejjari.hanae.gameup.dto.PurchaseDto;
import org.nejjari.hanae.gameup.web.SuperRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing Purchase entities.
 * <p>
 * This controller provides endpoints for CRUD operations on Purchase resources.
 * It extends the generic SuperRestController to inherit standard RESTful behavior.
 * </p>
 *
 * @RestController indicates that this class is a RESTful web service controller.
 * @RequestMapping("/purchase") maps HTTP requests to /purchase to this controller.
 */
@RestController
@RequestMapping(PurchaseRestController.BASE_PATH)
public class PurchaseRestController extends SuperRestController<PurchaseDto, PurchaseService> {


    /**
     * The base path for this controller.
     */
    public static final String BASE_PATH = "/purchase";

    /**
     * Constructs a PurchaseRestController with the specified PurchaseService.
     *
     * @param service the PurchaseService used to handle business logic for Purchase entities
     */
    @Autowired
    protected PurchaseRestController(PurchaseService service) {
        super(service);
    }


}
