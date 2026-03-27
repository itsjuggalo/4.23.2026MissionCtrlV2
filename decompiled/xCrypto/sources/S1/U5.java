package S1;

import android.content.ComponentName;
import android.content.Context;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class U5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Y5 f4256a;

    public U5(Y5 y5) {
        Objects.requireNonNull(y5);
        this.f4256a = y5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0565e6 c0565e6 = this.f4256a.f4308c;
        C0658q3 c0658q3 = c0565e6.f4245a;
        Context contextE = c0658q3.e();
        c0658q3.c();
        c0565e6.K(new ComponentName(contextE, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
