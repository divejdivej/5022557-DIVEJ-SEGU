package Builder2;

public class Computer {
    private String cpu;
    private String ram;
    private String storage;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    public static class Builder {
        private String cpu;
        private String ram;
        private String storage;

        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    public static void main(String[] args) {
        Computer computer1 = new Builder()
                .setCpu("Intel Core i5")
                .setRam("8GB")
                .setStorage("1TB")
                .build();

        Computer computer2 = new Builder()
                .setCpu("AMD Ryzen 7")
                .setRam("16GB")
                .setStorage("2TB")
                .build();

        System.out.println("Computer 1: CPU - " + computer1.cpu + ", RAM - " + computer1.ram + ", Storage - " + computer1.storage);
        System.out.println("Computer 2: CPU - " + computer2.cpu + ", RAM - " + computer2.ram + ", Storage - " + computer2.storage);
    }
}