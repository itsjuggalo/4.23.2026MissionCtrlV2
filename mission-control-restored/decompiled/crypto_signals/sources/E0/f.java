package E0;

import H4.p;
import android.graphics.Rect;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import y0.C1413a;
import y0.C1414b;
import y0.C1419g;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f370b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f371a;

    public f() {
        a3.d.q(3, "verificationMode");
        this.f371a = 3;
    }

    public static boolean a(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (kotlin.jvm.internal.j.a(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return kotlin.jvm.internal.j.a(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    public static boolean b(List list, List list2) {
        if (list == list2) {
            return true;
        }
        if (list.size() == list2.size()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (a((SidecarDisplayFeature) list.get(i), (SidecarDisplayFeature) list2.get(i))) {
                }
            }
            return true;
        }
        return false;
    }

    public final B0.l c(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState sidecarDeviceState) {
        if (sidecarWindowLayoutInfo == null) {
            return new B0.l(p.f577a);
        }
        SidecarDeviceState sidecarDeviceState2 = new SidecarDeviceState();
        a.d(sidecarDeviceState2, a.b(sidecarDeviceState));
        return new B0.l(d(a.c(sidecarWindowLayoutInfo), sidecarDeviceState2));
    }

    public final ArrayList d(List list, SidecarDeviceState sidecarDeviceState) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            B0.c cVarE = e((SidecarDisplayFeature) it.next(), sidecarDeviceState);
            if (cVarE != null) {
                arrayList.add(cVarE);
            }
        }
        return arrayList;
    }

    public final B0.c e(SidecarDisplayFeature feature, SidecarDeviceState sidecarDeviceState) {
        B0.b bVar;
        B0.b bVar2;
        kotlin.jvm.internal.j.e(feature, "feature");
        C1413a c1413a = C1413a.f11613a;
        int i = this.f371a;
        a3.d.q(i, "verificationMode");
        SidecarDisplayFeature sidecarDisplayFeature = (SidecarDisplayFeature) new C1419g(feature, i, c1413a).v("Type must be either TYPE_FOLD or TYPE_HINGE", b.f366a).v("Feature bounds must not be 0", c.f367a).v("TYPE_FOLD must have 0 area", d.f368a).v("Feature be pinned to either left or top", e.f369a).g();
        if (sidecarDisplayFeature == null) {
            return null;
        }
        int type = sidecarDisplayFeature.getType();
        if (type == 1) {
            bVar = B0.b.f80k;
        } else {
            if (type != 2) {
                return null;
            }
            bVar = B0.b.f81l;
        }
        int iB = a.b(sidecarDeviceState);
        if (iB == 0 || iB == 1) {
            return null;
        }
        if (iB != 2) {
            bVar2 = B0.b.e;
            if (iB != 3 && iB == 4) {
                return null;
            }
        } else {
            bVar2 = B0.b.f79f;
        }
        Rect rect = feature.getRect();
        kotlin.jvm.internal.j.d(rect, "feature.rect");
        return new B0.c(new C1414b(rect), bVar, bVar2);
    }
}
