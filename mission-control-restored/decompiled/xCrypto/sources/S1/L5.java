package S1;

import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class L5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n7 f4090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f4091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ J f4092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0565e6 f4093d;

    public L5(C0565e6 c0565e6, boolean z4, n7 n7Var, boolean z5, J j4, String str) {
        this.f4090a = n7Var;
        this.f4091b = z5;
        this.f4092c = j4;
        Objects.requireNonNull(c0565e6);
        this.f4093d = c0565e6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0565e6 c0565e6 = this.f4093d;
        InterfaceC0601j2 interfaceC0601j2N = c0565e6.N();
        if (interfaceC0601j2N == null) {
            c0565e6.f4245a.a().o().a("Discarding data. Failed to send event to service");
            return;
        }
        n7 n7Var = this.f4090a;
        AbstractC0940s.k(n7Var);
        c0565e6.b0(interfaceC0601j2N, this.f4091b ? null : this.f4092c, n7Var);
        c0565e6.J();
    }
}
