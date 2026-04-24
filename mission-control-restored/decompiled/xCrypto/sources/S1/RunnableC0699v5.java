package S1;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzcu;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: S1.v5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0699v5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f5001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f5002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n7 f5003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f5004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzcu f5005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0565e6 f5006f;

    public RunnableC0699v5(C0565e6 c0565e6, String str, String str2, n7 n7Var, boolean z4, zzcu zzcuVar) {
        this.f5001a = str;
        this.f5002b = str2;
        this.f5003c = n7Var;
        this.f5004d = z4;
        this.f5005e = zzcuVar;
        Objects.requireNonNull(c0565e6);
        this.f5006f = c0565e6;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Bundle bundle;
        RemoteException e4;
        Bundle bundle2 = new Bundle();
        try {
            C0565e6 c0565e6 = this.f5006f;
            InterfaceC0601j2 interfaceC0601j2N = c0565e6.N();
            if (interfaceC0601j2N == null) {
                C0658q3 c0658q3 = c0565e6.f4245a;
                c0658q3.a().o().c("Failed to get user properties; not connected to service", this.f5001a, this.f5002b);
                c0658q3.C().f0(this.f5005e, bundle2);
                return;
            }
            n7 n7Var = this.f5003c;
            AbstractC0940s.k(n7Var);
            List<h7> listP = interfaceC0601j2N.P(this.f5001a, this.f5002b, this.f5004d, n7Var);
            String[] strArr = l7.f4736i;
            bundle = new Bundle();
            if (listP != null) {
                for (h7 h7Var : listP) {
                    String str = h7Var.f4664e;
                    if (str != null) {
                        bundle.putString(h7Var.f4661b, str);
                    } else {
                        Long l4 = h7Var.f4663d;
                        if (l4 != null) {
                            bundle.putLong(h7Var.f4661b, l4.longValue());
                        } else {
                            Double d4 = h7Var.f4666g;
                            if (d4 != null) {
                                bundle.putDouble(h7Var.f4661b, d4.doubleValue());
                            }
                        }
                    }
                }
            }
            try {
                try {
                    c0565e6.J();
                    C0658q3 c0658q32 = c0565e6.f4245a;
                    c0658q32.C().f0(this.f5005e, bundle);
                } catch (RemoteException e5) {
                    e4 = e5;
                    this.f5006f.f4245a.a().o().c("Failed to get user properties; remote exception", this.f5001a, e4);
                    C0565e6 c0565e62 = this.f5006f;
                    c0565e62.f4245a.C().f0(this.f5005e, bundle);
                }
            } catch (Throwable th) {
                th = th;
                bundle2 = bundle;
                C0565e6 c0565e63 = this.f5006f;
                c0565e63.f4245a.C().f0(this.f5005e, bundle2);
                throw th;
            }
        } catch (RemoteException e6) {
            bundle = bundle2;
            e4 = e6;
        } catch (Throwable th2) {
            th = th2;
            C0565e6 c0565e632 = this.f5006f;
            c0565e632.f4245a.C().f0(this.f5005e, bundle2);
            throw th;
        }
    }
}
