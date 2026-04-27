package S1;

import android.os.RemoteException;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;

/* JADX INFO: renamed from: S1.z5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0731z5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n7 f5089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0565e6 f5090b;

    public RunnableC0731z5(C0565e6 c0565e6, n7 n7Var) {
        this.f5089a = n7Var;
        Objects.requireNonNull(c0565e6);
        this.f5090b = c0565e6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0565e6 c0565e6 = this.f5090b;
        InterfaceC0601j2 interfaceC0601j2N = c0565e6.N();
        if (interfaceC0601j2N == null) {
            c0565e6.f4245a.a().o().a("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            n7 n7Var = this.f5089a;
            AbstractC0940s.k(n7Var);
            interfaceC0601j2N.r(n7Var);
        } catch (RemoteException e4) {
            this.f5090b.f4245a.a().o().b("Failed to reset data on the service: remote exception", e4);
        }
        this.f5090b.J();
    }
}
