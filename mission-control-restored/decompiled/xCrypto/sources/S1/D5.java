package S1;

import android.os.RemoteException;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class D5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n7 f3908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0565e6 f3909b;

    public D5(C0565e6 c0565e6, n7 n7Var) {
        this.f3908a = n7Var;
        Objects.requireNonNull(c0565e6);
        this.f3909b = c0565e6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0565e6 c0565e6 = this.f3909b;
        InterfaceC0601j2 interfaceC0601j2N = c0565e6.N();
        if (interfaceC0601j2N == null) {
            c0565e6.f4245a.a().r().a("Failed to send app backgrounded");
            return;
        }
        try {
            n7 n7Var = this.f3908a;
            AbstractC0940s.k(n7Var);
            interfaceC0601j2N.k(n7Var);
            c0565e6.J();
        } catch (RemoteException e4) {
            this.f3909b.f4245a.a().o().b("Failed to send app backgrounded to the service", e4);
        }
    }
}
