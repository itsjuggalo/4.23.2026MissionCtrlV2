package S1;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.AbstractC0925c;

/* JADX INFO: renamed from: S1.w2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0704w2 extends AbstractC0925c {
    public C0704w2(Context context, Looper looper, AbstractC0925c.a aVar, AbstractC0925c.b bVar) {
        super(context, looper, 93, aVar, bVar, null);
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC0601j2 ? (InterfaceC0601j2) iInterfaceQueryLocalInterface : new C0577g2(iBinder);
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c, com.google.android.gms.common.api.a.f
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final String getServiceDescriptor() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final String getStartServiceAction() {
        return "com.google.android.gms.measurement.START";
    }
}
