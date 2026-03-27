package b0;

/* JADX INFO: renamed from: b0.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1175f extends I {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12598c;

    public C1175f(Object obj, int i8, int i9) {
        super(i9, null);
        this.f12597b = obj;
        this.f12598c = i8;
    }

    public final void b() {
        Object obj = this.f12597b;
        if ((obj != null ? obj.hashCode() : 0) != this.f12598c) {
            throw new IllegalStateException("Data in DataStore was mutated but DataStore is only compatible with Immutable types.".toString());
        }
    }

    public final Object c() {
        return this.f12597b;
    }
}
