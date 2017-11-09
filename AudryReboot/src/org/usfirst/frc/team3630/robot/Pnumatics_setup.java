package org.usfirst.frc.team3630.robot;


import edu.wpi.first.wpilibj.Ultrasonic;

import edu.wpi.first.wpilibj.DoubleSolenoid;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalOutput;

public class Pnumatics_setup {

DoubleSolenoid exampleDouble;

Ultrasonic ultra;
//DigitalOutput d;
double range;

public Pnumatics_setup(){
exampleDouble= new DoubleSolenoid(0,1);

	ultra = new Ultrasonic(3,4);
	//d= new DigitalOutput(1);
	 ultra.setAutomaticMode(true);

	  
	}





public double ultraRange(){

		
	 range= ultra.getRangeInches();
	 return range;
}





public void open(){
	exampleDouble.set(DoubleSolenoid.Value.kForward);
}
public void close(){
	exampleDouble.set(DoubleSolenoid.Value.kReverse);
}
public void off(){
	exampleDouble.set(DoubleSolenoid.Value.kOff);

}

public void onOff() {

		//
///	d.pulse(10);
	for(int k=0; k>=4; k++) {
		open();
		//Timer.delay(1);
/*		//try {
		//	Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		close(); 
		//Timer.delay(1);

	
	/*
	try {
		Thread.sleep(12000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	*/

	k++;
	
	}
	//Timer.delay(120);

}

public int  GetValue(){
	if(ultraRange() <= 48){
		
		return 1;
		
	}
	else if ( ultraRange() >=48){
		
		return 2;
		
	}

		
	else {
		return 2;
	}

	}



public void P_Periodic(){

	
	switch (GetValue()) {
	case 1:
		open();

		break;
	
	case 2: 
	
		close();
		
		break;
	
		
			default:
	close();
			break;
}
	
	
}





public void outputRange() {
	// TODO Auto-generated method stub
	SmartDashboard.putNumber("ulraRange", range);

}






}
