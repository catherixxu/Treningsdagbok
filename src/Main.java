import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

public static void main(String[] args) throws SQLException {
		
		
		Scanner scanner = new Scanner(System.in);
		boolean run= true;
		while(run){
			System.out.println("Hva har du lyst til aa gjore? \n"
					+ "Skriv inn tall for det du vil:\n"
					+ /*check*/ "1: Registrer treningsokt\n" 
					+ /*check*/ "2: Registrer ovelse\n" 
					+ /*check*/ "3: Registrer apparat\n" 
					+ "4: Vis de siste n oktene\n" // med notat?????
					+ "5: Vis resultatlogg for en periode\n"
					+ /*check*/ "6: Lag ovelsesgruppe\n" //MEN, må denne kobles med ovelse på noen måte?
					+ "7: Finn ovelser i gitt ovelsesgruppe\n"
					+ "8:"//valgfri use case
					+ "99: Avslutt");
			
			int input=scanner.nextInt();
			scanner.nextLine();
			//Goes to next line in input.
			
			String textInput;
			String[] myList;
			
		
			
			switch(input){
			
				// Registrerer treningsøkt
				case 1: 
					System.out.println("Legg til treningsøkt på formen 'YYYY-MM-DD, tidspunkt (kl. 00:00), varighet (tall), personlig form (heltall), personlig prestasjon (heltall), notat' ''");

					textInput=scanner.nextLine();
					myList = textInput.split(", ");
					for(int i = 0; i<myList.length; i++) {
						System.out.print(myList[i] + " | ");
					}
					Treningsokt treningsokt = new Treningsokt(Date.valueOf(myList[0]), myList[1], Integer.parseInt(myList[2]), Integer.parseInt(myList[3]), Integer.parseInt(myList[4]), myList[5]);
					Database.addTreningsokt(treningsokt);
					Database.printOvelser();
					System.out.println("Hvilke øvelser har denne treningsøkten? Skriv inn id for å legge til, '0' for å avslutte");
					ArrayList<Integer> added = new ArrayList<>();
					while(true){
						textInput = scanner.nextLine();
						if (Integer.parseInt(textInput)==0){
							break;
						}else{
							int id=Integer.parseInt(textInput);
							if (!added.contains(id)){
								Database.addOvelseTilOkt(id, treningsokt);
								added.add(id);
							}else{
								System.out.println("Den finnes allerede. Legg til en annen eller trykk '0' for aa avslutte.");
							}
						}
					}
					break;
				// Registrer ovelse
				case 2: 
					System.out.println("Vil du opprette apparatøvelse, tast 1. Dersom du ønsker friøvelse, tast 2");
					textInput=scanner.nextLine();
					if (Integer.parseInt(textInput)==1){
						System.out.println("Legg til en ovelse på formen 'ID (heltall), Navn' ', Antall kilo (heltall), Antall sett (heltall), ApparatID (heltall)'");
						textInput=scanner.nextLine();
						myList = textInput.split(", ");
						int id=Integer.parseInt(myList[0]);
						Ovelse ovelse=new Ovelse(id, myList[1]);
						ApparatOvelse apparatOvelse=new ApparatOvelse (id, myList[1],Integer.parseInt(myList[2]),Integer.parseInt(myList[3]),Integer.parseInt(myList[4]));
						Database.addApparatOvelse(apparatOvelse);
						Database.addOvelse(ovelse);
					}
					else if (Integer.parseInt(textInput)==2){
						System.out.println("Legg til en ovelse på formen 'ID (heltall), Navn' ', Beskrivelse''");
						textInput=scanner.nextLine();
						myList = textInput.split(", ");
						int id=Integer.parseInt(myList[0]);
						Ovelse ovelse=new Ovelse(id, myList[1]);
						FriOvelse friOvelse=new FriOvelse (id, myList[1], myList[2]);
						Database.addFriOvelse(friOvelse);
						Database.addOvelse(ovelse);
					}

					textInput=scanner.nextLine();
					myList = textInput.split(", ");
					Ovelse ovelse = new Ovelse(Integer.parseInt(myList[0]), myList[1]);
					Database.addOvelse(ovelse);
					break;
				
				//registrere apparat
				case 3:
					System.out.println("Legg til en apparat på formen 'ID (heltall), navn'', beskrivelse '' ");
					textInput=scanner.nextLine();
					myList = textInput.split(", ");
					Apparat apparat = new Apparat(Integer.parseInt(myList[0]), myList[1], myList[2]);
					Database.addApparat(apparat);
					break;	
					
				//Registrere øvelsesgruppe
				case 6:
					System.out.println("Legg til en ovelsesgruppe på formen 'ID (heltall), navn'', beskrivelse '' ");
					textInput=scanner.nextLine();
					myList = textInput.split(", ");
					Ovelsesgruppe ovelsesgruppe= new Ovelsesgruppe(Integer.parseInt(myList[0]), myList[1], myList[2]);
					Database.addOvelsesgruppe(ovelsesgruppe);
					break;
					
			/*	case 7:
					Database.printOvelsesgrupper(); 
					System.out.println("Hvilke øvelsesgruppe vil du velge? Skriv inn id for å legge til");
					textInput = scanner.nextLine();
						if (Integer.parseInt(textInput)==0){
							break;
						}
						else{
							int id=Integer.parseInt(textInput);
								Database.addOvelseTilOkt(id, treningsokt);
								added.add(id);
							}else{
								System.out.println("Den finnes allerede. Legg til en annen eller trykk '0' for aa avslutte.");
							}*/
						}
			}
			}
			
			
		//scanner.close()
}
