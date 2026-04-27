package com.yalantis.ucrop.view;

import E4.f;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

/* JADX INFO: loaded from: classes2.dex */
public class GestureCropImageView extends F4.a {

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public ScaleGestureDetector f12989E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public f f12990F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public GestureDetector f12991G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public float f12992H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public float f12993I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f12994J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public boolean f12995K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public boolean f12996L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public int f12997M;

    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            GestureCropImageView gestureCropImageView = GestureCropImageView.this;
            gestureCropImageView.v(gestureCropImageView.getDoubleTapTargetScale(), motionEvent.getX(), motionEvent.getY(), 200L);
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f7, float f8) {
            GestureCropImageView.this.j(-f7, -f8);
            return true;
        }
    }

    public class c extends f.b {
        public c() {
        }

        @Override // E4.f.a
        public boolean a(f fVar) {
            GestureCropImageView.this.h(fVar.c(), GestureCropImageView.this.f12992H, GestureCropImageView.this.f12993I);
            return true;
        }
    }

    public class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public d() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            GestureCropImageView.this.i(scaleGestureDetector.getScaleFactor(), GestureCropImageView.this.f12992H, GestureCropImageView.this.f12993I);
            return true;
        }
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // F4.b
    public void f() {
        super.f();
        z();
    }

    public int getDoubleTapScaleSteps() {
        return this.f12997M;
    }

    public float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) Math.pow(getMaxScale() / getMinScale(), 1.0f / this.f12997M));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            p();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.f12992H = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
            this.f12993I = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        }
        if (this.f12996L) {
            this.f12991G.onTouchEvent(motionEvent);
        }
        if (this.f12995K) {
            this.f12989E.onTouchEvent(motionEvent);
        }
        if (this.f12994J) {
            this.f12990F.d(motionEvent);
        }
        if ((motionEvent.getAction() & 255) == 1) {
            t();
        }
        return true;
    }

    public void setDoubleTapScaleSteps(int i7) {
        this.f12997M = i7;
    }

    public void setGestureEnabled(boolean z7) {
        this.f12996L = z7;
    }

    public void setRotateEnabled(boolean z7) {
        this.f12994J = z7;
    }

    public void setScaleEnabled(boolean z7) {
        this.f12995K = z7;
    }

    public final void z() {
        this.f12991G = new GestureDetector(getContext(), new b(), null, true);
        this.f12989E = new ScaleGestureDetector(getContext(), new d());
        this.f12990F = new f(new c());
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f12994J = true;
        this.f12995K = true;
        this.f12996L = true;
        this.f12997M = 5;
    }
}
