package refscheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import refscheduler.domain.TimeslotCreate;
import refscheduler.domain.TimeslotGet;
import refscheduler.service.TimeslotService;

import javax.validation.Valid;
import java.util.List;

/**
 * Timeslot controller.
 */
@RestController
@RequestMapping(produces = "application/json")
public class TimeslotController {

    @Autowired
    private TimeslotService timeslotService;

    @GetMapping(path = "/timeslot/{timeslotId}")
    public TimeslotGet getTimeslot(@PathVariable("timeslotId") final Long timeslotId) {
        return timeslotService.getTimeslot(timeslotId);
    }

    @GetMapping(path = "/timeslots")
    public List<TimeslotGet> getAllTimeslots() {
        return timeslotService.getAllTimeslots();
    }

    @PostMapping(path = "/timeslot")
    public Long createTimeslot(@RequestBody @Valid final TimeslotCreate timeslotCreate) {
        return timeslotService.createTimeslot(timeslotCreate);
    }
}
