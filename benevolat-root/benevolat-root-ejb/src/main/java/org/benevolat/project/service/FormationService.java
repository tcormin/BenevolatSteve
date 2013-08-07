package org.benevolat.project.service;

import java.util.List;

import javax.ejb.Stateless;

import org.benevolat.project.model.Formation;

/**
 * SERVICE formation
 * 
 * @author tcormin
 */
@Stateless
public class FormationService extends PersistenceService{

	/**
	* Enregistre la formation
	* @param formation
	* @throws Exception
	*/
	public void setData(Formation formation) throws Exception {
		save(formation);
		this.getLog().info("Formation is registred with title: "+formation.getTitre());
	}
	
	/**
	* Récupère toutes les formations
	* @return
	* @throws Exception
	*/
	public List<Formation> getFormations() throws Exception {
		List<Formation> f = findAll(Formation.class);
		this.getLog().info(f.size() + " formation found");
		return f;
	}
}