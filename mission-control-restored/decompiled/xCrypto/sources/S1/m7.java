package S1;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzda;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class m7 implements InterfaceC0571f4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzda f4758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f4759b;

    public m7(AppMeasurementDynamiteService appMeasurementDynamiteService, zzda zzdaVar) {
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f4759b = appMeasurementDynamiteService;
        this.f4758a = zzdaVar;
    }

    @Override // S1.InterfaceC0571f4
    public final void onEvent(String str, String str2, Bundle bundle, long j4) {
        try {
            this.f4758a.zze(str, str2, bundle, j4);
        } catch (RemoteException e4) {
            C0658q3 c0658q3 = this.f4759b.f10063a;
            if (c0658q3 != null) {
                c0658q3.a().r().b("Event listener threw exception", e4);
            }
        }
    }
}
