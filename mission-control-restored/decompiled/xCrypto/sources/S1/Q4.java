package S1;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class Q4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ V6 f4209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f4210b;

    public Q4(AppMeasurementDynamiteService appMeasurementDynamiteService, V6 v6) {
        this.f4209a = v6;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f4210b = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4210b.f10063a.B().I(this.f4209a);
    }
}
