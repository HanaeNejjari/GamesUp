"""
schemas.py

Définit les schémas de données pour la validation et la structuration des réponses API.

Classes :
- Recommendation : Schéma d'une recommandation (game_id, estimated_score).
- RecommendationsResponse : Schéma d'une réponse contenant une liste de recommandations.
"""
from typing import List

from pydantic import BaseModel


# Define the schema for the game
class Recommendation(BaseModel):
    game_id: int
    estimated_score: float


class RecommendationsResponse(BaseModel):
    recommendations: List[Recommendation]
