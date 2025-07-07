package org.nejjari.hanae.gameup.dto;


import java.util.List;


public record GameRecommendationsDto(List<GameRecommendationDto> recommendations) {

    public GameRecommendationsDto(List<GameRecommendationDto> recommendations) {
        this.recommendations = recommendations;
    }
}