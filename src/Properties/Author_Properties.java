package Properties;

import javax.swing.*;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class Author_Properties{
    public static void aboutProduct(){
        JOptionPane.showMessageDialog(null, "<html><p><h2><b>Aaron Keys</b></h2> is a user-friendly simple password manager designed to store and display</p><br>"+
        "<p>your important login credentials, including <i>'usernames'</i> and <i>'passwords'</i>.</p><br>"+
        "<p>This application is developed using <a href=\"https://www.bing.com/ck/a?!&&p=e7539abceaaa8b0eJmltdHM9MTY4ODA4MzIwMCZpZ3VpZD0xNDkzMmQxZi0wNDczLTYzNzMtMDBkZC0zZTVmMDU4NDYyOWQmaW5zaWQ9NTQwNA&ptn=3&hsh=3&fclid=14932d1f-0473-6373-00dd-3e5f0584629d&psq=java+swing&u=a1aHR0cHM6Ly9lbi53aWtpcGVkaWEub3JnL3dpa2kvU3dpbmdfKEphdmEp&ntb=1\"><b>Java Swing</b></a> for its intuitive graphical user interface.</p><br>"+
        "<p>It leverages the power of <a href=\"https://www.bing.com/ck/a?!&&p=6b47c75a78241444JmltdHM9MTY4ODA4MzIwMCZpZ3VpZD0xNDkzMmQxZi0wNDczLTYzNzMtMDBkZC0zZTVmMDU4NDYyOWQmaW5zaWQ9NTIyMA&ptn=3&hsh=3&fclid=14932d1f-0473-6373-00dd-3e5f0584629d&psq=mysql+wikipedia&u=a1aHR0cHM6Ly9lbi53aWtpcGVkaWEub3JnL3dpa2kvTXlTUUw&ntb=1\"><b>MySQL</b></a> database for efficient data storage and retrieval.</p><br>"+
        "<p>Additionally, <a href=\"https://www.bing.com/ck/a?!&&p=1a7312ec6f29fdeeJmltdHM9MTY4ODA4MzIwMCZpZ3VpZD0xNDkzMmQxZi0wNDczLTYzNzMtMDBkZC0zZTVmMDU4NDYyOWQmaW5zaWQ9NTQ1OA&ptn=3&hsh=3&fclid=14932d1f-0473-6373-00dd-3e5f0584629d&psq=html+wikipedia&u=a1aHR0cHM6Ly9lbi53aWtpcGVkaWEub3JnL3dpa2kvSFRNTA&ntb=1\"><b>HTML</b></a> is used for providing seemless contacts and information to the user.</p><br><br>"+
        "<p>To enhance usability, <b>Aaron Keys</b> offers a simple and intuitive interface that allows you</p><br>"+
        "<p>to easily input, view, and manage your login details. It eliminates the need to remember multiple</p><br>"+
        "usernames and passwords, providing a convenient solution for accessing your online accounts.</p><br><br><br>"+
        "<font color=\"red\"><h4><b>WARNING :</b></h4></font><br>"+
        "<p>While the application securely stores your data on your local storage system, it does not</p><br>"+
        "<p>provide any additional security measures such as encryption or <a href=\"https://www.bing.com/ck/a?!&&p=5d0ef4708d33d157JmltdHM9MTY4ODA4MzIwMCZpZ3VpZD0xNDkzMmQxZi0wNDczLTYzNzMtMDBkZC0zZTVmMDU4NDYyOWQmaW5zaWQ9NTIyNA&ptn=3&hsh=3&fclid=14932d1f-0473-6373-00dd-3e5f0584629d&psq=what+is+cloud+backup&u=a1aHR0cHM6Ly93d3cubmFraXZvLmNvbS9ibG9nL2ludHJvZHVjdGlvbi1jbG91ZC1iYWNrdXAv&ntb=1\">cloud backup</a>. Therefore, it is crucial to</p><br>"+
        "<p>ensure the safety of your memory and system to prevent unauthorized access.</p><br><br>"+
        "<p><i>Please be cautious and take necessary precautions when using Aaron Keys to safeguard your sensitive information.</i></p>"+
        "</html>", "About Product", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Images/Product logo.png"));
    }

    public static void aboutAuthor(){
        //UIManager.put("OptionPane.okButtonText", "Contant Us");
        JOptionPane.showMessageDialog(null, "<html><h4>Designed by </h4><h2><i><b>Little Thinker...</b></i></h2><br><br>"+
        "<p> Do you want to contant us, then click <b>Ok</b> button</p></html>", "Supports", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Images/Author logo.png"));

        JOptionPane.getRootFrame().dispose();
        try{
            openBrowser("lib/AaronKeys.html");
        }
        catch(IOException e){}
        catch(URISyntaxException e){}
    }

    private static void openBrowser(String url) throws IOException, URISyntaxException{
        /*URI uri = new URL(url).toURI();
        Desktop obj = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if(obj != null && obj.isSupported(Desktop.Action.BROWSE)){
            obj.browse(uri);
        }*/
        File file = new File(url);
        Desktop.getDesktop().browse(file.toURI());
    }
}
