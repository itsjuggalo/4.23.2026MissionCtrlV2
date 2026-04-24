package y3;

/* JADX INFO: renamed from: y3.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1955i extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Z2.i f15982a;

    public C1955i(Z2.i iVar) {
        this.f15982a = iVar;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.f15982a.toString();
    }
}
