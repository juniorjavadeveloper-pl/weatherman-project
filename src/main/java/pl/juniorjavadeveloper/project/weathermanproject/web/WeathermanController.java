package pl.juniorjavadeveloper.project.weathermanproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.juniorjavadeveloper.project.weathermanproject.service.WeathermanManagerService;

@Controller
@RequestMapping(value = "/weatherman")
public class WeathermanController {
    private final WeathermanManagerService weathermanManagerService;

    public WeathermanController(WeathermanManagerService weathermanManagerService) {
        this.weathermanManagerService = weathermanManagerService;
    }

    // L - list
    public void list() {
    }
    // C - create
    public void create() {
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
