package edu.iis.mto.serverloadbalancer;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ServerLoadBalancerTest {
	@Test
	public void itCompiles() {
		assertThat(true, equalTo(true));
	}

	@Test
	public void balancingServer_noVms_ServerStaysEmpty() throws Exception {
		Server theServer = a(server().withCapacity(1));
		balancing(listOfServers(theServer), emptyListOfVM());
		assertThat(theServer, loadPercentage(0.0d));
	}

	private VM emptyListOfVM() {
		return VM[0];
	}

	private Server[] listOfServers(Server... theServer) {
		return theServer;
	}


	private Server a(ServerBuilder serverBuilder) {
		return serverBuilder.build();
	}


	private ServerBuilder server() {
		return new ServerBuilder();
	}
}
