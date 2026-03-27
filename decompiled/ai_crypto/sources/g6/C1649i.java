package g6;

/* JADX INFO: renamed from: g6.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1649i extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient H5.g f14296a;

    public C1649i(H5.g gVar) {
        this.f14296a = gVar;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.f14296a.toString();
    }
}
