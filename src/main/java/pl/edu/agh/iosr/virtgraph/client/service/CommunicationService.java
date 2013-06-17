package pl.edu.agh.iosr.virtgraph.client.service;

import java.net.URI;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.springframework.stereotype.Service;

import pl.edu.agh.iosr.virtgraph.model.Host;
import pl.edu.agh.iosr.virtgraph.model.HostList;
import pl.edu.agh.iosr.virtgraph.model.ServiceList;
import pl.edu.agh.iosr.virtgraph.model.VMList;
import pl.edu.agh.iosr.virtgraph.model.VirtualMachine;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@Service
public class CommunicationService {

	private WebResource serverService;

	/* private WebResource hypervisorService; */

	private URI getBaseServerURI() {
		return UriBuilder.fromUri(
				"http://localhost:8080/virtgraph/hypervisor/test/").build();
	}

	/*
	 * private URI getBaseHypervisorURI() { return UriBuilder.fromUri(
	 * "http://localhost:8080/virtgraph/hypervisor/vms").build(); }
	 */
	@PostConstruct
	private void init() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		serverService = client.resource(getBaseServerURI());
		/* hypervisorService = client.resource(getBaseHypervisorURI()); */
	}

	public HostList getHosts() {
		return serverService.path("hostlist").accept(MediaType.APPLICATION_XML)
				.get(HostList.class);
	}

	public VMList getVMs(Host host) {
		return serverService.path("vmlist").accept(MediaType.APPLICATION_XML)
				.get(VMList.class);
	}

	public ServiceList getServices(String address, String vmid) {
		return serverService.path("servicelist")
				.accept(MediaType.APPLICATION_XML).get(ServiceList.class);
	}

	private VirtualMachine getVmById(Host host, String vmid) {
		for (VirtualMachine vm : getVMs(host).getVms()) {
			if (vm.getId().equals(vmid)) {
				return vm;
			}
		}
		return null;
	}

	private pl.edu.agh.iosr.virtgraph.model.Service getServiceByName(Host host,
			String vmid, String serviceName) {
		for (pl.edu.agh.iosr.virtgraph.model.Service service : getServices(
				host.getAddress(), vmid).getServices()) {
			if (service.getName().equals(serviceName)) {
				return service;
			}
		}
		return null;
	}

	public boolean toggleVm(String hostAddr, String vmid) {
		URI hypervisorUri = UriBuilder.fromUri(hostAddr).build();
		Client client = Client.create(new DefaultClientConfig());
		WebResource hypervisorService = client.resource(hypervisorUri);
		// FIXME!!!
		VirtualMachine vm = getVmById(new Host("fakename", hostAddr), vmid);
		vm.setRunning(!vm.isRunning());
		hypervisorService.path("vms").type(MediaType.APPLICATION_XML)
				.post(VirtualMachine.class, vm);
		return true;
	}

	public boolean toggleService(String hostAddr, String vmid,
			String serviceName) {
		URI hypervisorUri = UriBuilder.fromUri(hostAddr).build();
		Client client = Client.create(new DefaultClientConfig());
		WebResource hypervisorService = client.resource(hypervisorUri);
		// FIXME!!!
		pl.edu.agh.iosr.virtgraph.model.Service service = getServiceByName(
				new Host("fakename", hostAddr), vmid, serviceName);
		service.setStart(!service.isStart());
		hypervisorService.path("vms").path(vmid).path("services")
				.type(MediaType.APPLICATION_XML)
				.post(VirtualMachine.class, service);
		return true;
	}
}
