package v2;

/* JADX INFO: renamed from: v2.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2857w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC2857w f23789a = new a();

    /* JADX INFO: renamed from: v2.w$a */
    public class a extends AbstractC2857w {
        @Override // v2.AbstractC2857w
        public long a() {
            return System.nanoTime();
        }
    }

    public static AbstractC2857w b() {
        return f23789a;
    }

    public abstract long a();
}
