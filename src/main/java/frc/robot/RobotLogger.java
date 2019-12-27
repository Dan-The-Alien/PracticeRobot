/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
/**
 * Add your docs here.
 */
public class RobotLogger {

    public static Logger logger;
    private static FileHandler fileTxt;
    private static SimpleFormatter formatterTxt;

    public static void setup() throws IOException {
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        fileTxt = new FileHandler("Log.txt");
        formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);
    }
}