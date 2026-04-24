package S1;

import android.os.RemoteException;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzcu;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class B5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n7 f3868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzcu f3869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0565e6 f3870c;

    public B5(C0565e6 c0565e6, n7 n7Var, zzcu zzcuVar) {
        this.f3868a = n7Var;
        this.f3869b = zzcuVar;
        Objects.requireNonNull(c0565e6);
        this.f3870c = c0565e6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcu zzcuVar;
        l7 l7VarC;
        C0565e6 c0565e6;
        C0658q3 c0658q3;
        String strG = null;
        try {
            try {
                c0565e6 = this.f3870c;
                c0658q3 = c0565e6.f4245a;
            } catch (RemoteException e4) {
                this.f3870c.f4245a.a().o().b("Failed to get app instance id", e4);
            }
            if (c0658q3.x().w().o(Z3.ANALYTICS_STORAGE)) {
                InterfaceC0601j2 interfaceC0601j2N = c0565e6.N();
                if (interfaceC0601j2N != null) {
                    n7 n7Var = this.f3868a;
                    AbstractC0940s.k(n7Var);
                    strG = interfaceC0601j2N.g(n7Var);
                    if (strG != null) {
                        c0565e6.f4245a.B().E(strG);
                        c0658q3.x().f4186h.b(strG);
                    }
                    c0565e6.J();
                    C0565e6 c0565e62 = this.f3870c;
                    zzcuVar = this.f3869b;
                    l7VarC = c0565e62.f4245a.C();
                    l7VarC.a0(zzcuVar, strG);
                }
                c0658q3.a().o().a("Failed to get app instance id");
            } else {
                c0658q3.a().t().a("Analytics storage consent denied; will not get app instance id");
                c0565e6.f4245a.B().E(null);
                c0658q3.x().f4186h.b(null);
            }
            l7VarC = c0658q3.C();
            zzcuVar = this.f3869b;
            l7VarC.a0(zzcuVar, strG);
        } catch (Throwable th) {
            C0565e6 c0565e63 = this.f3870c;
            c0565e63.f4245a.C().a0(this.f3869b, null);
            throw th;
        }
    }
}
