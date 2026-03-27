package R1;

import P1.C0650d;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.internal.InterfaceC1169f;
import com.google.android.gms.common.api.internal.InterfaceC1178o;
import com.google.android.gms.common.internal.AbstractC1197h;
import com.google.android.gms.common.internal.C1194e;
import com.google.android.gms.common.internal.C1214z;
import com.google.android.gms.internal.base.zaf;

/* JADX INFO: loaded from: classes.dex */
public final class e extends AbstractC1197h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1214z f4678a;

    public e(Context context, Looper looper, C1194e c1194e, C1214z c1214z, InterfaceC1169f interfaceC1169f, InterfaceC1178o interfaceC1178o) {
        super(context, looper, 270, c1194e, interfaceC1169f, interfaceC1178o);
        this.f4678a = c1214z;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new a(iBinder);
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final C0650d[] getApiFeatures() {
        return zaf.zab;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final Bundle getGetServiceRequestExtraArgs() {
        return this.f4678a.b();
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c, com.google.android.gms.common.api.a.f
    public final int getMinApkVersion() {
        return 203400000;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final String getServiceDescriptor() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final String getStartServiceAction() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final boolean getUseDynamicLookup() {
        return true;
    }
}
