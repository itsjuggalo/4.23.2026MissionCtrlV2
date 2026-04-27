package N0;

import L0.c;
import L0.d;
import L0.j;
import L0.k;
import L0.m;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import androidx.window.extensions.layout.FoldingFeature;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f5455a = new g();

    public final L0.c a(k windowMetrics, FoldingFeature oemFeature) {
        d.b bVarA;
        c.b bVar;
        AbstractC2304t.f(windowMetrics, "windowMetrics");
        AbstractC2304t.f(oemFeature, "oemFeature");
        int type = oemFeature.getType();
        if (type == 1) {
            bVarA = d.b.f4961b.a();
        } else {
            if (type != 2) {
                return null;
            }
            bVarA = d.b.f4961b.b();
        }
        int state = oemFeature.getState();
        if (state == 1) {
            bVar = c.b.f4954c;
        } else {
            if (state != 2) {
                return null;
            }
            bVar = c.b.f4955d;
        }
        Rect bounds = oemFeature.getBounds();
        AbstractC2304t.e(bounds, "getBounds(...)");
        if (!d(windowMetrics, new I0.b(bounds))) {
            return null;
        }
        Rect bounds2 = oemFeature.getBounds();
        AbstractC2304t.e(bounds2, "getBounds(...)");
        return new L0.d(new I0.b(bounds2), bVarA, bVar);
    }

    public final j b(k windowMetrics, WindowLayoutInfo info) {
        L0.c cVarA;
        AbstractC2304t.f(windowMetrics, "windowMetrics");
        AbstractC2304t.f(info, "info");
        List<FoldingFeature> displayFeatures = info.getDisplayFeatures();
        AbstractC2304t.e(displayFeatures, "getDisplayFeatures(...)");
        ArrayList arrayList = new ArrayList();
        for (FoldingFeature foldingFeature : displayFeatures) {
            if (foldingFeature instanceof FoldingFeature) {
                g gVar = f5455a;
                AbstractC2304t.c(foldingFeature);
                cVarA = gVar.a(windowMetrics, foldingFeature);
            } else {
                cVarA = null;
            }
            if (cVarA != null) {
                arrayList.add(cVarA);
            }
        }
        return new j(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final j c(Context context, WindowLayoutInfo info) {
        k kVarC;
        AbstractC2304t.f(context, "context");
        AbstractC2304t.f(info, "info");
        m mVar = new m(null, 1, 0 == true ? 1 : 0);
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 30) {
            kVarC = mVar.d(context);
        } else {
            if (i8 < 29 || !(context instanceof Activity)) {
                throw new UnsupportedOperationException("Display Features are only supported after Q. Display features for non-Activity contexts are not expected to be reported on devices running Q.");
            }
            kVarC = mVar.c((Activity) context);
        }
        return b(kVarC, info);
    }

    public final boolean d(k kVar, I0.b bVar) {
        Rect rectA = kVar.a();
        if (bVar.e()) {
            return false;
        }
        if (bVar.d() != rectA.width() && bVar.a() != rectA.height()) {
            return false;
        }
        if (bVar.d() >= rectA.width() || bVar.a() >= rectA.height()) {
            return (bVar.d() == rectA.width() && bVar.a() == rectA.height()) ? false : true;
        }
        return false;
    }
}
