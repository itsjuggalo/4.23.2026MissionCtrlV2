package io.flutter.plugin.platform;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import io.flutter.plugin.platform.SingleViewPresentation;

/* JADX INFO: loaded from: classes2.dex */
public class b0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static VirtualDisplay.Callback f16741i = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SingleViewPresentation f16742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f16743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C2004a f16744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f16745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f16746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final InterfaceC2018o f16747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View.OnFocusChangeListener f16748g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public VirtualDisplay f16749h;

    public class a extends VirtualDisplay.Callback {
        @Override // android.hardware.display.VirtualDisplay.Callback
        public void onPaused() {
        }

        @Override // android.hardware.display.VirtualDisplay.Callback
        public void onResumed() {
        }
    }

    public class b implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f16750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f16751b;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                bVar.f16750a.postDelayed(bVar.f16751b, 128L);
            }
        }

        public b(View view, Runnable runnable) {
            this.f16750a = view;
            this.f16751b = runnable;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            c.a(this.f16750a, new a());
            this.f16750a.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public static class c implements ViewTreeObserver.OnDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f16754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Runnable f16755b;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f16754a.getViewTreeObserver().removeOnDrawListener(c.this);
            }
        }

        public c(View view, Runnable runnable) {
            this.f16754a = view;
            this.f16755b = runnable;
        }

        public static void a(View view, Runnable runnable) {
            view.getViewTreeObserver().addOnDrawListener(new c(view, runnable));
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.f16755b;
            if (runnable == null) {
                return;
            }
            runnable.run();
            this.f16755b = null;
            this.f16754a.post(new a());
        }
    }

    public b0(Context context, C2004a c2004a, VirtualDisplay virtualDisplay, InterfaceC2014k interfaceC2014k, InterfaceC2018o interfaceC2018o, View.OnFocusChangeListener onFocusChangeListener, int i7, Object obj) {
        this.f16743b = context;
        this.f16744c = c2004a;
        this.f16747f = interfaceC2018o;
        this.f16748g = onFocusChangeListener;
        this.f16746e = i7;
        this.f16749h = virtualDisplay;
        this.f16745d = context.getResources().getDisplayMetrics().densityDpi;
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(context, this.f16749h.getDisplay(), interfaceC2014k, c2004a, i7, onFocusChangeListener);
        this.f16742a = singleViewPresentation;
        singleViewPresentation.show();
    }

    public static b0 b(Context context, C2004a c2004a, InterfaceC2014k interfaceC2014k, InterfaceC2018o interfaceC2018o, int i7, int i8, int i9, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        if (i7 == 0 || i8 == 0) {
            return null;
        }
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        interfaceC2018o.a(i7, i8);
        VirtualDisplay virtualDisplayCreateVirtualDisplay = displayManager.createVirtualDisplay("flutter-vd#" + i9, i7, i8, displayMetrics.densityDpi, interfaceC2018o.getSurface(), 0, f16741i, null);
        if (virtualDisplayCreateVirtualDisplay == null) {
            return null;
        }
        return new b0(context, c2004a, virtualDisplayCreateVirtualDisplay, interfaceC2014k, interfaceC2018o, onFocusChangeListener, i9, obj);
    }

    public void a() {
        this.f16749h.setSurface(null);
    }

    public void c(MotionEvent motionEvent) {
        SingleViewPresentation singleViewPresentation = this.f16742a;
        if (singleViewPresentation == null) {
            return;
        }
        singleViewPresentation.dispatchTouchEvent(motionEvent);
    }

    public void d() {
        this.f16742a.cancel();
        this.f16742a.detachState();
        this.f16749h.release();
        this.f16747f.release();
    }

    public int e() {
        InterfaceC2018o interfaceC2018o = this.f16747f;
        if (interfaceC2018o != null) {
            return interfaceC2018o.getHeight();
        }
        return 0;
    }

    public int f() {
        InterfaceC2018o interfaceC2018o = this.f16747f;
        if (interfaceC2018o != null) {
            return interfaceC2018o.getWidth();
        }
        return 0;
    }

    public View g() {
        SingleViewPresentation singleViewPresentation = this.f16742a;
        if (singleViewPresentation == null) {
            return null;
        }
        return singleViewPresentation.getView().getView();
    }

    public void h() {
        SingleViewPresentation singleViewPresentation = this.f16742a;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.f16742a.getView().c();
    }

    public void i() {
        SingleViewPresentation singleViewPresentation = this.f16742a;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.f16742a.getView().d();
    }

    public void j() {
        int iF = f();
        int iE = e();
        boolean zIsFocused = g().isFocused();
        SingleViewPresentation.d dVarDetachState = this.f16742a.detachState();
        this.f16749h.setSurface(null);
        this.f16749h.release();
        this.f16749h = ((DisplayManager) this.f16743b.getSystemService("display")).createVirtualDisplay("flutter-vd#" + this.f16746e, iF, iE, this.f16745d, this.f16747f.getSurface(), 0, f16741i, null);
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(this.f16743b, this.f16749h.getDisplay(), this.f16744c, dVarDetachState, this.f16748g, zIsFocused);
        singleViewPresentation.show();
        this.f16742a.cancel();
        this.f16742a = singleViewPresentation;
    }

    public void k(int i7, int i8, Runnable runnable) {
        if (i7 == f() && i8 == e()) {
            g().postDelayed(runnable, 0L);
            return;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            l(g(), i7, i8, runnable);
            return;
        }
        boolean zIsFocused = g().isFocused();
        SingleViewPresentation.d dVarDetachState = this.f16742a.detachState();
        this.f16749h.setSurface(null);
        this.f16749h.release();
        DisplayManager displayManager = (DisplayManager) this.f16743b.getSystemService("display");
        this.f16747f.a(i7, i8);
        this.f16749h = displayManager.createVirtualDisplay("flutter-vd#" + this.f16746e, i7, i8, this.f16745d, this.f16747f.getSurface(), 0, f16741i, null);
        View viewG = g();
        viewG.addOnAttachStateChangeListener(new b(viewG, runnable));
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(this.f16743b, this.f16749h.getDisplay(), this.f16744c, dVarDetachState, this.f16748g, zIsFocused);
        singleViewPresentation.show();
        this.f16742a.cancel();
        this.f16742a = singleViewPresentation;
    }

    public final void l(View view, int i7, int i8, Runnable runnable) {
        this.f16747f.a(i7, i8);
        this.f16749h.resize(i7, i8, this.f16745d);
        this.f16749h.setSurface(this.f16747f.getSurface());
        view.postDelayed(runnable, 0L);
    }
}
