package wf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f24087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Thread f24088b = Thread.currentThread();

    public l(Object obj) {
        this.f24087a = obj;
    }

    public Object a() {
        if (b()) {
            return this.f24087a;
        }
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }

    public boolean b() {
        return this.f24088b == Thread.currentThread();
    }
}
