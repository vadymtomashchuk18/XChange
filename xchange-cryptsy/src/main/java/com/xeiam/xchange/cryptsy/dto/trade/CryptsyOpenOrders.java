/**
 * Copyright (C) 2012 - 2014 Xeiam LLC http://xeiam.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.xeiam.xchange.cryptsy.dto.trade;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xeiam.xchange.cryptsy.CryptsyUtils;
import com.xeiam.xchange.cryptsy.dto.CryptsyOrder.CryptsyOrderType;

/**
 * @author ObsessiveOrange
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptsyOpenOrders {
  
  private final int              marketID;
  private final int              orderID;
  private final CryptsyOrderType type;
  private final Date             timeStamp;
  private final BigDecimal       price;
  private final BigDecimal       quantityRem;
  private final BigDecimal       quantityOrg;
  private final BigDecimal       total;
  
  /**
   * Constructor
   * 
   * @param timestamp
   * @param isYourOrder
   * @param orderId
   * @param rate
   * @param amount
   * @param type
   * @param pair
   * @throws ParseException
   */
  public CryptsyOpenOrders(@JsonProperty("marketid") int marketID, @JsonProperty("ordertype") CryptsyOrderType type,
      @JsonProperty("orderid") int orderID, @JsonProperty("created") String timeStamp, @JsonProperty("price") BigDecimal price,
      @JsonProperty("quantity") BigDecimal quantityRem, @JsonProperty("total") BigDecimal total, @JsonProperty("orig_quantity") BigDecimal quantityOrg)
      throws ParseException {
  
    this.marketID = marketID;
    this.orderID = orderID;
    this.type = type;
    this.timeStamp = timeStamp == null ? null : CryptsyUtils.convertDateTime(timeStamp);
    this.price = price;
    this.quantityRem = quantityRem;
    this.total = total;
    this.quantityOrg = quantityOrg;
  }
  
  public int getMarketID() {
  
    return marketID;
  }
  
  public int getOrderID() {
  
    return orderID;
  }
  
  public CryptsyOrderType getTradeType() {
  
    return type;
  }
  
  public Date getTimestamp() {
  
    return timeStamp;
  }
  
  public BigDecimal getPrice() {
  
    return price;
  }
  
  public BigDecimal getQuantityRemaining() {
  
    return quantityRem;
  }
  
  public BigDecimal getOriginalQuantity() {
  
    return quantityOrg;
  }
  
  public BigDecimal getTotal() {
  
    return total;
  }
  
  @Override
  public String toString() {
  
    return "CryptsyOpenOrder[" + "Market ID='" + marketID + "',Order ID='" + orderID + "',Type='" + type + "',Timestamp='" + timeStamp + "',Price='"
        + price + "',Quantity Remaining='" + quantityRem + "',Total='" + total + "',Original Quantity='" + quantityOrg + "']";
  }
}
