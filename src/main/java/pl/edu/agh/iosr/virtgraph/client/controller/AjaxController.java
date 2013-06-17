package pl.edu.agh.iosr.virtgraph.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.edu.agh.iosr.virtgraph.client.service.CommunicationService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AjaxController {

    @Autowired
    private CommunicationService commService;
    private static final Logger logger = LoggerFactory
            .getLogger(AjaxController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */

    @RequestMapping(value = "/startvm", method = RequestMethod.POST)
    public @ResponseBody
    Boolean startvm(@RequestParam(value = "vmid", required = true) String vmid,
            @RequestParam(value = "hostAddr", required = true) String hostAddr,
            Model model) {
        System.out.println("The host address is:" + hostAddr);
        return commService.startVm(vmid);
    }

    /*
     * @RequestMapping(value = "/startvm", method = RequestMethod.POST) public @ResponseBody Integer home(Model model) {
     * return 1; }
     */
    @RequestMapping(value = "/startvm", method = RequestMethod.GET)
    public String test(Model model) {
        return "empty";
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
