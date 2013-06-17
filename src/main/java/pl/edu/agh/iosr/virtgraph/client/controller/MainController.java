package pl.edu.agh.iosr.virtgraph.client.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.edu.agh.iosr.virtgraph.client.service.CommunicationService;
import pl.edu.agh.iosr.virtgraph.model.Host;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {

    @Autowired
    private CommunicationService commService;
    private static final Logger logger = LoggerFactory
            .getLogger(MainController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        System.out.println("Showing the main page.");
        List<Host> hl = commService.getHosts().getHosts();
        System.out.println("Retrieved list of hosts:");
        System.out.println(hl);
        model.addAttribute("hostlist", hl);
        return "hosts";
    }

    @RequestMapping(value = "/vms", method = RequestMethod.GET)
    public String vms(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "address", required = true) String hostAddress,
            Locale locale, Model model) {

        // add host name and address to the model
        System.out.println("Host name: " + name);
        System.out.println("Host address: " + hostAddress);

        model.addAttribute("vmlist", commService.getVMs(
        // new Host(name, hostAddress)).getVms());
                new Host(name, hostAddress)).getVms());
        model.addAttribute("hostAddr", hostAddress);
        return "vms";
    }

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public String services(
            @RequestParam(value = "address", required = true) String hostAddress,
            @RequestParam(value = "vmid", required = true) String vmid,
            Locale locale, Model model) {

        // add host name and address to the model
        System.out.println("Host address: " + hostAddress);
        System.out.println("Vm id: " + vmid);

        model.addAttribute("servicelist", commService.getServices(hostAddress,
                vmid).getServices());

        model.addAttribute("hostAddr", hostAddress);
        model.addAttribute("vmid", vmid);
        return "services";
    }

    /*
     * @RequestMapping(value = "/compare", method = RequestMethod.GET) public String compare(@RequestParam("input1")
     * String input1,
     * 
     * @RequestParam("input2") String input2, Model model) { int result = comparator.compare(input1, input2);
     * 
     * String inEnglish = (result < 0) ? "less than" : (result > 0 ? "greater than" : "equal to"); String output =
     * "According to our Comparator, '" + input1 + "' is " + inEnglish + "'" + input2 + "'";
     * 
     * model.addAttribute("output", output);
     * 
     * return "compareResult"; }
     */
}
