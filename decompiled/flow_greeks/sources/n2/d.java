package n2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d extends f0 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f16504a;

        public a(View view) {
            this.f16504a = view;
        }

        @Override // n2.l.f
        public void d(l lVar) {
            y.g(this.f16504a, 1.0f);
            y.a(this.f16504a);
            lVar.R(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f16506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f16507b = false;

        public b(View view) {
            this.f16506a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            y.g(this.f16506a, 1.0f);
            if (this.f16507b) {
                this.f16506a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (t0.c0.x(this.f16506a) && this.f16506a.getLayerType() == 0) {
                this.f16507b = true;
                this.f16506a.setLayerType(2, null);
            }
        }
    }

    public d(int i10) {
        k0(i10);
    }

    public static float m0(r rVar, float f10) {
        Float f11;
        return (rVar == null || (f11 = (Float) rVar.f16595a.get("android:fade:transitionAlpha")) == null) ? f10 : f11.floatValue();
    }

    @Override // n2.f0
    public Animator g0(ViewGroup viewGroup, View view, r rVar, r rVar2) {
        float fM0 = m0(rVar, 0.0f);
        return l0(view, fM0 != 1.0f ? fM0 : 0.0f, 1.0f);
    }

    @Override // n2.f0
    public Animator i0(ViewGroup viewGroup, View view, r rVar, r rVar2) {
        y.e(view);
        return l0(view, m0(rVar, 1.0f), 0.0f);
    }

    @Override // n2.f0, n2.l
    public void k(r rVar) {
        super.k(rVar);
        rVar.f16595a.put("android:fade:transitionAlpha", Float.valueOf(y.c(rVar.f16596b)));
    }

    public final Animator l0(View view, float f10, float f11) {
        if (f10 == f11) {
            return null;
        }
        y.g(view, f10);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) y.f16606b, f11);
        objectAnimatorOfFloat.addListener(new b(view));
        a(new a(view));
        return objectAnimatorOfFloat;
    }
}
