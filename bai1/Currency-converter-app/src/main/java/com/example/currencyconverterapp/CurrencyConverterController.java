package com.example.currencyconverterapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConverterController {
    @GetMapping("/")
    public String getForm() {
        return "index";
    }

    @PostMapping("/")
        public String convertCurrency(@RequestParam String usdAmount, Model model) {
        double exchangeRate = 25000; // Replace with actual exchange rate from an API or database.
        double vndAmount = Double.parseDouble(usdAmount) * exchangeRate;
        model.addAttribute("vndAmount", vndAmount);
        return "index";
    }
}