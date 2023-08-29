# service-notifications-with-sms-mail-webhook
Au sein d'un projet de réalisation d'une plateforme de données, une fonctionnalité essentielle a été 
mise en place : le système de notification. Cette fonctionnalité vise à avertir en temps réel les 
responsables des équipements chargés de superviser les appareils surveillés par la plateforme, dès 
qu'un événement critique se produit, tel qu'un dépassement de température. 
Grâce à cette fonctionnalité de notification avancée, les responsables sont immédiatement alertés 
par le biais d'un message ou d'un courriel détaillant les informations spécifiques concernant 
l'évènement.  
Ces notifications sont conçues pour fournir des données claires et précises sur l'équipement 
concerné, la nature de l'incident, ainsi que l'heure et la date de l'événement. L'objectif de ces 
notifications est de permettre une réaction rapide et efficace des responsables face à tout problème 
potentiel. Ils peuvent ainsi prendre des mesures immédiates pour corriger la situation, minimiser les 
risques, et garantir le bon fonctionnement des équipements surveillés.

# L'architecture implémentée

![image](https://github.com/mostafasissi/service-notifications-with-sms-mail-webhook/assets/101025147/6b964757-1751-475a-9e69-d972d981a7c3)

# L'implementation 
  - Kafka producer  
Ce service efficace, basé sur Spring Boot, facilite l'envoi de messages vers Kafka.

  - Ecosystème de kafka  
L'implémentation de l'écosystème Kafka est réalisée à l'aide de Docker Compose, en 
exécutant deux conteneurs : l'un contenant un broker Kafka et l'autre contenant ZooKeeper.
  - kafka consumer  
Ce service est développé avec Spring Boot et a pour fonctionnalité de lire des messages à 
partir de divers topics Kafka (mail topic, sms topic, webhook topic) pour ensuite invoquer les 
services d'envoi de messages appropriés.
  - mail service  
Ce service est développé en utilisant Spring Boot avec le module Spring Mail, qui permet de 
gérer l'envoi d'e-mails de manière fiable et sécurisée.
  - SMS service :  
Ce service est réalisé en utilisant l'API de Vonage, une plateforme de communication 
puissante qui facilite l'envoi de SMS vers des destinations partout dans le monde. 
L'intégration de l'API de Vonage nous permet d'offrir une expérience de messagerie SMS 
fiable et efficace. Grâce à cette API, nous pouvons envoyer des SMS à des destinataires dans 
le monde entier, en bénéficiant d'une couverture étendue et d'une livraison rapide.
  - Webhook service ( tester avec slack) 
Ce service est conçu pour envoyer des webhooks vers différentes destinations, et pour nos 
tests, nous avons opté pour l'intégration avec Slack.
# Exigences
Pour construire et exécuter l'application, vous avez besoin de :

JDK 1.8
Maven 3
