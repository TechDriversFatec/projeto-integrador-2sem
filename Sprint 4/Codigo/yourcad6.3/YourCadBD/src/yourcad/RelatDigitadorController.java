/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourcad;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author MaXx
 */
public class RelatDigitadorController implements Initializable {

    @FXML
    private BorderPane mainPane;
    @FXML
    private AnchorPane ancPane_TelaInicio;
    @FXML
    private MenuBar menuBar_TelaInicial;
    @FXML
    private MenuItem menuItem_CadCliente;
    @FXML
    private MenuItem menuItem_CadConta;
    @FXML
    private MenuItem menuItem_CadConcessionaria;
    @FXML
    private MenuItem menuItem_PesqCliente;
    @FXML
    private MenuItem menuItem_PesqConta;
    @FXML
    private MenuItem menuItem_PesqConcessionaria;
    @FXML
    private MenuItem menuItem_RelatAcessos;
    @FXML
    private MenuItem menuItem_RelatClientes;
    @FXML
    private MenuItem menuItem_RelatDigitador;
    @FXML
    private Menu menu_Configuracao;
    @FXML
    private MenuItem menuItem_CadUsuarios;
    @FXML
    private MenuItem menuItem_PesqUsuarios;
    @FXML
    private Menu menu_Sair;
    @FXML
    private MenuItem menuItem_SairSistema;
    @FXML
    private TextField txt_relatLoginDigitador;
    @FXML
    private TextField txt_relatNomeDigitador;
    @FXML
    private Button btn_Pesquisar;
    @FXML
    private TextField txt_relatSql;
    @FXML
    private TextField txt_relatData1;
    @FXML
    private TextField txt_relatData2;
    @FXML
    private Button btn_relatImprimir;
    @FXML
    private TableView<RelatDigitador> table_ContasDigitador;
    @FXML
    private TableColumn<RelatDigitador, String> tb_digitador_cod;
    @FXML
    private TableColumn<RelatDigitador, String> tb_digitador_nome;
    @FXML
    private TableColumn<RelatDigitador, String> tb_digitador_instalacao;
    @FXML
    private TableColumn<RelatDigitador, String> tb_digitador_cliente;
    @FXML
    private TableColumn<RelatDigitador, String> tb_digitador_tipoConta;
    @FXML
    private TableColumn<?, ?> tb_digitador_Data;
    @FXML
    private TableColumn<?, ?> tb_digitador_Hora;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    // INICIO MENU BAR //
    // FUNÇÃO PARA ABRIR TELA A PARTIR DE MENU BAR 
    @FXML
    public void gotoCliente(ActionEvent event) throws IOException{
        PesqClienteController.alterClienteId = 0;
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Form_CadCliente.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void gotoConta(ActionEvent event) throws IOException {
        PesqContaEnergiaController.contaAlterId = 0;
        PesqContaAguaController.contaAlterId = 0;
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Form_CadConta.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void gotoConcessionaria(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Form_CadConcessionaria.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    @FXML
    private void gotoPesqCliente(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("PesqCliente.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    @FXML
    private void gotoPesqConta(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("PesqConta.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    @FXML
    private void gotoPesqConcessionaria(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("PesqConcessionaria.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    

     @FXML
    private void gotoUsuarios(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Form_Usuarios.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void gotoPesqUsuarios(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("PesqUsuarios.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void gotoRelatAcessos(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("RelatAcessos.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void gotoRelatClientes(ActionEvent event) throws IOException 
    {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("RelatContas.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void gotoRelatDigitador(ActionEvent event) throws IOException 
    {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("RelatDigitador.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void gotoSair(ActionEvent event) throws IOException 
    {
        Form_LoginController.usuario_Id = "";
        Form_LoginController.usuario_Nome = "";
        Form_LoginController.usuario_Login = "";
        Form_LoginController.usuario_Nivel_Acesso = "";
        Form_LoginController.usuario_Email = "";
        
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Form_Login.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBar_TelaInicial.getScene().getWindow();  
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show(); 
    }
    // FIM MENU BAR //
    
    private ObservableList<RelatDigitador> linhas_banco;
    @FXML
    private void pesquisarDigitador(ActionEvent event) throws Exception
    {
        String digitador_login = txt_relatLoginDigitador.getText();
        String digitador_nome = txt_relatNomeDigitador.getText();
        String digitador_data1 = txt_relatData1.getText();
        String digitador_data2 = txt_relatData2.getText();
        
        Connection conn = null;
        ResultSet resultadoBanco = null;
        conn = DBConexao.abrirConexao();
        Statement stm = conn.createStatement();
        
        List<RelatDigitador> digitador = new ArrayList<>();
        
        String sql;
        String sql1;
        if(!"".equals(digitador_login)){ sql1 = " WHERE usuario_login LIKE '%"+ digitador_login +"%' ";}
        else if(!"".equals(digitador_nome)){ sql1 = " WHERE usuario_nome LIKE '%"+ digitador_nome +"%' ";}
        else if(!"".equals(digitador_data1)&& "".equals(digitador_data2)){  sql1 = " WHERE relat_data = '"+ digitador_data1 +"' ";}
        else if(!"".equals(digitador_data2)&& "".equals(digitador_data1)){  sql1 = " WHERE relat_data = '"+ digitador_data2 +"' ";}
        else if(!"".equals(digitador_data1)&& !"".equals(digitador_data2)){  sql1 = " WHERE relat_data BETWEEN '"+digitador_data1+"' AND '"+digitador_data2+"' ";}
        else if(!"".equals(digitador_login) && !"".equals(digitador_nome) && !"".equals(digitador_data1) && !"".equals(digitador_data2))
        { sql1 = " WHERE usuario_login LIKE '%"+ digitador_login +"%' && usuario_nome LIKE '%"+ digitador_nome +"%' && relat_data BETWEEN '"+digitador_data1+"' AND '"+digitador_data2+"' ";}
        else{sql1 = "";}
        sql = "SELECT relat_id, usuarios.usuario_nome, cliente.cliente_nome, conta.conta_numero_instalacao, conta.conta_tipo, relat_data, "
                + " relat_hora, usuarios.usuario_nivel_acesso, usuarios.usuario_login, usuarios.usuario_status, usuarios.usuario_email "
                + " FROM relatorio_digitador "
                + " INNER JOIN usuarios ON usuarios.usuario_id = relatorio_digitador.usuario_id "
                + " INNER JOIN conta ON conta.conta_id = relatorio_digitador.conta_id "
                + " INNER JOIN cliente ON cliente.cliente_id = conta.cliente_id "
                + sql1 
                + " ;";
        resultadoBanco = stm.executeQuery(sql);
        System.out.println(sql);
        
        txt_relatSql.setText(sql);
        
        linhas_banco = FXCollections.observableArrayList();

        while(resultadoBanco.next())
        {   
          linhas_banco.add(new RelatDigitador(resultadoBanco.getString(1), resultadoBanco.getString(2), resultadoBanco.getString(3), 
                                              resultadoBanco.getString(4), resultadoBanco.getString(5), resultadoBanco.getString(6), 
                                              resultadoBanco.getString(7), resultadoBanco.getString(8), resultadoBanco.getString(9),
                                              resultadoBanco.getString(10), resultadoBanco.getString(11)));
        }
        
        tb_digitador_cod.setCellValueFactory(new PropertyValueFactory<>("relat_id"));
        tb_digitador_nome.setCellValueFactory(new PropertyValueFactory<>("relat_usuarioId"));
        tb_digitador_cliente.setCellValueFactory(new PropertyValueFactory<>("relat_cliente"));
        tb_digitador_instalacao.setCellValueFactory(new PropertyValueFactory<>("relat_instalacao"));
        tb_digitador_tipoConta.setCellValueFactory(new PropertyValueFactory<>("relat_tipoConta"));
        tb_digitador_Data.setCellValueFactory(new PropertyValueFactory<>("relat_data"));
        tb_digitador_Hora.setCellValueFactory(new PropertyValueFactory<>("relat_hora"));
                
        table_ContasDigitador.setItems(null);
        table_ContasDigitador.setItems(linhas_banco);
    }

    @FXML
    private void imprimirRelatorio(ActionEvent event) throws Exception 
    {
        String usuario_nome = txt_relatNomeDigitador.getText();
        String data1 = txt_relatData1.getText();
        String data2 = txt_relatData2.getText();
        String sql = txt_relatSql.getText();
        
        HashMap filtro = new HashMap();
        filtro.put("QUERY", sql);
        //filtro.put("USUARIO_NOME", usuario_nome);
        //filtro.put("DATA1", data1);
        //filtro.put("DATA2", data2);
        Connection conn = null;
        conn = DBConexao.abrirConexao();

        URL url = getClass().getResource("RelatDigitador.jasper");
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(url);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, filtro, conn);/*null: caso não existam filtros*/ 
        JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);//false: não deixa fechar a aplicação principal
        jasperViewer.setVisible(true);
        
    }
    
    @FXML
    private void mascaraDocumento(KeyEvent event)
    {
        
    }
    
}
