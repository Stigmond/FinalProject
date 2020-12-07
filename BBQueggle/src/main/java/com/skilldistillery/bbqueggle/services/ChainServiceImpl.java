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
		Optional<Chain> chainOpt = chainRepo.findById(Id);
		Chain managedChain = null;
		if (chainOpt.isPresent()) {
			managedChain = chainOpt.get();

			if (chain.getName() != null) {
				managedChain.setName(chain.getName());
			}
			if (chain.getLogo() != null) {
				managedChain.setLogo(chain.getLogo());
			}
			if (chain.getWebsite() != null) {
				managedChain.setWebsite(chain.getWebsite());
			}

			chainRepo.flush();
		}
		return managedChain;
	}

	@Override
	public boolean deleteChain(Integer Id) {
		boolean deleted = false;
		Optional<Chain> chainOpt = chainRepo.findById(Id);
		if (chainOpt.isPresent()) {
			chainRepo.deleteById(Id);
			deleted = true;
		}
		return deleted;
	}

}
