package com.chibusoft.africancuisines.model;

import java.util.List;

public class Cuisine {

        private String mainName;
        private String placeOfOrigin;
        private String description;
        private String image;
        private List<String> ingredients = null;

    /**
     * No args constructor for use in serialization
     */
    public Cuisine() {
    }

    /**
     * Parameterized constructor
     *
     * @param mainName      Main name of the cuisine
     * @param placeOfOrigin Place of origin
     * @param description   Description of the cuisine
     * @param image         Image URL
     * @param ingredients   List of ingredients
     */
    public Cuisine(String mainName, String placeOfOrigin, String description, String image, List<String> ingredients) {
        this.mainName = mainName;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
    }

    // Getters and Setters

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }



}
