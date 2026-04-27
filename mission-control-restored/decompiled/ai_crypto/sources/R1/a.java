package R1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.C1211w;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

/* JADX INFO: loaded from: classes.dex */
public final class a extends zaa implements IInterface {
    public a(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    public final void b(C1211w c1211w) {
        Parcel parcelZaa = zaa();
        zac.zac(parcelZaa, c1211w);
        zad(1, parcelZaa);
    }
}
