package pkg.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Getter
@Builder
public class EventDto {
	private int id;
	private String title;
	private LocalDate start;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private LocalDate end;
}
