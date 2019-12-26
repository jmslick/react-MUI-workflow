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

	// Ripout Repo
	@Bean
	CommandLineRunner initDatabase(RipoutRepository repository) {

		return args -> {
			log.info("Preloading " + repository
					.save(new Ripout("1001", true, "RO82110 001", "J. Siczpak", "387128", "w1234", "HVAC", "PSA",
							"Type-1", "HVAC-MAINT", "714", "32", Routing.STATUS_ORIG, Routing.ROUTING_ORIGINATOR)));

			log.info("Preloading " + repository
					.save(new Ripout("1002", false, "RO54562 001", "H. Walker", "789567", "w5678", "DSS", "New",
							"Type-Z01", "Dive System", "729", "20", Routing.STATUS_ORIG, Routing.ROUTING_ORIGINATOR)));

			log.info("Preloading " + repository
					.save(new Ripout("1003", true, "RO87645 001", "J. Siczpak", "387128", "w1234", "HVAC", "PSA",
							"Type-1", "HVAC-MAINT", "714", "32", Routing.STATUS_DRFT, Routing.ROUTING_RIPOUT_WRITER)));

			log.info("Preloading " + repository.save(
					new Ripout("1004", true, "RO26578 001", "J. Siczpak", "387128", "w8434", "PROP", "New", "Type-K584",
							"Prop-X821-A34", "714", "45", Routing.STATUS_NPUB, Routing.ROUTING_RIPOUT_WRITER)));

			log.info("Preloading " + repository.save(new Ripout("1005", false, "RO75634 001", "H. Walker", "789567",
					"w7831", "IAQ-5341", "PSA", "Type-4418", "Threat Mgmnt", "714", "457", Routing.STATUS_NPUB,
					Routing.ROUTING_RIPOUT_WRITER)));

			log.info("Preloading " + repository.save(new Ripout("1006", false, "RO78789 001", "J. Siczpak", "387128",
					"xabc123", "472-1JK", "PSA", "KJF09CVCUIAOT43", "Weapons Maint", "734", "219",
					Routing.ROLE_TEST_DEPT_TEST_CONTROLS, Routing.ROUTING_ENGINEERING_SUPER_REVIEW)));

			log.info("Preloading " + repository.save(new Ripout("1007", false, "RO78945 001", "W. Walden", "789456",
					"a7984", "AB-315", "NEW", "Type-T483QJ-7489", "Telemetry", "734", "456", Routing.STATUS_NPUB,
					Routing.ROUTING_QAI_STRU_REVIEW)));

		};
	}

	// Task Repo
	@Bean
	CommandLineRunner initTaskDatabase(TaskRepo taskRepo) {

		return args -> {
			log.info("Preloading " + taskRepo.save(new Task(100, Routing.STATUS_ORIG, Routing.ROUTING_ORIGINATOR,
					Routing.ROLE_ORIGINATOR, "RipoutOriginator")));

			// writer
			log.info("Preloading " + taskRepo.save(new Task(101, Routing.STATUS_DRFT, Routing.ROUTING_RIPOUT_WRITER,
					Routing.ROLE_RIPOUT_WRITER, "RipoutWriter")));

			// lead trade
			log.info("Preloading " + taskRepo.save(new Task(102, Routing.STATUS_DRFT, Routing.ROUTING_LEAD_TRADE,
					Routing.ROLE_LEAD_TRADE, "LeadTrade")));

			// ships mgmt
			log.info("Preloading " + taskRepo.save(new Task(103, Routing.STATUS_NPUB,
					Routing.ROUTING_SHIP_MGMT_APPROVAL, Routing.ROLE_SHIP_MANAGER, "ShipsManagementApproval")));

			// QAE
			log.info("Preloading " + taskRepo.save(new Task(104, Routing.STATUS_NPUB,
					Routing.ROUTING_QAE_SPECIAL_EMPHASIS_REVIEW, Routing.ROLE_QAE, "QaeSpecialEmphasisReview")));

			// NQCE
			log.info("Preloading "
					+ taskRepo.save(new Task(105, Routing.STATUS_NPUB, Routing.ROUTING_NQCE_NUCLEAR_INTERFACE,
							Routing.ROLE_NUCLEAR_QUALITY_CONTROL, "NQCENuclearInterface")));

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

	// TaskRouting
	@Bean
	CommandLineRunner initTaskRoutingDatabase(TaskRoutingRepo taskRoutingRepo) {
		return args -> {
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_RIPOUT_WRITER, 1, new Task(100))));

			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_LEAD_TRADE, 2, new Task(101))));

			log.info("Preloading " + taskRoutingRepo
					.save(new TaskRouting(Routing.ROUTING_QAE_SPECIAL_EMPHASIS_REVIEW, 3, new Task(103))));

			// QAE -> NQCE
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_NQCE_NUCLEAR_INTERFACE, 4, new Task(104))));

			// QAE -> Enhanced Eng Review
			log.info("Preloading " + taskRoutingRepo
					.save(new TaskRouting(Routing.ROUTING_ENGINEERING_INITIAL_REVIEW, 5, new Task(104))));

			// Enhanced Eng Review -> Enhanced Super Review
			log.info("Preloading " + taskRoutingRepo
					.save(new TaskRouting(Routing.ROUTING_ENGINEERING_SUPER_REVIEW, 6, new Task(106))));

			// Enhanced Super Review -> QAE Reentry
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_QAE_REENTRY_CTL_DOC_NUM, 7, new Task(107))));

			// QAE Reentry -> Planning Blue Tags
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_PLANNING_D355_BLUE_TAGS, 8, new Task(108))));

			// Planning Blue Tags -> Test Ctls
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_TEST_DEPT_TEST_CONTROLS, 9, new Task(109))));

			// Planning Blue Tags -> QAI Reviews
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_QAI_PIPING_REVIEW, 10, new Task(109))));
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_QAI_MECH_REVIEW, 11, new Task(109))));
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_QAI_STRU_REVIEW, 12, new Task(109))));
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_QAI_ELEC_REVIEW, 13, new Task(109))));

			// QAI Review -> QAI Super
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_QAI_SUPERVISOR_REVIEW, 14, new Task(111))));
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_QAI_SUPERVISOR_REVIEW, 14, new Task(112))));
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_QAI_SUPERVISOR_REVIEW, 14, new Task(113))));
			log.info("Preloading "
					+ taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_QAI_SUPERVISOR_REVIEW, 14, new Task(114))));

		};
	}

	/*
	 * return args -> { log.info("Preloading " + taskRoutingRepo.save(new
	 * TaskRouting(Routing.ROUTING_RIPOUT_WRITER, 100, null)));
	 * 
	 * log.info("Preloading " + taskRoutingRepo.save(new
	 * TaskRouting(Routing.ROUTING_LEAD_TRADE, 101, null)));
	 * 
	 * log.info("Preloading " + taskRoutingRepo.save(new
	 * TaskRouting(Routing.ROUTING_QAE_SPECIAL_EMPHASIS_REVIEW, 103, null)));
	 * 
	 * // QAE -> NQCE log.info("Preloading " + taskRoutingRepo.save(new
	 * TaskRouting(Routing.ROUTING_NQCE_NUCLEAR_INTERFACE, 104, null)));
	 * 
	 * // QAE -> Enhanced Eng Review log.info("Preloading " +
	 * taskRoutingRepo.save(new
	 * TaskRouting(Routing.ROUTING_ENGINEERING_INITIAL_REVIEW, 104, null)));
	 * 
	 * // Enhanced Eng Review -> Enhanced Super Review log.info("Preloading " +
	 * taskRoutingRepo.save(new
	 * TaskRouting(Routing.ROUTING_ENGINEERING_SUPER_REVIEW, 106, null)));
	 * 
	 * // Enhanced Super Review -> QAE Reentry log.info("Preloading " +
	 * taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_QAE_REENTRY_CTL_DOC_NUM,
	 * 107, null)));
	 * 
	 * // QAE Reentry -> Planning Blue Tags log.info("Preloading " +
	 * taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_PLANNING_D355_BLUE_TAGS,
	 * 108, null)));
	 * 
	 * // Planning Blue Tags -> Test Ctls log.info("Preloading " +
	 * taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_TEST_DEPT_TEST_CONTROLS,
	 * 109, null)));
	 * 
	 * // Planning Blue Tags -> QAI Reviews log.info("Preloading " +
	 * taskRoutingRepo.save(new TaskRouting(Routing.ROUTING_QAI_PIPING_REVIEW, 109,
	 * null))); log.info("Preloading " + taskRoutingRepo.save(new
	 * TaskRouting(Routing.ROUTING_QAI_MECH_REVIEW, 109, null)));
	 * log.info("Preloading " + taskRoutingRepo.save(new
	 * TaskRouting(Routing.ROUTING_QAI_STRU_REVIEW, 109, null)));
	 * log.info("Preloading " + taskRoutingRepo.save(new
	 * TaskRouting(Routing.ROUTING_QAI_ELEC_REVIEW, 109, null)));
	 * 
	 * // QAI Review -> QAI Super log.info("Preloading " + taskRoutingRepo.save(new
	 * TaskRouting(Routing.ROUTING_QAI_SUPERVISOR_REVIEW, 111, null)));
	 * log.info("Preloading " + taskRoutingRepo.save(new
	 * TaskRouting(Routing.ROUTING_QAI_SUPERVISOR_REVIEW, 112, null)));
	 * log.info("Preloading " + taskRoutingRepo.save(new
	 * TaskRouting(Routing.ROUTING_QAI_SUPERVISOR_REVIEW, 113, null)));
	 * log.info("Preloading " + taskRoutingRepo.save(new
	 * TaskRouting(Routing.ROUTING_QAI_SUPERVISOR_REVIEW, 114, null)));
	 * 
	 * }; }
	 */
}