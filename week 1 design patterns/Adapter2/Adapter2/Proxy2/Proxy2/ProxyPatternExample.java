package Proxy2;
public class ProxyPatternExample {
    interface Image {
        void display();
    }

    static class RealImage implements Image {
        private String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadFromDisk();
        }

        private void loadFromDisk() {
            System.out.println("Loading " + filename);
        }

        @Override
        public void display() {
            System.out.println("Displaying " + filename);
        }
    }

    static class ProxyImage implements Image {
        private RealImage image;
        private String filename;
        private boolean hasBeenLoaded = false;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        @Override
        public void display() {
            if (!hasBeenLoaded) {
                image = new RealImage(filename);
                hasBeenLoaded = true;
            }
            image.display();
        }
    }

    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        image1.display();
        image1.display();
        image2.display();
    }
}