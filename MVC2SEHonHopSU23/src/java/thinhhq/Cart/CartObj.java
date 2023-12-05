/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thinhhq.Cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ANDIM
 */
// Cart vua la DAO DTO 
public class CartObj implements Serializable {

    private Map<String, Integer> items;

    public Map<String, Integer> getItems() {
        return items;
    }

    public void addItemToCart(String sku) {
        if (sku == null) {
            return;
        }
        if (sku.trim().isEmpty()) {
            return;
        }
        //1. Check existed items
        if (this.items == null) {
            this.items = new HashMap<>();
        }
        //2. Check existed item
        int quantity = 1;
        if (this.items.containsKey(sku)) {
            quantity = this.items.get(sku) + 1;
        }
        //3. Update items
        this.items.put(sku, quantity);
    }
public void addItemToCart(String sku, int quantity){
    
}
    public void removeItemFromCart(String sku) {
        //1. Check existed items
        if (this.items == null) {
            return;
        }
        //2. Check existed item
        if (this.items.containsKey(sku)) {

            //3. Remove
            this.items.remove(sku);
            if(this.items.isEmpty()){
                this.items=null;
            }
        }
    }
}
