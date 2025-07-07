package org.nejjari.hanae.gameup.web.rest;

import org.nejjari.hanae.gameup.business.PublisherService;
import org.nejjari.hanae.gameup.dto.PublisherDto;
import org.nejjari.hanae.gameup.web.SuperRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * REST controller for managing Publisher entities.
 * <p>
 * This controller provides endpoints for CRUD operations on Publisher resources.
 * It extends the generic SuperRestController to inherit standard RESTful behavior.
 * </p>
 *
 * @RestController indicates that this class is a RESTful web service controller.
 * @RequestMapping("/publisher") maps HTTP requests to /publisher to this controller.
 */
@RestController
@RequestMapping(PublisherRestController.BASE_PATH)
public class PublisherRestController extends SuperRestController<PublisherDto, PublisherService> {


    /**
     * The base path for this controller.
     */
    public static final String BASE_PATH = "/publisher";

    /**
     * Constructs a PublisherRestController with the specified PublisherService.
     *
     * @param service the PublisherService used to handle business logic for Publisher entities
     */
    @Autowired
    protected PublisherRestController(PublisherService service) {
        super(service);
    }


}
