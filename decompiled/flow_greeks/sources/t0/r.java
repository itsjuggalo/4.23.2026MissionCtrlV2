package t0;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewParent f20550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewParent f20551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f20552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f20553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f20554e;

    public r(View view) {
        this.f20552c = view;
    }

    public boolean a(float f10, float f11, boolean z10) {
        ViewParent viewParentI;
        if (!m() || (viewParentI = i(0)) == null) {
            return false;
        }
        return i0.a(viewParentI, this.f20552c, f10, f11, z10);
    }

    public boolean b(float f10, float f11) {
        ViewParent viewParentI;
        if (!m() || (viewParentI = i(0)) == null) {
            return false;
        }
        return i0.b(viewParentI, this.f20552c, f10, f11);
    }

    public boolean c(int i10, int i11, int[] iArr, int[] iArr2) {
        return d(i10, i11, iArr, iArr2, 0);
    }

    public boolean d(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        ViewParent viewParentI;
        int i13;
        int i14;
        if (!m() || (viewParentI = i(i12)) == null) {
            return false;
        }
        if (i10 == 0 && i11 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.f20552c.getLocationInWindow(iArr2);
            i13 = iArr2[0];
            i14 = iArr2[1];
        } else {
            i13 = 0;
            i14 = 0;
        }
        if (iArr == null) {
            iArr = j();
        }
        int[] iArr3 = iArr;
        iArr3[0] = 0;
        iArr3[1] = 0;
        i0.c(viewParentI, this.f20552c, i10, i11, iArr3, i12);
        if (iArr2 != null) {
            this.f20552c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i13;
            iArr2[1] = iArr2[1] - i14;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public void e(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        h(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    public boolean f(int i10, int i11, int i12, int i13, int[] iArr) {
        return h(i10, i11, i12, i13, iArr, 0, null);
    }

    public boolean g(int i10, int i11, int i12, int i13, int[] iArr, int i14) {
        return h(i10, i11, i12, i13, iArr, i14, null);
    }

    public final boolean h(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        ViewParent viewParentI;
        int i15;
        int i16;
        int[] iArr3;
        if (!m() || (viewParentI = i(i14)) == null) {
            return false;
        }
        if (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f20552c.getLocationInWindow(iArr);
            i15 = iArr[0];
            i16 = iArr[1];
        } else {
            i15 = 0;
            i16 = 0;
        }
        if (iArr2 == null) {
            int[] iArrJ = j();
            iArrJ[0] = 0;
            iArrJ[1] = 0;
            iArr3 = iArrJ;
        } else {
            iArr3 = iArr2;
        }
        i0.d(viewParentI, this.f20552c, i10, i11, i12, i13, i14, iArr3);
        if (iArr != null) {
            this.f20552c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i15;
            iArr[1] = iArr[1] - i16;
        }
        return true;
    }

    public final ViewParent i(int i10) {
        if (i10 == 0) {
            return this.f20550a;
        }
        if (i10 != 1) {
            return null;
        }
        return this.f20551b;
    }

    public final int[] j() {
        if (this.f20554e == null) {
            this.f20554e = new int[2];
        }
        return this.f20554e;
    }

    public boolean k() {
        return l(0);
    }

    public boolean l(int i10) {
        return i(i10) != null;
    }

    public boolean m() {
        return this.f20553d;
    }

    public void n(boolean z10) {
        if (this.f20553d) {
            c0.W(this.f20552c);
        }
        this.f20553d = z10;
    }

    public final void o(int i10, ViewParent viewParent) {
        if (i10 == 0) {
            this.f20550a = viewParent;
        } else {
            if (i10 != 1) {
                return;
            }
            this.f20551b = viewParent;
        }
    }

    public boolean p(int i10) {
        return q(i10, 0);
    }

    public boolean q(int i10, int i11) {
        if (l(i11)) {
            return true;
        }
        if (!m()) {
            return false;
        }
        View view = this.f20552c;
        for (ViewParent parent = this.f20552c.getParent(); parent != null; parent = parent.getParent()) {
            if (i0.f(parent, view, this.f20552c, i10, i11)) {
                o(i11, parent);
                i0.e(parent, view, this.f20552c, i10, i11);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void r() {
        s(0);
    }

    public void s(int i10) {
        ViewParent viewParentI = i(i10);
        if (viewParentI != null) {
            i0.g(viewParentI, this.f20552c, i10);
            o(i10, null);
        }
    }
}
