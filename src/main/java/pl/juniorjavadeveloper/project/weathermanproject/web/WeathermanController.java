package pl.juniorjavadeveloper.project.weathermanproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.juniorjavadeveloper.project.weathermanproject.service.WeathermanService;

@Controller
@RequestMapping(value = "/weatherman")
public class WeathermanController {
    private final WeathermanService weathermanService;

    public WeathermanController(WeathermanService weathermanService) {
        this.weathermanService = weathermanService;
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
