package d7;

import s5.InterfaceC2711i;

/* JADX INFO: renamed from: d7.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1646g extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient InterfaceC2711i f17045a;

    public C1646g(InterfaceC2711i interfaceC2711i) {
        this.f17045a = interfaceC2711i;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.f17045a.toString();
    }
}
