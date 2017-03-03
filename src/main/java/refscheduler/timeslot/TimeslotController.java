package refscheduler.timeslot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
