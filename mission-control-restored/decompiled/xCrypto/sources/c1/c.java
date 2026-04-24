package c1;

/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f8307b = new c(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8308a;

    public c(Object obj) {
        this.f8308a = obj;
    }

    public static b a(Object obj) {
        return new c(d.c(obj, "instance cannot be null"));
    }

    @Override // V2.a
    public Object get() {
        return this.f8308a;
    }
}
