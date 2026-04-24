package a5;

import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: a5.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0297d0 extends CancellationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient InterfaceC0295c0 f4113a;

    public C0297d0(String str, Throwable th, InterfaceC0295c0 interfaceC0295c0) {
        super(str);
        this.f4113a = interfaceC0295c0;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0297d0)) {
            return false;
        }
        C0297d0 c0297d0 = (C0297d0) obj;
        return kotlin.jvm.internal.j.a(c0297d0.getMessage(), getMessage()) && kotlin.jvm.internal.j.a(c0297d0.f4113a, this.f4113a) && kotlin.jvm.internal.j.a(c0297d0.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        kotlin.jvm.internal.j.b(message);
        int iHashCode = (this.f4113a.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.f4113a;
    }
}
