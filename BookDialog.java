import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

// Okno dodawania nowego czytelnika
class BookDialog extends JDialog {
	private Biblioteka bib;
	
	public BookDialog(Biblioteka bib) {
    	this.bib = bib;	
        initUI();
    }
	
	public final void initUI() {
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 6)));
		
		JLabel bookName = new JLabel("Tytul ksiazki:");
        bookName.setFont(new Font("Serif", Font.BOLD, 12));
        bookName.setAlignmentX(0.5f);
        add(bookName);

        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JTextField bookNameTextField = new JTextField(20);
        add(bookNameTextField);
        
        add(Box.createRigidArea(new Dimension(0, 6)));
		
		JLabel author = new JLabel("Autor:");
        author.setFont(new Font("Serif", Font.BOLD, 12));
        author.setAlignmentX(0.5f);
        add(author);
        
        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JTextField authorTextField = new JTextField(20);
        add(authorTextField);
		
		add(Box.createRigidArea(new Dimension(0, 6)));
		
		JLabel isbn = new JLabel("Isbn:");
        isbn.setFont(new Font("Serif", Font.BOLD, 12));
        isbn.setAlignmentX(0.5f);
        add(isbn);
        
        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JTextField isbnTextField = new JTextField(20);
        add(isbnTextField);
		
		add(Box.createRigidArea(new Dimension(0, 6)));
		
		JLabel amount = new JLabel("Ilosc ksiazek:");
        amount.setFont(new Font("Serif", Font.BOLD, 12));
        amount.setAlignmentX(0.5f);
        add(amount);
        
        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JTextField amountTextField = new JTextField(20);
        add(amountTextField);

        add(Box.createRigidArea(new Dimension(0, 10)));

        JButton addButton = new JButton("Dodaj");
		
		// Akcja podpieta pod przycisk "Dodaj"
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	bib.dodajKsiazke(new Ksiazka(bookNameTextField.getText(), authorTextField.getText(), isbnTextField.getText(), Integer.parseInt(amountTextField.getText())));
                dispose();
            }
        });

        addButton.setAlignmentX(0.5f);
        add(addButton);
		
		add(Box.createRigidArea(new Dimension(0, 10)));
        
        JButton cancelButton = new JButton("Anuluj");
        cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });

        cancelButton.setAlignmentX(0.5f);
        add(cancelButton);
		
		
		setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("Dodaj ksiazke");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 320);
	}
}