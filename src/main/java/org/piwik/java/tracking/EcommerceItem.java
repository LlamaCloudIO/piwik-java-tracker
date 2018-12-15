/*
 * Piwik Java Tracker
 *
 * @link https://github.com/piwik/piwik-java-tracker
 * @license https://github.com/piwik/piwik-java-tracker/blob/master/LICENSE BSD-3 Clause
 */
package org.piwik.java.tracking;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonValue;

/**
 * Represents an item in an ecommerce order.
 *
 * @author brettcsorba
 */
public class EcommerceItem implements JsonValue {
    private String sku;
    private String name;
    private String category;
    private Double price;
    private Integer quantity;

    /**
     * Construct an EcommerceItem from its sku, name, category, price, and
     * quantity of the order.
     *
     * @param sku      the item's sku
     * @param name     the item's name
     * @param category the item's category
     * @param price    the item's price
     * @param quantity the quantity of this item in this order
     */
    public EcommerceItem(String sku, String name, String category, Double price, Integer quantity) {
        this.sku = sku;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Get an item's sku.
     *
     * @return the item's sku
     */
    public String getSku() {
        return sku;
    }

    /**
     * Set an item's sku.
     *
     * @param sku the sku to set
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * Get an item's name.
     *
     * @return the item's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set an item's name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get an item's category.
     *
     * @return an item's category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set an item's category.
     *
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Get an item's price.
     *
     * @return an item's price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Set an item's price.
     *
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Get the quantity of this item in this order.
     *
     * @return the quantity of this item in the order
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of this item in this order
     *
     * @param quantity the quantity of this item to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the JSON value type of EcommerceItem.
     *
     * @return ValueType.ARRAY
     */
    @Override
    public ValueType getValueType() {
        return ValueType.ARRAY;
    }

    /**
     * Returns the value of this EcommerceItem as a JSON Array string.
     *
     * @return this as a JSON array string
     */
    @Override
    public String toString() {
        return toJsonArray().toString();
    }

    /**
     * Returns the value of this EcommerceItem as a JsonArray.
     *
     * @return this as a JsonArray
     */
    JsonArray toJsonArray() {
        JsonArrayBuilder ab = Json.createArrayBuilder();
        ab.add(sku);
        ab.add(name);
        ab.add(category);
        ab.add(price);
        ab.add(quantity);

        return ab.build();
    }
}
