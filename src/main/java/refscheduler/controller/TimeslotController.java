package refscheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import refscheduler.domain.TimeslotCreate;
import refscheduler.domain.TimeslotGet;
import refscheduler.service.TimeslotService;

import javax.validation.Valid;

/**
 * Timeslot controller.
 */
@RestController
@RequestMapping(produces = "application/json")
public class TimeslotController {

    @Autowired
    private TimeslotService timeslotService;

    @RequestMapping(path = "/timeslot/{timeslotId}", method = RequestMethod.GET)
    public TimeslotGet findTimeslot(@PathVariable("timeslotId") final Long timeslotId) {
        return timeslotService.findTimeslot(timeslotId);
    }

    @RequestMapping(value = "/timeslot", method = RequestMethod.POST)
    public Long createTimeslot(@RequestBody @Valid final TimeslotCreate timeslotCreate) {
        return timeslotService.createTimeslot(timeslotCreate);
    }
}
