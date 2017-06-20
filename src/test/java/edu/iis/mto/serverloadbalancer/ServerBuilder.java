package edu.iis.mto.serverloadbalancer;

public class ServerBuilder implements Builder<Server> {

	private int capacity;
	private double currentLoad;

	public ServerBuilder withCapacity(int capacity) {
		this.capacity = capacity;
		return this;
	}

	public Server build() {
		Server server = new Server(capacity);
		if(currentLoad > 0) {
			// x / capacity = load; x = load * capacity
			Vm vm = new VmBuilder().ofSize( (int)(currentLoad * capacity) / 100).build();
			server.addVm(vm);
		}
		return server;
	}

	public static ServerBuilder server() {
		return new ServerBuilder();
	}

	public Builder<Server> withCurrentLoadOf(double currentLoad) {
		this.currentLoad = currentLoad;
		return this;
	}
}
