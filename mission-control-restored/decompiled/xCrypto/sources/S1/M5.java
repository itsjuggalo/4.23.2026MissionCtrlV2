package S1;

import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class M5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n7 f4111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f4112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0590i f4113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0565e6 f4114d;

    public M5(C0565e6 c0565e6, boolean z4, n7 n7Var, boolean z5, C0590i c0590i, C0590i c0590i2) {
        this.f4111a = n7Var;
        this.f4112b = z5;
        this.f4113c = c0590i;
        Objects.requireNonNull(c0565e6);
        this.f4114d = c0565e6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0565e6 c0565e6 = this.f4114d;
        InterfaceC0601j2 interfaceC0601j2N = c0565e6.N();
        if (interfaceC0601j2N == null) {
            c0565e6.f4245a.a().o().a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        n7 n7Var = this.f4111a;
        AbstractC0940s.k(n7Var);
        c0565e6.b0(interfaceC0601j2N, this.f4112b ? null : this.f4113c, n7Var);
        c0565e6.J();
    }
}
