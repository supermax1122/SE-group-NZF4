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
    private int fulldurability;
    private int durability;
    private int droperate;    
    
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
            setDurability(3);
            setDroperate(1);
        }else{
            setDurability(1);
            setDroperate(0);
        }
    }
    
    /**
     * Durability drop
     */
    public void dropDurability (){
        use();
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
        durabilityReastore();
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
        
    public int getDurability() {
        return durability;
    }
    
    public void durabilityReastore(){
        durability = fulldurability;
    }

    public int getFulldurability() {
        return fulldurability;
    }

    private void setDurability(int durability) {
        this.durability = durability;
        this.fulldurability = durability;
    }

    public int getDroperate() {
        return droperate;
    }

    public void setDroperate(int dropreate) {
        this.droperate = dropreate;
    }    
    
    public void use (){
        durability = durability - droperate;
    }
    
    @Override
    public String toString (){
        if (this.getName().equalsIgnoreCase("Trap")) {
            if (isBroken()){
                return this.getName() + "- Broken";
            }else{
                return this.getName() + "- Durability(" + getDurability() + ")";
            }
        }else{
            return this.getName();
        }
    }
}
