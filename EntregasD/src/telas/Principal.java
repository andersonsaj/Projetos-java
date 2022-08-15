package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Principal extends JFrame{
	
	private JPanel pnlSuperior;
	private JPanel pnlLateral;
	private JPanel pnlCorpo;
	private JPanel pnlRodape;
	private JPanel pnlCabecalho;
	private JPanel pnlLogo;
	private PanelPadrao pnlPadrao =null;
	
	public Principal() {
		this.setExtendedState(this.MAXIMIZED_BOTH);
		organizarLayout();
		this.setVisible(true);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		//setLocationRelativeTo(null);
		setTitle("Sistema de Entregas");
		setResizable(false);
	}
	
	private void organizarLayout() {
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setLayout(new BorderLayout());
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		pnlSuperior = new JPanel(layout);
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		pnlSuperior.setPreferredSize(new Dimension(getSize().width,
				(int)(getSize().height*0.1)));
		pnlSuperior.setBackground(Color.blue);
		
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		pnlLogo = new JPanel();
		pnlLogo.setPreferredSize(new Dimension((int)(getSize().width*0.15),
				(int) (getSize().height*0.1)));
		pnlLogo.setBackground(Color.darkGray);
		pnlSuperior.add(pnlLogo, c);
		
		c.gridwidth =1;
		c.gridx = 1;
		c.gridy = 0;
		pnlCabecalho = new JPanel();
		pnlCabecalho.setPreferredSize(new Dimension((int)(getSize().width*0.85), 
				(int)(getSize().height*0.1)));
		pnlCabecalho.setBackground(Color.LIGHT_GRAY);
		pnlSuperior.add(pnlCabecalho, c);
		
		add(pnlSuperior, BorderLayout.NORTH);
		
		pnlLateral = new JPanel(layout);
		pnlLateral.setPreferredSize(new Dimension((int)(getSize().width*0.15), 
				(int)(getSize().height*0.87)));
		pnlLateral.setBackground(Color.darkGray);
		
		String[][] nomes = {{"Cli", "Ped"}, {"Ate", "Prod"}, {"Fun", "Ger"}
		, {"Mot", "Cat"}, {"Conf", "Rel"}};
		JButton[][] botoes = new JButton[5][2];
		for(int lin = 0; lin < 5; lin++) {
			for(int col = 0; col <2; col++) {
				botoes[lin][col] = new JButton(nomes[lin][col]);
				
				c.gridx = col;
				c.gridy = lin;
				
				botoes[lin][col].setOpaque(true);
				botoes[lin][col].setBackground(Color.darkGray);
				botoes[lin][col].setFont(new Font("Arial", Font.PLAIN, 12));
				botoes[lin][col].setForeground(Color.white);
				botoes[lin][col].setBorder(BorderFactory.createLineBorder(Color.lightGray));
				botoes[lin][col].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						setPanelPadrao(e,c);
						
					}
					
				});
				pnlLateral.add(botoes[lin][col], c);
			}
		}
		
		add(pnlLateral, BorderLayout.WEST);
		
		pnlCorpo = new JPanel(new BorderLayout());
		pnlCorpo.setPreferredSize(new Dimension((int)(getSize().width*0.85), 
				(int)(getSize().height*0.7)));
		add(pnlCorpo, BorderLayout.EAST);
		
		pnlRodape = new JPanel();
		pnlRodape.setPreferredSize(new Dimension((int)getSize().width,
				(int)(getSize().height*0.03)));
		pnlRodape.setBackground(Color.LIGHT_GRAY);
		
		add(pnlRodape, BorderLayout.SOUTH);
		
	}

	protected void setPanelPadrao(ActionEvent e, GridBagConstraints c) {
		if(e.getSource() instanceof JButton) {
			JButton botao = (JButton) e.getSource();
			
			if(pnlPadrao != null)
				pnlCorpo.remove(pnlPadrao);
			
			PanelPadrao pp = PanelPadrao.getInstancia(botao, 
					new Dimension(pnlCorpo.getSize().width,
					pnlCorpo.getSize().height));
			pp.setBackground(Color.white);
			pp.setBorder(BorderFactory.createEtchedBorder());
			pnlCorpo.add(pp, BorderLayout.NORTH);
			pnlCorpo.repaint();
			validate();
			
			setPanelAtual(pp);
		}
		
	}

	private void setPanelAtual(PanelPadrao pp) {
		pnlPadrao =pp;
		
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Principal();
			}
			
		});
	}
}
