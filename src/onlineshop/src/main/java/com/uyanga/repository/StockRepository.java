package com.uyanga.repository;

import com.uyanga.entity.Product;
import com.uyanga.entity.Stock;

import java.util.HashMap;
import java.util.Map;

public class StockRepository {
    private Map<String, Stock> stock = new HashMap<>();

    public StockRepository()
    {
        this.stock.put("sId1", new Stock("sId1", "stock_address1"));
        this.stock.put("sId2", new Stock("sId2", "stock_address1"));
    }

    public Stock findById(String stockId)
    {
        if (this.stock.keySet().contains(stockId))
        {
            return this.stock.get(stockId);
        }
        else
        {
            return null;
        }
    }
}
