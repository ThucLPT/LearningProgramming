package pkg.init;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.stereotype.Component;

import pkg.entity.Event;
import pkg.repo.EventRepo;

@Component
public class EventInit implements ApplicationRunner {
	@Autowired
	private EventRepo eventRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Event event = new Event();
		event.setTitle("Event");
		event.setStart(LocalDate.now().plusDays(1));
		event.setEnd(LocalDate.now().plusDays(5));
		eventRepo.save(event);
	}
}
