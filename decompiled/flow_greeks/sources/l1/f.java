package l1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends i0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f15008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15009c;

    public f(Object obj, int i10, int i11) {
        super(i11, null);
        this.f15008b = obj;
        this.f15009c = i10;
    }

    public final void b() {
        Object obj = this.f15008b;
        if ((obj != null ? obj.hashCode() : 0) != this.f15009c) {
            throw new IllegalStateException("Data in DataStore was mutated but DataStore is only compatible with Immutable types.");
        }
    }

    public final Object c() {
        return this.f15008b;
    }
}
