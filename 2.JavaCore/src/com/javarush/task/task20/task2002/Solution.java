package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("c:\\tmp\\your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();

            user.setFirstName("Sergey");
            user.setLastName("Gey");
            user.setCountry(User.Country.OTHER);
            user.setMale(true);
            Date date = new Date(1998,5,21);
            user.setBirthDate(date);

            //  Второй пользователь
            User user1 = new User();

            user1.setFirstName("Roman");
            user1.setLastName("Bubnov");
            user1.setCountry(User.Country.OTHER);
            user1.setMale(false);
            Date date1 = new Date(1998,7,17);
            user1.setBirthDate(date1);

            //  Добавляем пользователей в список
            javaRush.users.add(user);
            javaRush.users.add(user1);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter p = new PrintWriter(outputStream);

            if (users.size()>0) {
                p.println("true");
                for(User user : users) {
                    if (user.getFirstName() != null ) {
                        p.println(user.getFirstName());
                    } else {
                        p.println("null");
                    }

                    if (user.getLastName() != null ) {
                        p.println(user.getLastName());
                    } else {
                        p.println("null");
                    }

                    if (user.getBirthDate() != null ) {
                        p.println(user.getBirthDate().getTime());
                    } else {
                        p.println("null");
                    }

                    p.println(user.isMale());

                    if (user.getCountry() != null ) {
                        p.println(user.getCountry().getDisplayName());
                    } else {
                        p.println("null");
                    }
                }
            } else {
                p.println("false");
            }

            p.flush();
            p.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            Boolean isEmpty = reader.readLine().equals("true") ? true : false;

            if (isEmpty) {
                while(reader.ready()) {
                    String firstName = reader.readLine();
                    String lastName = reader.readLine();
                    String birthDate = reader.readLine();
                    String isMale = reader.readLine();
                    String country = reader.readLine();
                    User user = new User();
                    if (!firstName.equals("null")) {
                        user.setFirstName(firstName);
                    }
                    if (!lastName.equals("null")) {
                        user.setLastName(lastName);
                    }
                    if (!birthDate.equals("null")) {
                        user.setBirthDate(new Date(Long.parseLong(birthDate)));
                    }
                    user.setMale(isMale.equals("true")? true : false);

                    if(!country.equals("null")) {
                        switch (country) {
                            case "Ukraine":
                                user.setCountry(User.Country.UKRAINE);
                                break;
                            case "Russia":
                                user.setCountry(User.Country.RUSSIA);
                                break;
                            case "Other":
                                user.setCountry(User.Country.OTHER);
                                break;
                        }
                    }

                    users.add(user);
                }
            }

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
