package constants;

public enum Path {
    COINS_PATH("D:\\coding\\java\\Projects\\mid-term\\AmusementPark\\icones\\coins"),
    SPECIAL_COIN_PATH("D:\\coding\\java\\Projects\\mid-term\\AmusementPark\\icones\\specialCoins"),
    GAMES_PATH("D:\\coding\\java\\Projects\\mid-term\\AmusementPark\\icones\\games"),
    BACKGROUND_PATH("D:\\coding\\java\\Projects\\mid-term\\AmusementPark\\icones\\background"),
    MAIN_REPOSITORY("D:\\coding\\java\\Projects\\mid-term\\AmusementPark\\icones"),
    AVATAR_PATH("D:\\coding\\java\\Projects\\mid-term\\AmusementPark\\icones\\avatars"),
    SLOT_MACHIN_PATH("D:\\coding\\java\\Projects\\mid-term\\AmusementPark\\icones\\slotMachine");


    private final String path;

    private Path(String path){
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
}
