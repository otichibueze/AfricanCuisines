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

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;


    private TextView mPlaceOfOrigin;
    //TODO: Create TextView PlaceHolder Field For mOriginDetails
    //TODO: Create TextView PlaceHolder Field For mDescription
    //TODO: Create TextView PlaceHolder Field For mDescriptionDetails
    //TODO: Create TextView PlaceHolder Field For mIngredients
    //TODO: Create TextView PlaceHolder Field For mIngredientsDetails


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //ImageView ingredientsIv = findViewById(R.id.image_iv);

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

        //mPlaceOfOrigin = (TextView) findViewById(R.id.origin_tv);
        //TODO: Set TextView PlaceHolder Field For mOriginDetails
        //TODO: Set TextView PlaceHolder Field For mDescription
        //TODO: Set TextView PlaceHolder Field For mDescriptionDetails
        //TODO: Set TextView PlaceHolder Field For mIngredients
        //TODO: Set TextView PlaceHolder Field For mIngredientsDetails


        populateUI(cuisine);
        //TODO: Use Picasso to load image and into ingredientsIv set

        //setTitle(cuisine.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(Cuisine cuisine) {

        //TODO: setText of mOriginDetails to cuisine.getPlaceOfOrigin()
        //TODO: setText of mDescriptionDetails to cuisine.getDescription()

        //TODO: Use StringBuilder to append all arrays to for form one sentence
        StringBuilder s = new StringBuilder();

        //TODO: setText of mIngredientsDetails to s
        // mIngredientsDetails.setText(s.substring(0,s.length() -2));

    }
}
