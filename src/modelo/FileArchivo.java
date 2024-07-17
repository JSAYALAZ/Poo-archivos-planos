package modelo;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.File;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class FileArchivo implements Serializable {
    JFileChooser jf;
    File archivo;

    public FileArchivo() {
        jf = new JFileChooser();
    }

    public void escogerDirectorio(TextField txtDirectorio, TextArea txtPantalla) {
        try {
            jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            jf.showDialog(null, "Seleccionar");
            txtDirectorio.setText(jf.getSelectedFile().toString());
            txtPantalla.setText("Se seleccionado un directorio correctamente...");
        } catch (Exception e) {
            txtPantalla.setText("Error general: " + e.getMessage());
        }
    }

    public void GuardarCarpeta(String nomCarpeta, TextArea txtPantalla) {
        try {
            archivo = new File(jf.getSelectedFile(), nomCarpeta);
            archivo.mkdir();
            txtPantalla.setText("Se ha creado correctamente...");

        } catch (Exception e) {
            txtPantalla.setText("Error general dado: " + e.getMessage());
        }
    }

    public void BorrarCarpeta(Frame ventana, TextArea txtPantalla) {
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jf.showOpenDialog(ventana);
        archivo = jf.getSelectedFile();
        System.out.println(jf.getSelectedFile());
        if (archivo.getAbsolutePath() != null) {
            archivo.delete();
            txtPantalla.setText("Se a borrado correctamente...");
        }
    }

    public void GuardarArchivo(String nomArchivo, TextArea txtPantalla) {
        try {
            archivo = new File(jf.getSelectedFile(), nomArchivo + ".txt");
            try (PrintWriter escribirArchivo = new PrintWriter(archivo)) {
                escribirArchivo.write(txtPantalla.getText());
                escribirArchivo.close();
                txtPantalla.setText("Se ha creado correctamente...");
            } catch (Exception e) {
                txtPantalla.setText("Error dado: " + e.getMessage());
            }
        } catch (Exception e) {
            txtPantalla.setText("Error general: " + e.getMessage());
        }
    }

    public void BorrarArchivo(Frame ventana, TextArea txtPantalla) {
        jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jf.showOpenDialog(ventana);
        archivo = jf.getSelectedFile();
        System.out.println(jf.getSelectedFile());
        if (archivo.getAbsolutePath() != null) {
            archivo.delete();
            txtPantalla.setText("Se a borrado correctamente...");
        }
    }

    public void LeerArchivo(TextArea txtPantalla, TextField txtDirectorio) {
        jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jf.showOpenDialog(null);
        archivo = jf.getSelectedFile();
        txtDirectorio.setText(jf.getSelectedFile().toString());
        try (Scanner teclado = new Scanner(archivo)) {
            txtPantalla.setText("");
            while (teclado.hasNextLine()) {
                txtPantalla.append(teclado.nextLine() + "\n");
            }
        } catch (Exception e) {
            txtPantalla.setText("Error dado: " + e.getMessage());
        }

    }
}
