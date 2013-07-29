package org.benevolat.project.test;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Member;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.benevolat.project.model.Mission;
import org.benevolat.project.service.MissionService;
import org.benevolat.project.util.Resources;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class MissionRegistrationTest {
   @Deployment
   public static Archive<?> createTestArchive() {
      return ShrinkWrap.create(WebArchive.class, "test.war")
            .addClasses(Mission.class, MissionService.class, Resources.class)
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
            // Deploy our test datasource
            .addAsWebInfResource("test-ds.xml", "test-ds.xml");
   }

   @Inject
   MissionService missionService;

   @Inject
   Logger log;

   @Test
   public void testRegister() throws Exception {
      Mission mission = new Mission();
      mission.setTitre("Mission titre");
      missionService.setData(mission);
      assertNotNull(mission.getId());
      log.info(mission.getTitre() + " was persisted with id " + mission.getId());
   }
   
}
