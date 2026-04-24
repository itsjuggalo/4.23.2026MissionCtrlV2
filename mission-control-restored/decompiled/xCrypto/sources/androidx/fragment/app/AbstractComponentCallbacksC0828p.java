package androidx.fragment.app;

import H.AbstractC0277k;
import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.AbstractC0846i;
import androidx.lifecycle.AbstractC0853p;
import androidx.lifecycle.C0851n;
import androidx.lifecycle.InterfaceC0844g;
import androidx.lifecycle.InterfaceC0848k;
import androidx.lifecycle.InterfaceC0850m;
import androidx.lifecycle.K;
import c0.AbstractC0870a;
import c0.C0871b;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.common.Constants;
import d0.AbstractC1208a;
import e.AbstractC1221c;
import e.AbstractC1222d;
import e.InterfaceC1220b;
import e.InterfaceC1223e;
import f.AbstractC1238a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import r.InterfaceC1725a;
import w.AbstractC1898b;

/* JADX INFO: renamed from: androidx.fragment.app.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractComponentCallbacksC0828p implements ComponentCallbacks, View.OnCreateContextMenuListener, InterfaceC0850m, androidx.lifecycle.N, InterfaceC0844g, o0.f {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    k mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mBeingSaved;
    private boolean mCalled;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    K.b mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    I mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    A mHost;
    boolean mInLayout;
    boolean mIsCreated;
    LayoutInflater mLayoutInflater;
    C0851n mLifecycleRegistry;
    AbstractComponentCallbacksC0828p mParentFragment;
    boolean mPerformedCreateView;
    Handler mPostponedHandler;
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    o0.e mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    String mTag;
    AbstractComponentCallbacksC0828p mTarget;
    int mTargetRequestCode;
    boolean mTransitioning;
    View mView;
    V mViewLifecycleOwner;
    int mState = -1;
    String mWho = UUID.randomUUID().toString();
    String mTargetWho = null;
    private Boolean mIsPrimaryNavigationFragment = null;
    I mChildFragmentManager = new J();
    boolean mMenuVisible = true;
    boolean mUserVisibleHint = true;
    Runnable mPostponedDurationRunnable = new b();
    AbstractC0846i.b mMaxState = AbstractC0846i.b.RESUMED;
    androidx.lifecycle.r mViewLifecycleOwnerLiveData = new androidx.lifecycle.r();
    private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
    private final ArrayList<m> mOnPreAttachedListeners = new ArrayList<>();
    private final m mSavedStateAttachListener = new c();

    /* JADX INFO: renamed from: androidx.fragment.app.p$a */
    public class a extends AbstractC1221c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f7558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractC1238a f7559b;

        public a(AtomicReference atomicReference, AbstractC1238a abstractC1238a) {
            this.f7558a = atomicReference;
            this.f7559b = abstractC1238a;
        }

        @Override // e.AbstractC1221c
        public void b(Object obj, AbstractC1898b abstractC1898b) {
            AbstractC1221c abstractC1221c = (AbstractC1221c) this.f7558a.get();
            if (abstractC1221c == null) {
                throw new IllegalStateException("Operation cannot be started before fragment is in created state");
            }
            abstractC1221c.b(obj, abstractC1898b);
        }

        @Override // e.AbstractC1221c
        public void c() {
            AbstractC1221c abstractC1221c = (AbstractC1221c) this.f7558a.getAndSet(null);
            if (abstractC1221c != null) {
                abstractC1221c.c();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractComponentCallbacksC0828p.this.startPostponedEnterTransition();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$c */
    public class c extends m {
        public c() {
            super(null);
        }

        @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p.m
        public void a() {
            AbstractComponentCallbacksC0828p.this.mSavedStateRegistryController.c();
            androidx.lifecycle.D.c(AbstractComponentCallbacksC0828p.this);
            Bundle bundle = AbstractComponentCallbacksC0828p.this.mSavedFragmentState;
            AbstractComponentCallbacksC0828p.this.mSavedStateRegistryController.d(bundle != null ? bundle.getBundle("registryState") : null);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$d */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractComponentCallbacksC0828p.this.callStartTransitionListener(false);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$e */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Z f7564a;

        public e(Z z4) {
            this.f7564a = z4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f7564a.w()) {
                this.f7564a.n();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$f */
    public class f extends AbstractC0834w {
        public f() {
        }

        @Override // androidx.fragment.app.AbstractC0834w
        public View c(int i4) {
            View view = AbstractComponentCallbacksC0828p.this.mView;
            if (view != null) {
                return view.findViewById(i4);
            }
            throw new IllegalStateException("Fragment " + AbstractComponentCallbacksC0828p.this + " does not have a view");
        }

        @Override // androidx.fragment.app.AbstractC0834w
        public boolean d() {
            return AbstractComponentCallbacksC0828p.this.mView != null;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$g */
    public class g implements InterfaceC0848k {
        public g() {
        }

        @Override // androidx.lifecycle.InterfaceC0848k
        public void a(InterfaceC0850m interfaceC0850m, AbstractC0846i.a aVar) {
            View view;
            if (aVar != AbstractC0846i.a.ON_STOP || (view = AbstractComponentCallbacksC0828p.this.mView) == null) {
                return;
            }
            view.cancelPendingInputEvents();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$h */
    public class h implements InterfaceC1725a {
        public h() {
        }

        @Override // r.InterfaceC1725a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC1222d apply(Void r32) {
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = AbstractComponentCallbacksC0828p.this;
            Object obj = abstractComponentCallbacksC0828p.mHost;
            return obj instanceof InterfaceC1223e ? ((InterfaceC1223e) obj).getActivityResultRegistry() : abstractComponentCallbacksC0828p.requireActivity().getActivityResultRegistry();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$i */
    public class i implements InterfaceC1725a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC1222d f7569a;

        public i(AbstractC1222d abstractC1222d) {
            this.f7569a = abstractC1222d;
        }

        @Override // r.InterfaceC1725a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC1222d apply(Void r12) {
            return this.f7569a;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$j */
    public class j extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1725a f7571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f7572b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbstractC1238a f7573c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1220b f7574d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(InterfaceC1725a interfaceC1725a, AtomicReference atomicReference, AbstractC1238a abstractC1238a, InterfaceC1220b interfaceC1220b) {
            super(null);
            this.f7571a = interfaceC1725a;
            this.f7572b = atomicReference;
            this.f7573c = abstractC1238a;
            this.f7574d = interfaceC1220b;
        }

        @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p.m
        public void a() {
            String strGenerateActivityResultKey = AbstractComponentCallbacksC0828p.this.generateActivityResultKey();
            this.f7572b.set(((AbstractC1222d) this.f7571a.apply(null)).i(strGenerateActivityResultKey, AbstractComponentCallbacksC0828p.this, this.f7573c, this.f7574d));
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$k */
    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f7576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7578c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7579d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7580e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7581f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7582g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ArrayList f7583h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ArrayList f7584i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f7585j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f7586k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f7587l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f7588m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f7589n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Object f7590o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Boolean f7591p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Boolean f7592q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f7593r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public View f7594s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f7595t;

        public k() {
            Object obj = AbstractComponentCallbacksC0828p.USE_DEFAULT_TRANSITION;
            this.f7586k = obj;
            this.f7587l = null;
            this.f7588m = obj;
            this.f7589n = null;
            this.f7590o = obj;
            this.f7593r = 1.0f;
            this.f7594s = null;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$l */
    public static class l extends RuntimeException {
        public l(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$m */
    public static abstract class m {
        public m() {
        }

        public abstract void a();

        public /* synthetic */ m(b bVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$n */
    public static class n implements Parcelable {
        public static final Parcelable.Creator<n> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f7596a;

        /* JADX INFO: renamed from: androidx.fragment.app.p$n$a */
        public class a implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public n createFromParcel(Parcel parcel) {
                return new n(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public n createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new n(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public n[] newArray(int i4) {
                return new n[i4];
            }
        }

        public n(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle = parcel.readBundle();
            this.f7596a = bundle;
            if (classLoader == null || bundle == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeBundle(this.f7596a);
        }
    }

    public AbstractComponentCallbacksC0828p() {
        h();
    }

    public static /* synthetic */ void d(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        abstractComponentCallbacksC0828p.mViewLifecycleOwner.d(abstractComponentCallbacksC0828p.mSavedViewRegistryState);
        abstractComponentCallbacksC0828p.mSavedViewRegistryState = null;
    }

    @Deprecated
    public static AbstractComponentCallbacksC0828p instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    public void callStartTransitionListener(boolean z4) {
        ViewGroup viewGroup;
        I i4;
        k kVar = this.mAnimationInfo;
        if (kVar != null) {
            kVar.f7595t = false;
        }
        if (this.mView == null || (viewGroup = this.mContainer) == null || (i4 = this.mFragmentManager) == null) {
            return;
        }
        Z zU = Z.u(viewGroup, i4);
        zU.x();
        if (z4) {
            this.mHost.h().post(new e(zU));
        } else {
            zU.n();
        }
        Handler handler = this.mPostponedHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mPostponedDurationRunnable);
            this.mPostponedHandler = null;
        }
    }

    public AbstractC0834w createFragmentContainer() {
        return new f();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pG = g(false);
        if (abstractComponentCallbacksC0828pG != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(abstractComponentCallbacksC0828pG);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            AbstractC1208a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        this.mChildFragmentManager.X(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public final k e() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new k();
        }
        return this.mAnimationInfo;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int f() {
        AbstractC0846i.b bVar = this.mMaxState;
        return (bVar == AbstractC0846i.b.INITIALIZED || this.mParentFragment == null) ? bVar.ordinal() : Math.min(bVar.ordinal(), this.mParentFragment.f());
    }

    public AbstractComponentCallbacksC0828p findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.k0(str);
    }

    public final AbstractComponentCallbacksC0828p g(boolean z4) {
        String str;
        if (z4) {
            Y.c.j(this);
        }
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = this.mTarget;
        if (abstractComponentCallbacksC0828p != null) {
            return abstractComponentCallbacksC0828p;
        }
        I i4 = this.mFragmentManager;
        if (i4 == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return i4.g0(str);
    }

    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final AbstractActivityC0832u getActivity() {
        A a4 = this.mHost;
        if (a4 == null) {
            return null;
        }
        return (AbstractActivityC0832u) a4.e();
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        k kVar = this.mAnimationInfo;
        if (kVar == null || (bool = kVar.f7592q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        k kVar = this.mAnimationInfo;
        if (kVar == null || (bool = kVar.f7591p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public View getAnimatingAway() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return null;
        }
        return kVar.f7576a;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final I getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public Context getContext() {
        A a4 = this.mHost;
        if (a4 == null) {
            return null;
        }
        return a4.f();
    }

    @Override // androidx.lifecycle.InterfaceC0844g
    public AbstractC0870a getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && I.J0(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        C0871b c0871b = new C0871b();
        if (application != null) {
            c0871b.c(K.a.f7651h, application);
        }
        c0871b.c(androidx.lifecycle.D.f7627a, this);
        c0871b.c(androidx.lifecycle.D.f7628b, this);
        if (getArguments() != null) {
            c0871b.c(androidx.lifecycle.D.f7629c, getArguments());
        }
        return c0871b;
    }

    public K.b getDefaultViewModelProviderFactory() {
        Application application;
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.mDefaultFactory == null) {
            Context applicationContext = requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && I.J0(3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.mDefaultFactory = new androidx.lifecycle.G(application, this, getArguments());
        }
        return this.mDefaultFactory;
    }

    public int getEnterAnim() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return 0;
        }
        return kVar.f7578c;
    }

    public Object getEnterTransition() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return null;
        }
        return kVar.f7585j;
    }

    public w.w getEnterTransitionCallback() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return null;
        }
        kVar.getClass();
        return null;
    }

    public int getExitAnim() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return 0;
        }
        return kVar.f7579d;
    }

    public Object getExitTransition() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return null;
        }
        return kVar.f7587l;
    }

    public w.w getExitTransitionCallback() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return null;
        }
        kVar.getClass();
        return null;
    }

    public View getFocusedView() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return null;
        }
        return kVar.f7594s;
    }

    @Deprecated
    public final I getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        A a4 = this.mHost;
        if (a4 == null) {
            return null;
        }
        return a4.j();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Override // androidx.lifecycle.InterfaceC0850m
    public AbstractC0846i getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public AbstractC1208a getLoaderManager() {
        return AbstractC1208a.b(this);
    }

    public int getNextTransition() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return 0;
        }
        return kVar.f7582g;
    }

    public final AbstractComponentCallbacksC0828p getParentFragment() {
        return this.mParentFragment;
    }

    public final I getParentFragmentManager() {
        I i4 = this.mFragmentManager;
        if (i4 != null) {
            return i4;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public boolean getPopDirection() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return false;
        }
        return kVar.f7577b;
    }

    public int getPopEnterAnim() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return 0;
        }
        return kVar.f7580e;
    }

    public int getPopExitAnim() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return 0;
        }
        return kVar.f7581f;
    }

    public float getPostOnViewCreatedAlpha() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return 1.0f;
        }
        return kVar.f7593r;
    }

    public Object getReenterTransition() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return null;
        }
        Object obj = kVar.f7588m;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        Y.c.h(this);
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return null;
        }
        Object obj = kVar.f7586k;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // o0.f
    public final o0.d getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    public Object getSharedElementEnterTransition() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return null;
        }
        return kVar.f7589n;
    }

    public Object getSharedElementReturnTransition() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return null;
        }
        Object obj = kVar.f7590o;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    public ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        k kVar = this.mAnimationInfo;
        return (kVar == null || (arrayList = kVar.f7583h) == null) ? new ArrayList<>() : arrayList;
    }

    public ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        k kVar = this.mAnimationInfo;
        return (kVar == null || (arrayList = kVar.f7584i) == null) ? new ArrayList<>() : arrayList;
    }

    public final String getString(int i4) {
        return getResources().getString(i4);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final AbstractComponentCallbacksC0828p getTargetFragment() {
        return g(true);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        Y.c.i(this);
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i4) {
        return getResources().getText(i4);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public InterfaceC0850m getViewLifecycleOwner() {
        V v4 = this.mViewLifecycleOwner;
        if (v4 != null) {
            return v4;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner for " + this + " when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public AbstractC0853p getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.N
    public androidx.lifecycle.M getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (f() != AbstractC0846i.b.INITIALIZED.ordinal()) {
            return this.mFragmentManager.E0(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    public final void h() {
        this.mLifecycleRegistry = new C0851n(this);
        this.mSavedStateRegistryController = o0.e.a(this);
        this.mDefaultFactory = null;
        if (this.mOnPreAttachedListeners.contains(this.mSavedStateAttachListener)) {
            return;
        }
        j(this.mSavedStateAttachListener);
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final AbstractC1221c i(AbstractC1238a abstractC1238a, InterfaceC1725a interfaceC1725a, InterfaceC1220b interfaceC1220b) {
        if (this.mState <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            j(new j(interfaceC1725a, atomicReference, abstractC1238a, interfaceC1220b));
            return new a(atomicReference, abstractC1238a);
        }
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    public void initState() {
        h();
        this.mPreviousWho = this.mWho;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new J();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        if (this.mHidden) {
            return true;
        }
        I i4 = this.mFragmentManager;
        return i4 != null && i4.M0(this.mParentFragment);
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        if (!this.mMenuVisible) {
            return false;
        }
        I i4 = this.mFragmentManager;
        return i4 == null || i4.N0(this.mParentFragment);
    }

    public boolean isPostponed() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return false;
        }
        return kVar.f7595t;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        I i4 = this.mFragmentManager;
        if (i4 == null) {
            return false;
        }
        return i4.Q0();
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public final void j(m mVar) {
        if (this.mState >= 0) {
            mVar.a();
        } else {
            this.mOnPreAttachedListeners.add(mVar);
        }
    }

    public final void k() {
        if (I.J0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.mView != null) {
            Bundle bundle = this.mSavedFragmentState;
            restoreViewState(bundle != null ? bundle.getBundle("savedInstanceState") : null);
        }
        this.mSavedFragmentState = null;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.V0();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i4, int i5, Intent intent) {
        if (I.J0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i4 + " resultCode: " + i5 + " data: " + intent);
        }
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        A a4 = this.mHost;
        Activity activityE = a4 == null ? null : a4.e();
        if (activityE != null) {
            this.mCalled = false;
            onAttach(activityE);
        }
    }

    @Deprecated
    public void onAttachFragment(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState();
        if (this.mChildFragmentManager.P0(1)) {
            return;
        }
        this.mChildFragmentManager.C();
    }

    public Animation onCreateAnimation(int i4, boolean z4, int i5) {
        return null;
    }

    public Animator onCreateAnimator(int i4, boolean z4, int i5) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Deprecated
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i4 = this.mContentLayoutId;
        if (i4 != 0) {
            return layoutInflater.inflate(i4, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    @Deprecated
    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z4) {
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        A a4 = this.mHost;
        Activity activityE = a4 == null ? null : a4.e();
        if (activityE != null) {
            this.mCalled = false;
            onInflate(activityE, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z4) {
    }

    @Deprecated
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    @Deprecated
    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z4) {
    }

    @Deprecated
    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z4) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i4, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.V0();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled) {
            k();
            this.mChildFragmentManager.y();
        } else {
            throw new b0("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    public void performAttach() {
        Iterator<m> it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.m(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.f());
        if (this.mCalled) {
            this.mFragmentManager.I(this);
            this.mChildFragmentManager.z();
        } else {
            throw new b0("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.B(menuItem);
    }

    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.V0();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new g());
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.h(AbstractC0846i.a.ON_CREATE);
            return;
        }
        throw new b0("Fragment " + this + " did not call through to super.onCreate()");
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z4 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z4 = true;
        }
        return this.mChildFragmentManager.D(menu, menuInflater) | z4;
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.V0();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new V(this, getViewModelStore(), new Runnable() { // from class: androidx.fragment.app.o
            @Override // java.lang.Runnable
            public final void run() {
                AbstractComponentCallbacksC0828p.d(this.f7557a);
            }
        });
        View viewOnCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = viewOnCreateView;
        if (viewOnCreateView == null) {
            if (this.mViewLifecycleOwner.c()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.mViewLifecycleOwner = null;
            return;
        }
        this.mViewLifecycleOwner.b();
        if (I.J0(3)) {
            Log.d("FragmentManager", "Setting ViewLifecycleOwner on View " + this.mView + " for Fragment " + this);
        }
        androidx.lifecycle.O.a(this.mView, this.mViewLifecycleOwner);
        androidx.lifecycle.P.a(this.mView, this.mViewLifecycleOwner);
        o0.g.a(this.mView, this.mViewLifecycleOwner);
        this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
    }

    public void performDestroy() {
        this.mChildFragmentManager.E();
        this.mLifecycleRegistry.h(AbstractC0846i.a.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled) {
            return;
        }
        throw new b0("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public void performDestroyView() {
        this.mChildFragmentManager.F();
        if (this.mView != null && this.mViewLifecycleOwner.getLifecycle().b().c(AbstractC0846i.b.CREATED)) {
            this.mViewLifecycleOwner.a(AbstractC0846i.a.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            AbstractC1208a.b(this).d();
            this.mPerformedCreateView = false;
        } else {
            throw new b0("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled) {
            if (this.mChildFragmentManager.I0()) {
                return;
            }
            this.mChildFragmentManager.E();
            this.mChildFragmentManager = new J();
            return;
        }
        throw new b0("Fragment " + this + " did not call through to super.onDetach()");
    }

    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = layoutInflaterOnGetLayoutInflater;
        return layoutInflaterOnGetLayoutInflater;
    }

    public void performLowMemory() {
        onLowMemory();
    }

    public void performMultiWindowModeChanged(boolean z4) {
        onMultiWindowModeChanged(z4);
    }

    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.K(menuItem);
    }

    public void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.L(menu);
    }

    public void performPause() {
        this.mChildFragmentManager.N();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(AbstractC0846i.a.ON_PAUSE);
        }
        this.mLifecycleRegistry.h(AbstractC0846i.a.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (this.mCalled) {
            return;
        }
        throw new b0("Fragment " + this + " did not call through to super.onPause()");
    }

    public void performPictureInPictureModeChanged(boolean z4) {
        onPictureInPictureModeChanged(z4);
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z4 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z4 = true;
        }
        return this.mChildFragmentManager.P(menu) | z4;
    }

    public void performPrimaryNavigationFragmentChanged() {
        boolean zO0 = this.mFragmentManager.O0(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != zO0) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(zO0);
            onPrimaryNavigationFragmentChanged(zO0);
            this.mChildFragmentManager.Q();
        }
    }

    public void performResume() {
        this.mChildFragmentManager.V0();
        this.mChildFragmentManager.b0(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new b0("Fragment " + this + " did not call through to super.onResume()");
        }
        C0851n c0851n = this.mLifecycleRegistry;
        AbstractC0846i.a aVar = AbstractC0846i.a.ON_RESUME;
        c0851n.h(aVar);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(aVar);
        }
        this.mChildFragmentManager.R();
    }

    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
    }

    public void performStart() {
        this.mChildFragmentManager.V0();
        this.mChildFragmentManager.b0(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new b0("Fragment " + this + " did not call through to super.onStart()");
        }
        C0851n c0851n = this.mLifecycleRegistry;
        AbstractC0846i.a aVar = AbstractC0846i.a.ON_START;
        c0851n.h(aVar);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(aVar);
        }
        this.mChildFragmentManager.S();
    }

    public void performStop() {
        this.mChildFragmentManager.U();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(AbstractC0846i.a.ON_STOP);
        }
        this.mLifecycleRegistry.h(AbstractC0846i.a.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (this.mCalled) {
            return;
        }
        throw new b0("Fragment " + this + " did not call through to super.onStop()");
    }

    public void performViewCreated() {
        Bundle bundle = this.mSavedFragmentState;
        onViewCreated(this.mView, bundle != null ? bundle.getBundle("savedInstanceState") : null);
        this.mChildFragmentManager.V();
    }

    public void postponeEnterTransition() {
        e().f7595t = true;
    }

    public final <I, O> AbstractC1221c registerForActivityResult(AbstractC1238a abstractC1238a, InterfaceC1220b interfaceC1220b) {
        return i(abstractC1238a, new h(), interfaceC1220b);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] strArr, int i4) {
        if (this.mHost != null) {
            getParentFragmentManager().R0(this, strArr, i4);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final AbstractActivityC0832u requireActivity() {
        AbstractActivityC0832u activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @Deprecated
    public final I requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    public final AbstractComponentCallbacksC0828p requireParentFragment() {
        AbstractComponentCallbacksC0828p parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public void restoreChildFragmentState() {
        Bundle bundle;
        Bundle bundle2 = this.mSavedFragmentState;
        if (bundle2 == null || (bundle = bundle2.getBundle("childFragmentManager")) == null) {
            return;
        }
        this.mChildFragmentManager.j1(bundle);
        this.mChildFragmentManager.C();
    }

    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (this.mCalled) {
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(AbstractC0846i.a.ON_CREATE);
            }
        } else {
            throw new b0("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z4) {
        e().f7592q = Boolean.valueOf(z4);
    }

    public void setAllowReturnTransitionOverlap(boolean z4) {
        e().f7591p = Boolean.valueOf(z4);
    }

    public void setAnimations(int i4, int i5, int i6, int i7) {
        if (this.mAnimationInfo == null && i4 == 0 && i5 == 0 && i6 == 0 && i7 == 0) {
            return;
        }
        e().f7578c = i4;
        e().f7579d = i5;
        e().f7580e = i6;
        e().f7581f = i7;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(w.w wVar) {
        e().getClass();
    }

    public void setEnterTransition(Object obj) {
        e().f7585j = obj;
    }

    public void setExitSharedElementCallback(w.w wVar) {
        e().getClass();
    }

    public void setExitTransition(Object obj) {
        e().f7587l = obj;
    }

    public void setFocusedView(View view) {
        e().f7594s = view;
    }

    @Deprecated
    public void setHasOptionsMenu(boolean z4) {
        if (this.mHasMenu != z4) {
            this.mHasMenu = z4;
            if (!isAdded() || isHidden()) {
                return;
            }
            this.mHost.p();
        }
    }

    public void setInitialSavedState(n nVar) {
        Bundle bundle;
        if (this.mFragmentManager != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (nVar == null || (bundle = nVar.f7596a) == null) {
            bundle = null;
        }
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z4) {
        if (this.mMenuVisible != z4) {
            this.mMenuVisible = z4;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.p();
            }
        }
    }

    public void setNextTransition(int i4) {
        if (this.mAnimationInfo == null && i4 == 0) {
            return;
        }
        e();
        this.mAnimationInfo.f7582g = i4;
    }

    public void setPopDirection(boolean z4) {
        if (this.mAnimationInfo == null) {
            return;
        }
        e().f7577b = z4;
    }

    public void setPostOnViewCreatedAlpha(float f4) {
        e().f7593r = f4;
    }

    public void setReenterTransition(Object obj) {
        e().f7588m = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z4) {
        Y.c.k(this);
        this.mRetainInstance = z4;
        I i4 = this.mFragmentManager;
        if (i4 == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z4) {
            i4.k(this);
        } else {
            i4.h1(this);
        }
    }

    public void setReturnTransition(Object obj) {
        e().f7586k = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        e().f7589n = obj;
    }

    public void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        e();
        k kVar = this.mAnimationInfo;
        kVar.f7583h = arrayList;
        kVar.f7584i = arrayList2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        e().f7590o = obj;
    }

    @Deprecated
    public void setTargetFragment(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p, int i4) {
        if (abstractComponentCallbacksC0828p != null) {
            Y.c.l(this, abstractComponentCallbacksC0828p, i4);
        }
        I i5 = this.mFragmentManager;
        I i6 = abstractComponentCallbacksC0828p != null ? abstractComponentCallbacksC0828p.mFragmentManager : null;
        if (i5 != null && i6 != null && i5 != i6) {
            throw new IllegalArgumentException("Fragment " + abstractComponentCallbacksC0828p + " must share the same FragmentManager to be set as a target fragment");
        }
        for (AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pG = abstractComponentCallbacksC0828p; abstractComponentCallbacksC0828pG != null; abstractComponentCallbacksC0828pG = abstractComponentCallbacksC0828pG.g(false)) {
            if (abstractComponentCallbacksC0828pG.equals(this)) {
                throw new IllegalArgumentException("Setting " + abstractComponentCallbacksC0828p + " as the target of " + this + " would create a target cycle");
            }
        }
        if (abstractComponentCallbacksC0828p == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager == null || abstractComponentCallbacksC0828p.mFragmentManager == null) {
            this.mTargetWho = null;
            this.mTarget = abstractComponentCallbacksC0828p;
        } else {
            this.mTargetWho = abstractComponentCallbacksC0828p.mWho;
            this.mTarget = null;
        }
        this.mTargetRequestCode = i4;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z4) {
        Y.c.m(this, z4);
        if (!this.mUserVisibleHint && z4 && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            I i4 = this.mFragmentManager;
            i4.X0(i4.w(this));
        }
        this.mUserVisibleHint = z4;
        this.mDeferStart = this.mState < 5 && !z4;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z4);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        A a4 = this.mHost;
        if (a4 != null) {
            return a4.m(str);
        }
        return false;
    }

    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i4) {
        startActivityForResult(intent, i4, null);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i4, Intent intent, int i5, int i6, int i7, Bundle bundle) {
        Bundle bundle2;
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        if (I.J0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(this);
            sb.append(" received the following in startIntentSenderForResult() requestCode: ");
            sb.append(i4);
            sb.append(" IntentSender: ");
            sb.append(intentSender);
            sb.append(" fillInIntent: ");
            sb.append(intent);
            sb.append(" options: ");
            bundle2 = bundle;
            sb.append(bundle2);
            Log.v("FragmentManager", sb.toString());
        } else {
            bundle2 = bundle;
        }
        getParentFragmentManager().T0(this, intentSender, i4, intent, i5, i6, i7, bundle2);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !e().f7595t) {
            return;
        }
        if (this.mHost == null) {
            e().f7595t = false;
        } else if (Looper.myLooper() != this.mHost.h().getLooper()) {
            this.mHost.h().postAtFrontOfQueue(new d());
        } else {
            callStartTransitionListener(true);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    @Deprecated
    public static AbstractComponentCallbacksC0828p instantiate(Context context, String str, Bundle bundle) {
        try {
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = (AbstractComponentCallbacksC0828p) AbstractC0837z.d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle == null) {
                return abstractComponentCallbacksC0828p;
            }
            bundle.setClassLoader(abstractComponentCallbacksC0828p.getClass().getClassLoader());
            abstractComponentCallbacksC0828p.setArguments(bundle);
            return abstractComponentCallbacksC0828p;
        } catch (IllegalAccessException e4) {
            throw new l("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e4);
        } catch (InstantiationException e5) {
            throw new l("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e5);
        } catch (NoSuchMethodException e6) {
            throw new l("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e6);
        } catch (InvocationTargetException e7) {
            throw new l("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e7);
        }
    }

    public final String getString(int i4, Object... objArr) {
        return getResources().getString(i4, objArr);
    }

    public final void postponeEnterTransition(long j4, TimeUnit timeUnit) {
        e().f7595t = true;
        Handler handler = this.mPostponedHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mPostponedDurationRunnable);
        }
        I i4 = this.mFragmentManager;
        if (i4 != null) {
            this.mPostponedHandler = i4.w0().h();
        } else {
            this.mPostponedHandler = new Handler(Looper.getMainLooper());
        }
        this.mPostponedHandler.removeCallbacks(this.mPostponedDurationRunnable);
        this.mPostponedHandler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j4));
    }

    public final <I, O> AbstractC1221c registerForActivityResult(AbstractC1238a abstractC1238a, AbstractC1222d abstractC1222d, InterfaceC1220b interfaceC1220b) {
        return i(abstractC1238a, new i(abstractC1222d), interfaceC1220b);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        A a4 = this.mHost;
        if (a4 != null) {
            a4.n(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i4, Bundle bundle) {
        if (this.mHost != null) {
            getParentFragmentManager().S0(this, intent, i4, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        A a4 = this.mHost;
        if (a4 != null) {
            LayoutInflater layoutInflaterK = a4.k();
            AbstractC0277k.a(layoutInflaterK, this.mChildFragmentManager.x0());
            return layoutInflaterK;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }
}
