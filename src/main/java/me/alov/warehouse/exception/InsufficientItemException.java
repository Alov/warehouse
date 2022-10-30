package me.alov.warehouse.exception;

import lombok.Getter;

@Getter
public class InsufficientItemException extends RuntimeException {
    private String itemName;
    private Integer count;

    public InsufficientItemException(String itemName, Integer count) {
        super("Cannot sale items " + itemName + " more that exist(" + count +")");
        this.itemName = itemName;
        this.count = count;
    }

    public InsufficientItemException(Throwable cause, String itemName, Integer count) {
        super("Cannot sale items " + itemName + " more that exist(" + count +")", cause);
        this.itemName = itemName;
        this.count = count;
    }
}
