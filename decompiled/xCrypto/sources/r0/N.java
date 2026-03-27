package r0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import r0.AbstractC1738l;

/* JADX INFO: loaded from: classes.dex */
public abstract class N extends AbstractC1738l {

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public static final String[] f14329O = {"android:visibility:visibility", "android:visibility:parent"};

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public int f14330I = 3;

    public class a extends AbstractC1739m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f14331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f14332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f14333c;

        public a(ViewGroup viewGroup, View view, View view2) {
            this.f14331a = viewGroup;
            this.f14332b = view;
            this.f14333c = view2;
        }

        @Override // r0.AbstractC1739m, r0.AbstractC1738l.f
        public void a(AbstractC1738l abstractC1738l) {
            x.a(this.f14331a).d(this.f14332b);
        }

        @Override // r0.AbstractC1738l.f
        public void b(AbstractC1738l abstractC1738l) {
            this.f14333c.setTag(AbstractC1735i.f14407a, null);
            x.a(this.f14331a).d(this.f14332b);
            abstractC1738l.P(this);
        }

        @Override // r0.AbstractC1739m, r0.AbstractC1738l.f
        public void d(AbstractC1738l abstractC1738l) {
            if (this.f14332b.getParent() == null) {
                x.a(this.f14331a).c(this.f14332b);
            } else {
                N.this.f();
            }
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f14341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f14342b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14343c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f14344d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ViewGroup f14345e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ViewGroup f14346f;
    }

    private void c0(s sVar) {
        sVar.f14470a.put("android:visibility:visibility", Integer.valueOf(sVar.f14471b.getVisibility()));
        sVar.f14470a.put("android:visibility:parent", sVar.f14471b.getParent());
        int[] iArr = new int[2];
        sVar.f14471b.getLocationOnScreen(iArr);
        sVar.f14470a.put("android:visibility:screenLocation", iArr);
    }

    @Override // r0.AbstractC1738l
    public String[] D() {
        return f14329O;
    }

    @Override // r0.AbstractC1738l
    public boolean F(s sVar, s sVar2) {
        if (sVar == null && sVar2 == null) {
            return false;
        }
        if (sVar != null && sVar2 != null && sVar2.f14470a.containsKey("android:visibility:visibility") != sVar.f14470a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c cVarD0 = d0(sVar, sVar2);
        return cVarD0.f14341a && (cVarD0.f14343c == 0 || cVarD0.f14344d == 0);
    }

    public final c d0(s sVar, s sVar2) {
        c cVar = new c();
        cVar.f14341a = false;
        cVar.f14342b = false;
        if (sVar == null || !sVar.f14470a.containsKey("android:visibility:visibility")) {
            cVar.f14343c = -1;
            cVar.f14345e = null;
        } else {
            cVar.f14343c = ((Integer) sVar.f14470a.get("android:visibility:visibility")).intValue();
            cVar.f14345e = (ViewGroup) sVar.f14470a.get("android:visibility:parent");
        }
        if (sVar2 == null || !sVar2.f14470a.containsKey("android:visibility:visibility")) {
            cVar.f14344d = -1;
            cVar.f14346f = null;
        } else {
            cVar.f14344d = ((Integer) sVar2.f14470a.get("android:visibility:visibility")).intValue();
            cVar.f14346f = (ViewGroup) sVar2.f14470a.get("android:visibility:parent");
        }
        if (sVar != null && sVar2 != null) {
            int i4 = cVar.f14343c;
            int i5 = cVar.f14344d;
            if (i4 != i5 || cVar.f14345e != cVar.f14346f) {
                if (i4 != i5) {
                    if (i4 == 0) {
                        cVar.f14342b = false;
                        cVar.f14341a = true;
                        return cVar;
                    }
                    if (i5 == 0) {
                        cVar.f14342b = true;
                        cVar.f14341a = true;
                        return cVar;
                    }
                } else {
                    if (cVar.f14346f == null) {
                        cVar.f14342b = false;
                        cVar.f14341a = true;
                        return cVar;
                    }
                    if (cVar.f14345e == null) {
                        cVar.f14342b = true;
                        cVar.f14341a = true;
                        return cVar;
                    }
                }
            }
        } else {
            if (sVar == null && cVar.f14344d == 0) {
                cVar.f14342b = true;
                cVar.f14341a = true;
                return cVar;
            }
            if (sVar2 == null && cVar.f14343c == 0) {
                cVar.f14342b = false;
                cVar.f14341a = true;
            }
        }
        return cVar;
    }

    public abstract Animator e0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    public Animator f0(ViewGroup viewGroup, s sVar, int i4, s sVar2, int i5) {
        if ((this.f14330I & 1) != 1 || sVar2 == null) {
            return null;
        }
        if (sVar == null) {
            View view = (View) sVar2.f14471b.getParent();
            if (d0(t(view, false), E(view, false)).f14341a) {
                return null;
            }
        }
        return e0(viewGroup, sVar2.f14471b, sVar, sVar2);
    }

    @Override // r0.AbstractC1738l
    public void g(s sVar) {
        c0(sVar);
    }

    public abstract Animator g0(ViewGroup viewGroup, View view, s sVar, s sVar2);

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
    public android.animation.Animator h0(android.view.ViewGroup r10, r0.s r11, int r12, r0.s r13, int r14) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r0.N.h0(android.view.ViewGroup, r0.s, int, r0.s, int):android.animation.Animator");
    }

    public void i0(int i4) {
        if ((i4 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.f14330I = i4;
    }

    @Override // r0.AbstractC1738l
    public void j(s sVar) {
        c0(sVar);
    }

    @Override // r0.AbstractC1738l
    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        c cVarD0 = d0(sVar, sVar2);
        if (!cVarD0.f14341a) {
            return null;
        }
        if (cVarD0.f14345e == null && cVarD0.f14346f == null) {
            return null;
        }
        return cVarD0.f14342b ? f0(viewGroup, sVar, cVarD0.f14343c, sVar2, cVarD0.f14344d) : h0(viewGroup, sVar, cVarD0.f14343c, sVar2, cVarD0.f14344d);
    }

    public static class b extends AnimatorListenerAdapter implements AbstractC1738l.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f14335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f14336b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ViewGroup f14337c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f14338d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f14339e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f14340f = false;

        public b(View view, int i4, boolean z4) {
            this.f14335a = view;
            this.f14336b = i4;
            this.f14337c = (ViewGroup) view.getParent();
            this.f14338d = z4;
            g(true);
        }

        @Override // r0.AbstractC1738l.f
        public void a(AbstractC1738l abstractC1738l) {
            g(false);
        }

        @Override // r0.AbstractC1738l.f
        public void b(AbstractC1738l abstractC1738l) {
            f();
            abstractC1738l.P(this);
        }

        @Override // r0.AbstractC1738l.f
        public void d(AbstractC1738l abstractC1738l) {
            g(true);
        }

        public final void f() {
            if (!this.f14340f) {
                AbstractC1726A.h(this.f14335a, this.f14336b);
                ViewGroup viewGroup = this.f14337c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        public final void g(boolean z4) {
            ViewGroup viewGroup;
            if (!this.f14338d || this.f14339e == z4 || (viewGroup = this.f14337c) == null) {
                return;
            }
            this.f14339e = z4;
            x.c(viewGroup, z4);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f14340f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            if (this.f14340f) {
                return;
            }
            AbstractC1726A.h(this.f14335a, this.f14336b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.f14340f) {
                return;
            }
            AbstractC1726A.h(this.f14335a, 0);
        }

        @Override // r0.AbstractC1738l.f
        public void c(AbstractC1738l abstractC1738l) {
        }

        @Override // r0.AbstractC1738l.f
        public void e(AbstractC1738l abstractC1738l) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
