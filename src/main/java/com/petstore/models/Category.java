package com.petstore.models;

public class Category {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static Category getCategory(int id,String name){
        Category category=new Category();
        category.setId(id);
        category.setName(name);
        return category;
    }
}
