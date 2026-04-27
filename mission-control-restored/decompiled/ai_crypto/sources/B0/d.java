package B0;

import android.adservices.measurement.MeasurementManager;
import android.content.Context;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class d extends l {
    /* JADX WARN: Illegal instructions before constructor call */
    public d(Context context) {
        r.f(context, "context");
        MeasurementManager measurementManager = MeasurementManager.get(context);
        r.e(measurementManager, "get(context)");
        super(measurementManager);
    }
}
