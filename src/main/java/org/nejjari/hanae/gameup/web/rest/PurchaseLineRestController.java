package org.nejjari.hanae.gameup.web.rest;

import org.nejjari.hanae.gameup.business.PurchaseLineService;
import org.nejjari.hanae.gameup.dto.PurchaseLineDto;
import org.nejjari.hanae.gameup.web.SuperRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing PurchaseLine entities.
 * <p>
 * This controller provides endpoints for CRUD operations on PurchaseLine resources.
 * It extends the generic SuperRestController to inherit standard RESTful behavior.
 * </p>
 *
 * @RestController indicates that this class is a RESTful web service controller.
 * @RequestMapping("/purchase-line") maps HTTP requests to /purchase-line to this controller.
 */
@RestController
@RequestMapping(PurchaseLineRestController.BASE_PATH)
public class PurchaseLineRestController extends SuperRestController<PurchaseLineDto, PurchaseLineService> {


    /**
     * The base path for this controller.
     */
    public static final String BASE_PATH = "/purchase-line";

    /**
     * Constructs a PurchaseLineRestController with the specified PurchaseLineService.
     *
     * @param service the PurchaseLineService used to handle business logic for PurchaseLine entities
     */
    @Autowired
    protected PurchaseLineRestController(PurchaseLineService service) {
        super(service);
    }


}
