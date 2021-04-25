package com.store.management.store.stock;

import com.store.management.store.stock.interfac.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private IStockService stockService;

    @GetMapping
    public ResponseEntity<List<Stock>> getAllStock() {
        return ResponseEntity.ok(stockService.getAllStock());
    }

    @PutMapping
    public ResponseEntity<Stock> save(@RequestBody Stock stock) {
        return ResponseEntity.ok(stockService.addStock(stock));
    }
}
