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

    @RequestMapping(path = "/timeslot/{timeslotId}", method = RequestMethod.GET)
    public TimeslotGet getTimeslot(@PathVariable("timeslotId") final Long timeslotId) {
        return timeslotService.getTimeslot(timeslotId);
    }

    @RequestMapping(path = "/timeslots", method = RequestMethod.GET)
    public List<TimeslotGet> getAllTimeslots() {
        return timeslotService.getAllTimeslots();
    }

    @RequestMapping(value = "/timeslot", method = RequestMethod.POST)
    public Long createTimeslot(@RequestBody @Valid final TimeslotCreate timeslotCreate) {
        return timeslotService.createTimeslot(timeslotCreate);
    }
}
