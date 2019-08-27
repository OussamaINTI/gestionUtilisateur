package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Utilisateur;

public interface IUtilisateurService {
	public List<Utilisateur> findAll();

	public Utilisateur findOne(Long idUtilisateur);

	public Utilisateur save(Utilisateur utilisateur);

	public void delete(Long idUtilisateur);
	
	public Utilisateur findOneByUsername(String username);
}
