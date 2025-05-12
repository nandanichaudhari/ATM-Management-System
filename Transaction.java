/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm_management_system.Entity;

/**
 *
 * @author aniwe
 */
public class Transaction {
    int TID,amount;
    String date ,accountNo,type;

    public Transaction() {
    }

    public Transaction(int TID, int amount, String date, String accountNo, String type) {
        this.TID = TID;
        this.amount = amount;
        this.date = date;
        this.accountNo = accountNo;
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction{");
        sb.append("TID=").append(TID);
        sb.append(", amount=").append(amount);
        sb.append(", date=").append(date);
        sb.append(", accountNo=").append(accountNo);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
    
    

    public int getTID() {
        return TID;
    }

    public void setTID(int TID) {
        this.TID = TID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
