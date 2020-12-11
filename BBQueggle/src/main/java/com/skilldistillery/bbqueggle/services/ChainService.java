package com.skilldistillery.bbqueggle.services;

import java.util.List;

import com.skilldistillery.bbqueggle.entities.Chain;

public interface ChainService {

	List<Chain> index();

	Chain getChainById(Integer Id);

	Chain createChain(Chain newChain, String username);

	Chain updateChain(Chain chain, Integer Id, String username);

	boolean deleteChain(Integer Id, String username);

}
