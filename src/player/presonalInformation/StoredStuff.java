package player.presonalInformation;

public  class StoredStuff {
    private String playerName;
    private SimpleAvatar avatar;
    private GameInfo info = new GameInfo();;


    public StoredStuff(String playerName, SimpleAvatar avatar){
        setName(playerName);
        setAvatar(avatar);
    }

    public void setAvatar(SimpleAvatar avatar2) {
        this.avatar = avatar2;
    }

    public void setName(String playerName){
        this.playerName = playerName;
    }

    public String getName() {
        return playerName;
    }

    public SimpleAvatar getAvatar() {
        return avatar;
    }

    public GameInfo getInfo() {
        return info;
    }

}
