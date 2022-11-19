package first;

import java.util.*;
import java.util.Scanner;

public class NumberOfProvinces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Country country = new Country();
        for (int i = 0; i < n; i++) {
            String[] cityList = sc.next().split(",");
            City city = new City(i);
            for (String item : cityList) {
                int c = Integer.parseInt(item);
                city.adjoinList.addLast(c);
            }
            country.cityList.add(city);
        }
        for (City city : country.cityList) {
            if (city.flag == -1) {
                country.check(city.cityIndex);
            }
        }
        System.out.println(country.provinceCount);
    }
}
class City {
    int cityIndex;
    LinkedList<Integer> adjoinList;

    public City(int cityIndex) {
        this.cityIndex = cityIndex;
        adjoinList = new LinkedList<>();
    }
    int flag = -1;
}
class Country {
    int provinceCount = 0;
    ArrayList<City> cityList;

    public Country() {
        this.cityList = new ArrayList<>();
    }

    void check(int cityIndex) {
        if (cityList.get(cityIndex).flag == -1) {
            cityList.get(cityIndex).flag = provinceCount++;

            for (Integer integer : cityList.get(cityIndex).adjoinList) {
                cityList.get(integer).flag = cityList.get(cityIndex).flag;
                check(integer);
            }
        }
    }
}
