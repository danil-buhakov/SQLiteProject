package com.skillup.bigdig.databaseproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    List<Person> personList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_add)
    void add() {
        PersonTable.addPerson(new Person("vasya", "vasyaPupkin@it.ua"), this);
    }

    @OnClick(R.id.bt_delete)
    void delete() {
        if (personList.size() > 0) {
            PersonTable.deletePerson(personList.get(personList.size() - 1), this);
            personList.remove(personList.size() - 1);
        }
    }

    @OnClick(R.id.bt_get_all)
    void getAll() {
        personList = PersonTable.getAll(this);
        for (Person p :
                personList) {
            Log.d("danil", p.toString());
        }
    }
}
