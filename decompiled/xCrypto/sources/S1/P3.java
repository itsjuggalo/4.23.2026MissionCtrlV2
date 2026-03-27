package S1;

import com.google.android.gms.internal.measurement.zzcu;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class P3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcu f4164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ J f4165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f4167d;

    public P3(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcu zzcuVar, J j4, String str) {
        this.f4164a = zzcuVar;
        this.f4165b = j4;
        this.f4166c = str;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f4167d = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4167d.f10063a.J().B(this.f4164a, this.f4165b, this.f4166c);
    }
}
