package w0;

import android.adservices.measurement.MeasurementManager;
import android.content.Context;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: w0.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2886d extends AbstractC2894l {
    /* JADX WARN: Illegal instructions before constructor call */
    public C2886d(Context context) {
        AbstractC2304t.f(context, "context");
        MeasurementManager measurementManager = MeasurementManager.get(context);
        AbstractC2304t.e(measurementManager, "get(context)");
        super(measurementManager);
    }
}
