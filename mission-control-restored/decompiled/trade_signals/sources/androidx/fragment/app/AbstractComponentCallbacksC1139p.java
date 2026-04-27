package androidx.fragment.app;

import T.AbstractC0929k;
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
import androidx.lifecycle.AbstractC1157i;
import androidx.lifecycle.AbstractC1164p;
import androidx.lifecycle.C1162n;
import androidx.lifecycle.InterfaceC1155g;
import androidx.lifecycle.InterfaceC1159k;
import androidx.lifecycle.InterfaceC1161m;
import androidx.lifecycle.K;
import com.revenuecat.purchases.common.Constants;
import e.InterfaceC1657b;
import f.AbstractC1725a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p0.AbstractC2539a;
import p0.C2540b;
import q0.AbstractC2617a;
import r.InterfaceC2668a;

/* JADX INFO: renamed from: androidx.fragment.app.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractComponentCallbacksC1139p implements ComponentCallbacks, View.OnCreateContextMenuListener, InterfaceC1161m, androidx.lifecycle.N, InterfaceC1155g, z0.f {
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
    C1162n mLifecycleRegistry;
    AbstractComponentCallbacksC1139p mParentFragment;
    boolean mPerformedCreateView;
    Handler mPostponedHandler;
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    z0.e mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    String mTag;
    AbstractComponentCallbacksC1139p mTarget;
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
    AbstractC1157i.b mMaxState = AbstractC1157i.b.RESUMED;
    androidx.lifecycle.r mViewLifecycleOwnerLiveData = new androidx.lifecycle.r();
    private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
    private final ArrayList<m> mOnPreAttachedListeners = new ArrayList<>();
    private final m mSavedStateAttachListener = new c();

    /* JADX INFO: renamed from: androidx.fragment.app.p$a */
    public class a extends e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f11854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractC1725a f11855b;

        public a(AtomicReference atomicReference, AbstractC1725a abstractC1725a) {
            this.f11854a = atomicReference;
            this.f11855b = abstractC1725a;
        }

        @Override // e.c
        public void b(Object obj, H.b bVar) {
            e.c cVar = (e.c) this.f11854a.get();
            if (cVar == null) {
                throw new IllegalStateException("Operation cannot be started before fragment is in created state");
            }
            cVar.b(obj, bVar);
        }

        @Override // e.c
        public void c() {
            e.c cVar = (e.c) this.f11854a.getAndSet(null);
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractComponentCallbacksC1139p.this.startPostponedEnterTransition();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$c */
    public class c extends m {
        public c() {
            super(null);
        }

        @Override // androidx.fragment.app.AbstractComponentCallbacksC1139p.m
        public void a() {
            AbstractComponentCallbacksC1139p.this.mSavedStateRegistryController.c();
            androidx.lifecycle.D.c(AbstractComponentCallbacksC1139p.this);
            Bundle bundle = AbstractComponentCallbacksC1139p.this.mSavedFragmentState;
            AbstractComponentCallbacksC1139p.this.mSavedStateRegistryController.d(bundle != null ? bundle.getBundle("registryState") : null);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$d */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractComponentCallbacksC1139p.this.callStartTransitionListener(false);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$e */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Z f11860a;

        public e(Z z7) {
            this.f11860a = z7;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f11860a.w()) {
                this.f11860a.n();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$f */
    public class f extends AbstractC1145w {
        public f() {
        }

        @Override // androidx.fragment.app.AbstractC1145w
        public View c(int i8) {
            View view = AbstractComponentCallbacksC1139p.this.mView;
            if (view != null) {
                return view.findViewById(i8);
            }
            throw new IllegalStateException("Fragment " + AbstractComponentCallbacksC1139p.this + " does not have a view");
        }

        @Override // androidx.fragment.app.AbstractC1145w
        public boolean d() {
            return AbstractComponentCallbacksC1139p.this.mView != null;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$g */
    public class g implements InterfaceC1159k {
        public g() {
        }

        @Override // androidx.lifecycle.InterfaceC1159k
        public void b(InterfaceC1161m interfaceC1161m, AbstractC1157i.a aVar) {
            View view;
            if (aVar != AbstractC1157i.a.ON_STOP || (view = AbstractComponentCallbacksC1139p.this.mView) == null) {
                return;
            }
            view.cancelPendingInputEvents();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$h */
    public class h implements InterfaceC2668a {
        public h() {
        }

        @Override // r.InterfaceC2668a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e.d apply(Void r32) {
            AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p = AbstractComponentCallbacksC1139p.this;
            Object obj = abstractComponentCallbacksC1139p.mHost;
            return obj instanceof e.e ? ((e.e) obj).getActivityResultRegistry() : abstractComponentCallbacksC1139p.requireActivity().getActivityResultRegistry();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$i */
    public class i implements InterfaceC2668a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e.d f11865a;

        public i(e.d dVar) {
            this.f11865a = dVar;
        }

        @Override // r.InterfaceC2668a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e.d apply(Void r12) {
            return this.f11865a;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$j */
    public class j extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC2668a f11867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f11868b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbstractC1725a f11869c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1657b f11870d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(InterfaceC2668a interfaceC2668a, AtomicReference atomicReference, AbstractC1725a abstractC1725a, InterfaceC1657b interfaceC1657b) {
            super(null);
            this.f11867a = interfaceC2668a;
            this.f11868b = atomicReference;
            this.f11869c = abstractC1725a;
            this.f11870d = interfaceC1657b;
        }

        @Override // androidx.fragment.app.AbstractComponentCallbacksC1139p.m
        public void a() {
            String strGenerateActivityResultKey = AbstractComponentCallbacksC1139p.this.generateActivityResultKey();
            this.f11868b.set(((e.d) this.f11867a.apply(null)).i(strGenerateActivityResultKey, AbstractComponentCallbacksC1139p.this, this.f11869c, this.f11870d));
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.p$k */
    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f11872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11873b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f11874c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f11875d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f11876e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f11877f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f11878g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ArrayList f11879h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ArrayList f11880i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f11881j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f11882k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f11883l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f11884m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f11885n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Object f11886o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Boolean f11887p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Boolean f11888q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f11889r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public View f11890s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f11891t;

        public k() {
            Object obj = AbstractComponentCallbacksC1139p.USE_DEFAULT_TRANSITION;
            this.f11882k = obj;
            this.f11883l = null;
            this.f11884m = obj;
            this.f11885n = null;
            this.f11886o = obj;
            this.f11889r = 1.0f;
            this.f11890s = null;
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
        public final Bundle f11892a;

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
            public n[] newArray(int i8) {
                return new n[i8];
            }
        }

        public n(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle = parcel.readBundle();
            this.f11892a = bundle;
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
        public void writeToParcel(Parcel parcel, int i8) {
            parcel.writeBundle(this.f11892a);
        }
    }

    public AbstractComponentCallbacksC1139p() {
        h();
    }

    @Deprecated
    public static AbstractComponentCallbacksC1139p instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    public void callStartTransitionListener(boolean z7) {
        ViewGroup viewGroup;
        I i8;
        k kVar = this.mAnimationInfo;
        if (kVar != null) {
            kVar.f11891t = false;
        }
        if (this.mView == null || (viewGroup = this.mContainer) == null || (i8 = this.mFragmentManager) == null) {
            return;
        }
        Z zU = Z.u(viewGroup, i8);
        zU.x();
        if (z7) {
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

    public AbstractC1145w createFragmentContainer() {
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
        AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139pG = g(false);
        if (abstractComponentCallbacksC1139pG != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(abstractComponentCallbacksC1139pG);
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
            AbstractC2617a.b(this).a(str, fileDescriptor, printWriter, strArr);
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
        AbstractC1157i.b bVar = this.mMaxState;
        return (bVar == AbstractC1157i.b.INITIALIZED || this.mParentFragment == null) ? bVar.ordinal() : Math.min(bVar.ordinal(), this.mParentFragment.f());
    }

    public AbstractComponentCallbacksC1139p findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.k0(str);
    }

    public final AbstractComponentCallbacksC1139p g(boolean z7) {
        String str;
        if (z7) {
            m0.c.j(this);
        }
        AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p = this.mTarget;
        if (abstractComponentCallbacksC1139p != null) {
            return abstractComponentCallbacksC1139p;
        }
        I i8 = this.mFragmentManager;
        if (i8 == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return i8.g0(str);
    }

    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final AbstractActivityC1143u getActivity() {
        A a8 = this.mHost;
        if (a8 == null) {
            return null;
        }
        return (AbstractActivityC1143u) a8.e();
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        k kVar = this.mAnimationInfo;
        if (kVar == null || (bool = kVar.f11888q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        k kVar = this.mAnimationInfo;
        if (kVar == null || (bool = kVar.f11887p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public View getAnimatingAway() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return null;
        }
        return kVar.f11872a;
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
        A a8 = this.mHost;
        if (a8 == null) {
            return null;
        }
        return a8.f();
    }

    @Override // androidx.lifecycle.InterfaceC1155g
    public AbstractC2539a getDefaultViewModelCreationExtras() {
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
        C2540b c2540b = new C2540b();
        if (application != null) {
            c2540b.c(K.a.f11947h, application);
        }
        c2540b.c(androidx.lifecycle.D.f11923a, this);
        c2540b.c(androidx.lifecycle.D.f11924b, this);
        if (getArguments() != null) {
            c2540b.c(androidx.lifecycle.D.f11925c, getArguments());
        }
        return c2540b;
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
        return kVar.f11874c;
    }

    public Object getEnterTransition() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return null;
        }
        return kVar.f11881j;
    }

    public H.u getEnterTransitionCallback() {
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
        return kVar.f11875d;
    }

    public Object getExitTransition() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return null;
        }
        return kVar.f11883l;
    }

    public H.u getExitTransitionCallback() {
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
        return kVar.f11890s;
    }

    @Deprecated
    public final I getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        A a8 = this.mHost;
        if (a8 == null) {
            return null;
        }
        return a8.j();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Override // androidx.lifecycle.InterfaceC1161m
    public AbstractC1157i getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public AbstractC2617a getLoaderManager() {
        return AbstractC2617a.b(this);
    }

    public int getNextTransition() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return 0;
        }
        return kVar.f11878g;
    }

    public final AbstractComponentCallbacksC1139p getParentFragment() {
        return this.mParentFragment;
    }

    public final I getParentFragmentManager() {
        I i8 = this.mFragmentManager;
        if (i8 != null) {
            return i8;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public boolean getPopDirection() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return false;
        }
        return kVar.f11873b;
    }

    public int getPopEnterAnim() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return 0;
        }
        return kVar.f11876e;
    }

    public int getPopExitAnim() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return 0;
        }
        return kVar.f11877f;
    }

    public float getPostOnViewCreatedAlpha() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return 1.0f;
        }
        return kVar.f11889r;
    }

    public Object getReenterTransition() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return null;
        }
        Object obj = kVar.f11884m;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        m0.c.h(this);
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return null;
        }
        Object obj = kVar.f11882k;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // z0.f
    public final z0.d getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    public Object getSharedElementEnterTransition() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return null;
        }
        return kVar.f11885n;
    }

    public Object getSharedElementReturnTransition() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return null;
        }
        Object obj = kVar.f11886o;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    public ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        k kVar = this.mAnimationInfo;
        return (kVar == null || (arrayList = kVar.f11879h) == null) ? new ArrayList<>() : arrayList;
    }

    public ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        k kVar = this.mAnimationInfo;
        return (kVar == null || (arrayList = kVar.f11880i) == null) ? new ArrayList<>() : arrayList;
    }

    public final String getString(int i8) {
        return getResources().getString(i8);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final AbstractComponentCallbacksC1139p getTargetFragment() {
        return g(true);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        m0.c.i(this);
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i8) {
        return getResources().getText(i8);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public InterfaceC1161m getViewLifecycleOwner() {
        V v8 = this.mViewLifecycleOwner;
        if (v8 != null) {
            return v8;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner for " + this + " when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public AbstractC1164p getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.N
    public androidx.lifecycle.M getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (f() != AbstractC1157i.b.INITIALIZED.ordinal()) {
            return this.mFragmentManager.E0(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    public final void h() {
        this.mLifecycleRegistry = new C1162n(this);
        this.mSavedStateRegistryController = z0.e.a(this);
        this.mDefaultFactory = null;
        if (this.mOnPreAttachedListeners.contains(this.mSavedStateAttachListener)) {
            return;
        }
        k(this.mSavedStateAttachListener);
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final /* synthetic */ void i() {
        this.mViewLifecycleOwner.d(this.mSavedViewRegistryState);
        this.mSavedViewRegistryState = null;
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
        I i8;
        return this.mHidden || ((i8 = this.mFragmentManager) != null && i8.M0(this.mParentFragment));
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        I i8;
        return this.mMenuVisible && ((i8 = this.mFragmentManager) == null || i8.N0(this.mParentFragment));
    }

    public boolean isPostponed() {
        k kVar = this.mAnimationInfo;
        if (kVar == null) {
            return false;
        }
        return kVar.f11891t;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        I i8 = this.mFragmentManager;
        if (i8 == null) {
            return false;
        }
        return i8.Q0();
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public final e.c j(AbstractC1725a abstractC1725a, InterfaceC2668a interfaceC2668a, InterfaceC1657b interfaceC1657b) {
        if (this.mState <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            k(new j(interfaceC2668a, atomicReference, abstractC1725a, interfaceC1657b));
            return new a(atomicReference, abstractC1725a);
        }
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    public final void k(m mVar) {
        if (this.mState >= 0) {
            mVar.a();
        } else {
            this.mOnPreAttachedListeners.add(mVar);
        }
    }

    public final void l() {
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
        this.mChildFragmentManager.a1();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    public void onActivityResult(int i8, int i9, Intent intent) {
        if (I.J0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i8 + " resultCode: " + i9 + " data: " + intent);
        }
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onAttachFragment(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
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

    public Animation onCreateAnimation(int i8, boolean z7, int i9) {
        return null;
    }

    public Animator onCreateAnimator(int i8, boolean z7, int i9) {
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
        int i8 = this.mContentLayoutId;
        if (i8 != 0) {
            return layoutInflater.inflate(i8, viewGroup, false);
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

    public void onHiddenChanged(boolean z7) {
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z7) {
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

    public void onPictureInPictureModeChanged(boolean z7) {
    }

    @Deprecated
    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z7) {
    }

    public void onRequestPermissionsResult(int i8, String[] strArr, int[] iArr) {
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
        this.mChildFragmentManager.a1();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled) {
            l();
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
        this.mChildFragmentManager.a1();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new g());
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.h(AbstractC1157i.a.ON_CREATE);
            return;
        }
        throw new b0("Fragment " + this + " did not call through to super.onCreate()");
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z7 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z7 = true;
        }
        return z7 | this.mChildFragmentManager.D(menu, menuInflater);
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.a1();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new V(this, getViewModelStore(), new Runnable() { // from class: androidx.fragment.app.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f11853a.i();
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
        z0.g.a(this.mView, this.mViewLifecycleOwner);
        this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
    }

    public void performDestroy() {
        this.mChildFragmentManager.E();
        this.mLifecycleRegistry.h(AbstractC1157i.a.ON_DESTROY);
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
        if (this.mView != null && this.mViewLifecycleOwner.getLifecycle().b().b(AbstractC1157i.b.CREATED)) {
            this.mViewLifecycleOwner.a(AbstractC1157i.a.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            AbstractC2617a.b(this).c();
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

    public void performMultiWindowModeChanged(boolean z7) {
        onMultiWindowModeChanged(z7);
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
            this.mViewLifecycleOwner.a(AbstractC1157i.a.ON_PAUSE);
        }
        this.mLifecycleRegistry.h(AbstractC1157i.a.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (this.mCalled) {
            return;
        }
        throw new b0("Fragment " + this + " did not call through to super.onPause()");
    }

    public void performPictureInPictureModeChanged(boolean z7) {
        onPictureInPictureModeChanged(z7);
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z7 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z7 = true;
        }
        return z7 | this.mChildFragmentManager.P(menu);
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
        this.mChildFragmentManager.a1();
        this.mChildFragmentManager.b0(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new b0("Fragment " + this + " did not call through to super.onResume()");
        }
        C1162n c1162n = this.mLifecycleRegistry;
        AbstractC1157i.a aVar = AbstractC1157i.a.ON_RESUME;
        c1162n.h(aVar);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(aVar);
        }
        this.mChildFragmentManager.R();
    }

    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
    }

    public void performStart() {
        this.mChildFragmentManager.a1();
        this.mChildFragmentManager.b0(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new b0("Fragment " + this + " did not call through to super.onStart()");
        }
        C1162n c1162n = this.mLifecycleRegistry;
        AbstractC1157i.a aVar = AbstractC1157i.a.ON_START;
        c1162n.h(aVar);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(aVar);
        }
        this.mChildFragmentManager.S();
    }

    public void performStop() {
        this.mChildFragmentManager.U();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(AbstractC1157i.a.ON_STOP);
        }
        this.mLifecycleRegistry.h(AbstractC1157i.a.ON_STOP);
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
        e().f11891t = true;
    }

    public final <I, O> e.c registerForActivityResult(AbstractC1725a abstractC1725a, InterfaceC1657b interfaceC1657b) {
        return j(abstractC1725a, new h(), interfaceC1657b);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] strArr, int i8) {
        if (this.mHost != null) {
            getParentFragmentManager().W0(this, strArr, i8);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final AbstractActivityC1143u requireActivity() {
        AbstractActivityC1143u activity = getActivity();
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

    public final AbstractComponentCallbacksC1139p requireParentFragment() {
        AbstractComponentCallbacksC1139p parentFragment = getParentFragment();
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
        this.mChildFragmentManager.o1(bundle);
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
                this.mViewLifecycleOwner.a(AbstractC1157i.a.ON_CREATE);
            }
        } else {
            throw new b0("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z7) {
        e().f11888q = Boolean.valueOf(z7);
    }

    public void setAllowReturnTransitionOverlap(boolean z7) {
        e().f11887p = Boolean.valueOf(z7);
    }

    public void setAnimations(int i8, int i9, int i10, int i11) {
        if (this.mAnimationInfo == null && i8 == 0 && i9 == 0 && i10 == 0 && i11 == 0) {
            return;
        }
        e().f11874c = i8;
        e().f11875d = i9;
        e().f11876e = i10;
        e().f11877f = i11;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(H.u uVar) {
        e().getClass();
    }

    public void setEnterTransition(Object obj) {
        e().f11881j = obj;
    }

    public void setExitSharedElementCallback(H.u uVar) {
        e().getClass();
    }

    public void setExitTransition(Object obj) {
        e().f11883l = obj;
    }

    public void setFocusedView(View view) {
        e().f11890s = view;
    }

    @Deprecated
    public void setHasOptionsMenu(boolean z7) {
        if (this.mHasMenu != z7) {
            this.mHasMenu = z7;
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
        if (nVar == null || (bundle = nVar.f11892a) == null) {
            bundle = null;
        }
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z7) {
        if (this.mMenuVisible != z7) {
            this.mMenuVisible = z7;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.p();
            }
        }
    }

    public void setNextTransition(int i8) {
        if (this.mAnimationInfo == null && i8 == 0) {
            return;
        }
        e();
        this.mAnimationInfo.f11878g = i8;
    }

    public void setPopDirection(boolean z7) {
        if (this.mAnimationInfo == null) {
            return;
        }
        e().f11873b = z7;
    }

    public void setPostOnViewCreatedAlpha(float f8) {
        e().f11889r = f8;
    }

    public void setReenterTransition(Object obj) {
        e().f11884m = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z7) {
        m0.c.k(this);
        this.mRetainInstance = z7;
        I i8 = this.mFragmentManager;
        if (i8 == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z7) {
            i8.k(this);
        } else {
            i8.m1(this);
        }
    }

    public void setReturnTransition(Object obj) {
        e().f11882k = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        e().f11885n = obj;
    }

    public void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        e();
        k kVar = this.mAnimationInfo;
        kVar.f11879h = arrayList;
        kVar.f11880i = arrayList2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        e().f11886o = obj;
    }

    @Deprecated
    public void setTargetFragment(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p, int i8) {
        if (abstractComponentCallbacksC1139p != null) {
            m0.c.l(this, abstractComponentCallbacksC1139p, i8);
        }
        I i9 = this.mFragmentManager;
        I i10 = abstractComponentCallbacksC1139p != null ? abstractComponentCallbacksC1139p.mFragmentManager : null;
        if (i9 != null && i10 != null && i9 != i10) {
            throw new IllegalArgumentException("Fragment " + abstractComponentCallbacksC1139p + " must share the same FragmentManager to be set as a target fragment");
        }
        for (AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139pG = abstractComponentCallbacksC1139p; abstractComponentCallbacksC1139pG != null; abstractComponentCallbacksC1139pG = abstractComponentCallbacksC1139pG.g(false)) {
            if (abstractComponentCallbacksC1139pG.equals(this)) {
                throw new IllegalArgumentException("Setting " + abstractComponentCallbacksC1139p + " as the target of " + this + " would create a target cycle");
            }
        }
        if (abstractComponentCallbacksC1139p == null) {
            this.mTargetWho = null;
        } else {
            if (this.mFragmentManager == null || abstractComponentCallbacksC1139p.mFragmentManager == null) {
                this.mTargetWho = null;
                this.mTarget = abstractComponentCallbacksC1139p;
                this.mTargetRequestCode = i8;
            }
            this.mTargetWho = abstractComponentCallbacksC1139p.mWho;
        }
        this.mTarget = null;
        this.mTargetRequestCode = i8;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z7) {
        m0.c.m(this, z7);
        if (!this.mUserVisibleHint && z7 && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            I i8 = this.mFragmentManager;
            i8.c1(i8.w(this));
        }
        this.mUserVisibleHint = z7;
        this.mDeferStart = this.mState < 5 && !z7;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z7);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        A a8 = this.mHost;
        if (a8 != null) {
            return a8.m(str);
        }
        return false;
    }

    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i8) {
        startActivityForResult(intent, i8, null);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i8, Intent intent, int i9, int i10, int i11, Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        if (I.J0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + i8 + " IntentSender: " + intentSender + " fillInIntent: " + intent + " options: " + bundle);
        }
        getParentFragmentManager().Y0(this, intentSender, i8, intent, i9, i10, i11, bundle);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !e().f11891t) {
            return;
        }
        if (this.mHost == null) {
            e().f11891t = false;
        } else if (Looper.myLooper() != this.mHost.h().getLooper()) {
            this.mHost.h().postAtFrontOfQueue(new d());
        } else {
            callStartTransitionListener(true);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
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
    public static AbstractComponentCallbacksC1139p instantiate(Context context, String str, Bundle bundle) {
        try {
            AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p = (AbstractComponentCallbacksC1139p) AbstractC1148z.d(context.getClassLoader(), str).getConstructor(null).newInstance(null);
            if (bundle != null) {
                bundle.setClassLoader(abstractComponentCallbacksC1139p.getClass().getClassLoader());
                abstractComponentCallbacksC1139p.setArguments(bundle);
            }
            return abstractComponentCallbacksC1139p;
        } catch (IllegalAccessException e8) {
            throw new l("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e8);
        } catch (InstantiationException e9) {
            throw new l("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e9);
        } catch (NoSuchMethodException e10) {
            throw new l("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e10);
        } catch (InvocationTargetException e11) {
            throw new l("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e11);
        }
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        A a8 = this.mHost;
        if (a8 == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater layoutInflaterK = a8.k();
        AbstractC0929k.a(layoutInflaterK, this.mChildFragmentManager.x0());
        return layoutInflaterK;
    }

    public final String getString(int i8, Object... objArr) {
        return getResources().getString(i8, objArr);
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        A a8 = this.mHost;
        Activity activityE = a8 == null ? null : a8.e();
        if (activityE != null) {
            this.mCalled = false;
            onAttach(activityE);
        }
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        A a8 = this.mHost;
        Activity activityE = a8 == null ? null : a8.e();
        if (activityE != null) {
            this.mCalled = false;
            onInflate(activityE, attributeSet, bundle);
        }
    }

    public final void postponeEnterTransition(long j8, TimeUnit timeUnit) {
        e().f11891t = true;
        Handler handler = this.mPostponedHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mPostponedDurationRunnable);
        }
        I i8 = this.mFragmentManager;
        this.mPostponedHandler = i8 != null ? i8.w0().h() : new Handler(Looper.getMainLooper());
        this.mPostponedHandler.removeCallbacks(this.mPostponedDurationRunnable);
        this.mPostponedHandler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j8));
    }

    public final <I, O> e.c registerForActivityResult(AbstractC1725a abstractC1725a, e.d dVar, InterfaceC1657b interfaceC1657b) {
        return j(abstractC1725a, new i(dVar), interfaceC1657b);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        A a8 = this.mHost;
        if (a8 != null) {
            a8.n(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i8, Bundle bundle) {
        if (this.mHost != null) {
            getParentFragmentManager().X0(this, intent, i8, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }
}
