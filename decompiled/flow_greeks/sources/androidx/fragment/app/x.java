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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class x extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f2341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f2342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f2343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2344d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2345a = new a();

        public final WindowInsets a(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, View v10, WindowInsets insets) {
            kotlin.jvm.internal.t.f(onApplyWindowInsetsListener, "onApplyWindowInsetsListener");
            kotlin.jvm.internal.t.f(v10, "v");
            kotlin.jvm.internal.t.f(insets, "insets");
            WindowInsets windowInsetsOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(v10, insets);
            kotlin.jvm.internal.t.e(windowInsetsOnApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            return windowInsetsOnApplyWindowInsets;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(Context context, AttributeSet attrs, i0 fm) {
        String str;
        super(context, attrs);
        kotlin.jvm.internal.t.f(context, "context");
        kotlin.jvm.internal.t.f(attrs, "attrs");
        kotlin.jvm.internal.t.f(fm, "fm");
        this.f2341a = new ArrayList();
        this.f2342b = new ArrayList();
        this.f2344d = true;
        String classAttribute = attrs.getClassAttribute();
        int[] FragmentContainerView = u1.c.f22149e;
        kotlin.jvm.internal.t.e(FragmentContainerView, "FragmentContainerView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, FragmentContainerView, 0, 0);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(u1.c.f22150f) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(u1.c.f22151g);
        typedArrayObtainStyledAttributes.recycle();
        int id2 = getId();
        p pVarI0 = fm.i0(id2);
        if (classAttribute != null && pVarI0 == null) {
            if (id2 == -1) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            p pVarA = fm.u0().a(context.getClassLoader(), classAttribute);
            kotlin.jvm.internal.t.e(pVarA, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            pVarA.mFragmentId = id2;
            pVarA.mContainerId = id2;
            pVarA.mTag = string;
            pVarA.mFragmentManager = fm;
            pVarA.mHost = fm.w0();
            pVarA.onInflate(context, attrs, (Bundle) null);
            fm.o().m(true).c(this, pVarA, string).i();
        }
        fm.W0(this);
    }

    public final void a(View view) {
        if (this.f2342b.contains(view)) {
            this.f2341a.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int i10, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.t.f(child, "child");
        if (i0.D0(child) != null) {
            super.addView(child, i10, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + child + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        t0.j0 j0VarC;
        kotlin.jvm.internal.t.f(insets, "insets");
        t0.j0 j0VarV = t0.j0.v(insets);
        kotlin.jvm.internal.t.e(j0VarV, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f2343c;
        if (onApplyWindowInsetsListener != null) {
            a aVar = a.f2345a;
            kotlin.jvm.internal.t.c(onApplyWindowInsetsListener);
            j0VarC = t0.j0.v(aVar.a(onApplyWindowInsetsListener, this, insets));
        } else {
            j0VarC = t0.c0.C(this, j0VarV);
        }
        kotlin.jvm.internal.t.e(j0VarC, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!j0VarC.n()) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                t0.c0.c(getChildAt(i10), j0VarC);
            }
        }
        return insets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        kotlin.jvm.internal.t.f(canvas, "canvas");
        if (this.f2344d) {
            Iterator it = this.f2341a.iterator();
            while (it.hasNext()) {
                super.drawChild(canvas, (View) it.next(), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View child, long j10) {
        kotlin.jvm.internal.t.f(canvas, "canvas");
        kotlin.jvm.internal.t.f(child, "child");
        if (this.f2344d && !this.f2341a.isEmpty() && this.f2341a.contains(child)) {
            return false;
        }
        return super.drawChild(canvas, child, j10);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        kotlin.jvm.internal.t.f(view, "view");
        this.f2342b.remove(view);
        if (this.f2341a.remove(view)) {
            this.f2344d = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends p> F getFragment() {
        return (F) i0.l0(this).i0(getId());
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        kotlin.jvm.internal.t.f(insets, "insets");
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
                kotlin.jvm.internal.t.e(view, "view");
                a(view);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        kotlin.jvm.internal.t.f(view, "view");
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i10) {
        View view = getChildAt(i10);
        kotlin.jvm.internal.t.e(view, "view");
        a(view);
        super.removeViewAt(i10);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        kotlin.jvm.internal.t.f(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i10, int i11) {
        int i12 = i10 + i11;
        for (int i13 = i10; i13 < i12; i13++) {
            View view = getChildAt(i13);
            kotlin.jvm.internal.t.e(view, "view");
            a(view);
        }
        super.removeViews(i10, i11);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i10, int i11) {
        int i12 = i10 + i11;
        for (int i13 = i10; i13 < i12; i13++) {
            View view = getChildAt(i13);
            kotlin.jvm.internal.t.e(view, "view");
            a(view);
        }
        super.removeViewsInLayout(i10, i11);
    }

    public final void setDrawDisappearingViewsLast(boolean z10) {
        this.f2344d = z10;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener listener) {
        kotlin.jvm.internal.t.f(listener, "listener");
        this.f2343c = listener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        kotlin.jvm.internal.t.f(view, "view");
        if (view.getParent() == this) {
            this.f2342b.add(view);
        }
        super.startViewTransition(view);
    }
}
