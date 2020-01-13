package pkg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pkg.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {
	Tag findByText(String text);
}
