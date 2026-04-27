package m0;

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
import l0.AbstractC2152a;

/* JADX INFO: renamed from: m0.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2222v {
    public static int a(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p, boolean z7, boolean z8) {
        return z8 ? z7 ? abstractComponentCallbacksC2216p.J() : abstractComponentCallbacksC2216p.K() : z7 ? abstractComponentCallbacksC2216p.u() : abstractComponentCallbacksC2216p.y();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0071 A[Catch: RuntimeException -> 0x0077, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0077, blocks: (B:32:0x006b, B:34:0x0071), top: B:45:0x006b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static m0.AbstractC2222v.a b(android.content.Context r4, m0.AbstractComponentCallbacksC2216p r5, boolean r6, boolean r7) {
        /*
            int r0 = r5.F()
            int r7 = a(r5, r6, r7)
            r1 = 0
            r5.v1(r1, r1, r1, r1)
            android.view.ViewGroup r1 = r5.f18843I
            r2 = 0
            if (r1 == 0) goto L20
            int r3 = l0.AbstractC2153b.f18283c
            java.lang.Object r1 = r1.getTag(r3)
            if (r1 == 0) goto L20
            android.view.ViewGroup r1 = r5.f18843I
            int r3 = l0.AbstractC2153b.f18283c
            r1.setTag(r3, r2)
        L20:
            android.view.ViewGroup r1 = r5.f18843I
            if (r1 == 0) goto L2b
            android.animation.LayoutTransition r1 = r1.getLayoutTransition()
            if (r1 == 0) goto L2b
            return r2
        L2b:
            android.view.animation.Animation r1 = r5.q0(r0, r6, r7)
            if (r1 == 0) goto L37
            m0.v$a r4 = new m0.v$a
            r4.<init>(r1)
            return r4
        L37:
            android.animation.Animator r5 = r5.r0(r0, r6, r7)
            if (r5 == 0) goto L43
            m0.v$a r4 = new m0.v$a
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
            m0.v$a r0 = new m0.v$a     // Catch: android.content.res.Resources.NotFoundException -> L69 java.lang.RuntimeException -> L6b
            r0.<init>(r6)     // Catch: android.content.res.Resources.NotFoundException -> L69 java.lang.RuntimeException -> L6b
            return r0
        L69:
            r4 = move-exception
            throw r4
        L6b:
            android.animation.Animator r6 = android.animation.AnimatorInflater.loadAnimator(r4, r7)     // Catch: java.lang.RuntimeException -> L77
            if (r6 == 0) goto L87
            m0.v$a r0 = new m0.v$a     // Catch: java.lang.RuntimeException -> L77
            r0.<init>(r6)     // Catch: java.lang.RuntimeException -> L77
            return r0
        L77:
            r6 = move-exception
            if (r5 != 0) goto L86
            android.view.animation.Animation r4 = android.view.animation.AnimationUtils.loadAnimation(r4, r7)
            if (r4 == 0) goto L87
            m0.v$a r5 = new m0.v$a
            r5.<init>(r4)
            return r5
        L86:
            throw r6
        L87:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: m0.AbstractC2222v.b(android.content.Context, m0.p, boolean, boolean):m0.v$a");
    }

    public static int c(Context context, int i7) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i7});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int d(Context context, int i7, boolean z7) {
        if (i7 == 4097) {
            return z7 ? AbstractC2152a.f18279e : AbstractC2152a.f18280f;
        }
        if (i7 == 8194) {
            return z7 ? AbstractC2152a.f18275a : AbstractC2152a.f18276b;
        }
        if (i7 == 8197) {
            return z7 ? c(context, R.attr.activityCloseEnterAnimation) : c(context, R.attr.activityCloseExitAnimation);
        }
        if (i7 == 4099) {
            return z7 ? AbstractC2152a.f18277c : AbstractC2152a.f18278d;
        }
        if (i7 != 4100) {
            return -1;
        }
        return z7 ? c(context, R.attr.activityOpenEnterAnimation) : c(context, R.attr.activityOpenExitAnimation);
    }

    /* JADX INFO: renamed from: m0.v$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animation f18927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AnimatorSet f18928b;

        public a(Animation animation) {
            this.f18927a = animation;
            this.f18928b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        public a(Animator animator) {
            this.f18927a = null;
            AnimatorSet animatorSet = new AnimatorSet();
            this.f18928b = animatorSet;
            animatorSet.play(animator);
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* JADX INFO: renamed from: m0.v$b */
    public static class b extends AnimationSet implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f18929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f18930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f18931c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f18932d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f18933e;

        public b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f18933e = true;
            this.f18929a = viewGroup;
            this.f18930b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j7, Transformation transformation) {
            this.f18933e = true;
            if (this.f18931c) {
                return !this.f18932d;
            }
            if (!super.getTransformation(j7, transformation)) {
                this.f18931c = true;
                Q.I.a(this.f18929a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f18931c || !this.f18933e) {
                this.f18929a.endViewTransition(this.f18930b);
                this.f18932d = true;
            } else {
                this.f18933e = false;
                this.f18929a.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j7, Transformation transformation, float f7) {
            this.f18933e = true;
            if (this.f18931c) {
                return !this.f18932d;
            }
            if (!super.getTransformation(j7, transformation, f7)) {
                this.f18931c = true;
                Q.I.a(this.f18929a, this);
            }
            return true;
        }
    }
}
