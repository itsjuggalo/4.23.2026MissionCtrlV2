package androidx.fragment.app;

import H.ViewTreeObserverOnPreDrawListenerC0291z;
import X2.AbstractC0770q;
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
import androidx.fragment.app.AbstractC0833v;
import androidx.fragment.app.C0818f;
import androidx.fragment.app.Z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import u.C1853a;

/* JADX INFO: renamed from: androidx.fragment.app.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0818f extends Z {

    /* JADX INFO: renamed from: androidx.fragment.app.f$a */
    public static final class a extends Z.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f7475d;

        /* JADX INFO: renamed from: androidx.fragment.app.f$a$a, reason: collision with other inner class name */
        public static final class AnimationAnimationListenerC0104a implements Animation.AnimationListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Z.d f7476a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ViewGroup f7477b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ View f7478c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ a f7479d;

            public AnimationAnimationListenerC0104a(Z.d dVar, ViewGroup viewGroup, View view, a aVar) {
                this.f7476a = dVar;
                this.f7477b = viewGroup;
                this.f7478c = view;
                this.f7479d = aVar;
            }

            public static final void b(ViewGroup container, View view, a this$0) {
                kotlin.jvm.internal.r.f(container, "$container");
                kotlin.jvm.internal.r.f(this$0, "this$0");
                container.endViewTransition(view);
                this$0.h().a().f(this$0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                kotlin.jvm.internal.r.f(animation, "animation");
                final ViewGroup viewGroup = this.f7477b;
                final View view = this.f7478c;
                final a aVar = this.f7479d;
                viewGroup.post(new Runnable() { // from class: androidx.fragment.app.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        C0818f.a.AnimationAnimationListenerC0104a.b(viewGroup, view, aVar);
                    }
                });
                if (I.J0(2)) {
                    Log.v("FragmentManager", "Animation from operation " + this.f7476a + " has ended.");
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                kotlin.jvm.internal.r.f(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                kotlin.jvm.internal.r.f(animation, "animation");
                if (I.J0(2)) {
                    Log.v("FragmentManager", "Animation from operation " + this.f7476a + " has reached onAnimationStart.");
                }
            }
        }

        public a(b animationInfo) {
            kotlin.jvm.internal.r.f(animationInfo, "animationInfo");
            this.f7475d = animationInfo;
        }

        @Override // androidx.fragment.app.Z.b
        public void c(ViewGroup container) {
            kotlin.jvm.internal.r.f(container, "container");
            Z.d dVarA = this.f7475d.a();
            View view = dVarA.i().mView;
            view.clearAnimation();
            container.endViewTransition(view);
            this.f7475d.a().f(this);
            if (I.J0(2)) {
                Log.v("FragmentManager", "Animation from operation " + dVarA + " has been cancelled.");
            }
        }

        @Override // androidx.fragment.app.Z.b
        public void d(ViewGroup container) {
            kotlin.jvm.internal.r.f(container, "container");
            if (this.f7475d.b()) {
                this.f7475d.a().f(this);
                return;
            }
            Context context = container.getContext();
            Z.d dVarA = this.f7475d.a();
            View view = dVarA.i().mView;
            b bVar = this.f7475d;
            kotlin.jvm.internal.r.e(context, "context");
            AbstractC0833v.a aVarC = bVar.c(context);
            if (aVarC == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Animation animation = aVarC.f7602a;
            if (animation == null) {
                throw new IllegalStateException("Required value was null.");
            }
            if (dVarA.h() != Z.d.b.REMOVED) {
                view.startAnimation(animation);
                this.f7475d.a().f(this);
                return;
            }
            container.startViewTransition(view);
            AbstractC0833v.b bVar2 = new AbstractC0833v.b(animation, container, view);
            bVar2.setAnimationListener(new AnimationAnimationListenerC0104a(dVarA, container, view, this));
            view.startAnimation(bVar2);
            if (I.J0(2)) {
                Log.v("FragmentManager", "Animation from operation " + dVarA + " has started.");
            }
        }

        public final b h() {
            return this.f7475d;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.f$b */
    public static final class b extends C0105f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f7480b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f7481c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AbstractC0833v.a f7482d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Z.d operation, boolean z4) {
            super(operation);
            kotlin.jvm.internal.r.f(operation, "operation");
            this.f7480b = z4;
        }

        public final AbstractC0833v.a c(Context context) {
            kotlin.jvm.internal.r.f(context, "context");
            if (this.f7481c) {
                return this.f7482d;
            }
            AbstractC0833v.a aVarB = AbstractC0833v.b(context, a().i(), a().h() == Z.d.b.VISIBLE, this.f7480b);
            this.f7482d = aVarB;
            this.f7481c = true;
            return aVarB;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.f$c */
    public static final class c extends Z.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f7483d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public AnimatorSet f7484e;

        /* JADX INFO: renamed from: androidx.fragment.app.f$c$a */
        public static final class a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ViewGroup f7485a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f7486b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ boolean f7487c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Z.d f7488d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ c f7489e;

            public a(ViewGroup viewGroup, View view, boolean z4, Z.d dVar, c cVar) {
                this.f7485a = viewGroup;
                this.f7486b = view;
                this.f7487c = z4;
                this.f7488d = dVar;
                this.f7489e = cVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator anim) {
                kotlin.jvm.internal.r.f(anim, "anim");
                this.f7485a.endViewTransition(this.f7486b);
                if (this.f7487c) {
                    Z.d.b bVarH = this.f7488d.h();
                    View viewToAnimate = this.f7486b;
                    kotlin.jvm.internal.r.e(viewToAnimate, "viewToAnimate");
                    bVarH.c(viewToAnimate, this.f7485a);
                }
                this.f7489e.h().a().f(this.f7489e);
                if (I.J0(2)) {
                    Log.v("FragmentManager", "Animator from operation " + this.f7488d + " has ended.");
                }
            }
        }

        public c(b animatorInfo) {
            kotlin.jvm.internal.r.f(animatorInfo, "animatorInfo");
            this.f7483d = animatorInfo;
        }

        @Override // androidx.fragment.app.Z.b
        public boolean b() {
            return true;
        }

        @Override // androidx.fragment.app.Z.b
        public void c(ViewGroup container) {
            kotlin.jvm.internal.r.f(container, "container");
            AnimatorSet animatorSet = this.f7484e;
            if (animatorSet == null) {
                this.f7483d.a().f(this);
                return;
            }
            Z.d dVarA = this.f7483d.a();
            if (!dVarA.n()) {
                animatorSet.end();
            } else if (Build.VERSION.SDK_INT >= 26) {
                e.f7491a.a(animatorSet);
            }
            if (I.J0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Animator from operation ");
                sb.append(dVarA);
                sb.append(" has been canceled");
                sb.append(dVarA.n() ? " with seeking." : ".");
                sb.append(' ');
                Log.v("FragmentManager", sb.toString());
            }
        }

        @Override // androidx.fragment.app.Z.b
        public void d(ViewGroup container) {
            kotlin.jvm.internal.r.f(container, "container");
            Z.d dVarA = this.f7483d.a();
            AnimatorSet animatorSet = this.f7484e;
            if (animatorSet == null) {
                this.f7483d.a().f(this);
                return;
            }
            animatorSet.start();
            if (I.J0(2)) {
                Log.v("FragmentManager", "Animator from operation " + dVarA + " has started.");
            }
        }

        @Override // androidx.fragment.app.Z.b
        public void e(androidx.activity.b backEvent, ViewGroup container) {
            kotlin.jvm.internal.r.f(backEvent, "backEvent");
            kotlin.jvm.internal.r.f(container, "container");
            Z.d dVarA = this.f7483d.a();
            AnimatorSet animatorSet = this.f7484e;
            if (animatorSet == null) {
                this.f7483d.a().f(this);
                return;
            }
            if (Build.VERSION.SDK_INT < 34 || !dVarA.i().mTransitioning) {
                return;
            }
            if (I.J0(2)) {
                Log.v("FragmentManager", "Adding BackProgressCallbacks for Animators to operation " + dVarA);
            }
            long jA = d.f7490a.a(animatorSet);
            long jA2 = (long) (backEvent.a() * jA);
            if (jA2 == 0) {
                jA2 = 1;
            }
            if (jA2 == jA) {
                jA2 = jA - 1;
            }
            if (I.J0(2)) {
                Log.v("FragmentManager", "Setting currentPlayTime to " + jA2 + " for Animator " + animatorSet + " on operation " + dVarA);
            }
            e.f7491a.b(animatorSet, jA2);
        }

        @Override // androidx.fragment.app.Z.b
        public void f(ViewGroup container) {
            c cVar;
            kotlin.jvm.internal.r.f(container, "container");
            if (this.f7483d.b()) {
                return;
            }
            Context context = container.getContext();
            b bVar = this.f7483d;
            kotlin.jvm.internal.r.e(context, "context");
            AbstractC0833v.a aVarC = bVar.c(context);
            this.f7484e = aVarC != null ? aVarC.f7603b : null;
            Z.d dVarA = this.f7483d.a();
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pI = dVarA.i();
            boolean z4 = dVarA.h() == Z.d.b.GONE;
            View view = abstractComponentCallbacksC0828pI.mView;
            container.startViewTransition(view);
            AnimatorSet animatorSet = this.f7484e;
            if (animatorSet != null) {
                cVar = this;
                animatorSet.addListener(new a(container, view, z4, dVarA, cVar));
            } else {
                cVar = this;
            }
            AnimatorSet animatorSet2 = cVar.f7484e;
            if (animatorSet2 != null) {
                animatorSet2.setTarget(view);
            }
        }

        public final b h() {
            return this.f7483d;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.f$d */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f7490a = new d();

        public final long a(AnimatorSet animatorSet) {
            kotlin.jvm.internal.r.f(animatorSet, "animatorSet");
            return animatorSet.getTotalDuration();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.f$e */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f7491a = new e();

        public final void a(AnimatorSet animatorSet) {
            kotlin.jvm.internal.r.f(animatorSet, "animatorSet");
            animatorSet.reverse();
        }

        public final void b(AnimatorSet animatorSet, long j4) {
            kotlin.jvm.internal.r.f(animatorSet, "animatorSet");
            animatorSet.setCurrentPlayTime(j4);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.f$f, reason: collision with other inner class name */
    public static class C0105f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Z.d f7492a;

        public C0105f(Z.d operation) {
            kotlin.jvm.internal.r.f(operation, "operation");
            this.f7492a = operation;
        }

        public final Z.d a() {
            return this.f7492a;
        }

        public final boolean b() {
            View view = this.f7492a.i().mView;
            Z.d.b bVarA = view != null ? Z.d.b.f7441a.a(view) : null;
            Z.d.b bVarH = this.f7492a.h();
            if (bVarA == bVarH) {
                return true;
            }
            Z.d.b bVar = Z.d.b.VISIBLE;
            return (bVarA == bVar || bVarH == bVar) ? false : true;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.f$g */
    public static final class g extends Z.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f7493d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Z.d f7494e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Z.d f7495f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final U f7496g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Object f7497h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ArrayList f7498i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final ArrayList f7499j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final C1853a f7500k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final ArrayList f7501l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final ArrayList f7502m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final C1853a f7503n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final C1853a f7504o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final boolean f7505p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final D.c f7506q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Object f7507r;

        /* JADX INFO: renamed from: androidx.fragment.app.f$g$a */
        public static final class a extends kotlin.jvm.internal.s implements Function0 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ViewGroup f7509b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Object f7510c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ViewGroup viewGroup, Object obj) {
                super(0);
                this.f7509b = viewGroup;
                this.f7510c = obj;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m5invoke();
                return W2.E.f5463a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m5invoke() {
                g.this.v().e(this.f7509b, this.f7510c);
            }
        }

        /* JADX INFO: renamed from: androidx.fragment.app.f$g$b */
        public static final class b extends kotlin.jvm.internal.s implements Function0 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ViewGroup f7512b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Object f7513c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ kotlin.jvm.internal.F f7514d;

            /* JADX INFO: renamed from: androidx.fragment.app.f$g$b$a */
            public static final class a extends kotlin.jvm.internal.s implements Function0 {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ g f7515a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ ViewGroup f7516b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(g gVar, ViewGroup viewGroup) {
                    super(0);
                    this.f7515a = gVar;
                    this.f7516b = viewGroup;
                }

                public static final void b(g this$0, ViewGroup container) {
                    kotlin.jvm.internal.r.f(this$0, "this$0");
                    kotlin.jvm.internal.r.f(container, "$container");
                    Iterator it = this$0.w().iterator();
                    while (it.hasNext()) {
                        Z.d dVarA = ((h) it.next()).a();
                        View view = dVarA.i().getView();
                        if (view != null) {
                            dVarA.h().c(view, container);
                        }
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m7invoke();
                    return W2.E.f5463a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m7invoke() {
                    if (I.J0(2)) {
                        Log.v("FragmentManager", "Animating to start");
                    }
                    U uV = this.f7515a.v();
                    Object objS = this.f7515a.s();
                    kotlin.jvm.internal.r.c(objS);
                    final g gVar = this.f7515a;
                    final ViewGroup viewGroup = this.f7516b;
                    uV.d(objS, new Runnable() { // from class: androidx.fragment.app.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            C0818f.g.b.a.b(gVar, viewGroup);
                        }
                    });
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(ViewGroup viewGroup, Object obj, kotlin.jvm.internal.F f4) {
                super(0);
                this.f7512b = viewGroup;
                this.f7513c = obj;
                this.f7514d = f4;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m6invoke();
                return W2.E.f5463a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m6invoke() {
                g gVar = g.this;
                gVar.C(gVar.v().j(this.f7512b, this.f7513c));
                boolean z4 = g.this.s() != null;
                Object obj = this.f7513c;
                ViewGroup viewGroup = this.f7512b;
                if (!z4) {
                    throw new IllegalStateException(("Unable to start transition " + obj + " for container " + viewGroup + com.amazon.a.a.o.c.a.b.f8816a).toString());
                }
                this.f7514d.f13410a = new a(g.this, viewGroup);
                if (I.J0(2)) {
                    Log.v("FragmentManager", "Started executing operations from " + g.this.t() + " to " + g.this.u());
                }
            }
        }

        public g(List transitionInfos, Z.d dVar, Z.d dVar2, U transitionImpl, Object obj, ArrayList sharedElementFirstOutViews, ArrayList sharedElementLastInViews, C1853a sharedElementNameMapping, ArrayList enteringNames, ArrayList exitingNames, C1853a firstOutViews, C1853a lastInViews, boolean z4) {
            kotlin.jvm.internal.r.f(transitionInfos, "transitionInfos");
            kotlin.jvm.internal.r.f(transitionImpl, "transitionImpl");
            kotlin.jvm.internal.r.f(sharedElementFirstOutViews, "sharedElementFirstOutViews");
            kotlin.jvm.internal.r.f(sharedElementLastInViews, "sharedElementLastInViews");
            kotlin.jvm.internal.r.f(sharedElementNameMapping, "sharedElementNameMapping");
            kotlin.jvm.internal.r.f(enteringNames, "enteringNames");
            kotlin.jvm.internal.r.f(exitingNames, "exitingNames");
            kotlin.jvm.internal.r.f(firstOutViews, "firstOutViews");
            kotlin.jvm.internal.r.f(lastInViews, "lastInViews");
            this.f7493d = transitionInfos;
            this.f7494e = dVar;
            this.f7495f = dVar2;
            this.f7496g = transitionImpl;
            this.f7497h = obj;
            this.f7498i = sharedElementFirstOutViews;
            this.f7499j = sharedElementLastInViews;
            this.f7500k = sharedElementNameMapping;
            this.f7501l = enteringNames;
            this.f7502m = exitingNames;
            this.f7503n = firstOutViews;
            this.f7504o = lastInViews;
            this.f7505p = z4;
            this.f7506q = new D.c();
        }

        public static final void A(Z.d operation, g this$0) {
            kotlin.jvm.internal.r.f(operation, "$operation");
            kotlin.jvm.internal.r.f(this$0, "this$0");
            if (I.J0(2)) {
                Log.v("FragmentManager", "Transition for operation " + operation + " has completed");
            }
            operation.f(this$0);
        }

        public static final void p(Z.d dVar, Z.d dVar2, g this$0) {
            kotlin.jvm.internal.r.f(this$0, "this$0");
            S.a(dVar.i(), dVar2.i(), this$0.f7505p, this$0.f7504o, false);
        }

        public static final void q(U impl, View view, Rect lastInEpicenterRect) {
            kotlin.jvm.internal.r.f(impl, "$impl");
            kotlin.jvm.internal.r.f(lastInEpicenterRect, "$lastInEpicenterRect");
            impl.k(view, lastInEpicenterRect);
        }

        public static final void r(ArrayList transitioningViews) {
            kotlin.jvm.internal.r.f(transitioningViews, "$transitioningViews");
            S.d(transitioningViews, 4);
        }

        public static final void y(Z.d operation, g this$0) {
            kotlin.jvm.internal.r.f(operation, "$operation");
            kotlin.jvm.internal.r.f(this$0, "this$0");
            if (I.J0(2)) {
                Log.v("FragmentManager", "Transition for operation " + operation + " has completed");
            }
            operation.f(this$0);
        }

        public static final void z(kotlin.jvm.internal.F seekCancelLambda) {
            kotlin.jvm.internal.r.f(seekCancelLambda, "$seekCancelLambda");
            Function0 function0 = (Function0) seekCancelLambda.f13410a;
            if (function0 != null) {
                function0.invoke();
            }
        }

        public final void B(ArrayList arrayList, ViewGroup viewGroup, Function0 function0) {
            S.d(arrayList, 4);
            ArrayList arrayListQ = this.f7496g.q(this.f7499j);
            if (I.J0(2)) {
                Log.v("FragmentManager", ">>>>> Beginning transition <<<<<");
                Log.v("FragmentManager", ">>>>> SharedElementFirstOutViews <<<<<");
                for (Object sharedElementFirstOutViews : this.f7498i) {
                    kotlin.jvm.internal.r.e(sharedElementFirstOutViews, "sharedElementFirstOutViews");
                    View view = (View) sharedElementFirstOutViews;
                    Log.v("FragmentManager", "View: " + view + " Name: " + H.E.s(view));
                }
                Log.v("FragmentManager", ">>>>> SharedElementLastInViews <<<<<");
                for (Object sharedElementLastInViews : this.f7499j) {
                    kotlin.jvm.internal.r.e(sharedElementLastInViews, "sharedElementLastInViews");
                    View view2 = (View) sharedElementLastInViews;
                    Log.v("FragmentManager", "View: " + view2 + " Name: " + H.E.s(view2));
                }
            }
            function0.invoke();
            this.f7496g.y(viewGroup, this.f7498i, this.f7499j, arrayListQ, this.f7500k);
            S.d(arrayList, 0);
            this.f7496g.A(this.f7497h, this.f7498i, this.f7499j);
        }

        public final void C(Object obj) {
            this.f7507r = obj;
        }

        @Override // androidx.fragment.app.Z.b
        public boolean b() {
            if (!this.f7496g.m()) {
                return false;
            }
            List<h> list = this.f7493d;
            if (list == null || !list.isEmpty()) {
                for (h hVar : list) {
                    if (Build.VERSION.SDK_INT < 34 || hVar.f() == null || !this.f7496g.n(hVar.f())) {
                        return false;
                    }
                }
            }
            Object obj = this.f7497h;
            return obj == null || this.f7496g.n(obj);
        }

        @Override // androidx.fragment.app.Z.b
        public void c(ViewGroup container) {
            kotlin.jvm.internal.r.f(container, "container");
            this.f7506q.a();
        }

        @Override // androidx.fragment.app.Z.b
        public void d(ViewGroup container) {
            kotlin.jvm.internal.r.f(container, "container");
            if (!container.isLaidOut()) {
                for (h hVar : this.f7493d) {
                    Z.d dVarA = hVar.a();
                    if (I.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Container " + container + " has not been laid out. Completing operation " + dVarA);
                    }
                    hVar.a().f(this);
                }
                return;
            }
            Object obj = this.f7507r;
            if (obj != null) {
                U u4 = this.f7496g;
                kotlin.jvm.internal.r.c(obj);
                u4.c(obj);
                if (I.J0(2)) {
                    Log.v("FragmentManager", "Ending execution of operations from " + this.f7494e + " to " + this.f7495f);
                    return;
                }
                return;
            }
            W2.o oVarO = o(container, this.f7495f, this.f7494e);
            ArrayList arrayList = (ArrayList) oVarO.a();
            Object objB = oVarO.b();
            List list = this.f7493d;
            ArrayList<Z.d> arrayList2 = new ArrayList(AbstractC0770q.q(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(((h) it.next()).a());
            }
            for (final Z.d dVar : arrayList2) {
                this.f7496g.w(dVar.i(), objB, this.f7506q, new Runnable() { // from class: androidx.fragment.app.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        C0818f.g.y(dVar, this);
                    }
                });
            }
            B(arrayList, container, new a(container, objB));
            if (I.J0(2)) {
                Log.v("FragmentManager", "Completed executing operations from " + this.f7494e + " to " + this.f7495f);
            }
        }

        @Override // androidx.fragment.app.Z.b
        public void e(androidx.activity.b backEvent, ViewGroup container) {
            kotlin.jvm.internal.r.f(backEvent, "backEvent");
            kotlin.jvm.internal.r.f(container, "container");
            Object obj = this.f7507r;
            if (obj != null) {
                this.f7496g.t(obj, backEvent.a());
            }
        }

        @Override // androidx.fragment.app.Z.b
        public void f(ViewGroup container) {
            kotlin.jvm.internal.r.f(container, "container");
            if (!container.isLaidOut()) {
                Iterator it = this.f7493d.iterator();
                while (it.hasNext()) {
                    Z.d dVarA = ((h) it.next()).a();
                    if (I.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Container " + container + " has not been laid out. Skipping onStart for operation " + dVarA);
                    }
                }
                return;
            }
            if (x() && this.f7497h != null && !b()) {
                Log.i("FragmentManager", "Ignoring shared elements transition " + this.f7497h + " between " + this.f7494e + " and " + this.f7495f + " as neither fragment has set a Transition. In order to run a SharedElementTransition, you must also set either an enter or exit transition on a fragment involved in the transaction. The sharedElementTransition will run after the back gesture has been committed.");
            }
            if (b() && x()) {
                final kotlin.jvm.internal.F f4 = new kotlin.jvm.internal.F();
                W2.o oVarO = o(container, this.f7495f, this.f7494e);
                ArrayList arrayList = (ArrayList) oVarO.a();
                Object objB = oVarO.b();
                List list = this.f7493d;
                ArrayList<Z.d> arrayList2 = new ArrayList(AbstractC0770q.q(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((h) it2.next()).a());
                }
                for (final Z.d dVar : arrayList2) {
                    this.f7496g.x(dVar.i(), objB, this.f7506q, new Runnable() { // from class: androidx.fragment.app.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            C0818f.g.z(f4);
                        }
                    }, new Runnable() { // from class: androidx.fragment.app.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            C0818f.g.A(dVar, this);
                        }
                    });
                }
                B(arrayList, container, new b(container, objB, f4));
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
            if (H.J.a(viewGroup)) {
                if (arrayList.contains(view)) {
                    return;
                }
                arrayList.add(view);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View child = viewGroup.getChildAt(i4);
                if (child.getVisibility() == 0) {
                    kotlin.jvm.internal.r.e(child, "child");
                    n(arrayList, child);
                }
            }
        }

        public final W2.o o(ViewGroup viewGroup, Z.d dVar, final Z.d dVar2) {
            final Z.d dVar3 = dVar;
            View view = new View(viewGroup.getContext());
            final Rect rect = new Rect();
            Iterator it = this.f7493d.iterator();
            boolean z4 = false;
            View view2 = null;
            while (it.hasNext()) {
                if (((h) it.next()).g() && dVar2 != null && dVar3 != null && !this.f7500k.isEmpty() && this.f7497h != null) {
                    S.a(dVar3.i(), dVar2.i(), this.f7505p, this.f7503n, true);
                    ViewTreeObserverOnPreDrawListenerC0291z.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            C0818f.g.p(dVar3, dVar2, this);
                        }
                    });
                    this.f7498i.addAll(this.f7503n.values());
                    if (!this.f7502m.isEmpty()) {
                        Object obj = this.f7502m.get(0);
                        kotlin.jvm.internal.r.e(obj, "exitingNames[0]");
                        view2 = (View) this.f7503n.get((String) obj);
                        this.f7496g.v(this.f7497h, view2);
                    }
                    this.f7499j.addAll(this.f7504o.values());
                    if (!this.f7501l.isEmpty()) {
                        Object obj2 = this.f7501l.get(0);
                        kotlin.jvm.internal.r.e(obj2, "enteringNames[0]");
                        final View view3 = (View) this.f7504o.get((String) obj2);
                        if (view3 != null) {
                            final U u4 = this.f7496g;
                            ViewTreeObserverOnPreDrawListenerC0291z.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.k
                                @Override // java.lang.Runnable
                                public final void run() {
                                    C0818f.g.q(u4, view3, rect);
                                }
                            });
                            z4 = true;
                        }
                    }
                    this.f7496g.z(this.f7497h, view, this.f7498i);
                    U u5 = this.f7496g;
                    Object obj3 = this.f7497h;
                    u5.s(obj3, null, null, null, null, obj3, this.f7499j);
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = this.f7493d.iterator();
            Object objP = null;
            Object objP2 = null;
            while (it2.hasNext()) {
                h hVar = (h) it2.next();
                Z.d dVarA = hVar.a();
                boolean z5 = z4;
                Object objH = this.f7496g.h(hVar.f());
                if (objH != null) {
                    final ArrayList arrayList2 = new ArrayList();
                    Iterator it3 = it2;
                    View view4 = dVarA.i().mView;
                    kotlin.jvm.internal.r.e(view4, "operation.fragment.mView");
                    n(arrayList2, view4);
                    if (this.f7497h != null && (dVarA == dVar2 || dVarA == dVar3)) {
                        if (dVarA == dVar2) {
                            arrayList2.removeAll(X2.x.l0(this.f7498i));
                        } else {
                            arrayList2.removeAll(X2.x.l0(this.f7499j));
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        this.f7496g.a(objH, view);
                    } else {
                        this.f7496g.b(objH, arrayList2);
                        this.f7496g.s(objH, objH, arrayList2, null, null, null, null);
                        if (dVarA.h() == Z.d.b.GONE) {
                            dVarA.r(false);
                            ArrayList arrayList3 = new ArrayList(arrayList2);
                            arrayList3.remove(dVarA.i().mView);
                            this.f7496g.r(objH, dVarA.i().mView, arrayList3);
                            ViewTreeObserverOnPreDrawListenerC0291z.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.l
                                @Override // java.lang.Runnable
                                public final void run() {
                                    C0818f.g.r(arrayList2);
                                }
                            });
                        }
                    }
                    if (dVarA.h() == Z.d.b.VISIBLE) {
                        arrayList.addAll(arrayList2);
                        if (z5) {
                            this.f7496g.u(objH, rect);
                        }
                        if (I.J0(2)) {
                            Log.v("FragmentManager", "Entering Transition: " + objH);
                            Log.v("FragmentManager", ">>>>> EnteringViews <<<<<");
                            for (Object transitioningViews : arrayList2) {
                                kotlin.jvm.internal.r.e(transitioningViews, "transitioningViews");
                                Log.v("FragmentManager", "View: " + ((View) transitioningViews));
                            }
                        }
                    } else {
                        this.f7496g.v(objH, view2);
                        if (I.J0(2)) {
                            Log.v("FragmentManager", "Exiting Transition: " + objH);
                            Log.v("FragmentManager", ">>>>> ExitingViews <<<<<");
                            for (Object transitioningViews2 : arrayList2) {
                                kotlin.jvm.internal.r.e(transitioningViews2, "transitioningViews");
                                Log.v("FragmentManager", "View: " + ((View) transitioningViews2));
                            }
                        }
                    }
                    if (hVar.h()) {
                        objP = this.f7496g.p(objP, objH, null);
                    } else {
                        objP2 = this.f7496g.p(objP2, objH, null);
                    }
                    dVar3 = dVar;
                    z4 = z5;
                    it2 = it3;
                } else {
                    dVar3 = dVar;
                    z4 = z5;
                }
            }
            Object objO = this.f7496g.o(objP, objP2, this.f7497h);
            if (I.J0(2)) {
                Log.v("FragmentManager", "Final merged transition: " + objO);
            }
            return new W2.o(arrayList, objO);
        }

        public final Object s() {
            return this.f7507r;
        }

        public final Z.d t() {
            return this.f7494e;
        }

        public final Z.d u() {
            return this.f7495f;
        }

        public final U v() {
            return this.f7496g;
        }

        public final List w() {
            return this.f7493d;
        }

        public final boolean x() {
            List list = this.f7493d;
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

    /* JADX INFO: renamed from: androidx.fragment.app.f$h */
    public static final class h extends C0105f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f7517b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f7518c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f7519d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Z.d operation, boolean z4, boolean z5) {
            Object returnTransition;
            super(operation);
            kotlin.jvm.internal.r.f(operation, "operation");
            Z.d.b bVarH = operation.h();
            Z.d.b bVar = Z.d.b.VISIBLE;
            if (bVarH == bVar) {
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pI = operation.i();
                returnTransition = z4 ? abstractComponentCallbacksC0828pI.getReenterTransition() : abstractComponentCallbacksC0828pI.getEnterTransition();
            } else {
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pI2 = operation.i();
                returnTransition = z4 ? abstractComponentCallbacksC0828pI2.getReturnTransition() : abstractComponentCallbacksC0828pI2.getExitTransition();
            }
            this.f7517b = returnTransition;
            this.f7518c = operation.h() == bVar ? z4 ? operation.i().getAllowReturnTransitionOverlap() : operation.i().getAllowEnterTransitionOverlap() : true;
            this.f7519d = z5 ? z4 ? operation.i().getSharedElementReturnTransition() : operation.i().getSharedElementEnterTransition() : null;
        }

        public final U c() {
            U uD = d(this.f7517b);
            U uD2 = d(this.f7519d);
            if (uD == null || uD2 == null || uD == uD2) {
                return uD == null ? uD2 : uD;
            }
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + a().i() + " returned Transition " + this.f7517b + " which uses a different Transition  type than its shared element transition " + this.f7519d).toString());
        }

        public final U d(Object obj) {
            if (obj == null) {
                return null;
            }
            U u4 = S.f7381b;
            if (u4 != null && u4.g(obj)) {
                return u4;
            }
            U u5 = S.f7382c;
            if (u5 != null && u5.g(obj)) {
                return u5;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + a().i() + " is not a valid framework Transition or AndroidX Transition");
        }

        public final Object e() {
            return this.f7519d;
        }

        public final Object f() {
            return this.f7517b;
        }

        public final boolean g() {
            return this.f7519d != null;
        }

        public final boolean h() {
            return this.f7518c;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.f$i */
    public static final class i extends kotlin.jvm.internal.s implements i3.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Collection f7520a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Collection collection) {
            super(1);
            this.f7520a = collection;
        }

        @Override // i3.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Map.Entry entry) {
            kotlin.jvm.internal.r.f(entry, "entry");
            return Boolean.valueOf(X2.x.C(this.f7520a, H.E.s((View) entry.getValue())));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0818f(ViewGroup container) {
        super(container);
        kotlin.jvm.internal.r.f(container, "container");
    }

    public static final void E(C0818f this$0, Z.d operation) {
        kotlin.jvm.internal.r.f(this$0, "this$0");
        kotlin.jvm.internal.r.f(operation, "$operation");
        this$0.c(operation);
    }

    public final void D(List list) {
        ArrayList<b> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            X2.u.t(arrayList2, ((b) it.next()).a().g());
        }
        boolean zIsEmpty = arrayList2.isEmpty();
        Iterator it2 = list.iterator();
        boolean z4 = false;
        while (it2.hasNext()) {
            b bVar = (b) it2.next();
            Context context = t().getContext();
            Z.d dVarA = bVar.a();
            kotlin.jvm.internal.r.e(context, "context");
            AbstractC0833v.a aVarC = bVar.c(context);
            if (aVarC != null) {
                if (aVarC.f7603b == null) {
                    arrayList.add(bVar);
                } else {
                    AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pI = dVarA.i();
                    if (dVarA.g().isEmpty()) {
                        if (dVarA.h() == Z.d.b.GONE) {
                            dVarA.r(false);
                        }
                        dVarA.b(new c(bVar));
                        z4 = true;
                    } else if (I.J0(2)) {
                        Log.v("FragmentManager", "Ignoring Animator set on " + abstractComponentCallbacksC0828pI + " as this Fragment was involved in a Transition.");
                    }
                }
            }
        }
        for (b bVar2 : arrayList) {
            Z.d dVarA2 = bVar2.a();
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pI2 = dVarA2.i();
            if (zIsEmpty) {
                if (!z4) {
                    dVarA2.b(new a(bVar2));
                } else if (I.J0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + abstractComponentCallbacksC0828pI2 + " as Animations cannot run alongside Animators.");
                }
            } else if (I.J0(2)) {
                Log.v("FragmentManager", "Ignoring Animation set on " + abstractComponentCallbacksC0828pI2 + " as Animations cannot run alongside Transitions.");
            }
        }
    }

    public final void F(List list, boolean z4, Z.d dVar, Z.d dVar2) {
        Object objB;
        Iterator it;
        ArrayList arrayList;
        W2.o oVarA;
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
        U u4 = null;
        for (h hVar : arrayList3) {
            U uC = hVar.c();
            if (u4 != null && uC != u4) {
                throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + hVar.a().i() + " returned Transition " + hVar.f() + " which uses a different Transition type than other Fragments.").toString());
            }
            u4 = uC;
        }
        if (u4 == null) {
            return;
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        C1853a c1853a = new C1853a();
        ArrayList<String> arrayList6 = new ArrayList<>();
        ArrayList<String> arrayList7 = new ArrayList<>();
        C1853a c1853a2 = new C1853a();
        C1853a c1853a3 = new C1853a();
        ArrayList<String> sharedElementTargetNames = arrayList6;
        Iterator it2 = arrayList3.iterator();
        ArrayList<String> sharedElementSourceNames = arrayList7;
        loop3: while (true) {
            objB = null;
            while (it2.hasNext()) {
                h hVar2 = (h) it2.next();
                if (hVar2.g() && dVar != null && dVar2 != null) {
                    objB = u4.B(u4.h(hVar2.e()));
                    sharedElementSourceNames = dVar2.i().getSharedElementSourceNames();
                    kotlin.jvm.internal.r.e(sharedElementSourceNames, "lastIn.fragment.sharedElementSourceNames");
                    ArrayList<String> sharedElementSourceNames2 = dVar.i().getSharedElementSourceNames();
                    kotlin.jvm.internal.r.e(sharedElementSourceNames2, "firstOut.fragment.sharedElementSourceNames");
                    ArrayList<String> sharedElementTargetNames2 = dVar.i().getSharedElementTargetNames();
                    kotlin.jvm.internal.r.e(sharedElementTargetNames2, "firstOut.fragment.sharedElementTargetNames");
                    int size = sharedElementTargetNames2.size();
                    it = it2;
                    int i4 = 0;
                    while (i4 < size) {
                        ArrayList arrayList8 = arrayList3;
                        int iIndexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames2.get(i4));
                        int i5 = size;
                        if (iIndexOf != -1) {
                            sharedElementSourceNames.set(iIndexOf, sharedElementSourceNames2.get(i4));
                        }
                        i4++;
                        arrayList3 = arrayList8;
                        size = i5;
                    }
                    arrayList = arrayList3;
                    sharedElementTargetNames = dVar2.i().getSharedElementTargetNames();
                    kotlin.jvm.internal.r.e(sharedElementTargetNames, "lastIn.fragment.sharedElementTargetNames");
                    if (z4) {
                        dVar.i().getEnterTransitionCallback();
                        dVar2.i().getExitTransitionCallback();
                        oVarA = W2.t.a(null, null);
                    } else {
                        dVar.i().getExitTransitionCallback();
                        dVar2.i().getEnterTransitionCallback();
                        oVarA = W2.t.a(null, null);
                    }
                    android.support.v4.media.session.b.a(oVarA.a());
                    android.support.v4.media.session.b.a(oVarA.b());
                    int i6 = 0;
                    for (int size2 = sharedElementSourceNames.size(); i6 < size2; size2 = size2) {
                        String str = sharedElementSourceNames.get(i6);
                        kotlin.jvm.internal.r.e(str, "exitingNames[i]");
                        String str2 = sharedElementTargetNames.get(i6);
                        kotlin.jvm.internal.r.e(str2, "enteringNames[i]");
                        c1853a.put(str, str2);
                        i6++;
                    }
                    if (I.J0(2)) {
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
                    kotlin.jvm.internal.r.e(view, "firstOut.fragment.mView");
                    G(c1853a2, view);
                    c1853a2.p(sharedElementSourceNames);
                    c1853a.p(c1853a2.keySet());
                    View view2 = dVar2.i().mView;
                    kotlin.jvm.internal.r.e(view2, "lastIn.fragment.mView");
                    G(c1853a3, view2);
                    c1853a3.p(sharedElementTargetNames);
                    c1853a3.p(c1853a.values());
                    S.c(c1853a, c1853a3);
                    Collection collectionKeySet = c1853a.keySet();
                    kotlin.jvm.internal.r.e(collectionKeySet, "sharedElementNameMapping.keys");
                    H(c1853a2, collectionKeySet);
                    Collection collectionValues = c1853a.values();
                    kotlin.jvm.internal.r.e(collectionValues, "sharedElementNameMapping.values");
                    H(c1853a3, collectionValues);
                    if (c1853a.isEmpty()) {
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
        g gVar = new g(arrayList9, dVar, dVar2, u4, objB, arrayList4, arrayList5, c1853a, sharedElementTargetNames, sharedElementSourceNames, c1853a2, c1853a3, z4);
        Iterator it6 = arrayList9.iterator();
        while (it6.hasNext()) {
            ((h) it6.next()).a().b(gVar);
        }
    }

    public final void G(Map map, View view) {
        String strS = H.E.s(view);
        if (strS != null) {
            map.put(strS, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View child = viewGroup.getChildAt(i4);
                if (child.getVisibility() == 0) {
                    kotlin.jvm.internal.r.e(child, "child");
                    G(map, child);
                }
            }
        }
    }

    public final void H(C1853a c1853a, Collection collection) {
        Set entries = c1853a.entrySet();
        kotlin.jvm.internal.r.e(entries, "entries");
        X2.u.z(entries, new i(collection));
    }

    public final void I(List list) {
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pI = ((Z.d) X2.x.R(list)).i();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Z.d dVar = (Z.d) it.next();
            dVar.i().mAnimationInfo.f7578c = abstractComponentCallbacksC0828pI.mAnimationInfo.f7578c;
            dVar.i().mAnimationInfo.f7579d = abstractComponentCallbacksC0828pI.mAnimationInfo.f7579d;
            dVar.i().mAnimationInfo.f7580e = abstractComponentCallbacksC0828pI.mAnimationInfo.f7580e;
            dVar.i().mAnimationInfo.f7581f = abstractComponentCallbacksC0828pI.mAnimationInfo.f7581f;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b9  */
    @Override // androidx.fragment.app.Z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(java.util.List r9, boolean r10) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0818f.d(java.util.List, boolean):void");
    }
}
