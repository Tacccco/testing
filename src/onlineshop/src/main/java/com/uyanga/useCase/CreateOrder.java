package com.uyanga.useCase;

import com.uyanga.ProductListItem;
import com.uyanga.entity.Order;
import com.uyanga.entity.Stock;
import com.uyanga.repository.CustomerRepository;
import com.uyanga.repository.ProductRepository;
import com.uyanga.repository.StockRepository;
import org.apache.commons.lang3.Validate;

import java.util.List;

public class CreateOrder {
    private CustomerRepository customerRepository;
    private ProductRepository productRepository;
    private StockRepository stockRepository;

    public CreateOrder(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = Validate.notNull(customerRepository);
        this.productRepository = Validate.notNull(productRepository);
    }

    public Order execute(String customerID, List<ProductListItem> orderedProducts)
    {
        Validate.notBlank(customerID);
        Validate.notEmpty(orderedProducts);

        if(customerRepository.findById(customerID) == null)
        {
            throw new IllegalArgumentException("customer not found!");
        }

        if(customerRepository.findById(customerID) == null)
        {
            throw new IllegalArgumentException("customer not found!");
        }

        double total = 0;

        for (ProductListItem p : orderedProducts)
        {
            double available = new CheckProductAmount(stockRepository, productRepository).execute("sId1",  p.getProductID());
            if(available < p.getAmount()){
                throw new IllegalArgumentException("not available amount of product");
            }
            total += productRepository.findById(p.getProductID()).getPrice() * p.getAmount();
        }

        return new Order("oID", customerID, orderedProducts, total );
    }


}
