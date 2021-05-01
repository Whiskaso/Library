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

class RemoveBookDialog extends JDialog {
	
	private Biblioteka bib;
	
	public RemoveBookDialog(Biblioteka bib) {
		this.bib = bib;
		initUI();
	}
	
	public final void initUI() {
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel books = new JLabel("Ksiazki:");
        books.setFont(new Font("Serif", Font.BOLD, 12));
        books.setAlignmentX(0.5f);
        add(books);
		
		add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JComboBox readersComboBox = new JComboBox(bib.getKsiazki().toArray());
        readersComboBox.setSelectedIndex(-1);
        readersComboBox.setPreferredSize(new Dimension(450, 22));
        readersComboBox.setMaximumSize(new Dimension(450, 22));
        add(readersComboBox);
		
		add(Box.createRigidArea(new Dimension(0, 10)));

        JButton removeButton = new JButton("Usun");
		
		// Akcja podpieta pod przycisk "Usun"
		
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				bib.usunKsiazke(bib.getKsiazki().get(readersComboBox.getSelectedIndex()));
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

        setTitle("Usun ksiazke");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 220);
	}
}