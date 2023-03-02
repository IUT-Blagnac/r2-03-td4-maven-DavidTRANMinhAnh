package main;
import tps.banque.AgenceBancaire;
import tps.banque.Compte;
import tps.banque.exception.ABCompteDejaExistantException;
import tps.banque.exception.ABCompteNullException;

public class ClasseEssaiAgenceBancaire {


public static void main(String[] argv) throws Exception {
	AgenceBancaire monAg; // 3.2 3
	monAg=new AgenceBancaire("MonAg", null);// 3.2 4
	monAg.afficher();// 3.2 5
	monAg.getNbComptes();// 3.2 6
	Compte cUn;
	Compte cDeux;
	Compte cTrois;
	cUn = new Compte ("0101", "prop1");
	cDeux = new Compte("0202", "prop2");
	cTrois = new Compte("0303", "prop2");// 3.2 7
	try {
		monAg.addCompte( cUn);
		monAg.addCompte( cDeux);
		monAg.addCompte( cTrois);
	} catch (ABCompteNullException e) {
		System.out.println (e.getMessage());
	} catch (ABCompteDejaExistantException e) {
		System.out.println (e.getMessage());
	} //3.2 8
	monAg.afficher();// 3.2 9
	Compte cR; // cr pour compte renvoye
	cR= monAg.getCompte("9999");
	if (cR==null) {
		System.out.println("Pas de compte trouve");
	} else {
		System.out.print("Le compte trouve est : ");
		cR.afficher();
	}// 3.2 10 pas de compte trouve
	Compte c;
	c = monAg.getCompte("0101");
	if (c != null) {
		System.out.print("Le compte trouve est : ");
	    c.afficher();
	    c.deposer (1000);  
	    c.afficher();
	}
	
	c = monAg.getCompte("0101");
	if (c != null) {
	    c.afficher();
	}// 3.2 11 
	Compte[] cRT; //crt pour compte rendu tableau
	cRT=monAg.getComptesDe("prop2");
	if (cRT != null) {
		System.out.print("Les compte de prop 2 sont : ");
		for (int i =0; i< cRT.length; i++) {
			cRT[i].afficher();
		}
	}else {
		System.out.println("Pas de compte trouv�");
	}// 3.2 12
	cDeux.deposer(2000);
	cTrois.deposer(3000);// 3.2 13
	Compte[] cRT1; //crt1 pout compte rendu tableau 
	cRT1=monAg.getComptesDe("prop2");
	if (cRT1 != null) {
		System.out.println("Les compte de prop 2 sont : ");
		for (int i =0; i< cRT1.length; i++) {
			cRT1[i].afficher();
		}
	}else {
		System.out.println("Pas de compte trouv�");
	}//3.2 14) le debit a bien été augmente entre les instruction donc le code fonctionne
	cRT1=monAg.getComptesDe("ABSTENT");
	if (cRT1 != null) {
		System.out.println("Les compte de ABSTENT sont : ");
		for (int i =0; i< cRT1.length; i++) {
			cRT1[i].afficher();
		}
	}else {
		System.out.println("Pas de compte trouv�");
	}// 3.2 15
	
	
	try {
		c = null;
		monAg.addCompte(c);
	} catch (ABCompteNullException e) {
		System.out.println (e.getMessage());
	} catch (ABCompteDejaExistantException e) {
		System.out.println (e.getMessage());
	}// 3.2 16 cela ne fonctionne pas car null n'est pas une r�f�rence de compte valide
	
	monAg.removeCompte("0202"); // 3.2 17
	//monAg.removeCompte("9999"); //3.2 18 cela ne marche pas car le compte 9999 n'est pas dans monAg
	
	Compte cQuatre;
	cQuatre= new Compte("0101", "prop99");
	
	
	
	
	
	
	
}
}