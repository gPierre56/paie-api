# paie-api

Lien vers l'application = https://guillaume-paie-api.herokuapp.com/

pour avoir les codes et dénomination des entreprises : https://guillaume-paie-api.herokuapp.com/entreprises

```
Ajouter un employé : 

Requête

GET /referentiels

POST /entreprises

ContentType Application / Json

{
  "matricule" : "DFGR6546"
  "codeEntreprise" : "DEV"
  "profil" : "2"
  "grade" : "3"
}

Réponse en cas de succès : 201

Réponse en cas d'erreur (Identifiant non reconnu ) : 


400

Content-Type: application/json

{
    "message" : "Matricule introuvable"
}
```


```
Liste des employés

Requête

GET /Employes

Réponse en cas de succès : 200
```

```
Ajouter un bulletin de salaire

Requêtes

POST bulletins-de-salaire

{
  "periode" : "5"
  "matricule" : "MO1"
  "primeExceptionelle" : "1000"
}

Réponse en cas de succès : 200

Réponse en cas d'erreur (Identifiant non reconnu ) : 


400

Content-Type: application/json

{
    "message" : "Matricule introuvable"
}

Réponse en cas d'erreur (Prime négative) : 


400

Content-Type: application/json

{
    "message" : "Le montant de la prime ne peut pas être négatif"
}
```

```

Page liste des bulletins : 

Requêtes

GET /bulletins

Réponse en cas de succès : 200

```

```
Page bulletin de salaire :

Requête 

Get /bulletin?code=xxx

Réponse en cas de succès : 200


Réponse en cas d'erreur (Identifiant non reconnu ) : 

400

Content-Type: application/json

{
    "message" : "Le matricule est inconnu"
}


```

```

Page ajouter un employé :

Requête 

POST employes

{
  "matricule" : "UYVUYVUY"
  "entreprise" : "1"
  "Profil" : "3"
  "grade" : "2"
}

Réponse en cas de succès : 200


    Réponse en cas d'erreur (matricule format invalide)

400

Content-Type: application/json

{
    "message" : "le matricule doit contenir x caracteres"
}
