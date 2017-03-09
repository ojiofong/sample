package com.clayons.interviewquestions;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.clayons.interviewquestions.Model.Person;
import com.squareup.picasso.Picasso;

import java.util.Locale;


public class DetailActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        setupViews();
    }

    private void setupViews() {
        imageView = (ImageView) findViewById(R.id.ivAvatar);
        button = (Button) findViewById(R.id.btnLike);

        Bundle b = getIntent().getExtras();
        if (b != null) {

            Person person = (Person) b.get(Constants.KEY_PERSON);

            String name = String.format(Locale.US, "%s %s", person.firstName, person.lastName);
            getSupportActionBar().setTitle(name);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            int color = person.isLiked ? R.color.colorAccent : R.color.light_grey;
            String text = person.isLiked ? getString(R.string.liked) : getString(R.string.like);
            button.setText(text);
            button.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, color)));
            Picasso.with(this).load(person.photoUrl).into(imageView);
        }
    }

    public void onClickButton(View view) {
        // Simply updating the UI. Not persisting or saving any data to disk
        String text = button.getText().equals(getString(R.string.like)) ? getString(R.string.liked) : getString(R.string.like);
        int color = button.getText().equals(getString(R.string.like)) ? R.color.colorAccent : R.color.light_grey;
        button.setText(text);
        button.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, color)));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
