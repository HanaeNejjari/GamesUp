package org.nejjari.hanae.gameup.web.rest;

import org.nejjari.hanae.gameup.business.AvisService;
import org.nejjari.hanae.gameup.dto.AvisDto;
import org.nejjari.hanae.gameup.web.SuperRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.nejjari.hanae.gameup.web.rest.AvisRestController.BASE_PATH;

/**
 * REST controller for managing Avis entities.
 * <p>
 * This controller provides endpoints for CRUD operations on Avis resources.
 * It extends the generic SuperRestController to inherit standard RESTful behavior.
 * </p>
 *
 * @RestController indicates that this class is a RESTful web service controller.
 * @RequestMapping("/avis") maps HTTP requests to /avis to this controller.
 */

@RestController
@RequestMapping(BASE_PATH)
public class AvisRestController extends SuperRestController<AvisDto, AvisService> {


    /**
     * The base path for this controller.
     */
    public static final String BASE_PATH = "/avis";

    /**
     * Constructs an AvisRestController with the specified AvisService.
     *
     * @param service the AvisService used to handle business logic for Avis entities
     */
    @Autowired
    protected AvisRestController(AvisService service) {
        super(service);
    }


}
