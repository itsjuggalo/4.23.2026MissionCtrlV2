package H2;

/* JADX INFO: loaded from: classes.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f2629a = new a();

    public class a extends v {
        @Override // H2.v
        public long a() {
            return System.nanoTime();
        }
    }

    public static v b() {
        return f2629a;
    }

    public abstract long a();
}
