package telas;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class PanelPadrao extends JTabbedPane implements ChangeListener{

	private JPanel pnlPesquisa;
	private JPanel pnlNovo;
	private JButton botaoSelecionado;
	private Dimension dim;
	private static PanelPadrao instancia;
	
	private PanelPadrao(JButton botao, Dimension d) {
		if(botao.getText().equals("Ate")) {
			addTab("Pesquisar", pnlPesquisa);
			addTab("Novo", pnlNovo);
			botaoSelecionado = botao;
			dim = d;
		}
		setPreferredSize(d);
		addChangeListener(this);
	}
	
	public static synchronized PanelPadrao getInstancia(JButton botao, Dimension d) {
		if(instancia == null)
			instancia = new PanelPadrao(botao, d);
		return instancia;
	}
	
	public static synchronized void matarInstancia() {
		instancia = null;
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

}
