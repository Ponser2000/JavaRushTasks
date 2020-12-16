package com.javarush.task.task30.task3008.client;

public class ClientGuiController extends Client {

  private ClientGuiModel model = new ClientGuiModel();
  private ClientGuiView view = new ClientGuiView(this);

  public class GuiSocketThread extends SocketThread {

    @Override
    protected void processIncomingMessage(String message) {
      if (message == null) {
        return;
      }
      model.setNewMessage(message);
      view.refreshMessages();
    }

    @Override
    protected void informAboutAddingNewUser(String userName) {
      model.addUser(userName);
      view.refreshUsers();
    }

    @Override
    public void informAboutDeletingNewUser(String userName) {
      model.deleteUser(userName);
      view.refreshUsers();
    }

    @Override
    public void notifyConnectionStatusChanged(boolean clientConnected) {
      super.notifyConnectionStatusChanged(clientConnected);
      view.notifyConnectionStatusChanged(clientConnected);
    }
  }

  protected SocketThread getSocketThread() {
    return new GuiSocketThread();
  }

  public void run() {
    getSocketThread().run();
  }

  protected String getServerAddress() {
    return view.getServerAddress();
  }

  protected int getServerPort() {
    return view.getServerPort();
  }

  protected String getUserName() {
    return view.getUserName();
  }

  public ClientGuiModel getModel() {
    return model;
  }

  public static void main(String... args) {
    new ClientGuiController().run();
  }

}
