package S1;

import com.google.android.gms.internal.measurement.zzcu;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import java.util.Objects;

/* JADX INFO: renamed from: S1.q4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0659q4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcu f4881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f4884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f4885e;

    public RunnableC0659q4(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcu zzcuVar, String str, String str2, boolean z4) {
        this.f4881a = zzcuVar;
        this.f4882b = str;
        this.f4883c = str2;
        this.f4884d = z4;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f4885e = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4885e.f10063a.J().h0(this.f4881a, this.f4882b, this.f4883c, this.f4884d);
    }
}
