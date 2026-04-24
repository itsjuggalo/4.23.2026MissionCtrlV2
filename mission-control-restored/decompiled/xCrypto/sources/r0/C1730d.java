package r0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: r0.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1730d extends N {

    /* JADX INFO: renamed from: r0.d$a */
    public class a extends AbstractC1739m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f14385a;

        public a(View view) {
            this.f14385a = view;
        }

        @Override // r0.AbstractC1738l.f
        public void b(AbstractC1738l abstractC1738l) {
            AbstractC1726A.g(this.f14385a, 1.0f);
            AbstractC1726A.a(this.f14385a);
            abstractC1738l.P(this);
        }
    }

    /* JADX INFO: renamed from: r0.d$b */
    public static class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f14387a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f14388b = false;

        public b(View view) {
            this.f14387a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC1726A.g(this.f14387a, 1.0f);
            if (this.f14388b) {
                this.f14387a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (H.E.u(this.f14387a) && this.f14387a.getLayerType() == 0) {
                this.f14388b = true;
                this.f14387a.setLayerType(2, null);
            }
        }
    }

    public C1730d(int i4) {
        i0(i4);
    }

    public static float k0(s sVar, float f4) {
        Float f5;
        return (sVar == null || (f5 = (Float) sVar.f14470a.get("android:fade:transitionAlpha")) == null) ? f4 : f5.floatValue();
    }

    @Override // r0.N
    public Animator e0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        float fK0 = k0(sVar, 0.0f);
        return j0(view, fK0 != 1.0f ? fK0 : 0.0f, 1.0f);
    }

    @Override // r0.N
    public Animator g0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        AbstractC1726A.e(view);
        return j0(view, k0(sVar, 1.0f), 0.0f);
    }

    @Override // r0.N, r0.AbstractC1738l
    public void j(s sVar) {
        super.j(sVar);
        sVar.f14470a.put("android:fade:transitionAlpha", Float.valueOf(AbstractC1726A.c(sVar.f14471b)));
    }

    public final Animator j0(View view, float f4, float f5) {
        if (f4 == f5) {
            return null;
        }
        AbstractC1726A.g(view, f4);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) AbstractC1726A.f14320b, f5);
        objectAnimatorOfFloat.addListener(new b(view));
        a(new a(view));
        return objectAnimatorOfFloat;
    }
}
