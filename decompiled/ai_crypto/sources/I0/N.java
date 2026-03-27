package I0;

import I0.AbstractC0571l;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class N extends AbstractC0571l {

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public static final String[] f2713O = {"android:visibility:visibility", "android:visibility:parent"};

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public int f2714I = 3;

    public class a extends AbstractC0572m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f2716b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f2717c;

        public a(ViewGroup viewGroup, View view, View view2) {
            this.f2715a = viewGroup;
            this.f2716b = view;
            this.f2717c = view2;
        }

        @Override // I0.AbstractC0572m, I0.AbstractC0571l.f
        public void a(AbstractC0571l abstractC0571l) {
            x.a(this.f2715a).d(this.f2716b);
        }

        @Override // I0.AbstractC0572m, I0.AbstractC0571l.f
        public void b(AbstractC0571l abstractC0571l) {
            if (this.f2716b.getParent() == null) {
                x.a(this.f2715a).c(this.f2716b);
            } else {
                N.this.cancel();
            }
        }

        @Override // I0.AbstractC0571l.f
        public void e(AbstractC0571l abstractC0571l) {
            this.f2717c.setTag(AbstractC0568i.f2791a, null);
            x.a(this.f2715a).d(this.f2716b);
            abstractC0571l.P(this);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2726b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2727c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2728d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ViewGroup f2729e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ViewGroup f2730f;
    }

    private void c0(s sVar) {
        sVar.f2854a.put("android:visibility:visibility", Integer.valueOf(sVar.f2855b.getVisibility()));
        sVar.f2854a.put("android:visibility:parent", sVar.f2855b.getParent());
        int[] iArr = new int[2];
        sVar.f2855b.getLocationOnScreen(iArr);
        sVar.f2854a.put("android:visibility:screenLocation", iArr);
    }

    @Override // I0.AbstractC0571l
    public String[] D() {
        return f2713O;
    }

    @Override // I0.AbstractC0571l
    public boolean F(s sVar, s sVar2) {
        if (sVar == null && sVar2 == null) {
            return false;
        }
        if (sVar != null && sVar2 != null && sVar2.f2854a.containsKey("android:visibility:visibility") != sVar.f2854a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c cVarD0 = d0(sVar, sVar2);
        if (cVarD0.f2725a) {
            return cVarD0.f2727c == 0 || cVarD0.f2728d == 0;
        }
        return false;
    }

    public final c d0(s sVar, s sVar2) {
        c cVar = new c();
        cVar.f2725a = false;
        cVar.f2726b = false;
        if (sVar == null || !sVar.f2854a.containsKey("android:visibility:visibility")) {
            cVar.f2727c = -1;
            cVar.f2729e = null;
        } else {
            cVar.f2727c = ((Integer) sVar.f2854a.get("android:visibility:visibility")).intValue();
            cVar.f2729e = (ViewGroup) sVar.f2854a.get("android:visibility:parent");
        }
        if (sVar2 == null || !sVar2.f2854a.containsKey("android:visibility:visibility")) {
            cVar.f2728d = -1;
            cVar.f2730f = null;
        } else {
            cVar.f2728d = ((Integer) sVar2.f2854a.get("android:visibility:visibility")).intValue();
            cVar.f2730f = (ViewGroup) sVar2.f2854a.get("android:visibility:parent");
        }
        if (sVar != null && sVar2 != null) {
            int i7 = cVar.f2727c;
            int i8 = cVar.f2728d;
            if (i7 == i8 && cVar.f2729e == cVar.f2730f) {
                return cVar;
            }
            if (i7 != i8) {
                if (i7 == 0) {
                    cVar.f2726b = false;
                    cVar.f2725a = true;
                } else if (i8 == 0) {
                    cVar.f2726b = true;
                    cVar.f2725a = true;
                }
            } else if (cVar.f2730f == null) {
                cVar.f2726b = false;
                cVar.f2725a = true;
            } else if (cVar.f2729e == null) {
                cVar.f2726b = true;
                cVar.f2725a = true;
            }
        } else if (sVar == null && cVar.f2728d == 0) {
            cVar.f2726b = true;
            cVar.f2725a = true;
        } else if (sVar2 == null && cVar.f2727c == 0) {
            cVar.f2726b = false;
            cVar.f2725a = true;
        }
        return cVar;
    }

    public Animator e0(ViewGroup viewGroup, s sVar, int i7, s sVar2, int i8) {
        if ((this.f2714I & 1) != 1 || sVar2 == null) {
            return null;
        }
        if (sVar == null) {
            View view = (View) sVar2.f2855b.getParent();
            if (d0(t(view, false), E(view, false)).f2725a) {
                return null;
            }
        }
        return f0(viewGroup, sVar2.f2855b, sVar, sVar2);
    }

    @Override // I0.AbstractC0571l
    public void f(s sVar) {
        c0(sVar);
    }

    public abstract Animator f0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0069 A[PHI: r2
      0x0069: PHI (r2v3 android.view.View) = 
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v6 android.view.View)
     binds: [B:26:0x003e, B:31:0x004d, B:37:0x0076, B:39:0x0079, B:41:0x007f, B:43:0x0083, B:34:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator g0(android.view.ViewGroup r11, I0.s r12, int r13, I0.s r14, int r15) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I0.N.g0(android.view.ViewGroup, I0.s, int, I0.s, int):android.animation.Animator");
    }

    public abstract Animator h0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    public void i0(int i7) {
        if ((i7 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.f2714I = i7;
    }

    @Override // I0.AbstractC0571l
    public void j(s sVar) {
        c0(sVar);
    }

    @Override // I0.AbstractC0571l
    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        c cVarD0 = d0(sVar, sVar2);
        if (!cVarD0.f2725a) {
            return null;
        }
        if (cVarD0.f2729e == null && cVarD0.f2730f == null) {
            return null;
        }
        return cVarD0.f2726b ? e0(viewGroup, sVar, cVarD0.f2727c, sVar2, cVarD0.f2728d) : g0(viewGroup, sVar, cVarD0.f2727c, sVar2, cVarD0.f2728d);
    }

    public static class b extends AnimatorListenerAdapter implements AbstractC0571l.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f2719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2720b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ViewGroup f2721c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f2722d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f2723e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f2724f = false;

        public b(View view, int i7, boolean z7) {
            this.f2719a = view;
            this.f2720b = i7;
            this.f2721c = (ViewGroup) view.getParent();
            this.f2722d = z7;
            g(true);
        }

        @Override // I0.AbstractC0571l.f
        public void a(AbstractC0571l abstractC0571l) {
            g(false);
        }

        @Override // I0.AbstractC0571l.f
        public void b(AbstractC0571l abstractC0571l) {
            g(true);
        }

        @Override // I0.AbstractC0571l.f
        public void e(AbstractC0571l abstractC0571l) {
            f();
            abstractC0571l.P(this);
        }

        public final void f() {
            if (!this.f2724f) {
                A.h(this.f2719a, this.f2720b);
                ViewGroup viewGroup = this.f2721c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        public final void g(boolean z7) {
            ViewGroup viewGroup;
            if (!this.f2722d || this.f2723e == z7 || (viewGroup = this.f2721c) == null) {
                return;
            }
            this.f2723e = z7;
            x.c(viewGroup, z7);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2724f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            if (this.f2724f) {
                return;
            }
            A.h(this.f2719a, this.f2720b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.f2724f) {
                return;
            }
            A.h(this.f2719a, 0);
        }

        @Override // I0.AbstractC0571l.f
        public void c(AbstractC0571l abstractC0571l) {
        }

        @Override // I0.AbstractC0571l.f
        public void d(AbstractC0571l abstractC0571l) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
