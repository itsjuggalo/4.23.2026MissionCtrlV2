package Z;

import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.ViewGroup;
import d.C0498b;

/* JADX INFO: renamed from: Z.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0266h extends Z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0264f f3841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnimatorSet f3842c;

    public C0266h(C0264f c0264f) {
        this.f3841b = c0264f;
    }

    @Override // Z.Z
    public final void a(ViewGroup container) {
        kotlin.jvm.internal.j.e(container, "container");
        AnimatorSet animatorSet = this.f3842c;
        animatorSet.getClass();
        animatorSet.start();
        if (P.K(2)) {
            Log.v("FragmentManager", "Animator from operation " + ((Object) null) + " has started.");
        }
    }

    @Override // Z.Z
    public final void b(C0498b backEvent, ViewGroup container) {
        kotlin.jvm.internal.j.e(backEvent, "backEvent");
        kotlin.jvm.internal.j.e(container, "container");
        this.f3842c.getClass();
        if (Build.VERSION.SDK_INT >= 34) {
            throw null;
        }
    }

    @Override // Z.Z
    public final void c(ViewGroup container) {
        kotlin.jvm.internal.j.e(container, "container");
        C0264f c0264f = this.f3841b;
        if (c0264f.O()) {
            return;
        }
        Context context = container.getContext();
        kotlin.jvm.internal.j.d(context, "context");
        Y3.d dVarP0 = c0264f.p0(context);
        this.f3842c = dVarP0 != null ? (AnimatorSet) dVarP0.f3630c : null;
        throw null;
    }
}
