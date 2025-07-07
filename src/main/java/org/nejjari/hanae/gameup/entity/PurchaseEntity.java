package org.nejjari.hanae.gameup.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;
import org.nejjari.hanae.gameup.entity.base.SuperEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Entity representing a purchase in the system.
 * A purchase contains a list of purchase lines, a date, and status flags.
 */
@Entity
@NoArgsConstructor
public class PurchaseEntity extends SuperEntity {
    /**
     * The list of purchase lines associated with this purchase.
     */
    @OneToMany(fetch = FetchType.EAGER)
    private List<PurchaseLineEntity> line = new ArrayList<>(0);

    /**
     * The date of the purchase.
     */
    private LocalDate date;

    /**
     * Indicates if the purchase has been paid.
     */
    private boolean paid;

    /**
     * Indicates if the purchase has been delivered.
     */
    private boolean delivered;

    /**
     * Indicates if the purchase has been archived.
     */
    private boolean archived;

    /**
     * Constructs a PurchaseEntity with the specified parameters.
     *
     * @param id        the unique identifier
     * @param line      the list of purchase lines
     * @param date      the date of the purchase
     * @param paid      whether the purchase is paid
     * @param delivered whether the purchase is delivered
     * @param archived  whether the purchase is archived
     */
    public PurchaseEntity(Long id, List<PurchaseLineEntity> line, LocalDate date, boolean paid, boolean delivered, boolean archived) {
        this.id = id;
        this.line = Optional.ofNullable(line).orElse(this.line);
        this.date = date;
        this.paid = paid;
        this.delivered = delivered;
        this.archived = archived;
    }

    /**
     * Returns the identifier of the purchase.
     *
     * @return the identifier
     */
    @Override
    public Long getIdentifier() {
        return id;
    }

    /**
     * Returns the identifier of the purchase.
     *
     * @return the identifier
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the identifier of the purchase.
     *
     * @param id the identifier to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the list of purchase lines.
     *
     * @return the list of purchase lines
     */
    public List<PurchaseLineEntity> getLine() {
        return this.line;
    }

    /**
     * Sets the list of purchase lines.
     *
     * @param line the list of purchase lines to set
     */
    public void setLine(List<PurchaseLineEntity> line) {
        this.line = line;
    }

    /**
     * Returns the date of the purchase.
     *
     * @return the date
     */
    public LocalDate getDate() {
        return this.date;
    }

    /**
     * Sets the date of the purchase.
     *
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Returns whether the purchase is paid.
     *
     * @return true if paid, false otherwise
     */
    public boolean isPaid() {
        return this.paid;
    }

    /**
     * Sets whether the purchase is paid.
     *
     * @param paid true if paid, false otherwise
     */
    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    /**
     * Returns whether the purchase is delivered.
     *
     * @return true if delivered, false otherwise
     */
    public boolean isDelivered() {
        return this.delivered;
    }

    /**
     * Sets whether the purchase is delivered.
     *
     * @param delivered true if delivered, false otherwise
     */
    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    /**
     * Returns whether the purchase is archived.
     *
     * @return true if archived, false otherwise
     */
    public boolean isArchived() {
        return this.archived;
    }

    /**
     * Sets whether the purchase is archived.
     *
     * @param archived true if archived, false otherwise
     */
    public void setArchived(boolean archived) {
        this.archived = archived;
    }


    /**
     * Returns a string representation of the purchase.
     *
     * @return the string representation
     */
    public String toString() {
        return "PurchaseEntity(id=" + this.getId() + ", line=" + this.getLine() + ", date=" + this.getDate() + ", paid=" + this.isPaid() + ", delivered=" + this.isDelivered() + ", archived=" + this.isArchived() + ")";
    }
}