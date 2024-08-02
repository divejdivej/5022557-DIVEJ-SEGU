package Adapter2;
public class AdapterPatternExample {
    interface PaymentProcessor {
        void processPayment(String paymentMethod);
    }

    static class PayPalPaymentGateway {
        public void makePayPalPayment(String paymentMethod) {
            System.out.println("Making PayPal payment using " + paymentMethod);
        }
    }

    static class StripePaymentGateway {
        public void makeStripePayment(String paymentMethod) {
            System.out.println("Making Stripe payment using " + paymentMethod);
        }
    }

    static class PayPalAdapter implements PaymentProcessor {
        private PayPalPaymentGateway paypalGateway;

        public PayPalAdapter(PayPalPaymentGateway paypalGateway) {
            this.paypalGateway = paypalGateway;
        }

        @Override
        public void processPayment(String paymentMethod) {
            paypalGateway.makePayPalPayment(paymentMethod);
        }
    }

    static class StripeAdapter implements PaymentProcessor {
        private StripePaymentGateway stripeGateway;

        public StripeAdapter(StripePaymentGateway stripeGateway) {
            this.stripeGateway = stripeGateway;
        }

        @Override
        public void processPayment(String paymentMethod) {
            stripeGateway.makeStripePayment(paymentMethod);
        }
    }

    public static void main(String[] args) {
        PayPalPaymentGateway paypalGateway = new PayPalPaymentGateway();
        PayPalAdapter paypalAdapter = new PayPalAdapter(paypalGateway);
        paypalAdapter.processPayment("Credit Card");

        StripePaymentGateway stripeGateway = new StripePaymentGateway();
        StripeAdapter stripeAdapter = new StripeAdapter(stripeGateway);
        stripeAdapter.processPayment("Debit Card");
    }
}