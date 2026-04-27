package b6;

import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: b6.x0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1103x0 extends CancellationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient InterfaceC1101w0 f9099a;

    public C1103x0(String str, Throwable th, InterfaceC1101w0 interfaceC1101w0) {
        super(str);
        this.f9099a = interfaceC1101w0;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof C1103x0) {
                C1103x0 c1103x0 = (C1103x0) obj;
                if (!kotlin.jvm.internal.r.b(c1103x0.getMessage(), getMessage()) || !kotlin.jvm.internal.r.b(c1103x0.f9099a, this.f9099a) || !kotlin.jvm.internal.r.b(c1103x0.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        kotlin.jvm.internal.r.c(message);
        int iHashCode = ((message.hashCode() * 31) + this.f9099a.hashCode()) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f9099a;
    }
}
