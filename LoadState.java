import java.io.*;
import java.util.ArrayList;

// Zad 2. Serializacja biblioteki - odczyt
public class LoadState {
		
	public static void load(Biblioteka bib) {
		loadReaders(bib);
		loadBooks(bib);
		loadLends(bib);
	}
	
	private static void loadReaders(Biblioteka bib) {
		try {
			FileInputStream fis = new FileInputStream("readers.ser");
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			ArrayList<Czytelnik> czytelnicy = new ArrayList<Czytelnik>();
			czytelnicy = (ArrayList<Czytelnik>) ois.readObject();
			
			bib.setCzytelnicy(czytelnicy);
			
			ois.close();
		} catch (Exception e){
			
		}
	}
	
	private static void loadBooks(Biblioteka bib) {
		try {
			FileInputStream fis = new FileInputStream("books.ser");
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			ArrayList<Ksiazka> ksiazki = new ArrayList<Ksiazka>();
			ksiazki = (ArrayList<Ksiazka>) ois.readObject();
			
			bib.setKsiazki(ksiazki);
			
			ois.close();
		} catch (Exception e){
			
		}
	}
	
	private static void loadLends(Biblioteka bib) {
		try {
			FileInputStream fis = new FileInputStream("lends.ser");
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			ArrayList<Wypozyczenie> wypozyczenia = new ArrayList<Wypozyczenie>();
			wypozyczenia = (ArrayList<Wypozyczenie>) ois.readObject();
			
			bib.setWypozyczenia(wypozyczenia);
			
			ois.close();
		} catch (Exception e){
			
		}
	}
}

