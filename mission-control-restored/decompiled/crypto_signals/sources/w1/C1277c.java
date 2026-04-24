package w1;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.internal.InterfaceC0403f;
import com.google.android.gms.common.api.internal.InterfaceC0413p;
import com.google.android.gms.common.internal.AbstractC0433k;
import com.google.android.gms.common.internal.C0430h;
import com.google.android.gms.common.internal.C0444w;
import com.google.android.gms.internal.base.zaf;
import u1.C1202d;

/* JADX INFO: renamed from: w1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1277c extends AbstractC0433k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0444w f10714a;

    public C1277c(Context context, Looper looper, C0430h c0430h, C0444w c0444w, InterfaceC0403f interfaceC0403f, InterfaceC0413p interfaceC0413p) {
        super(context, looper, 270, c0430h, interfaceC0403f, interfaceC0413p);
        this.f10714a = c0444w;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof C1275a ? (C1275a) iInterfaceQueryLocalInterface : new C1275a(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final C1202d[] getApiFeatures() {
        return zaf.zab;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final Bundle getGetServiceRequestExtraArgs() {
        C0444w c0444w = this.f10714a;
        c0444w.getClass();
        Bundle bundle = new Bundle();
        String str = c0444w.f5289a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final int getMinApkVersion() {
        return 203400000;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final String getServiceDescriptor() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final String getStartServiceAction() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final boolean getUseDynamicLookup() {
        return true;
    }
}
