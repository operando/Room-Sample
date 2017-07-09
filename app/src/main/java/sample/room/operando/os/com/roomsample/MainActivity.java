package sample.room.operando.os.com.roomsample;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, "room-sample")
                .allowMainThreadQueries()
                .build();

        findViewById(R.id.select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, db.userDao().getAll().toString());
            }
        });

        findViewById(R.id.insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User u = new User();
                u.setFirstName("test");
                u.setLastName("ooo");
                u.uid = UUID.randomUUID().toString();
                db.userDao().insert(u);
            }
        });

        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User u = db.userDao().getAll().get(0);
                u.setFirstName("update");
                db.userDao().update(u);
            }
        });

        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User u = db.userDao().getAll().get(0);
                db.userDao().delete(u);
            }
        });
    }
}