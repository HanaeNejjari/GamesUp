package org.nejjari.hanae.gameup.web.rest;

import org.nejjari.hanae.gameup.business.AuthorService;
import org.nejjari.hanae.gameup.dto.AuthorDto;
import org.nejjari.hanae.gameup.web.SuperRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing authors.
 * Exposes endpoints for performing CRUD operations on {@link AuthorDto} objects.
 * The base path for all author related endpoints is `/author`.
 * <p>
 * This controller inherits common functionalities from {@link SuperRestController},
 * providing a consistent API structure across different entities.
 *
 * @author Hanae NEJJARI
 * @version 1.0
 */
@RestController
@RequestMapping(AuthorRestController.BASE_PATH)
public class AuthorRestController extends SuperRestController<AuthorDto, AuthorService> {

    /**
     * The base path for this controller.
     */
    public static final String BASE_PATH = "/author";


    /**
     * Constructor for the AuthorRestController.
     *
     * @param service The service for managing authors.
     */
    @Autowired
    protected AuthorRestController(AuthorService service) {
        super(service);
    }


}
