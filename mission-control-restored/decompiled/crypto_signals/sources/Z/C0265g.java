package Z;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;

/* JADX INFO: renamed from: Z.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0265g extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f3838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f3839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0266h f3840c;

    public C0265g(ViewGroup viewGroup, boolean z6, a0 a0Var, C0266h c0266h) {
        this.f3838a = viewGroup;
        this.f3839b = z6;
        this.f3840c = c0266h;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator anim) {
        kotlin.jvm.internal.j.e(anim, "anim");
        this.f3838a.endViewTransition(null);
        if (this.f3839b) {
            throw null;
        }
        C0264f c0264f = this.f3840c.f3841b;
        throw null;
    }
}
