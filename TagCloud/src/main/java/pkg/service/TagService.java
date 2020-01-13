package pkg.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pkg.entity.Tag;
import pkg.repository.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository repository;

	public Tag save(Tag tag) {
		return repository.save(tag);
	}

	public List<Tag> findAll() {
		List<Tag> tags = new ArrayList<Tag>();
		for (Tag tag : repository.findAll()) {
			tags.add(tag);
		}
		int min = 0, max = 0;
		for (Tag tag : tags) {
			if (tag.getUse() < min)
				min = tag.getUse();
			if (tag.getUse() > max)
				max = tag.getUse();
		}
		double fontMin = 10, fontMax = 20;
		for (Tag tag : tags) {
			double weight = tag.getUse() == min ? fontMin : (tag.getUse() / (double) max) * (fontMax - fontMin) + fontMin;
			tag.setWeight(weight);
		}
		return tags;
	}

	public Tag findByText(String text) {
		return repository.findByText(text);
	}
}
