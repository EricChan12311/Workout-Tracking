package my.edu.utar.workouttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalTime;

public class EventEditActivity extends AppCompatActivity
{
    EditText eventNameET, eventSetET, eventRepET, eventWeightET;
    TextView eventDateTV, eventTimeTV;
    FirebaseDatabase db;
    DatabaseReference reference;

    LocalTime time;
    String eventName, eventSet, eventRep, eventWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        initWidgets();
        time = LocalTime.now();
        eventDateTV.setText("Date: " + CalendarUtils.formattedDate(CalendarUtils.selectedDate));
        eventTimeTV.setText("Time: " + CalendarUtils.formattedTime(time));

        Button btn = (Button) findViewById(R.id.savebtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventName = eventNameET.getText().toString();
                eventSet = eventSetET.getText().toString();
                eventRep = eventRepET.getText().toString();
                eventWeight = eventWeightET.getText().toString();
                Event newEvent = new Event(eventName, eventSet, eventRep, eventWeight, CalendarUtils.selectedDate, time);
                Event.eventsList.add(newEvent);
                Event event = new Event(eventName, eventSet, eventRep, eventWeight, eventDateTV, eventTimeTV);
                db = FirebaseDatabase.getInstance();
                reference = db.getReference("Track");
                reference.child(eventName).setValue(event).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(Task<Void> task) {
                        eventSetET.setText("");
                        eventRepET.setText("");
                        eventWeightET.setText("");
                    }
                });
                finish();
            }
        });

    }

    private void initWidgets()
    {
        eventNameET = findViewById(R.id.eventNameET);
        eventSetET = findViewById(R.id.eventSetET);
        eventRepET = findViewById(R.id.eventRepET);
        eventWeightET = findViewById(R.id.eventWeightET);
        eventDateTV = findViewById(R.id.eventDateTV);
        eventTimeTV = findViewById(R.id.eventTimeTV);
    }

    }