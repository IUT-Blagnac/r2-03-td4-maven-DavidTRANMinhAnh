package main;

import tps.banque.Compte;
import tps.banque.exception.CompteException;

public class ClasseEssaiCompte {
	public static void mainExo1(String[] argv) throws Exception {
		Compte cUn;
		cUn = new Compte ("01010101", "Lepoisson Benoit");
		cUn.afficher(); //2.3.1 4 Le num du compte, le nom, le debit, le credit et le nbOps du compte cUn sont affiche
		try {
			cUn.deposer(1000);
			cUn.retirer(500);
		}catch(Exception e) {
			System.out.println("Ereur");
		}
		// 2.3.1  5
		cUn.getNumCompte();
		cUn.getProprietaire();
		cUn.setProprietaire("Lepoisson Benoit");
		cUn.soldeCompte();
		cUn.deposer(2);
		cUn.retirer(1);
		cUn.toString();
		cUn.afficher(); // 2.3.1 6
		//cUn.deposer(-100); Renvoie une exception car les nombres negatifs ne fonctionnes pas avec retirer() et deposer()  
		//cUn.retirer(-100);
		System.out.println(cUn);// 2.3.1 9) Resultat est le meme qu'avec afficher() 
		System.out.println(System.identityHashCode(cUn)); //2.3.1 10 Resultat est 681842940
		cUn=null;// 2.3.1 11
		System.out.println(System.identityHashCode(cUn));// 2.3.1 12 le resultat est 0
		cUn.afficher(); // 2.3.1 13 Exception est donnee car cUn est desormais null
		
	}
	public static void main(String[] argv) throws Exception {
		Compte cUn;
		Compte cDeux; //2.3.2 1 et 2.3.2.2
		//cUn.afficher(); //2.3.2 3 la variable cUn n'est pas initialise java a donc revoye une exception
		cUn = new Compte ("010101", "Jean");
		cDeux = new Compte ("020202", "Marie");// 2.3.2 4
		cUn.afficher();
		cDeux.afficher();
		System.out.println(System.identityHashCode(cUn));
		System.out.println(System.identityHashCode(cDeux));// 2.3.2 5 // les information affiche sont celle qui ont ete afecte precedament dans l'instruction 4)
		try {
			cUn.deposer(1);
			cDeux.deposer(1000);
		} catch (CompteException e) {
			System.out.println(e); // 2.3.2 6
		}
		cUn.afficher();
		cDeux.afficher();
		cUn.soldeCompte();
		cDeux.soldeCompte(); // 2.3.2 7
		try {
			cUn.retirer(1);
			cDeux.retirer(1000);
		} catch (CompteException e) {
			System.out.println(e); // 2.3.2 8
		}
		cUn.afficher();
		cDeux.afficher();
		cUn.soldeCompte();
		cDeux.soldeCompte(); // 2.3.2 9
		//cUn.retirer(-100); // 2.3.2 10 Java renvoi une exception car la fonction retirer ne prend pas les nombres negatifs
		//cDeux.deposer(-100);// 2.3.2 11 Java renvoi aussi une exception car la fonction deposer ne prend pas les nombres negatifs
		cDeux=cUn; // 2.3.2 12
		cUn.afficher();
		cDeux.afficher();
		cUn.soldeCompte();
		cDeux.soldeCompte();
		System.out.println(System.identityHashCode(cUn));
		System.out.println(System.identityHashCode(cDeux)); // 2.3.2 13 cDeux est desormait identique e cUn
		cUn.deposer(1000);
		cUn.afficher();
		cDeux.afficher();
		cUn.soldeCompte();
		cDeux.soldeCompte(); // 2.3.2 14
		Compte cTrois;
		Compte cQuatre;// 2.3.2 15
		cTrois=cUn;
		cQuatre=cUn;//2.3.2 16
		cUn.afficher();
		cDeux.afficher();
		cTrois.afficher();
		cQuatre.afficher();
		cUn.soldeCompte();
		cDeux.soldeCompte();
		cTrois.soldeCompte();
		cQuatre.soldeCompte();// 2.3.2 17 les 4 variable sont donc toutes identique a cause de leur affectation de l'instruction 16)
		System.out.println(System.identityHashCode(cUn));
		System.out.println(System.identityHashCode(cDeux));
		System.out.println(System.identityHashCode(cTrois));
		System.out.println(System.identityHashCode(cQuatre));// 2.3.2 18 les 4 variables ont les memes references
		cTrois.deposer(500);
		cQuatre.retirer(200);// 2.3.2 19 je pense que ce que les valeur de debit et de credir vons augmenter car elles sont trop basses pour faire les actions demandees
		cUn.afficher();
		cDeux.afficher();
		cTrois.afficher();
		cQuatre.afficher();
		cUn.soldeCompte();
		cDeux.soldeCompte();
		cTrois.soldeCompte();
		cQuatre.soldeCompte();// 2.3.2 20 Les valeurs de debit ont ete augmentees de 200 et celle de credit de 500 car nous avons fait des depots/retrait trop grands pour les anciennes valeur
		// 2.3.2 21 il est impossible de refaire un depot sur le compte de "Marie" car nous n'avons plus de variable attache a cet objet
		cUn=null;//2.3.2 22
		System.out.println(cUn);// 2.3.2 23 le resultat est "null"
		//cUn.afficher();// 2.3.2 24 une exception est revoye car cUn est null
		cDeux.afficher();
		cDeux.soldeCompte();// 2.3.2 25 l'objet est revoye comme avant car il n'est pas ratache qu'a cUn	
		
	
	
	}





}