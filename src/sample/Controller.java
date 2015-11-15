package sample;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.control.TextArea;

import javafx.scene.text.Font;
import javafx.stage.*;

import java.awt.datatransfer.UnsupportedFlavorException;

import java.io.*;

import java.util.Optional;

public class Controller {
    private Stage stage;



    public TextArea textArea1;
    @FXML
    CheckMenuItem Arial;
    @FXML
    CheckMenuItem Verdana;
    @FXML
    CheckMenuItem Times;
    @FXML
    CheckMenuItem Comic;
    @FXML
    RadioMenuItem dc;
    @FXML
    RadioMenuItem cc;
    @FXML
    RadioMenuItem dcs;

    @FXML
    RadioMenuItem dc2;
    @FXML
    javafx.scene.control.MenuItem copy;
    @FXML
    javafx.scene.control.MenuItem paste;
    @FXML
    javafx.scene.control.MenuItem undo;

    public static String File1;
    boolean j=true;

    public void tamanio (ActionEvent actionEvent) throws Exception {

        String d = ((RadioMenuItem) actionEvent.getSource()).getText();
          if (d.equals("18")){
             dc.setSelected(false);
             dcs.setSelected(false);
             cc.setSelected(false);
             dc2.setSelected(true);
             String f1 = textArea1.getFont().getFamily();
                textArea1.setFont(Font.font(f1, 18));


         }

        else if (d.equals("12")){
             dc2.setSelected(false);
             dcs.setSelected(false);
             cc.setSelected(false);
             dc.setSelected(true);

            String f1 = textArea1.getFont().getFamily();
             System.out.println(f1);
            textArea1.setFont(Font.font(f1, 12));

        }
        else if (d.equals("14")){
             dc.setSelected(false);
             dc2.setSelected(false);
             dcs.setSelected(false);
             cc.setSelected(true);
             String f1 = textArea1.getFont().getFamily();
             textArea1.setFont(Font.font(f1, 14));

         }
       else  if (d.equals("16")){
             dc.setSelected(false);
             dc2.setSelected(false);
             cc.setSelected(false);
             dcs.setSelected(true);

             String f1 = textArea1.getFont().getFamily();
             textArea1.setFont(Font.font(f1, 16));
         }

    }

    public void fuente (ActionEvent actionEvent) {
        String d = ((CheckMenuItem) actionEvent.getSource()).getText();
        if (d.equals("Arial")){
            Times.setSelected(false);
           Comic.setSelected(false);
            Verdana.setSelected(false);
            Arial.setSelected(true);

            Double f1 = textArea1.getFont().getSize();
            textArea1.setFont(Font.font("Arial", f1));
            textArea1.setFont(Font.font(f1));
        }
        else if (d.equals("Comic Sans")){
            Times.setSelected(false);
            Arial.setSelected(false);
            Verdana.setSelected(false);
            Comic.setSelected(true);

            Double f1 = textArea1.getFont().getSize();
            textArea1.setFont(Font.font("sans-serif", f1));

        }
        if (d.equals("Times New")){
            Arial.setSelected(false);
            Comic.setSelected(false);
            Verdana.setSelected(false);
           Times.setSelected(true);

            Double f1 = textArea1.getFont().getSize();
            textArea1.setFont(Font.font("Times new roman", f1));

        }
        if (d.equals("Verdana")){
            Arial.setSelected(false);
            Comic.setSelected(false);
            Times.setSelected(false);
            Verdana.setSelected(true);

            Double f1 = textArea1.getFont().getSize();
            textArea1.setFont(Font.font("Verdana", f1));
        }

    }

    public void abrir (ActionEvent actionEvent) throws IOException {

        if (!textArea1.getText().equals("")) {


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setContentText("Quieres guardar?");
            ButtonType buttonTypeOne = new ButtonType("Si");
            ButtonType buttonTypeNO = new ButtonType("NO");
            ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeNO, buttonTypeCancel);
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == buttonTypeOne) {

                guardar(actionEvent);
                System.out.println(j);
                if (j==false){
                }
                else {
                    abrir2();
                }
            } else if (result.get() == buttonTypeNO) {
                abrir2();
            }
            else {
            }
        }
        else {
            abrir2();
        }
    }

    public void guardar (ActionEvent actionEvent) throws IOException {
        try{

            if (File1==null) {


                FileChooser fileChooser = new FileChooser();
                File file = fileChooser.showSaveDialog(stage);
                // Create file
                FileWriter fstream = new FileWriter(file);
                BufferedWriter out = new BufferedWriter(fstream);
                out.write(textArea1.getText());
                out.close();
                j=true;
                File1=file.getAbsolutePath();

            }
            else {
                FileWriter fstream = new FileWriter(File1);
                BufferedWriter out = new BufferedWriter(fstream);
                out.write(textArea1.getText());
                j=true;
                out.close();

            }


        }catch (Exception e){
            System.err.println("Error444: " + e.getMessage());
            j=false;
        }

    }

    public void guardarComo (ActionEvent actionEvent) throws IOException {
        try {


            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(stage);
            // Create file
            FileWriter fstream = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(textArea1.getText());
            out.close();
            File1=file.getAbsolutePath();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());

        }
    }
    public void nuevo (ActionEvent actionEvent) throws IOException {
        if (!textArea1.getText().equals("")) {


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            //alert.setHeaderText("Look, a Confirmation Dialog");
            alert.setContentText("Quieres guardar?");
            ButtonType buttonTypeOne = new ButtonType("Si");
            ButtonType buttonTypeNO = new ButtonType("NO");
            ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            //ButtonType buttonTypeThree = new ButtonType("Three");
            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeNO, buttonTypeCancel);
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == buttonTypeOne) {

                guardar(actionEvent);
                System.out.println(j);
                if (j==false){
                }
                else {
                    textArea1.setText("");
                    File1 = null;
                }
            } else if (result.get() == buttonTypeNO) {
                textArea1.setText("");
                File1=null;

            }
            else {

            }
        }


    }




    public void close1(ActionEvent actionEvent) {
        Platform.exit();

    }

    public void abrir2() throws IOException {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);

        File1 = (file.getAbsolutePath());
        FileReader fileReader = new FileReader(file);
        //StringBuilder stringBuffer = new StringBuilder();


        BufferedReader bufferedReader = null;

        try {

            bufferedReader = new BufferedReader(fileReader);

            String text;
            while ((text=bufferedReader.readLine()) != null) {
                //System.out.println(bufferedReader.readLine());
                textArea1.setText(textArea1.getText() + "\n"+text);
            }

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {

            }

        }
        Main.gt.setTitle("Editor" + file.getName());
        textArea1.setText("");
    }






    public void copy(ActionEvent actionEvent) {

        textArea1.copy();
    }

    public void paste (ActionEvent actionEvent) throws IOException, UnsupportedFlavorException {

        textArea1.paste();
    }

    public void undo (ActionEvent actionEvent) throws IOException, UnsupportedFlavorException {
        textArea1.undo();

    }

    public void copyDisable (){
        System.out.println("dddd");
        if (textArea1.getSelectedText().equals("")) {
            copy.setDisable(true);
        }
        else {
        paste.setDisable(false);
        copy.setDisable(false);
        }

    }
}




/* Metodos en desuso
    public static void setStringToClipboard(String stringContent) {

        StringSelection stringSelection = new StringSelection(stringContent);

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

    }

    public static String getStringFromClipboard() throws IOException, UnsupportedFlavorException {

        Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);


            if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {

                String text = (String) transferable.getTransferData(DataFlavor.stringFlavor);
                return text;



            }


        else
            return null;

    }


}



<Button mnemonicParsing="false" text="Copy">
                <graphic>
                    <ImageView fitHeight="16.0" fitWidth="16.0" pickOnBounds="true" preserveRatio="true">
                        <image>
                            <Image url="http://emilis.info/files/images/tango-icon-theme/16x16/actions/edit-copy.gif" />
                        </image>
                    </ImageView>
                </graphic>
            </Button>
          <Button mnemonicParsing="false" text="Paste">
              <graphic>
                  <ImageView fitHeight="16.0" fitWidth="16.0" pickOnBounds="true" preserveRatio="true">
                      <image>
                          <Image url="http://files.softicons.com/download/application-icons/must-have-icons-by-visualpharm/png/16/Paste.png" />
                      </image>
                  </ImageView>
              </graphic>
          </Button>
            <Button mnemonicParsing="false" text="Undo">
                <graphic>
                    <ImageView fitHeight="16.0" fitWidth="16.0" pickOnBounds="true" preserveRatio="true">
                        <image>
                            <Image url="http://megaicons.net/static/img/icons_sizes/8/1331/16/undo-icon.png" />
                        </image>
                    </ImageView>
                </graphic>
            </Button>
 */