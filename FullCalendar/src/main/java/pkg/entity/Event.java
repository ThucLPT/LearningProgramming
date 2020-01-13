package pkg.entity;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;
import pkg.dto.EventDto;

@Entity

@NoArgsConstructor
@Getter
@Setter
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate start;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate end;

	public EventDto toDto() {
		if (this.end == null)
			return EventDto.builder().id(this.id).title(this.title).start(this.start).build();
		return EventDto.builder().id(this.id).title(this.title).start(this.start).end(this.end.plusDays(1)).build();
	}
}
