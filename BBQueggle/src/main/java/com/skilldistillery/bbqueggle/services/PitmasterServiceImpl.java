package com.skilldistillery.bbqueggle.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bbqueggle.entities.Pitmaster;
import com.skilldistillery.bbqueggle.entities.Restaurant;
import com.skilldistillery.bbqueggle.repositories.PitmasterRepository;
import com.skilldistillery.bbqueggle.repositories.RestaurantRepository;

@Service
public class PitmasterServiceImpl implements PitmasterService {

	@Autowired
	PitmasterRepository pitmasterRepo;
	@Autowired
	RestaurantRepository restaurantRepo;

	@Override
	public List<Pitmaster> getAllPitmasters() {
		List<Pitmaster> allPitmasters = null;
		allPitmasters = pitmasterRepo.findAll();
		return allPitmasters;
	}

	@Override
	public Pitmaster getPitmasterById(Integer id, String username) {
		Optional<Pitmaster> optPm = pitmasterRepo.findById(id);
		Pitmaster pitmaster = null;
		if (optPm.isPresent()) {
			pitmaster = optPm.get();
		}
		return pitmaster;
	}

	@Override
	public Pitmaster createPitmaster(Pitmaster newPitmaster, String username) {
		if (newPitmaster.getFirstName() == null) {
			newPitmaster.setFirstName("N/A");
		}
		if (newPitmaster.getLastName() == null) {
			newPitmaster.setLastName("N/A");
		}
		if (newPitmaster.getDescription() == null) {
			newPitmaster.setDescription("N/A");
		}
		if (newPitmaster.getImage() == null) {
			newPitmaster.setImage(
					"https://png.pngtree.com/png-clipart/20191120/original/pngtree-pig-chef-png-image_5084868.jpg");
		}

		pitmasterRepo.saveAndFlush(newPitmaster);
		return newPitmaster;
	}

	@Override
	public Pitmaster updatePitmaster(Integer id, Pitmaster pitmaster, String username) {
		Pitmaster managedPitmaster = this.getPitmasterById(id, username);
		if (managedPitmaster == null) {
			return null;
		}
		if (pitmaster.getFirstName() != null) {
			managedPitmaster.setFirstName(pitmaster.getFirstName());
		}
		if (pitmaster.getLastName() != null) {
			managedPitmaster.setLastName(pitmaster.getLastName());
		}
		if (pitmaster.getDescription() != null) {
			managedPitmaster.setDescription(pitmaster.getDescription());
		}
		if (pitmaster.getImage() != null) {
			managedPitmaster.setImage(pitmaster.getImage());
		}
		pitmasterRepo.saveAndFlush(managedPitmaster);

		return managedPitmaster;
	}

	@Override
	public boolean deletePitmaster(Integer id, String username) {
		boolean deleted = false;
		Restaurant restaurant = restaurantRepo.findByPitmaster_Id(id);
		if (restaurant != null) {
			restaurant.setPitmaster(null);
//			restaurantRepo.saveAndFlush(restaurant);
		}
		Pitmaster pitmasterToDelete = this.getPitmasterById(id, username);
		if (pitmasterToDelete != null) {
			pitmasterRepo.delete(pitmasterToDelete);
			deleted = true;
		}
		return deleted;
	}

}
