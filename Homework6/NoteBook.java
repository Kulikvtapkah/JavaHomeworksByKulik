package Homework6;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class NoteBook {
    private String brand;
    private String color;
    private String OS;
    private Double screenSize;
    private int RAM;
    private int hardDriveSize;
    private int price;
    private boolean installment;

    public NoteBook(String brand,
            String color,
            String OS,
            Double screenSize,
            int RAM,
            int hardDriveSize,
            int price,
            boolean installment) {

        this.brand = brand;
        this.color = color;
        this.OS = OS;
        this.RAM = RAM;
        this.hardDriveSize = hardDriveSize;
        this.price = price;
        this.screenSize = screenSize;
        this.installment = installment;

    }

    public NoteBook(String brand,
            String color,
            String OS,
            Double screenSize,
            int RAM,
            int hardDriveSize,
            int price) {

        this.brand = brand;
        this.color = color;
        this.OS = OS;
        this.RAM = RAM;
        this.hardDriveSize = hardDriveSize;
        this.price = price;
        this.screenSize = screenSize;
        this.installment = false;

    }

    public NoteBook(String brand,
            String color,
            Double screenSize,
            int RAM,
            int hardDriveSize,
            int price) {

        this.brand = brand;
        this.color = color;
        this.OS = "no operating system";
        this.RAM = RAM;
        this.hardDriveSize = hardDriveSize;
        this.price = price;
        this.screenSize = screenSize;
        this.installment = false;

    }

    public NoteBook(String brand,
            String color,
            Double screenSize,
            int RAM,
            int hardDriveSize,
            int price,
            boolean installment) {

        this.brand = brand;
        this.color = color;
        this.OS = "no operating system";
        this.RAM = RAM;
        this.hardDriveSize = hardDriveSize;
        this.price = price;
        this.screenSize = screenSize;
        this.installment = installment;

    }

    @Override
    public String toString() {

        String parameters = "Brand: " + brand +
                "\ncolor: " + color +
                "\nScreen size: " + screenSize +
                "\nRAM memory: " + RAM + " GB" +
                "\nHard drive size: " + hardDriveSize + " GB" +
                "\nOperating system: " + OS +
                "\nPrice: " + price + " rub" +
                "\n" + this.getInstallment();

        return parameters;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public String getOS() {
        return OS;
    }

    public Double getScreenSize() {
        return screenSize;
    }

    public Integer getRAM() {
        return RAM;
    }

    public Integer getHardDriveSize() {
        return hardDriveSize;
    }

    public Integer getPrice() {
        return price;
    }

    public String getInstallment() {
        if (installment) {
            return "Installment is available";
        } else {
            return "Installment is inavailable";
        }

    }

    public boolean isMatch(HashMap<String, Object> filter) {

        TreeSet<String> stringFilter = new TreeSet<String>();

        if (filter.containsKey("brand")) {
            stringFilter.clear();
            stringFilter.addAll((TreeSet<String>) filter.get("brand"));
            if (!stringFilter.contains(this.brand)) {
                return false;
            }
        }
        if (filter.containsKey("color")) {
            stringFilter.clear();
            stringFilter.addAll((TreeSet<String>) filter.get("color"));
            if (!stringFilter.contains(this.color)) {
                return false;
            }
        }
        if (filter.containsKey("OS")) {
            stringFilter.clear();
            stringFilter.addAll((TreeSet<String>) filter.get("OS"));
            if (!stringFilter.contains(this.OS)) {
                return false;
            }
        }

        if (filter.containsKey("RAM")) {
            int[] numberFilter = (int[]) filter.get("RAM");
            if (!(this.RAM <= numberFilter[1] && this.RAM >= numberFilter[0])) {
                return false;
            }
        }
        if (filter.containsKey("hardDriveSize")) {
            int[] numberFilter = (int[]) filter.get("hardDriveSize");
            if (!(this.hardDriveSize <= numberFilter[1] && this.hardDriveSize >= numberFilter[0])) {
                return false;
            }
        }
        if (filter.containsKey("price")) {
            int[] numberFilter = (int[]) filter.get("price");
            if (!(this.price <= numberFilter[1] && this.price >= numberFilter[0])) {
                return false;
            }
        }
        if (filter.containsKey("screenSize")) {
            Double[] numberFilter = (Double[]) filter.get("screenSize");
            if (!(this.screenSize <= numberFilter[1] && this.screenSize >= numberFilter[0])) {
                return false;
            }
        }

        if (filter.containsKey("installment")) {
            if (this.installment == false) {
                return false;
            }
        }

        return true;
    }
}
