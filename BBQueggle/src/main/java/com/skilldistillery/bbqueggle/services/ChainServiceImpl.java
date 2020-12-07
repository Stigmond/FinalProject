package com.skilldistillery.bbqueggle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bbqueggle.entities.Chain;
import com.skilldistillery.bbqueggle.repositories.ChainRepository;

@Service
public class ChainServiceImpl implements ChainService {

	@Autowired
	private ChainRepository chainRepo;

	@Override
	public List<Chain> index() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chain getChainById(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chain createChain(Chain newChain) {
		// TODO Auto-generated method stub
		return null;
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
