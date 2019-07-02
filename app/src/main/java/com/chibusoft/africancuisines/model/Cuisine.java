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

    //COMPLETE : CREATE A ANOTHER CONSTRUCTOR THAT WILL TAKE ALL THE FIELDS CREATED ABOVE
    public Cuisine(String _mainName,String _placeOfOrigin,String _description, String _image, List<String> _ingredients) {

        mainName = _mainName;
        placeOfOrigin = _placeOfOrigin;
        description = _description;
        image = _image;
        ingredients = _ingredients;
    }

    //COMPLETE : ADD GETTER AND SETTERS FOR ALL THE FIELDS CREATED


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
