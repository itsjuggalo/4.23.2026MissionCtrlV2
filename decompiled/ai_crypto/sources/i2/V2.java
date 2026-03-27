package i2;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public final class V2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final U2 f15423a;

    public V2(U2 u22) {
        AbstractC1207s.k(u22);
        this.f15423a = u22;
    }

    public final void a(Context context, Intent intent) {
        C1898q3 c1898q3O = C1898q3.O(context, null, null);
        C2 c2A = c1898q3O.a();
        if (intent == null) {
            c2A.r().a("Receiver called with null intent");
            return;
        }
        c1898q3O.c();
        String action = intent.getAction();
        c2A.w().b("Local receiver got", action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                c2A.r().a("Install Referrer Broadcasts are deprecated");
            }
        } else {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            c2A.w().a("Starting wakeful intent.");
            this.f15423a.a(context, className);
        }
    }
}
