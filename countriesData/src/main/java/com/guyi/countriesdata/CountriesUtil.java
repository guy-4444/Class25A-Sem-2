package com.guyi.countriesdata;

import java.util.ArrayList;
import java.util.Collections;

public class CountriesUtil {

    public static ArrayList<String> getCountriesNames() {
        ArrayList<Country> countriesModels = DataManager.generateCountriesDataArrayList();
        ArrayList<String> arr = new ArrayList<>();
        for (Country countriesModel : countriesModels) {
            arr.add(countriesModel.getName());
        }
        Collections.sort(arr);
        return arr;
    }

    public static String getCurrency(String countryName) {
        ArrayList<Country> countriesModels = DataManager.generateCountriesDataArrayList();
        for (Country country : countriesModels) {
            if (country.getName().equals(countryName)) {
                return country.getCurrencyName() + " (" + country.getCurrencySymbol() + ")";
            }
        }

        return "";
    }
}
