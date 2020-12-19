package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Sergey Ponomarev on 18.12.2020
 * @project JavaRushTasks/com.javarush.task.task27.task2712.ad
 */
public class AdvertisementManager {
  private final AdvertisementStorage storage;
  private int timeSeconds;
  private ArrayList<List<Advertisement>> bigList = new ArrayList<List<Advertisement>>();

  public AdvertisementManager(int timeSeconds) {
    storage = AdvertisementStorage.getInstance();
    this.timeSeconds = timeSeconds;
  }

  public void processVideos() throws NoVideoAvailableException{
    if (storage.list().isEmpty()) {
      throw new NoVideoAvailableException();
    }

  }

  private void permutate(ArrayList<Advertisement> list)
  {
    // Очищаем статический массив комбинаций
    bigList = new ArrayList<List<Advertisement>>();
    for (int i = 1; i < (int)(Math.pow(2,list.size())); i++)
    {
      // Текущая выборка
      List<Advertisement> curList = new ArrayList<>();

      // Строка - битовое поле, задающее номера элементов в списке элементов для текущей выборки
      // Для удобства переворачиваем ее
      String binaryField = Integer.toBinaryString(i).toString();
      while(binaryField.length() < list.size())
        binaryField = "0" + binaryField;
      binaryField = new StringBuffer(binaryField).reverse().toString();
      // Проходим строку от начала до конца
      // Индекс '1' - индикатор добавления элемента list.get(j) в тек. выборку
      for (int j = 0; j < binaryField.length(); j++)
      {
        if(binaryField.charAt(j) == '1')
        {
          // Добавляем текущий элемент в тек. выборку
          curList.add(list.get(j));
        }
      }
      // Тек. выборку собрали , перед добавлением в общий список проверим ,
      // не привышает ли она длительность заказа. Если превышает, то она нам не нужна
      if(getDurationOfList(curList) <= timeSeconds)
        bigList.add(curList);
    }
  }

  private static long getAmountOfList(List<Advertisement> list)
  {
    long res = 0;
    for(Advertisement a : list)
      res += a.getAmountPerOneDisplaying();
    return res;
  }

  private static int getDurationOfList(List<Advertisement> list)
  {
    int res = 0;
    for(Advertisement a : list)
      res += a.getDuration();
    return res;
  }
}
