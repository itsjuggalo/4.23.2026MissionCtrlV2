package com.google.android.material.snackbar;

import C2.g;
import C2.k;
import Q.N;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import n2.AbstractC2252a;
import n2.j;
import t2.AbstractC2655b;
import y2.l;
import z2.AbstractC2881c;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseTransientBottomBar {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f11644b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f11645c = {AbstractC2252a.f19118v};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f11646d = BaseTransientBottomBar.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f11643a = new Handler(Looper.getMainLooper(), new a());

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final b f11647j = new b(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean E(View view) {
            return this.f11647j.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f11647j.b(coordinatorLayout, view, motionEvent);
            return super.k(coordinatorLayout, view, motionEvent);
        }
    }

    public class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i7 = message.what;
            if (i7 == 0) {
                android.support.v4.media.session.b.a(message.obj);
                throw null;
            }
            if (i7 != 1) {
                return false;
            }
            android.support.v4.media.session.b.a(message.obj);
            throw null;
        }
    }

    public static class b {
        public b(SwipeDismissBehavior swipeDismissBehavior) {
            swipeDismissBehavior.K(0.1f);
            swipeDismissBehavior.J(0.6f);
            swipeDismissBehavior.L(0);
        }

        public boolean a(View view) {
            return view instanceof c;
        }

        public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.z(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.a.b().e(null);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.a.b().f(null);
            }
        }
    }

    public static class c extends FrameLayout {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final View.OnTouchListener f11648k = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public k f11649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f11650b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f11651c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f11652d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f11653e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f11654f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ColorStateList f11655g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PorterDuff.Mode f11656h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Rect f11657i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f11658j;

        public class a implements View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public c(Context context, AttributeSet attributeSet) {
            super(E2.a.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, j.f19339L3);
            if (typedArrayObtainStyledAttributes.hasValue(j.f19388S3)) {
                N.t0(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(j.f19388S3, 0));
            }
            this.f11650b = typedArrayObtainStyledAttributes.getInt(j.f19360O3, 0);
            if (typedArrayObtainStyledAttributes.hasValue(j.f19402U3) || typedArrayObtainStyledAttributes.hasValue(j.f19409V3)) {
                this.f11649a = k.e(context2, attributeSet, 0, 0).m();
            }
            this.f11651c = typedArrayObtainStyledAttributes.getFloat(j.f19367P3, 1.0f);
            setBackgroundTintList(AbstractC2881c.a(context2, typedArrayObtainStyledAttributes, j.f19374Q3));
            setBackgroundTintMode(l.f(typedArrayObtainStyledAttributes.getInt(j.f19381R3, -1), PorterDuff.Mode.SRC_IN));
            this.f11652d = typedArrayObtainStyledAttributes.getFloat(j.f19353N3, 1.0f);
            this.f11653e = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.f19346M3, -1);
            this.f11654f = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.f19395T3, -1);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(f11648k);
            setFocusable(true);
            if (getBackground() == null) {
                N.p0(this, a());
            }
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar baseTransientBottomBar) {
        }

        public final Drawable a() {
            int i7 = AbstractC2655b.i(this, AbstractC2252a.f19103g, AbstractC2252a.f19100d, getBackgroundOverlayColorAlpha());
            k kVar = this.f11649a;
            Drawable drawableD = kVar != null ? BaseTransientBottomBar.d(i7, kVar) : BaseTransientBottomBar.c(i7, getResources());
            if (this.f11655g == null) {
                return J.a.l(drawableD);
            }
            Drawable drawableL = J.a.l(drawableD);
            J.a.i(drawableL, this.f11655g);
            return drawableL;
        }

        public final void b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f11657i = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        public float getActionTextColorAlpha() {
            return this.f11652d;
        }

        public int getAnimationMode() {
            return this.f11650b;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.f11651c;
        }

        public int getMaxInlineActionWidth() {
            return this.f11654f;
        }

        public int getMaxWidth() {
            return this.f11653e;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            N.i0(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
            super.onLayout(z7, i7, i8, i9, i10);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i7, int i8) {
            super.onMeasure(i7, i8);
            if (this.f11653e > 0) {
                int measuredWidth = getMeasuredWidth();
                int i9 = this.f11653e;
                if (measuredWidth > i9) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i9, 1073741824), i8);
                }
            }
        }

        public void setAnimationMode(int i7) {
            this.f11650b = i7;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.f11655g != null) {
                drawable = J.a.l(drawable.mutate());
                J.a.i(drawable, this.f11655g);
                J.a.j(drawable, this.f11656h);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f11655g = colorStateList;
            if (getBackground() != null) {
                Drawable drawableL = J.a.l(getBackground().mutate());
                J.a.i(drawableL, colorStateList);
                J.a.j(drawableL, this.f11656h);
                if (drawableL != getBackground()) {
                    super.setBackgroundDrawable(drawableL);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f11656h = mode;
            if (getBackground() != null) {
                Drawable drawableL = J.a.l(getBackground().mutate());
                J.a.j(drawableL, mode);
                if (drawableL != getBackground()) {
                    super.setBackgroundDrawable(drawableL);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (this.f11658j || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            b((ViewGroup.MarginLayoutParams) layoutParams);
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f11648k);
            super.setOnClickListener(onClickListener);
        }
    }

    public static GradientDrawable c(int i7, Resources resources) {
        float dimension = resources.getDimension(n2.c.f19137K);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(i7);
        return gradientDrawable;
    }

    public static g d(int i7, k kVar) {
        g gVar = new g(kVar);
        gVar.U(ColorStateList.valueOf(i7));
        return gVar;
    }
}
