package nz.ac.aut.ense701.gameModel;

import nz.ac.aut.ense701.gameModel.ScoreRecord;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileIn {

    private File file;
    private BufferedReader reader;
    private InputStream is;
    private InputStreamReader isReader;

    public FileIn() {
    }

    public FileIn(String filePath) {
        file = new File(filePath);
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

    public ArrayList<ScoreRecord> ScoreRecordList() throws IOException {
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

    public static void main(String[] args) throws IOException {

        FileIn ScoreListFileIn = new FileIn("scoreFile.txt");

        ArrayList<ScoreRecord> scoreRecordList = ScoreListFileIn.ScoreRecordList();

        for (ScoreRecord a : scoreRecordList) {
            System.out.println(a);
        }

    }
}
