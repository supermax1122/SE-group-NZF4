package JTest;




import nz.ac.aut.ense701.gameModel.User;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class UserTest  {
    private User user;
     @Before
     public void setUp() {
        user = new User("name");
        
     }
    
    @Test
    public void testName(){      
         String name = "name";
         String name1 = user.getUserName();
         assertEquals(name, name1);
     }
    
    @Test
    public void testScore(){
        int score = 100;
        user.setScore(score);
        int score1 = user.getScore();
        assertEquals(score, score1);
        
    }
    
    

}