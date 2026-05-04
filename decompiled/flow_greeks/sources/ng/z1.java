package ng;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class z1 extends CancellationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient y1 f17200a;

    public z1(String str, Throwable th, y1 y1Var) {
        super(str);
        this.f17200a = y1Var;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof z1)) {
            return false;
        }
        z1 z1Var = (z1) obj;
        return kotlin.jvm.internal.t.b(z1Var.getMessage(), getMessage()) && kotlin.jvm.internal.t.b(z1Var.f17200a, this.f17200a) && kotlin.jvm.internal.t.b(z1Var.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        kotlin.jvm.internal.t.c(message);
        int iHashCode = ((message.hashCode() * 31) + this.f17200a.hashCode()) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f17200a;
    }
}
