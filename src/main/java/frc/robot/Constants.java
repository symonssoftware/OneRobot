/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
	
	public static final int DIO_0 = 0;
	public static final int DIO_1 = 1;
	public static final int DIO_2 = 2;
	public static final int DIO_3 = 3;
	public static final int DIO_4 = 4;
	public static final int DIO_5 = 5;
	public static final int DIO_6 = 6;
	public static final int DIO_7 = 7;
	public static final int DIO_8 = 8;
	public static final int DIO_9 = 9;

	public static final int PIGEON_IMU_CAN_ID = 62;

    public static final int RIGHT_FRONT_MOTOR_CAN_ID = 11;
	public static final int RIGHT_REAR_MOTOR_CAN_ID = 12;
	public static final int LEFT_FRONT_MOTOR_CAN_ID = 13;
	public static final int LEFT_REAR_MOTOR_CAN_ID = 14;


	public static final double VISION_TARGET_TOLERANCE_IN_INCHES = 1.0;
	public static final double VISION_MOTOR_SPEED = .35;

	//public static final int STEP_DELAY = 190000;
	public static final int STEP_DELAY = 120000 ;
}
