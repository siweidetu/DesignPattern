package main.java.state.login;

public class AppContext {
    public static final UserState STATE_LOGIN = new LoginInState();
    public static final UserState STATE_UNLOGIN = new UnLoginState();
    private UserState currentState = STATE_UNLOGIN;
    {
        STATE_LOGIN.setContext(this);
        STATE_UNLOGIN.setContext(this);
    }
    public void setState(UserState state){
        this.currentState = state;
        this.currentState.setContext(this);
    }

    public UserState getState(){
        return this.currentState;
    }

    public void favorite(){
        this.currentState.favorite();
    }

    public void comment(String comment){
        this.currentState.comment(comment);
    }

    public static void main(String[] args) {
        AppContext context = new AppContext();
        context.favorite();
        context.comment("评论： 好文章，360\n" +
                "个赞！");
    }
}
