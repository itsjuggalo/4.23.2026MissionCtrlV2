package U1;

import Q1.C0792d;
import S1.InterfaceC0872d;
import S1.InterfaceC0879k;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.AbstractC1287g;
import com.google.android.gms.common.internal.C1284d;
import com.google.android.gms.common.internal.C1300u;

/* JADX INFO: loaded from: classes.dex */
public final class e extends AbstractC1287g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C1300u f8091d;

    public e(Context context, Looper looper, C1284d c1284d, C1300u c1300u, InterfaceC0872d interfaceC0872d, InterfaceC0879k interfaceC0879k) {
        super(context, looper, 270, c1284d, interfaceC0872d, interfaceC0879k);
        this.f8091d = c1300u;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1283c
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new a(iBinder);
    }

    @Override // com.google.android.gms.common.internal.AbstractC1283c
    public final C0792d[] getApiFeatures() {
        return c2.d.f13343b;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1283c
    public final Bundle getGetServiceRequestExtraArgs() {
        return this.f8091d.b();
    }

    @Override // com.google.android.gms.common.internal.AbstractC1283c, R1.a.f
    public final int getMinApkVersion() {
        return 203400000;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1283c
    public final String getServiceDescriptor() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC1283c
    public final String getStartServiceAction() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // com.google.android.gms.common.internal.AbstractC1283c
    public final boolean getUseDynamicLookup() {
        return true;
    }
}
