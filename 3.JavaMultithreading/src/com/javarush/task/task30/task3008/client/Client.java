package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

  protected Connection connection;
  private volatile boolean clientConnected = false;

  public class SocketThread extends Thread {

    protected void processIncomingMessage(String message) throws IOException {
      ConsoleHelper.writeMessage(message);
    }


    protected void informAboutAddingNewUser(String userName) {
      ConsoleHelper.writeMessage("Пользователь с ником " + userName + " присоединился к чату");
    }

    protected  void informAboutDeletingNewUser(String userName){
      ConsoleHelper.writeMessage("Пользователь с ником " + userName + " покинул чат");
    }

    protected void notifyConnectionStatusChanged(boolean clientConnected){
      synchronized (Client.this)
      {
        Client.this.clientConnected=clientConnected;
        Client.this.notify();
      }
    }

    protected void clientHandshake() throws IOException, ClassNotFoundException{
      Message message;
      while (!clientConnected) {
        message = connection.receive();
        if (message.getType() == MessageType.NAME_REQUEST) {
          connection.send(new Message(MessageType.USER_NAME, getUserName()));
        } else {
          if (message.getType() == MessageType.NAME_ACCEPTED) {
            notifyConnectionStatusChanged(true);
            break;
          } else {
            throw new IOException("Unexpected MessageType");
          }
        }
      }
    }

    protected void clientMainLoop() throws IOException, ClassNotFoundException{
      while(true) {
        Message message = connection.receive();
        if (message.getType() == null) {
          throw new IOException("Unexpected MessageType");
        }
        switch (message.getType()) {
          case TEXT: {
            processIncomingMessage(message.getData());
            break;
          }
          case USER_ADDED: {
            informAboutAddingNewUser(message.getData());
            break;
          }
          case USER_REMOVED: {
            informAboutDeletingNewUser(message.getData());
            break;
          }
          default: {
            throw new IOException("Unexpected MessageType");
          }
        }
      }
    }

    public void run(){
      String address = getServerAddress();
      int port = getServerPort();
      Socket socket = null;

      try {
        socket = new Socket(address,port);
        connection = new Connection(socket);
        clientHandshake();
        clientMainLoop();

      } catch (IOException | ClassNotFoundException e) {
        notifyConnectionStatusChanged(false);
      }
    }

  }


  public void run() {
    SocketThread socketThread = getSocketThread();
    socketThread.setDaemon(true);
    socketThread.start();
    try {
      synchronized (this) {
        this.wait();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
      ConsoleHelper.writeMessage("При работе клиента возникла ошибка");
    }
    if (clientConnected) {
      ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду ‘exit’.");
    } else {
      ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
    }
    while (clientConnected) {
      String line = ConsoleHelper.readString();
      if (line.equals("exit")) {
        break;
      }
      if (shouldSendTextFromConsole()) {
        sendTextMessage(line);
      }
    }


  }

  protected String getServerAddress() {
    return ConsoleHelper.readString();
  }

  protected int getServerPort() {
    return ConsoleHelper.readInt();
  }

  protected String getUserName() {
    return ConsoleHelper.readString();
  }

  protected boolean shouldSendTextFromConsole() {
    return true;
  }

  protected SocketThread getSocketThread() {
    SocketThread socketThread = new SocketThread();
    return socketThread;
  }

  protected void sendTextMessage(String text) {
    try {
      connection.send(new Message(MessageType.TEXT, text));
    } catch (IOException e) {
      e.printStackTrace();
      clientConnected = false;
    }
  }



  public static void main(String[] args) {
    Client client = new Client();
    client.run();
  }

}
