package ch06;

public class Client2 {

    private String host;

    public void setHost(String host) {
        this.host = host;
    }

    public void connect() {
        System.out.println("Client2.connect() executed...");
    }

    public void send() {
        System.out.println("Client2.send() to "+host);
    }

    public void close() {
        System.out.print("I'm dying too!!");
    }
}
