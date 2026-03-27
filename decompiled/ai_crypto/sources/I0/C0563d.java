package I0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: I0.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0563d extends N {

    /* JADX INFO: renamed from: I0.d$a */
    public class a extends AbstractC0572m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f2769a;

        public a(View view) {
            this.f2769a = view;
        }

        @Override // I0.AbstractC0571l.f
        public void e(AbstractC0571l abstractC0571l) {
            A.g(this.f2769a, 1.0f);
            A.a(this.f2769a);
            abstractC0571l.P(this);
        }
    }

    /* JADX INFO: renamed from: I0.d$b */
    public static class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f2771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2772b = false;

        public b(View view) {
            this.f2771a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            A.g(this.f2771a, 1.0f);
            if (this.f2772b) {
                this.f2771a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (Q.N.L(this.f2771a) && this.f2771a.getLayerType() == 0) {
                this.f2772b = true;
                this.f2771a.setLayerType(2, null);
            }
        }
    }

    public C0563d(int i7) {
        i0(i7);
    }

    public static float k0(s sVar, float f7) {
        Float f8;
        return (sVar == null || (f8 = (Float) sVar.f2854a.get("android:fade:transitionAlpha")) == null) ? f7 : f8.floatValue();
    }

    @Override // I0.N
    public Animator f0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        float fK0 = k0(sVar, 0.0f);
        return j0(view, fK0 != 1.0f ? fK0 : 0.0f, 1.0f);
    }

    @Override // I0.N
    public Animator h0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        A.e(view);
        return j0(view, k0(sVar, 1.0f), 0.0f);
    }

    @Override // I0.N, I0.AbstractC0571l
    public void j(s sVar) {
        super.j(sVar);
        sVar.f2854a.put("android:fade:transitionAlpha", Float.valueOf(A.c(sVar.f2855b)));
    }

    public final Animator j0(View view, float f7, float f8) {
        if (f7 == f8) {
            return null;
        }
        A.g(view, f7);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) A.f2704b, f8);
        objectAnimatorOfFloat.addListener(new b(view));
        a(new a(view));
        return objectAnimatorOfFloat;
    }

    public C0563d() {
    }
}
