package pl.edu.agh.iosr.virtgraph.client.service;

import java.net.URI;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.springframework.stereotype.Service;

import pl.edu.agh.iosr.virtgraph.model.Host;
import pl.edu.agh.iosr.virtgraph.model.HostList;
import pl.edu.agh.iosr.virtgraph.model.VMList;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@Service
public class CommunicationService {

    private WebResource serverService;
    private WebResource hypervisorService;

    private URI getBaseServerURI() {
        return UriBuilder.fromUri(
                "http://localhost:8080/virtgraph/hypervisor/test/").build();
    }

    private URI getBaseHypervisorURI() {
        return UriBuilder.fromUri(
                "http://localhost:8080/virtgraph/hypervisor/vms").build();
    }

    @PostConstruct
    private void init() {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        serverService = client.resource(getBaseServerURI());
        hypervisorService = client.resource(getBaseHypervisorURI());
    }

    public HostList getHosts() {
        return serverService.path("hostlist").accept(MediaType.APPLICATION_XML)
                .get(HostList.class);
    }

    public VMList getVMs(Host host) {
        return serverService.path("vmlist").accept(MediaType.APPLICATION_XML)
                .get(VMList.class);
    }

    public boolean startVm(String vmid) {
        System.out.println("Starting a virtual machine");
        System.out.println("The vmid is:" + vmid);
        System.out.println("Not implemented yet");
        return true;
    }
}
