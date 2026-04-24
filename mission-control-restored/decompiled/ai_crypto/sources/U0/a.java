package U0;

import F5.AbstractC0556n;
import O0.h;
import O0.j;
import Q5.k;
import R0.c;
import R0.d;
import android.graphics.Rect;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0082a f4749b = new C0082a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f4750c = a.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f4751a;

    /* JADX INFO: renamed from: U0.a$a, reason: collision with other inner class name */
    public static final class C0082a {
        public /* synthetic */ C0082a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final int a(SidecarDeviceState sidecarDeviceState) {
            r.f(sidecarDeviceState, "sidecarDeviceState");
            try {
                try {
                    return sidecarDeviceState.posture;
                } catch (NoSuchFieldError unused) {
                    Object objInvoke = SidecarDeviceState.class.getMethod("getPosture", null).invoke(sidecarDeviceState, null);
                    r.d(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                    return ((Integer) objInvoke).intValue();
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return 0;
            }
        }

        public final int b(SidecarDeviceState sidecarDeviceState) {
            r.f(sidecarDeviceState, "sidecarDeviceState");
            int iA = a(sidecarDeviceState);
            if (iA < 0 || iA > 4) {
                return 0;
            }
            return iA;
        }

        public final List c(SidecarWindowLayoutInfo info) {
            r.f(info, "info");
            try {
                try {
                    List list = info.displayFeatures;
                    return list == null ? AbstractC0556n.g() : list;
                } catch (NoSuchFieldError unused) {
                    Object objInvoke = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", null).invoke(info, null);
                    r.d(objInvoke, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                    return (List) objInvoke;
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return AbstractC0556n.g();
            }
            return AbstractC0556n.g();
        }

        public final void d(SidecarDeviceState sidecarDeviceState, int i7) {
            r.f(sidecarDeviceState, "sidecarDeviceState");
            try {
                try {
                    sidecarDeviceState.posture = i7;
                } catch (NoSuchFieldError unused) {
                    SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, Integer.valueOf(i7));
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        public C0082a() {
        }
    }

    public static final class b extends s implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f4752a = new b();

        public b() {
            super(1);
        }

        @Override // Q5.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(SidecarDisplayFeature require) {
            r.f(require, "$this$require");
            boolean z7 = true;
            if (require.getType() != 1 && require.getType() != 2) {
                z7 = false;
            }
            return Boolean.valueOf(z7);
        }
    }

    public static final class c extends s implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f4753a = new c();

        public c() {
            super(1);
        }

        @Override // Q5.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(SidecarDisplayFeature require) {
            r.f(require, "$this$require");
            return Boolean.valueOf((require.getRect().width() == 0 && require.getRect().height() == 0) ? false : true);
        }
    }

    public static final class d extends s implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f4754a = new d();

        public d() {
            super(1);
        }

        @Override // Q5.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(SidecarDisplayFeature require) {
            r.f(require, "$this$require");
            boolean z7 = true;
            if (require.getType() == 1 && require.getRect().width() != 0 && require.getRect().height() != 0) {
                z7 = false;
            }
            return Boolean.valueOf(z7);
        }
    }

    public static final class e extends s implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f4755a = new e();

        public e() {
            super(1);
        }

        @Override // Q5.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(SidecarDisplayFeature require) {
            r.f(require, "$this$require");
            return Boolean.valueOf(require.getRect().left == 0 || require.getRect().top == 0);
        }
    }

    public a(j verificationMode) {
        r.f(verificationMode, "verificationMode");
        this.f4751a = verificationMode;
    }

    public final boolean a(SidecarDeviceState sidecarDeviceState, SidecarDeviceState sidecarDeviceState2) {
        if (r.b(sidecarDeviceState, sidecarDeviceState2)) {
            return true;
        }
        if (sidecarDeviceState == null || sidecarDeviceState2 == null) {
            return false;
        }
        C0082a c0082a = f4749b;
        return c0082a.b(sidecarDeviceState) == c0082a.b(sidecarDeviceState2);
    }

    public final boolean b(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (r.b(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return r.b(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    public final boolean c(List list, List list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (!b((SidecarDisplayFeature) list.get(i7), (SidecarDisplayFeature) list2.get(i7))) {
                return false;
            }
        }
        return true;
    }

    public final boolean d(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarWindowLayoutInfo sidecarWindowLayoutInfo2) {
        if (r.b(sidecarWindowLayoutInfo, sidecarWindowLayoutInfo2)) {
            return true;
        }
        if (sidecarWindowLayoutInfo == null || sidecarWindowLayoutInfo2 == null) {
            return false;
        }
        C0082a c0082a = f4749b;
        return c(c0082a.c(sidecarWindowLayoutInfo), c0082a.c(sidecarWindowLayoutInfo2));
    }

    public final R0.j e(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState state) {
        r.f(state, "state");
        if (sidecarWindowLayoutInfo == null) {
            return new R0.j(AbstractC0556n.g());
        }
        SidecarDeviceState sidecarDeviceState = new SidecarDeviceState();
        C0082a c0082a = f4749b;
        c0082a.d(sidecarDeviceState, c0082a.b(state));
        return new R0.j(f(c0082a.c(sidecarWindowLayoutInfo), sidecarDeviceState));
    }

    public final List f(List sidecarDisplayFeatures, SidecarDeviceState deviceState) {
        r.f(sidecarDisplayFeatures, "sidecarDisplayFeatures");
        r.f(deviceState, "deviceState");
        ArrayList arrayList = new ArrayList();
        Iterator it = sidecarDisplayFeatures.iterator();
        while (it.hasNext()) {
            R0.a aVarG = g((SidecarDisplayFeature) it.next(), deviceState);
            if (aVarG != null) {
                arrayList.add(aVarG);
            }
        }
        return arrayList;
    }

    public final R0.a g(SidecarDisplayFeature feature, SidecarDeviceState deviceState) {
        d.b bVarA;
        c.b bVar;
        r.f(feature, "feature");
        r.f(deviceState, "deviceState");
        h.a aVar = h.f4028a;
        String TAG = f4750c;
        r.e(TAG, "TAG");
        SidecarDisplayFeature sidecarDisplayFeature = (SidecarDisplayFeature) h.a.b(aVar, feature, TAG, this.f4751a, null, 4, null).c("Type must be either TYPE_FOLD or TYPE_HINGE", b.f4752a).c("Feature bounds must not be 0", c.f4753a).c("TYPE_FOLD must have 0 area", d.f4754a).c("Feature be pinned to either left or top", e.f4755a).a();
        if (sidecarDisplayFeature == null) {
            return null;
        }
        int type = sidecarDisplayFeature.getType();
        if (type == 1) {
            bVarA = d.b.f4637b.a();
        } else {
            if (type != 2) {
                return null;
            }
            bVarA = d.b.f4637b.b();
        }
        int iB = f4749b.b(deviceState);
        if (iB == 0 || iB == 1) {
            return null;
        }
        if (iB == 2) {
            bVar = c.b.f4631d;
        } else {
            if (iB != 3 && iB == 4) {
                return null;
            }
            bVar = c.b.f4630c;
        }
        Rect rect = feature.getRect();
        r.e(rect, "feature.rect");
        return new R0.d(new O0.b(rect), bVarA, bVar);
    }

    public /* synthetic */ a(j jVar, int i7, AbstractC2148j abstractC2148j) {
        this((i7 & 1) != 0 ? j.QUIET : jVar);
    }
}
