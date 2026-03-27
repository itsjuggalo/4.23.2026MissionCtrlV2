package androidx.window.layout.adapter.sidecar;

import E5.E;
import F5.AbstractC0556n;
import O0.k;
import R0.j;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.layout.adapter.sidecar.SidecarCompat;
import androidx.window.layout.adapter.sidecar.a;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class SidecarCompat implements androidx.window.layout.adapter.sidecar.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f8448f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SidecarInterface f8449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final U0.a f8450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f8451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f8452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f8453e;

    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {
        public TranslatingCallback() {
        }

        public void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
            SidecarInterface sidecarInterfaceH;
            r.f(newDeviceState, "newDeviceState");
            Collection<Activity> collectionValues = SidecarCompat.this.f8451c.values();
            SidecarCompat sidecarCompat = SidecarCompat.this;
            for (Activity activity : collectionValues) {
                IBinder iBinderA = SidecarCompat.f8448f.a(activity);
                SidecarWindowLayoutInfo windowLayoutInfo = null;
                if (iBinderA != null && (sidecarInterfaceH = sidecarCompat.h()) != null) {
                    windowLayoutInfo = sidecarInterfaceH.getWindowLayoutInfo(iBinderA);
                }
                b bVar = sidecarCompat.f8453e;
                if (bVar != null) {
                    bVar.a(activity, sidecarCompat.f8450b.e(windowLayoutInfo, newDeviceState));
                }
            }
        }

        public void onWindowLayoutChanged(IBinder windowToken, SidecarWindowLayoutInfo newLayout) {
            SidecarDeviceState sidecarDeviceState;
            r.f(windowToken, "windowToken");
            r.f(newLayout, "newLayout");
            Activity activity = (Activity) SidecarCompat.this.f8451c.get(windowToken);
            if (activity == null) {
                Log.w("SidecarCompat", "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                return;
            }
            U0.a aVar = SidecarCompat.this.f8450b;
            SidecarInterface sidecarInterfaceH = SidecarCompat.this.h();
            if (sidecarInterfaceH == null || (sidecarDeviceState = sidecarInterfaceH.getDeviceState()) == null) {
                sidecarDeviceState = new SidecarDeviceState();
            }
            j jVarE = aVar.e(newLayout, sidecarDeviceState);
            b bVar = SidecarCompat.this.f8453e;
            if (bVar != null) {
                bVar.a(activity, jVarE);
            }
        }
    }

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final IBinder a(Activity activity) {
            Window window;
            WindowManager.LayoutParams attributes;
            if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
                return null;
            }
            return attributes.token;
        }

        public final SidecarInterface b(Context context) {
            r.f(context, "context");
            return SidecarProvider.getSidecarImpl(context.getApplicationContext());
        }

        public final k c() {
            try {
                String apiVersion = SidecarProvider.getApiVersion();
                if (TextUtils.isEmpty(apiVersion)) {
                    return null;
                }
                return k.f4037f.b(apiVersion);
            } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
                return null;
            }
        }

        public a() {
        }
    }

    public static final class b implements a.InterfaceC0141a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a.InterfaceC0141a f8455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ReentrantLock f8456b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WeakHashMap f8457c;

        public b(a.InterfaceC0141a callbackInterface) {
            r.f(callbackInterface, "callbackInterface");
            this.f8455a = callbackInterface;
            this.f8456b = new ReentrantLock();
            this.f8457c = new WeakHashMap();
        }

        @Override // androidx.window.layout.adapter.sidecar.a.InterfaceC0141a
        public void a(Activity activity, j newLayout) {
            r.f(activity, "activity");
            r.f(newLayout, "newLayout");
            ReentrantLock reentrantLock = this.f8456b;
            reentrantLock.lock();
            try {
                if (r.b(newLayout, (j) this.f8457c.get(activity))) {
                    return;
                }
                reentrantLock.unlock();
                this.f8455a.a(activity, newLayout);
            } finally {
                reentrantLock.unlock();
            }
        }

        public final void b(Activity activity) {
            r.f(activity, "activity");
            ReentrantLock reentrantLock = this.f8456b;
            reentrantLock.lock();
            try {
                this.f8457c.put(activity, null);
                E e7 = E.f1657a;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public static final class c implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SidecarCompat f8458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference f8459b;

        public c(SidecarCompat sidecarCompat, Activity activity) {
            r.f(sidecarCompat, "sidecarCompat");
            r.f(activity, "activity");
            this.f8458a = sidecarCompat;
            this.f8459b = new WeakReference(activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            r.f(view, "view");
            view.removeOnAttachStateChangeListener(this);
            Activity activity = (Activity) this.f8459b.get();
            IBinder iBinderA = SidecarCompat.f8448f.a(activity);
            if (activity == null || iBinderA == null) {
                return;
            }
            this.f8458a.j(iBinderA, activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            r.f(view, "view");
        }
    }

    public SidecarCompat(SidecarInterface sidecarInterface, U0.a sidecarAdapter) {
        r.f(sidecarAdapter, "sidecarAdapter");
        this.f8449a = sidecarInterface;
        this.f8450b = sidecarAdapter;
        this.f8451c = new LinkedHashMap();
        this.f8452d = new LinkedHashMap();
    }

    public static final void l(SidecarCompat this$0, Activity activity, Configuration configuration) {
        r.f(this$0, "this$0");
        r.f(activity, "$activity");
        b bVar = this$0.f8453e;
        if (bVar != null) {
            bVar.a(activity, this$0.i(activity));
        }
    }

    @Override // androidx.window.layout.adapter.sidecar.a
    public void a(a.InterfaceC0141a extensionCallback) {
        r.f(extensionCallback, "extensionCallback");
        this.f8453e = new b(extensionCallback);
        SidecarInterface sidecarInterface = this.f8449a;
        if (sidecarInterface != null) {
            sidecarInterface.setSidecarCallback(new DistinctElementSidecarCallback(this.f8450b, new TranslatingCallback()));
        }
    }

    @Override // androidx.window.layout.adapter.sidecar.a
    public void b(Activity activity) {
        r.f(activity, "activity");
        IBinder iBinderA = f8448f.a(activity);
        if (iBinderA != null) {
            j(iBinderA, activity);
        } else {
            activity.getWindow().getDecorView().addOnAttachStateChangeListener(new c(this, activity));
        }
    }

    @Override // androidx.window.layout.adapter.sidecar.a
    public void c(Activity activity) {
        SidecarInterface sidecarInterface;
        r.f(activity, "activity");
        IBinder iBinderA = f8448f.a(activity);
        if (iBinderA == null) {
            return;
        }
        SidecarInterface sidecarInterface2 = this.f8449a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerRemoved(iBinderA);
        }
        m(activity);
        b bVar = this.f8453e;
        if (bVar != null) {
            bVar.b(activity);
        }
        boolean z7 = this.f8451c.size() == 1;
        this.f8451c.remove(iBinderA);
        if (!z7 || (sidecarInterface = this.f8449a) == null) {
            return;
        }
        sidecarInterface.onDeviceStateListenersChanged(true);
    }

    public final SidecarInterface h() {
        return this.f8449a;
    }

    public final j i(Activity activity) {
        SidecarDeviceState sidecarDeviceState;
        r.f(activity, "activity");
        IBinder iBinderA = f8448f.a(activity);
        if (iBinderA == null) {
            return new j(AbstractC0556n.g());
        }
        SidecarInterface sidecarInterface = this.f8449a;
        SidecarWindowLayoutInfo windowLayoutInfo = sidecarInterface != null ? sidecarInterface.getWindowLayoutInfo(iBinderA) : null;
        U0.a aVar = this.f8450b;
        SidecarInterface sidecarInterface2 = this.f8449a;
        if (sidecarInterface2 == null || (sidecarDeviceState = sidecarInterface2.getDeviceState()) == null) {
            sidecarDeviceState = new SidecarDeviceState();
        }
        return aVar.e(windowLayoutInfo, sidecarDeviceState);
    }

    public final void j(IBinder windowToken, Activity activity) {
        SidecarInterface sidecarInterface;
        r.f(windowToken, "windowToken");
        r.f(activity, "activity");
        this.f8451c.put(windowToken, activity);
        SidecarInterface sidecarInterface2 = this.f8449a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(windowToken);
        }
        if (this.f8451c.size() == 1 && (sidecarInterface = this.f8449a) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        b bVar = this.f8453e;
        if (bVar != null) {
            bVar.a(activity, i(activity));
        }
        k(activity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k(final Activity activity) {
        if (this.f8452d.get(activity) == null && (activity instanceof G.c)) {
            P.a aVar = new P.a() { // from class: U0.b
                @Override // P.a
                public final void accept(Object obj) {
                    SidecarCompat.l(this.f4756a, activity, (Configuration) obj);
                }
            };
            this.f8452d.put(activity, aVar);
            ((G.c) activity).l(aVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(Activity activity) {
        P.a aVar = (P.a) this.f8452d.get(activity);
        if (aVar == null) {
            return;
        }
        if (activity instanceof G.c) {
            ((G.c) activity).d(aVar);
        }
        this.f8452d.remove(activity);
    }

    public boolean n() {
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        Class<?> cls4;
        try {
            SidecarInterface sidecarInterface = this.f8449a;
            Method method = (sidecarInterface == null || (cls4 = sidecarInterface.getClass()) == null) ? null : cls4.getMethod("setSidecarCallback", SidecarInterface.SidecarCallback.class);
            Class<?> returnType = method != null ? method.getReturnType() : null;
            Class cls5 = Void.TYPE;
            if (!r.b(returnType, cls5)) {
                throw new NoSuchMethodException("Illegal return type for 'setSidecarCallback': " + returnType);
            }
            SidecarInterface sidecarInterface2 = this.f8449a;
            if (sidecarInterface2 != null) {
                sidecarInterface2.getDeviceState();
            }
            SidecarInterface sidecarInterface3 = this.f8449a;
            if (sidecarInterface3 != null) {
                sidecarInterface3.onDeviceStateListenersChanged(true);
            }
            SidecarInterface sidecarInterface4 = this.f8449a;
            Method method2 = (sidecarInterface4 == null || (cls3 = sidecarInterface4.getClass()) == null) ? null : cls3.getMethod("getWindowLayoutInfo", IBinder.class);
            Class<?> returnType2 = method2 != null ? method2.getReturnType() : null;
            if (!r.b(returnType2, SidecarWindowLayoutInfo.class)) {
                throw new NoSuchMethodException("Illegal return type for 'getWindowLayoutInfo': " + returnType2);
            }
            SidecarInterface sidecarInterface5 = this.f8449a;
            Method method3 = (sidecarInterface5 == null || (cls2 = sidecarInterface5.getClass()) == null) ? null : cls2.getMethod("onWindowLayoutChangeListenerAdded", IBinder.class);
            Class<?> returnType3 = method3 != null ? method3.getReturnType() : null;
            if (!r.b(returnType3, cls5)) {
                throw new NoSuchMethodException("Illegal return type for 'onWindowLayoutChangeListenerAdded': " + returnType3);
            }
            SidecarInterface sidecarInterface6 = this.f8449a;
            Method method4 = (sidecarInterface6 == null || (cls = sidecarInterface6.getClass()) == null) ? null : cls.getMethod("onWindowLayoutChangeListenerRemoved", IBinder.class);
            Class<?> returnType4 = method4 != null ? method4.getReturnType() : null;
            if (!r.b(returnType4, cls5)) {
                throw new NoSuchMethodException("Illegal return type for 'onWindowLayoutChangeListenerRemoved': " + returnType4);
            }
            SidecarDeviceState sidecarDeviceState = new SidecarDeviceState();
            try {
                sidecarDeviceState.posture = 3;
            } catch (NoSuchFieldError unused) {
                SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, 3);
                Object objInvoke = SidecarDeviceState.class.getMethod("getPosture", null).invoke(sidecarDeviceState, null);
                r.d(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                if (((Integer) objInvoke).intValue() != 3) {
                    throw new Exception("Invalid device posture getter/setter");
                }
            }
            SidecarDisplayFeature sidecarDisplayFeature = new SidecarDisplayFeature();
            Rect rect = sidecarDisplayFeature.getRect();
            r.e(rect, "displayFeature.rect");
            sidecarDisplayFeature.setRect(rect);
            sidecarDisplayFeature.getType();
            sidecarDisplayFeature.setType(1);
            SidecarWindowLayoutInfo sidecarWindowLayoutInfo = new SidecarWindowLayoutInfo();
            try {
                List list = sidecarWindowLayoutInfo.displayFeatures;
                return true;
            } catch (NoSuchFieldError unused2) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(sidecarDisplayFeature);
                SidecarWindowLayoutInfo.class.getMethod("setDisplayFeatures", List.class).invoke(sidecarWindowLayoutInfo, arrayList);
                Object objInvoke2 = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", null).invoke(sidecarWindowLayoutInfo, null);
                r.d(objInvoke2, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                if (r.b(arrayList, (List) objInvoke2)) {
                    return true;
                }
                throw new Exception("Invalid display feature getter/setter");
            }
        } catch (Throwable unused3) {
            return false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SidecarCompat(Context context) {
        this(f8448f.b(context), new U0.a(null, 1, null));
        r.f(context, "context");
    }
}
