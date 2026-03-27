package P4;

import K4.C0622c;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import java.util.Iterator;
import q5.AbstractC2569h;

/* JADX INFO: loaded from: classes2.dex */
public class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FlutterMutatorsStack f4351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f4352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C0622c f4357g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f4358h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalFocusChangeListener f4359i;

    /* JADX INFO: renamed from: P4.a$a, reason: collision with other inner class name */
    public class ViewTreeObserverOnGlobalFocusChangeListenerC0070a implements ViewTreeObserver.OnGlobalFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnFocusChangeListener f4360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f4361b;

        public ViewTreeObserverOnGlobalFocusChangeListenerC0070a(View.OnFocusChangeListener onFocusChangeListener, View view) {
            this.f4360a = onFocusChangeListener;
            this.f4361b = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public void onGlobalFocusChanged(View view, View view2) {
            View.OnFocusChangeListener onFocusChangeListener = this.f4360a;
            View view3 = this.f4361b;
            onFocusChangeListener.onFocusChange(view3, AbstractC2569h.d(view3));
        }
    }

    public a(Context context, float f7, C0622c c0622c) {
        super(context, null);
        this.f4352b = f7;
        this.f4357g = c0622c;
        this.f4358h = new Paint();
    }

    private Matrix getPlatformViewMatrix() {
        Matrix matrix = new Matrix(this.f4351a.getFinalMatrix());
        float f7 = this.f4352b;
        matrix.preScale(1.0f / f7, 1.0f / f7);
        matrix.postTranslate(-this.f4353c, -this.f4354d);
        return matrix;
    }

    public void a(FlutterMutatorsStack flutterMutatorsStack, int i7, int i8, int i9, int i10) {
        this.f4351a = flutterMutatorsStack;
        this.f4353c = i7;
        this.f4354d = i8;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i9, i10);
        layoutParams.leftMargin = i7;
        layoutParams.topMargin = i8;
        setLayoutParams(layoutParams);
        setWillNotDraw(false);
    }

    public void b() {
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive() || (onGlobalFocusChangeListener = this.f4359i) == null) {
            return;
        }
        this.f4359i = null;
        viewTreeObserver.removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(getPlatformViewMatrix());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.save();
        Iterator<Path> it = this.f4351a.getFinalClippingPaths().iterator();
        while (it.hasNext()) {
            Path path = new Path(it.next());
            path.offset(-this.f4353c, -this.f4354d);
            canvas.clipPath(path);
        }
        if (this.f4358h.getAlpha() != ((int) (this.f4351a.getFinalOpacity() * 255.0f))) {
            this.f4358h.setAlpha((int) (this.f4351a.getFinalOpacity() * 255.0f));
            setLayerType(2, this.f4358h);
        }
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f4357g == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i7 = this.f4353c;
            this.f4355e = i7;
            int i8 = this.f4354d;
            this.f4356f = i8;
            matrix.postTranslate(i7, i8);
        } else if (action != 2) {
            matrix.postTranslate(this.f4353c, this.f4354d);
        } else {
            matrix.postTranslate(this.f4355e, this.f4356f);
            this.f4355e = this.f4353c;
            this.f4356f = this.f4354d;
        }
        return this.f4357g.l(motionEvent, matrix);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getImportantForAccessibility() != 4) {
            return super.requestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }

    public void setOnDescendantFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        b();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.f4359i == null) {
            ViewTreeObserverOnGlobalFocusChangeListenerC0070a viewTreeObserverOnGlobalFocusChangeListenerC0070a = new ViewTreeObserverOnGlobalFocusChangeListenerC0070a(onFocusChangeListener, this);
            this.f4359i = viewTreeObserverOnGlobalFocusChangeListenerC0070a;
            viewTreeObserver.addOnGlobalFocusChangeListener(viewTreeObserverOnGlobalFocusChangeListenerC0070a);
        }
    }
}
