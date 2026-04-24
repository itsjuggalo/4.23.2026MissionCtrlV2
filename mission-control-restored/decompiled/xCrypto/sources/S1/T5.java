package S1;

import com.google.android.gms.internal.measurement.zzcu;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class T5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcu f4247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f4248b;

    public T5(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcu zzcuVar) {
        this.f4247a = zzcuVar;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f4248b = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AppMeasurementDynamiteService appMeasurementDynamiteService = this.f4248b;
        appMeasurementDynamiteService.f10063a.C().e0(this.f4247a, appMeasurementDynamiteService.f10063a.d());
    }
}
