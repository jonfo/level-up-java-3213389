package com.linkedin.javacodechallenges;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class StoreItem implements Comparable<StoreItem> {
  String name;
  double retailPrice;
  double discount;

  @Override
  public int compareTo(StoreItem item) {
    double curHiPrice = this.retailPrice * (1.0 - this.discount);
    double itemPrice = item.retailPrice * (1.0 - item.discount);
    if (curHiPrice < itemPrice)
      return -1;
    else if (curHiPrice > itemPrice)
      return 1;
    return 0;
  }

  public static Optional<StoreItem> findLeastExpensive(Collection<StoreItem> items) {

    if (items.size() == 0)
      return Optional.empty();
    StoreItem bestDeal = Collections.min(items);
    if (bestDeal != null) {
      return Optional.of(bestDeal);
    }
    return Optional.empty();
  }

  @Override
  public String toString() {
    return "Name: " + name + ", " + "Retail price: " + retailPrice + ", " + "Discount " + discount;
  }
}