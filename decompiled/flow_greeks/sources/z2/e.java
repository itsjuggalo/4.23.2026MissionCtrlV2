package z2;

import android.graphics.Rect;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import cd.h0;
import dd.r;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import t2.h;
import t2.j;
import w2.c;
import w2.d;
import w2.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f25584b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f25585c = e.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f25586a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public final int a(SidecarDeviceState sidecarDeviceState) {
            t.f(sidecarDeviceState, "sidecarDeviceState");
            try {
                try {
                    return sidecarDeviceState.posture;
                } catch (NoSuchFieldError unused) {
                    Object objInvoke = SidecarDeviceState.class.getMethod("getPosture", null).invoke(sidecarDeviceState, null);
                    t.d(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                    return ((Integer) objInvoke).intValue();
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return 0;
            }
        }

        public final int b(SidecarDeviceState sidecarDeviceState) {
            t.f(sidecarDeviceState, "sidecarDeviceState");
            int iA = a(sidecarDeviceState);
            if (iA < 0 || iA > 4) {
                return 0;
            }
            return iA;
        }

        public final List c(SidecarWindowLayoutInfo info) {
            t.f(info, "info");
            try {
                try {
                    List list = info.displayFeatures;
                    return list == null ? r.k() : list;
                } catch (NoSuchFieldError unused) {
                    Object objInvoke = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", null).invoke(info, null);
                    t.d(objInvoke, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                    return (List) objInvoke;
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return r.k();
            }
            return r.k();
        }

        public final void d(SidecarDeviceState sidecarDeviceState, int i10) {
            t.f(sidecarDeviceState, "sidecarDeviceState");
            try {
                try {
                    sidecarDeviceState.posture = i10;
                } catch (NoSuchFieldError unused) {
                    SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, Integer.valueOf(i10));
                }
            } catch (IllegalAccessException unused2) {
                h0 h0Var = h0.f3852a;
            } catch (NoSuchMethodException unused3) {
                h0 h0Var2 = h0.f3852a;
            } catch (InvocationTargetException unused4) {
                h0 h0Var3 = h0.f3852a;
            }
        }

        public a() {
        }
    }

    public e(j verificationMode) {
        t.f(verificationMode, "verificationMode");
        this.f25586a = verificationMode;
    }

    public static final boolean k(SidecarDisplayFeature require) {
        t.f(require, "$this$require");
        return require.getType() == 1 || require.getType() == 2;
    }

    public static final boolean l(SidecarDisplayFeature require) {
        t.f(require, "$this$require");
        return (require.getRect().width() == 0 && require.getRect().height() == 0) ? false : true;
    }

    public static final boolean m(SidecarDisplayFeature require) {
        t.f(require, "$this$require");
        return require.getType() != 1 || require.getRect().width() == 0 || require.getRect().height() == 0;
    }

    public static final boolean n(SidecarDisplayFeature require) {
        t.f(require, "$this$require");
        return require.getRect().left == 0 || require.getRect().top == 0;
    }

    public final boolean e(SidecarDeviceState sidecarDeviceState, SidecarDeviceState sidecarDeviceState2) {
        if (t.b(sidecarDeviceState, sidecarDeviceState2)) {
            return true;
        }
        if (sidecarDeviceState == null || sidecarDeviceState2 == null) {
            return false;
        }
        a aVar = f25584b;
        return aVar.b(sidecarDeviceState) == aVar.b(sidecarDeviceState2);
    }

    public final boolean f(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (t.b(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return t.b(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    public final boolean g(List list, List list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!f((SidecarDisplayFeature) list.get(i10), (SidecarDisplayFeature) list2.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public final boolean h(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarWindowLayoutInfo sidecarWindowLayoutInfo2) {
        if (t.b(sidecarWindowLayoutInfo, sidecarWindowLayoutInfo2)) {
            return true;
        }
        if (sidecarWindowLayoutInfo == null || sidecarWindowLayoutInfo2 == null) {
            return false;
        }
        a aVar = f25584b;
        return g(aVar.c(sidecarWindowLayoutInfo), aVar.c(sidecarWindowLayoutInfo2));
    }

    public final List i(List sidecarDisplayFeatures, SidecarDeviceState deviceState) {
        t.f(sidecarDisplayFeatures, "sidecarDisplayFeatures");
        t.f(deviceState, "deviceState");
        ArrayList arrayList = new ArrayList();
        Iterator it = sidecarDisplayFeatures.iterator();
        while (it.hasNext()) {
            w2.a aVarO = o((SidecarDisplayFeature) it.next(), deviceState);
            if (aVarO != null) {
                arrayList.add(aVarO);
            }
        }
        return arrayList;
    }

    public final s j(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState state) {
        t.f(state, "state");
        if (sidecarWindowLayoutInfo == null) {
            return new s(r.k());
        }
        SidecarDeviceState sidecarDeviceState = new SidecarDeviceState();
        a aVar = f25584b;
        aVar.d(sidecarDeviceState, aVar.b(state));
        return new s(i(aVar.c(sidecarWindowLayoutInfo), sidecarDeviceState));
    }

    public final w2.a o(SidecarDisplayFeature feature, SidecarDeviceState deviceState) {
        d.b bVarA;
        c.b bVar;
        t.f(feature, "feature");
        t.f(deviceState, "deviceState");
        h.a aVar = h.f20656a;
        String TAG = f25585c;
        t.e(TAG, "TAG");
        SidecarDisplayFeature sidecarDisplayFeature = (SidecarDisplayFeature) h.a.b(aVar, feature, TAG, this.f25586a, null, 4, null).c("Type must be either TYPE_FOLD or TYPE_HINGE", new pd.k() { // from class: z2.a
            @Override // pd.k
            public final Object invoke(Object obj) {
                return Boolean.valueOf(e.k((SidecarDisplayFeature) obj));
            }
        }).c("Feature bounds must not be 0", new pd.k() { // from class: z2.b
            @Override // pd.k
            public final Object invoke(Object obj) {
                return Boolean.valueOf(e.l((SidecarDisplayFeature) obj));
            }
        }).c("TYPE_FOLD must have 0 area", new pd.k() { // from class: z2.c
            @Override // pd.k
            public final Object invoke(Object obj) {
                return Boolean.valueOf(e.m((SidecarDisplayFeature) obj));
            }
        }).c("Feature be pinned to either left or top", new pd.k() { // from class: z2.d
            @Override // pd.k
            public final Object invoke(Object obj) {
                return Boolean.valueOf(e.n((SidecarDisplayFeature) obj));
            }
        }).a();
        if (sidecarDisplayFeature == null) {
            return null;
        }
        int type = sidecarDisplayFeature.getType();
        if (type == 1) {
            bVarA = d.b.f23630b.a();
        } else {
            if (type != 2) {
                return null;
            }
            bVarA = d.b.f23630b.b();
        }
        int iB = f25584b.b(deviceState);
        if (iB == 0 || iB == 1) {
            return null;
        }
        if (iB == 2) {
            bVar = c.b.f23624d;
        } else {
            if (iB != 3 && iB == 4) {
                return null;
            }
            bVar = c.b.f23623c;
        }
        Rect rect = feature.getRect();
        t.e(rect, "getRect(...)");
        return new w2.d(new t2.b(rect), bVarA, bVar);
    }

    public /* synthetic */ e(j jVar, int i10, k kVar) {
        this((i10 & 1) != 0 ? j.f20663c : jVar);
    }
}
