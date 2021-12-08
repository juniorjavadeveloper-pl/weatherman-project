package pl.juniorjavadeveloper.project.weathermanproject.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.juniorjavadeveloper.project.weathermanproject.service.WeathermanManagerService;
import pl.juniorjavadeveloper.project.weathermanproject.web.model.LocationModel;
import pl.juniorjavadeveloper.project.weathermanproject.web.model.WeatherDataRequestModel;

import javax.validation.Valid;
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
    public String createView(ModelMap modelMap) {
        LOGGER.info("createView()");
        modelMap.addAttribute("weatherDataRequestModel", new WeatherDataRequestModel());
        return "weatherman/location-add";
    }

    @PostMapping(value = "/add")
    public String create(@Valid @ModelAttribute WeatherDataRequestModel weatherDataRequestModel,
                         BindingResult bindingResult) {
        LOGGER.info("create({})", weatherDataRequestModel);
        if (bindingResult.hasErrors()) {
            LOGGER.info("create() validation error {}", bindingResult.getFieldErrors());
            return "weatherman/location-add";
        }
        LocationModel createdLocationModel = weathermanManagerService.create(weatherDataRequestModel);
        LOGGER.info("create(...) = {}", createdLocationModel);
        return "redirect:/weatherman/locations";
    }

    // R - read aka. currentWeather(...)
    @GetMapping(value = "/{id}/weather/current")
    public String read(@PathVariable Long id, ModelMap modelMap) {
        LOGGER.info("read({})", id);
        LocationModel locationModel = weathermanManagerService.read(id);
        modelMap.addAttribute("locationWeatherCurrent", locationModel);
        return "weatherman/weather-current";
    }

    // U - update
    public void update() {
    }

    // D - delete
    public void delete() {
    }
}
