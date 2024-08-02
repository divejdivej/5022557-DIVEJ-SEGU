package Dependancy2;
public class DependencyInjectionExample {
    interface CustomerRepository {
        String findCustomerById(int id);
    }

    static class CustomerRepositoryImpl implements CustomerRepository {
        @Override
        public String findCustomerById(int id) {
            return "Customer " + id + " found";
        }
    }

    static class CustomerService {
        private CustomerRepository customerRepository;

        public CustomerService(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        public String findCustomer(int id) {
            return customerRepository.findCustomerById(id);
        }
    }

    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);
        System.out.println(customerService.findCustomer(123));
    }
}