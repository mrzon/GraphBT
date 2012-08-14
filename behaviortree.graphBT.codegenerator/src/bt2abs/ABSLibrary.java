/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt2abs;

/**
 *
 * @author Emerson
 */
public class ABSLibrary {
    private String name;
    public ABSLibrary(String n)
    {
        name = n;
    }
    public String getName()
    {
        return name;
    }
    @Override
    public String toString()
    {
        return "import "+name+";";
    }
}
