-- You can use this file to load seed data into the database using SQL statements

-- MISSIONS
-- INSERT INTO `jpadb`.`mission` (`id`, `titre`, `nombreBenevoles`) VALUES ('1', 'Hublot', '1');
-- INSERT INTO `jpadb`.`mission` (`id`, `titre`, `nombreBenevoles`) VALUES ('2', 'Rolex', '1');
-- INSERT INTO `jpadb`.`mission` (`id`, `titre`, `nombreBenevoles`) VALUES ('3', 'Swatch', '1');
-- INSERT INTO `jpadb`.`mission` (`id`, `titre`, `nombreBenevoles`) VALUES ('4', 'Mais ouais !!', '1');

-- UTILISATEURS
-- INSERT INTO `jpadb`.`utilisateur` (`username`,`id`)	VALUES ('evolutio', '4');

-- ASSOCIATIONS
-- INSERT INTO `jpadb`.`association` (`acronyme`, `buts`, `contact`, `dateCreation`, `nom`, `presentation`, `id`)
-- 	VALUES ('Evolutio', 'Lorem ipsum', 'Eric et Nelson', '1.1.2000', 'Evolutio', 'ONG qui blablabla', '4');

-- EVENEMENTS
-- INSERT INTO `jpadb`.`evenement` (`id`, `dateDebut`, `description`, `lieu`, `nom`, `url`)
-- 	VALUES ('1', '4.12.2013', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.', 'Genève', 'Course de l escalade', 'www.ecalade.ch');
-- INSERT INTO `jpadb`.`evenement` (`id`, `dateDebut`, `dateFin`, `description`, `lieu`, `nom`, `url`)
-- 	VALUES ('2', '1.9.2013', '2.9.2013', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.', 'Genève', 'Fête du logiciel', 'www.humour.com');
-- INSERT INTO `jpadb`.`evenement` (`id`, `dateDebut`, `dateFin`, `description`, `lieu`, `nom`, `url`)
-- 	VALUES ('3', '21.6.2014', '23.6.2014', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.', 'Genève', 'Fête de la musique', 'www.fetedelamusique.ch');

-- A LA FIN
-- INSERT INTO `jpadb`.`mission` (`id`, `dateDebut`, `delaiInscription`, `description`, `lieu`, `nombreBenevoles`, `titre`, `association_id`)
-- 	VALUES ('5', '21.6.2014', '1.5.2014', 'Vous devrez gérer le stand de EVOLUTIO une ONG qui récoulte des fonds pour l enseignement en Ouhganda', 'Cropettes', '1', 'Responsable stand', '4');

