package org.nejjari.hanae.gameup.web.rest;

import org.nejjari.hanae.gameup.business.InventoryService;
import org.nejjari.hanae.gameup.dto.InventoryDto;
import org.nejjari.hanae.gameup.web.SuperRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing Inventory entities.
 * <p>
 * This controller provides endpoints for CRUD operations on Inventory resources.
 * It extends the generic SuperRestController to inherit standard RESTful behavior.
 * </p>
 *
 * @RestController indicates that this class is a RESTful web service controller.
 * @RequestMapping("/inventory") maps HTTP requests to /inventory to this controller.
 */

@RestController
@RequestMapping(value = InventoryRestController.BASE_PATH)
public class InventoryRestController extends SuperRestController<InventoryDto, InventoryService> {

    /**
     * The base path for this controller.
     */
    public static final String BASE_PATH = "/inventory";

    /**
     * Constructs an InventoryRestController with the specified InventoryService.
     *
     * @param service the InventoryService used to handle business logic for Inventory entities
     */
    @Autowired
    protected InventoryRestController(InventoryService service) {
        super(service);
    }


}
