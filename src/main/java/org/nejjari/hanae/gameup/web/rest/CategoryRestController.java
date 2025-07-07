package org.nejjari.hanae.gameup.web.rest;

import org.nejjari.hanae.gameup.business.CategoryService;
import org.nejjari.hanae.gameup.dto.CategoryDto;
import org.nejjari.hanae.gameup.web.SuperRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.nejjari.hanae.gameup.web.rest.CategoryRestController.BASE_PATH;

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
public class CategoryRestController extends SuperRestController<CategoryDto, CategoryService> {


    /**
     * The base path for this controller.
     */
    public static final String BASE_PATH = "/category";

    /**
     * Constructs a CategoryRestController with the specified CategoryService.
     *
     * @param service the CategoryService used to handle business logic for Category entities
     */
    @Autowired
    protected CategoryRestController(CategoryService service) {
        super(service);
    }


}
