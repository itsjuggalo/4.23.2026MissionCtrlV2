package O0;

import B5.k;
import I0.h;
import I0.j;
import L0.c;
import L0.d;
import android.graphics.Rect;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0084a f5886b = new C0084a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5887c = a.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f5888a;

    /* JADX INFO: renamed from: O0.a$a, reason: collision with other inner class name */
    public static final class C0084a {
        public C0084a() {
        }

        public final int a(SidecarDeviceState sidecarDeviceState) {
            AbstractC2304t.f(sidecarDeviceState, "sidecarDeviceState");
            try {
                try {
                    return sidecarDeviceState.posture;
                } catch (NoSuchFieldError unused) {
                    Object objInvoke = SidecarDeviceState.class.getMethod("getPosture", null).invoke(sidecarDeviceState, null);
                    AbstractC2304t.d(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                    return ((Integer) objInvoke).intValue();
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return 0;
            }
        }

        public final int b(SidecarDeviceState sidecarDeviceState) {
            AbstractC2304t.f(sidecarDeviceState, "sidecarDeviceState");
            int iA = a(sidecarDeviceState);
            if (iA < 0 || iA > 4) {
                return 0;
            }
            return iA;
        }

        public final List c(SidecarWindowLayoutInfo info) {
            AbstractC2304t.f(info, "info");
            try {
                try {
                    List list = info.displayFeatures;
                    return list == null ? AbstractC2595q.i() : list;
                } catch (NoSuchFieldError unused) {
                    Object objInvoke = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", null).invoke(info, null);
                    AbstractC2304t.d(objInvoke, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                    return (List) objInvoke;
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return AbstractC2595q.i();
            }
            return AbstractC2595q.i();
        }

        public final void d(SidecarDeviceState sidecarDeviceState, int i8) {
            AbstractC2304t.f(sidecarDeviceState, "sidecarDeviceState");
            try {
                try {
                    sidecarDeviceState.posture = i8;
                } catch (NoSuchFieldError unused) {
                    SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, Integer.valueOf(i8));
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        public /* synthetic */ C0084a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public static final class b extends AbstractC2306v implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f5889a = new b();

        public b() {
            super(1);
        }

        @Override // B5.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(SidecarDisplayFeature require) {
            AbstractC2304t.f(require, "$this$require");
            boolean z7 = true;
            if (require.getType() != 1 && require.getType() != 2) {
                z7 = false;
            }
            return Boolean.valueOf(z7);
        }
    }

    public static final class c extends AbstractC2306v implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f5890a = new c();

        public c() {
            super(1);
        }

        @Override // B5.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(SidecarDisplayFeature require) {
            AbstractC2304t.f(require, "$this$require");
            return Boolean.valueOf((require.getRect().width() == 0 && require.getRect().height() == 0) ? false : true);
        }
    }

    public static final class d extends AbstractC2306v implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f5891a = new d();

        public d() {
            super(1);
        }

        @Override // B5.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(SidecarDisplayFeature require) {
            AbstractC2304t.f(require, "$this$require");
            boolean z7 = true;
            if (require.getType() == 1 && require.getRect().width() != 0 && require.getRect().height() != 0) {
                z7 = false;
            }
            return Boolean.valueOf(z7);
        }
    }

    public static final class e extends AbstractC2306v implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f5892a = new e();

        public e() {
            super(1);
        }

        @Override // B5.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(SidecarDisplayFeature require) {
            AbstractC2304t.f(require, "$this$require");
            return Boolean.valueOf(require.getRect().left == 0 || require.getRect().top == 0);
        }
    }

    public a(j verificationMode) {
        AbstractC2304t.f(verificationMode, "verificationMode");
        this.f5888a = verificationMode;
    }

    public final boolean a(SidecarDeviceState sidecarDeviceState, SidecarDeviceState sidecarDeviceState2) {
        if (AbstractC2304t.b(sidecarDeviceState, sidecarDeviceState2)) {
            return true;
        }
        if (sidecarDeviceState == null || sidecarDeviceState2 == null) {
            return false;
        }
        C0084a c0084a = f5886b;
        return c0084a.b(sidecarDeviceState) == c0084a.b(sidecarDeviceState2);
    }

    public final boolean b(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (AbstractC2304t.b(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return AbstractC2304t.b(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    public final boolean c(List list, List list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (!b((SidecarDisplayFeature) list.get(i8), (SidecarDisplayFeature) list2.get(i8))) {
                return false;
            }
        }
        return true;
    }

    public final boolean d(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarWindowLayoutInfo sidecarWindowLayoutInfo2) {
        if (AbstractC2304t.b(sidecarWindowLayoutInfo, sidecarWindowLayoutInfo2)) {
            return true;
        }
        if (sidecarWindowLayoutInfo == null || sidecarWindowLayoutInfo2 == null) {
            return false;
        }
        C0084a c0084a = f5886b;
        return c(c0084a.c(sidecarWindowLayoutInfo), c0084a.c(sidecarWindowLayoutInfo2));
    }

    public final L0.j e(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState state) {
        AbstractC2304t.f(state, "state");
        if (sidecarWindowLayoutInfo == null) {
            return new L0.j(AbstractC2595q.i());
        }
        SidecarDeviceState sidecarDeviceState = new SidecarDeviceState();
        C0084a c0084a = f5886b;
        c0084a.d(sidecarDeviceState, c0084a.b(state));
        return new L0.j(f(c0084a.c(sidecarWindowLayoutInfo), sidecarDeviceState));
    }

    public final List f(List sidecarDisplayFeatures, SidecarDeviceState deviceState) {
        AbstractC2304t.f(sidecarDisplayFeatures, "sidecarDisplayFeatures");
        AbstractC2304t.f(deviceState, "deviceState");
        ArrayList arrayList = new ArrayList();
        Iterator it = sidecarDisplayFeatures.iterator();
        while (it.hasNext()) {
            L0.a aVarG = g((SidecarDisplayFeature) it.next(), deviceState);
            if (aVarG != null) {
                arrayList.add(aVarG);
            }
        }
        return arrayList;
    }

    public final L0.a g(SidecarDisplayFeature feature, SidecarDeviceState deviceState) {
        d.b bVarA;
        c.b bVar;
        AbstractC2304t.f(feature, "feature");
        AbstractC2304t.f(deviceState, "deviceState");
        h.a aVar = h.f4042a;
        String TAG = f5887c;
        AbstractC2304t.e(TAG, "TAG");
        SidecarDisplayFeature sidecarDisplayFeature = (SidecarDisplayFeature) h.a.b(aVar, feature, TAG, this.f5888a, null, 4, null).c("Type must be either TYPE_FOLD or TYPE_HINGE", b.f5889a).c("Feature bounds must not be 0", c.f5890a).c("TYPE_FOLD must have 0 area", d.f5891a).c("Feature be pinned to either left or top", e.f5892a).a();
        if (sidecarDisplayFeature == null) {
            return null;
        }
        int type = sidecarDisplayFeature.getType();
        if (type == 1) {
            bVarA = d.b.f4961b.a();
        } else {
            if (type != 2) {
                return null;
            }
            bVarA = d.b.f4961b.b();
        }
        int iB = f5886b.b(deviceState);
        if (iB == 0 || iB == 1) {
            return null;
        }
        if (iB == 2) {
            bVar = c.b.f4955d;
        } else {
            if (iB != 3 && iB == 4) {
                return null;
            }
            bVar = c.b.f4954c;
        }
        Rect rect = feature.getRect();
        AbstractC2304t.e(rect, "getRect(...)");
        return new L0.d(new I0.b(rect), bVarA, bVar);
    }

    public /* synthetic */ a(j jVar, int i8, AbstractC2296k abstractC2296k) {
        this((i8 & 1) != 0 ? j.f4049c : jVar);
    }
}
