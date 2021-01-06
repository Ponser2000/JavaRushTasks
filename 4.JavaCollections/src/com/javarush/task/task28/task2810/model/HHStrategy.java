package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Sergey Ponomarev on 05.01.2021
 * @project JavaRushTasks/com.javarush.task.task28.task2810.model
 */

// https://grc.ua/search/vacancy?L_is_autosearch=false&area=5&clusters=true&enable_snippets=true&text=java+Kiev&page=1

public class HHStrategy implements Strategy{

  private static final String URL_FORMAT = "https://hh.ru/search/vacancy?text=java+%s&page=%d";

  private static final String LINK = String.format(URL_FORMAT, "Краснодар", 0);

  @Override
  public List<Vacancy> getVacancies(String searchString) throws IOException {
    List<Vacancy> allVacancies = new ArrayList<>();

    int page = 0;
      do {
        Document doc = getDocument(searchString, page);

        Elements vacanciesHtmlList = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");

        if (vacanciesHtmlList.isEmpty()) break;

        for (Element element : vacanciesHtmlList) {
          Elements links = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title");
          Elements locations = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address");
          Elements companyName = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer");
          Elements salary = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation");

          Vacancy vacancy = new Vacancy();
          vacancy.setSiteName("hh.ru");
          vacancy.setTitle(links.get(0).text());
          vacancy.setUrl(links.get(0).attr("href"));
          vacancy.setCity(locations.get(0).text());
          vacancy.setCompanyName(companyName.get(0).text());
          vacancy.setSalary(salary.size() > 0 ? salary.get(0).text() : "");

          allVacancies.add(vacancy);
        }

        page++;
      } while (true);
    return allVacancies;
  }

  protected Document getDocument(String searchString, int page) throws IOException {
    return Jsoup.connect(String.format(URL_FORMAT, searchString, page))
        .referrer("https://hh.ru/")
        .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
        .get();
  }
}
