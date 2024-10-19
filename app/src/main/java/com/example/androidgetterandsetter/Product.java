package com.example.androidgetterandsetter;


public class Product {
    private int id, prize;
    private String name, category;



    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public String getName(){ return name;}
    public void setName(String name){this.name = name;}

    public String getCategory(){return category;}
    public void setCategory(String category){this.category = category;}

    public int getPrize(){return prize;}
    public void setPrize(int prize){this.prize = prize;}

}
