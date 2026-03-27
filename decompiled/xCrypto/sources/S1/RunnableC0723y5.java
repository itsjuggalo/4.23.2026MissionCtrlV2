package S1;

import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;

/* JADX INFO: renamed from: S1.y5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0723y5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n7 f5062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f5063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h7 f5064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0565e6 f5065d;

    public RunnableC0723y5(C0565e6 c0565e6, n7 n7Var, boolean z4, h7 h7Var) {
        this.f5062a = n7Var;
        this.f5063b = z4;
        this.f5064c = h7Var;
        Objects.requireNonNull(c0565e6);
        this.f5065d = c0565e6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0565e6 c0565e6 = this.f5065d;
        InterfaceC0601j2 interfaceC0601j2N = c0565e6.N();
        if (interfaceC0601j2N == null) {
            c0565e6.f4245a.a().o().a("Discarding data. Failed to set user property");
            return;
        }
        n7 n7Var = this.f5062a;
        AbstractC0940s.k(n7Var);
        c0565e6.b0(interfaceC0601j2N, this.f5063b ? null : this.f5064c, n7Var);
        c0565e6.J();
    }
}
