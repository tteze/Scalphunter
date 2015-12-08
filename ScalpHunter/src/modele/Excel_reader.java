/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author Théophile
 */
public class Excel_reader {

    private String path = "Documents\\cards.xls";
    ArrayList<Card> cards;

    public Excel_reader() {
        cards = new ArrayList();
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(new File(path));
            Sheet sheet = workbook.getSheet(0);
            int nb_cartes = Integer.valueOf(sheet.getCell(1, 1).getContents());

            for (int i = 3; i < nb_cartes + 3; i++) {
                String name = sheet.getCell(0, i).getContents();
                int cost = Integer.valueOf(sheet.getCell(1, i).getContents());
                int att = Integer.valueOf(sheet.getCell(2, i).getContents());
                int def = Integer.valueOf(sheet.getCell(3, i).getContents());
                cards.add(new Minion(name, cost, att, def));
            }
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (workbook != null) {
                /* On ferme le worbook pour libérer la mémoire */
                workbook.close();
            }
        }

    }

    public ArrayList<Card> getCards() {
        return cards;
    }

}
