"""
data_loader.py

Fonction utilitaire pour charger les données d'entraînement à partir d'un fichier CSV.

Fonctions :
- load_training_data(file_path) -> pd.DataFrame
    Charge un fichier CSV contenant les données d'utilisateur, jeux, etc.
"""
import pandas as pd


# Ex: Charger un fichier CSV contenant les données d'utilisateur, jeux, etc.
def load_training_data(file_path):
    # Ex: Charger un fichier CSV contenant les données d'utilisateur, jeux, etc.
    return pd.read_csv(file_path)
