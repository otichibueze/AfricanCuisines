package com.chibusoft.africancuisines;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chibusoft.africancuisines.model.Cuisine;
import com.chibusoft.africancuisines.utils.jsonUtils;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;


    private TextView mPlaceOfOrigin;
    private TextView mOriginDetails;
    private TextView mDescription;
    private TextView mDescriptionDetails;
    private TextView mIngredients;
    private TextView mIngredientsDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView ingredientsIv = findViewById(R.id.image_iv);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] cuisines = getResources().getStringArray(R.array.Cuisines_details);
        String json = cuisines[position];
        Cuisine cuisine = jsonUtils.parseSandwichJson(json);
        if (cuisine == null) {
            // Cuisine data unavailable
            closeOnError();
            return;
        }

        // Initialize all TextViews
        mPlaceOfOrigin = findViewById(R.id.origin_lb);
        mOriginDetails = findViewById(R.id.origin_details);
        mDescription = findViewById(R.id.description_tv);
        mDescriptionDetails = findViewById(R.id.description_details);
        mIngredients = findViewById(R.id.ingredients_tv);
        mIngredientsDetails = findViewById(R.id.ingredients_details);

        populateUI(cuisine);

        // Use Picasso to load cuisine image
        Picasso.get()
                .load(cuisine.getImage())
                .into(ingredientsIv);

        setTitle(cuisine.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(Cuisine cuisine) {

        // Set place of origin
        mOriginDetails.setText(cuisine.getPlaceOfOrigin());

        // Set description
        mDescriptionDetails.setText(cuisine.getDescription());

        // Build ingredients list from array
        StringBuilder s = new StringBuilder();
        for (String ingredient : cuisine.getIngredients()) {
            s.append(ingredient).append(", ");
        }

        // Set ingredients (remove last comma and space)
        if (s.length() > 2) {
            mIngredientsDetails.setText(s.substring(0, s.length() - 2));
        }
    }
}
