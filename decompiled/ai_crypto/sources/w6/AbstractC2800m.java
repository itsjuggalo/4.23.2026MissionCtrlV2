package w6;

/* JADX INFO: renamed from: w6.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2800m implements Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z f25134a;

    public AbstractC2800m(Z delegate) {
        kotlin.jvm.internal.r.f(delegate, "delegate");
        this.f25134a = delegate;
    }

    @Override // w6.Z, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f25134a.close();
    }

    @Override // w6.Z
    public a0 f() {
        return this.f25134a.f();
    }

    public final Z h() {
        return this.f25134a;
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f25134a + ')';
    }

    @Override // w6.Z
    public long z(C2792e sink, long j7) {
        kotlin.jvm.internal.r.f(sink, "sink");
        return this.f25134a.z(sink, j7);
    }
}
