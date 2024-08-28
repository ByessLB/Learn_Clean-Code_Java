# Clean Code

## Méthode SOLID

La méthode SOLID est un ensemble de cinq principes de concepton orientée objet qui visent à rendre le code plus compréhensible, flexible et maintenable. Voici une définition de chaque principe dans le contexte de Java :

1. Single Responsibility Principle (SRP) :

- **Définition** : Une classe doit avoir une seule raison de changer, c'est-à-dire qu'elle doit avoir une seule responsabilité.

- **Exemple** :

```java
public class UserService {
    public void createUser(User user) {
        // Logique pour créer un utilisateur
    }

    public void sendEmail(User user) {
        // Logique pour envoyer un email
    }
}
```
Ici, `UserService` a deux responsabilités : créer un utilisateur et envoyer un email. Pour respecter le SRP, il faudrait séparer ces responsabilités en deux classes distinctes.

2. **Open/Closed Principle (OCP)** :

- **Définition** : Les entités logicielles (classes, modules, fonctions, etc.) doivent être ouvertes à l'extension mais fermées à la modification.

- **Exemple** :

```java
public interface Shape {
    double area();
}

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
```
En utilisant une interface `Shape`, on peut ajouter de nouvelles formes sans modifier les classes existantes.

3. **Liskow Substitution Principle (LSP)** :

- **Définition** : Les objets d'une classe dérivée doivent pouvoir remplacer les objets de la classe de base sans altérer le comportement correct du programme.

- **Exemple** :

```java
public class Bird {
    public void fly() {
        // Logique pour voler
    }
}

public class Sparrow extends Bird {
    @Override
    public void fly() {
        // Logique pour voler
    }
}

public class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostriches can't fly");
    }
}
```
Ici, `Ostrich` ne respect pas le LSP car il ne peut voler, ce qui altère le comportement attendu.

4. **Interface Segregation Principle (ISP)** :

- **Définition** : Les clients ne doivent pas être forcés de dépendre d'interfaces qu'ils n'utilisent pas.

- **Exemple** :

```java
public interface Worker {
    void work();
    void eat();
}

public class Human implements Worker {
    @Override
    public void work() {
        // Logique pour travailler
    }

    @Override
    public void eat() {
        // Logique pour manger
    }
}

public class Robot implements Worker {
    @Override
    public void work() {
        // Logique pour travailler
    }

    @Override
    public void eat() {
        throw new UnsupportedOperationException("Robots can't eat");
    }
}
```
Ici, `Robot` ne respecte pas l'ISP car il ne peut pas manger. Pour respecter l'ISP, il faudrait séparer les interfaces en `worakble` et `Eatable`.

5. **Dependency Inversion Principle (DIP)** :

- **Définition** : Les modules de haut niveau ne doivent pas dépendre des modules de bas niveau. Les deux doivent dépendre d'abstractions. Les abstractions ne doivent pas dépendre des détails. Les détails doivent dépendre des abstractions.

- **Exemple** :

```java
public interface Logger {
    void log(String message);
}

public class CosonleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

public class Application {
    private Logger logger;

    public Application(Logger logger) {
        this.logger = logger;
    }

    public void run() {
        logger.log("Application started");
    }
}
```
Dans cet exemple, `Application` ne dépend pas de `ConsoleLogger`, mais plutôt de l'interface `Logger`. Cela permet de changer le type de logger sans affecter l'application.


## DRY (Don't Repeat Yourself)

- **Définition** : Chaque morceau de connaisance doit avoir une représentation unique et non ambiguë dans le système.

- **Exemple** :

```java
// Mauvaise pratique (répétition de code)
public class UserService {
    public void createUser(User user) {
        // Logique pour créer un utilisateur
        validateUser(user);
        saveUser(user);
    }

    public void updateUser(User user) {
        // Logique pour mettre à jour un utilisateur
        validateUser(user);
        saveUser(user);
    }

    private void validateUser(User user) {
        // Logique de validation
    }

    private void saveUser(User user) {
        // Logique de sauvegarde
    }
}
```
En extrayant la logique de validation et de sauvegarde dans des méthodes séparées, on évite la répétition de code.

## KISS (Keep It Simple, Stupid)

- **Définition** : Les systèmes fonctionnent mieux s'ils sont simple plutôt que complexes.

- **Exemple** :

```java
// Mauvaise pratique (code complexe)
public class Calculator {
    public double calculate(double a, double b, String operation) {
        switch (operation) {
            case "add":
                return a + b;
            case "subtract":
                return a - b;
            case "multiply":
                return a * b;
            case "divide":
                if (b != 0) {
                    return a / b;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            default:
            throw new UnsupportedOperationException("Invalid operation");
        }
    }
}
```
Pour simplifier, on pourrait diviser ce code en plusieurs méthodes spécifiques :
```java
public class Calculator {
    public double add(double a, double b) {
        return a + b;
    }
    public double subtract(double a, double b) {
        return a - b;
    }
    public double multiply(double a, double b) {
        return a * b;
    }
    public double divide(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("Division by zero");
        }
    }
}
```

## YAGNI (You Aren't Gonna Need It)

- **Définition** : Ne pas ajouter de fonctionnalités jusqu'à ce qu'elles soient nécessaires.

- **Exemple** :

```java
// Mauvaise pratique (ajout de fonctionnalités inutiles)
public class User {
    private String name;
    private String email;
    private Strinf address;
    private String phoneNumber;
    private String socialSecurityNumber;
    private String creditCardNumber;

    // Constructeurs, getters et setters
}
```
Si bous n'avez pas besoin de toutes ces informations pour l'instant, il est préférable de commencer avec le minimum nécessaire :
```java
public class User {
    private String name;
    private String email;

    // Constructeurs, getters et setters
}
```

## Boy Scoot Rule (Leave the campground cleaner than you found it)

- **Définition** : Toujours essayer de laisser le code dans un meilleur état que celui dans lequel vous l'avez trouvé.

- **Exemple** :

```java
// Code existant
public class UserService {
    public void createUser(User user) {
        // Logique pour créer un utilisateur
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        // Autre logique
    }
}
```
En appliquant la règle du boy scout, vous pourriez améliorer ce code en extrayant la validation dans une méthode séparée :
```java
public class UserService {
    public void createUser(User user) {
        validateUser(user);
        // Autre logique
    }

    private void validateUser(User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }
}
```

En suivant ces principes, vous pouvez améliorer la qualité, la maintenabilité et la simplicité de votre code Java.