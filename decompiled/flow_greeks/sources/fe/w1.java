package fe;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9541b;

    public w1(String name, boolean z10) {
        kotlin.jvm.internal.t.f(name, "name");
        this.f9540a = name;
        this.f9541b = z10;
    }

    public Integer a(w1 visibility) {
        kotlin.jvm.internal.t.f(visibility, "visibility");
        return v1.f9525a.a(this, visibility);
    }

    public String b() {
        return this.f9540a;
    }

    public final boolean c() {
        return this.f9541b;
    }

    public final String toString() {
        return b();
    }

    public w1 d() {
        return this;
    }
}
