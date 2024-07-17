package vista;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import modelo.FileArchivo;

public final class Ventana extends Frame{
    FileArchivo archivo;
    public Ventana(){
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        ventanaPrincipal();
        this.setVisible(true);
    }
    
    public void ventanaPrincipal(){
        Panel panel1 = new Panel();
        Panel panel2 = new Panel(new GridLayout(5,1));
        Panel panel3 = new Panel();
        Panel panel4 = new Panel(new BorderLayout());
        Panel panel5 = new Panel();
        Panel panel6 = new Panel();
        Label lblTitulo = new Label("Bienvenido al sistema para leer y guardar alchivos .txt");
        Label lblArchivo = new Label("Nombre del archivo:");
        Label lblDirectorio = new Label("Directorio:");
        TextField txtArchivo = new TextField(40);
        TextField txtDirectorio = new TextField();
        TextArea txtPantalla = new TextArea("Digame que quiere que contenga el archivo |.txt|");
        Button btnGuardar = new Button("Guardar");
        Button btnBorrar = new Button("Borrar");
        Button btnSeleccionar = new Button("Seleccionar");
        Button btnCarpetas = new Button("Cambiar a crear/borrar carpetas");
        Button btnLeer = new Button("Leer archivos");
        this.add(panel1,BorderLayout.NORTH);
        this.add(panel5,BorderLayout.CENTER);
        this.add(panel4,BorderLayout.SOUTH);
        panel1.setBackground(Color.LIGHT_GRAY);
        panel2.setBackground(Color.LIGHT_GRAY);
        panel3.setBackground(Color.LIGHT_GRAY);
        panel4.setBackground(Color.LIGHT_GRAY);
        panel5.setBackground(Color.LIGHT_GRAY);
        panel6.setBackground(Color.LIGHT_GRAY);
        panel5.add(panel2);
        panel5.add(panel3);
        panel1.add(lblTitulo);
        panel2.add(lblArchivo);
        panel2.add(txtArchivo);
        panel2.add(lblDirectorio);
        panel2.add(txtDirectorio);
        panel2.add(btnSeleccionar);
        panel3.add(btnGuardar);
        panel3.add(btnBorrar);
        panel3.add(btnLeer);
        panel4.add(txtPantalla,BorderLayout.CENTER);
        panel4.add(panel6,BorderLayout.SOUTH);
        panel6.add(btnCarpetas);
        lblTitulo.setFont(new Font("Serif", Font.BOLD, 18));
        lblArchivo.setFont(new Font("Serif", ABORT, 12));
        lblDirectorio.setFont(new Font("Serif", ABORT, 12));
        archivo = new FileArchivo();
        btnSeleccionar.addActionListener((ActionEvent)->{
            archivo.escogerDirectorio(txtDirectorio,txtPantalla);
        });
        btnGuardar.addActionListener((ActionEvent)->{
            archivo.GuardarArchivo(txtArchivo.getText(),txtPantalla);
        });
        btnBorrar.addActionListener((ActionEvent)->{
            archivo.BorrarArchivo(this,txtPantalla);
        });
        btnLeer.addActionListener((ActionEvent)->{
            archivo.LeerArchivo(txtPantalla, txtDirectorio);
        });
        btnCarpetas.addActionListener((ActionEvent)->{
            this.dispose();
            ventanaCarpetas();
        });
    }

    public void ventanaCarpetas(){
        Frame ventana2 = new Frame();
        Panel panel1 = new Panel();
        Panel panel2 = new Panel(new GridLayout(5,1));
        Panel panel3 = new Panel();
        Panel panel4 = new Panel(new BorderLayout());
        Panel panel5 = new Panel();
        Panel panel6 = new Panel();
        Label lblTitulo = new Label("Bienvenido al sistema para crear y borrar carpetas");
        Label lblDirectorio = new Label("Seleccione un directorio:");
        Label lblCarpeta = new Label("Nombre de la carpeta:");
        TextField txtDirectorio = new TextField(40);
        TextField txtCarpeta = new TextField();
        TextArea txtPantalla = new TextArea("Aqui... Dira si hubo algun error o no");
        Button btnGuardar = new Button("Guardar");
        Button btnBorrar = new Button("Borrar");
        Button btnSeleccionar = new Button("Seleccionar");
        Button btnArchivos = new Button("Cambiar a crear/borrar archivos");
        ventana2.setLayout(new BorderLayout());
        ventana2.add(panel1,BorderLayout.NORTH);
        ventana2.add(panel5,BorderLayout.CENTER);
        ventana2.add(panel4,BorderLayout.SOUTH);
        ventana2.setSize(600,400);
        ventana2.setLocationRelativeTo(null);
        panel1.setBackground(Color.LIGHT_GRAY);
        panel2.setBackground(Color.LIGHT_GRAY);
        panel3.setBackground(Color.LIGHT_GRAY);
        panel4.setBackground(Color.LIGHT_GRAY);
        panel5.setBackground(Color.LIGHT_GRAY);
        panel6.setBackground(Color.LIGHT_GRAY);
        panel5.add(panel2);
        panel5.add(panel3);
        panel1.add(lblTitulo);
        panel2.add(lblCarpeta);
        panel2.add(txtCarpeta);
        panel2.add(lblDirectorio);
        panel2.add(txtDirectorio);
        panel2.add(btnSeleccionar);
        panel3.add(btnGuardar);
        panel3.add(btnBorrar);
        panel4.add(txtPantalla,BorderLayout.CENTER);
        panel4.add(panel6,BorderLayout.SOUTH);
        panel6.add(btnArchivos);
        lblTitulo.setFont(new Font("Serif", Font.BOLD, 18));
        lblCarpeta.setFont(new Font("Serif", ABORT, 12));
        lblDirectorio.setFont(new Font("Serif", ABORT, 12));
        archivo = new FileArchivo();
        btnSeleccionar.addActionListener((ActionEvent)->{
            archivo.escogerDirectorio(txtDirectorio,txtPantalla);

        });
        btnGuardar.addActionListener((ActionEvent)->{
            archivo.GuardarCarpeta(txtCarpeta.getText(),txtPantalla);
        });
        btnBorrar.addActionListener((ActionEvent)->{
            archivo.BorrarCarpeta(ventana2,txtPantalla);
        });
        ventana2.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        btnArchivos.addActionListener((ActionEvent)->{
            ventana2.dispose();
            this.setVisible(true);
        });
        ventana2.setVisible(true);
    }
}
