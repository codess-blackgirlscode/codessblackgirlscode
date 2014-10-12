package com.codess.microsoft.blackgirlscode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.UUID;


public class ProfilePageActivity extends Activity {


    HashMap<Integer,Person> people = DataGenerator.makePeople();
    ImageView profilePic;
    TextView name;
    TextView age;
    TextView language;
    TextView hobbies;
    TextView goals;

    String personName;
    String personAge;
    String personLanguage;
    String personHobbies;
    String personGoals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        extractData();

        profilePic = (ImageView) findViewById(R.id.imageView);
        profilePic.setImageResource(R.drawable.panda);

        name = (TextView) findViewById(R.id.textView_nameValue);
        name.setText(personName);

        age = (TextView) findViewById(R.id.textView_ageValue);
        age.setText(personAge);

        language = (TextView) findViewById(R.id.textView_languageValue);
        language.setText(personLanguage);

        hobbies = (TextView) findViewById(R.id.textView_hobbiesValue);
        hobbies.setText(personHobbies);

        goals = (TextView) findViewById(R.id.textView_goalsValue);
        goals.setText(personGoals);
    }

    private void extractData() {
//        Intent intent = getIntent();
//        Bundle b = intent.getExtras();
//
//        UUID person_id = (UUID)b.get("EXTRA_PROFILE_ID");
        Integer person_id = 2;

        Person newPerson = people.get(person_id);
        personName = newPerson.getName();
        personAge = newPerson.getAge().toString();
        personLanguage = newPerson.getLanguages();
        personGoals = newPerson.getGoals();
        personHobbies = newPerson.getHobbies();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
