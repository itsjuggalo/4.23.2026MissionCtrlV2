package com.yalantis.ucrop.view;

import E.l;
import J3.b;
import K3.c;
import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

/* JADX INFO: loaded from: classes.dex */
public class GestureCropImageView extends c {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public ScaleGestureDetector f5827B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public b f5828C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public GestureDetector f5829D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public float f5830E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public float f5831F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public boolean f5832G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public boolean f5833H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public boolean f5834I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f5835J;

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5832G = true;
        this.f5833H = true;
        this.f5834I = true;
        this.f5835J = 5;
    }

    public int getDoubleTapScaleSteps() {
        return this.f5835J;
    }

    public float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) Math.pow(getMaxScale() / getMinScale(), 1.0f / this.f5835J));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            removeCallbacks(this.f997w);
            removeCallbacks(this.f998x);
        }
        if (motionEvent.getPointerCount() > 1) {
            this.f5830E = (motionEvent.getX(1) + motionEvent.getX(0)) / 2.0f;
            this.f5831F = (motionEvent.getY(1) + motionEvent.getY(0)) / 2.0f;
        }
        if (this.f5834I) {
            this.f5829D.onTouchEvent(motionEvent);
        }
        if (this.f5833H) {
            this.f5827B.onTouchEvent(motionEvent);
        }
        if (this.f5832G) {
            b bVar = this.f5828C;
            bVar.getClass();
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                bVar.f786c = motionEvent.getX();
                bVar.f787d = motionEvent.getY();
                bVar.e = motionEvent.findPointerIndex(motionEvent.getPointerId(0));
                bVar.f789g = 0.0f;
                bVar.f790h = true;
            } else if (actionMasked == 1) {
                bVar.e = -1;
            } else if (actionMasked != 2) {
                if (actionMasked == 5) {
                    bVar.f784a = motionEvent.getX();
                    bVar.f785b = motionEvent.getY();
                    bVar.f788f = motionEvent.findPointerIndex(motionEvent.getPointerId(motionEvent.getActionIndex()));
                    bVar.f789g = 0.0f;
                    bVar.f790h = true;
                } else if (actionMasked == 6) {
                    bVar.f788f = -1;
                }
            } else if (bVar.e != -1 && bVar.f788f != -1 && motionEvent.getPointerCount() > bVar.f788f) {
                float x6 = motionEvent.getX(bVar.e);
                float y = motionEvent.getY(bVar.e);
                float x7 = motionEvent.getX(bVar.f788f);
                float y6 = motionEvent.getY(bVar.f788f);
                if (bVar.f790h) {
                    bVar.f789g = 0.0f;
                    bVar.f790h = false;
                } else {
                    float f6 = bVar.f784a;
                    float degrees = (((float) Math.toDegrees((float) Math.atan2(y6 - y, x7 - x6))) % 360.0f) - (((float) Math.toDegrees((float) Math.atan2(bVar.f785b - bVar.f787d, f6 - bVar.f786c))) % 360.0f);
                    bVar.f789g = degrees;
                    if (degrees < -180.0f) {
                        bVar.f789g = degrees + 360.0f;
                    } else if (degrees > 180.0f) {
                        bVar.f789g = degrees - 360.0f;
                    }
                }
                l lVar = bVar.i;
                float f7 = bVar.f789g;
                GestureCropImageView gestureCropImageView = (GestureCropImageView) lVar.f365b;
                float f8 = gestureCropImageView.f5830E;
                float f9 = gestureCropImageView.f5831F;
                if (f7 != 0.0f) {
                    Matrix matrix = gestureCropImageView.f1004k;
                    matrix.postRotate(f7, f8, f9);
                    gestureCropImageView.setImageMatrix(matrix);
                }
                bVar.f784a = x7;
                bVar.f785b = y6;
                bVar.f786c = x6;
                bVar.f787d = y;
            }
        }
        if ((motionEvent.getAction() & 255) == 1) {
            setImageToWrapCropBounds(true);
        }
        return true;
    }

    public void setDoubleTapScaleSteps(int i) {
        this.f5835J = i;
    }

    public void setGestureEnabled(boolean z6) {
        this.f5834I = z6;
    }

    public void setRotateEnabled(boolean z6) {
        this.f5832G = z6;
    }

    public void setScaleEnabled(boolean z6) {
        this.f5833H = z6;
    }
}
