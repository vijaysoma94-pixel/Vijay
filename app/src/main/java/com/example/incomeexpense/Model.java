package com.example.incomeexpense;

public class Model {

    private int id;
    private String type;   // "income" or "expense"
    private int amount;

    // Empty constructor
    public Model() {
    }

    // Constructor without id
    public Model(String type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    // Constructor with id
    public Model(int id, String type, int amount) {
        this.id = id;
        this.type = type;
        this.amount = amount;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter and Setter for amount
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
