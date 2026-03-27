package C0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: C0.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0445d extends N {

    /* JADX INFO: renamed from: C0.d$a */
    public class a extends AbstractC0454m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f491a;

        public a(View view) {
            this.f491a = view;
        }

        @Override // C0.AbstractC0453l.f
        public void d(AbstractC0453l abstractC0453l) {
            A.g(this.f491a, 1.0f);
            A.a(this.f491a);
            abstractC0453l.S(this);
        }
    }

    /* JADX INFO: renamed from: C0.d$b */
    public static class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f494b = false;

        public b(View view) {
            this.f493a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            A.g(this.f493a, 1.0f);
            if (this.f494b) {
                this.f493a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (T.D.x(this.f493a) && this.f493a.getLayerType() == 0) {
                this.f494b = true;
                this.f493a.setLayerType(2, null);
            }
        }
    }

    public C0445d(int i8) {
        l0(i8);
    }

    public static float n0(s sVar, float f8) {
        Float f9;
        return (sVar == null || (f9 = (Float) sVar.f576a.get("android:fade:transitionAlpha")) == null) ? f8 : f9.floatValue();
    }

    @Override // C0.N
    public Animator i0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        float fN0 = n0(sVar, 0.0f);
        return m0(view, fN0 != 1.0f ? fN0 : 0.0f, 1.0f);
    }

    @Override // C0.N
    public Animator k0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        A.e(view);
        return m0(view, n0(sVar, 1.0f), 0.0f);
    }

    @Override // C0.N, C0.AbstractC0453l
    public void l(s sVar) {
        super.l(sVar);
        sVar.f576a.put("android:fade:transitionAlpha", Float.valueOf(A.c(sVar.f577b)));
    }

    public final Animator m0(View view, float f8, float f9) {
        if (f8 == f9) {
            return null;
        }
        A.g(view, f8);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) A.f426b, f9);
        objectAnimatorOfFloat.addListener(new b(view));
        b(new a(view));
        return objectAnimatorOfFloat;
    }
}
