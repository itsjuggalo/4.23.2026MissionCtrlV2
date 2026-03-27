package S1;

import android.os.RemoteException;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class A5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f3850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n7 f3851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0565e6 f3852c;

    public A5(C0565e6 c0565e6, AtomicReference atomicReference, n7 n7Var) {
        this.f3850a = atomicReference;
        this.f3851b = n7Var;
        Objects.requireNonNull(c0565e6);
        this.f3852c = c0565e6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        C0565e6 c0565e6;
        C0658q3 c0658q3;
        AtomicReference atomicReference2 = this.f3850a;
        synchronized (atomicReference2) {
            try {
                try {
                    c0565e6 = this.f3852c;
                    c0658q3 = c0565e6.f4245a;
                } catch (RemoteException e4) {
                    this.f3852c.f4245a.a().o().b("Failed to get app instance id", e4);
                    atomicReference = this.f3850a;
                }
                if (c0658q3.x().w().o(Z3.ANALYTICS_STORAGE)) {
                    InterfaceC0601j2 interfaceC0601j2N = c0565e6.N();
                    if (interfaceC0601j2N != null) {
                        n7 n7Var = this.f3851b;
                        AbstractC0940s.k(n7Var);
                        atomicReference2.set(interfaceC0601j2N.g(n7Var));
                        String str = (String) atomicReference2.get();
                        if (str != null) {
                            c0565e6.f4245a.B().E(str);
                            c0658q3.x().f4186h.b(str);
                        }
                        c0565e6.J();
                        atomicReference = this.f3850a;
                        atomicReference.notify();
                        return;
                    }
                    c0658q3.a().o().a("Failed to get app instance id");
                    atomicReference2.notify();
                } else {
                    c0658q3.a().t().a("Analytics storage consent denied; will not get app instance id");
                    c0565e6.f4245a.B().E(null);
                    c0658q3.x().f4186h.b(null);
                    atomicReference2.set(null);
                    atomicReference2.notify();
                }
            } catch (Throwable th) {
                this.f3850a.notify();
                throw th;
            }
        }
    }
}
