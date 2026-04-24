package S1;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzcu;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class H5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ J f3990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzcu f3992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0565e6 f3993d;

    public H5(C0565e6 c0565e6, J j4, String str, zzcu zzcuVar) {
        this.f3990a = j4;
        this.f3991b = str;
        this.f3992c = zzcuVar;
        Objects.requireNonNull(c0565e6);
        this.f3993d = c0565e6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcu zzcuVar;
        l7 l7VarC;
        C0565e6 c0565e6;
        InterfaceC0601j2 interfaceC0601j2N;
        byte[] bArrO = null;
        try {
            try {
                c0565e6 = this.f3993d;
                interfaceC0601j2N = c0565e6.N();
            } catch (RemoteException e4) {
                this.f3993d.f4245a.a().o().b("Failed to send event to the service to bundle", e4);
            }
            if (interfaceC0601j2N == null) {
                C0658q3 c0658q3 = c0565e6.f4245a;
                c0658q3.a().o().a("Discarding data. Failed to send event to service to bundle");
                l7VarC = c0658q3.C();
                zzcuVar = this.f3992c;
                l7VarC.d0(zzcuVar, bArrO);
            }
            bArrO = interfaceC0601j2N.o(this.f3990a, this.f3991b);
            c0565e6.J();
            C0565e6 c0565e62 = this.f3993d;
            zzcuVar = this.f3992c;
            l7VarC = c0565e62.f4245a.C();
            l7VarC.d0(zzcuVar, bArrO);
        } catch (Throwable th) {
            C0565e6 c0565e63 = this.f3993d;
            c0565e63.f4245a.C().d0(this.f3992c, null);
            throw th;
        }
    }
}
