package main.java.com.gdeb.ripout.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import main.java.com.gdeb.ripout.model.Ripout;
import main.java.com.gdeb.ripout.model.Task;
import main.java.com.gdeb.ripout.model.TaskRouting;
import main.java.com.gdeb.ripout.routing.Routing;

@Configuration
//@Slf4j
//@Log
class LoadDatabase {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(RipoutRepository repository) {

		return args -> {
			log.info("Preloading " + repository
					.save(new Ripout(1, Routing.ROUTING_RIPOUT_WRITER, true, Routing.STATUS_DRFT, 012345, "siczpak")));
			log.info("Preloading " + repository
					.save(new Ripout(1, Routing.ROUTING_RIPOUT_WRITER, true, Routing.STATUS_DRFT, 678901, "kincaid")));
		};
	}

	@Bean
	CommandLineRunner initTaskDatabase(TaskRepo taskRepo) {

		return args -> {
			log.info("Preloading " + taskRepo.save(
					new Task(100, null, Routing.ROUTING_ORIGINATOR, Routing.ROLE_Originator, "RipoutOriginator")));

			// writer
			log.info("Preloading " + taskRepo.save(new Task(101, Routing.STATUS_DRFT, Routing.ROUTING_RIPOUT_WRITER,
					Routing.ROLE_RipoutWriter, "RipoutWriter")));

			// lead trade
			log.info("Preloading " + taskRepo.save(new Task(102, Routing.STATUS_DRFT, Routing.ROUTING_LEAD_TRADE,
					Routing.ROLE_LeadTrade, "LeadTrade")));

			// ships mgmt
			log.info("Preloading " + taskRepo.save(new Task(103, Routing.STATUS_NPUB,
					Routing.ROUTING_SHIP_MGMT_APPROVAL, Routing.ROLE_ShipManager, "ShipsManagementApproval")));

			// QAE
			log.info("Preloading " + taskRepo.save(new Task(104, Routing.STATUS_NPUB,
					Routing.ROUTING_QAE_SPECIAL_EMPHASIS_REVIEW, Routing.ROLE_QAE, "QaeSpecialEmphasisReview")));

			// NQCE
			log.info("Preloading "
					+ taskRepo.save(new Task(105, Routing.STATUS_NPUB, Routing.ROUTING_NQCE_NUCLEAR_INTERFACE,
							Routing.ROLE_NuclearQualityControl, "NQCENuclearInterface")));

			// Enhanced: Eng Review
			log.info("Preloading "
					+ taskRepo.save(new Task(106, Routing.STATUS_NPUB, Routing.ROUTING_ENGINEERING_INITIAL_REVIEW,
							Routing.ROLE_ENHANCED_RO_ENGINEER, "NQCENuclearInterface")));

			// Enhanced: Eng Super Review
			log.info("Preloading "
					+ taskRepo.save(new Task(107, Routing.STATUS_NPUB, Routing.ROUTING_ENGINEERING_SUPER_REVIEW,
							Routing.ROLE_ENHANCED_RO_ENGINEER_SUPERVISOR, "EngineeringSupervisorReview")));

			// QAE Reentry
			log.info("Preloading " + taskRepo.save(new Task(108, Routing.STATUS_NPUB,
					Routing.ROUTING_QAE_REENTRY_CTL_DOC_NUM, Routing.ROLE_QAE, "QAEReentryControlDocumentNumber")));

			// Planning blue tags
			log.info("Preloading " + taskRepo.save(new Task(109, Routing.STATUS_NPUB,
					Routing.ROUTING_PLANNING_D355_BLUE_TAGS, Routing.ROLE_PLANNING, "Planning")));

			// Test Dept Test Controls
			log.info("Preloading "
					+ taskRepo.save(new Task(110, Routing.STATUS_STEC, Routing.ROUTING_TEST_DEPT_TEST_CONTROLS,
							Routing.ROLE_TEST_DEPT_TEST_CONTROLS, "TestDeptTestControls")));

			// QAI
			log.info("Preloading " + taskRepo.save(new Task(111, Routing.STATUS_NPUB, Routing.ROUTING_QAI_PIPING_REVIEW,
					Routing.ROLE_QAI, "QaiReview")));
			log.info("Preloading " + taskRepo.save(new Task(112, Routing.STATUS_NPUB, Routing.ROUTING_QAI_MECH_REVIEW,
					Routing.ROLE_QAI, "QaiReview")));
			log.info("Preloading " + taskRepo.save(new Task(113, Routing.STATUS_NPUB, Routing.ROUTING_QAI_STRU_REVIEW,
					Routing.ROLE_QAI, "QaiReview")));
			log.info("Preloading " + taskRepo.save(new Task(114, Routing.STATUS_NPUB, Routing.ROUTING_QAI_ELEC_REVIEW,
					Routing.ROLE_QAI, "QaiReview")));

			// QAI Super
			log.info("Preloading " + taskRepo.save(new Task(115, Routing.STATUS_NPUB,
					Routing.ROUTING_QAI_SUPERVISOR_REVIEW, Routing.ROLE_QAI_SUPERVISOR_REVIEW, "QaiReview")));
		};
	}

	@Bean
	CommandLineRunner initTaskRoutingDatabase(TaskRoutingRepo taskRoutingRepo) {

		return args -> {
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_RIPOUT_WRITER, new Task(100))));

			log.info("Preloading " + taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_LEAD_TRADE, new Task(101))));

			log.info("Preloading " + taskRoutingRepo
					.save(new TaskRouting(Routing.ROUTING_QAE_SPECIAL_EMPHASIS_REVIEW, new Task(103))));

			// QAE -> NQCE
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_NQCE_NUCLEAR_INTERFACE, new Task(104))));

			// QAE -> Enhanced Eng Review
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_ENGINEERING_INITIAL_REVIEW, new Task(104))));

			// Enhanced Eng Review -> Enhanced Super Review
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_ENGINEERING_SUPER_REVIEW, new Task(106))));

			// Enhanced Super Review -> QAE Reentry
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_QAE_REENTRY_CTL_DOC_NUM, new Task(107))));

			// QAE Reentry -> Planning Blue Tags
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_PLANNING_D355_BLUE_TAGS, new Task(108))));

			// Planning Blue Tags -> Test Ctls
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_TEST_DEPT_TEST_CONTROLS, new Task(109))));

			// Planning Blue Tags -> QAI Reviews
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_QAI_PIPING_REVIEW, new Task(109))));
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_QAI_MECH_REVIEW, new Task(109))));
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_QAI_STRU_REVIEW, new Task(109))));
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_QAI_ELEC_REVIEW, new Task(109))));

			// QAI Review -> QAI Super
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_QAI_SUPERVISOR_REVIEW, new Task(111))));
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_QAI_SUPERVISOR_REVIEW, new Task(112))));
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_QAI_SUPERVISOR_REVIEW, new Task(113))));
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_QAI_SUPERVISOR_REVIEW, new Task(114))));

		};
	}

}