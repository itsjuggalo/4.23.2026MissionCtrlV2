package D0;

import A0.c;
import A0.d;
import A0.j;
import X2.AbstractC0769p;
import android.graphics.Rect;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import i3.k;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import x0.AbstractC1919h;
import x0.C1913b;
import x0.EnumC1921j;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0012a f303b = new C0012a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f304c = a.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC1921j f305a;

    /* JADX INFO: renamed from: D0.a$a, reason: collision with other inner class name */
    public static final class C0012a {
        public /* synthetic */ C0012a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final int a(SidecarDeviceState sidecarDeviceState) {
            r.f(sidecarDeviceState, "sidecarDeviceState");
            try {
                return sidecarDeviceState.posture;
            } catch (NoSuchFieldError unused) {
                try {
                    Object objInvoke = SidecarDeviceState.class.getMethod("getPosture", new Class[0]).invoke(sidecarDeviceState, new Object[0]);
                    r.d(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                    return ((Integer) objInvoke).intValue();
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                    return 0;
                }
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
                    return list == null ? AbstractC0769p.g() : list;
                } catch (NoSuchFieldError unused) {
                    Object objInvoke = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", new Class[0]).invoke(info, new Object[0]);
                    r.d(objInvoke, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                    return (List) objInvoke;
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return AbstractC0769p.g();
            }
            return AbstractC0769p.g();
        }

        public final void d(SidecarDeviceState sidecarDeviceState, int i4) {
            r.f(sidecarDeviceState, "sidecarDeviceState");
            try {
                try {
                    sidecarDeviceState.posture = i4;
                } catch (NoSuchFieldError unused) {
                    SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, Integer.valueOf(i4));
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        public C0012a() {
        }
    }

    public static final class b extends s implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f306a = new b();

        public b() {
            super(1);
        }

        @Override // i3.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(SidecarDisplayFeature require) {
            r.f(require, "$this$require");
            boolean z4 = true;
            if (require.getType() != 1 && require.getType() != 2) {
                z4 = false;
            }
            return Boolean.valueOf(z4);
        }
    }

    public static final class c extends s implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f307a = new c();

        public c() {
            super(1);
        }

        @Override // i3.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(SidecarDisplayFeature require) {
            r.f(require, "$this$require");
            return Boolean.valueOf((require.getRect().width() == 0 && require.getRect().height() == 0) ? false : true);
        }
    }

    public static final class d extends s implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f308a = new d();

        public d() {
            super(1);
        }

        @Override // i3.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(SidecarDisplayFeature require) {
            r.f(require, "$this$require");
            boolean z4 = true;
            if (require.getType() == 1 && require.getRect().width() != 0 && require.getRect().height() != 0) {
                z4 = false;
            }
            return Boolean.valueOf(z4);
        }
    }

    public static final class e extends s implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f309a = new e();

        public e() {
            super(1);
        }

        @Override // i3.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(SidecarDisplayFeature require) {
            r.f(require, "$this$require");
            return Boolean.valueOf(require.getRect().left == 0 || require.getRect().top == 0);
        }
    }

    public a(EnumC1921j verificationMode) {
        r.f(verificationMode, "verificationMode");
        this.f305a = verificationMode;
    }

    public final boolean a(SidecarDeviceState sidecarDeviceState, SidecarDeviceState sidecarDeviceState2) {
        if (r.b(sidecarDeviceState, sidecarDeviceState2)) {
            return true;
        }
        if (sidecarDeviceState == null || sidecarDeviceState2 == null) {
            return false;
        }
        C0012a c0012a = f303b;
        return c0012a.b(sidecarDeviceState) == c0012a.b(sidecarDeviceState2);
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
        for (int i4 = 0; i4 < size; i4++) {
            if (!b((SidecarDisplayFeature) list.get(i4), (SidecarDisplayFeature) list2.get(i4))) {
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
        C0012a c0012a = f303b;
        return c(c0012a.c(sidecarWindowLayoutInfo), c0012a.c(sidecarWindowLayoutInfo2));
    }

    public final j e(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState state) {
        r.f(state, "state");
        if (sidecarWindowLayoutInfo == null) {
            return new j(AbstractC0769p.g());
        }
        SidecarDeviceState sidecarDeviceState = new SidecarDeviceState();
        C0012a c0012a = f303b;
        c0012a.d(sidecarDeviceState, c0012a.b(state));
        return new j(f(c0012a.c(sidecarWindowLayoutInfo), sidecarDeviceState));
    }

    public final List f(List sidecarDisplayFeatures, SidecarDeviceState deviceState) {
        r.f(sidecarDisplayFeatures, "sidecarDisplayFeatures");
        r.f(deviceState, "deviceState");
        ArrayList arrayList = new ArrayList();
        Iterator it = sidecarDisplayFeatures.iterator();
        while (it.hasNext()) {
            A0.a aVarG = g((SidecarDisplayFeature) it.next(), deviceState);
            if (aVarG != null) {
                arrayList.add(aVarG);
            }
        }
        return arrayList;
    }

    public final A0.a g(SidecarDisplayFeature feature, SidecarDeviceState deviceState) {
        d.b bVarA;
        c.b bVar;
        r.f(feature, "feature");
        r.f(deviceState, "deviceState");
        AbstractC1919h.a aVar = AbstractC1919h.f15713a;
        String TAG = f304c;
        r.e(TAG, "TAG");
        SidecarDisplayFeature sidecarDisplayFeature = (SidecarDisplayFeature) AbstractC1919h.a.b(aVar, feature, TAG, this.f305a, null, 4, null).c("Type must be either TYPE_FOLD or TYPE_HINGE", b.f306a).c("Feature bounds must not be 0", c.f307a).c("TYPE_FOLD must have 0 area", d.f308a).c("Feature be pinned to either left or top", e.f309a).a();
        if (sidecarDisplayFeature == null) {
            return null;
        }
        int type = sidecarDisplayFeature.getType();
        if (type == 1) {
            bVarA = d.b.f16b.a();
        } else {
            if (type != 2) {
                return null;
            }
            bVarA = d.b.f16b.b();
        }
        int iB = f303b.b(deviceState);
        if (iB == 0 || iB == 1) {
            return null;
        }
        if (iB == 2) {
            bVar = c.b.f10d;
        } else {
            if (iB != 3 && iB == 4) {
                return null;
            }
            bVar = c.b.f9c;
        }
        Rect rect = feature.getRect();
        r.e(rect, "feature.rect");
        return new A0.d(new C1913b(rect), bVarA, bVar);
    }

    public /* synthetic */ a(EnumC1921j enumC1921j, int i4, AbstractC1585j abstractC1585j) {
        this((i4 & 1) != 0 ? EnumC1921j.QUIET : enumC1921j);
    }
}
