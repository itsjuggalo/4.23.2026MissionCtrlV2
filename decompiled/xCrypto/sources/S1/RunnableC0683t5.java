package S1;

import com.google.android.gms.internal.measurement.zzcu;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import java.util.Objects;

/* JADX INFO: renamed from: S1.t5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0683t5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcu f4949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f4952d;

    public RunnableC0683t5(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcu zzcuVar, String str, String str2) {
        this.f4949a = zzcuVar;
        this.f4950b = str;
        this.f4951c = str2;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f4952d = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4952d.f10063a.J().f0(this.f4949a, this.f4950b, this.f4951c);
    }
}
