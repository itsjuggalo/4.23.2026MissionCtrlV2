package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Z;
import androidx.lifecycle.AbstractC0846i;

/* JADX INFO: loaded from: classes.dex */
public class O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C f7340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final P f7341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractComponentCallbacksC0828p f7342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7343d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7344e = -1;

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f7345a;

        public a(View view) {
            this.f7345a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f7345a.removeOnAttachStateChangeListener(this);
            H.E.F(this.f7345a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7347a;

        static {
            int[] iArr = new int[AbstractC0846i.b.values().length];
            f7347a = iArr;
            try {
                iArr[AbstractC0846i.b.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7347a[AbstractC0846i.b.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7347a[AbstractC0846i.b.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7347a[AbstractC0846i.b.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public O(C c4, P p4, AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        this.f7340a = c4;
        this.f7341b = p4;
        this.f7342c = abstractComponentCallbacksC0828p;
    }

    public void a() {
        if (I.J0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f7342c);
        }
        Bundle bundle = this.f7342c.mSavedFragmentState;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        this.f7342c.performActivityCreated(bundle2);
        this.f7340a.a(this.f7342c, bundle2, false);
    }

    public void b() {
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pM0 = I.m0(this.f7342c.mContainer);
        AbstractComponentCallbacksC0828p parentFragment = this.f7342c.getParentFragment();
        if (abstractComponentCallbacksC0828pM0 != null && !abstractComponentCallbacksC0828pM0.equals(parentFragment)) {
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = this.f7342c;
            Y.c.o(abstractComponentCallbacksC0828p, abstractComponentCallbacksC0828pM0, abstractComponentCallbacksC0828p.mContainerId);
        }
        int iJ = this.f7341b.j(this.f7342c);
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p2 = this.f7342c;
        abstractComponentCallbacksC0828p2.mContainer.addView(abstractComponentCallbacksC0828p2.mView, iJ);
    }

    public void c() {
        if (I.J0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f7342c);
        }
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = this.f7342c;
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p2 = abstractComponentCallbacksC0828p.mTarget;
        O oN = null;
        if (abstractComponentCallbacksC0828p2 != null) {
            O oN2 = this.f7341b.n(abstractComponentCallbacksC0828p2.mWho);
            if (oN2 == null) {
                throw new IllegalStateException("Fragment " + this.f7342c + " declared target fragment " + this.f7342c.mTarget + " that does not belong to this FragmentManager!");
            }
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p3 = this.f7342c;
            abstractComponentCallbacksC0828p3.mTargetWho = abstractComponentCallbacksC0828p3.mTarget.mWho;
            abstractComponentCallbacksC0828p3.mTarget = null;
            oN = oN2;
        } else {
            String str = abstractComponentCallbacksC0828p.mTargetWho;
            if (str != null && (oN = this.f7341b.n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f7342c + " declared target fragment " + this.f7342c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (oN != null) {
            oN.m();
        }
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p4 = this.f7342c;
        abstractComponentCallbacksC0828p4.mHost = abstractComponentCallbacksC0828p4.mFragmentManager.w0();
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p5 = this.f7342c;
        abstractComponentCallbacksC0828p5.mParentFragment = abstractComponentCallbacksC0828p5.mFragmentManager.z0();
        this.f7340a.g(this.f7342c, false);
        this.f7342c.performAttach();
        this.f7340a.b(this.f7342c, false);
    }

    public int d() {
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = this.f7342c;
        if (abstractComponentCallbacksC0828p.mFragmentManager == null) {
            return abstractComponentCallbacksC0828p.mState;
        }
        int iMin = this.f7344e;
        int i4 = b.f7347a[abstractComponentCallbacksC0828p.mMaxState.ordinal()];
        if (i4 != 1) {
            iMin = i4 != 2 ? i4 != 3 ? i4 != 4 ? Math.min(iMin, -1) : Math.min(iMin, 0) : Math.min(iMin, 1) : Math.min(iMin, 5);
        }
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p2 = this.f7342c;
        if (abstractComponentCallbacksC0828p2.mFromLayout) {
            if (abstractComponentCallbacksC0828p2.mInLayout) {
                iMin = Math.max(this.f7344e, 2);
                View view = this.f7342c.mView;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f7344e < 4 ? Math.min(iMin, abstractComponentCallbacksC0828p2.mState) : Math.min(iMin, 1);
            }
        }
        if (!this.f7342c.mAdded) {
            iMin = Math.min(iMin, 1);
        }
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p3 = this.f7342c;
        ViewGroup viewGroup = abstractComponentCallbacksC0828p3.mContainer;
        Z.d.a aVarS = viewGroup != null ? Z.u(viewGroup, abstractComponentCallbacksC0828p3.getParentFragmentManager()).s(this) : null;
        if (aVarS == Z.d.a.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (aVarS == Z.d.a.REMOVING) {
            iMin = Math.max(iMin, 3);
        } else {
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p4 = this.f7342c;
            if (abstractComponentCallbacksC0828p4.mRemoving) {
                iMin = abstractComponentCallbacksC0828p4.isInBackStack() ? Math.min(iMin, 1) : Math.min(iMin, -1);
            }
        }
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p5 = this.f7342c;
        if (abstractComponentCallbacksC0828p5.mDeferStart && abstractComponentCallbacksC0828p5.mState < 5) {
            iMin = Math.min(iMin, 4);
        }
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p6 = this.f7342c;
        if (abstractComponentCallbacksC0828p6.mTransitioning && abstractComponentCallbacksC0828p6.mContainer != null) {
            iMin = Math.max(iMin, 3);
        }
        if (I.J0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + this.f7342c);
        }
        return iMin;
    }

    public void e() {
        if (I.J0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f7342c);
        }
        Bundle bundle = this.f7342c.mSavedFragmentState;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = this.f7342c;
        if (abstractComponentCallbacksC0828p.mIsCreated) {
            abstractComponentCallbacksC0828p.mState = 1;
            abstractComponentCallbacksC0828p.restoreChildFragmentState();
        } else {
            this.f7340a.h(abstractComponentCallbacksC0828p, bundle2, false);
            this.f7342c.performCreate(bundle2);
            this.f7340a.c(this.f7342c, bundle2, false);
        }
    }

    public void f() {
        String resourceName;
        if (this.f7342c.mFromLayout) {
            return;
        }
        if (I.J0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f7342c);
        }
        Bundle bundle = this.f7342c.mSavedFragmentState;
        ViewGroup viewGroup = null;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        LayoutInflater layoutInflaterPerformGetLayoutInflater = this.f7342c.performGetLayoutInflater(bundle2);
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = this.f7342c;
        ViewGroup viewGroup2 = abstractComponentCallbacksC0828p.mContainer;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i4 = abstractComponentCallbacksC0828p.mContainerId;
            if (i4 != 0) {
                if (i4 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f7342c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) abstractComponentCallbacksC0828p.mFragmentManager.s0().c(this.f7342c.mContainerId);
                if (viewGroup == null) {
                    AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p2 = this.f7342c;
                    if (!abstractComponentCallbacksC0828p2.mRestored) {
                        try {
                            resourceName = abstractComponentCallbacksC0828p2.getResources().getResourceName(this.f7342c.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f7342c.mContainerId) + " (" + resourceName + ") for fragment " + this.f7342c);
                    }
                } else if (!(viewGroup instanceof C0835x)) {
                    Y.c.n(this.f7342c, viewGroup);
                }
            }
        }
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p3 = this.f7342c;
        abstractComponentCallbacksC0828p3.mContainer = viewGroup;
        abstractComponentCallbacksC0828p3.performCreateView(layoutInflaterPerformGetLayoutInflater, viewGroup, bundle2);
        if (this.f7342c.mView != null) {
            if (I.J0(3)) {
                Log.d("FragmentManager", "moveto VIEW_CREATED: " + this.f7342c);
            }
            this.f7342c.mView.setSaveFromParentEnabled(false);
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p4 = this.f7342c;
            abstractComponentCallbacksC0828p4.mView.setTag(X.b.f5519a, abstractComponentCallbacksC0828p4);
            if (viewGroup != null) {
                b();
            }
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p5 = this.f7342c;
            if (abstractComponentCallbacksC0828p5.mHidden) {
                abstractComponentCallbacksC0828p5.mView.setVisibility(8);
            }
            if (this.f7342c.mView.isAttachedToWindow()) {
                H.E.F(this.f7342c.mView);
            } else {
                View view = this.f7342c.mView;
                view.addOnAttachStateChangeListener(new a(view));
            }
            this.f7342c.performViewCreated();
            C c4 = this.f7340a;
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p6 = this.f7342c;
            c4.m(abstractComponentCallbacksC0828p6, abstractComponentCallbacksC0828p6.mView, bundle2, false);
            int visibility = this.f7342c.mView.getVisibility();
            this.f7342c.setPostOnViewCreatedAlpha(this.f7342c.mView.getAlpha());
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p7 = this.f7342c;
            if (abstractComponentCallbacksC0828p7.mContainer != null && visibility == 0) {
                View viewFindFocus = abstractComponentCallbacksC0828p7.mView.findFocus();
                if (viewFindFocus != null) {
                    this.f7342c.setFocusedView(viewFindFocus);
                    if (I.J0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + this.f7342c);
                    }
                }
                this.f7342c.mView.setAlpha(0.0f);
            }
        }
        this.f7342c.mState = 2;
    }

    public void g() {
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pF;
        if (I.J0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f7342c);
        }
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = this.f7342c;
        boolean zIsChangingConfigurations = true;
        boolean z4 = abstractComponentCallbacksC0828p.mRemoving && !abstractComponentCallbacksC0828p.isInBackStack();
        if (z4) {
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p2 = this.f7342c;
            if (!abstractComponentCallbacksC0828p2.mBeingSaved) {
                this.f7341b.B(abstractComponentCallbacksC0828p2.mWho, null);
            }
        }
        if (!z4 && !this.f7341b.p().r(this.f7342c)) {
            String str = this.f7342c.mTargetWho;
            if (str != null && (abstractComponentCallbacksC0828pF = this.f7341b.f(str)) != null && abstractComponentCallbacksC0828pF.mRetainInstance) {
                this.f7342c.mTarget = abstractComponentCallbacksC0828pF;
            }
            this.f7342c.mState = 0;
            return;
        }
        A a4 = this.f7342c.mHost;
        if (a4 instanceof androidx.lifecycle.N) {
            zIsChangingConfigurations = this.f7341b.p().o();
        } else if (a4.f() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) a4.f()).isChangingConfigurations();
        }
        if ((z4 && !this.f7342c.mBeingSaved) || zIsChangingConfigurations) {
            this.f7341b.p().g(this.f7342c, false);
        }
        this.f7342c.performDestroy();
        this.f7340a.d(this.f7342c, false);
        for (O o4 : this.f7341b.k()) {
            if (o4 != null) {
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pK = o4.k();
                if (this.f7342c.mWho.equals(abstractComponentCallbacksC0828pK.mTargetWho)) {
                    abstractComponentCallbacksC0828pK.mTarget = this.f7342c;
                    abstractComponentCallbacksC0828pK.mTargetWho = null;
                }
            }
        }
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p3 = this.f7342c;
        String str2 = abstractComponentCallbacksC0828p3.mTargetWho;
        if (str2 != null) {
            abstractComponentCallbacksC0828p3.mTarget = this.f7341b.f(str2);
        }
        this.f7341b.s(this);
    }

    public void h() {
        View view;
        if (I.J0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f7342c);
        }
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = this.f7342c;
        ViewGroup viewGroup = abstractComponentCallbacksC0828p.mContainer;
        if (viewGroup != null && (view = abstractComponentCallbacksC0828p.mView) != null) {
            viewGroup.removeView(view);
        }
        this.f7342c.performDestroyView();
        this.f7340a.n(this.f7342c, false);
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p2 = this.f7342c;
        abstractComponentCallbacksC0828p2.mContainer = null;
        abstractComponentCallbacksC0828p2.mView = null;
        abstractComponentCallbacksC0828p2.mViewLifecycleOwner = null;
        abstractComponentCallbacksC0828p2.mViewLifecycleOwnerLiveData.setValue(null);
        this.f7342c.mInLayout = false;
    }

    public void i() {
        if (I.J0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f7342c);
        }
        this.f7342c.performDetach();
        this.f7340a.e(this.f7342c, false);
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = this.f7342c;
        abstractComponentCallbacksC0828p.mState = -1;
        abstractComponentCallbacksC0828p.mHost = null;
        abstractComponentCallbacksC0828p.mParentFragment = null;
        abstractComponentCallbacksC0828p.mFragmentManager = null;
        if ((!abstractComponentCallbacksC0828p.mRemoving || abstractComponentCallbacksC0828p.isInBackStack()) && !this.f7341b.p().r(this.f7342c)) {
            return;
        }
        if (I.J0(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + this.f7342c);
        }
        this.f7342c.initState();
    }

    public void j() {
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = this.f7342c;
        if (abstractComponentCallbacksC0828p.mFromLayout && abstractComponentCallbacksC0828p.mInLayout && !abstractComponentCallbacksC0828p.mPerformedCreateView) {
            if (I.J0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f7342c);
            }
            Bundle bundle = this.f7342c.mSavedFragmentState;
            Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p2 = this.f7342c;
            abstractComponentCallbacksC0828p2.performCreateView(abstractComponentCallbacksC0828p2.performGetLayoutInflater(bundle2), null, bundle2);
            View view = this.f7342c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p3 = this.f7342c;
                abstractComponentCallbacksC0828p3.mView.setTag(X.b.f5519a, abstractComponentCallbacksC0828p3);
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p4 = this.f7342c;
                if (abstractComponentCallbacksC0828p4.mHidden) {
                    abstractComponentCallbacksC0828p4.mView.setVisibility(8);
                }
                this.f7342c.performViewCreated();
                C c4 = this.f7340a;
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p5 = this.f7342c;
                c4.m(abstractComponentCallbacksC0828p5, abstractComponentCallbacksC0828p5.mView, bundle2, false);
                this.f7342c.mState = 2;
            }
        }
    }

    public AbstractComponentCallbacksC0828p k() {
        return this.f7342c;
    }

    public final boolean l(View view) {
        if (view == this.f7342c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f7342c.mView) {
                return true;
            }
        }
        return false;
    }

    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f7343d) {
            if (I.J0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.f7343d = true;
            boolean z4 = false;
            while (true) {
                int iD = d();
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = this.f7342c;
                int i4 = abstractComponentCallbacksC0828p.mState;
                if (iD == i4) {
                    if (!z4 && i4 == -1 && abstractComponentCallbacksC0828p.mRemoving && !abstractComponentCallbacksC0828p.isInBackStack() && !this.f7342c.mBeingSaved) {
                        if (I.J0(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.f7342c);
                        }
                        this.f7341b.p().g(this.f7342c, true);
                        this.f7341b.s(this);
                        if (I.J0(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + this.f7342c);
                        }
                        this.f7342c.initState();
                    }
                    AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p2 = this.f7342c;
                    if (abstractComponentCallbacksC0828p2.mHiddenChanged) {
                        if (abstractComponentCallbacksC0828p2.mView != null && (viewGroup = abstractComponentCallbacksC0828p2.mContainer) != null) {
                            Z zU = Z.u(viewGroup, abstractComponentCallbacksC0828p2.getParentFragmentManager());
                            if (this.f7342c.mHidden) {
                                zU.k(this);
                            } else {
                                zU.m(this);
                            }
                        }
                        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p3 = this.f7342c;
                        I i5 = abstractComponentCallbacksC0828p3.mFragmentManager;
                        if (i5 != null) {
                            i5.H0(abstractComponentCallbacksC0828p3);
                        }
                        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p4 = this.f7342c;
                        abstractComponentCallbacksC0828p4.mHiddenChanged = false;
                        abstractComponentCallbacksC0828p4.onHiddenChanged(abstractComponentCallbacksC0828p4.mHidden);
                        this.f7342c.mChildFragmentManager.J();
                    }
                    this.f7343d = false;
                    return;
                }
                if (iD <= i4) {
                    switch (i4 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            if (abstractComponentCallbacksC0828p.mBeingSaved && this.f7341b.q(abstractComponentCallbacksC0828p.mWho) == null) {
                                this.f7341b.B(this.f7342c.mWho, q());
                            }
                            g();
                            break;
                        case 1:
                            h();
                            this.f7342c.mState = 1;
                            break;
                        case 2:
                            abstractComponentCallbacksC0828p.mInLayout = false;
                            abstractComponentCallbacksC0828p.mState = 2;
                            break;
                        case 3:
                            if (I.J0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f7342c);
                            }
                            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p5 = this.f7342c;
                            if (abstractComponentCallbacksC0828p5.mBeingSaved) {
                                this.f7341b.B(abstractComponentCallbacksC0828p5.mWho, q());
                            } else if (abstractComponentCallbacksC0828p5.mView != null && abstractComponentCallbacksC0828p5.mSavedViewState == null) {
                                r();
                            }
                            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p6 = this.f7342c;
                            if (abstractComponentCallbacksC0828p6.mView != null && (viewGroup2 = abstractComponentCallbacksC0828p6.mContainer) != null) {
                                Z.u(viewGroup2, abstractComponentCallbacksC0828p6.getParentFragmentManager()).l(this);
                            }
                            this.f7342c.mState = 3;
                            break;
                        case 4:
                            u();
                            break;
                        case 5:
                            abstractComponentCallbacksC0828p.mState = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i4 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (abstractComponentCallbacksC0828p.mView != null && (viewGroup3 = abstractComponentCallbacksC0828p.mContainer) != null) {
                                Z.u(viewGroup3, abstractComponentCallbacksC0828p.getParentFragmentManager()).j(Z.d.b.g(this.f7342c.mView.getVisibility()), this);
                            }
                            this.f7342c.mState = 4;
                            break;
                        case 5:
                            t();
                            break;
                        case 6:
                            abstractComponentCallbacksC0828p.mState = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
                z4 = true;
            }
        } catch (Throwable th) {
            this.f7343d = false;
            throw th;
        }
    }

    public void n() {
        if (I.J0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f7342c);
        }
        this.f7342c.performPause();
        this.f7340a.f(this.f7342c, false);
    }

    public void o(ClassLoader classLoader) {
        Bundle bundle = this.f7342c.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        if (this.f7342c.mSavedFragmentState.getBundle("savedInstanceState") == null) {
            this.f7342c.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
        }
        try {
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = this.f7342c;
            abstractComponentCallbacksC0828p.mSavedViewState = abstractComponentCallbacksC0828p.mSavedFragmentState.getSparseParcelableArray("viewState");
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p2 = this.f7342c;
            abstractComponentCallbacksC0828p2.mSavedViewRegistryState = abstractComponentCallbacksC0828p2.mSavedFragmentState.getBundle("viewRegistryState");
            N n4 = (N) this.f7342c.mSavedFragmentState.getParcelable("state");
            if (n4 != null) {
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p3 = this.f7342c;
                abstractComponentCallbacksC0828p3.mTargetWho = n4.f7337l;
                abstractComponentCallbacksC0828p3.mTargetRequestCode = n4.f7338m;
                Boolean bool = abstractComponentCallbacksC0828p3.mSavedUserVisibleHint;
                if (bool != null) {
                    abstractComponentCallbacksC0828p3.mUserVisibleHint = bool.booleanValue();
                    this.f7342c.mSavedUserVisibleHint = null;
                } else {
                    abstractComponentCallbacksC0828p3.mUserVisibleHint = n4.f7339n;
                }
            }
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p4 = this.f7342c;
            if (abstractComponentCallbacksC0828p4.mUserVisibleHint) {
                return;
            }
            abstractComponentCallbacksC0828p4.mDeferStart = true;
        } catch (BadParcelableException e4) {
            throw new IllegalStateException("Failed to restore view hierarchy state for fragment " + k(), e4);
        }
    }

    public void p() {
        if (I.J0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f7342c);
        }
        View focusedView = this.f7342c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean zRequestFocus = focusedView.requestFocus();
            if (I.J0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                sb.append(zRequestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.f7342c);
                sb.append(" resulting in focused view ");
                sb.append(this.f7342c.mView.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.f7342c.setFocusedView(null);
        this.f7342c.performResume();
        this.f7340a.i(this.f7342c, false);
        this.f7341b.B(this.f7342c.mWho, null);
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = this.f7342c;
        abstractComponentCallbacksC0828p.mSavedFragmentState = null;
        abstractComponentCallbacksC0828p.mSavedViewState = null;
        abstractComponentCallbacksC0828p.mSavedViewRegistryState = null;
    }

    public Bundle q() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = this.f7342c;
        if (abstractComponentCallbacksC0828p.mState == -1 && (bundle = abstractComponentCallbacksC0828p.mSavedFragmentState) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("state", new N(this.f7342c));
        if (this.f7342c.mState > -1) {
            Bundle bundle3 = new Bundle();
            this.f7342c.performSaveInstanceState(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.f7340a.j(this.f7342c, bundle3, false);
            Bundle bundle4 = new Bundle();
            this.f7342c.mSavedStateRegistryController.e(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle bundleL1 = this.f7342c.mChildFragmentManager.l1();
            if (!bundleL1.isEmpty()) {
                bundle2.putBundle("childFragmentManager", bundleL1);
            }
            if (this.f7342c.mView != null) {
                r();
            }
            SparseArray<Parcelable> sparseArray = this.f7342c.mSavedViewState;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = this.f7342c.mSavedViewRegistryState;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = this.f7342c.mArguments;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    public void r() {
        if (this.f7342c.mView == null) {
            return;
        }
        if (I.J0(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + this.f7342c + " with view " + this.f7342c.mView);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f7342c.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f7342c.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f7342c.mViewLifecycleOwner.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f7342c.mSavedViewRegistryState = bundle;
    }

    public void s(int i4) {
        this.f7344e = i4;
    }

    public void t() {
        if (I.J0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f7342c);
        }
        this.f7342c.performStart();
        this.f7340a.k(this.f7342c, false);
    }

    public void u() {
        if (I.J0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f7342c);
        }
        this.f7342c.performStop();
        this.f7340a.l(this.f7342c, false);
    }

    public O(C c4, P p4, ClassLoader classLoader, AbstractC0837z abstractC0837z, Bundle bundle) {
        this.f7340a = c4;
        this.f7341b = p4;
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pA = ((N) bundle.getParcelable("state")).a(abstractC0837z, classLoader);
        this.f7342c = abstractComponentCallbacksC0828pA;
        abstractComponentCallbacksC0828pA.mSavedFragmentState = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        abstractComponentCallbacksC0828pA.setArguments(bundle2);
        if (I.J0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + abstractComponentCallbacksC0828pA);
        }
    }

    public O(C c4, P p4, AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p, Bundle bundle) {
        this.f7340a = c4;
        this.f7341b = p4;
        this.f7342c = abstractComponentCallbacksC0828p;
        abstractComponentCallbacksC0828p.mSavedViewState = null;
        abstractComponentCallbacksC0828p.mSavedViewRegistryState = null;
        abstractComponentCallbacksC0828p.mBackStackNesting = 0;
        abstractComponentCallbacksC0828p.mInLayout = false;
        abstractComponentCallbacksC0828p.mAdded = false;
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p2 = abstractComponentCallbacksC0828p.mTarget;
        abstractComponentCallbacksC0828p.mTargetWho = abstractComponentCallbacksC0828p2 != null ? abstractComponentCallbacksC0828p2.mWho : null;
        abstractComponentCallbacksC0828p.mTarget = null;
        abstractComponentCallbacksC0828p.mSavedFragmentState = bundle;
        abstractComponentCallbacksC0828p.mArguments = bundle.getBundle("arguments");
    }
}
