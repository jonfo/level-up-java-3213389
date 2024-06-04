package com.linkedin.javacodechallenges;

import java.util.Collection;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StoreItem {
  String name;
  double retailPrice;
  double discount;

  public static Optional<StoreItem> findLeastExpensive(Collection<StoreItem> items) {

    // List<StoreItem> list = values.stream().collect(Collectors.toList())

    System.out.println("size = " + items.size());
    StoreItem bestDeal = null;
    double lowestPrice = 1000000;
    items.forEach(list -> {
      double discountedPrice = list.getRetailPrice() * (1.0 - list.getDiscount());
      if (discountedPrice < lowestPrice) {
        bestDeal = list;
        lowestPrice = discountedPrice;
      }
      System.out.println("Discounted price for " + list.name + " = " + discountedPrice);
    });
    if (lowestPrice != 1000000)
      return Optional.of(bestDeal);

    return Optional.empty();
  }

  @Override
  public String toString() {
    return "Name: " + name + ", " + "Retail price: " + retailPrice + ", " + "Discount " + discount;
  }
}