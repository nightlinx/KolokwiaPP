package KolokwiumC;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Turniej {
	Rozgrywka mecz[][];
	int n; // dolny

	public Turniej(int n) {
		this.n = n;
		mecz = new Rozgrywka[n][];
		for (int i = 0; i < n; i++) {
			mecz[i] = new Rozgrywka[i];
		}
	}

	void dopiszRunde() throws IOException {
		FileReader file = new FileReader("runda.txt");
		Scanner in = new Scanner(file);

		while (in.hasNext()) {
			int druzynaGosp = in.nextInt();
			int druzynaGosci = in.nextInt();
			int bramkiGosp = in.nextInt();
			in.next(); // dwukropek
			int bramkiGosci = in.nextInt();
			in.close();
			file.close();

			mecz[druzynaGosp][druzynaGosci] = new Rozgrywka(bramkiGosp,
					bramkiGosci);
		}
	}

	Wynik punktyDruzyny(int druzyna) {
		Wynik wynik = null;
		int punkty = 0;
		int sumaStrzelonych = 0;
		int sumaStraconych = 0;

		for (int j = 0; j < n; j++) {
			if (druzyna != j) {
				int strzelone = mecz[druzyna][j].gosp;
				int stracone = mecz[druzyna][j].goscie;

				if (strzelone > stracone)
					punkty += 2;
				else if (strzelone == stracone)
					punkty += 1;
				sumaStrzelonych += strzelone;
				sumaStraconych += stracone;
			}
		}
		wynik = new Wynik(punkty, sumaStrzelonych, sumaStraconych);
		return wynik;
	}

	boolean jestLepsza(int a, int b) {
		boolean aLepsza = true;

		if (punktyDruzyny(a).punkty < punktyDruzyny(b).punkty) {
			aLepsza = false;
		} else if (punktyDruzyny(a).punkty == punktyDruzyny(b).punkty) {
			int roznica = punktyDruzyny(a).strzelone
					- punktyDruzyny(b).strzelone;

			if (roznica == 0) {
				double stosunekA = punktyDruzyny(a).strzelone
						/ punktyDruzyny(a).stracone;
				double stosunekB = punktyDruzyny(b).strzelone
						/ punktyDruzyny(b).stracone;

				if (stosunekB > stosunekA)
					aLepsza = false;
			}
			if (roznica < 0)
				aLepsza = false;
		}
		return aLepsza;
	}

	void zapiszTabele() throws FileNotFoundException {
		PrintWriter out = new PrintWriter("tabela.txt");

		for (int i = 0; i < n; i++) {
			out.println(i + " " + punktyDruzyny(i).punkty + " "
					+ punktyDruzyny(i).strzelone + " "
					+ punktyDruzyny(i).stracone);
		}
		out.close();
	}
}
