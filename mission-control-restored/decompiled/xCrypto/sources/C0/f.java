package C0;

import A0.c;
import A0.d;
import A0.j;
import A0.k;
import A0.o;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import androidx.window.extensions.layout.FoldingFeature;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;
import x0.C1913b;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f141a = new f();

    public final A0.c a(k windowMetrics, FoldingFeature oemFeature) {
        d.b bVarA;
        c.b bVar;
        r.f(windowMetrics, "windowMetrics");
        r.f(oemFeature, "oemFeature");
        int type = oemFeature.getType();
        if (type == 1) {
            bVarA = d.b.f16b.a();
        } else {
            if (type != 2) {
                return null;
            }
            bVarA = d.b.f16b.b();
        }
        int state = oemFeature.getState();
        if (state == 1) {
            bVar = c.b.f9c;
        } else {
            if (state != 2) {
                return null;
            }
            bVar = c.b.f10d;
        }
        Rect bounds = oemFeature.getBounds();
        r.e(bounds, "oemFeature.bounds");
        if (!d(windowMetrics, new C1913b(bounds))) {
            return null;
        }
        Rect bounds2 = oemFeature.getBounds();
        r.e(bounds2, "oemFeature.bounds");
        return new A0.d(new C1913b(bounds2), bVarA, bVar);
    }

    public final j b(k windowMetrics, WindowLayoutInfo info) {
        A0.c cVarA;
        r.f(windowMetrics, "windowMetrics");
        r.f(info, "info");
        List<FoldingFeature> displayFeatures = info.getDisplayFeatures();
        r.e(displayFeatures, "info.displayFeatures");
        ArrayList arrayList = new ArrayList();
        for (FoldingFeature feature : displayFeatures) {
            if (feature instanceof FoldingFeature) {
                f fVar = f141a;
                r.e(feature, "feature");
                cVarA = fVar.a(windowMetrics, feature);
            } else {
                cVarA = null;
            }
            if (cVarA != null) {
                arrayList.add(cVarA);
            }
        }
        return new j(arrayList);
    }

    public final j c(Context context, WindowLayoutInfo info) {
        r.f(context, "context");
        r.f(info, "info");
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 30) {
            return b(o.f50b.d(context), info);
        }
        if (i4 < 29 || !(context instanceof Activity)) {
            throw new UnsupportedOperationException("Display Features are only supported after Q. Display features for non-Activity contexts are not expected to be reported on devices running Q.");
        }
        return b(o.f50b.c((Activity) context), info);
    }

    public final boolean d(k kVar, C1913b c1913b) {
        Rect rectA = kVar.a();
        if (c1913b.e()) {
            return false;
        }
        if (c1913b.d() != rectA.width() && c1913b.a() != rectA.height()) {
            return false;
        }
        if (c1913b.d() >= rectA.width() || c1913b.a() >= rectA.height()) {
            return (c1913b.d() == rectA.width() && c1913b.a() == rectA.height()) ? false : true;
        }
        return false;
    }
}
