package p0;

import N1.I1;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f.d f9049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f9050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final io.flutter.plugin.platform.p f9051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final io.flutter.plugin.platform.p f9052d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9053f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9054g;

    public u() {
        Y3.j jVar = new Y3.j(this, 22);
        Z.B b3 = new Z.B(this, 20);
        this.f9051c = new io.flutter.plugin.platform.p(jVar);
        this.f9052d = new io.flutter.plugin.platform.p(b3);
        this.e = false;
    }

    public static int e(int i, int i6, int i7) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i6, i7) : size : Math.min(size, Math.max(i6, i7));
    }

    public static void v(View view) {
        ((v) view.getLayoutParams()).getClass();
        throw null;
    }

    public static C0898j w(Context context, AttributeSet attributeSet, int i, int i6) {
        C0898j c0898j = new C0898j(1);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o0.a.f8626a, i, i6);
        c0898j.f9038b = typedArrayObtainStyledAttributes.getInt(0, 1);
        c0898j.f9039c = typedArrayObtainStyledAttributes.getInt(9, 1);
        c0898j.f9040d = typedArrayObtainStyledAttributes.getBoolean(8, false);
        c0898j.e = typedArrayObtainStyledAttributes.getBoolean(10, false);
        typedArrayObtainStyledAttributes.recycle();
        return c0898j;
    }

    public void A(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.f9050b;
        E3.k kVar = recyclerView.f4758a;
        C c6 = recyclerView.f4761b0;
        if (recyclerView == null || accessibilityEvent == null) {
            return;
        }
        boolean z6 = true;
        if (!recyclerView.canScrollVertically(1) && !this.f9050b.canScrollVertically(-1) && !this.f9050b.canScrollHorizontally(-1) && !this.f9050b.canScrollHorizontally(1)) {
            z6 = false;
        }
        accessibilityEvent.setScrollable(z6);
        this.f9050b.getClass();
    }

    public abstract void B(Parcelable parcelable);

    public abstract Parcelable C();

    public final void E() {
        int iP = p() - 1;
        if (iP < 0) {
            return;
        }
        RecyclerView.j(o(iP));
        throw null;
    }

    public final void F(E3.k kVar) {
        int size = ((ArrayList) kVar.f423c).size();
        int i = size - 1;
        ArrayList arrayList = (ArrayList) kVar.f423c;
        if (i >= 0) {
            arrayList.get(i).getClass();
            throw new ClassCastException();
        }
        arrayList.clear();
        if (size > 0) {
            this.f9050b.invalidate();
        }
    }

    public final boolean G(RecyclerView recyclerView, View view, Rect rect, boolean z6, boolean z7) {
        boolean z8;
        boolean z9;
        int iS = s();
        int iU = u();
        int iT = this.f9053f - t();
        int iR = this.f9054g - r();
        int left = (view.getLeft() + rect.left) - view.getScrollX();
        int top = (view.getTop() + rect.top) - view.getScrollY();
        int iWidth = rect.width() + left;
        int iHeight = rect.height() + top;
        int i = left - iS;
        int iMin = Math.min(0, i);
        int i6 = top - iU;
        int iMin2 = Math.min(0, i6);
        int i7 = iWidth - iT;
        int iMax = Math.max(0, i7);
        int iMax2 = Math.max(0, iHeight - iR);
        RecyclerView recyclerView2 = this.f9050b;
        Field field = D.C.f194a;
        if (recyclerView2.getLayoutDirection() != 1) {
            if (iMin == 0) {
                iMin = Math.min(i, iMax);
            }
            iMax = iMin;
        } else if (iMax == 0) {
            iMax = Math.max(iMin, i7);
        }
        if (iMin2 == 0) {
            iMin2 = Math.min(i6, iMax2);
        }
        int[] iArr = {iMax, iMin2};
        int i8 = iArr[0];
        int i9 = iArr[1];
        if (z7) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iS2 = s();
            int iU2 = u();
            int iT2 = this.f9053f - t();
            int iR2 = this.f9054g - r();
            Rect rect2 = this.f9050b.f4773k;
            int[] iArr2 = RecyclerView.f4733l0;
            v vVar = (v) focusedChild.getLayoutParams();
            Rect rect3 = vVar.f9055a;
            z8 = false;
            z9 = true;
            rect2.set((focusedChild.getLeft() - rect3.left) - ((ViewGroup.MarginLayoutParams) vVar).leftMargin, (focusedChild.getTop() - rect3.top) - ((ViewGroup.MarginLayoutParams) vVar).topMargin, focusedChild.getRight() + rect3.right + ((ViewGroup.MarginLayoutParams) vVar).rightMargin, focusedChild.getBottom() + rect3.bottom + ((ViewGroup.MarginLayoutParams) vVar).bottomMargin);
            if (rect2.left - i8 >= iT2 || rect2.right - i8 <= iS2 || rect2.top - i9 >= iR2 || rect2.bottom - i9 <= iU2) {
                return false;
            }
        } else {
            z8 = false;
            z9 = true;
        }
        if (i8 == 0 && i9 == 0) {
            return z8;
        }
        if (z6) {
            recyclerView.scrollBy(i8, i9);
            return z9;
        }
        recyclerView.r(i8, i9);
        return z9;
    }

    public final void H() {
        RecyclerView recyclerView = this.f9050b;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public final void I(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.f9050b = null;
            this.f9049a = null;
            this.f9053f = 0;
            this.f9054g = 0;
            return;
        }
        this.f9050b = recyclerView;
        this.f9049a = recyclerView.f4764d;
        this.f9053f = recyclerView.getWidth();
        this.f9054g = recyclerView.getHeight();
    }

    public abstract void a(String str);

    public abstract boolean b();

    public abstract boolean c();

    public boolean d(v vVar) {
        return vVar != null;
    }

    public abstract int f(C c6);

    public abstract void g(C c6);

    public abstract int h(C c6);

    public abstract int i(C c6);

    public abstract void j(C c6);

    public abstract int k(C c6);

    public abstract v l();

    public v m(Context context, AttributeSet attributeSet) {
        return new v(context, attributeSet);
    }

    public v n(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof v ? new v((v) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new v((ViewGroup.MarginLayoutParams) layoutParams) : new v(layoutParams);
    }

    public final View o(int i) {
        f.d dVar = this.f9049a;
        if (dVar == null) {
            return null;
        }
        int i6 = -1;
        if (i >= 0) {
            int childCount = ((RecyclerView) ((Z.B) dVar.f6383c).f3700b).getChildCount();
            int i7 = i;
            while (true) {
                if (i7 >= childCount) {
                    break;
                }
                I1 i12 = (I1) dVar.f6382b;
                int iA = i - (i7 - i12.a(i7));
                if (iA == 0) {
                    i6 = i7;
                    while (i12.c(i6)) {
                        i6++;
                    }
                } else {
                    i7 += iA;
                }
            }
        }
        return ((RecyclerView) ((Z.B) dVar.f6383c).f3700b).getChildAt(i6);
    }

    public final int p() {
        f.d dVar = this.f9049a;
        if (dVar != null) {
            return ((RecyclerView) ((Z.B) dVar.f6383c).f3700b).getChildCount() - ((ArrayList) dVar.f6384d).size();
        }
        return 0;
    }

    public int q(E3.k kVar, C c6) {
        RecyclerView recyclerView = this.f9050b;
        if (recyclerView == null) {
            return 1;
        }
        recyclerView.getClass();
        return 1;
    }

    public final int r() {
        RecyclerView recyclerView = this.f9050b;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public final int s() {
        RecyclerView recyclerView = this.f9050b;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public final int t() {
        RecyclerView recyclerView = this.f9050b;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public final int u() {
        RecyclerView recyclerView = this.f9050b;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public int x(E3.k kVar, C c6) {
        RecyclerView recyclerView = this.f9050b;
        if (recyclerView == null) {
            return 1;
        }
        recyclerView.getClass();
        return 1;
    }

    public abstract boolean y();

    public abstract void z(RecyclerView recyclerView);

    public void D(int i) {
    }
}
