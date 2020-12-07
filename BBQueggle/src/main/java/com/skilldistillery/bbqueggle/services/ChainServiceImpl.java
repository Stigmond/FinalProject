package com.skilldistillery.bbqueggle.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bbqueggle.entities.Chain;
import com.skilldistillery.bbqueggle.entities.Style;
import com.skilldistillery.bbqueggle.repositories.ChainRepository;

@Service
public class ChainServiceImpl implements ChainService {

	@Autowired
	private ChainRepository chainRepo;

	@Override
	public List<Chain> index() {
		List<Chain> allChains = chainRepo.findAll();
		return allChains;
	}

	@Override
	public Chain getChainById(Integer Id) {
		Optional<Chain> chainOpt = chainRepo.findById(Id);
		Chain chain = null;
		if (chainOpt.isPresent()) {
			chain = chainOpt.get();
		}
		return chain;
	}

	@Override
	public Chain createChain(Chain newChain) {
		chainRepo.saveAndFlush(newChain);
		return chainRepo.save(newChain);
	}

	@Override
	public Chain updateChain(Chain chain, Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteChain(Integer Id) {
		// TODO Auto-generated method stub
		return false;
	}

}
