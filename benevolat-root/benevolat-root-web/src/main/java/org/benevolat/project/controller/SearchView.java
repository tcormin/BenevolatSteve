package org.benevolat.project.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Evenement;
import org.benevolat.project.service.AssociationService;
import org.benevolat.project.service.BenevoleService;
import org.benevolat.project.service.EvenementService;
import org.benevolat.project.service.MissionService;

@RequestScoped
@Named("searchView")
public class SearchView implements Serializable {

	private static final long serialVersionUID = -7083396080063284495L;

	@Inject
	private AssociationService associationService;
	@Inject
	private BenevoleService benevoleService;
	@Inject
	private MissionService missionService;
	@Inject
	private EvenementService evenementService;
	
	private String searchText="";

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getSearchText() {
		return searchText;
	}
	
//	public List<Association> getA() throws Exception {
//		return associationService.search(Association.class,searchText);
//	}
//
//	public List<Mission> getMp() throws Exception {
//		return missionService.search(Mission.class,searchText);
//	}
//
//	public List<Mission> getMr() throws Exception {
//		return missionService.search(Mission.class,searchText);
//	}
	
	public List<Evenement> getEvenements(){
		return this.evenementService.search(this.searchText);
	}

	public String launchSearch(){
		
//		Iterator<Mission> itr = this.getMp().iterator();
//		Mission m;
//		
//		while(itr.hasNext()){
//			m = itr.next();
//			if(m.getTitre().contains(this.searchText)){
//				this.mp.add(m);
//			}
//			if(m.getDescription().contains(this.searchText)){
//				this.mp.add(m);
//			}
//		}
//	
//		itr = this.sessionBean.getgMissions().getDaoMission().getMissionsRegulieres().iterator();
//		
//		while(itr.hasNext()){
//			m = itr.next();
//			if(m.getTitre().contains(this.searchText)){
//				this.mr.add(m);
//			}
//			if(m.getDescription().contains(this.searchText)){
//				this.mr.add(m);
//			}
//		}
//		
//		Iterator<Association> itrA = this.sessionBean.getgUtilisateurs().getDaoAssociation().getAssociations().iterator();
//		Association ass;
//		while(itrA.hasNext()){
//			ass = itrA.next();
//			if(ass.getNom().contains(this.searchText)){
//				this.a.add(ass);
//			}
//			if(ass.getPresentation().contains(this.searchText)){
//				this.a.add(ass);
//			}
//		}
		return "search";
	
	}
	
}
