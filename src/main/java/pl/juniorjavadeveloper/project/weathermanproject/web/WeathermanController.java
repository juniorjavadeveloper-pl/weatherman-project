package pl.juniorjavadeveloper.project.weathermanproject.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.juniorjavadeveloper.project.weathermanproject.service.WeathermanManagerService;
import pl.juniorjavadeveloper.project.weathermanproject.web.model.LocationModel;
import pl.juniorjavadeveloper.project.weathermanproject.web.model.WeatherDataRequestModel;

import java.util.List;

@Controller
@RequestMapping(value = "/weatherman/locations")
public class WeathermanController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeathermanController.class);

    private final WeathermanManagerService weathermanManagerService;

    public WeathermanController(WeathermanManagerService weathermanManagerService) {
        this.weathermanManagerService = weathermanManagerService;
    }

    // L - list aka. listLocations()
    @GetMapping
    public String listView(ModelMap modelMap) {
        LOGGER.info("listView()");
        List<LocationModel> locations = weathermanManagerService.list();
        modelMap.addAttribute("locations", locations);
        return "weatherman/locations";
    }

    // C - create aka. addLocation(...)
    @GetMapping(value = "/add")
    public String createView() {
        LOGGER.info("createView()");
        return "weatherman/location-add";
    }

    @PostMapping(value = "/add")
    public String create(@ModelAttribute WeatherDataRequestModel weatherDataRequestModel) {
        LOGGER.info("create({})", weatherDataRequestModel);
        LocationModel createdLocationModel = weathermanManagerService.create(weatherDataRequestModel);
        return "redirect:/weatherman/locations";
    }

    // R - read
    public void read() {
    }

    // U - update
    public void update() {
    }

    // D - delete
    public void delete() {
    }
}
