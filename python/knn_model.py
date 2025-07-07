"""
knn_model.py

Implémente le modèle KNN pour la recommandation de jeux.

Fonctions :
- train_model(training_data: TrainingData)
    Entraîne le modèle KNN à partir des interactions utilisateur-jeu.
    Stocke le modèle et la matrice utilisateur-jeu.

- get_recommendations_for_user(user_data: UserData) -> List[dict]
    Retourne les 5 meilleures recommandations pour un utilisateur donné,
    en se basant sur les utilisateurs les plus proches (KNN).
"""
import pandas as pd
from sklearn.neighbors import NearestNeighbors

from models import TrainingData, UserData

# Simule le stockage du modèle
trained_model = {
    "model": None,
    "user_game_matrix": None,
    "user_ids": [],
    "game_ids": []
}


# Initialise le modèle KNN
def train_model(training_data: TrainingData):
    df = pd.DataFrame([vars(i) for i in training_data.interactions])
    if df.empty:
        raise ValueError("Aucune donnée d'entraînement fournie.")

    user_game_matrix = df.pivot_table(index="user_id", columns="game_id", values="rating").fillna(0)
    knn = NearestNeighbors(metric='cosine', algorithm='brute')
    knn.fit(user_game_matrix)

    # Stocke le modèle entraîné
    trained_model["model"] = knn
    trained_model["user_game_matrix"] = user_game_matrix
    trained_model["user_ids"] = user_game_matrix.index.tolist()
    trained_model["game_ids"] = user_game_matrix.columns.tolist()


# Renvoie les 5 meilleures recommandations pour un utilisateur donné
def get_recommendations_for_user(user_data: UserData):
    if trained_model["model"] is None:
        raise ValueError("Le modèle n'a pas encore été entraîné.")

    matrix = trained_model["user_game_matrix"]
    if user_data.user_id not in matrix.index:
        raise ValueError("Utilisateur inconnu pour le modèle KNN.")

    user_index = matrix.index.get_loc(user_data.user_id)
    distances, indices = trained_model["model"].kneighbors([matrix.iloc[user_index]], n_neighbors=2)

    neighbor_indices = indices.flatten().tolist()[1:]  # on ignore l'utilisateur lui-même
    neighbor_user_ids = [matrix.index[i] for i in neighbor_indices]

    # Récupère les jeux que les utilisateurs similaires ont aimés, mais que l’utilisateur actuel ne connaît pas encore.
    user_games = set([p.game_id for p in user_data.purchases])
    recommendations = {}

    for neighbor_id in neighbor_user_ids:
        neighbor_ratings = matrix.loc[neighbor_id]
        for game_id, rating in neighbor_ratings.items():
            if game_id not in user_games and rating > 0:
                recommendations[game_id] = rating

    # Trie les recommandations par score décroissant
    sorted_recs = sorted(recommendations.items(), key=lambda x: x[1], reverse=True)
    return [{"game_id": gid, "estimated_score": round(score, 2)} for gid, score in sorted_recs[:5]]
