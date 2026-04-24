package androidx.fragment.app;

import H.ViewTreeObserverOnPreDrawListenerC0291z;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* JADX INFO: renamed from: androidx.fragment.app.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0833v {
    public static int a(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p, boolean z4, boolean z5) {
        return z5 ? z4 ? abstractComponentCallbacksC0828p.getPopEnterAnim() : abstractComponentCallbacksC0828p.getPopExitAnim() : z4 ? abstractComponentCallbacksC0828p.getEnterAnim() : abstractComponentCallbacksC0828p.getExitAnim();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0071 A[Catch: RuntimeException -> 0x0077, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0077, blocks: (B:32:0x006b, B:34:0x0071), top: B:45:0x006b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.fragment.app.AbstractC0833v.a b(android.content.Context r4, androidx.fragment.app.AbstractComponentCallbacksC0828p r5, boolean r6, boolean r7) {
        /*
            int r0 = r5.getNextTransition()
            int r7 = a(r5, r6, r7)
            r1 = 0
            r5.setAnimations(r1, r1, r1, r1)
            android.view.ViewGroup r1 = r5.mContainer
            r2 = 0
            if (r1 == 0) goto L20
            int r3 = X.b.f5521c
            java.lang.Object r1 = r1.getTag(r3)
            if (r1 == 0) goto L20
            android.view.ViewGroup r1 = r5.mContainer
            int r3 = X.b.f5521c
            r1.setTag(r3, r2)
        L20:
            android.view.ViewGroup r1 = r5.mContainer
            if (r1 == 0) goto L2b
            android.animation.LayoutTransition r1 = r1.getLayoutTransition()
            if (r1 == 0) goto L2b
            return r2
        L2b:
            android.view.animation.Animation r1 = r5.onCreateAnimation(r0, r6, r7)
            if (r1 == 0) goto L37
            androidx.fragment.app.v$a r4 = new androidx.fragment.app.v$a
            r4.<init>(r1)
            return r4
        L37:
            android.animation.Animator r5 = r5.onCreateAnimator(r0, r6, r7)
            if (r5 == 0) goto L43
            androidx.fragment.app.v$a r4 = new androidx.fragment.app.v$a
            r4.<init>(r5)
            return r4
        L43:
            if (r7 != 0) goto L4b
            if (r0 == 0) goto L4b
            int r7 = d(r4, r0, r6)
        L4b:
            if (r7 == 0) goto L87
            android.content.res.Resources r5 = r4.getResources()
            java.lang.String r5 = r5.getResourceTypeName(r7)
            java.lang.String r6 = "anim"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L6b
            android.view.animation.Animation r6 = android.view.animation.AnimationUtils.loadAnimation(r4, r7)     // Catch: android.content.res.Resources.NotFoundException -> L69 java.lang.RuntimeException -> L6b
            if (r6 == 0) goto L87
            androidx.fragment.app.v$a r0 = new androidx.fragment.app.v$a     // Catch: android.content.res.Resources.NotFoundException -> L69 java.lang.RuntimeException -> L6b
            r0.<init>(r6)     // Catch: android.content.res.Resources.NotFoundException -> L69 java.lang.RuntimeException -> L6b
            return r0
        L69:
            r4 = move-exception
            throw r4
        L6b:
            android.animation.Animator r6 = android.animation.AnimatorInflater.loadAnimator(r4, r7)     // Catch: java.lang.RuntimeException -> L77
            if (r6 == 0) goto L87
            androidx.fragment.app.v$a r0 = new androidx.fragment.app.v$a     // Catch: java.lang.RuntimeException -> L77
            r0.<init>(r6)     // Catch: java.lang.RuntimeException -> L77
            return r0
        L77:
            r6 = move-exception
            if (r5 != 0) goto L86
            android.view.animation.Animation r4 = android.view.animation.AnimationUtils.loadAnimation(r4, r7)
            if (r4 == 0) goto L87
            androidx.fragment.app.v$a r5 = new androidx.fragment.app.v$a
            r5.<init>(r4)
            return r5
        L86:
            throw r6
        L87:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.AbstractC0833v.b(android.content.Context, androidx.fragment.app.p, boolean, boolean):androidx.fragment.app.v$a");
    }

    public static int c(Context context, int i4) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i4});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int d(Context context, int i4, boolean z4) {
        if (i4 == 4097) {
            return z4 ? X.a.f5517e : X.a.f5518f;
        }
        if (i4 == 8194) {
            return z4 ? X.a.f5513a : X.a.f5514b;
        }
        if (i4 == 8197) {
            return z4 ? c(context, R.attr.activityCloseEnterAnimation) : c(context, R.attr.activityCloseExitAnimation);
        }
        if (i4 == 4099) {
            return z4 ? X.a.f5515c : X.a.f5516d;
        }
        if (i4 != 4100) {
            return -1;
        }
        return z4 ? c(context, R.attr.activityOpenEnterAnimation) : c(context, R.attr.activityOpenExitAnimation);
    }

    /* JADX INFO: renamed from: androidx.fragment.app.v$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animation f7602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AnimatorSet f7603b;

        public a(Animation animation) {
            this.f7602a = animation;
            this.f7603b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        public a(Animator animator) {
            this.f7602a = null;
            AnimatorSet animatorSet = new AnimatorSet();
            this.f7603b = animatorSet;
            animatorSet.play(animator);
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.v$b */
    public static class b extends AnimationSet implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f7604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f7605b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f7606c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f7607d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f7608e;

        public b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f7608e = true;
            this.f7604a = viewGroup;
            this.f7605b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j4, Transformation transformation) {
            this.f7608e = true;
            if (this.f7606c) {
                return !this.f7607d;
            }
            if (!super.getTransformation(j4, transformation)) {
                this.f7606c = true;
                ViewTreeObserverOnPreDrawListenerC0291z.a(this.f7604a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f7606c || !this.f7608e) {
                this.f7604a.endViewTransition(this.f7605b);
                this.f7607d = true;
            } else {
                this.f7608e = false;
                this.f7604a.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j4, Transformation transformation, float f4) {
            this.f7608e = true;
            if (this.f7606c) {
                return !this.f7607d;
            }
            if (!super.getTransformation(j4, transformation, f4)) {
                this.f7606c = true;
                ViewTreeObserverOnPreDrawListenerC0291z.a(this.f7604a, this);
            }
            return true;
        }
    }
}
