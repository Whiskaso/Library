import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;

// Okno oddawania ksiazki (usuwania zwrotu)
class RemoveLendDialog extends JDialog {
	
	private Biblioteka bib;
	
    public RemoveLendDialog(Biblioteka bib) {
    	this.bib = bib;	
        initUI();
    }
    public final void initUI() {
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel lendBooks = new JLabel("Wypozyczone ksiazki:");
        lendBooks.setFont(new Font("Serif", Font.BOLD, 12));
        lendBooks.setAlignmentX(0.5f);
        add(lendBooks);
		
		add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JComboBox lendComboBox = new JComboBox(bib.getWypozyczenia().toArray());
        lendComboBox.setSelectedIndex(-1);
        lendComboBox.setPreferredSize(new Dimension(450, 22));
        lendComboBox.setMaximumSize(new Dimension(450, 22));
        add(lendComboBox);
		
		add(Box.createRigidArea(new Dimension(0, 10)));

        JButton removeButton = new JButton("Oddaj");
		
        // Akcja podpieta pod przycisk "Oddaj"
		
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				bib.usunWypozyczenie(bib.getWypozyczenia().get(lendComboBox.getSelectedIndex()));
				dispose();
			}
		});
		
		removeButton.setAlignmentX(0.5f);
        add(removeButton);
        
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

        setTitle("Oddaj ksiazke");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 220);

	}
}
