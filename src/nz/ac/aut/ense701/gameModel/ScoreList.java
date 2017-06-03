/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gameModel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marvin'PC
 */
public class ScoreList {

    private File file;
    private BufferedReader reader;
    private InputStream is;
    private InputStreamReader isReader;
    public final static String FILE_PATH = "scoreFile.txt";
    //  private File file;
    //  private ArrayList<ScoreRecord> scoreList;
    private OutputStream os;
    private OutputStreamWriter osWriter;
    private BufferedWriter writer;

    public ArrayList<ScoreRecord> ScoreRecordList() throws IOException {
        FileIn();
        ArrayList<ScoreRecord> readRecordtList = null;
        String txtLine = null;

        if (reader != null) {
            readRecordtList = new ArrayList<ScoreRecord>();

            while ((txtLine = reader.readLine()) != null) {
                ScoreRecord aScoreRecord = new ScoreRecord();
                aScoreRecord.setName(txtLine);
                if ((txtLine = reader.readLine()) != null) {
                    aScoreRecord.setMapNo(txtLine);
                }
                if ((txtLine = reader.readLine()) != null) {
                    aScoreRecord.setDiffculty(txtLine);
                }
                if ((txtLine = reader.readLine()) != null) {
                    aScoreRecord.setScore(txtLine);
                }

                readRecordtList.add(aScoreRecord);

            }
        }

        System.out.println("Score List is established\n");
        reader.close();
        is.close();
        isReader.close();
        file.exists();
        return readRecordtList;

    }

    public void scoreListFileOut(ArrayList<ScoreRecord> scoreList) throws IOException {
        Fileout();

        if (scoreList != null && writer != null) {
            String txtLine = null;
            for (ScoreRecord a : scoreList) {
                if ((txtLine = a.getName()) != null) {
                    writer.write(txtLine);
                    writer.newLine();
                }
                if ((txtLine = a.getMapNo()) != null) {
                    writer.write(txtLine);
                    writer.newLine();
                }
                if ((txtLine = a.getDiffculty()) != null) {
                    writer.write(txtLine);
                    writer.newLine();
                }
                if ((txtLine = a.getScore()) != null) {
                    writer.write(txtLine);
                    writer.newLine();
                }

            }

            os.flush();
            osWriter.flush();
            writer.flush();
            os.close();
            osWriter.close();
            writer.close();
            System.out.println("Score File Saved\n");
        }

    }

    public void addNewScoreRecord(ScoreRecord aScoreRecord) {

        try {
            ArrayList<ScoreRecord> scoreList=ScoreRecordList();
            scoreList.add(aScoreRecord);
            scoreListFileOut( scoreList);
        } catch (IOException ex) {
            Logger.getLogger(ScoreList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void Fileout() {
        // this.scoreList = scoreList;

        file = new File(FILE_PATH);
        if (file != null && file.isFile() && file.canRead()) {
            try {
                os = new FileOutputStream(file);
                osWriter = new OutputStreamWriter(os);
                writer = new BufferedWriter(osWriter);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void FileIn() {

        file = new File(FILE_PATH);
        if (file != null && file.isFile() && file.canRead()) {
            try {
                is = new FileInputStream(file);
                isReader = new InputStreamReader(is);
                reader = new BufferedReader(isReader);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws IOException {

        //    FileIn ScoreListFileIn = new FileIn("scoreFile.txt");
        //  ArrayList<ScoreRecord> scoreRecordList = ScoreListFileIn.ScoreRecordList();
        ArrayList<ScoreRecord> scoreRecordList = new ScoreList().ScoreRecordList();

        for (ScoreRecord a : scoreRecordList) {
            System.out.println(a);
        }

    }

}
