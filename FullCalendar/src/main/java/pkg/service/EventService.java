package pkg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pkg.dto.EventDto;
import pkg.entity.Event;
import pkg.repo.EventRepo;

@Service
public class EventService {
	@Autowired
	private EventRepo eventRepo;

	public List<EventDto> FindAll() {
		List<EventDto> list = new ArrayList<EventDto>();
		for (Event event : eventRepo.findAll())
			list.add(event.toDto());
		return list;
	}

	public List<Event> findAll() {
		return eventRepo.findAll();
	}

	public Event findById(int id) {
		return eventRepo.findById(id).get();
	}

	public void save(Event event) {
		eventRepo.save(event);
	}

	public void deleteById(int id) {
		eventRepo.deleteById(id);
	}
}
