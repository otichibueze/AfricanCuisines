package com.chibusoft.africancuisines;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chibusoft.africancuisines.model.Cuisine;
import com.chibusoft.africancuisines.utils.jsonUtils;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    private TextView mOriginDetails;
    private TextView mDescriptionDetails;
    private TextView mIngredientsDetails;
    private ImageView ingredientsIv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ingredientsIv = (ImageView) findViewById(R.id.image_iv);

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

        mOriginDetails = (TextView) findViewById(R.id.origin_details);
        mDescriptionDetails = (TextView) findViewById(R.id.description_details);
        mIngredientsDetails = (TextView) findViewById(R.id.ingredients_details);

        populateUI(cuisine);

        setTitle(cuisine.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(Cuisine cuisine) {

        //TODO: Use Picasso to load image and into ingredientsIv set
        Picasso.get()
                .load(cuisine.getImage())
                .placeholder(R.drawable.food)
                .error(R.drawable.error)
                .into(ingredientsIv, new Callback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.d("PICASSO", "onError: " + e.getMessage().toString());
                    }
                });

        mOriginDetails.setText(cuisine.getPlaceOfOrigin());

        mDescriptionDetails.append(cuisine.getDescription());

        //if empty hide
        StringBuilder s = new StringBuilder();

        for (String in : cuisine.getIngredients()) {
            s.append(in + ", ");
        }

        mIngredientsDetails.setText(s.substring(0, s.length() - 2));
    }
}
