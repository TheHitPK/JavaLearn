package pokedexPackage;

import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Tabla {

    //Datos de prueba, podria tener aqui una clase que me los de, clase la cual podria consultar una base de datos.
    private static final String[] HEADERS = new String[]{"header1", "header2"};

    private static final String[][] DATOS_DE_TABLA = new String[][]{
            {"hola", " hola otra vez"},
            {"ola ola", "jelou jelou"}
    };

    private static final String[][] OTROS_DATOS_PARA_OTRA_TABLA = new String[][]{
            {"nuevos", " datos"},
            {"para", "comparar"}
    };


    public static void main(String[] args) {
        JFrame principalPanel = createPrincipalFrame(1024, 1000);

        JPanel panelWithData = createPanel(null);
        JScrollPane tablaDatosPrimerTrimestre = createTableWithScroll(DATOS_DE_TABLA, HEADERS, 100, 200, 200, 300);
        JScrollPane tablaDatosSegundoTrimestre  = createTableWithScroll(OTROS_DATOS_PARA_OTRA_TABLA, HEADERS, 600, 200, 200, 300);

        panelWithData.add(tablaDatosPrimerTrimestre);
        panelWithData.add(tablaDatosSegundoTrimestre);

        principalPanel.add(panelWithData);
        principalPanel.setVisible(true);
    }

    private static JFrame createPrincipalFrame(int width, int height) {
        JFrame principalPanel = new JFrame("frame principal");
        principalPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principalPanel.setSize(width, height);
        return principalPanel;
    }

    private static JPanel createPanel(LayoutManager layoutManager) {
        return new JPanel(layoutManager);
    }

    private static JScrollPane createTableWithScroll(String[][] data, String[] headers, int x, int y, int width, int height){
        JTable jTable = new JTable(data, headers);
        JScrollPane scrollPane = new JScrollPane(jTable);
        scrollPane.setBounds(x, y, width, height);
        return scrollPane;
    }


}
