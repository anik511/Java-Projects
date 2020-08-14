/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerui;

/**
 *
 * @author DCL
 */
public class FoodTable {
    
    String foodNME, foodPrice;

   

    public String getFoodNME() {
        return foodNME;
    }

    public void setFoodNME(String foodNME) {
        this.foodNME = foodNME;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }
     public FoodTable(String foodNME, String foodPrice) {
        this.foodNME = foodNME;
        this.foodPrice = foodPrice;
    }
    
}
