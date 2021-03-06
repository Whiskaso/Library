import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;



// Klasa Biblioteka
public class Biblioteka extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3167090132551198602L;
	// Listy ksiazek, czytelnikow i wypozyczen
	ArrayList<Ksiazka> ksiazki;
	ArrayList<Czytelnik> czytelnicy;
	ArrayList<Wypozyczenie> wypozyczenia;
	long numer_czytelnika;
	
	/**
	 * Konstruktor
	 */
	public Biblioteka() {
		this.ksiazki = new ArrayList<Ksiazka>();
		this.czytelnicy = new ArrayList<Czytelnik>();
		this.wypozyczenia = new ArrayList<Wypozyczenie>();
		this.numer_czytelnika = 1;
		initUI(this);
	}
	// Metoda inicjalizująca GUI
	public final void initUI(final Biblioteka bib) {
		
		// Panel
		JPanel panel = new JPanel();

		// Pole tekstowe
		final JTextArea textArea = new JTextArea("");
        textArea.setPreferredSize(new Dimension(550, 600));
        textArea.setEditable(false);
        
        // Dodanie pola tekstowego do panelu
        panel.add(textArea);
        
        // Dodanie panelu do JFrame
        add(panel);
        pack();
        // Pasek menu
        JMenuBar menubar = new JMenuBar();
        // Menu Biblioteka
        JMenu lib = new JMenu("Biblioteka");
        lib.setMnemonic(KeyEvent.VK_B);
        // Pozycja menu: Zakoncz
        JMenuItem eMenuItem = new JMenuItem("Zakoncz");
        eMenuItem.setMnemonic(KeyEvent.VK_Z);
        eMenuItem.setToolTipText("Zakoncz program");
        // Podpiecie akcji pod "Zakoncz"
        eMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
        		System.exit(0);
            }
        });

        // Pozycja menu: Wyswietl czytelnikow
        JMenuItem usersMenuItem = new JMenuItem("Wyswietl czytelnikow");
        usersMenuItem.setMnemonic(KeyEvent.VK_C);
        usersMenuItem.setToolTipText("Wyswietlenie listy czytelnikow");
        // Podpiecie akcji pod "Wyswietl czytelnikow"
        usersMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	textArea.setText("");
            	for (Czytelnik c: czytelnicy) {  
            		textArea.append(c+"\n");
            	}		
            }		  
        });
        
        // Pozycja menu: Wyswietl ksiazki
        JMenuItem booksMenuItem = new JMenuItem("Wyswietl ksiazki");
        booksMenuItem.setMnemonic(KeyEvent.VK_K);
        booksMenuItem.setToolTipText("Wyswietlenie listy ksiazek");
        // Podpiecie akcji pod "Wyswietl ksiazki"
        booksMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	textArea.setText("");
            	for (Ksiazka k: ksiazki) {  
            		textArea.append(k+"\n");
            	}		
            }		  
        });

        // Pozycja menu: Wyswietl wypozyczenia
        JMenuItem lendsMenuItem = new JMenuItem("Wyswietl wypozyczenia");
        lendsMenuItem.setMnemonic(KeyEvent.VK_Y);
        lendsMenuItem.setToolTipText("Wyswietlenie listy ksiazek");
        // Podpiecie akcji pod "Wyswietl wypozyczenia"
        lendsMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	textArea.setText("");
            	for (Wypozyczenie k: wypozyczenia) {  
            		textArea.append(k+"\n");
            	}		
            }		  
        });
        
        // Pozycja menu: Dodaj nowego czytelnika
        JMenuItem newReaderMenuItem = new JMenuItem("Dodaj nowego czytelnika");
        newReaderMenuItem.setMnemonic(KeyEvent.VK_N);
        // Podpiecie akcji pod "Dodaj nowego czytelnika"
        newReaderMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ReaderDialog ad = new ReaderDialog(bib);
                ad.setVisible(true);
            }
        });
        
		
		// Pozycja menu: Dodaj nowa ksiazke
		JMenuItem newBookMenuItem = new  JMenuItem("Dodaj nowa ksiazke");
		// Podpiecie akcji pod "Dodaj nowa ksiazke"
		newBookMenuItem.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent event)	{
				BookDialog ad = new BookDialog(bib);
				ad.setVisible(true);
			}
		});
		
		// Pozycja menu: Usun czytelnika
        JMenuItem removeReaderMenuItem = new JMenuItem("Usun czytelnika");
        // Podpiecie akcji pod "Usun czytelnika"
        removeReaderMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                RemoveReaderDialog ad = new RemoveReaderDialog(bib);
                ad.setVisible(true);
            }
        });
		
		// Pozycja menu: Usun ksiazke
        JMenuItem removeBookMenuItem = new JMenuItem("Usun ksiazke");
        // Podpiecie akcji pod "Usun ksiazke"
        removeBookMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                RemoveBookDialog ad = new RemoveBookDialog(bib);
                ad.setVisible(true);
            }
        });
		
        // Pozycja menu: Wypozycz ksiazke czytelnikowi
        JMenuItem lendBookMenuItem = new JMenuItem("Wypozycz ksiazke czytelnikowi");
        lendBookMenuItem.setMnemonic(KeyEvent.VK_W);
        // Podpiecie akcji pod "Wypozycz ksiazke czytelnikowi"
        lendBookMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                LendDialog ad = new LendDialog(bib);
                ad.setVisible(true);
            }
        });
		
		// Pozycja menu: Oddaj ksiazke (usun wypozyczenie)
		JMenuItem removeLendMenuItem = new JMenuItem("Oddaj ksiazke");
		//Podpiecie akcji pod "Oddaj ksiazke"
		removeLendMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				RemoveLendDialog ad = new RemoveLendDialog(bib);
				ad.setVisible(true);
			}
		});
		
		// Pozycja menu: Zapisz stan biblioteki
		JMenuItem saveStateMenuItem = new JMenuItem("Zapisz stan biblioteki");
		// Podpiecie akcji pod "Zapisz stan biblioteki"
		saveStateMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				SaveState.save(bib);
			}
		});
		
		// Pozycja menu: Wczytaj stan biblioteki
		JMenuItem loadStateMenuItem = new JMenuItem("Wczytaj stan biblioteki");
		// Podpiecie akcji pod "Wczytaj stan biblioteki"
		loadStateMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				LoadState.load(bib);
			}
		});
		
	
        // Dodanie pozycji do menu "Biblioteka"
        lib.add(lendBookMenuItem);
		lib.add(removeLendMenuItem);
        lib.addSeparator();
        lib.add(newReaderMenuItem);
		lib.add(newBookMenuItem);
        lib.addSeparator();
		lib.add(removeReaderMenuItem);
		lib.add(removeBookMenuItem);
        lib.addSeparator();
        lib.add(usersMenuItem);        
        lib.add(booksMenuItem);
        lib.add(lendsMenuItem);
        lib.addSeparator();
		lib.add(saveStateMenuItem);
		lib.add(loadStateMenuItem);
        lib.addSeparator();
        lib.add(eMenuItem);

        // Menu "Pomoc"
        JMenu help = new JMenu("Pomoc");
        help.setMnemonic(KeyEvent.VK_P);
        
        // Pozycja menu: O programie
        JMenuItem about = new JMenuItem("O programie");
        about.setMnemonic(KeyEvent.VK_O);
        
        // Podpiecie akcji pod "O programie"
        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                AboutDialog ad = new AboutDialog();
                ad.setVisible(true);
            }
        });

        // Dodanie pozycji "O programie" do menu "Pomoc"
        help.add(about);
        
        // Dodanie menu "Biblioteka" i "Pomoc" do paska menu
        menubar.add(lib);
        menubar.add(help);

        setJMenuBar(menubar);
        
        setTitle("Biblioteka");
        setSize(600, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	
	// Metody get i set
	
	/**
	 * @return the ksiazki
	 */
	public ArrayList<Ksiazka> getKsiazki() {
		return ksiazki;
	}


	/**
	 * @param ksiazki the ksiazki to set
	 */
	public void setKsiazki(ArrayList<Ksiazka> ksiazki) {
		this.ksiazki = ksiazki;
	}

	/**
	 * @return the czytelnicy
	 */
	public ArrayList<Czytelnik> getCzytelnicy() {
		return czytelnicy;
	}

	/**
	 * @param czytelnicy the czytelnicy to set
	 */
	public void setCzytelnicy(ArrayList<Czytelnik> czytelnicy) {
		this.czytelnicy = czytelnicy;
	}

	/**
	 * @return the wypozyczenia
	 */
	public ArrayList<Wypozyczenie> getWypozyczenia() {
		return wypozyczenia;
	}

	/**
	 * @param wypozyczenia the wypozyczenia to set
	 */
	public void setWypozyczenia(ArrayList<Wypozyczenie> wypozyczenia) {
		this.wypozyczenia = wypozyczenia;
	}

	public long getNumer_czytelnika() {
		return numer_czytelnika;
	}

	public void setNumer_czytelnika(long numer_czytelnika) {
		this.numer_czytelnika = numer_czytelnika;
	}
	
	public long kolejny_numer_czytelnika() {
		return numer_czytelnika++;
	}
	
	public void dodajKsiazke(Ksiazka k) {
		ksiazki.add(k);
	}

	public void dodajCzytelnika(Czytelnik c) {
		czytelnicy.add(c);
	}

	public void dodajWypozyczenie(Wypozyczenie w) {
		wypozyczenia.add(w);
	}

	public void usunKsiazke(Ksiazka k) {
		ksiazki.remove(k);
	}

	public void usunCzytelnika(Czytelnik c) {
		czytelnicy.remove(c);
	}

	public void usunWypozyczenie(Wypozyczenie w) {
		wypozyczenia.remove(w);
	}
	
	public boolean wypozyczKsiazkeCzytelnikowi(Ksiazka k, Czytelnik c) {
		if (k.wypozycz()) {
			dodajWypozyczenie(new Wypozyczenie(k, c));
			return true;
		}
		else 
			return false;
	}
}
