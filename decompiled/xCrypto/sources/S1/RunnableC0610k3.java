package S1;

import com.google.android.gms.internal.measurement.zzcu;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import java.util.Objects;

/* JADX INFO: renamed from: S1.k3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0610k3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcu f4714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f4715b;

    public RunnableC0610k3(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcu zzcuVar) {
        this.f4714a = zzcuVar;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f4715b = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4715b.f10063a.J().r(this.f4714a);
    }
}
