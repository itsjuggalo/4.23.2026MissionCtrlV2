package i6;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f16469i = new c();

    public c() {
        super(l.f16482c, l.f16483d, l.f16484e, l.f16480a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // b6.I
    public String toString() {
        return "Dispatchers.Default";
    }
}
