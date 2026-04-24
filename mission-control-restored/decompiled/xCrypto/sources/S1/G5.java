package S1;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class G5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n7 f3971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f3972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ H f3973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Bundle f3974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0565e6 f3975e;

    public G5(C0565e6 c0565e6, boolean z4, n7 n7Var, boolean z5, H h4, Bundle bundle) {
        this.f3971a = n7Var;
        this.f3972b = z5;
        this.f3973c = h4;
        this.f3974d = bundle;
        Objects.requireNonNull(c0565e6);
        this.f3975e = c0565e6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0565e6 c0565e6 = this.f3975e;
        InterfaceC0601j2 interfaceC0601j2N = c0565e6.N();
        if (interfaceC0601j2N == null) {
            c0565e6.f4245a.a().o().a("Failed to send default event parameters to service");
            return;
        }
        if (c0565e6.f4245a.w().H(null, AbstractC0569f2.f4565d1)) {
            n7 n7Var = this.f3971a;
            AbstractC0940s.k(n7Var);
            this.f3975e.b0(interfaceC0601j2N, this.f3972b ? null : this.f3973c, n7Var);
            return;
        }
        try {
            n7 n7Var2 = this.f3971a;
            AbstractC0940s.k(n7Var2);
            interfaceC0601j2N.t(this.f3974d, n7Var2);
            c0565e6.J();
        } catch (RemoteException e4) {
            this.f3975e.f4245a.a().o().b("Failed to send default event parameters to service", e4);
        }
    }
}
