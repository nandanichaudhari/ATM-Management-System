 
package com.mycompany.atm_management_system.Entity;

 
public class Person {
    int pId;
    String name;
    String password, mobileNo,accountNo;
    int balance;

    
    public Person() {
    }

    public Person(int pId, String name, String password, String mobileNo, String accountNo, int balance) {
        this.pId = pId;
        this.name = name;
        this.password = password;
        this.mobileNo = mobileNo;
        this.accountNo = accountNo;
        this.balance = balance;
    }
    

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "Person{" + "pId=" + pId + ", name=" + name + ", password=" + password + ", mobileNo=" + mobileNo + ", accountNo=" + accountNo + ", balance=" + balance + '}';
    }

    
    
}
