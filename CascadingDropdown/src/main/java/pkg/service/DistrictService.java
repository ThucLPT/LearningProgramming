package pkg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pkg.entity.District;
import pkg.repository.DistrictRepository;

@Service
public class DistrictService {
	@Autowired
	private DistrictRepository districtRepository;

	public District findById(int id) {
		return districtRepository.findById(id).get();
	}
}
