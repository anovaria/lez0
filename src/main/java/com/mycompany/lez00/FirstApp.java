
package com.mycompany.lez00;

import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class FirstApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // fase 1 dichiarazione variabili
        String nomefornito;                  //nome cliente
        String frasesaluto = "Benvenuto!";   //testo di benvenuto
        String risultato = "";               //variabile per l'output finale da spedire
        int sogliacontanti = 3000;
        int sogliaspesa = 1000;
        int costospedizione = 50;
        String msgSpedizione;
        int costopackaging = 5;
        int sogliacarta = 5000;
        float qta;
        float perc;
        float prezzo;
        float prezzofinale;                  // contiene in floatl'eleborazione per il calcolo prezzo
        int cod;
//fase 2 input utente
        String strprezzo = JOptionPane.showInputDialog("dimmi il prezzo");
        // converto il prezzo in float
        prezzo = Float.parseFloat(strprezzo);
        String strqta = JOptionPane.showInputDialog("dimmi la quantità");
        qta = Float.parseFloat(strqta);
        String strperc = JOptionPane.showInputDialog("dimmi la percentuale di sconto");
        perc = Float.parseFloat(strperc);
        try {
            String strcod = JOptionPane.showInputDialog(null, "dimmi codice tipo cliente (1 2 3 )");
            cod = Integer.parseInt(strcod);
        } catch (Exception err) {
        cod = 1;
        JOptionPane.showMessageDialog(null, "hai scritto un cod errato e ti è stato assegnato il cod 1 di fornitore locale");
        }
        //fase finale 3 elaborazione dati
        //calcolo prezzzo finale con sconto fornito e pezzi richiesti
        prezzofinale = (prezzo * qta) - (prezzo * qta * perc / 100);
        // se prezzo finale minore di sogliaspesa al prezzofinale aggiungo prezzospedizione
        if (prezzofinale <= sogliaspesa) {
            //aggiungo spese
            prezzofinale += costospedizione;
            //preparo messaggio spese
            msgSpedizione = "Applicato costo di spedizione di " + costospedizione + " Euro perche' inferiore a spesa minima di " + sogliaspesa + "  Euro + " + costopackaging + "  Euro per pezzo unitario";
        } else {
            msgSpedizione = "Applicato sconto di " + costospedizione + " Euro perche' superiore a spesa minima di " + sogliaspesa + " Euro";

        }
        prezzofinale = prezzofinale + (costopackaging * qta);

        JOptionPane.showMessageDialog(null, prezzofinale);

        nomefornito = JOptionPane.showInputDialog("dimmi un nome");
        risultato = frasesaluto;
        risultato = risultato + " ";
        risultato = risultato + nomefornito;
        risultato += "\nmi devi " + prezzofinale + " euro";
        // se prezzo finale sotto alla soglia contanti messaggio ok
        // altrimenti messaggio bonifico
        if (prezzofinale <= sogliacontanti) {
            risultato += "\npuoi pagare " + prezzofinale + " euro in contanti";

        } else {//caso > 3000
            //devo vdere se carta o bonifico
            if (prezzofinale > sogliacontanti && prezzofinale < sogliacarta) {
                risultato += "\npuoi pagare " + prezzofinale + " euro SOLO tramite bonifico o carta";
            } else {
                risultato += "\npuoi pagare " + prezzofinale + " euro SOLO tramite bonifico";

            }
        }

        risultato += "\n " + msgSpedizione;

        if (!(qta > 50 || prezzofinale > 2000) || perc == 0) {
            risultato += "\ncliente basic";

        } else {
            risultato += "\ncliente GOLD";
        }
        String msgCod;
        switch (cod) {
            case 1:
                msgCod = "\nFornitore locale";
                break;
            case 2:
                msgCod = "\nFornitore estero";
                break;
            default:
                msgCod = "\nFornitore altro";
                break;
        }
        risultato += msgCod;

        JOptionPane.showMessageDialog(null, risultato);

        // TODO code application logic here
    }

}
