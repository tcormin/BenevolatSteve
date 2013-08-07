package org.benevolat.project.test;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.benevolat.project.model.Mission;
import org.benevolat.project.service.MissionService;
import org.junit.Test;

public class TestMissionRegistration {

   @Inject
   MissionService missionService;

   @Inject
   Logger log;

   @Test
   public void testRegister() throws Exception {
		String titreMission = "Mission titre";
		
		Mission m = new Mission();
		m.setTitre(titreMission);
		assertEquals(m.getTitre(),titreMission);
   }
   
}
