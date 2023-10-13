package sio.gestionsubventions;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import sio.gestionsubventions.Model.Structure;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class SubventionsController implements Initializable {
    HashMap<String, HashMap<String, TreeMap<Integer, ArrayList<Structure>>>> lesSubventions;
    TreeItem root;
    @FXML
    private AnchorPane apAffecter;
    @FXML
    private ListView lvVilles;
    @FXML
    private AnchorPane apStatistiques;
    @FXML
    private ListView lvSecteurs;
    @FXML
    private ComboBox cboAnnees;
    @FXML
    private TextField txtNomStructure;
    @FXML
    private TextField txtMontant;
    @FXML
    private Button btnAffecterSubvention;
    @FXML
    private Button btnMenuAffecter;
    @FXML
    private Button btnMenuStatistiques;
    @FXML
    private ListView lvVillesStats;
    @FXML
    private TreeView tvMontantsParSecteurs;
    @FXML
    private TreeView tvMontantsParAnnees;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        apAffecter.toFront();
        lesSubventions = new HashMap<>();
        lvVilles.getItems().addAll("Bordeaux", "Nantes", "Paris");
        lvSecteurs.getItems().addAll("Culture", "Education", "Santé", "Sport");
        cboAnnees.getItems().addAll(2020, 2021, 2022, 2023, 2024, 2025);
        cboAnnees.getSelectionModel().selectFirst();

        // Jeu d'essais au cas où :)
//        Structure structure1 = new Structure("Structure 1",1000);
//        Structure structure2 = new Structure("Structure 2",2000);
//        Structure structure3 = new Structure("Structure 3",3000);
//        Structure structure4 = new Structure("Structure 4",4000);
//        Structure structure5 = new Structure("Structure 5",5000);
//        Structure structure6 = new Structure("Structure 6",6000);
//        Structure structure7 = new Structure("Structure 7",7000);
//        Structure structure8 = new Structure("Structure 8",8000);
//        Structure structure9 = new Structure("Structure 9",9000);
//
//        ArrayList<Structure> lesStructuresDeBordeaux = new ArrayList<>();
//        lesStructuresDeBordeaux.add(structure1);
//        lesStructuresDeBordeaux.add(structure2);
//        lesStructuresDeBordeaux.add(structure3);
//
//        ArrayList<Structure> lesStructuresDeNantes = new ArrayList<>();
//        lesStructuresDeNantes.add(structure4);
//        lesStructuresDeNantes.add(structure5);
//        lesStructuresDeNantes.add(structure6);
//
//        ArrayList<Structure> lesStructuresDeParis = new ArrayList<>();
//        lesStructuresDeParis.add(structure7);
//        lesStructuresDeParis.add(structure8);
//        lesStructuresDeParis.add(structure9);
//
//        TreeMap<Integer,ArrayList<Structure>> lesAnneesDeBordeaux = new TreeMap<>();
//        lesAnneesDeBordeaux.put(2020, lesStructuresDeBordeaux);
//        lesAnneesDeBordeaux.put(2021, lesStructuresDeBordeaux);
//        lesAnneesDeBordeaux.put(2022, lesStructuresDeBordeaux);
//
//        TreeMap<Integer,ArrayList<Structure>> lesAnneesDeNantes = new TreeMap<>();
//        lesAnneesDeNantes.put(2020, lesStructuresDeNantes);
//        lesAnneesDeNantes.put(2021, lesStructuresDeNantes);
//        lesAnneesDeNantes.put(2022, lesStructuresDeNantes);
//        lesAnneesDeNantes.put(2023, lesStructuresDeNantes);
//
//        TreeMap<Integer,ArrayList<Structure>> lesAnneesDeParis = new TreeMap<>();
//        lesAnneesDeParis.put(2022, lesStructuresDeParis);
//        lesAnneesDeParis.put(2023, lesStructuresDeParis);
//        lesAnneesDeParis.put(2024, lesStructuresDeParis);
//
//        HashMap<String,TreeMap<Integer,ArrayList<Structure>>> lesSecteursDeBordeaux = new HashMap<>();
//        lesSecteursDeBordeaux.put("Santé", lesAnneesDeBordeaux);
//        lesSecteursDeBordeaux.put("Sport", lesAnneesDeBordeaux);
//
//        HashMap<String,TreeMap<Integer,ArrayList<Structure>>> lesSecteursDeNantes = new HashMap<>();
//        lesSecteursDeNantes.put("Education", lesAnneesDeNantes);
//        lesSecteursDeNantes.put("Culture", lesAnneesDeNantes);
//
//        HashMap<String,TreeMap<Integer,ArrayList<Structure>>> lesSecteursDeParis = new HashMap<>();
//        lesSecteursDeParis.put("Culture", lesAnneesDeParis);
//
//        lesSubventions.put("Bordeaux",lesSecteursDeBordeaux);
//        lesSubventions.put("Nantes",lesSecteursDeNantes);
//        lesSubventions.put("Paris",lesSecteursDeParis);

    }

    @FXML
    public void btnMenuClicked(Event event) {
        if (event.getSource() == btnMenuAffecter) {
            apAffecter.toFront();
        } else if (event.getSource() == btnMenuStatistiques) {
            apStatistiques.toFront();
        }
    }

    @FXML
    public void btnAffecterSubventionClicked(Event event) {

        if (txtNomStructure.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText("");
            alert.setContentText("Saisir une structure");
            alert.showAndWait();
        } else if (txtMontant.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText("");
            alert.setContentText("Saisir un montant");
            alert.showAndWait();

        } else if (lvVilles.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText("");
            alert.setContentText("Choisir une ville");
            alert.showAndWait();
        } else if (lvSecteurs.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText("");
            alert.setContentText("Saisir un secteur");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("");
            alert.setContentText("Subvention Enregistrée");
            alert.showAndWait();
            affichageville();


        }


    }

    @FXML
    public void affichageville() {

        lvVillesStats.getItems().add(lvVilles.getSelectionModel().getSelectedItem().toString());

    }

    @FXML
    public void lvVillesStatsClicked(Event event) {
        int i = Integer.parseInt(txtMontant.getText());
        Structure Structure1 = new Structure(txtNomStructure.getText(), i);

        if (!lesSubventions.containsKey(lvVilles.getSelectionModel().getSelectedItem().toString())) {
            ArrayList<Structure> Structure = new ArrayList<>();
            Structure.add(Structure1);

            TreeMap<Integer, ArrayList<Structure>> annee = new TreeMap<>();

            int p = Integer.parseInt(cboAnnees.getValue().toString());
            annee.put(p, Structure);

            HashMap<String, TreeMap<Integer, ArrayList<Structure>>> secteur = new HashMap<>();

            secteur.put(lvSecteurs.getSelectionModel().getSelectedItem().toString(), annee);
            lesSubventions.put(lvVilles.getSelectionModel().getSelectedItem().toString(), secteur);


        } else {

            ArrayList<Structure> Structure = new ArrayList<>();
            Structure.add(Structure1);

            TreeMap<Integer, ArrayList<Structure>> annee = new TreeMap<>();

            int p = Integer.parseInt(cboAnnees.getValue().toString());
            annee.put(p, Structure);

            HashMap<String, TreeMap<Integer, ArrayList<Structure>>> secteur = new HashMap<>();

            secteur.put(lvSecteurs.getSelectionModel().getSelectedItem().toString(), annee);
            lesSubventions.put(lvVilles.getSelectionModel().getSelectedItem().toString(), secteur);
        }
        affichageparsecteur();

    }

    @FXML
    public void affichageparsecteur() {



            TreeItem Secteur1;


            root.getChildren().clear();

        for (String a : lesSubventions.keySet()) {
            TreeItem<String> noeudVille = new TreeItem<>(a);

            noeudVille.setExpanded(true);

            for (String i : lesSubventions.get(a).keySet()) {
                TreeItem<String> noeudSecteur = new TreeItem<>(i);

                noeudSecteur.setExpanded(true);

                    double totalmontantsecteur = 0.0;

                for (int o : lesSubventions.get(a).get(i).keySet()) {
                    for (Structure laStructure : lesSubventions.get(a).get(i).get(o)) {

                            totalmontantsecteur += laStructure.getMontant();
                    }
                }

                TreeItem<String> infosecteur = new TreeItem<>("Le montant total s'élève à : " + totalmontantsecteur);
                    noeudSecteur.getChildren().add(infosecteur);

                    noeudVille.getChildren().add(noeudSecteur);
            }

            root.getChildren().add(noeudVille);
        }
        // Ville-----Secteur----Annee

    }
}





