package S;

/* JADX INFO: renamed from: S.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0520f extends D {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3608c;

    public C0520f(Object obj, int i4, int i5) {
        super(i5, null);
        this.f3607b = obj;
        this.f3608c = i4;
    }

    public final void b() {
        Object obj = this.f3607b;
        if ((obj != null ? obj.hashCode() : 0) != this.f3608c) {
            throw new IllegalStateException("Data in DataStore was mutated but DataStore is only compatible with Immutable types.");
        }
    }

    public final Object c() {
        return this.f3607b;
    }
}
