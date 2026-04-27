package androidx.window.layout.adapter.sidecar;

import I0.k;
import L0.j;
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
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes.dex */
public final class SidecarCompat implements androidx.window.layout.adapter.sidecar.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f12513f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SidecarInterface f12514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final O0.a f12515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f12516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f12517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f12518e;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/window/layout/adapter/sidecar/SidecarCompat$TranslatingCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "<init>", "(Landroidx/window/layout/adapter/sidecar/SidecarCompat;)V", "Landroidx/window/sidecar/SidecarDeviceState;", "newDeviceState", "Lo5/H;", "onDeviceStateChanged", "(Landroidx/window/sidecar/SidecarDeviceState;)V", "Landroid/os/IBinder;", "windowToken", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "newLayout", "onWindowLayoutChanged", "(Landroid/os/IBinder;Landroidx/window/sidecar/SidecarWindowLayoutInfo;)V", "window_release"}, k = 1, mv = {1, 9, 0})
    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {
        public TranslatingCallback() {
        }

        public void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
            SidecarInterface sidecarInterfaceI;
            AbstractC2304t.f(newDeviceState, "newDeviceState");
            Collection<Activity> collectionValues = SidecarCompat.this.f12516c.values();
            SidecarCompat sidecarCompat = SidecarCompat.this;
            for (Activity activity : collectionValues) {
                IBinder iBinderA = SidecarCompat.f12513f.a(activity);
                SidecarWindowLayoutInfo windowLayoutInfo = null;
                if (iBinderA != null && (sidecarInterfaceI = sidecarCompat.i()) != null) {
                    windowLayoutInfo = sidecarInterfaceI.getWindowLayoutInfo(iBinderA);
                }
                b bVar = sidecarCompat.f12518e;
                if (bVar != null) {
                    bVar.a(activity, sidecarCompat.f12515b.e(windowLayoutInfo, newDeviceState));
                }
            }
        }

        public void onWindowLayoutChanged(IBinder windowToken, SidecarWindowLayoutInfo newLayout) {
            SidecarDeviceState sidecarDeviceState;
            AbstractC2304t.f(windowToken, "windowToken");
            AbstractC2304t.f(newLayout, "newLayout");
            Activity activity = (Activity) SidecarCompat.this.f12516c.get(windowToken);
            if (activity == null) {
                Log.w("SidecarCompat", "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                return;
            }
            O0.a aVar = SidecarCompat.this.f12515b;
            SidecarInterface sidecarInterfaceI = SidecarCompat.this.i();
            if (sidecarInterfaceI == null || (sidecarDeviceState = sidecarInterfaceI.getDeviceState()) == null) {
                sidecarDeviceState = new SidecarDeviceState();
            }
            j jVarE = aVar.e(newLayout, sidecarDeviceState);
            b bVar = SidecarCompat.this.f12518e;
            if (bVar != null) {
                bVar.a(activity, jVarE);
            }
        }
    }

    public static final class a {
        public a() {
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
            AbstractC2304t.f(context, "context");
            return SidecarProvider.getSidecarImpl(context.getApplicationContext());
        }

        public final k c() {
            try {
                String apiVersion = SidecarProvider.getApiVersion();
                if (TextUtils.isEmpty(apiVersion)) {
                    return null;
                }
                return k.f4052f.b(apiVersion);
            } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
                return null;
            }
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public static final class b implements a.InterfaceC0202a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a.InterfaceC0202a f12520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ReentrantLock f12521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WeakHashMap f12522c;

        public b(a.InterfaceC0202a callbackInterface) {
            AbstractC2304t.f(callbackInterface, "callbackInterface");
            this.f12520a = callbackInterface;
            this.f12521b = new ReentrantLock();
            this.f12522c = new WeakHashMap();
        }

        @Override // androidx.window.layout.adapter.sidecar.a.InterfaceC0202a
        public void a(Activity activity, j newLayout) {
            AbstractC2304t.f(activity, "activity");
            AbstractC2304t.f(newLayout, "newLayout");
            ReentrantLock reentrantLock = this.f12521b;
            reentrantLock.lock();
            try {
                if (AbstractC2304t.b(newLayout, (j) this.f12522c.get(activity))) {
                    return;
                }
                reentrantLock.unlock();
                this.f12520a.a(activity, newLayout);
            } finally {
                reentrantLock.unlock();
            }
        }

        public final void b(Activity activity) {
            AbstractC2304t.f(activity, "activity");
            ReentrantLock reentrantLock = this.f12521b;
            reentrantLock.lock();
            try {
                this.f12522c.put(activity, null);
                C2470H c2470h = C2470H.f21956a;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public static final class c implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SidecarCompat f12523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference f12524b;

        public c(SidecarCompat sidecarCompat, Activity activity) {
            AbstractC2304t.f(sidecarCompat, "sidecarCompat");
            AbstractC2304t.f(activity, "activity");
            this.f12523a = sidecarCompat;
            this.f12524b = new WeakReference(activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            AbstractC2304t.f(view, "view");
            view.removeOnAttachStateChangeListener(this);
            Activity activity = (Activity) this.f12524b.get();
            IBinder iBinderA = SidecarCompat.f12513f.a(activity);
            if (activity == null || iBinderA == null) {
                return;
            }
            this.f12523a.k(iBinderA, activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            AbstractC2304t.f(view, "view");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SidecarCompat(Context context) {
        this(f12513f.b(context), new O0.a(null, 1, null));
        AbstractC2304t.f(context, "context");
    }

    public static final void m(SidecarCompat sidecarCompat, Activity activity, Configuration configuration) {
        b bVar = sidecarCompat.f12518e;
        if (bVar != null) {
            bVar.a(activity, sidecarCompat.j(activity));
        }
    }

    @Override // androidx.window.layout.adapter.sidecar.a
    public void a(a.InterfaceC0202a extensionCallback) {
        AbstractC2304t.f(extensionCallback, "extensionCallback");
        this.f12518e = new b(extensionCallback);
        SidecarInterface sidecarInterface = this.f12514a;
        if (sidecarInterface != null) {
            sidecarInterface.setSidecarCallback(new DistinctElementSidecarCallback(this.f12515b, new TranslatingCallback()));
        }
    }

    @Override // androidx.window.layout.adapter.sidecar.a
    public void b(Activity activity) {
        AbstractC2304t.f(activity, "activity");
        IBinder iBinderA = f12513f.a(activity);
        if (iBinderA != null) {
            k(iBinderA, activity);
        } else {
            activity.getWindow().getDecorView().addOnAttachStateChangeListener(new c(this, activity));
        }
    }

    @Override // androidx.window.layout.adapter.sidecar.a
    public void c(Activity activity) {
        SidecarInterface sidecarInterface;
        AbstractC2304t.f(activity, "activity");
        IBinder iBinderA = f12513f.a(activity);
        if (iBinderA == null) {
            return;
        }
        SidecarInterface sidecarInterface2 = this.f12514a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerRemoved(iBinderA);
        }
        n(activity);
        b bVar = this.f12518e;
        if (bVar != null) {
            bVar.b(activity);
        }
        boolean z7 = this.f12516c.size() == 1;
        this.f12516c.remove(iBinderA);
        if (!z7 || (sidecarInterface = this.f12514a) == null) {
            return;
        }
        sidecarInterface.onDeviceStateListenersChanged(true);
    }

    @Override // androidx.window.layout.adapter.sidecar.a
    public boolean d() {
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        Class<?> cls4;
        try {
            SidecarInterface sidecarInterface = this.f12514a;
            Method method = (sidecarInterface == null || (cls4 = sidecarInterface.getClass()) == null) ? null : cls4.getMethod("setSidecarCallback", SidecarInterface.SidecarCallback.class);
            Class<?> returnType = method != null ? method.getReturnType() : null;
            Class cls5 = Void.TYPE;
            if (!AbstractC2304t.b(returnType, cls5)) {
                throw new NoSuchMethodException("Illegal return type for 'setSidecarCallback': " + returnType);
            }
            SidecarInterface sidecarInterface2 = this.f12514a;
            if (sidecarInterface2 != null) {
                sidecarInterface2.getDeviceState();
            }
            SidecarInterface sidecarInterface3 = this.f12514a;
            if (sidecarInterface3 != null) {
                sidecarInterface3.onDeviceStateListenersChanged(true);
            }
            SidecarInterface sidecarInterface4 = this.f12514a;
            Method method2 = (sidecarInterface4 == null || (cls3 = sidecarInterface4.getClass()) == null) ? null : cls3.getMethod("getWindowLayoutInfo", IBinder.class);
            Class<?> returnType2 = method2 != null ? method2.getReturnType() : null;
            if (!AbstractC2304t.b(returnType2, SidecarWindowLayoutInfo.class)) {
                throw new NoSuchMethodException("Illegal return type for 'getWindowLayoutInfo': " + returnType2);
            }
            SidecarInterface sidecarInterface5 = this.f12514a;
            Method method3 = (sidecarInterface5 == null || (cls2 = sidecarInterface5.getClass()) == null) ? null : cls2.getMethod("onWindowLayoutChangeListenerAdded", IBinder.class);
            Class<?> returnType3 = method3 != null ? method3.getReturnType() : null;
            if (!AbstractC2304t.b(returnType3, cls5)) {
                throw new NoSuchMethodException("Illegal return type for 'onWindowLayoutChangeListenerAdded': " + returnType3);
            }
            SidecarInterface sidecarInterface6 = this.f12514a;
            Method method4 = (sidecarInterface6 == null || (cls = sidecarInterface6.getClass()) == null) ? null : cls.getMethod("onWindowLayoutChangeListenerRemoved", IBinder.class);
            Class<?> returnType4 = method4 != null ? method4.getReturnType() : null;
            if (!AbstractC2304t.b(returnType4, cls5)) {
                throw new NoSuchMethodException("Illegal return type for 'onWindowLayoutChangeListenerRemoved': " + returnType4);
            }
            SidecarDeviceState sidecarDeviceState = new SidecarDeviceState();
            try {
                sidecarDeviceState.posture = 3;
            } catch (NoSuchFieldError unused) {
                SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, 3);
                Object objInvoke = SidecarDeviceState.class.getMethod("getPosture", null).invoke(sidecarDeviceState, null);
                AbstractC2304t.d(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                if (((Integer) objInvoke).intValue() != 3) {
                    throw new Exception("Invalid device posture getter/setter");
                }
            }
            SidecarDisplayFeature sidecarDisplayFeature = new SidecarDisplayFeature();
            Rect rect = sidecarDisplayFeature.getRect();
            AbstractC2304t.e(rect, "getRect(...)");
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
                AbstractC2304t.d(objInvoke2, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                if (AbstractC2304t.b(arrayList, (List) objInvoke2)) {
                    return true;
                }
                throw new Exception("Invalid display feature getter/setter");
            }
        } catch (Throwable unused3) {
            return false;
        }
    }

    public final SidecarInterface i() {
        return this.f12514a;
    }

    public final j j(Activity activity) {
        SidecarDeviceState sidecarDeviceState;
        AbstractC2304t.f(activity, "activity");
        IBinder iBinderA = f12513f.a(activity);
        if (iBinderA == null) {
            return new j(AbstractC2595q.i());
        }
        SidecarInterface sidecarInterface = this.f12514a;
        SidecarWindowLayoutInfo windowLayoutInfo = sidecarInterface != null ? sidecarInterface.getWindowLayoutInfo(iBinderA) : null;
        O0.a aVar = this.f12515b;
        SidecarInterface sidecarInterface2 = this.f12514a;
        if (sidecarInterface2 == null || (sidecarDeviceState = sidecarInterface2.getDeviceState()) == null) {
            sidecarDeviceState = new SidecarDeviceState();
        }
        return aVar.e(windowLayoutInfo, sidecarDeviceState);
    }

    public final void k(IBinder windowToken, Activity activity) {
        SidecarInterface sidecarInterface;
        AbstractC2304t.f(windowToken, "windowToken");
        AbstractC2304t.f(activity, "activity");
        this.f12516c.put(windowToken, activity);
        SidecarInterface sidecarInterface2 = this.f12514a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(windowToken);
        }
        if (this.f12516c.size() == 1 && (sidecarInterface = this.f12514a) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        b bVar = this.f12518e;
        if (bVar != null) {
            bVar.a(activity, j(activity));
        }
        l(activity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l(final Activity activity) {
        if (this.f12517d.get(activity) == null && (activity instanceof I.c)) {
            S.a aVar = new S.a() { // from class: O0.b
                @Override // S.a
                public final void accept(Object obj) {
                    SidecarCompat.m(this.f5893a, activity, (Configuration) obj);
                }
            };
            this.f12517d.put(activity, aVar);
            ((I.c) activity).addOnConfigurationChangedListener(aVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n(Activity activity) {
        S.a aVar = (S.a) this.f12517d.get(activity);
        if (aVar == null) {
            return;
        }
        if (activity instanceof I.c) {
            ((I.c) activity).removeOnConfigurationChangedListener(aVar);
        }
        this.f12517d.remove(activity);
    }

    public SidecarCompat(SidecarInterface sidecarInterface, O0.a sidecarAdapter) {
        AbstractC2304t.f(sidecarAdapter, "sidecarAdapter");
        this.f12514a = sidecarInterface;
        this.f12515b = sidecarAdapter;
        this.f12516c = new LinkedHashMap();
        this.f12517d = new LinkedHashMap();
    }
}
