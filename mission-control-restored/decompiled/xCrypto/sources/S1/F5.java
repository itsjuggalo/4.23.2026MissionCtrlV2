package S1;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class F5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0628m5 f3953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0565e6 f3954b;

    public F5(C0565e6 c0565e6, C0628m5 c0628m5) {
        this.f3953a = c0628m5;
        Objects.requireNonNull(c0565e6);
        this.f3954b = c0565e6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0565e6 c0565e6 = this.f3954b;
        InterfaceC0601j2 interfaceC0601j2N = c0565e6.N();
        if (interfaceC0601j2N == null) {
            c0565e6.f4245a.a().o().a("Failed to send current screen to service");
            return;
        }
        try {
            C0628m5 c0628m5 = this.f3953a;
            if (c0628m5 == null) {
                interfaceC0601j2N.l(0L, null, null, c0565e6.f4245a.e().getPackageName());
            } else {
                interfaceC0601j2N.l(c0628m5.f4753c, c0628m5.f4751a, c0628m5.f4752b, c0565e6.f4245a.e().getPackageName());
            }
            c0565e6.J();
        } catch (RemoteException e4) {
            this.f3954b.f4245a.a().o().b("Failed to send current screen to the service", e4);
        }
    }
}
