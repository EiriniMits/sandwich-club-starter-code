package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {


    public static Sandwich parseSandwichJson(String json) {


        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject name = jsonObject.getJSONObject("name");
            String mainName = name.optString("mainName");

            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAsList = getJsonArray(alsoKnownAs);

            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            String description = jsonObject.getString("description");
            String image = jsonObject.getString("image");

            JSONArray ingredients = jsonObject.getJSONArray("ingredients");
            List<String> ingredientsList = getJsonArray(ingredients);

            return new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredientsList);

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<String> getJsonArray(JSONArray json) throws JSONException {

        ArrayList<String> jsonArray = new ArrayList<>();

        if (json != null) {
            for (int i = 0; i < json.length(); i++) {
                jsonArray.add(json.getString(i));
            }
        }
        return jsonArray;

    }

}
