package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: androidx.fragment.app.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0835x extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f7609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f7610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f7611c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f7612e;

    /* JADX INFO: renamed from: androidx.fragment.app.x$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7613a = new a();

        public final WindowInsets a(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, View v4, WindowInsets insets) {
            kotlin.jvm.internal.r.f(onApplyWindowInsetsListener, "onApplyWindowInsetsListener");
            kotlin.jvm.internal.r.f(v4, "v");
            kotlin.jvm.internal.r.f(insets, "insets");
            WindowInsets windowInsetsOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(v4, insets);
            kotlin.jvm.internal.r.e(windowInsetsOnApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            return windowInsetsOnApplyWindowInsets;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0835x(Context context, AttributeSet attrs, I fm) {
        String str;
        super(context, attrs);
        kotlin.jvm.internal.r.f(context, "context");
        kotlin.jvm.internal.r.f(attrs, "attrs");
        kotlin.jvm.internal.r.f(fm, "fm");
        this.f7609a = new ArrayList();
        this.f7610b = new ArrayList();
        this.f7612e = true;
        String classAttribute = attrs.getClassAttribute();
        int[] FragmentContainerView = X.c.f5526e;
        kotlin.jvm.internal.r.e(FragmentContainerView, "FragmentContainerView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, FragmentContainerView, 0, 0);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(X.c.f5527f) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(X.c.f5528g);
        typedArrayObtainStyledAttributes.recycle();
        int id = getId();
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pI0 = fm.i0(id);
        if (classAttribute != null && abstractComponentCallbacksC0828pI0 == null) {
            if (id == -1) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pA = fm.u0().a(context.getClassLoader(), classAttribute);
            kotlin.jvm.internal.r.e(abstractComponentCallbacksC0828pA, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            abstractComponentCallbacksC0828pA.mFragmentId = id;
            abstractComponentCallbacksC0828pA.mContainerId = id;
            abstractComponentCallbacksC0828pA.mTag = string;
            abstractComponentCallbacksC0828pA.mFragmentManager = fm;
            abstractComponentCallbacksC0828pA.mHost = fm.w0();
            abstractComponentCallbacksC0828pA.onInflate(context, attrs, (Bundle) null);
            fm.o().m(true).c(this, abstractComponentCallbacksC0828pA, string).i();
        }
        fm.W0(this);
    }

    public final void a(View view) {
        if (this.f7610b.contains(view)) {
            this.f7609a.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int i4, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.r.f(child, "child");
        if (I.D0(child) != null) {
            super.addView(child, i4, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + child + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        H.L lA;
        kotlin.jvm.internal.r.f(insets, "insets");
        H.L lN = H.L.n(insets);
        kotlin.jvm.internal.r.e(lN, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f7611c;
        if (onApplyWindowInsetsListener != null) {
            a aVar = a.f7613a;
            kotlin.jvm.internal.r.c(onApplyWindowInsetsListener);
            lA = H.L.n(aVar.a(onApplyWindowInsetsListener, this, insets));
        } else {
            lA = H.E.A(this, lN);
        }
        kotlin.jvm.internal.r.e(lA, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!lA.h()) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                H.E.b(getChildAt(i4), lA);
            }
        }
        return insets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        kotlin.jvm.internal.r.f(canvas, "canvas");
        if (this.f7612e) {
            Iterator it = this.f7609a.iterator();
            while (it.hasNext()) {
                super.drawChild(canvas, (View) it.next(), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View child, long j4) {
        kotlin.jvm.internal.r.f(canvas, "canvas");
        kotlin.jvm.internal.r.f(child, "child");
        if (this.f7612e && !this.f7609a.isEmpty() && this.f7609a.contains(child)) {
            return false;
        }
        return super.drawChild(canvas, child, j4);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        kotlin.jvm.internal.r.f(view, "view");
        this.f7610b.remove(view);
        if (this.f7609a.remove(view)) {
            this.f7612e = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends AbstractComponentCallbacksC0828p> F getFragment() {
        return (F) I.l0(this).i0(getId());
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        kotlin.jvm.internal.r.f(insets, "insets");
        return insets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            } else {
                View view = getChildAt(childCount);
                kotlin.jvm.internal.r.e(view, "view");
                a(view);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        kotlin.jvm.internal.r.f(view, "view");
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i4) {
        View view = getChildAt(i4);
        kotlin.jvm.internal.r.e(view, "view");
        a(view);
        super.removeViewAt(i4);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        kotlin.jvm.internal.r.f(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i4, int i5) {
        int i6 = i4 + i5;
        for (int i7 = i4; i7 < i6; i7++) {
            View view = getChildAt(i7);
            kotlin.jvm.internal.r.e(view, "view");
            a(view);
        }
        super.removeViews(i4, i5);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i4, int i5) {
        int i6 = i4 + i5;
        for (int i7 = i4; i7 < i6; i7++) {
            View view = getChildAt(i7);
            kotlin.jvm.internal.r.e(view, "view");
            a(view);
        }
        super.removeViewsInLayout(i4, i5);
    }

    public final void setDrawDisappearingViewsLast(boolean z4) {
        this.f7612e = z4;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener listener) {
        kotlin.jvm.internal.r.f(listener, "listener");
        this.f7611c = listener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        kotlin.jvm.internal.r.f(view, "view");
        if (view.getParent() == this) {
            this.f7610b.add(view);
        }
        super.startViewTransition(view);
    }
}
