"""
recommendation.py

Contient la fonction principale pour générer les recommandations à partir des données utilisateur.

Fonctions :
- generate_recommendations(user_data: UserData) -> List[Recommendation]
    Appelle le modèle KNN pour obtenir les recommandations brutes (des dicts),
    puis les convertit en objets Recommendation pour correspondre au schéma.
"""
from knn_model import get_recommendations_for_user
from models import UserData
from schemas import Recommendation  # Utilise le bon modèle de réponse


# Fonction pour générer les recommandations
def generate_recommendations(user_data: UserData):
    # Appelle le modèle pour obtenir les recommandations brutes (des dicts)
    raw_recs = get_recommendations_for_user(user_data)

    # Convertit les dicts en objets Recommendation pour correspondre au schéma
    return [Recommendation(**r) for r in raw_recs]
