package pkg.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pkg.dto.EventDto;
import pkg.service.EventService;

@RestController
public class EventRest {
	@Autowired
	private EventService eventService;

	@GetMapping("api")
	public List<EventDto> findAll() {
		return eventService.FindAll();
	}
}
