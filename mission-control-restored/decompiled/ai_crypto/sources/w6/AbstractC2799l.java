package w6;

/* JADX INFO: renamed from: w6.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2799l implements X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X f25133a;

    public AbstractC2799l(X delegate) {
        kotlin.jvm.internal.r.f(delegate, "delegate");
        this.f25133a = delegate;
    }

    @Override // w6.X
    public void L(C2792e source, long j7) {
        kotlin.jvm.internal.r.f(source, "source");
        this.f25133a.L(source, j7);
    }

    @Override // w6.X, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f25133a.close();
    }

    @Override // w6.X
    public a0 f() {
        return this.f25133a.f();
    }

    @Override // w6.X, java.io.Flushable
    public void flush() {
        this.f25133a.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f25133a + ')';
    }
}
