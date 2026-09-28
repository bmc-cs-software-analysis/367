public class Lab03Tests {

  public static void testCity() {
    City city = new City("Philly", 100000);
    assert city.getName().equals("Philly");
    assert city.getPopulation() == 100000;
    assert city.toString().equals("Philly (100000 pop)");

  }

  public static void testEmptyCitySLL() {
    CitySLL list = new CitySLL();
    assert list.isEmpty();
    assert list.size() == 0;
    assert list.first() == null;
    assert list.last() == null;
    assert list.toString().equals(""); 
  }
    
  public static void testInsertCitySLL() {
    CitySLL list = new CitySLL();
    City tmp1 = new City("a", 1);
    list.insertFirst(tmp1);
    assert list.first() == tmp1;
    assert list.last() == tmp1;
    assert list.isEmpty() == false;
    assert list.size() == 1;

    char cityName = 'b';
    City firstCity = new City("name", 0);;
    for (int i = 2; i < 11; i++) {
      firstCity = new City(cityName + "", i);
      list.insertFirst(firstCity);
      assert list.first().getName().equals(cityName + "");
      assert list.first().getPopulation() == i;
      assert list.size() == i;
      cityName += 1;
    }

    City lastCity = new City("name", 0);
    for (int i = 11; i < 22; i++) {
      lastCity = new City(cityName + "", i);
      list.insertBack(lastCity);
      assert list.last().getName().equals(cityName + "");
      assert list.last().getPopulation() == i;
      assert list.size() == i;
      cityName += 1;
    }

    assert list.first() == firstCity;
    assert list.last() == lastCity;
  }

  public static void testCitySLLString() {
    CitySLL list = new CitySLL();
    char name = '?';
    for (int i = 0; i < 2; i++) {
      list.insertFirst(new City(name + "", i));
      if (i == 0) {
        assert list.toString().equals("? (0 pop)");
      } else {
        assert list.toString().equals("D (1 pop), ? (0 pop)");
      }
      name += 5;
    }
  }

  public static void testEmptyCityDLL() {
    CityDLL list = new CityDLL();
    assert list.isEmpty();
    assert list.size() == 0;
    assert list.first() == null;
    assert list.last() == null;
    assert list.toString().equals(""); 
  }

  public static void testInsertCityDLL() {
    CityDLL list = new CityDLL();
    City tmp1 = new City("a", 1);
    list.insertFirst(tmp1);
    assert list.first() == tmp1;
    assert list.last() == tmp1;
    assert list.isEmpty() == false;
    assert list.size() == 1;

    char cityName = 'b';
    City firstCity = new City("name", 0);;
    for (int i = 2; i < 11; i++) {
      firstCity = new City(cityName + "", i);
      list.insertFirst(firstCity);
      assert list.first().getName().equals(cityName + "");
      assert list.first().getPopulation() == i;
      assert list.size() == i;
      cityName += 1;
    }

    City lastCity = new City("name", 0);
    for (int i = 11; i < 22; i++) {
      lastCity = new City(cityName + "", i);
      list.insertBack(lastCity);
      assert list.last().getName().equals(cityName + "");
      assert list.last().getPopulation() == i;
      assert list.size() == i;
      cityName += 1;
    }

    assert list.first() == firstCity;
    assert list.last() == lastCity;
  }

  public static void testCityDLLString() {
    CityDLL list = new CityDLL();
    char name = '?';
    for (int i = 0; i < 2; i++) {
      list.insertFirst(new City(name + "", i));
      if (i == 0) {
        assert list.toString().equals("? (0 pop)");
      } else {
        assert list.toString().equals("D (1 pop), ? (0 pop)");
      }
      name += 5;
    }
  }

  public static void testInsertSortedCityDLL() {
    CityDLL list = new CityDLL();
    list.insertSortedAlpha(new City("Merion", 0));
    assert list.size() == 1;
    list.insertSortedAlpha(new City("Ardmore", 0));
    assert list.size() == 2;
    list.insertSortedAlpha(new City("Wayne", 0));
    assert list.size() == 3;
    assert list.toString().equals("Ardmore (0 pop), Merion (0 pop), Wayne (0 pop)");

    list = new CityDLL();
    list.insertSortedAlpha(new City("Ardmore", 0));
    assert list.size() == 1;
    list.insertSortedAlpha(new City("Merion", 0));
    assert list.size() == 2;
    list.insertSortedAlpha(new City("Wayne", 0));
    assert list.size() == 3;
    assert list.toString().equals("Ardmore (0 pop), Merion (0 pop), Wayne (0 pop)");

    list = new CityDLL();
    list.insertSortedAlpha(new City("Wayne", 0));
    assert list.size() == 1;
    list.insertSortedAlpha(new City("Merion", 0));
    assert list.size() == 2;
    list.insertSortedAlpha(new City("Ardmore", 0));
    assert list.size() == 3;
    assert list.toString().equals("Ardmore (0 pop), Merion (0 pop), Wayne (0 pop)");

    list = new CityDLL();
    list.insertSortedPop(new City("Dallas", 9));
    list.insertSortedPop(new City("Miami", 3));
    list.insertSortedPop(new City("New York", 7));
    assert list.toString().equals("Miami (3 pop), New York (7 pop), Dallas (9 pop)");

    list = new CityDLL();
    list.insertSortedPop(new City("Miami", 3));
    list.insertSortedPop(new City("New York", 7));
    list.insertSortedPop(new City("Dallas", 9));
    assert list.toString().equals("Miami (3 pop), New York (7 pop), Dallas (9 pop)");

    list = new CityDLL();
    list.insertSortedPop(new City("Dallas", 9));
    list.insertSortedPop(new City("New York", 7));
    list.insertSortedPop(new City("Miami", 3));
    assert list.toString().equals("Miami (3 pop), New York (7 pop), Dallas (9 pop)");
  }


  public static void main(String[] args) {
    testCity();
    System.out.println("City tests passes!");

    testEmptyCitySLL();
    System.out.println("Empty CitySLL tests passes!");

    testInsertCitySLL();
    System.out.println("Insert CitySLL tests passes!");

    testCitySLLString();
    System.out.println("toString CitySLL tests passes!");
    System.out.println();

    testEmptyCityDLL();
    System.out.println("Empty CityDLL tests passes!");

    testInsertCityDLL();
    System.out.println("Insert CityDLL tests passes!");

    testCityDLLString();
    System.out.println("toString CityDLL tests passes!");

    testInsertSortedCityDLL();
    System.out.println("Insert Sorted CityDLL tests passes!");

  }

}
