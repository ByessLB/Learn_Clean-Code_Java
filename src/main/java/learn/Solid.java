package learn;

public class Solid {

    // S -> Single Responsability Principale (SRP)

    class ContentManagement {

        void createContent(String content) { /* ... */}

        // void displayContent() {/* ... */}
    }

    // Séparation selon SRP
    class displayContent {
    void displayContent() {/* ... */}
    }

    // O -> Opend/closed Principale (OCP)

    void displayContent(Object content) {
        if (content instanceof Article article) {
            System.out.println(article);
        } else if (content instanceof Video video) {
            System.out.println(video);
        }
    }

    // Amélioration
    interface Content {
        void display() {};
    }

    class Article Implements Content {
        @Override
        public void display() {
            System.out.println(this);
        }
    }
    class Video Implements Content {
        @Override
        public void display() {
            System.out.println(this);
        }
    }

    // L -> Liskov Substitution Principale (LSP)

    class BaseContent {
        String getPreview() { return "Content Preview";}
    }

    class AssetContent extends BaseContent {
        @Override
        String getPreview() { return "Asset Preview";}
    }

    void displayContent(BaseContent baseContent) {
        System.out.println(baseContent);
    }

    void print() {
        displayContent(new AssetContent());
    }

    // I -> Interface Segregation Principle (ISP)

    Interface ContentManager {
        void create();
        void display();
        void delete();
        void edit();
        void showDetails();
    }
    // toute les class n'ont pas forcement besoin de toute les méthodes
    // de cette interface. De ce fait, il vaut mieux séparé selon les besoins

    // D -> Dependency Inversion Principle (DIP)

    class NotificationManager {
        // EmailService emailService = new EmailService();
        // PushNotificationService pushService = new PushNotificationService();

    //     void envoyerNotiication(String message) {
    //         emailService.sendEmail(message);
    //         pushService.sendPush(message);
    //     }
    // }

    // class EmailService {
        //     void sendEmail(String message) {}
        // }
        // class PushNotificationService {
            //     void sendPush(String message) {}
            // }

        private NotificationService notificationService;

        public NotificationManager(NotificationService notificationService) {
            this.notificationService = notificationService;
        }

        void sendNotification(String message) {
            notificationService.send(message);
        }

    }
    class EmailService implements NotificationService {
        @Override
        public void send(String message) {}
    }
    class PushNotificationService implements NotificationService {
        public void send(String message) {}
    }

    interface NotificationService {
        void send(String message)
    }

}
