package edu.iis.mto.serverloadbalancer;

/**
 * Created by 195035 on 25.04.2017.
 */
public class ServerBuilder {

    private int capacity;

    public ServerBuilder withCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public Server build() {
        return new Server(this.capacity);
    }
}
