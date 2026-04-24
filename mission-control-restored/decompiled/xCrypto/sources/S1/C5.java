package S1;

import android.os.RemoteException;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class C5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n7 f3894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0565e6 f3895b;

    public C5(C0565e6 c0565e6, n7 n7Var, boolean z4) {
        this.f3894a = n7Var;
        Objects.requireNonNull(c0565e6);
        this.f3895b = c0565e6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0565e6 c0565e6 = this.f3895b;
        InterfaceC0601j2 interfaceC0601j2N = c0565e6.N();
        if (interfaceC0601j2N == null) {
            c0565e6.f4245a.a().o().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            n7 n7Var = this.f3894a;
            AbstractC0940s.k(n7Var);
            C0658q3 c0658q3 = c0565e6.f4245a;
            C0622m c0622mW = c0658q3.w();
            C0561e2 c0561e2 = AbstractC0569f2.f4565d1;
            if (c0622mW.H(null, c0561e2)) {
                c0565e6.b0(interfaceC0601j2N, null, n7Var);
            }
            interfaceC0601j2N.Q(n7Var);
            c0565e6.f4245a.E().v();
            c0658q3.w().H(null, c0561e2);
            c0565e6.b0(interfaceC0601j2N, null, n7Var);
            c0565e6.J();
        } catch (RemoteException e4) {
            this.f3895b.f4245a.a().o().b("Failed to send app launch to the service", e4);
        }
    }
}
