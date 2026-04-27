package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.support.v4.media.session.b;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;
import o2.AbstractC2300a;

/* JADX INFO: loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f11257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewPropertyAnimator f11261e;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f11261e = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.f11257a = new LinkedHashSet();
        this.f11258b = 0;
        this.f11259c = 2;
        this.f11260d = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i7, int i8) {
        return i7 == 2;
    }

    public final void F(View view, int i7, long j7, TimeInterpolator timeInterpolator) {
        this.f11261e = view.animate().translationY(i7).setInterpolator(timeInterpolator).setDuration(j7).setListener(new a());
    }

    public boolean G() {
        return this.f11259c == 1;
    }

    public boolean H() {
        return this.f11259c == 2;
    }

    public void I(View view) {
        J(view, true);
    }

    public void J(View view, boolean z7) {
        if (G()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f11261e;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        M(view, 1);
        int i7 = this.f11258b + this.f11260d;
        if (z7) {
            F(view, i7, 175L, AbstractC2300a.f20021c);
        } else {
            view.setTranslationY(i7);
        }
    }

    public void K(View view) {
        L(view, true);
    }

    public void L(View view, boolean z7) {
        if (H()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f11261e;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        M(view, 2);
        if (z7) {
            F(view, 0, 225L, AbstractC2300a.f20022d);
        } else {
            view.setTranslationY(0);
        }
    }

    public final void M(View view, int i7) {
        this.f11259c = i7;
        Iterator it = this.f11257a.iterator();
        if (it.hasNext()) {
            b.a(it.next());
            throw null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i7) {
        this.f11258b = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        return super.l(coordinatorLayout, view, i7);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void t(CoordinatorLayout coordinatorLayout, View view, View view2, int i7, int i8, int i9, int i10, int i11, int[] iArr) {
        if (i8 > 0) {
            I(view);
        } else if (i8 < 0) {
            K(view);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11257a = new LinkedHashSet();
        this.f11258b = 0;
        this.f11259c = 2;
        this.f11260d = 0;
    }
}
