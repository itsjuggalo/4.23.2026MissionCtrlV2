package E3;

/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f892b = new c(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f893a;

    public c(Object obj) {
        this.f893a = obj;
    }

    public static b a(Object obj) {
        return new c(d.c(obj, "instance cannot be null"));
    }

    @Override // n5.InterfaceC2426a
    public Object get() {
        return this.f893a;
    }
}
