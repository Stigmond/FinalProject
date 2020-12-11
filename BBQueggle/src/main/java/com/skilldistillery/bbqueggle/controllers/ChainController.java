package com.skilldistillery.bbqueggle.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bbqueggle.entities.Chain;
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
	public Chain getchainById(@PathVariable Integer chainId, HttpServletResponse response, Principal principal) {
		Chain chain = svc.getChainById(chainId, principal.getName());
		if (chain == null) {
			response.setStatus(404);
		}
		return chain;
	}

	@PostMapping("chain")
	public Chain createChain(@RequestBody Chain newChain, HttpServletResponse response, HttpServletRequest request, Principal principal) {
		Chain createdChain = null;
		try {
			createdChain = svc.createChain(newChain, principal.getName());
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

	@PutMapping("chain/{chainId}")
	public Chain updateChain(@PathVariable Integer chainId, @RequestBody Chain updatedChain,
			HttpServletResponse response, Principal principal) {
		try {
			updatedChain = svc.updateChain(updatedChain, chainId, principal.getName());
			if (updatedChain == null) {
				response.setStatus(404);
				updatedChain = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
			updatedChain = null;
		}
		return updatedChain;
	}

	@DeleteMapping("chain/{chainId}")
	public void deleteChain(@PathVariable Integer chainId, HttpServletResponse response, Principal principal) {
		if (svc.deleteChain(chainId, principal.getName())) {
			response.setStatus(204);

		} else {
			response.setStatus(404);
		}
	}

}
