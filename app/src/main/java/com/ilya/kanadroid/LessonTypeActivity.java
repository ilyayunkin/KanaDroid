package com.ilya.kanadroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LessonTypeActivity extends AppCompatActivity {
    // public:
    public void onClick(View v) {
        Button b = (Button) v;

        switch (v.getId()){
            case R.id.monographsButton:
                GlobalPlaySettings.setLessonType(GlobalPlaySettings.LessonType.MONOGRAPHS);
                break;
            case R.id.digraphsButton:
                GlobalPlaySettings.setLessonType(GlobalPlaySettings.LessonType.DIGRAPHS);
                break;
            case R.id.diacriticsButton:
                GlobalPlaySettings.setLessonType(GlobalPlaySettings.LessonType.DIACRITICS);
                break;
        }

        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_type);
    }
}