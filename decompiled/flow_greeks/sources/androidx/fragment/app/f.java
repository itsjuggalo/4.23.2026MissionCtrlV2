package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.f;
import androidx.fragment.app.v;
import androidx.fragment.app.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends y0 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends y0.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f2057d;

        /* JADX INFO: renamed from: androidx.fragment.app.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class AnimationAnimationListenerC0027a implements Animation.AnimationListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ y0.d f2058a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ViewGroup f2059b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ View f2060c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ a f2061d;

            public AnimationAnimationListenerC0027a(y0.d dVar, ViewGroup viewGroup, View view, a aVar) {
                this.f2058a = dVar;
                this.f2059b = viewGroup;
                this.f2060c = view;
                this.f2061d = aVar;
            }

            public static final void b(ViewGroup container, View view, a this$0) {
                kotlin.jvm.internal.t.f(container, "$container");
                kotlin.jvm.internal.t.f(this$0, "this$0");
                container.endViewTransition(view);
                this$0.h().a().f(this$0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                kotlin.jvm.internal.t.f(animation, "animation");
                final ViewGroup viewGroup = this.f2059b;
                final View view = this.f2060c;
                final a aVar = this.f2061d;
                viewGroup.post(new Runnable() { // from class: androidx.fragment.app.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.a.AnimationAnimationListenerC0027a.b(viewGroup, view, aVar);
                    }
                });
                if (i0.J0(2)) {
                    Log.v("FragmentManager", "Animation from operation " + this.f2058a + " has ended.");
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                kotlin.jvm.internal.t.f(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                kotlin.jvm.internal.t.f(animation, "animation");
                if (i0.J0(2)) {
                    Log.v("FragmentManager", "Animation from operation " + this.f2058a + " has reached onAnimationStart.");
                }
            }
        }

        public a(b animationInfo) {
            kotlin.jvm.internal.t.f(animationInfo, "animationInfo");
            this.f2057d = animationInfo;
        }

        @Override // androidx.fragment.app.y0.b
        public void c(ViewGroup container) {
            kotlin.jvm.internal.t.f(container, "container");
            y0.d dVarA = this.f2057d.a();
            View view = dVarA.i().mView;
            view.clearAnimation();
            container.endViewTransition(view);
            this.f2057d.a().f(this);
            if (i0.J0(2)) {
                Log.v("FragmentManager", "Animation from operation " + dVarA + " has been cancelled.");
            }
        }

        @Override // androidx.fragment.app.y0.b
        public void d(ViewGroup container) {
            kotlin.jvm.internal.t.f(container, "container");
            if (this.f2057d.b()) {
                this.f2057d.a().f(this);
                return;
            }
            Context context = container.getContext();
            y0.d dVarA = this.f2057d.a();
            View view = dVarA.i().mView;
            b bVar = this.f2057d;
            kotlin.jvm.internal.t.e(context, "context");
            v.a aVarC = bVar.c(context);
            if (aVarC == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Animation animation = aVarC.f2330a;
            if (animation == null) {
                throw new IllegalStateException("Required value was null.");
            }
            if (dVarA.h() != y0.d.b.REMOVED) {
                view.startAnimation(animation);
                this.f2057d.a().f(this);
                return;
            }
            container.startViewTransition(view);
            v.b bVar2 = new v.b(animation, container, view);
            bVar2.setAnimationListener(new AnimationAnimationListenerC0027a(dVarA, container, view, this));
            view.startAnimation(bVar2);
            if (i0.J0(2)) {
                Log.v("FragmentManager", "Animation from operation " + dVarA + " has started.");
            }
        }

        public final b h() {
            return this.f2057d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends C0028f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f2062b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2063c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public v.a f2064d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(y0.d operation, boolean z10) {
            super(operation);
            kotlin.jvm.internal.t.f(operation, "operation");
            this.f2062b = z10;
        }

        public final v.a c(Context context) {
            kotlin.jvm.internal.t.f(context, "context");
            if (this.f2063c) {
                return this.f2064d;
            }
            v.a aVarB = v.b(context, a().i(), a().h() == y0.d.b.VISIBLE, this.f2062b);
            this.f2064d = aVarB;
            this.f2063c = true;
            return aVarB;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends y0.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f2065d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public AnimatorSet f2066e;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ViewGroup f2067a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f2068b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ boolean f2069c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ y0.d f2070d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ c f2071e;

            public a(ViewGroup viewGroup, View view, boolean z10, y0.d dVar, c cVar) {
                this.f2067a = viewGroup;
                this.f2068b = view;
                this.f2069c = z10;
                this.f2070d = dVar;
                this.f2071e = cVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator anim) {
                kotlin.jvm.internal.t.f(anim, "anim");
                this.f2067a.endViewTransition(this.f2068b);
                if (this.f2069c) {
                    y0.d.b bVarH = this.f2070d.h();
                    View viewToAnimate = this.f2068b;
                    kotlin.jvm.internal.t.e(viewToAnimate, "viewToAnimate");
                    bVarH.b(viewToAnimate, this.f2067a);
                }
                this.f2071e.h().a().f(this.f2071e);
                if (i0.J0(2)) {
                    Log.v("FragmentManager", "Animator from operation " + this.f2070d + " has ended.");
                }
            }
        }

        public c(b animatorInfo) {
            kotlin.jvm.internal.t.f(animatorInfo, "animatorInfo");
            this.f2065d = animatorInfo;
        }

        @Override // androidx.fragment.app.y0.b
        public boolean b() {
            return true;
        }

        @Override // androidx.fragment.app.y0.b
        public void c(ViewGroup container) {
            kotlin.jvm.internal.t.f(container, "container");
            AnimatorSet animatorSet = this.f2066e;
            if (animatorSet == null) {
                this.f2065d.a().f(this);
                return;
            }
            y0.d dVarA = this.f2065d.a();
            if (!dVarA.n()) {
                animatorSet.end();
            } else if (Build.VERSION.SDK_INT >= 26) {
                e.f2073a.a(animatorSet);
            }
            if (i0.J0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Animator from operation ");
                sb2.append(dVarA);
                sb2.append(" has been canceled");
                sb2.append(dVarA.n() ? " with seeking." : ".");
                sb2.append(' ');
                Log.v("FragmentManager", sb2.toString());
            }
        }

        @Override // androidx.fragment.app.y0.b
        public void d(ViewGroup container) {
            kotlin.jvm.internal.t.f(container, "container");
            y0.d dVarA = this.f2065d.a();
            AnimatorSet animatorSet = this.f2066e;
            if (animatorSet == null) {
                this.f2065d.a().f(this);
                return;
            }
            animatorSet.start();
            if (i0.J0(2)) {
                Log.v("FragmentManager", "Animator from operation " + dVarA + " has started.");
            }
        }

        @Override // androidx.fragment.app.y0.b
        public void e(androidx.activity.b backEvent, ViewGroup container) {
            kotlin.jvm.internal.t.f(backEvent, "backEvent");
            kotlin.jvm.internal.t.f(container, "container");
            y0.d dVarA = this.f2065d.a();
            AnimatorSet animatorSet = this.f2066e;
            if (animatorSet == null) {
                this.f2065d.a().f(this);
                return;
            }
            if (Build.VERSION.SDK_INT < 34 || !dVarA.i().mTransitioning) {
                return;
            }
            if (i0.J0(2)) {
                Log.v("FragmentManager", "Adding BackProgressCallbacks for Animators to operation " + dVarA);
            }
            long jA = d.f2072a.a(animatorSet);
            long jA2 = (long) (backEvent.a() * jA);
            if (jA2 == 0) {
                jA2 = 1;
            }
            if (jA2 == jA) {
                jA2 = jA - 1;
            }
            if (i0.J0(2)) {
                Log.v("FragmentManager", "Setting currentPlayTime to " + jA2 + " for Animator " + animatorSet + " on operation " + dVarA);
            }
            e.f2073a.b(animatorSet, jA2);
        }

        @Override // androidx.fragment.app.y0.b
        public void f(ViewGroup container) {
            c cVar;
            kotlin.jvm.internal.t.f(container, "container");
            if (this.f2065d.b()) {
                return;
            }
            Context context = container.getContext();
            b bVar = this.f2065d;
            kotlin.jvm.internal.t.e(context, "context");
            v.a aVarC = bVar.c(context);
            this.f2066e = aVarC != null ? aVarC.f2331b : null;
            y0.d dVarA = this.f2065d.a();
            p pVarI = dVarA.i();
            boolean z10 = dVarA.h() == y0.d.b.GONE;
            View view = pVarI.mView;
            container.startViewTransition(view);
            AnimatorSet animatorSet = this.f2066e;
            if (animatorSet != null) {
                cVar = this;
                animatorSet.addListener(new a(container, view, z10, dVarA, cVar));
            } else {
                cVar = this;
            }
            AnimatorSet animatorSet2 = cVar.f2066e;
            if (animatorSet2 != null) {
                animatorSet2.setTarget(view);
            }
        }

        public final b h() {
            return this.f2065d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f2072a = new d();

        public final long a(AnimatorSet animatorSet) {
            kotlin.jvm.internal.t.f(animatorSet, "animatorSet");
            return animatorSet.getTotalDuration();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f2073a = new e();

        public final void a(AnimatorSet animatorSet) {
            kotlin.jvm.internal.t.f(animatorSet, "animatorSet");
            animatorSet.reverse();
        }

        public final void b(AnimatorSet animatorSet, long j10) {
            kotlin.jvm.internal.t.f(animatorSet, "animatorSet");
            animatorSet.setCurrentPlayTime(j10);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0028f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y0.d f2074a;

        public C0028f(y0.d operation) {
            kotlin.jvm.internal.t.f(operation, "operation");
            this.f2074a = operation;
        }

        public final y0.d a() {
            return this.f2074a;
        }

        public final boolean b() {
            View view = this.f2074a.i().mView;
            y0.d.b bVarA = view != null ? y0.d.b.f2374a.a(view) : null;
            y0.d.b bVarH = this.f2074a.h();
            if (bVarA == bVarH) {
                return true;
            }
            y0.d.b bVar = y0.d.b.VISIBLE;
            return (bVarA == bVar || bVarH == bVar) ? false : true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class g extends y0.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f2075d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final y0.d f2076e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final y0.d f2077f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final t0 f2078g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Object f2079h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ArrayList f2080i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final ArrayList f2081j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final w.a f2082k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final ArrayList f2083l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final ArrayList f2084m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final w.a f2085n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final w.a f2086o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final boolean f2087p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final p0.c f2088q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Object f2089r;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends kotlin.jvm.internal.v implements Function0 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ViewGroup f2091b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Object f2092c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ViewGroup viewGroup, Object obj) {
                super(0);
                this.f2091b = viewGroup;
                this.f2092c = obj;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m12invoke();
                return cd.h0.f3852a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m12invoke() {
                g.this.v().e(this.f2091b, this.f2092c);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class b extends kotlin.jvm.internal.v implements Function0 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ViewGroup f2094b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Object f2095c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ kotlin.jvm.internal.m0 f2096d;

            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static final class a extends kotlin.jvm.internal.v implements Function0 {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ g f2097a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ ViewGroup f2098b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(g gVar, ViewGroup viewGroup) {
                    super(0);
                    this.f2097a = gVar;
                    this.f2098b = viewGroup;
                }

                public static final void b(g this$0, ViewGroup container) {
                    kotlin.jvm.internal.t.f(this$0, "this$0");
                    kotlin.jvm.internal.t.f(container, "$container");
                    Iterator it = this$0.w().iterator();
                    while (it.hasNext()) {
                        y0.d dVarA = ((h) it.next()).a();
                        View view = dVarA.i().getView();
                        if (view != null) {
                            dVarA.h().b(view, container);
                        }
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m14invoke();
                    return cd.h0.f3852a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m14invoke() {
                    if (i0.J0(2)) {
                        Log.v("FragmentManager", "Animating to start");
                    }
                    t0 t0VarV = this.f2097a.v();
                    Object objS = this.f2097a.s();
                    kotlin.jvm.internal.t.c(objS);
                    final g gVar = this.f2097a;
                    final ViewGroup viewGroup = this.f2098b;
                    t0VarV.d(objS, new Runnable() { // from class: androidx.fragment.app.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.g.b.a.b(gVar, viewGroup);
                        }
                    });
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(ViewGroup viewGroup, Object obj, kotlin.jvm.internal.m0 m0Var) {
                super(0);
                this.f2094b = viewGroup;
                this.f2095c = obj;
                this.f2096d = m0Var;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m13invoke();
                return cd.h0.f3852a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m13invoke() {
                g gVar = g.this;
                gVar.C(gVar.v().j(this.f2094b, this.f2095c));
                boolean z10 = g.this.s() != null;
                Object obj = this.f2095c;
                ViewGroup viewGroup = this.f2094b;
                if (!z10) {
                    throw new IllegalStateException(("Unable to start transition " + obj + " for container " + viewGroup + com.amazon.a.a.o.c.a.b.f4610a).toString());
                }
                this.f2096d.f14947a = new a(g.this, viewGroup);
                if (i0.J0(2)) {
                    Log.v("FragmentManager", "Started executing operations from " + g.this.t() + " to " + g.this.u());
                }
            }
        }

        public g(List transitionInfos, y0.d dVar, y0.d dVar2, t0 transitionImpl, Object obj, ArrayList sharedElementFirstOutViews, ArrayList sharedElementLastInViews, w.a sharedElementNameMapping, ArrayList enteringNames, ArrayList exitingNames, w.a firstOutViews, w.a lastInViews, boolean z10) {
            kotlin.jvm.internal.t.f(transitionInfos, "transitionInfos");
            kotlin.jvm.internal.t.f(transitionImpl, "transitionImpl");
            kotlin.jvm.internal.t.f(sharedElementFirstOutViews, "sharedElementFirstOutViews");
            kotlin.jvm.internal.t.f(sharedElementLastInViews, "sharedElementLastInViews");
            kotlin.jvm.internal.t.f(sharedElementNameMapping, "sharedElementNameMapping");
            kotlin.jvm.internal.t.f(enteringNames, "enteringNames");
            kotlin.jvm.internal.t.f(exitingNames, "exitingNames");
            kotlin.jvm.internal.t.f(firstOutViews, "firstOutViews");
            kotlin.jvm.internal.t.f(lastInViews, "lastInViews");
            this.f2075d = transitionInfos;
            this.f2076e = dVar;
            this.f2077f = dVar2;
            this.f2078g = transitionImpl;
            this.f2079h = obj;
            this.f2080i = sharedElementFirstOutViews;
            this.f2081j = sharedElementLastInViews;
            this.f2082k = sharedElementNameMapping;
            this.f2083l = enteringNames;
            this.f2084m = exitingNames;
            this.f2085n = firstOutViews;
            this.f2086o = lastInViews;
            this.f2087p = z10;
            this.f2088q = new p0.c();
        }

        public static final void A(y0.d operation, g this$0) {
            kotlin.jvm.internal.t.f(operation, "$operation");
            kotlin.jvm.internal.t.f(this$0, "this$0");
            if (i0.J0(2)) {
                Log.v("FragmentManager", "Transition for operation " + operation + " has completed");
            }
            operation.f(this$0);
        }

        public static final void p(y0.d dVar, y0.d dVar2, g this$0) {
            kotlin.jvm.internal.t.f(this$0, "this$0");
            r0.a(dVar.i(), dVar2.i(), this$0.f2087p, this$0.f2086o, false);
        }

        public static final void q(t0 impl, View view, Rect lastInEpicenterRect) {
            kotlin.jvm.internal.t.f(impl, "$impl");
            kotlin.jvm.internal.t.f(lastInEpicenterRect, "$lastInEpicenterRect");
            impl.k(view, lastInEpicenterRect);
        }

        public static final void r(ArrayList transitioningViews) {
            kotlin.jvm.internal.t.f(transitioningViews, "$transitioningViews");
            r0.d(transitioningViews, 4);
        }

        public static final void y(y0.d operation, g this$0) {
            kotlin.jvm.internal.t.f(operation, "$operation");
            kotlin.jvm.internal.t.f(this$0, "this$0");
            if (i0.J0(2)) {
                Log.v("FragmentManager", "Transition for operation " + operation + " has completed");
            }
            operation.f(this$0);
        }

        public static final void z(kotlin.jvm.internal.m0 seekCancelLambda) {
            kotlin.jvm.internal.t.f(seekCancelLambda, "$seekCancelLambda");
            Function0 function0 = (Function0) seekCancelLambda.f14947a;
            if (function0 != null) {
                function0.invoke();
            }
        }

        public final void B(ArrayList arrayList, ViewGroup viewGroup, Function0 function0) {
            r0.d(arrayList, 4);
            ArrayList arrayListQ = this.f2078g.q(this.f2081j);
            if (i0.J0(2)) {
                Log.v("FragmentManager", ">>>>> Beginning transition <<<<<");
                Log.v("FragmentManager", ">>>>> SharedElementFirstOutViews <<<<<");
                for (Object sharedElementFirstOutViews : this.f2080i) {
                    kotlin.jvm.internal.t.e(sharedElementFirstOutViews, "sharedElementFirstOutViews");
                    View view = (View) sharedElementFirstOutViews;
                    Log.v("FragmentManager", "View: " + view + " Name: " + t0.c0.v(view));
                }
                Log.v("FragmentManager", ">>>>> SharedElementLastInViews <<<<<");
                for (Object sharedElementLastInViews : this.f2081j) {
                    kotlin.jvm.internal.t.e(sharedElementLastInViews, "sharedElementLastInViews");
                    View view2 = (View) sharedElementLastInViews;
                    Log.v("FragmentManager", "View: " + view2 + " Name: " + t0.c0.v(view2));
                }
            }
            function0.invoke();
            this.f2078g.y(viewGroup, this.f2080i, this.f2081j, arrayListQ, this.f2082k);
            r0.d(arrayList, 0);
            this.f2078g.A(this.f2079h, this.f2080i, this.f2081j);
        }

        public final void C(Object obj) {
            this.f2089r = obj;
        }

        @Override // androidx.fragment.app.y0.b
        public boolean b() {
            if (!this.f2078g.m()) {
                return false;
            }
            List<h> list = this.f2075d;
            if (list == null || !list.isEmpty()) {
                for (h hVar : list) {
                    if (Build.VERSION.SDK_INT < 34 || hVar.f() == null || !this.f2078g.n(hVar.f())) {
                        return false;
                    }
                }
            }
            Object obj = this.f2079h;
            return obj == null || this.f2078g.n(obj);
        }

        @Override // androidx.fragment.app.y0.b
        public void c(ViewGroup container) {
            kotlin.jvm.internal.t.f(container, "container");
            this.f2088q.a();
        }

        @Override // androidx.fragment.app.y0.b
        public void d(ViewGroup container) {
            kotlin.jvm.internal.t.f(container, "container");
            if (!container.isLaidOut()) {
                for (h hVar : this.f2075d) {
                    y0.d dVarA = hVar.a();
                    if (i0.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Container " + container + " has not been laid out. Completing operation " + dVarA);
                    }
                    hVar.a().f(this);
                }
                return;
            }
            Object obj = this.f2089r;
            if (obj != null) {
                t0 t0Var = this.f2078g;
                kotlin.jvm.internal.t.c(obj);
                t0Var.c(obj);
                if (i0.J0(2)) {
                    Log.v("FragmentManager", "Ending execution of operations from " + this.f2076e + " to " + this.f2077f);
                    return;
                }
                return;
            }
            cd.q qVarO = o(container, this.f2077f, this.f2076e);
            ArrayList arrayList = (ArrayList) qVarO.a();
            Object objB = qVarO.b();
            List list = this.f2075d;
            ArrayList<y0.d> arrayList2 = new ArrayList(dd.s.u(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(((h) it.next()).a());
            }
            for (final y0.d dVar : arrayList2) {
                this.f2078g.w(dVar.i(), objB, this.f2088q, new Runnable() { // from class: androidx.fragment.app.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.g.y(dVar, this);
                    }
                });
            }
            B(arrayList, container, new a(container, objB));
            if (i0.J0(2)) {
                Log.v("FragmentManager", "Completed executing operations from " + this.f2076e + " to " + this.f2077f);
            }
        }

        @Override // androidx.fragment.app.y0.b
        public void e(androidx.activity.b backEvent, ViewGroup container) {
            kotlin.jvm.internal.t.f(backEvent, "backEvent");
            kotlin.jvm.internal.t.f(container, "container");
            Object obj = this.f2089r;
            if (obj != null) {
                this.f2078g.t(obj, backEvent.a());
            }
        }

        @Override // androidx.fragment.app.y0.b
        public void f(ViewGroup container) {
            kotlin.jvm.internal.t.f(container, "container");
            if (!container.isLaidOut()) {
                Iterator it = this.f2075d.iterator();
                while (it.hasNext()) {
                    y0.d dVarA = ((h) it.next()).a();
                    if (i0.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Container " + container + " has not been laid out. Skipping onStart for operation " + dVarA);
                    }
                }
                return;
            }
            if (x() && this.f2079h != null && !b()) {
                Log.i("FragmentManager", "Ignoring shared elements transition " + this.f2079h + " between " + this.f2076e + " and " + this.f2077f + " as neither fragment has set a Transition. In order to run a SharedElementTransition, you must also set either an enter or exit transition on a fragment involved in the transaction. The sharedElementTransition will run after the back gesture has been committed.");
            }
            if (b() && x()) {
                final kotlin.jvm.internal.m0 m0Var = new kotlin.jvm.internal.m0();
                cd.q qVarO = o(container, this.f2077f, this.f2076e);
                ArrayList arrayList = (ArrayList) qVarO.a();
                Object objB = qVarO.b();
                List list = this.f2075d;
                ArrayList<y0.d> arrayList2 = new ArrayList(dd.s.u(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((h) it2.next()).a());
                }
                for (final y0.d dVar : arrayList2) {
                    this.f2078g.x(dVar.i(), objB, this.f2088q, new Runnable() { // from class: androidx.fragment.app.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.g.z(m0Var);
                        }
                    }, new Runnable() { // from class: androidx.fragment.app.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.g.A(dVar, this);
                        }
                    });
                }
                B(arrayList, container, new b(container, objB, m0Var));
            }
        }

        public final void n(ArrayList arrayList, View view) {
            if (!(view instanceof ViewGroup)) {
                if (arrayList.contains(view)) {
                    return;
                }
                arrayList.add(view);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (t0.h0.c(viewGroup)) {
                if (arrayList.contains(view)) {
                    return;
                }
                arrayList.add(view);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View child = viewGroup.getChildAt(i10);
                if (child.getVisibility() == 0) {
                    kotlin.jvm.internal.t.e(child, "child");
                    n(arrayList, child);
                }
            }
        }

        public final cd.q o(ViewGroup viewGroup, y0.d dVar, final y0.d dVar2) {
            final y0.d dVar3 = dVar;
            View view = new View(viewGroup.getContext());
            final Rect rect = new Rect();
            Iterator it = this.f2075d.iterator();
            boolean z10 = false;
            View view2 = null;
            while (it.hasNext()) {
                if (((h) it.next()).g() && dVar2 != null && dVar3 != null && !this.f2082k.isEmpty() && this.f2079h != null) {
                    r0.a(dVar3.i(), dVar2.i(), this.f2087p, this.f2085n, true);
                    t0.w.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.g.p(dVar3, dVar2, this);
                        }
                    });
                    this.f2080i.addAll(this.f2085n.values());
                    if (!this.f2084m.isEmpty()) {
                        Object obj = this.f2084m.get(0);
                        kotlin.jvm.internal.t.e(obj, "exitingNames[0]");
                        view2 = (View) this.f2085n.get((String) obj);
                        this.f2078g.v(this.f2079h, view2);
                    }
                    this.f2081j.addAll(this.f2086o.values());
                    if (!this.f2083l.isEmpty()) {
                        Object obj2 = this.f2083l.get(0);
                        kotlin.jvm.internal.t.e(obj2, "enteringNames[0]");
                        final View view3 = (View) this.f2086o.get((String) obj2);
                        if (view3 != null) {
                            final t0 t0Var = this.f2078g;
                            t0.w.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.k
                                @Override // java.lang.Runnable
                                public final void run() {
                                    f.g.q(t0Var, view3, rect);
                                }
                            });
                            z10 = true;
                        }
                    }
                    this.f2078g.z(this.f2079h, view, this.f2080i);
                    t0 t0Var2 = this.f2078g;
                    Object obj3 = this.f2079h;
                    t0Var2.s(obj3, null, null, null, null, obj3, this.f2081j);
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = this.f2075d.iterator();
            Object objP = null;
            Object objP2 = null;
            while (it2.hasNext()) {
                h hVar = (h) it2.next();
                y0.d dVarA = hVar.a();
                boolean z11 = z10;
                Object objH = this.f2078g.h(hVar.f());
                if (objH != null) {
                    final ArrayList arrayList2 = new ArrayList();
                    Iterator it3 = it2;
                    View view4 = dVarA.i().mView;
                    kotlin.jvm.internal.t.e(view4, "operation.fragment.mView");
                    n(arrayList2, view4);
                    if (this.f2079h != null && (dVarA == dVar2 || dVarA == dVar3)) {
                        if (dVarA == dVar2) {
                            arrayList2.removeAll(dd.a0.N0(this.f2080i));
                        } else {
                            arrayList2.removeAll(dd.a0.N0(this.f2081j));
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        this.f2078g.a(objH, view);
                    } else {
                        this.f2078g.b(objH, arrayList2);
                        this.f2078g.s(objH, objH, arrayList2, null, null, null, null);
                        if (dVarA.h() == y0.d.b.GONE) {
                            dVarA.r(false);
                            ArrayList arrayList3 = new ArrayList(arrayList2);
                            arrayList3.remove(dVarA.i().mView);
                            this.f2078g.r(objH, dVarA.i().mView, arrayList3);
                            t0.w.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.l
                                @Override // java.lang.Runnable
                                public final void run() {
                                    f.g.r(arrayList2);
                                }
                            });
                        }
                    }
                    if (dVarA.h() == y0.d.b.VISIBLE) {
                        arrayList.addAll(arrayList2);
                        if (z11) {
                            this.f2078g.u(objH, rect);
                        }
                        if (i0.J0(2)) {
                            Log.v("FragmentManager", "Entering Transition: " + objH);
                            Log.v("FragmentManager", ">>>>> EnteringViews <<<<<");
                            for (Object transitioningViews : arrayList2) {
                                kotlin.jvm.internal.t.e(transitioningViews, "transitioningViews");
                                Log.v("FragmentManager", "View: " + ((View) transitioningViews));
                            }
                        }
                    } else {
                        this.f2078g.v(objH, view2);
                        if (i0.J0(2)) {
                            Log.v("FragmentManager", "Exiting Transition: " + objH);
                            Log.v("FragmentManager", ">>>>> ExitingViews <<<<<");
                            for (Object transitioningViews2 : arrayList2) {
                                kotlin.jvm.internal.t.e(transitioningViews2, "transitioningViews");
                                Log.v("FragmentManager", "View: " + ((View) transitioningViews2));
                            }
                        }
                    }
                    if (hVar.h()) {
                        objP = this.f2078g.p(objP, objH, null);
                    } else {
                        objP2 = this.f2078g.p(objP2, objH, null);
                    }
                    dVar3 = dVar;
                    z10 = z11;
                    it2 = it3;
                } else {
                    dVar3 = dVar;
                    z10 = z11;
                }
            }
            Object objO = this.f2078g.o(objP, objP2, this.f2079h);
            if (i0.J0(2)) {
                Log.v("FragmentManager", "Final merged transition: " + objO);
            }
            return new cd.q(arrayList, objO);
        }

        public final Object s() {
            return this.f2089r;
        }

        public final y0.d t() {
            return this.f2076e;
        }

        public final y0.d u() {
            return this.f2077f;
        }

        public final t0 v() {
            return this.f2078g;
        }

        public final List w() {
            return this.f2075d;
        }

        public final boolean x() {
            List list = this.f2075d;
            if (list != null && list.isEmpty()) {
                return true;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (!((h) it.next()).a().i().mTransitioning) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class h extends C0028f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f2099b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f2100c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f2101d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(y0.d operation, boolean z10, boolean z11) {
            Object returnTransition;
            super(operation);
            kotlin.jvm.internal.t.f(operation, "operation");
            y0.d.b bVarH = operation.h();
            y0.d.b bVar = y0.d.b.VISIBLE;
            if (bVarH == bVar) {
                p pVarI = operation.i();
                returnTransition = z10 ? pVarI.getReenterTransition() : pVarI.getEnterTransition();
            } else {
                p pVarI2 = operation.i();
                returnTransition = z10 ? pVarI2.getReturnTransition() : pVarI2.getExitTransition();
            }
            this.f2099b = returnTransition;
            this.f2100c = operation.h() == bVar ? z10 ? operation.i().getAllowReturnTransitionOverlap() : operation.i().getAllowEnterTransitionOverlap() : true;
            this.f2101d = z11 ? z10 ? operation.i().getSharedElementReturnTransition() : operation.i().getSharedElementEnterTransition() : null;
        }

        public final t0 c() {
            t0 t0VarD = d(this.f2099b);
            t0 t0VarD2 = d(this.f2101d);
            if (t0VarD == null || t0VarD2 == null || t0VarD == t0VarD2) {
                return t0VarD == null ? t0VarD2 : t0VarD;
            }
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + a().i() + " returned Transition " + this.f2099b + " which uses a different Transition  type than its shared element transition " + this.f2101d).toString());
        }

        public final t0 d(Object obj) {
            if (obj == null) {
                return null;
            }
            t0 t0Var = r0.f2298b;
            if (t0Var != null && t0Var.g(obj)) {
                return t0Var;
            }
            t0 t0Var2 = r0.f2299c;
            if (t0Var2 != null && t0Var2.g(obj)) {
                return t0Var2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + a().i() + " is not a valid framework Transition or AndroidX Transition");
        }

        public final Object e() {
            return this.f2101d;
        }

        public final Object f() {
            return this.f2099b;
        }

        public final boolean g() {
            return this.f2101d != null;
        }

        public final boolean h() {
            return this.f2100c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class i extends kotlin.jvm.internal.v implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Collection f2102a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Collection collection) {
            super(1);
            this.f2102a = collection;
        }

        @Override // pd.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Map.Entry entry) {
            kotlin.jvm.internal.t.f(entry, "entry");
            return Boolean.valueOf(dd.a0.R(this.f2102a, t0.c0.v((View) entry.getValue())));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(ViewGroup container) {
        super(container);
        kotlin.jvm.internal.t.f(container, "container");
    }

    public static final void E(f this$0, y0.d operation) {
        kotlin.jvm.internal.t.f(this$0, "this$0");
        kotlin.jvm.internal.t.f(operation, "$operation");
        this$0.c(operation);
    }

    public final void D(List list) {
        ArrayList<b> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            dd.w.z(arrayList2, ((b) it.next()).a().g());
        }
        boolean zIsEmpty = arrayList2.isEmpty();
        Iterator it2 = list.iterator();
        boolean z10 = false;
        while (it2.hasNext()) {
            b bVar = (b) it2.next();
            Context context = t().getContext();
            y0.d dVarA = bVar.a();
            kotlin.jvm.internal.t.e(context, "context");
            v.a aVarC = bVar.c(context);
            if (aVarC != null) {
                if (aVarC.f2331b == null) {
                    arrayList.add(bVar);
                } else {
                    p pVarI = dVarA.i();
                    if (dVarA.g().isEmpty()) {
                        if (dVarA.h() == y0.d.b.GONE) {
                            dVarA.r(false);
                        }
                        dVarA.b(new c(bVar));
                        z10 = true;
                    } else if (i0.J0(2)) {
                        Log.v("FragmentManager", "Ignoring Animator set on " + pVarI + " as this Fragment was involved in a Transition.");
                    }
                }
            }
        }
        for (b bVar2 : arrayList) {
            y0.d dVarA2 = bVar2.a();
            p pVarI2 = dVarA2.i();
            if (zIsEmpty) {
                if (!z10) {
                    dVarA2.b(new a(bVar2));
                } else if (i0.J0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + pVarI2 + " as Animations cannot run alongside Animators.");
                }
            } else if (i0.J0(2)) {
                Log.v("FragmentManager", "Ignoring Animation set on " + pVarI2 + " as Animations cannot run alongside Transitions.");
            }
        }
    }

    public final void F(List list, boolean z10, y0.d dVar, y0.d dVar2) {
        Object objB;
        Iterator it;
        ArrayList arrayList;
        cd.q qVarA;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (!((h) obj).b()) {
                arrayList2.add(obj);
            }
        }
        ArrayList<h> arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            if (((h) obj2).c() != null) {
                arrayList3.add(obj2);
            }
        }
        t0 t0Var = null;
        for (h hVar : arrayList3) {
            t0 t0VarC = hVar.c();
            if (t0Var != null && t0VarC != t0Var) {
                throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + hVar.a().i() + " returned Transition " + hVar.f() + " which uses a different Transition type than other Fragments.").toString());
            }
            t0Var = t0VarC;
        }
        if (t0Var == null) {
            return;
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        w.a aVar = new w.a();
        ArrayList<String> arrayList6 = new ArrayList<>();
        ArrayList<String> arrayList7 = new ArrayList<>();
        w.a aVar2 = new w.a();
        w.a aVar3 = new w.a();
        ArrayList<String> sharedElementTargetNames = arrayList6;
        Iterator it2 = arrayList3.iterator();
        ArrayList<String> sharedElementSourceNames = arrayList7;
        loop3: while (true) {
            objB = null;
            while (it2.hasNext()) {
                h hVar2 = (h) it2.next();
                if (hVar2.g() && dVar != null && dVar2 != null) {
                    objB = t0Var.B(t0Var.h(hVar2.e()));
                    sharedElementSourceNames = dVar2.i().getSharedElementSourceNames();
                    kotlin.jvm.internal.t.e(sharedElementSourceNames, "lastIn.fragment.sharedElementSourceNames");
                    ArrayList<String> sharedElementSourceNames2 = dVar.i().getSharedElementSourceNames();
                    kotlin.jvm.internal.t.e(sharedElementSourceNames2, "firstOut.fragment.sharedElementSourceNames");
                    ArrayList<String> sharedElementTargetNames2 = dVar.i().getSharedElementTargetNames();
                    kotlin.jvm.internal.t.e(sharedElementTargetNames2, "firstOut.fragment.sharedElementTargetNames");
                    int size = sharedElementTargetNames2.size();
                    it = it2;
                    int i10 = 0;
                    while (i10 < size) {
                        ArrayList arrayList8 = arrayList3;
                        int iIndexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames2.get(i10));
                        int i11 = size;
                        if (iIndexOf != -1) {
                            sharedElementSourceNames.set(iIndexOf, sharedElementSourceNames2.get(i10));
                        }
                        i10++;
                        arrayList3 = arrayList8;
                        size = i11;
                    }
                    arrayList = arrayList3;
                    sharedElementTargetNames = dVar2.i().getSharedElementTargetNames();
                    kotlin.jvm.internal.t.e(sharedElementTargetNames, "lastIn.fragment.sharedElementTargetNames");
                    if (z10) {
                        dVar.i().getEnterTransitionCallback();
                        dVar2.i().getExitTransitionCallback();
                        qVarA = cd.w.a(null, null);
                    } else {
                        dVar.i().getExitTransitionCallback();
                        dVar2.i().getEnterTransitionCallback();
                        qVarA = cd.w.a(null, null);
                    }
                    android.support.v4.media.session.b.a(qVarA.a());
                    android.support.v4.media.session.b.a(qVarA.b());
                    int i12 = 0;
                    for (int size2 = sharedElementSourceNames.size(); i12 < size2; size2 = size2) {
                        String str = sharedElementSourceNames.get(i12);
                        kotlin.jvm.internal.t.e(str, "exitingNames[i]");
                        String str2 = sharedElementTargetNames.get(i12);
                        kotlin.jvm.internal.t.e(str2, "enteringNames[i]");
                        aVar.put(str, str2);
                        i12++;
                    }
                    if (i0.J0(2)) {
                        Log.v("FragmentManager", ">>> entering view names <<<");
                        for (Iterator<String> it3 = sharedElementTargetNames.iterator(); it3.hasNext(); it3 = it3) {
                            Log.v("FragmentManager", "Name: " + it3.next());
                        }
                        Log.v("FragmentManager", ">>> exiting view names <<<");
                        for (Iterator<String> it4 = sharedElementSourceNames.iterator(); it4.hasNext(); it4 = it4) {
                            Log.v("FragmentManager", "Name: " + it4.next());
                        }
                    }
                    View view = dVar.i().mView;
                    kotlin.jvm.internal.t.e(view, "firstOut.fragment.mView");
                    G(aVar2, view);
                    aVar2.o(sharedElementSourceNames);
                    aVar.o(aVar2.keySet());
                    View view2 = dVar2.i().mView;
                    kotlin.jvm.internal.t.e(view2, "lastIn.fragment.mView");
                    G(aVar3, view2);
                    aVar3.o(sharedElementTargetNames);
                    aVar3.o(aVar.values());
                    r0.c(aVar, aVar3);
                    Collection collectionKeySet = aVar.keySet();
                    kotlin.jvm.internal.t.e(collectionKeySet, "sharedElementNameMapping.keys");
                    H(aVar2, collectionKeySet);
                    Collection collectionValues = aVar.values();
                    kotlin.jvm.internal.t.e(collectionValues, "sharedElementNameMapping.values");
                    H(aVar3, collectionValues);
                    if (aVar.isEmpty()) {
                        break;
                    }
                } else {
                    it = it2;
                    arrayList = arrayList3;
                }
                it2 = it;
                arrayList3 = arrayList;
            }
            Log.i("FragmentManager", "Ignoring shared elements transition " + objB + " between " + dVar + " and " + dVar2 + " as there are no matching elements in both the entering and exiting fragment. In order to run a SharedElementTransition, both fragments involved must have the element.");
            arrayList4.clear();
            arrayList5.clear();
            it2 = it;
            arrayList3 = arrayList;
        }
        ArrayList arrayList9 = arrayList3;
        if (objB == null) {
            if (arrayList9.isEmpty()) {
                return;
            }
            Iterator it5 = arrayList9.iterator();
            while (it5.hasNext()) {
                if (((h) it5.next()).f() == null) {
                }
            }
            return;
        }
        g gVar = new g(arrayList9, dVar, dVar2, t0Var, objB, arrayList4, arrayList5, aVar, sharedElementTargetNames, sharedElementSourceNames, aVar2, aVar3, z10);
        Iterator it6 = arrayList9.iterator();
        while (it6.hasNext()) {
            ((h) it6.next()).a().b(gVar);
        }
    }

    public final void G(Map map, View view) {
        String strV = t0.c0.v(view);
        if (strV != null) {
            map.put(strV, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View child = viewGroup.getChildAt(i10);
                if (child.getVisibility() == 0) {
                    kotlin.jvm.internal.t.e(child, "child");
                    G(map, child);
                }
            }
        }
    }

    public final void H(w.a aVar, Collection collection) {
        Set entries = aVar.entrySet();
        kotlin.jvm.internal.t.e(entries, "entries");
        dd.w.F(entries, new i(collection));
    }

    public final void I(List list) {
        p pVarI = ((y0.d) dd.a0.k0(list)).i();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            y0.d dVar = (y0.d) it.next();
            dVar.i().mAnimationInfo.f2244c = pVarI.mAnimationInfo.f2244c;
            dVar.i().mAnimationInfo.f2245d = pVarI.mAnimationInfo.f2245d;
            dVar.i().mAnimationInfo.f2246e = pVarI.mAnimationInfo.f2246e;
            dVar.i().mAnimationInfo.f2247f = pVarI.mAnimationInfo.f2247f;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b9  */
    @Override // androidx.fragment.app.y0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(java.util.List r9, boolean r10) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.f.d(java.util.List, boolean):void");
    }
}
