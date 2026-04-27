package S1;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class Q5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0601j2 f4211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Y5 f4212b;

    public Q5(Y5 y5, InterfaceC0601j2 interfaceC0601j2) {
        this.f4211a = interfaceC0601j2;
        Objects.requireNonNull(y5);
        this.f4212b = y5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Y5 y5 = this.f4212b;
        synchronized (y5) {
            try {
                y5.g(false);
                C0565e6 c0565e6 = y5.f4308c;
                if (!c0565e6.W()) {
                    c0565e6.f4245a.a().w().a("Connected to service");
                    c0565e6.z(this.f4211a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
