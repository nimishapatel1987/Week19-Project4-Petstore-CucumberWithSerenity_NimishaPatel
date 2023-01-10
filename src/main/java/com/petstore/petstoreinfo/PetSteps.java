package com.petstore.petstoreinfo;

import com.petstore.models.Category;
import com.petstore.models.PetPojo;
import com.petstore.models.Tags;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class PetSteps {

    @Step
    public void createPet(int id, int id1, String name1, String name, List<String> photoUrls, int id2, String name2, String status) {
        Category category = Category.getCategory(id1, name1);
        Tags tag=Tags.getTagsfor(id2,name2);
        PetPojo petPojo=new PetPojo();
    }
}
