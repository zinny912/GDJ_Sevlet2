package com.iu.home;

public class Soldier {
	
	private String name;
	private Long num;

	//Gun과 has a 관계/ 의존성
	private Gun gun;
	
	//생성자 생성 : 생성자 안에서 직접 --- 결합도가 높다 / 군인이 사라지면 총도 사라짐
	public Soldier() {
		//this.gun = new Gun();
	}
	
	//생성자에서 매개변수 선언
	public Soldier(Gun gun) {
		this.gun = gun;
	}
	
	//메서드 생성하여 setter로 매개변수 받아서 선언
	public void setGun(Gun gun) {
		this.gun = gun;
	}
	
	//Act 해야하는 일, 행동 : 메서드로 / 명사같은 것들은 변수로
	public void useGun() {
		//총의 방아쇠를 당기세영
		this.gun.trigger();
		
	}
}
