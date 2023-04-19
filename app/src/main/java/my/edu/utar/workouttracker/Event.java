package my.edu.utar.workouttracker;

import android.widget.TextView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Event
{
    public static ArrayList<Event> eventsList = new ArrayList<>();

    public Event(String name, String set, String rep, String weight, TextView eventDateTV, TextView eventTimeTV) {
        this.name = name;
        this.set = set;
        this.rep = rep;
        this.weight = weight;
        this.date = date;
        this.time = time;
    }

    public static ArrayList<Event> eventsForDate(LocalDate date)
    {
        ArrayList<Event> events = new ArrayList<>();

        for(Event event : eventsList)
        {
            if(event.getDate().equals(date))
                events.add(event);
        }

        return events;
    }


    private String name, set, rep, weight;
    private LocalDate date;
    private LocalTime time;

    public Event(String name, String set, String rep, String weight, LocalDate date, LocalTime time)
    {
        this.name = name;
        this.set = set;
        this.rep = rep;
        this.weight = weight;
        this.date = date;
        this.time = time;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSet()
    {
        return set;
    }

    public void setSet(String set)
    {
        this.set = set;
    }

    public String getRep()
    {
        return rep;
    }

    public void setRep(String rep)
    {
        this.rep = rep;
    }

    public String getWeight()
    {
        return weight;
    }

    public void setWeight(String weight)
    {
        this.weight = weight;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public LocalTime getTime()
    {
        return time;
    }

    public void setTime(LocalTime time)
    {
        this.time = time;
    }
}
