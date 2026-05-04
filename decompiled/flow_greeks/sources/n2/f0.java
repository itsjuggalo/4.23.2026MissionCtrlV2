package n2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import n2.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f0 extends l {
    public static final String[] Q = {"android:visibility:visibility", "android:visibility:parent"};
    public int I = 3;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f16528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f16529b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f16530c;

        public a(ViewGroup viewGroup, View view, View view2) {
            this.f16528a = viewGroup;
            this.f16529b = view;
            this.f16530c = view2;
        }

        @Override // n2.m, n2.l.f
        public void a(l lVar) {
            if (this.f16529b.getParent() == null) {
                v.a(this.f16528a).c(this.f16529b);
            } else {
                f0.this.g();
            }
        }

        @Override // n2.l.f
        public void d(l lVar) {
            this.f16530c.setTag(i.f16545a, null);
            v.a(this.f16528a).d(this.f16529b);
            lVar.R(this);
        }

        @Override // n2.m, n2.l.f
        public void e(l lVar) {
            v.a(this.f16528a).d(this.f16529b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f16538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f16539b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f16540c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f16541d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ViewGroup f16542e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ViewGroup f16543f;
    }

    private void e0(r rVar) {
        rVar.f16595a.put("android:visibility:visibility", Integer.valueOf(rVar.f16596b.getVisibility()));
        rVar.f16595a.put("android:visibility:parent", rVar.f16596b.getParent());
        int[] iArr = new int[2];
        rVar.f16596b.getLocationOnScreen(iArr);
        rVar.f16595a.put("android:visibility:screenLocation", iArr);
    }

    @Override // n2.l
    public String[] F() {
        return Q;
    }

    @Override // n2.l
    public boolean H(r rVar, r rVar2) {
        if (rVar == null && rVar2 == null) {
            return false;
        }
        if (rVar != null && rVar2 != null && rVar2.f16595a.containsKey("android:visibility:visibility") != rVar.f16595a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c cVarF0 = f0(rVar, rVar2);
        return cVarF0.f16538a && (cVarF0.f16540c == 0 || cVarF0.f16541d == 0);
    }

    public final c f0(r rVar, r rVar2) {
        c cVar = new c();
        cVar.f16538a = false;
        cVar.f16539b = false;
        if (rVar == null || !rVar.f16595a.containsKey("android:visibility:visibility")) {
            cVar.f16540c = -1;
            cVar.f16542e = null;
        } else {
            cVar.f16540c = ((Integer) rVar.f16595a.get("android:visibility:visibility")).intValue();
            cVar.f16542e = (ViewGroup) rVar.f16595a.get("android:visibility:parent");
        }
        if (rVar2 == null || !rVar2.f16595a.containsKey("android:visibility:visibility")) {
            cVar.f16541d = -1;
            cVar.f16543f = null;
        } else {
            cVar.f16541d = ((Integer) rVar2.f16595a.get("android:visibility:visibility")).intValue();
            cVar.f16543f = (ViewGroup) rVar2.f16595a.get("android:visibility:parent");
        }
        if (rVar != null && rVar2 != null) {
            int i10 = cVar.f16540c;
            int i11 = cVar.f16541d;
            if (i10 != i11 || cVar.f16542e != cVar.f16543f) {
                if (i10 != i11) {
                    if (i10 == 0) {
                        cVar.f16539b = false;
                        cVar.f16538a = true;
                        return cVar;
                    }
                    if (i11 == 0) {
                        cVar.f16539b = true;
                        cVar.f16538a = true;
                        return cVar;
                    }
                } else {
                    if (cVar.f16543f == null) {
                        cVar.f16539b = false;
                        cVar.f16538a = true;
                        return cVar;
                    }
                    if (cVar.f16542e == null) {
                        cVar.f16539b = true;
                        cVar.f16538a = true;
                        return cVar;
                    }
                }
            }
        } else {
            if (rVar == null && cVar.f16541d == 0) {
                cVar.f16539b = true;
                cVar.f16538a = true;
                return cVar;
            }
            if (rVar2 == null && cVar.f16540c == 0) {
                cVar.f16539b = false;
                cVar.f16538a = true;
            }
        }
        return cVar;
    }

    public abstract Animator g0(ViewGroup viewGroup, View view, r rVar, r rVar2);

    @Override // n2.l
    public void h(r rVar) {
        e0(rVar);
    }

    public Animator h0(ViewGroup viewGroup, r rVar, int i10, r rVar2, int i11) {
        if ((this.I & 1) != 1 || rVar2 == null) {
            return null;
        }
        if (rVar == null) {
            View view = (View) rVar2.f16596b.getParent();
            if (f0(v(view, false), G(view, false)).f16538a) {
                return null;
            }
        }
        return g0(viewGroup, rVar2.f16596b, rVar, rVar2);
    }

    public abstract Animator i0(ViewGroup viewGroup, View view, r rVar, r rVar2);

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
    public android.animation.Animator j0(android.view.ViewGroup r10, n2.r r11, int r12, n2.r r13, int r14) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n2.f0.j0(android.view.ViewGroup, n2.r, int, n2.r, int):android.animation.Animator");
    }

    @Override // n2.l
    public void k(r rVar) {
        e0(rVar);
    }

    public void k0(int i10) {
        if ((i10 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.I = i10;
    }

    @Override // n2.l
    public Animator o(ViewGroup viewGroup, r rVar, r rVar2) {
        c cVarF0 = f0(rVar, rVar2);
        if (!cVarF0.f16538a) {
            return null;
        }
        if (cVarF0.f16542e == null && cVarF0.f16543f == null) {
            return null;
        }
        return cVarF0.f16539b ? h0(viewGroup, rVar, cVarF0.f16540c, rVar2, cVarF0.f16541d) : j0(viewGroup, rVar, cVarF0.f16540c, rVar2, cVarF0.f16541d);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends AnimatorListenerAdapter implements l.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f16532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f16533b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ViewGroup f16534c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f16535d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f16536e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f16537f = false;

        public b(View view, int i10, boolean z10) {
            this.f16532a = view;
            this.f16533b = i10;
            this.f16534c = (ViewGroup) view.getParent();
            this.f16535d = z10;
            g(true);
        }

        @Override // n2.l.f
        public void a(l lVar) {
            g(true);
        }

        @Override // n2.l.f
        public void d(l lVar) {
            f();
            lVar.R(this);
        }

        @Override // n2.l.f
        public void e(l lVar) {
            g(false);
        }

        public final void f() {
            if (!this.f16537f) {
                y.h(this.f16532a, this.f16533b);
                ViewGroup viewGroup = this.f16534c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        public final void g(boolean z10) {
            ViewGroup viewGroup;
            if (!this.f16535d || this.f16536e == z10 || (viewGroup = this.f16534c) == null) {
                return;
            }
            this.f16536e = z10;
            v.c(viewGroup, z10);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f16537f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            if (this.f16537f) {
                return;
            }
            y.h(this.f16532a, this.f16533b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.f16537f) {
                return;
            }
            y.h(this.f16532a, 0);
        }

        @Override // n2.l.f
        public void b(l lVar) {
        }

        @Override // n2.l.f
        public void c(l lVar) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
