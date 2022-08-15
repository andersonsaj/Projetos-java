package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.Listeners.DataChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Pessoa;
import model.services.PessoaService;

public class PessoaListController implements Initializable, DataChangeListener{

	private PessoaService service;
	
	@FXML
	private TableView<Pessoa> tableViewPessoa;
	@FXML
	private TableColumn<Pessoa, String> tableColumnNome;
	@FXML
	private TableColumn<Pessoa, String> tableColumnCpf;
	@FXML
	private TableColumn<Pessoa, String> tableColumnEmail;
	@FXML
	private TableColumn<Pessoa, String> tableColumnTelefone;
	@FXML
	private TableColumn<Pessoa, String> tableColumnRua;
	@FXML
	private TableColumn<Pessoa, String> tableColumnBairro;
	@FXML
	private TableColumn<Pessoa, String> tableColumnCidade;
	@FXML
	private TableColumn<Pessoa, String> tableColumnEstado;
	
	private ObservableList<Pessoa> obsList;
	
	
	public void setPessoaService(PessoaService service) {
		this.service = service;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}
	
	private void initializeNodes() {
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tableColumnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tableColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
//		tableColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("numero"));
//		tableColumnRua.setCellValueFactory(new PropertyValueFactory<>("rua"));
//		tableColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("bairro"));
//		tableColumnRua.setCellValueFactory(new PropertyValueFactory<>("cidade"));
//		tableColumnRua.setCellValueFactory(new PropertyValueFactory<>("estado"));
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewPessoa.prefHeightProperty().bind(stage.heightProperty());
	}

	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		List<Pessoa> list = service.findAllPessoa();
//		obsList = FXCollections.observableArrayList(list);
//		tableViewPessoa.setItems(obsList);
//		initEditButtons();
//		initRemoveButtons();
	}
	
	@Override
	public void onDataChanged() {
		updateTableView();
	}

}
