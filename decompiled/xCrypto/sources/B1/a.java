package B1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.C0944w;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

/* JADX INFO: loaded from: classes.dex */
public final class a extends zaa implements IInterface {
    public a(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    public final void b(C0944w c0944w) {
        Parcel parcelZaa = zaa();
        zac.zac(parcelZaa, c0944w);
        zad(1, parcelZaa);
    }
}
