package MyDiary.Core.Entry.LoginSystem.Verifier;

public abstract class Verifier<T> {

    private T item;

    public Verifier(T item) {
        this.item = item;
    }

    public abstract boolean verify();

    protected T getItem() {
        return this.item;
    }
}
