
import FileIO.FileIn;
import FileIO.ScoreRecord;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class FileOut {

    private File file;
    private ArrayList<ScoreRecord> scoreList;
    private OutputStream os;
    private OutputStreamWriter osWriter;
    private BufferedWriter writer;

    public FileOut() {
    }

    public FileOut(String filePath, ArrayList<ScoreRecord> scoreList) {
        this.scoreList = scoreList;

        file = new File(filePath);
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

    public void scoreListFileOut() throws IOException {
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

    public static void main(String[] args) throws IOException {

        FileIn scoreFileIn = new FileIn("scoreFile.txt");
        ArrayList<ScoreRecord> scoreList = scoreFileIn.ScoreRecordList();

        for (ScoreRecord a : scoreList) {
            System.out.println(a);
        }

        FileOut scoreListFileOut = new FileOut("scoreFile.txt", scoreList);

        scoreListFileOut.scoreListFileOut();

        FileIn scoreFileIn2 = new FileIn("scoreFile.txt");
        scoreList = scoreFileIn2.ScoreRecordList();
        for (ScoreRecord a : scoreList) {
            System.out.println(a);
        }
    }
}
