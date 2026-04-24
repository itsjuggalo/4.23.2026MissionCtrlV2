package S1;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public final class V2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final U2 f4264a;

    public V2(U2 u22) {
        AbstractC0940s.k(u22);
        this.f4264a = u22;
    }

    public final void a(Context context, Intent intent) {
        C0658q3 c0658q3O = C0658q3.O(context, null, null);
        C2 c2A = c0658q3O.a();
        if (intent == null) {
            c2A.r().a("Receiver called with null intent");
            return;
        }
        c0658q3O.c();
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
            this.f4264a.a(context, className);
        }
    }
}
