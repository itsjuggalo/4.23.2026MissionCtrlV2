package B1;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.internal.InterfaceC0903g;
import com.google.android.gms.common.api.internal.InterfaceC0912p;
import com.google.android.gms.common.internal.AbstractC0930h;
import com.google.android.gms.common.internal.C0927e;
import com.google.android.gms.common.internal.C0947z;
import com.google.android.gms.internal.base.zaf;
import z1.C1986d;

/* JADX INFO: loaded from: classes.dex */
public final class e extends AbstractC0930h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0947z f113a;

    public e(Context context, Looper looper, C0927e c0927e, C0947z c0947z, InterfaceC0903g interfaceC0903g, InterfaceC0912p interfaceC0912p) {
        super(context, looper, 270, c0927e, interfaceC0903g, interfaceC0912p);
        this.f113a = c0947z;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new a(iBinder);
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final C1986d[] getApiFeatures() {
        return zaf.zab;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final Bundle getGetServiceRequestExtraArgs() {
        return this.f113a.b();
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c, com.google.android.gms.common.api.a.f
    public final int getMinApkVersion() {
        return 203400000;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final String getServiceDescriptor() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final String getStartServiceAction() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final boolean getUseDynamicLookup() {
        return true;
    }
}
