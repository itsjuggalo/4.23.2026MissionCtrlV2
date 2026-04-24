package S1;

import android.os.RemoteException;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzcu;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class O5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n7 f4154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzcu f4155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0565e6 f4156e;

    public O5(C0565e6 c0565e6, String str, String str2, n7 n7Var, zzcu zzcuVar) {
        this.f4152a = str;
        this.f4153b = str2;
        this.f4154c = n7Var;
        this.f4155d = zzcuVar;
        Objects.requireNonNull(c0565e6);
        this.f4156e = c0565e6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcu zzcuVar;
        l7 l7VarC;
        C0565e6 c0565e6;
        InterfaceC0601j2 interfaceC0601j2N;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                c0565e6 = this.f4156e;
                interfaceC0601j2N = c0565e6.N();
            } catch (RemoteException e4) {
                this.f4156e.f4245a.a().o().d("Failed to get conditional properties; remote exception", this.f4152a, this.f4153b, e4);
            }
            if (interfaceC0601j2N == null) {
                C0658q3 c0658q3 = c0565e6.f4245a;
                c0658q3.a().o().c("Failed to get conditional properties; not connected to service", this.f4152a, this.f4153b);
                l7VarC = c0658q3.C();
                zzcuVar = this.f4155d;
                l7VarC.g0(zzcuVar, arrayList);
            }
            n7 n7Var = this.f4154c;
            AbstractC0940s.k(n7Var);
            arrayList = l7.h0(interfaceC0601j2N.C(this.f4152a, this.f4153b, n7Var));
            c0565e6.J();
            C0565e6 c0565e62 = this.f4156e;
            zzcuVar = this.f4155d;
            l7VarC = c0565e62.f4245a.C();
            l7VarC.g0(zzcuVar, arrayList);
        } catch (Throwable th) {
            C0565e6 c0565e63 = this.f4156e;
            c0565e63.f4245a.C().g0(this.f4155d, arrayList);
            throw th;
        }
    }
}
