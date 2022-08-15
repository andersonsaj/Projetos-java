package telas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import acessoDados.ClienteDAO;
import classes.Cliente;

@SuppressWarnings("serial")
public class CadCliente extends JFrame{
	
	private JPanel pnlCadastro;
	private JPanel pnlBotoes;
	private JPanel pnlCabecalho;
	private JLabel lblCabecalho;
	private JLabel lblNomeCliente;
	private JTextField txtNomeCliente;
	private JLabel lblTelCliente;
	private JTextField txtTelCliente;
	private JLabel lblEndCliente;
	private JTextField txtEndCliente;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	
	
	public static void main(String[] args) {
		new CadCliente();
	}
	
	public CadCliente() {
		iniciarComponentes();
		
		setVisible(true);
		setSize(640, 190);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Cadastro de Clientes");
		
	}

	private void iniciarComponentes() {
		// TODO Auto-generated method stub
		pnlCadastro = new JPanel(new GridLayout(3, 2));
		pnlBotoes = new JPanel(new GridLayout(0, 2));
		
		pnlCabecalho = new JPanel();
		lblCabecalho = new JLabel("Informa��es do Cliente");
		pnlCabecalho.add(lblCabecalho);
		
		lblNomeCliente = new JLabel("Nome");
		txtNomeCliente = new JTextField();
		
		lblTelCliente = new JLabel("Telefone");
		txtTelCliente = new JTextField();
		
		lblEndCliente = new JLabel("Endereço");
		txtEndCliente = new JTextField();

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				
				try {
					if (!"".equals(txtNomeCliente.getText().trim()) && 
						!"".equals(txtTelCliente.getText().trim()) &&
						!"".equals(txtEndCliente.getText().trim())) {
						
						cliente.setNome(txtNomeCliente.getText());
						cliente.setTelefone(txtTelCliente.getText());
						
						new ClienteDAO().inserir(cliente);
						
					//	JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Alerta do sistema", JOptionPane.INFORMATION_MESSAGE);
						limparCampos();
					//	dispose();
					}else {
						if ("".equals(txtNomeCliente.getText().trim())){
							JOptionPane.showMessageDialog(null, "O campo Nome é de preenchimento obrigatório!", "Alerta do sistema", JOptionPane.WARNING_MESSAGE);
							
						}else if ("".equals(txtTelCliente.getText().trim())) {
							JOptionPane.showMessageDialog(null, "O campo Telefone é de preenchimento obrigatório!", "Alerta do sistema", JOptionPane.WARNING_MESSAGE);
							
						}else {
							JOptionPane.showMessageDialog(null, "O campo Endereço é de preenchimento obrigatório!", "Alerta do sistema", JOptionPane.WARNING_MESSAGE);
						}
					}
				}catch(Exception ex) {
					
					JOptionPane.showMessageDialog(null, "Sistema com mal funcionamento, desculpe o transtorno. Contate o administrador.", "Alerta do sistema", JOptionPane.ERROR_MESSAGE);
				
				}
			}
			
		});
		
		btnCancelar  = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		
		pnlBotoes.add(btnCancelar);
		pnlBotoes.add(btnCadastrar);
		
		pnlCadastro.add(lblNomeCliente);
		pnlCadastro.add(txtNomeCliente);
		pnlCadastro.add(lblTelCliente);
		pnlCadastro.add(txtTelCliente);
		pnlCadastro.add(lblEndCliente);
		pnlCadastro.add(txtEndCliente);
		
		add(pnlCabecalho);
		add(pnlCadastro);
		add(pnlBotoes);
		
		this.setLayout(new BorderLayout());
		this.getContentPane().add(pnlCabecalho, BorderLayout.NORTH);
		this.getContentPane().add(pnlCadastro, BorderLayout.CENTER);
		this.getContentPane().add(pnlBotoes, BorderLayout.SOUTH);
		
	}
	
	private void limparCampos() {
		txtNomeCliente.setText("");
		txtTelCliente.setText("");
		txtEndCliente.setText("");
	}
}
