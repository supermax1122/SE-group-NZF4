package nz.ac.aut.ense701.gui;


import nz.ac.aut.ense701.gameModel.User;
import nz.ac.aut.ense701.GUITools.MyBackGround;
import nz.ac.aut.ense701.GUITools.MyButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;  
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;  
import javax.swing.JTextField;
import nz.ac.aut.ense701.gameModel.Player;
  
/** 
 *  
 * @author HongzhouSha
 * 
 */  
public class StartMenuGUI extends JFrame {  
  
    private static final int WIDTH = 800;//width of window
    private static final int HEIGHT = 600;//height of window
    private UserLogIn login;
    private MyBackGround my;
    
    public static void main(String[] args) throws InterruptedException {  
    
    	StartMenuGUI ge = new StartMenuGUI();  
        ge.ShowMoon(); 

    }  
  
    public void ShowMoon(){  
    	
        MyPanel panel = new MyPanel();//get the object of MyPanel  
        Thread t = new Thread(panel);//Start thread
        t.start();  
        this.add(panel);//add into the window  
         
    }  
      
    public StartMenuGUI(){  
        this.setSize(WIDTH, HEIGHT);//set width and height
        this.setTitle("KiwiIsland");//tile
        this.setResizable(false);//size of window cannot be change  
        this.setLocationRelativeTo(null);//set indow in the middle
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//when colse the window 
        login = new UserLogIn(){
        	 protected void paintComponent(Graphics g) {    
                 ImageIcon icon = new ImageIcon("image/islandlogin.jpg");    
                 Image img = icon.getImage();    
                 g.drawImage(img, 0, 0, 800, 200, icon.getImageObserver());
                 
             }  
        };
        Container contentPane = this.getContentPane();  
	    contentPane.add(login, BorderLayout.SOUTH);
        this.setVisible(true);  
        
        
        }  
     private void Dispose(){
		this.dispose();
    }
      /**
     * Inner class for UserLogIn
     * @author Hongzhousha
     *
     */
    public class UserLogIn extends JPanel{
        //Create the User Name.
 	private JLabel nameTextLabel = new JLabel("User Name：");
 	private JTextField nameField = new JTextField(25);

 	//Create buttons.
 	private MyButton YesButton = new MyButton("image/StartGame1.jpg", "image/StartGame2.jpg", "image/StartGame3.jpg");
 	private MyButton NoButton = new MyButton("image/Exit1.jpg", "image/Exit2.jpg", "image/Exit3.jpg");
 	
 	private User user;
         
         @SuppressWarnings("unchecked")
 	public UserLogIn(){
         	
        		GridBagLayout layout = new GridBagLayout();
             this.setLayout(layout);
         	nameTextLabel.setForeground(Color.RED);

            	
         
             GridBagConstraints gbc = new GridBagConstraints();
             gbc.gridx = 0;
             gbc.gridy = 0;
             gbc.gridwidth = 1;
             gbc.weightx = 60;
             gbc.fill = GridBagConstraints.NONE;
             this.add(nameTextLabel, gbc);
             GridBagConstraints gbc_1 = new GridBagConstraints();
             gbc_1.gridx = 0;
             gbc_1.gridy = 5;
             gbc_1.gridwidth = 6;
             gbc_1.weightx = 60;
             gbc_1.fill = GridBagConstraints.NONE;
             this.add(nameField, gbc_1);
             GridBagConstraints gbc_2 = new GridBagConstraints();
             gbc_2.gridx = 0;
             gbc_2.gridy = 6;
           
             gbc_2.fill = GridBagConstraints.NONE;
            this.add(YesButton, gbc_2);
             GridBagConstraints gbc_3 = new GridBagConstraints();
             gbc_3.gridx = 2;
             gbc_3.gridy = 7;
     
             gbc_3.fill = GridBagConstraints.NONE;
            this.add(NoButton, gbc_3);


 		initializeListeners();
 	
 		
 		
 		this.user = new User();

 	}
         	//initialize listenners
 	private void initializeListeners() {
 			this.YesButton.addActionListener(new ActionListener() {
 				public void actionPerformed(ActionEvent e) {
 					try {
                                             login();
                                                 
 					} catch (Exception e1) {
 						// TODO Auto-generated catch block
 						e1.printStackTrace();
 					}
 				}
 			});
 			this.NoButton.addActionListener(new ActionListener() {
 				public void actionPerformed(ActionEvent e) {
 					System.exit(0);
 				
 				}
 			});
 	}
         
         private void login() throws Exception {
 			if (this.nameField.getText().equals("")) {
 				JOptionPane.showConfirmDialog(null, "Plese Enter Your Name", "warning", 
 						JOptionPane.OK_CANCEL_OPTION);
 				return;
 			}
 			//Set User's detail
 			setUser();
 			//this.setVisible(false);
 			Dispose();
                         
//                          // create the game object
//                         final Game game = new Game();
//                         // create the GUI for the game
//                         final KiwiCountUI  gui  = new KiwiCountUI(game);
//                         // make the GUI visible
                         java.awt.EventQueue.invokeLater(new Runnable() 
                         {
                             @Override
                             public void run() 
                             {
                             	GameSelectGUI ui =new GameSelectGUI();
                             	
                             }
                         });
                         
 	   }
         
         private void setUser() {
 		//Create User
 		String name = this.nameField.getText();     
 		this.user.setUserName(name);
                System.out.println("User Name is :"+this.user.getUserName());
 	}
 	

     
 }
/** 
 *  Runnable
 * @author HongzhouSha
 * 
 */  
class MyPanel extends JPanel implements Runnable{  
  
    private int x = 0;  
    private int y = 0;  
    private String url="sk.png"; 
    private Image k;  
    private ImageIcon icon;    
    private String url1="image/islandup.jpg"; 
    private InputStream in; 
    private UserLogIn login;
    
    
    public MyPanel(){  
        super(); 
      
        
    }
      
    @Override  
    public void paint(Graphics g) {  
       
        super.paint(g);  
 
        try {  
            in = new FileInputStream(url1);   
            BufferedImage image = ImageIO.read(in);  
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(),  
                    this);  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }   
 
        icon = new ImageIcon("image/k.png");  
        k = icon.getImage();               
        g.drawImage(k, x, y, null); 
        icon = new ImageIcon("image/i.png");  
        k = icon.getImage();               
        g.drawImage(k, 80, y, null); 
        icon = new ImageIcon("image/w.png");  
        k = icon.getImage();               
        g.drawImage(k, 120, y, null); 
        icon = new ImageIcon("image/i.png");  
        k = icon.getImage();               
        g.drawImage(k, 235, y, null); 
        icon = new ImageIcon("image/i.png");  
        k = icon.getImage();               
        g.drawImage(k, 345, y, null); 
        icon = new ImageIcon("image/s.png");  
        k = icon.getImage();               
        g.drawImage(k, 390, y, null); 
        icon = new ImageIcon("image/l.png");  
        k = icon.getImage();               
        g.drawImage(k, 460, y, null); 
        icon = new ImageIcon("image/a.png");  
        k = icon.getImage();               
        g.drawImage(k, 540, y, null); 
        icon = new ImageIcon("image/n.png");  
        k = icon.getImage();               
        g.drawImage(k, 630, y, null); 
        icon = new ImageIcon("image/d.png");  
        k = icon.getImage();               
        g.drawImage(k, 720, y, null); 
          
        paintComponents(g);  
    }  
    @Override  
    public void run() {  
        while(y<=150){
            y++;   
            try {  
                Thread.sleep(60); 
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
            repaint();
        }  
          
    }  
      
      
}    
      
}