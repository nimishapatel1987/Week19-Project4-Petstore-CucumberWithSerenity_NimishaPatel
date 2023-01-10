package com.petstore.models;

public class Tags {
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
    public static Tags getTagsfor(int id,String name){
        Tags tag=new Tags();
        tag.setId(id);
        tag.setName(name);
        return tag;
    }
}
