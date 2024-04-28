package constants;

public enum Path {
    COINS_PATH("D:\\coding\\java\\midtermProject\\AmusementPark\\icones\\coins"),
    SPECIAL_COIN_PATH("D:\\coding\\java\\midtermProject\\AmusementPark\\icones\\specialCoins"),
    GAMES_PATH("D:\\coding\\java\\midtermProject\\AmusementPark\\icones\\games"),
    BACKGROUND_PATH("D:\\coding\\java\\midtermProject\\AmusementPark\\icones\\background"),
    MAIN_REPOSITORY("D:\\coding\\java\\midtermProject\\AmusementPark\\icones"),
    AVATAR_PATH("D:\\coding\\java\\midtermProject\\AmusementPark\\icones\\avatars"),
    SLOT_MACHIN_PATH("D:\\coding\\java\\midtermProject\\AmusementPark\\icones\\slotMachine");


    private final String path;

    private Path(String path){
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
}
