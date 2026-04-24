package D;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: renamed from: D.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0006f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewParent f235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewParent f236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f238d;
    public int[] e;

    public C0006f(ViewGroup viewGroup) {
        this.f237c = viewGroup;
    }

    public final boolean a(float f6, float f7, boolean z6) {
        ViewParent viewParentE;
        if (this.f238d && (viewParentE = e(0)) != null) {
            try {
                return H.a(viewParentE, this.f237c, f6, f7, z6);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedFling", e);
            }
        }
        return false;
    }

    public final boolean b(float f6, float f7) {
        ViewParent viewParentE;
        if (this.f238d && (viewParentE = e(0)) != null) {
            try {
                return H.b(viewParentE, this.f237c, f6, f7);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedPreFling", e);
            }
        }
        return false;
    }

    public final boolean c(int i, int i6, int[] iArr, int[] iArr2, int i7) {
        ViewParent viewParentE;
        int i8;
        int i9;
        if (!this.f238d || (viewParentE = e(i7)) == null) {
            return false;
        }
        if (i == 0 && i6 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        ViewGroup viewGroup = this.f237c;
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            i8 = iArr2[0];
            i9 = iArr2[1];
        } else {
            i8 = 0;
            i9 = 0;
        }
        if (iArr == null) {
            if (this.e == null) {
                this.e = new int[2];
            }
            iArr = this.e;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        if (viewParentE instanceof InterfaceC0007g) {
            ((InterfaceC0007g) viewParentE).d(i, i6, iArr, i7);
        } else if (i7 == 0) {
            try {
                H.c(viewParentE, viewGroup, i, i6, iArr);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedPreScroll", e);
            }
        }
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i8;
            iArr2[1] = iArr2[1] - i9;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public final boolean d(int i, int i6, int i7, int i8, int[] iArr, int i9, int[] iArr2) {
        ViewParent viewParentE;
        int i10;
        int i11;
        int[] iArr3;
        if (this.f238d && (viewParentE = e(i9)) != null) {
            if (i != 0 || i6 != 0 || i7 != 0 || i8 != 0) {
                ViewGroup viewGroup = this.f237c;
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    i10 = iArr[0];
                    i11 = iArr[1];
                } else {
                    i10 = 0;
                    i11 = 0;
                }
                if (iArr2 == null) {
                    if (this.e == null) {
                        this.e = new int[2];
                    }
                    int[] iArr4 = this.e;
                    iArr4[0] = 0;
                    iArr4[1] = 0;
                    iArr3 = iArr4;
                } else {
                    iArr3 = iArr2;
                }
                if (viewParentE instanceof InterfaceC0008h) {
                    ((InterfaceC0008h) viewParentE).e(viewGroup, i, i6, i7, i8, i9, iArr3);
                } else {
                    iArr3[0] = iArr3[0] + i7;
                    iArr3[1] = iArr3[1] + i8;
                    if (viewParentE instanceof InterfaceC0007g) {
                        ((InterfaceC0007g) viewParentE).b(viewGroup, i, i6, i7, i8, i9);
                    } else if (i9 == 0) {
                        try {
                            H.d(viewParentE, viewGroup, i, i6, i7, i8);
                        } catch (AbstractMethodError e) {
                            Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedScroll", e);
                        }
                    }
                }
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    iArr[0] = iArr[0] - i10;
                    iArr[1] = iArr[1] - i11;
                }
                return true;
            }
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                return false;
            }
        }
        return false;
    }

    public final ViewParent e(int i) {
        if (i == 0) {
            return this.f235a;
        }
        if (i != 1) {
            return null;
        }
        return this.f236b;
    }

    public final boolean f(int i) {
        return e(i) != null;
    }

    public final boolean g(int i, int i6) {
        boolean zF;
        if (!f(i6)) {
            if (this.f238d) {
                ViewGroup viewGroup = this.f237c;
                View view = viewGroup;
                for (ViewParent parent = viewGroup.getParent(); parent != null; parent = parent.getParent()) {
                    boolean z6 = parent instanceof InterfaceC0007g;
                    if (z6) {
                        zF = ((InterfaceC0007g) parent).f(view, viewGroup, i, i6);
                    } else if (i6 == 0) {
                        try {
                            zF = H.f(parent, view, viewGroup, i);
                        } catch (AbstractMethodError e) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e);
                            zF = false;
                        }
                    } else {
                        zF = false;
                    }
                    if (zF) {
                        if (i6 == 0) {
                            this.f235a = parent;
                        } else if (i6 == 1) {
                            this.f236b = parent;
                        }
                        if (z6) {
                            ((InterfaceC0007g) parent).a(view, viewGroup, i, i6);
                        } else if (i6 == 0) {
                            try {
                                H.e(parent, view, viewGroup, i);
                            } catch (AbstractMethodError e2) {
                                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e2);
                            }
                        }
                    } else {
                        if (parent instanceof View) {
                            view = (View) parent;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void h(int i) {
        ViewParent viewParentE = e(i);
        if (viewParentE != null) {
            boolean z6 = viewParentE instanceof InterfaceC0007g;
            ViewGroup viewGroup = this.f237c;
            if (z6) {
                ((InterfaceC0007g) viewParentE).c(viewGroup, i);
            } else if (i == 0) {
                try {
                    H.g(viewParentE, viewGroup);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onStopNestedScroll", e);
                }
            }
            if (i == 0) {
                this.f235a = null;
            } else {
                if (i != 1) {
                    return;
                }
                this.f236b = null;
            }
        }
    }
}
