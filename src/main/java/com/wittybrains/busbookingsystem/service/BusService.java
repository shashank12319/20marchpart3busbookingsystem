package com.wittybrains.busbookingsystem.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.wittybrains.busbookingsystem.dto.BusDTO;
import com.wittybrains.busbookingsystem.model.Bus;
import com.wittybrains.busbookingsystem.repository.BusRepository;

@Service
public class BusService {

	private final BusRepository busRepository;

	public BusService(BusRepository busRepository) {
		this.busRepository = busRepository;
	}

	public List<BusDTO> createBuses(List<BusDTO> busList) {
	    List<BusDTO> createdBuses = new ArrayList<>();

	    for (BusDTO busDTO : busList) {
	        Bus bus = new Bus();
	        bus.setDestination(busDTO.getDestination());
	        bus.setNumber(busDTO.getNumber());
	        bus.setSource(busDTO.getSource());
	        bus.setType(busDTO.getType());
	        bus.setTiming(busDTO.getTiming());

	        busRepository.save(bus);

	        createdBuses.add(new BusDTO());
	    }

	    return createdBuses;
	}
}
