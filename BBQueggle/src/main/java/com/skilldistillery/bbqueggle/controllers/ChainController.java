package com.skilldistillery.bbqueggle.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bbqueggle.entities.Chain;
import com.skilldistillery.bbqueggle.entities.Style;
import com.skilldistillery.bbqueggle.services.ChainServiceImpl;

@CrossOrigin({ "*", "http://localhost:4210" })
@RequestMapping("api")
@RestController
public class ChainController {

	@Autowired
	private ChainServiceImpl svc;

	@GetMapping("chain")
	public List<Chain> index() {
		return svc.index();
	}

	@GetMapping("chain/{chainId}")
	public Chain getchainById(@PathVariable Integer chainId, HttpServletResponse response) {
		Chain chain = svc.getChainById(chainId);
		if (chain == null) {
			response.setStatus(404);
		}
		return chain;
	}

	@PostMapping("chain")
	public Chain createChain(@RequestBody Chain newChain, HttpServletResponse response, HttpServletRequest request) {
		Chain createdChain = null;
		try {
			createdChain = svc.createChain(newChain);
			response.setStatus(201);
			StringBuffer url = request.getRequestURL();
			url.append("/").append(newChain.getId());
			response.setHeader("Location", url.toString());

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
			newChain = null;
		}
		return createdChain;

	}

}
