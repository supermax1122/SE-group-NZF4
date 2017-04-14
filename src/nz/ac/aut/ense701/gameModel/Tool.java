package nz.ac.aut.ense701.gameModel;

/**
 * This class represents a tool that can be found on the island
 * and gives the player any sort of advantage. 
 * 
 * @author AS
 * @version July 2011
 */

public class Tool extends Item 
{
    private boolean broken;
    private Durability durability;
    
    /**
     * Construct a tool with known attributes.
     * @param pos the position of the tool
     * @param name the name of the tool
     * @param description a longer description of the tool
     * @param weight the weight of the tool
     * @param size the size of the tool
     */
    public Tool(Position pos, String name, String description, double weight, double size) 
    {
        super(pos, name, description, weight, size);
        this.broken = false;
        if (this.getName().equalsIgnoreCase("Trap")){
            durability = new Durability (3, 1);
        }else{
            durability = new Durability (4, 0);            
        }
    }
    
    /**
     * Durability drop
     */
    public void dropDurability (){
        durability.use();
    }
    
    public Durability getDurability () {
        return durability;
    }
    
    /**
     * Break the tool
     */
    public void setBroken()
    {
        broken = true;
    }
    
    /**
     * Fix the tool
     */
    public void fix()
    {
        durability.durabilityReastore();
        broken = false;
    }
    
    /**
     * Is tool broken
     * @return true if broken
     */
    public boolean isBroken()
    {
        return this.broken;
    }
    
    /**
    * Check if this tool is a predator trap
    * @return true if trap
     */
    public boolean isTrap()
    {
      String name = this.getName();
      return name.equalsIgnoreCase("Trap");
    }
 
    /**
    * Check if this tool is a screwdriver
    * @return true if screwdriver
     */    
    public boolean isScrewdriver() {
       String name = this.getName();
      return name.equalsIgnoreCase("Screwdriver"); 
    }
    
    
    @Override
    public String getStringRepresentation() 
    {
        return "T";
    }
    
    @Override
    public String toString (){
        if (this.getName().equalsIgnoreCase("Trap")) {
            if (isBroken()){
                return this.getName() + "- Broken";
            }else{
                return this.getName() + "- Durability(" + durability.getDurability() + ")";
            }
        }else{
            return this.getName();
        }
    }
}
