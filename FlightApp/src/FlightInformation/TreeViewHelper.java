package FlightInformation;

import java.util.ArrayList;
import javafx.scene.control.TreeItem;

public class TreeViewHelper
{
    public TreeViewHelper()
    {
    }

    // This method creates an ArrayList of TreeItems (data)
    public ArrayList<TreeItem> getData()
    {
        ArrayList<TreeItem> data = new ArrayList<TreeItem>();

        TreeItem schedule = new TreeItem("Schedule");
        schedule.getChildren().addAll(getSchedule());

        TreeItem destination = new TreeItem("Destination");
        destination.getChildren().addAll(getDestination());

        TreeItem numberOfStops = new TreeItem("Number of Stops");
        numberOfStops.getChildren().addAll(getNumberOfStops());

        // Business or Economy
        TreeItem price = new TreeItem("Price");
        price.getChildren().addAll(getPrices());

        TreeItem additionalInformation = new TreeItem("Additional Information");
        additionalInformation.getChildren().addAll(getAdditionalInformation());


        data.add(schedule);
        data.add(destination);
        data.add(numberOfStops);
        data.add(price);
        data.add(additionalInformation);

        return data;
    }

    private ArrayList<TreeItem> getSchedule()
    {
        ArrayList<TreeItem> schedule = new ArrayList<TreeItem>();

        TreeItem day = new TreeItem("Day");
        TreeItem departure = new TreeItem("Departure");
        TreeItem arrival = new TreeItem("Arrival");
        TreeItem duration = new TreeItem("Duration");

        schedule.add(day);
        schedule.add(departure);
        schedule.add(arrival);
        schedule.add(duration);

        return schedule;
    }

    private ArrayList<TreeItem> getDestination()
    {
        ArrayList<TreeItem> destination = new ArrayList<TreeItem>();

        TreeItem departure = new TreeItem("Departure");
        TreeItem arrival = new TreeItem("Arrival");

        destination.add(departure);
        destination.add(arrival);

        return destination;
    }

    private ArrayList<TreeItem> getNumberOfStops()
    {
        ArrayList<TreeItem> schedule = new ArrayList<TreeItem>();

        TreeItem departure = new TreeItem("Departure");
        TreeItem arrival = new TreeItem("Arrival");

        schedule.add(departure);
        schedule.add(arrival);

        return schedule;
    }

    private ArrayList<TreeItem> getPrices()
    {
        ArrayList<TreeItem> price = new ArrayList<TreeItem>();

        TreeItem ecoOrBuis;

        // TODO
        if (true) {
             ecoOrBuis = new TreeItem("Economy");
        }
         ecoOrBuis = new TreeItem("Business");

        price.add(ecoOrBuis);

        return price;
    }

    private ArrayList<TreeItem> getAdditionalInformation()
    {
        ArrayList<TreeItem> information = new ArrayList<TreeItem>();

        /// Current Status: Favorite <-> Open <-> Booked <-> Flought
        TreeItem status = new TreeItem("Current Status");
        TreeItem requestedServices = new TreeItem("Requested Services");
        TreeItem review = new TreeItem("Review:");

        information.add(status);
        information.add(requestedServices);
        information.add(review);

        return information;
    }

    }