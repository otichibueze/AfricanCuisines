package com.chibusoft.africancuisines.utils;

import com.chibusoft.africancuisines.model.Cuisine;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class jsonUtils {

    private static JSONObject cuisinesDetails;
    private static Cuisine cuisines;

    public static Cuisine parseSandwichJson(String json) {

        try {
            cuisinesDetails = new JSONObject(json);

            JSONObject name = cuisinesDetails.getJSONObject("name");

            //These strings mainName, placeOfOrigin, description and image are keys from our json file
            String mainName = name.getString("mainName");
            String placeOfOrigin = cuisinesDetails.getString("placeOfOrigin");
            String description = cuisinesDetails.getString("description");
            String image = cuisinesDetails.getString("image");


            //The ingredients is a json array
            JSONArray jsingredients = cuisinesDetails.getJSONArray("ingredients");

            List<String> ingredients = new ArrayList<>();

            for(int i = 0; i <jsingredients.length(); i++)
            {
                ingredients.add(jsingredients.getString(i));
            }


            //TODO : Create a Cuisine constructor that will take all required fields from json class created above


            return cuisines;
        }
        catch (JSONException e)
        {
            e.getStackTrace();
            return  null;
        }

    }

}
