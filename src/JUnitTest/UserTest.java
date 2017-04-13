package JUnitTest;




import LogInUI.User;
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
         String name1 = user.getName();
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