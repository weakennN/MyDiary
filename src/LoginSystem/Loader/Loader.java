package LoginSystem.Loader;

import Core.MyDiary;

public abstract class Loader {

    private MyDiary myDiary;

    public Loader(MyDiary myDiary) {
        this.myDiary = myDiary;
    }

    public abstract void load();

    protected MyDiary getMyDiary() {
        return this.myDiary;
    }
}
