package S1;

import android.os.RemoteException;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class J5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n7 f4063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0565e6 f4064b;

    public J5(C0565e6 c0565e6, n7 n7Var) {
        this.f4063a = n7Var;
        Objects.requireNonNull(c0565e6);
        this.f4064b = c0565e6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0565e6 c0565e6 = this.f4064b;
        InterfaceC0601j2 interfaceC0601j2N = c0565e6.N();
        if (interfaceC0601j2N == null) {
            c0565e6.f4245a.a().o().a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            n7 n7Var = this.f4063a;
            AbstractC0940s.k(n7Var);
            interfaceC0601j2N.X(n7Var);
            c0565e6.J();
        } catch (RemoteException e4) {
            this.f4064b.f4245a.a().o().b("Failed to send measurementEnabled to the service", e4);
        }
    }
}
