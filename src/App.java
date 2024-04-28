import board.Board;
import welcomePage.OnAcceptClickListener;
import welcomePage.WelcomePage;

public class App implements OnAcceptClickListener{
    private WelcomePage welcomePage;
    public static void main(String[] args) throws Exception {
        App app = new App(); // Create an instance of App
        app.welcomePage = new WelcomePage(app); // Use the instance to create the WelcomePage
    }

    @Override
    public void onAcceptClick() {
        Board board = new Board(welcomePage.getPlayer(1), welcomePage.getPlayer(2));
        board.setVisible(true);
        
    }
}