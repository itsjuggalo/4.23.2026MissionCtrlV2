package h5;

/* JADX INFO: loaded from: classes.dex */
public final class e extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f6685d;

    static {
        int i = k.f6693c;
        int i6 = k.f6694d;
        long j4 = k.e;
        String str = k.f6691a;
        e eVar = new e();
        eVar.f6687c = new c(i, i6, j4, str);
        f6685d = eVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // a5.AbstractC0317y
    public final String toString() {
        return "Dispatchers.Default";
    }
}
