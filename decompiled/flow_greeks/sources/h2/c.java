package h2;

import android.adservices.measurement.MeasurementManager;
import android.content.Context;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends h {
    /* JADX WARN: Illegal instructions before constructor call */
    public c(Context context) {
        t.f(context, "context");
        MeasurementManager measurementManager = MeasurementManager.get(context);
        t.e(measurementManager, "get(context)");
        super(measurementManager);
    }
}
