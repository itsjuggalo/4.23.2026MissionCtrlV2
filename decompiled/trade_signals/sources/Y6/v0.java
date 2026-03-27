package Y6;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 extends CancellationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient InterfaceC1033u0 f9696a;

    public v0(String str, Throwable th, InterfaceC1033u0 interfaceC1033u0) {
        super(str);
        this.f9696a = interfaceC1033u0;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof v0) {
                v0 v0Var = (v0) obj;
                if (!AbstractC2304t.b(v0Var.getMessage(), getMessage()) || !AbstractC2304t.b(v0Var.f9696a, this.f9696a) || !AbstractC2304t.b(v0Var.getCause(), getCause())) {
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
        AbstractC2304t.c(message);
        int iHashCode = ((message.hashCode() * 31) + this.f9696a.hashCode()) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f9696a;
    }
}
