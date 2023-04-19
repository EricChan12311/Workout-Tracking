package my.edu.utar.workouttracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EventAdapter extends ArrayAdapter<Event>
{
    public EventAdapter(Context context, List<Event> events)
    {
        super(context, 0, events);
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent)
    {
        Event event = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_cell, parent, false);

        TextView eventCellTV = convertView.findViewById(R.id.eventCellTV);

        String eventTitle = event.getName() +"  Sets:"+  event.getSet() +"  Reps:"+  event.getRep() +"  Weight:"+  event.getWeight() +"   "+ CalendarUtils.formattedTime(event.getTime());
        eventCellTV.setText(eventTitle);
        return convertView;
    }
}
