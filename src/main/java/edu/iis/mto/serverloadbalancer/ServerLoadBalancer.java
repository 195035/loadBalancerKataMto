package edu.iis.mto.serverloadbalancer;

public class ServerLoadBalancer {


	public void balance(Server[] servers, Vm[] vms) {
		for (Vm vm : vms) {
			Server leastLoaded = null;
			for(Server server : servers) {
				if(leastLoaded == null || server.currentLoadPecentage < leastLoaded.currentLoadPecentage) {
					leastLoaded = server;
				}
			}
			leastLoaded.addVm(vm);
		}

	}

}
