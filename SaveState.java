import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

// Zad 2. Serializacja biblioteki - zapis
public class SaveState {
	public static void save(Biblioteka bib) {
		saveReaders(bib.getCzytelnicy());
		saveBooks(bib.getKsiazki());
		saveLends(bib.getWypozyczenia());
	}

	private static void saveReaders (ArrayList<Czytelnik> czytelnicy) {
		try {
			FileOutputStream fos = new FileOutputStream("readers.ser");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			oos.writeObject(czytelnicy);
			oos.close();
		} catch (IOException exception){
			
		}
	}
	
	private static void saveBooks (ArrayList<Ksiazka> ksiazki) {
		try {
			FileOutputStream fos = new FileOutputStream("books.ser");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
		
			oos.writeObject(ksiazki);
			oos.close();
		} catch (IOException exception) {
			
		}
	}
	
	private static void saveLends (ArrayList<Wypozyczenie> wypozyczenia) {
		try {
			FileOutputStream fos = new FileOutputStream("lends.ser");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
		
			oos.writeObject(wypozyczenia);
			oos.close();
		} catch (IOException exception) {
			
		}
	}
}