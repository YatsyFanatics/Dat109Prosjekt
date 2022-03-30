package model;

public class Poengtabell {

	public final static int bonusGrense = 42;
	public final static int bonusPoeng = 50;
	public final static int yatzyPoeng = 50;

	int[][] yatzyTabell;

	public Poengtabell() {
		yatzyTabell = new int[18][6];
	}
	public Poengtabell(int antallSpillere) {
		yatzyTabell = new int[18][antallSpillere];
	}

	public void regnUt(int spillerNr, int radNr, int[] arr) {

		switch (radNr) {
		case 1:
			enere(spillerNr, arr);
			break;

		case 2:
			toere(spillerNr, arr);
			break;

		case 3:
			treere(spillerNr, arr);
			break;

		case 4:
			firere(spillerNr, arr);
			break;

		case 5:
			femere(spillerNr, arr);
			break;

		case 6:
			seksere(spillerNr, arr);
			break;

		case 7:
			sum(spillerNr);
			break;

		case 8:
			ettPar(spillerNr, arr);
			break;

		case 9:
			toPar(spillerNr, arr);
			break;

		case 10:
			treLike(spillerNr, arr);
			break;

		case 11:
			litenStright(spillerNr, arr);
			break;

		case 12:
			storStright(spillerNr, arr);
			break;

		case 13:
			yatzy(spillerNr, arr);
			break;

		case 14:
			total(spillerNr);
			break;
		}

	}

	public void enere(int spillerNr, int[] arr) {
		settInn(0, spillerNr, sumTerningVerdi(1, arr));

	}

	public void toere(int spillerNr, int[] arr) {
		settInn(1, spillerNr, sumTerningVerdi(2, arr));

	}

	public void treere(int spillerNr, int[] arr) {
		settInn(2, spillerNr, sumTerningVerdi(3, arr));

	}

	public void firere(int spillerNr, int[] arr) {
		settInn(3, spillerNr, sumTerningVerdi(4, arr));

	}

	public void femere(int spillerNr, int[] arr) {
		settInn(4, spillerNr, sumTerningVerdi(5, arr));

	}

	public void seksere(int spillerNr, int[] arr) {
		settInn(5, spillerNr, sumTerningVerdi(6, arr));

	}

	public void sum(int spillerNr) {
		int sum = 0;

		for (int i = 0; i <= 5; i++) {
			sum += hentVerdi(i, spillerNr);
		}
		settInn(6, spillerNr, sum);

		if (sum >= bonusGrense) {
			settInn(7, spillerNr, bonusPoeng);
		} else {
			settInn(7, spillerNr, 0);
		}

	}

	public void ettPar(int spillerNr, int[] arr) {
		int sum = 0;
		for (int i = 1; i <= 6; i++) {
			if (antallLike(i, arr) > 1) {
				sum = i * 2;
			}

		}
		settInn(8, spillerNr, sum);
	}

	public void toPar(int spillerNr, int[] arr) {
		int sum = 0;
		int par1 = 0;
		boolean toPar = false;
		for (int i = 1; i <= 6; i++) {
			if (antallLike(i, arr) > 1) {
				sum = i * 2;
				par1 = i;
			}

		}
		for (int i = 1; i <= 6; i++) {
			if (antallLike(i, arr) > 1 && i != par1) {
				sum += i * 2;
				toPar = true;
			}

		}
		if (toPar) {
			settInn(9, spillerNr, sum);
		}
	}

	public void treLike(int spillerNr, int[] arr) {
		int sum = 0;
		for (int i = 1; i <= 6; i++) {
			if (antallLike(i, arr) > 2) {
				sum = i * 3;
			}

		}
		settInn(10, spillerNr, sum);

	}
	
	public void fireLike(int spillerNr, int[] arr) {
		int sum = 0;
		for (int i = 1; i <= 6; i++) {
			if (antallLike(i, arr) > 3) {
				sum = i * 4;
			}

		}
		settInn(11, spillerNr, sum);

	}
	

	public void litenStright(int spillerNr, int[] arr) {
		int sum = 0;
		boolean funnet = false;
		for (int i = 1; i <= 5; i++) {
			for (int n = 1; n <= 5 && !funnet; n++) {
				if (i == n) {
					sum += n;
					funnet = true;
				}
			}
			funnet = false;
		}
		if (sum == (1 + 2 + 3 + 4 + 5)) {
			settInn(12, spillerNr, sum);
		} else {
			settInn(12, spillerNr, 0);
		}

	}

	public void storStright(int spillerNr, int[] arr) {
		int sum = 0;
		boolean funnet = false;
		for (int i = 2; i <= 6; i++) {
			for (int n = 2; n <= 6 && !funnet; n++) {
				if (i == n) {
					sum += i;
					funnet = true;
				}
			}
			funnet = false;
		}
		if (sum == (2 + 3 + 4 + 5 + 6)) {
			settInn(13, spillerNr, sum);
		} else {
			settInn(13, spillerNr, 0);
		}

	}

	public void hus(int spillerNr, int[] arr) {
		int sum = 0;
		int treLike = 0;
		boolean hus = false;

		for (int i = 1; i <= 6; i++) {
			if (antallLike(i, arr) > 2) {
				sum = i * 3;
				treLike = i;
			}

		}

		if (treLike > 0) {
			for (int i = 1; i <= 6; i++) {
				if (antallLike(i, arr) > 1 && i != treLike) {
					sum += i * 2;
					hus = true;
				}

			}
		}

		if (hus) {
			settInn(14, spillerNr, sum);
		} else {
			settInn(14, spillerNr, 0);
		}

	}

	public void sjanse(int spillerNr, int[] arr) {
		int sum = 0;
		for(int  i = 0; i <5; i++) {
			sum += arr[i];
		}
		settInn(15, spillerNr, sum);

	}

	public void yatzy(int spillerNr, int[] arr) {
		settInn(16, spillerNr, yatzyPoeng);
	}

	public void total(int spillerNr) {

		int sum = 0;

		for (int i = 6; i <= 16; i++) {
			sum += hentVerdi(i, spillerNr);
		}
		settInn(17, spillerNr, sum);
	}

	private int sumTerningVerdi(int verdi, int[] arr) {
		int sum = 0;
		for (int i : arr) {
			if (i == verdi) {
				sum += i;
			}
		}
		return sum;
	}

	private void settInn(int radNr, int spillerNr, int sum) {
		yatzyTabell[radNr][spillerNr] = sum;
	}

	public int hentVerdi(int radNr, int spillerNr) {
		return yatzyTabell[radNr][spillerNr];
	}

	private int antallLike(int verdi, int[] arr) {
		int antallForekomster = 0;
		for (int i : arr) {
			if (i == verdi) {
				antallForekomster++;
			}
		}
		return antallForekomster;
	}
	
	public int[] hentRad(int i) {
		return yatzyTabell[i];
	}

}
