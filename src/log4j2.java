import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

void main() {
    final Logger logger = LogManager.getLogger();

    for (int i = 1; i<200; i++) {
        logger.trace("TRACE message {}", i);
        logger.debug("DEBUG message {}", i);
        logger.info("INFO message {}", i);
        logger.warn("WARN message {}", i);
        logger.error("ERROR message {}", i);
    }
}