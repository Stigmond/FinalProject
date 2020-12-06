package com.skilldistillery.bbqueggle.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bbqueggle.entities.Pitmaster;
import com.skilldistillery.bbqueggle.repositories.PitmasterRepository;

@Service
public class PitmasterServiceImpl implements PitmasterService {

	@Autowired
	PitmasterRepository pitmasterRepo;

	@Override
	public List<Pitmaster> getAllPitmasters() {
		List<Pitmaster> allPitmasters = null;
		allPitmasters = pitmasterRepo.findAll();
		return allPitmasters;
	}

	@Override
	public Pitmaster getPitmasterById(Integer id) {
		Optional<Pitmaster> optPm = pitmasterRepo.findById(id);
		Pitmaster pitmaster = null;
		if (optPm.isPresent()) {
			pitmaster = optPm.get();
		}
		return pitmaster;
	}

	@Override
	public Pitmaster createPitmaster(Pitmaster newPitmaster) {
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
	public Pitmaster updatePitmaster(Integer id, Pitmaster pitmaster) {
		Pitmaster managedPitmaster = this.getPitmasterById(id);
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
	public boolean deletePitmaster(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
