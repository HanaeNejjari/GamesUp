package org.nejjari.hanae.gameup.dto;


import org.nejjari.hanae.gameup.dto.base.SuperDto;

import java.util.List;

/**
 * {@code AuthorDto} is a record representing the data transfer object for an author.
 * It contains information about the author's ID, name, and a list of games associated with the author.
 * This record implements the {@link SuperDto} interface, providing a common interface for DTOs
 * within the application.
 *
 * @param id    The unique identifier of the author.
 * @param name  The name of the author.
 * @param games A list of {@link GameDto} objects representing the games associated with the author.
 */
public record AuthorDto(Long id, String name, List<GameDto> games) implements SuperDto {
    /**
     * Constructs an {@code AuthorDto} object.
     *
     * @param id    The unique identifier of the author.
     * @param name  The name of the author.
     * @param games A list of {@link GameDto} objects representing the games associated with the author.
     */
    public AuthorDto(Long id, String name, List<GameDto> games) {
        this.id = id;
        this.name = name;
        this.games = games;
    }

    /**
     * Returns the identifier of the author.
     *
     * @return The unique identifier of the author.
     */
    @Override
    public Long getIdentifier() {
        return id;
    }
}
