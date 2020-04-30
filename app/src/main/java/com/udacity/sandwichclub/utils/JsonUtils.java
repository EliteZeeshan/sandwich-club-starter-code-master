package com.udacity.sandwichclub.utils;

        import android.content.Context;
        import android.content.res.Resources;

        import com.udacity.sandwichclub.R;
        import com.udacity.sandwichclub.model.Sandwich;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.logging.XMLFormatter;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();

        try {
            JSONObject jsonObject = new JSONObject(json);

            JSONObject name = jsonObject.getJSONObject("name");

            String mainName = name.getString("mainName");

            JSONArray alsoName = name.getJSONArray("alsoKnownAs");
            List<String> alsoNameList = new ArrayList<>();
            for (int i = 0; i < alsoName.length(); i++) {
                alsoNameList.add(alsoName.getString(i));

            }

            String placeOfORign = name.getString("placeOfOrigin");

            String description = name.getString("description");

            String images = name.getString("image");

            JSONArray ingridenta = name.getJSONArray("ingredients");
            List<String> ingrideiantsList = new ArrayList<>();
            for (int j = 0; j < ingridenta.length(); j++) {
                ingrideiantsList.add(ingridenta.getString(j));


                sandwich.setMainName(mainName);
                sandwich.setAlsoKnownAs(alsoNameList);
                sandwich.setIngredients(ingrideiantsList);
                sandwich.setImage(images);
                sandwich.setPlaceOfOrigin(placeOfORign);
                sandwich.setDescription(description);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich ;
    }
}
