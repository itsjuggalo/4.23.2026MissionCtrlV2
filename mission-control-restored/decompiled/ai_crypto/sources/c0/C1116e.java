package c0;

/* JADX INFO: renamed from: c0.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1116e extends v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f9116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9117c;

    public C1116e(Object obj, int i7, int i8) {
        super(i8, null);
        this.f9116b = obj;
        this.f9117c = i7;
    }

    public final void b() {
        Object obj = this.f9116b;
        if ((obj != null ? obj.hashCode() : 0) != this.f9117c) {
            throw new IllegalStateException("Data in DataStore was mutated but DataStore is only compatible with Immutable types.");
        }
    }

    public final Object c() {
        return this.f9116b;
    }
}
