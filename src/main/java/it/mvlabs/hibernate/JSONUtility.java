package it.mvlabs.hibernate;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONUtility {
    
    private static final Gson gson = new GsonBuilder().serializeNulls().create();
    private static final JsonParser parser = new JsonParser();
    
    public static List<JSONBOrder> ordersFromJsonArray(String pizzas) {
        JsonArray pizzasArray = parser.parse(pizzas).getAsJsonArray();
        List<JSONBOrder> result = new ArrayList<JSONBOrder>();
        pizzasArray.forEach(elem -> result.add(gson.fromJson(elem, JSONBOrder.class)));
        return result;
    }
    
    public static JsonArray pizzeriaOrders(String pizzas, String pizzeriaId, String pizzeriaName) { 
        JsonArray pizzasArray = parser.parse(pizzas).getAsJsonArray();
        JsonArray result = new JsonArray();

        pizzasArray.forEach(elem -> {
            JSONBOrder order = gson.fromJson(elem, JSONBOrder.class);     
            JsonObject obj = new JsonObject();
            obj.addProperty("name", pizzeriaName);
            obj.addProperty("pizzeria", pizzeriaId);
            obj.addProperty("at", order.getAt());
            obj.addProperty("customer", order.getCustomer());
            obj.addProperty("pizza", order.getPizza());
            
            result.add(obj);
        });
        return result;
    }
    
    public static String serializeOrders(List<JSONBOrder> orders) {
        return gson.toJson(orders);
    }
    
    public static String arrayToString(JsonArray array){
        return gson.toJson(array);
    }
}
