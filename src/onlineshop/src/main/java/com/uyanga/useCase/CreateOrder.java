package com.uyanga.useCase;

import com.uyanga.ProductListItem;
import com.uyanga.entity.Order;
import org.apache.commons.lang3.Validate;

import java.util.List;

public class CreateOrder {

    public Order execute(String customerID, List<ProductListItem> orderedProducts)
    {
        Validate.notBlank(customerID);
        Validate.notEmpty(orderedProducts);

        return new Order("oID", customerID, orderedProducts );
    }


}
