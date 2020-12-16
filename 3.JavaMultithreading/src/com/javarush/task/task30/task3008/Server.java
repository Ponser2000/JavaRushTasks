package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

  private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

  private static class Handler extends Thread {

    Socket socket;

    public Handler(Socket socket) {
      this.socket = socket;
    }

    private String serverHandshake(Connection connection)
        throws IOException, ClassNotFoundException {
      String userName;
      Message request = new Message(MessageType.NAME_REQUEST);
      Message answer;
      do {
        connection.send(request);
        answer = connection.receive();
        userName = answer.getData();

      } while ((answer.getType() != MessageType.USER_NAME) || userName.isEmpty() || connectionMap
          .containsKey(userName));
      connectionMap.put(userName, connection);
      connection.send(new Message(MessageType.NAME_ACCEPTED, "Ваше имя принято!"));
      return userName;
    }

    private void notifyUsers(Connection connection, String userName) throws IOException {
      for (Entry<String, Connection> connectionEntry : connectionMap.entrySet()) {
        Connection connect = connectionEntry.getValue();
        String user = connectionEntry.getKey();
        if (!user.equals(userName)) {
          connection.send(new Message(MessageType.USER_ADDED, user));
        }
      }
    }

    private void serverMainLoop(Connection connection, String userName)
        throws IOException, ClassNotFoundException {
      Message answer;
      while (true) {
        answer = connection.receive();
        if (answer.getType() == MessageType.TEXT) {
          String message = userName + ": " + answer.getData();
          sendBroadcastMessage(new Message(MessageType.TEXT, message));
        } else {
          ConsoleHelper.writeMessage("Error 404!");
        }
      }
    }

    
    @Override
    public void run() {
      ConsoleHelper.writeMessage(
          String.format("Получено соединение с %1s", socket.getRemoteSocketAddress()));
      String newUserName = "";
      try (Connection connection = new Connection(this.socket)) {
        newUserName = serverHandshake(connection);
        Message msgOutServer = new Message(MessageType.USER_ADDED, newUserName);
        sendBroadcastMessage(msgOutServer);
        notifyUsers(connection, newUserName);
        serverMainLoop(connection, newUserName);
      } catch (IOException e) {
        ConsoleHelper.writeMessage("IOException! При обмене данными с удаленным адресом");
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        ConsoleHelper
            .writeMessage("ClassNotFoundException! При обмене данными с удаленным адресом");
        e.printStackTrace();
      } finally {
        if (!newUserName.isEmpty()) {
          connectionMap.remove(newUserName);
          Message msgOutServer = new Message(MessageType.USER_REMOVED, newUserName);
          sendBroadcastMessage(msgOutServer);
        }
        ConsoleHelper.writeMessage("Соединение закрыто");
      }

    }
  }

  public static void sendBroadcastMessage(Message message) {
    for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
      String key = pair.getKey();
      Connection connection = pair.getValue();
      try {
        connection.send(message);
      } catch (IOException e) {
        System.out.println("Can't send message");
      }
    }
  }

  public static void main(String[] args) {
    int port = ConsoleHelper.readInt();
    ServerSocket server = null;

    try {
      server = new ServerSocket(port);
      System.out.println("Сервер запущен!");
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }

    try {
      Socket clientSocket = null;
      while (true) {
        clientSocket = server.accept();
        Handler handler = new Handler(clientSocket);
        handler.start();
      }
    } catch (Exception e) {
      e.printStackTrace();
      try {
        server.close();
      } catch (IOException ioException) {
        ioException.printStackTrace();
      }
    }
  }
}
