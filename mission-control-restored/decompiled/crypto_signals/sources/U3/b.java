package U3;

import P3.C0226a;
import android.app.Activity;
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

/* JADX INFO: loaded from: classes.dex */
public final class b extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FlutterMutatorsStack f3173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f3174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3176d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3177f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C0226a f3178k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Paint f3179l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f3180m;

    public b(Activity activity, float f6, C0226a c0226a) {
        super(activity, null);
        this.f3174b = f6;
        this.f3178k = c0226a;
        this.f3179l = new Paint();
    }

    private Matrix getPlatformViewMatrix() {
        Matrix matrix = new Matrix(this.f3173a.getFinalMatrix());
        float f6 = this.f3174b;
        matrix.preScale(1.0f / f6, 1.0f / f6);
        matrix.postTranslate(-this.f3175c, -this.f3176d);
        return matrix;
    }

    public final void a() {
        a aVar;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive() || (aVar = this.f3180m) == null) {
            return;
        }
        this.f3180m = null;
        viewTreeObserver.removeOnGlobalFocusChangeListener(aVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(getPlatformViewMatrix());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        canvas.save();
        Iterator<Path> it = this.f3173a.getFinalClippingPaths().iterator();
        while (it.hasNext()) {
            Path path = new Path(it.next());
            path.offset(-this.f3175c, -this.f3176d);
            canvas.clipPath(path);
        }
        int finalOpacity = (int) (this.f3173a.getFinalOpacity() * 255.0f);
        Paint paint = this.f3179l;
        if (paint.getAlpha() != finalOpacity) {
            paint.setAlpha((int) (this.f3173a.getFinalOpacity() * 255.0f));
            setLayerType(2, paint);
        }
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C0226a c0226a = this.f3178k;
        if (c0226a == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i = this.f3175c;
            this.e = i;
            int i6 = this.f3176d;
            this.f3177f = i6;
            matrix.postTranslate(i, i6);
        } else if (action != 2) {
            matrix.postTranslate(this.f3175c, this.f3176d);
        } else {
            matrix.postTranslate(this.e, this.f3177f);
            this.e = this.f3175c;
            this.f3177f = this.f3176d;
        }
        c0226a.d(motionEvent, matrix);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getImportantForAccessibility() != 4) {
            return super.requestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }

    public void setOnDescendantFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        a();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.f3180m == null) {
            a aVar = new a(onFocusChangeListener, this);
            this.f3180m = aVar;
            viewTreeObserver.addOnGlobalFocusChangeListener(aVar);
        }
    }
}
