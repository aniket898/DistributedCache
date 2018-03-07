package com.aniket.distributed.local.cache.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaxiRide {

    private int taxi_id;
    private String trip_start_timestamp;
    private String trip_end_timestamp;
    private int trip_seconds;
    private Float trip_miles;
    private int pickup_census_tract;
    private int dropoff_census_tract;
    private int pickup_community_area;
    private int dropoff_community_area;
    private Float fare;
    private Float tips;
    private Float tolls;
    private Float extras;
    private Float trip_total;
    private String payment_type;
    private int company;
    private int pickup_latitude;
    private int pickup_longitude;
    private String pickup_location;
    private int dropoff_latitude;
    private int dropoff_longitude;
    private String dropoff_location;


    public int getTaxi_id() {
        return taxi_id;
    }

    public void setTaxi_id(int taxi_id) {
        this.taxi_id = taxi_id;
    }

    public String getTrip_start_timestamp() {
        return trip_start_timestamp;
    }

    public void setTrip_start_timestamp(String trip_start_timestamp) {
        this.trip_start_timestamp = trip_start_timestamp;
    }

    public String getTrip_end_timestamp() {
        return trip_end_timestamp;
    }

    public void setTrip_end_timestamp(String trip_end_timestamp) {
        this.trip_end_timestamp = trip_end_timestamp;
    }

    public int getTrip_seconds() {
        return trip_seconds;
    }

    public void setTrip_seconds(int trip_seconds) {
        this.trip_seconds = trip_seconds;
    }

    public Float getTrip_miles() {
        return trip_miles;
    }

    public void setTrip_miles(Float trip_miles) {
        this.trip_miles = trip_miles;
    }

    public int getPickup_census_tract() {
        return pickup_census_tract;
    }

    public void setPickup_census_tract(int pickup_census_tract) {
        this.pickup_census_tract = pickup_census_tract;
    }

    public int getDropoff_census_tract() {
        return dropoff_census_tract;
    }

    public void setDropoff_census_tract(int dropoff_census_tract) {
        this.dropoff_census_tract = dropoff_census_tract;
    }

    public int getPickup_community_area() {
        return pickup_community_area;
    }

    public void setPickup_community_area(int pickup_community_area) {
        this.pickup_community_area = pickup_community_area;
    }

    public int getDropoff_community_area() {
        return dropoff_community_area;
    }

    public void setDropoff_community_area(int dropoff_community_area) {
        this.dropoff_community_area = dropoff_community_area;
    }

    public Float getFare() {
        return fare;
    }

    public void setFare(Float fare) {
        this.fare = fare;
    }

    public Float getTips() {
        return tips;
    }

    public void setTips(Float tips) {
        this.tips = tips;
    }

    public Float getTolls() {
        return tolls;
    }

    public void setTolls(Float tolls) {
        this.tolls = tolls;
    }

    public Float getExtras() {
        return extras;
    }

    public void setExtras(Float extras) {
        this.extras = extras;
    }

    public Float getTrip_total() {
        return trip_total;
    }

    public void setTrip_total(Float trip_total) {
        this.trip_total = trip_total;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public int getCompany() {
        return company;
    }

    public void setCompany(int company) {
        this.company = company;
    }

    public int getPickup_latitude() {
        return pickup_latitude;
    }

    public void setPickup_latitude(int pickup_latitude) {
        this.pickup_latitude = pickup_latitude;
    }

    public int getPickup_longitude() {
        return pickup_longitude;
    }

    public void setPickup_longitude(int pickup_longitude) {
        this.pickup_longitude = pickup_longitude;
    }

    public String getPickup_location() {
        return pickup_location;
    }

    public void setPickup_location(String pickup_location) {
        this.pickup_location = pickup_location;
    }

    public int getDropoff_latitude() {
        return dropoff_latitude;
    }

    public void setDropoff_latitude(int dropoff_latitude) {
        this.dropoff_latitude = dropoff_latitude;
    }

    public int getDropoff_longitude() {
        return dropoff_longitude;
    }

    public void setDropoff_longitude(int dropoff_longitude) {
        this.dropoff_longitude = dropoff_longitude;
    }

    public String getDropoff_location() {
        return dropoff_location;
    }

    public void setDropoff_location(String dropoff_location) {
        this.dropoff_location = dropoff_location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaxiRide taxiRide = (TaxiRide) o;

        if (taxi_id != taxiRide.taxi_id) return false;
        if (trip_seconds != taxiRide.trip_seconds) return false;
        if (pickup_census_tract != taxiRide.pickup_census_tract) return false;
        if (dropoff_census_tract != taxiRide.dropoff_census_tract) return false;
        if (pickup_community_area != taxiRide.pickup_community_area) return false;
        if (dropoff_community_area != taxiRide.dropoff_community_area) return false;
        if (company != taxiRide.company) return false;
        if (pickup_latitude != taxiRide.pickup_latitude) return false;
        if (pickup_longitude != taxiRide.pickup_longitude) return false;
        if (dropoff_latitude != taxiRide.dropoff_latitude) return false;
        if (dropoff_longitude != taxiRide.dropoff_longitude) return false;
        if (trip_start_timestamp != null ? !trip_start_timestamp.equals(taxiRide.trip_start_timestamp) : taxiRide.trip_start_timestamp != null)
            return false;
        if (trip_end_timestamp != null ? !trip_end_timestamp.equals(taxiRide.trip_end_timestamp) : taxiRide.trip_end_timestamp != null)
            return false;
        if (trip_miles != null ? !trip_miles.equals(taxiRide.trip_miles) : taxiRide.trip_miles != null) return false;
        if (fare != null ? !fare.equals(taxiRide.fare) : taxiRide.fare != null) return false;
        if (tips != null ? !tips.equals(taxiRide.tips) : taxiRide.tips != null) return false;
        if (tolls != null ? !tolls.equals(taxiRide.tolls) : taxiRide.tolls != null) return false;
        if (extras != null ? !extras.equals(taxiRide.extras) : taxiRide.extras != null) return false;
        if (trip_total != null ? !trip_total.equals(taxiRide.trip_total) : taxiRide.trip_total != null) return false;
        if (payment_type != null ? !payment_type.equals(taxiRide.payment_type) : taxiRide.payment_type != null)
            return false;
        if (pickup_location != null ? !pickup_location.equals(taxiRide.pickup_location) : taxiRide.pickup_location != null)
            return false;
        return dropoff_location != null ? dropoff_location.equals(taxiRide.dropoff_location) : taxiRide.dropoff_location == null;
    }

    @Override
    public int hashCode() {
        int result = taxi_id;
        result = 31 * result + (trip_start_timestamp != null ? trip_start_timestamp.hashCode() : 0);
        result = 31 * result + (trip_end_timestamp != null ? trip_end_timestamp.hashCode() : 0);
        result = 31 * result + trip_seconds;
        result = 31 * result + (trip_miles != null ? trip_miles.hashCode() : 0);
        result = 31 * result + pickup_census_tract;
        result = 31 * result + dropoff_census_tract;
        result = 31 * result + pickup_community_area;
        result = 31 * result + dropoff_community_area;
        result = 31 * result + (fare != null ? fare.hashCode() : 0);
        result = 31 * result + (tips != null ? tips.hashCode() : 0);
        result = 31 * result + (tolls != null ? tolls.hashCode() : 0);
        result = 31 * result + (extras != null ? extras.hashCode() : 0);
        result = 31 * result + (trip_total != null ? trip_total.hashCode() : 0);
        result = 31 * result + (payment_type != null ? payment_type.hashCode() : 0);
        result = 31 * result + company;
        result = 31 * result + pickup_latitude;
        result = 31 * result + pickup_longitude;
        result = 31 * result + (pickup_location != null ? pickup_location.hashCode() : 0);
        result = 31 * result + dropoff_latitude;
        result = 31 * result + dropoff_longitude;
        result = 31 * result + (dropoff_location != null ? dropoff_location.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TaxiRide{" +
                "taxi_id=" + taxi_id +
                ", trip_start_timestamp='" + trip_start_timestamp + '\'' +
                ", trip_end_timestamp='" + trip_end_timestamp + '\'' +
                ", trip_seconds=" + trip_seconds +
                ", trip_miles=" + trip_miles +
                ", pickup_census_tract=" + pickup_census_tract +
                ", dropoff_census_tract=" + dropoff_census_tract +
                ", pickup_community_area=" + pickup_community_area +
                ", dropoff_community_area=" + dropoff_community_area +
                ", fare=" + fare +
                ", tips=" + tips +
                ", tolls=" + tolls +
                ", extras=" + extras +
                ", trip_total=" + trip_total +
                ", payment_type='" + payment_type + '\'' +
                ", company=" + company +
                ", pickup_latitude=" + pickup_latitude +
                ", pickup_longitude=" + pickup_longitude +
                ", pickup_location='" + pickup_location + '\'' +
                ", dropoff_latitude=" + dropoff_latitude +
                ", dropoff_longitude=" + dropoff_longitude +
                ", dropoff_location='" + dropoff_location + '\'' +
                '}';
    }
}
