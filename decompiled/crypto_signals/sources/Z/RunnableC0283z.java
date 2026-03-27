package Z;

import D.ViewTreeObserverOnPreDrawListenerC0011k;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* JADX INFO: renamed from: Z.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0283z extends AnimationSet implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f3931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3934d;

    public RunnableC0283z(Animation animation, ViewGroup viewGroup) {
        super(false);
        this.f3934d = true;
        this.f3931a = viewGroup;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j4, Transformation transformation) {
        this.f3934d = true;
        if (this.f3932b) {
            return !this.f3933c;
        }
        if (!super.getTransformation(j4, transformation)) {
            this.f3932b = true;
            ViewTreeObserverOnPreDrawListenerC0011k.a(this.f3931a, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z6 = this.f3932b;
        ViewGroup viewGroup = this.f3931a;
        if (z6 || !this.f3934d) {
            viewGroup.endViewTransition(null);
            this.f3933c = true;
        } else {
            this.f3934d = false;
            viewGroup.post(this);
        }
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j4, Transformation transformation, float f6) {
        this.f3934d = true;
        if (this.f3932b) {
            return !this.f3933c;
        }
        if (!super.getTransformation(j4, transformation, f6)) {
            this.f3932b = true;
            ViewTreeObserverOnPreDrawListenerC0011k.a(this.f3931a, this);
        }
        return true;
    }
}
