# Utilise une image Python officielle
FROM python:3.11

# Crée un dossier de travail
WORKDIR /app

# Copie tout le code dans le conteneur
COPY requirements.txt .

# Installe les dépendances
RUN pip install --no-cache-dir -r requirements.txt

# Puis on copie le reste du code
COPY . .

# Ouvre le port 8081 pour accéder à l'API
EXPOSE 8081

# Ouvre le port 8081 vers localhost:8081


# Commande pour démarrer l'API
CMD ["uvicorn", "main:app", "--host", "0.0.0.0", "--port", "8081"]
