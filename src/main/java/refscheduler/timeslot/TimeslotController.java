package refscheduler.timeslot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Timeslot getTimeslot(@PathVariable("timeslotId") final Long timeslotId) {
        return timeslotService.getTimeslot(timeslotId);
    }

    @GetMapping(path = "/timeslots")
    public List<Timeslot> getAllTimeslots() {
        return timeslotService.getAllTimeslots();
    }

    @PostMapping(path = "/timeslot")
    public Long createTimeslot(@RequestBody @Valid final Timeslot timeslot) {
        return timeslotService.save(timeslot);
    }

    @DeleteMapping(path = "/timeslot/{timeslotId}")
    public void deleteTimeslot(@PathVariable("timeslotId") final Long timeslotId) {
        timeslotService.delete(timeslotId);
    }
}
