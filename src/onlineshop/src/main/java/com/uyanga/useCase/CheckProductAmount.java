package com.uyanga.useCase;

import com.uyanga.ProductListItem;
import com.uyanga.entity.Product;
import com.uyanga.repository.ProductRepository;
import com.uyanga.repository.StockRepository;
import org.apache.commons.lang3.Validate;

import java.util.List;

public class CheckProductAmount {

    private final StockRepository stockRepository;
    private final ProductRepository productRepository;

    public CheckProductAmount(StockRepository stockRepository, ProductRepository productRepository) {
        this.stockRepository = Validate.notNull(stockRepository);
        this.productRepository = Validate.notNull(productRepository);
    }

    public double execute(String StockId, String ProductId)
    {
        Validate.notBlank(StockId);
        Validate.notBlank(ProductId);

        if(productRepository.findById(ProductId) == null)
            throw new IllegalArgumentException("Product doesn't exist!");

        if (stockRepository.findById(StockId) == null)
            throw new IllegalArgumentException("Store doesn't exist!");

        List<ProductListItem> availables = stockRepository.findById(StockId).getAvailableProducts();

        for (ProductListItem p: availables)
        {
            if (p.getProductID() == ProductId)
                return p.getAmount();
        }

        return 0;
    }
}
