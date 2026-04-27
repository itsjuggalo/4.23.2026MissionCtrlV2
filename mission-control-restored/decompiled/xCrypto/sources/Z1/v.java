package Z1;

/* JADX INFO: loaded from: classes.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f6004a = new a();

    public class a extends v {
        @Override // Z1.v
        public long a() {
            return System.nanoTime();
        }
    }

    public static v b() {
        return f6004a;
    }

    public abstract long a();
}
