package com.iu.home;

public class Gun {
	
	private String company;
	private String name;
	
	//총은 총알을 가지고 있어야함 
	private Bullet bullet;
	
	
	public void setBullet(Bullet bullet) {
		this.bullet = bullet;
	}







	//방아쇠를 당기면 하는 일
	public void trigger() {
		
		//방아쇠가 당겨져서 총알이 나가며 소리를 낸당
		this.bullet.sound();
	}

}
