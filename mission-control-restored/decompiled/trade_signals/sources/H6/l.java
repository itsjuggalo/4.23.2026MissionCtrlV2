package H6;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Thread f4007b = Thread.currentThread();

    public l(Object obj) {
        this.f4006a = obj;
    }

    public Object a() {
        if (b()) {
            return this.f4006a;
        }
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }

    public boolean b() {
        return this.f4007b == Thread.currentThread();
    }
}
