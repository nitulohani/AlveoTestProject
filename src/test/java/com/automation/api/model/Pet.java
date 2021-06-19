package com.automation.api.model;


import java.util.Date;

public class  Pet {
    private Integer petId;
    private Integer id;
    private Integer quantity;
    private String ShipDate;
    private String status;
    private boolean complete;

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getShipDate() {
        return ShipDate;
    }

    public void setShipDate(String shipDate) {
        ShipDate = shipDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Pet(Integer petId, Integer id, Integer quantity, String shipDate, String status, boolean complete) {
        this.petId = petId;
        this.id = id;
        this.quantity = quantity;
        ShipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }

    public Pet(Integer petId, Integer id, Integer quantity) {
        this.petId = petId;
        this.id = id;
        this.quantity = quantity;
    }
}
