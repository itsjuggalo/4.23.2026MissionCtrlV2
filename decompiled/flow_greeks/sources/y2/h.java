package y2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import androidx.window.extensions.layout.FoldingFeature;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.ArrayList;
import java.util.List;
import w2.c;
import w2.d;
import w2.s;
import w2.t;
import w2.w;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f25178a = new h();

    public final w2.c a(t windowMetrics, FoldingFeature oemFeature) {
        d.b bVarA;
        c.b bVar;
        kotlin.jvm.internal.t.f(windowMetrics, "windowMetrics");
        kotlin.jvm.internal.t.f(oemFeature, "oemFeature");
        int type = oemFeature.getType();
        if (type == 1) {
            bVarA = d.b.f23630b.a();
        } else {
            if (type != 2) {
                return null;
            }
            bVarA = d.b.f23630b.b();
        }
        int state = oemFeature.getState();
        if (state == 1) {
            bVar = c.b.f23623c;
        } else {
            if (state != 2) {
                return null;
            }
            bVar = c.b.f23624d;
        }
        Rect bounds = oemFeature.getBounds();
        kotlin.jvm.internal.t.e(bounds, "getBounds(...)");
        if (!d(windowMetrics, new t2.b(bounds))) {
            return null;
        }
        Rect bounds2 = oemFeature.getBounds();
        kotlin.jvm.internal.t.e(bounds2, "getBounds(...)");
        return new w2.d(new t2.b(bounds2), bVarA, bVar);
    }

    public final s b(Context context, WindowLayoutInfo info) {
        kotlin.jvm.internal.t.f(context, "context");
        kotlin.jvm.internal.t.f(info, "info");
        w wVar = new w(null, 1, null);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            return c(wVar.d(context), info);
        }
        if (i10 < 29 || !(context instanceof Activity)) {
            throw new UnsupportedOperationException("Display Features are only supported after Q. Display features for non-Activity contexts are not expected to be reported on devices running Q.");
        }
        return c(wVar.c((Activity) context), info);
    }

    public final s c(t windowMetrics, WindowLayoutInfo info) {
        kotlin.jvm.internal.t.f(windowMetrics, "windowMetrics");
        kotlin.jvm.internal.t.f(info, "info");
        List<FoldingFeature> displayFeatures = info.getDisplayFeatures();
        kotlin.jvm.internal.t.e(displayFeatures, "getDisplayFeatures(...)");
        ArrayList arrayList = new ArrayList();
        for (FoldingFeature foldingFeature : displayFeatures) {
            w2.c cVarA = foldingFeature instanceof FoldingFeature ? f25178a.a(windowMetrics, foldingFeature) : null;
            if (cVarA != null) {
                arrayList.add(cVarA);
            }
        }
        return new s(arrayList);
    }

    public final boolean d(t tVar, t2.b bVar) {
        Rect rectA = tVar.a();
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
