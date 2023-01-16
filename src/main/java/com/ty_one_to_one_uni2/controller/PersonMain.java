package com.ty_one_to_one_uni2.controller;

import java.util.Scanner;

import com.ty_one_to_one_uni2.dao.PanCardDeo;
import com.ty_one_to_one_uni2.dao.PersonDeo;
import com.ty_one_to_one_uni2.dto.PanCard;
import com.ty_one_to_one_uni2.dto.Person;

import net.bytebuddy.asm.Advice.Enter;

public class PersonMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PersonDeo deo = new PersonDeo();
		PanCardDeo panCardDeo=new PanCardDeo();
		boolean repeat = true;
		while (repeat) {
			System.out.println(
					"enter the choice \n 1.savePerson \n 2.updatePerson \n 3.deleteperson \n 4.getPersonById \n5.getallPersonDetails \n6.exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter the person id");
				int id = scanner.nextInt();
				System.out.println("Enter the person name");
				String name = scanner.next();
				System.out.println("Enter the person phone number");
				Long phone = scanner.nextLong();
				System.out.println("Enter the person address");
				String address = scanner.next();
				System.out.println("Enter the person pincode");
				int pincode = scanner.nextInt();
				Person person = new Person();
				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				person.setAddress(address);
				person.setPincode(address);
				System.out.println("Enter the PanCard id");
				int pId = scanner.nextInt();
				System.out.println("Enter the PanCard name");
				String pName = scanner.next();
				System.out.println("Enter the PanCard address");
				String pAddress = scanner.next();
				PanCard panCard = new PanCard();
				panCard.setPid(pId);
				panCard.setName(pName);
				panCard.setAddress(pAddress);
				person.setPanCard(panCard);
				deo.savePerson(person);
			}
				break;
		case 2: {
			System.out.println("Enter choice \n 1.to update Person name \n 2.to update PanCard name");
			int choice1=scanner.nextInt();
			switch (choice) {
			case 1:{
				System.out.println("Enter the person id");
				int id = scanner.nextInt();
				System.out.println("Enter the person name to update");
				String name = scanner.next();
				deo.updatePerson(name,id);
			}break;
			case 2:{
				System.out.println("Enter the PanCard id");
				int id = scanner.nextInt();
				System.out.println("Enter the PanCard name to update");
				String name = scanner.next();
				panCardDeo.updatePanCard(name, id);
			}
		}
		}break;
		case 3:{
			System.out.println("Enter choice \n 1.to delet Person  \n 2.to delete PanCard ");
			int choice1=scanner.nextInt();
			switch (choice1) {
			case 1:{
				System.out.println("Enter the person id");
				int id = scanner.nextInt();
				deo.deletePerson(id);
			}break;
			case 2:{
				System.out.println("Enter the PanCard id");
				int id = scanner.nextInt();
				panCardDeo.deletePanCard(id);;
			}
			}
		}break;
		case 4:{
			System.out.println("Enter the person id");
			int id = scanner.nextInt();
			Person person=deo.getPersonByPersonId(id);
			System.out.println(person);
		}break;
		case 5:{
			System.out.println(deo.getAllPerson());
			
		}break;
		case 6:
				repeat = false;
				break;
			}
		}
	}
}
