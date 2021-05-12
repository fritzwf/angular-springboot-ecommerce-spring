package com.feuersoft.ecommerce.service;

import com.feuersoft.ecommerce.dao.CustomerRepository;
import com.feuersoft.ecommerce.dto.Purchase;
import com.feuersoft.ecommerce.dto.PurchaseResponse;
import com.feuersoft.ecommerce.entity.Customer;
import com.feuersoft.ecommerce.entity.Order;
import com.feuersoft.ecommerce.entity.OrderItem;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

/**
 * Created by ffeuerbacher on 5/10/2021
 */

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    // @Autowired - since we only have one constructor, the autowired is
    // not needed because Spring will know what to use.
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the oder from info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with billingAddress and shipping Address
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        Customer customer = purchase.getCustomer();
        // check if this is an existing customer
        String emailAddr = customer.getEmail();
        Customer customerFromDB = customerRepository.findByEmail(emailAddr);
        if (null != customerFromDB) {
            // customer was found
            customer = customerFromDB;
        }
        customer.add(order);

        // save to database
        customerRepository.save(customer);

        //  return a response
        return new PurchaseResponse(orderTrackingNumber);

    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version 4)
        return UUID.randomUUID().toString();
    }
}
