package org.nejjari.hanae.gameup.dto;


import org.nejjari.hanae.gameup.dto.base.SuperDto;


public record GameRecommendationDto(Long game_id, Double estimated_score) implements SuperDto, Comparable<Double> {
    public GameRecommendationDto(Long game_id, Double estimated_score) {
        this.game_id = game_id;
        this.estimated_score = estimated_score;
    }

    /**
     * Returns the identifier of the recommendation game.
     *
     * @return The unique identifier of the recommendation game.
     */
    @Override
    public Long getIdentifier() {
        return game_id;
    }

    @Override
    public int compareTo(Double other) {
        return estimated_score.compareTo(other);
    }
}
