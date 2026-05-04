package r9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f19446b = new c(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f19447a;

    public c(Object obj) {
        this.f19447a = obj;
    }

    public static b a(Object obj) {
        return new c(d.c(obj, "instance cannot be null"));
    }

    @Override // bd.a
    public Object get() {
        return this.f19447a;
    }
}
