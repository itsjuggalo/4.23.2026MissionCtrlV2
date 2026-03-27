package R0;

import com.google.android.gms.internal.play_billing.InterfaceC1427z0;
import com.google.android.gms.internal.play_billing.R2;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

/* JADX INFO: renamed from: R0.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0823k0 implements InterfaceC1427z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ S.a f7000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f7001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0831o0 f7002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7003d;

    public C0823k0(C0831o0 c0831o0, int i8, S.a aVar, Runnable runnable) {
        this.f7003d = i8;
        this.f7000a = aVar;
        this.f7001b = runnable;
        Objects.requireNonNull(c0831o0);
        this.f7002c = c0831o0;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1427z0
    public final /* bridge */ /* synthetic */ void a(Object obj) {
        Integer num = (Integer) obj;
        int iIntValue = num.intValue();
        C0831o0 c0831o0 = this.f7002c;
        if (!C0831o0.Y0(iIntValue)) {
            this.f7001b.run();
        } else {
            this.f7000a.accept(c0831o0.Z0(this.f7003d, num.intValue()));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1427z0
    public final void b(Throwable th) {
        String str;
        if (th instanceof TimeoutException) {
            this.f7002c.b1(R2.BILLING_OVERRIDE_SERVICE_CALL_TIMEOUT, 28, com.android.billingclient.api.c.f14683F);
            str = "Asynchronous call to Billing Override Service timed out.";
        } else {
            this.f7002c.b1(R2.BILLING_OVERRIDE_SERVICE_CALL_EXCEPTION, 28, com.android.billingclient.api.c.f14683F);
            str = "An error occurred while retrieving billing override.";
        }
        com.google.android.gms.internal.play_billing.V.n("BillingClientTesting", str, th);
        this.f7001b.run();
    }
}
