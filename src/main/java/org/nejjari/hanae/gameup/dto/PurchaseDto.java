package org.nejjari.hanae.gameup.dto;

import org.nejjari.hanae.gameup.dto.base.SuperDto;

import java.time.LocalDate;
import java.util.List;


/**
 * Data Transfer Object representing a complete purchase.
 * Contains the purchase ID, list of purchase lines, date, and status flags.
 */
public record PurchaseDto(
        Long id,
        List<PurchaseLineDto> line,
        LocalDate date,
        Boolean paid,
        Boolean delivered,
        Boolean archived
) implements SuperDto {

    /**
     * Constructs a new PurchaseDto with the specified details.
     *
     * @param id        the unique identifier of the purchase
     * @param line      the list of purchase lines included in the purchase
     * @param date      the date the purchase was made
     * @param paid      whether the purchase has been paid
     * @param delivered whether the purchase has been delivered
     * @param archived  whether the purchase has been archived
     */
    public PurchaseDto(Long id, List<PurchaseLineDto> line, LocalDate date, Boolean paid, Boolean delivered, Boolean archived) {
        this.id = id;
        this.line = line;
        this.date = date;
        this.paid = paid;
        this.delivered = delivered;
        this.archived = archived;
    }

    /**
     * Returns the unique identifier of the purchase.
     *
     * @return the ID of the purchase
     */
    @Override
    public Long getIdentifier() {
        return id;
    }
}
