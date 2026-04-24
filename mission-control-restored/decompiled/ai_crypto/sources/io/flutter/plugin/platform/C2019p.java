package io.flutter.plugin.platform;

import K4.C0622c;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import q5.AbstractC2569h;

/* JADX INFO: renamed from: io.flutter.plugin.platform.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2019p extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C0622c f16778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InterfaceC2018o f16779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalFocusChangeListener f16780g;

    /* JADX INFO: renamed from: io.flutter.plugin.platform.p$a */
    public class a implements ViewTreeObserver.OnGlobalFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnFocusChangeListener f16781a;

        public a(View.OnFocusChangeListener onFocusChangeListener) {
            this.f16781a = onFocusChangeListener;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public void onGlobalFocusChanged(View view, View view2) {
            View.OnFocusChangeListener onFocusChangeListener = this.f16781a;
            C2019p c2019p = C2019p.this;
            onFocusChangeListener.onFocusChange(c2019p, AbstractC2569h.d(c2019p));
        }
    }

    public C2019p(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public void a() {
        InterfaceC2018o interfaceC2018o = this.f16779f;
        if (interfaceC2018o != null) {
            interfaceC2018o.release();
            this.f16779f = null;
        }
    }

    public void b(int i7, int i8) {
        InterfaceC2018o interfaceC2018o = this.f16779f;
        if (interfaceC2018o != null) {
            interfaceC2018o.a(i7, i8);
        }
    }

    public void c() {
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive() || (onGlobalFocusChangeListener = this.f16780g) == null) {
            return;
        }
        this.f16780g = null;
        viewTreeObserver.removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        InterfaceC2018o interfaceC2018o = this.f16779f;
        if (interfaceC2018o == null) {
            super.draw(canvas);
            J4.b.b("PlatformViewWrapper", "Platform view cannot be composed without a RenderTarget.");
            return;
        }
        Surface surface = interfaceC2018o.getSurface();
        if (!surface.isValid()) {
            J4.b.b("PlatformViewWrapper", "Platform view cannot be composed without a valid RenderTarget surface.");
            return;
        }
        Canvas canvasLockHardwareCanvas = surface.lockHardwareCanvas();
        if (canvasLockHardwareCanvas == null) {
            invalidate();
            return;
        }
        try {
            canvasLockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.draw(canvasLockHardwareCanvas);
        } finally {
            this.f16779f.scheduleFrame();
            surface.unlockCanvasAndPost(canvasLockHardwareCanvas);
        }
    }

    public ViewTreeObserver.OnGlobalFocusChangeListener getActiveFocusListener() {
        return this.f16780g;
    }

    public int getRenderTargetHeight() {
        InterfaceC2018o interfaceC2018o = this.f16779f;
        if (interfaceC2018o != null) {
            return interfaceC2018o.getHeight();
        }
        return 0;
    }

    public int getRenderTargetWidth() {
        InterfaceC2018o interfaceC2018o = this.f16779f;
        if (interfaceC2018o != null) {
            return interfaceC2018o.getWidth();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        invalidate();
        return super.invalidateChildInParent(iArr, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(View view, View view2) {
        super.onDescendantInvalidated(view, view2);
        invalidate();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f16778e == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i7 = this.f16776c;
            this.f16774a = i7;
            int i8 = this.f16777d;
            this.f16775b = i8;
            matrix.postTranslate(i7, i8);
        } else if (action != 2) {
            matrix.postTranslate(this.f16776c, this.f16777d);
        } else {
            matrix.postTranslate(this.f16774a, this.f16775b);
            this.f16774a = this.f16776c;
            this.f16775b = this.f16777d;
        }
        return this.f16778e.l(motionEvent, matrix);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getImportantForAccessibility() != 4) {
            return super.requestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }

    public void setLayoutParams(FrameLayout.LayoutParams layoutParams) {
        super.setLayoutParams((ViewGroup.LayoutParams) layoutParams);
        this.f16776c = layoutParams.leftMargin;
        this.f16777d = layoutParams.topMargin;
    }

    public void setOnDescendantFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        c();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.f16780g == null) {
            a aVar = new a(onFocusChangeListener);
            this.f16780g = aVar;
            viewTreeObserver.addOnGlobalFocusChangeListener(aVar);
        }
    }

    public void setTouchProcessor(C0622c c0622c) {
        this.f16778e = c0622c;
    }

    public C2019p(Context context, InterfaceC2018o interfaceC2018o) {
        this(context);
        this.f16779f = interfaceC2018o;
        Surface surface = interfaceC2018o.getSurface();
        if (surface == null || FlutterRenderer.f16547j) {
            return;
        }
        Canvas canvasLockHardwareCanvas = surface.lockHardwareCanvas();
        try {
            canvasLockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        } finally {
            surface.unlockCanvasAndPost(canvasLockHardwareCanvas);
        }
    }
}
