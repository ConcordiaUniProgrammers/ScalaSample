package main.scala

import org.apache.logging.log4j.LogManager

object Log4jDemo {
	val log = LogManager.getLogger(getClass().getName())
	def main(args: Array[String]) {
		println("Logging is running....")
		log.info("Info : info text is {}","Demo is running");
		log.warn("Warning : warning text is {}", "Demo is running");
		log.debug("Debug : debug text is {}", "Demo is running");
		log.error("Error : error text is {}", "Demo is running");
		log.fatal("Fatal : fatal text is {}", "Demo is running");
		println("""End of logging!
		logs are stored in logs -> app_logger.log""")
	}
}