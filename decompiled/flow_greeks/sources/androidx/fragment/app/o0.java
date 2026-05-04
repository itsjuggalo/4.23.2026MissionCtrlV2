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
import androidx.fragment.app.y0;
import androidx.lifecycle.i;
import io.flutter.plugins.firebase.database.FlutterFirebaseDatabaseException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f2216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p0 f2217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f2218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2219d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2220e = -1;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2223a;

        static {
            int[] iArr = new int[i.b.values().length];
            f2223a = iArr;
            try {
                iArr[i.b.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2223a[i.b.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2223a[i.b.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2223a[i.b.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public o0(c0 c0Var, p0 p0Var, p pVar) {
        this.f2216a = c0Var;
        this.f2217b = p0Var;
        this.f2218c = pVar;
    }

    public void a() {
        if (i0.J0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f2218c);
        }
        Bundle bundle = this.f2218c.mSavedFragmentState;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        this.f2218c.performActivityCreated(bundle2);
        this.f2216a.a(this.f2218c, bundle2, false);
    }

    public void b() {
        p pVarM0 = i0.m0(this.f2218c.mContainer);
        p parentFragment = this.f2218c.getParentFragment();
        if (pVarM0 != null && !pVarM0.equals(parentFragment)) {
            p pVar = this.f2218c;
            v1.c.o(pVar, pVarM0, pVar.mContainerId);
        }
        int iJ = this.f2217b.j(this.f2218c);
        p pVar2 = this.f2218c;
        pVar2.mContainer.addView(pVar2.mView, iJ);
    }

    public void c() {
        if (i0.J0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f2218c);
        }
        p pVar = this.f2218c;
        p pVar2 = pVar.mTarget;
        o0 o0VarN = null;
        if (pVar2 != null) {
            o0 o0VarN2 = this.f2217b.n(pVar2.mWho);
            if (o0VarN2 == null) {
                throw new IllegalStateException("Fragment " + this.f2218c + " declared target fragment " + this.f2218c.mTarget + " that does not belong to this FragmentManager!");
            }
            p pVar3 = this.f2218c;
            pVar3.mTargetWho = pVar3.mTarget.mWho;
            pVar3.mTarget = null;
            o0VarN = o0VarN2;
        } else {
            String str = pVar.mTargetWho;
            if (str != null && (o0VarN = this.f2217b.n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f2218c + " declared target fragment " + this.f2218c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (o0VarN != null) {
            o0VarN.m();
        }
        p pVar4 = this.f2218c;
        pVar4.mHost = pVar4.mFragmentManager.w0();
        p pVar5 = this.f2218c;
        pVar5.mParentFragment = pVar5.mFragmentManager.z0();
        this.f2216a.g(this.f2218c, false);
        this.f2218c.performAttach();
        this.f2216a.b(this.f2218c, false);
    }

    public int d() {
        p pVar = this.f2218c;
        if (pVar.mFragmentManager == null) {
            return pVar.mState;
        }
        int iMin = this.f2220e;
        int i10 = b.f2223a[pVar.mMaxState.ordinal()];
        if (i10 != 1) {
            iMin = i10 != 2 ? i10 != 3 ? i10 != 4 ? Math.min(iMin, -1) : Math.min(iMin, 0) : Math.min(iMin, 1) : Math.min(iMin, 5);
        }
        p pVar2 = this.f2218c;
        if (pVar2.mFromLayout) {
            if (pVar2.mInLayout) {
                iMin = Math.max(this.f2220e, 2);
                View view = this.f2218c.mView;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f2220e < 4 ? Math.min(iMin, pVar2.mState) : Math.min(iMin, 1);
            }
        }
        if (!this.f2218c.mAdded) {
            iMin = Math.min(iMin, 1);
        }
        p pVar3 = this.f2218c;
        ViewGroup viewGroup = pVar3.mContainer;
        y0.d.a aVarS = viewGroup != null ? y0.u(viewGroup, pVar3.getParentFragmentManager()).s(this) : null;
        if (aVarS == y0.d.a.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (aVarS == y0.d.a.REMOVING) {
            iMin = Math.max(iMin, 3);
        } else {
            p pVar4 = this.f2218c;
            if (pVar4.mRemoving) {
                iMin = pVar4.isInBackStack() ? Math.min(iMin, 1) : Math.min(iMin, -1);
            }
        }
        p pVar5 = this.f2218c;
        if (pVar5.mDeferStart && pVar5.mState < 5) {
            iMin = Math.min(iMin, 4);
        }
        p pVar6 = this.f2218c;
        if (pVar6.mTransitioning && pVar6.mContainer != null) {
            iMin = Math.max(iMin, 3);
        }
        if (i0.J0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + this.f2218c);
        }
        return iMin;
    }

    public void e() {
        if (i0.J0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f2218c);
        }
        Bundle bundle = this.f2218c.mSavedFragmentState;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        p pVar = this.f2218c;
        if (pVar.mIsCreated) {
            pVar.mState = 1;
            pVar.restoreChildFragmentState();
        } else {
            this.f2216a.h(pVar, bundle2, false);
            this.f2218c.performCreate(bundle2);
            this.f2216a.c(this.f2218c, bundle2, false);
        }
    }

    public void f() {
        String resourceName;
        if (this.f2218c.mFromLayout) {
            return;
        }
        if (i0.J0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f2218c);
        }
        Bundle bundle = this.f2218c.mSavedFragmentState;
        ViewGroup viewGroup = null;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        LayoutInflater layoutInflaterPerformGetLayoutInflater = this.f2218c.performGetLayoutInflater(bundle2);
        p pVar = this.f2218c;
        ViewGroup viewGroup2 = pVar.mContainer;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i10 = pVar.mContainerId;
            if (i10 != 0) {
                if (i10 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f2218c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) pVar.mFragmentManager.s0().c(this.f2218c.mContainerId);
                if (viewGroup == null) {
                    p pVar2 = this.f2218c;
                    if (!pVar2.mRestored) {
                        try {
                            resourceName = pVar2.getResources().getResourceName(this.f2218c.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = FlutterFirebaseDatabaseException.UNKNOWN_ERROR_CODE;
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f2218c.mContainerId) + " (" + resourceName + ") for fragment " + this.f2218c);
                    }
                } else if (!(viewGroup instanceof x)) {
                    v1.c.n(this.f2218c, viewGroup);
                }
            }
        }
        p pVar3 = this.f2218c;
        pVar3.mContainer = viewGroup;
        pVar3.performCreateView(layoutInflaterPerformGetLayoutInflater, viewGroup, bundle2);
        if (this.f2218c.mView != null) {
            if (i0.J0(3)) {
                Log.d("FragmentManager", "moveto VIEW_CREATED: " + this.f2218c);
            }
            this.f2218c.mView.setSaveFromParentEnabled(false);
            p pVar4 = this.f2218c;
            pVar4.mView.setTag(u1.b.f22142a, pVar4);
            if (viewGroup != null) {
                b();
            }
            p pVar5 = this.f2218c;
            if (pVar5.mHidden) {
                pVar5.mView.setVisibility(8);
            }
            if (this.f2218c.mView.isAttachedToWindow()) {
                t0.c0.H(this.f2218c.mView);
            } else {
                View view = this.f2218c.mView;
                view.addOnAttachStateChangeListener(new a(view));
            }
            this.f2218c.performViewCreated();
            c0 c0Var = this.f2216a;
            p pVar6 = this.f2218c;
            c0Var.m(pVar6, pVar6.mView, bundle2, false);
            int visibility = this.f2218c.mView.getVisibility();
            this.f2218c.setPostOnViewCreatedAlpha(this.f2218c.mView.getAlpha());
            p pVar7 = this.f2218c;
            if (pVar7.mContainer != null && visibility == 0) {
                View viewFindFocus = pVar7.mView.findFocus();
                if (viewFindFocus != null) {
                    this.f2218c.setFocusedView(viewFindFocus);
                    if (i0.J0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + this.f2218c);
                    }
                }
                this.f2218c.mView.setAlpha(0.0f);
            }
        }
        this.f2218c.mState = 2;
    }

    public void g() {
        p pVarF;
        if (i0.J0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f2218c);
        }
        p pVar = this.f2218c;
        boolean zIsChangingConfigurations = true;
        boolean z10 = pVar.mRemoving && !pVar.isInBackStack();
        if (z10) {
            p pVar2 = this.f2218c;
            if (!pVar2.mBeingSaved) {
                this.f2217b.B(pVar2.mWho, null);
            }
        }
        if (!z10 && !this.f2217b.p().r(this.f2218c)) {
            String str = this.f2218c.mTargetWho;
            if (str != null && (pVarF = this.f2217b.f(str)) != null && pVarF.mRetainInstance) {
                this.f2218c.mTarget = pVarF;
            }
            this.f2218c.mState = 0;
            return;
        }
        a0 a0Var = this.f2218c.mHost;
        if (a0Var instanceof androidx.lifecycle.m0) {
            zIsChangingConfigurations = this.f2217b.p().o();
        } else if (a0Var.f() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) a0Var.f()).isChangingConfigurations();
        }
        if ((z10 && !this.f2218c.mBeingSaved) || zIsChangingConfigurations) {
            this.f2217b.p().g(this.f2218c, false);
        }
        this.f2218c.performDestroy();
        this.f2216a.d(this.f2218c, false);
        for (o0 o0Var : this.f2217b.k()) {
            if (o0Var != null) {
                p pVarK = o0Var.k();
                if (this.f2218c.mWho.equals(pVarK.mTargetWho)) {
                    pVarK.mTarget = this.f2218c;
                    pVarK.mTargetWho = null;
                }
            }
        }
        p pVar3 = this.f2218c;
        String str2 = pVar3.mTargetWho;
        if (str2 != null) {
            pVar3.mTarget = this.f2217b.f(str2);
        }
        this.f2217b.s(this);
    }

    public void h() {
        View view;
        if (i0.J0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f2218c);
        }
        p pVar = this.f2218c;
        ViewGroup viewGroup = pVar.mContainer;
        if (viewGroup != null && (view = pVar.mView) != null) {
            viewGroup.removeView(view);
        }
        this.f2218c.performDestroyView();
        this.f2216a.n(this.f2218c, false);
        p pVar2 = this.f2218c;
        pVar2.mContainer = null;
        pVar2.mView = null;
        pVar2.mViewLifecycleOwner = null;
        pVar2.mViewLifecycleOwnerLiveData.setValue(null);
        this.f2218c.mInLayout = false;
    }

    public void i() {
        if (i0.J0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f2218c);
        }
        this.f2218c.performDetach();
        this.f2216a.e(this.f2218c, false);
        p pVar = this.f2218c;
        pVar.mState = -1;
        pVar.mHost = null;
        pVar.mParentFragment = null;
        pVar.mFragmentManager = null;
        if ((!pVar.mRemoving || pVar.isInBackStack()) && !this.f2217b.p().r(this.f2218c)) {
            return;
        }
        if (i0.J0(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + this.f2218c);
        }
        this.f2218c.initState();
    }

    public void j() {
        p pVar = this.f2218c;
        if (pVar.mFromLayout && pVar.mInLayout && !pVar.mPerformedCreateView) {
            if (i0.J0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f2218c);
            }
            Bundle bundle = this.f2218c.mSavedFragmentState;
            Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
            p pVar2 = this.f2218c;
            pVar2.performCreateView(pVar2.performGetLayoutInflater(bundle2), null, bundle2);
            View view = this.f2218c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                p pVar3 = this.f2218c;
                pVar3.mView.setTag(u1.b.f22142a, pVar3);
                p pVar4 = this.f2218c;
                if (pVar4.mHidden) {
                    pVar4.mView.setVisibility(8);
                }
                this.f2218c.performViewCreated();
                c0 c0Var = this.f2216a;
                p pVar5 = this.f2218c;
                c0Var.m(pVar5, pVar5.mView, bundle2, false);
                this.f2218c.mState = 2;
            }
        }
    }

    public p k() {
        return this.f2218c;
    }

    public final boolean l(View view) {
        if (view == this.f2218c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f2218c.mView) {
                return true;
            }
        }
        return false;
    }

    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f2219d) {
            if (i0.J0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.f2219d = true;
            boolean z10 = false;
            while (true) {
                int iD = d();
                p pVar = this.f2218c;
                int i10 = pVar.mState;
                if (iD == i10) {
                    if (!z10 && i10 == -1 && pVar.mRemoving && !pVar.isInBackStack() && !this.f2218c.mBeingSaved) {
                        if (i0.J0(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.f2218c);
                        }
                        this.f2217b.p().g(this.f2218c, true);
                        this.f2217b.s(this);
                        if (i0.J0(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + this.f2218c);
                        }
                        this.f2218c.initState();
                    }
                    p pVar2 = this.f2218c;
                    if (pVar2.mHiddenChanged) {
                        if (pVar2.mView != null && (viewGroup = pVar2.mContainer) != null) {
                            y0 y0VarU = y0.u(viewGroup, pVar2.getParentFragmentManager());
                            if (this.f2218c.mHidden) {
                                y0VarU.k(this);
                            } else {
                                y0VarU.m(this);
                            }
                        }
                        p pVar3 = this.f2218c;
                        i0 i0Var = pVar3.mFragmentManager;
                        if (i0Var != null) {
                            i0Var.H0(pVar3);
                        }
                        p pVar4 = this.f2218c;
                        pVar4.mHiddenChanged = false;
                        pVar4.onHiddenChanged(pVar4.mHidden);
                        this.f2218c.mChildFragmentManager.J();
                    }
                    this.f2219d = false;
                    return;
                }
                if (iD <= i10) {
                    switch (i10 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            if (pVar.mBeingSaved && this.f2217b.q(pVar.mWho) == null) {
                                this.f2217b.B(this.f2218c.mWho, q());
                            }
                            g();
                            break;
                        case 1:
                            h();
                            this.f2218c.mState = 1;
                            break;
                        case 2:
                            pVar.mInLayout = false;
                            pVar.mState = 2;
                            break;
                        case 3:
                            if (i0.J0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f2218c);
                            }
                            p pVar5 = this.f2218c;
                            if (pVar5.mBeingSaved) {
                                this.f2217b.B(pVar5.mWho, q());
                            } else if (pVar5.mView != null && pVar5.mSavedViewState == null) {
                                r();
                            }
                            p pVar6 = this.f2218c;
                            if (pVar6.mView != null && (viewGroup2 = pVar6.mContainer) != null) {
                                y0.u(viewGroup2, pVar6.getParentFragmentManager()).l(this);
                            }
                            this.f2218c.mState = 3;
                            break;
                        case 4:
                            u();
                            break;
                        case 5:
                            pVar.mState = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i10 + 1) {
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
                            if (pVar.mView != null && (viewGroup3 = pVar.mContainer) != null) {
                                y0.u(viewGroup3, pVar.getParentFragmentManager()).j(y0.d.b.c(this.f2218c.mView.getVisibility()), this);
                            }
                            this.f2218c.mState = 4;
                            break;
                        case 5:
                            t();
                            break;
                        case 6:
                            pVar.mState = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
                z10 = true;
            }
        } catch (Throwable th) {
            this.f2219d = false;
            throw th;
        }
    }

    public void n() {
        if (i0.J0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f2218c);
        }
        this.f2218c.performPause();
        this.f2216a.f(this.f2218c, false);
    }

    public void o(ClassLoader classLoader) {
        Bundle bundle = this.f2218c.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        if (this.f2218c.mSavedFragmentState.getBundle("savedInstanceState") == null) {
            this.f2218c.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
        }
        try {
            p pVar = this.f2218c;
            pVar.mSavedViewState = pVar.mSavedFragmentState.getSparseParcelableArray("viewState");
            p pVar2 = this.f2218c;
            pVar2.mSavedViewRegistryState = pVar2.mSavedFragmentState.getBundle("viewRegistryState");
            n0 n0Var = (n0) this.f2218c.mSavedFragmentState.getParcelable("state");
            if (n0Var != null) {
                p pVar3 = this.f2218c;
                pVar3.mTargetWho = n0Var.f2212l;
                pVar3.mTargetRequestCode = n0Var.f2213m;
                Boolean bool = pVar3.mSavedUserVisibleHint;
                if (bool != null) {
                    pVar3.mUserVisibleHint = bool.booleanValue();
                    this.f2218c.mSavedUserVisibleHint = null;
                } else {
                    pVar3.mUserVisibleHint = n0Var.f2214n;
                }
            }
            p pVar4 = this.f2218c;
            if (pVar4.mUserVisibleHint) {
                return;
            }
            pVar4.mDeferStart = true;
        } catch (BadParcelableException e10) {
            throw new IllegalStateException("Failed to restore view hierarchy state for fragment " + k(), e10);
        }
    }

    public void p() {
        if (i0.J0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f2218c);
        }
        View focusedView = this.f2218c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean zRequestFocus = focusedView.requestFocus();
            if (i0.J0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("requestFocus: Restoring focused view ");
                sb2.append(focusedView);
                sb2.append(" ");
                sb2.append(zRequestFocus ? "succeeded" : "failed");
                sb2.append(" on Fragment ");
                sb2.append(this.f2218c);
                sb2.append(" resulting in focused view ");
                sb2.append(this.f2218c.mView.findFocus());
                Log.v("FragmentManager", sb2.toString());
            }
        }
        this.f2218c.setFocusedView(null);
        this.f2218c.performResume();
        this.f2216a.i(this.f2218c, false);
        this.f2217b.B(this.f2218c.mWho, null);
        p pVar = this.f2218c;
        pVar.mSavedFragmentState = null;
        pVar.mSavedViewState = null;
        pVar.mSavedViewRegistryState = null;
    }

    public Bundle q() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        p pVar = this.f2218c;
        if (pVar.mState == -1 && (bundle = pVar.mSavedFragmentState) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("state", new n0(this.f2218c));
        if (this.f2218c.mState > -1) {
            Bundle bundle3 = new Bundle();
            this.f2218c.performSaveInstanceState(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.f2216a.j(this.f2218c, bundle3, false);
            Bundle bundle4 = new Bundle();
            this.f2218c.mSavedStateRegistryController.e(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle bundleL1 = this.f2218c.mChildFragmentManager.l1();
            if (!bundleL1.isEmpty()) {
                bundle2.putBundle("childFragmentManager", bundleL1);
            }
            if (this.f2218c.mView != null) {
                r();
            }
            SparseArray<Parcelable> sparseArray = this.f2218c.mSavedViewState;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = this.f2218c.mSavedViewRegistryState;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = this.f2218c.mArguments;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    public void r() {
        if (this.f2218c.mView == null) {
            return;
        }
        if (i0.J0(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + this.f2218c + " with view " + this.f2218c.mView);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f2218c.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f2218c.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f2218c.mViewLifecycleOwner.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f2218c.mSavedViewRegistryState = bundle;
    }

    public void s(int i10) {
        this.f2220e = i10;
    }

    public void t() {
        if (i0.J0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f2218c);
        }
        this.f2218c.performStart();
        this.f2216a.k(this.f2218c, false);
    }

    public void u() {
        if (i0.J0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f2218c);
        }
        this.f2218c.performStop();
        this.f2216a.l(this.f2218c, false);
    }

    public o0(c0 c0Var, p0 p0Var, ClassLoader classLoader, z zVar, Bundle bundle) {
        this.f2216a = c0Var;
        this.f2217b = p0Var;
        p pVarA = ((n0) bundle.getParcelable("state")).a(zVar, classLoader);
        this.f2218c = pVarA;
        pVarA.mSavedFragmentState = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        pVarA.setArguments(bundle2);
        if (i0.J0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + pVarA);
        }
    }

    public o0(c0 c0Var, p0 p0Var, p pVar, Bundle bundle) {
        this.f2216a = c0Var;
        this.f2217b = p0Var;
        this.f2218c = pVar;
        pVar.mSavedViewState = null;
        pVar.mSavedViewRegistryState = null;
        pVar.mBackStackNesting = 0;
        pVar.mInLayout = false;
        pVar.mAdded = false;
        p pVar2 = pVar.mTarget;
        pVar.mTargetWho = pVar2 != null ? pVar2.mWho : null;
        pVar.mTarget = null;
        pVar.mSavedFragmentState = bundle;
        pVar.mArguments = bundle.getBundle("arguments");
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f2221a;

        public a(View view) {
            this.f2221a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f2221a.removeOnAttachStateChangeListener(this);
            t0.c0.H(this.f2221a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
