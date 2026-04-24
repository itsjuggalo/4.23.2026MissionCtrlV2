package S1;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzda;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class V6 implements InterfaceC0563e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzda f4267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f4268b;

    public V6(AppMeasurementDynamiteService appMeasurementDynamiteService, zzda zzdaVar) {
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f4268b = appMeasurementDynamiteService;
        this.f4267a = zzdaVar;
    }

    @Override // S1.InterfaceC0563e4
    public final void a(String str, String str2, Bundle bundle, long j4) {
        try {
            this.f4267a.zze(str, str2, bundle, j4);
        } catch (RemoteException e4) {
            C0658q3 c0658q3 = this.f4268b.f10063a;
            if (c0658q3 != null) {
                c0658q3.a().r().b("Event interceptor threw exception", e4);
            }
        }
    }
}
