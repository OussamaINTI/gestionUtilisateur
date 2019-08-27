package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Utilisateur;
import com.inti.service.interfaces.IUtilisateurService;

@RestController
public class UtilisateurController {
	@Autowired
	IUtilisateurService utilisateurService;
	@Autowired
	PasswordEncoder passwordEncoder;

	@RequestMapping(value = "users", method = RequestMethod.GET)
	public List<Utilisateur> findAll() {
		return utilisateurService.findAll();
	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.GET)
	public Utilisateur findOne(@PathVariable("id") Long idUtilisateur) {
		return utilisateurService.findOne(idUtilisateur);
	}

	@RequestMapping(value = "users", method = RequestMethod.POST)
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		Utilisateur user = new Utilisateur();
		user.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		user.setNomUtilisateur(utilisateur.getNomUtilisateur());
		user.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
		user.setUsername(utilisateur.getUsername());
		user.setImage(utilisateur.getImage());
		user.setListRole(utilisateur.getListRole());
		user.setDateNaissance(utilisateur.getDateNaissance());
		return utilisateurService.save(user);
	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
	public void deleteUtilisateur(@PathVariable("id") Long idUtilisateur) {
		utilisateurService.delete(idUtilisateur);
	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.PUT)
	public Utilisateur updateUtilisateur(@PathVariable("id") Long idUtilisateur, @RequestBody Utilisateur utilisateur) {
		Utilisateur currentUtilisateur = utilisateurService.findOne(idUtilisateur);
		currentUtilisateur.setNomUtilisateur(utilisateur.getNomUtilisateur());
		currentUtilisateur.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
		currentUtilisateur.setUsername(utilisateur.getUsername());
		currentUtilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		currentUtilisateur.setDateNaissance(utilisateur.getDateNaissance());
		currentUtilisateur.setImage(utilisateur.getImage());
		currentUtilisateur.setListRole(utilisateur.getListRole());
		return utilisateurService.save(currentUtilisateur);

	}
}
