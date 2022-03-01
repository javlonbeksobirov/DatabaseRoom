package com.b12game.databaseroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.b12game.databaseroom.database.UserRepository;
import com.b12game.databaseroom.model.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        button = findViewById(R.id.btn_save);
        textView = findViewById(R.id.tv_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roomDatabase();
            }
        });
    }

    void roomDatabase() {
        UserRepository repository = new UserRepository(getApplication());
        User user = new User(2, "sobirov Javlonbek");
//        repository.saveUser(user);
        new UserAsynkTask(repository).execute(user);
    }


    class UserAsynkTask extends AsyncTask<User, Void, List<User>> {
        UserRepository repository;

        public UserAsynkTask(UserRepository repository) {
            this.repository = repository;
        }

        @Override
        protected List<User> doInBackground(User... users) {
            repository.saveUser(users[0]);
            return repository.getUsers();
        }

        @Override
        protected void onPostExecute(List<User> users) {
            super.onPostExecute(users);
            textView.setText("Room db "+ users.size());
        }
    }

}