package com.javarush.task.task30.task3008;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

public class Connection implements Closeable {
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public Connection(Socket socket) {

        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        this.socket = socket;
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.out = out;
        this.in = in;


    }

    public void send(Message message) throws IOException {
        synchronized (this.out) {
            this.out.writeObject(message);
            this.out.flush();
        }
    }

    public Message receive() throws IOException, ClassNotFoundException {
        synchronized (this.in) {
            return  (Message) this.in.readObject();
        }
    }

    public SocketAddress getRemoteSocketAddress(){
        return this.socket.getRemoteSocketAddress();
    }

    public void close() throws IOException{
        this.out.close();
        this.in.close();
        this.socket.close();
    }


}
