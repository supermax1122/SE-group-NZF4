package nz.ac.aut.ense701.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.Terrain;

/*
 * Panel for representing a single GridSquare of the island on the GUI.
 * 
 * @author AS
 * @version 1.0 - created
 */

public class GridSquarePanel extends javax.swing.JPanel 
{
    /** 
     * Creates new GridSquarePanel.
     * @param game the game to represent
     * @param row the row to represent
     * @param column the column to represent
     */
    public GridSquarePanel(Game game, int row, int column)
    {
        this.game   = game;
        this.row    = row;
        this.column = column;
        initComponents();
        lblText.setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        boolean squareVisible = game.isVisible(row, column);
        boolean squareExplored = game.isExplored(row, column);
        boolean iscurrentrow = (game.getPlayer().getPosition().getRow() == row);
        boolean iscurrentcol = (game.getPlayer().getPosition().getColumn() == column);

        if ((squareVisible && !squareExplored)||this.Isvisible||(iscurrentrow&&iscurrentcol)) {
            String imagePath = "image/"+imageName;
            ImageIcon icon = new ImageIcon(imagePath);
            Image img = icon.getImage();
            Dimension size = this.getParent().getSize();
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
            if (iscurrentrow&&iscurrentcol){
                ImageIcon ico = new ImageIcon("image/maincharacter.png");
                Image imge = ico.getImage();
                g.drawImage(imge, 0, 0, this.getWidth(), this.getHeight(), null);                
            }
            this.Isvisible = true;
        }
        if (this.showOccupant){
            char []arrays = this.lblText.getText().toCharArray();
            for (int i = 0; i < arrays.length; i++){
                if (arrays[i] == 'H'){
                    ImageIcon ico = new ImageIcon("image/hazard.png");
                    Image imge = ico.getImage();
                    g.drawImage(imge, 0, 0, this.getWidth(), this.getHeight(), null);                
                    System.out.println(arrays[i]);            
                }
                if (arrays[i] == 'T'){
                    ImageIcon ico = new ImageIcon("image/toolbox.png");
                    Image imge = ico.getImage();
                    g.drawImage(imge, 0, 0, this.getWidth(), this.getHeight(), null);                
                    System.out.println(arrays[i]);            
                }
            }
        }
    }
    
    public void setImagename (String imageName){
        this.imageName = imageName;
    }
    
    public void setOccupantRepresentation (String OccupantRepresentation){
    }
    
    /**
     * Updates the representation of the grid square panel.
     */
    public void update()
    {
        // get the GridSquare object from the world
        Terrain terrain   = game.getTerrain(row, column);
        boolean squareVisible = game.isVisible(row, column);
        boolean squareExplored = game.isExplored(row, column);
        
        Color  color;
        
        switch ( terrain )
        {
            case SAND     : setImagename("sand.jpg");/*color = Color.YELLOW*/; break;
            case FOREST   : setImagename("forest.jpg")/*color = Color.GREEN*/;  break;
            case WETLAND : setImagename("wetland.jpg")/*color = Color.BLUE*/; break;
            case SCRUB : setImagename("scrub.jpg")/*color = Color.DARK_GRAY*/;   break;
            case WATER    : setImagename("water.jpg")/*color = Color.CYAN*/;   break;
            default  : color = Color.LIGHT_GRAY; break;
        }
        
       if ( squareExplored || squareVisible )
        {
            // Set the text of the JLabel according to the occupant
            lblText.setText(game.getOccupantStringRepresentation(row,column));
            this.showOccupant = true;
            this.repaint();
            // Set the colour. 
/*            if ( squareVisible && !squareExplored ) 
            {
                // When explored the colour is brighter
                color = new Color(Math.min(255, color.getRed()   + 128), 
                                  Math.min(255, color.getGreen() + 128), 
                                  Math.min(255, color.getBlue()  + 128));
            }
            lblText.setBackground(color);*/
            // set border colour according to 
            // whether the player is in the grid square or not
            setBorder(game.hasPlayer(row,column) ? activeBorder : normalBorder);
        }
        else
        {
            lblText.setText("");
            lblText.setBackground(null);
            this.Isvisible = false;
            this.showOccupant = false;
            setBorder(normalBorder);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblText = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(new java.awt.BorderLayout());

        lblText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblText.setText("content");
        lblText.setOpaque(true);
        add(lblText, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblText;
    // End of variables declaration//GEN-END:variables
    
    private Game game;
    private int row, column;
    private String imageName;
    boolean Isvisible = false;
    boolean showOccupant = false;
            
    private static final Border normalBorder = new LineBorder(Color.BLACK, 1);
    private static final Border activeBorder = new LineBorder(Color.RED, 3);
}
