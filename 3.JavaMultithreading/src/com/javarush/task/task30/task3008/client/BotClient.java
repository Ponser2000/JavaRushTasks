package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BotClient extends Client{
  public class BotSocketThread extends SocketThread{
    @Override
    protected void clientMainLoop() throws IOException, ClassNotFoundException {
      sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
      super.clientMainLoop();
    }

    @Override
    protected void processIncomingMessage(String message) throws IOException {
      ConsoleHelper.writeMessage(message);
      String[] s = message.split(": ");
      if (s.length != 2) return;
      String name = s[0];
      String sms = s[1];
      Calendar calendar = new GregorianCalendar();
      Date date = calendar.getTime();

      if (sms.equals("дата")) {
        SimpleDateFormat sdf = new SimpleDateFormat("d.MM.YYYY");
        String m = sdf.format(date);
        sendTextMessage("Информация для " + name + ":" + " "+ m);
      }
      if (sms.equals("день")) {
        SimpleDateFormat sdf = new SimpleDateFormat("d");
        String m = sdf.format(date);
        sendTextMessage("Информация для " + name + ":" +" "+ m);
      }
      if (sms.equals("месяц")) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
        String m = sdf.format(date);
        sendTextMessage("Информация для " + name + ":" +" "+ m);
      }
      if (sms.equals("год")) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
        String m = sdf.format(date);
        sendTextMessage("Информация для " + name + ":" +" "+ m);
      }
      if (sms.equals("время")) {
        SimpleDateFormat sdf = new SimpleDateFormat("H:mm:ss");
        String m = sdf.format(date);
        sendTextMessage("Информация для " + name + ":" +" "+ m);
      }
      if (sms.equals("час")) {
        SimpleDateFormat sdf = new SimpleDateFormat("H");
        String m = sdf.format(date);
        sendTextMessage("Информация для " + name + ":" +" "+ m);
      }
      if (sms.equals("минуты")) {
        SimpleDateFormat sdf = new SimpleDateFormat("m");
        String m = sdf.format(date);
        sendTextMessage("Информация для " + name + ":" +" "+ m);
      }
      if (sms.equals("секунды")) {
        SimpleDateFormat sdf = new SimpleDateFormat("s");
        String m = sdf.format(date);
        sendTextMessage("Информация для " + name + ":" +" "+ m);
      }
    }

  }

  protected SocketThread getSocketThread() {
    BotSocketThread botSocketThread = new BotSocketThread();
    return botSocketThread;
  }

  protected boolean shouldSendTextFromConsole() {
    return false;
  }

  protected String getUserName() {
    return String.format("date_bot_%d", (int) (Math.random() * 100));
  }

  public static void main(String[] args) {
    BotClient botClient = new BotClient();
    botClient.run();
  }

}
