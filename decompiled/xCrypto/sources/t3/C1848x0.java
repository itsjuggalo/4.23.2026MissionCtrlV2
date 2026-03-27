package t3;

import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: t3.x0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1848x0 extends CancellationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient InterfaceC1846w0 f15041a;

    public C1848x0(String str, Throwable th, InterfaceC1846w0 interfaceC1846w0) {
        super(str);
        this.f15041a = interfaceC1846w0;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1848x0)) {
            return false;
        }
        C1848x0 c1848x0 = (C1848x0) obj;
        return kotlin.jvm.internal.r.b(c1848x0.getMessage(), getMessage()) && kotlin.jvm.internal.r.b(c1848x0.f15041a, this.f15041a) && kotlin.jvm.internal.r.b(c1848x0.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        kotlin.jvm.internal.r.c(message);
        int iHashCode = ((message.hashCode() * 31) + this.f15041a.hashCode()) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f15041a;
    }
}
