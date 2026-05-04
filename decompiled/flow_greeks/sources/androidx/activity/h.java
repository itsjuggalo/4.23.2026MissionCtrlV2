package androidx.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.h;
import androidx.lifecycle.c0;
import androidx.lifecycle.f0;
import androidx.lifecycle.i;
import androidx.lifecycle.j0;
import androidx.lifecycle.l0;
import androidx.lifecycle.m0;
import androidx.lifecycle.n0;
import androidx.lifecycle.o0;
import androidx.lifecycle.x;
import cd.h0;
import f.a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import k2.d;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h extends h0.f implements androidx.lifecycle.m, m0, androidx.lifecycle.g, k2.f, r, e.e, i0.c, i0.d, h0.n, h0.o, t0.k, n {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final e.d mActivityResultRegistry;
    private int mContentLayoutId;
    private j0.b mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    final m mFullyDrawnReporter;
    private final AtomicInteger mNextLocalRequestCode;
    private p mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<s0.a> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<s0.a> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<s0.a> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<s0.a> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<s0.a> mOnTrimMemoryListeners;
    final j mReportFullyDrawnExecutor;
    final k2.e mSavedStateRegistryController;
    private l0 mViewModelStore;
    final d.a mContextAwareHelper = new d.a();
    private final t0.n mMenuHostHelper = new t0.n(new Runnable() { // from class: androidx.activity.d
        @Override // java.lang.Runnable
        public final void run() {
            this.f884a.invalidateMenu();
        }
    });
    private final androidx.lifecycle.n mLifecycleRegistry = new androidx.lifecycle.n(this);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends e.d {

        /* JADX INFO: renamed from: androidx.activity.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class RunnableC0012a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f889a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.C0169a f890b;

            public RunnableC0012a(int i10, a.C0169a c0169a) {
                this.f889a = i10;
                this.f890b = c0169a;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c(this.f889a, this.f890b.a());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f892a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ IntentSender.SendIntentException f893b;

            public b(int i10, IntentSender.SendIntentException sendIntentException) {
                this.f892a = i10;
                this.f893b = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b(this.f892a, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f893b));
            }
        }

        public a() {
        }

        @Override // e.d
        public void f(int i10, f.a aVar, Object obj, h0.b bVar) {
            Bundle bundleExtra;
            int i11;
            h hVar = h.this;
            a.C0169a c0169aB = aVar.b(hVar, obj);
            if (c0169aB != null) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0012a(i10, c0169aB));
                return;
            }
            Intent intentA = aVar.a(hVar, obj);
            if (intentA.getExtras() != null && intentA.getExtras().getClassLoader() == null) {
                intentA.setExtrasClassLoader(hVar.getClassLoader());
            }
            if (intentA.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            } else {
                bundleExtra = null;
            }
            Bundle bundle = bundleExtra;
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentA.getAction())) {
                String[] stringArrayExtra = intentA.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                h0.a.r(hVar, stringArrayExtra, i10);
                return;
            }
            if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentA.getAction())) {
                h0.a.v(hVar, intentA, i10, bundle);
                return;
            }
            e.f fVar = (e.f) intentA.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                i11 = i10;
            } catch (IntentSender.SendIntentException e10) {
                e = e10;
                i11 = i10;
            }
            try {
                h0.a.w(hVar, fVar.e(), i11, fVar.a(), fVar.b(), fVar.d(), 0, bundle);
            } catch (IntentSender.SendIntentException e11) {
                e = e11;
                new Handler(Looper.getMainLooper()).post(new b(i11, e));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements androidx.lifecycle.k {
        public b() {
        }

        @Override // androidx.lifecycle.k
        public void b(androidx.lifecycle.m mVar, i.a aVar) {
            if (aVar == i.a.ON_STOP) {
                Window window = h.this.getWindow();
                View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                if (viewPeekDecorView != null) {
                    g.a(viewPeekDecorView);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements androidx.lifecycle.k {
        public c() {
        }

        @Override // androidx.lifecycle.k
        public void b(androidx.lifecycle.m mVar, i.a aVar) {
            if (aVar == i.a.ON_DESTROY) {
                h.this.mContextAwareHelper.b();
                if (!h.this.isChangingConfigurations()) {
                    h.this.getViewModelStore().a();
                }
                h.this.mReportFullyDrawnExecutor.c();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements androidx.lifecycle.k {
        public d() {
        }

        @Override // androidx.lifecycle.k
        public void b(androidx.lifecycle.m mVar, i.a aVar) {
            h.this.ensureViewModelStore();
            h.this.getLifecycle().c(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                h.super.onBackPressed();
            } catch (IllegalStateException e10) {
                if (!TextUtils.equals(e10.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e10;
                }
            } catch (NullPointerException e11) {
                if (!TextUtils.equals(e11.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                    throw e11;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class f implements androidx.lifecycle.k {
        public f() {
        }

        @Override // androidx.lifecycle.k
        public void b(androidx.lifecycle.m mVar, i.a aVar) {
            if (aVar != i.a.ON_CREATE || Build.VERSION.SDK_INT < 33) {
                return;
            }
            h.this.mOnBackPressedDispatcher.n(C0013h.a((h) mVar));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class g {
        public static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    /* JADX INFO: renamed from: androidx.activity.h$h, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0013h {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public l0 f901b;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface j extends Executor {
        void G(View view);

        void c();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class k implements j, ViewTreeObserver.OnDrawListener, Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Runnable f903b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f902a = SystemClock.uptimeMillis() + 10000;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f904c = false;

        public k() {
        }

        public static /* synthetic */ void a(k kVar) {
            Runnable runnable = kVar.f903b;
            if (runnable != null) {
                runnable.run();
                kVar.f903b = null;
            }
        }

        @Override // androidx.activity.h.j
        public void G(View view) {
            if (this.f904c) {
                return;
            }
            this.f904c = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }

        @Override // androidx.activity.h.j
        public void c() {
            h.this.getWindow().getDecorView().removeCallbacks(this);
            h.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f903b = runnable;
            View decorView = h.this.getWindow().getDecorView();
            if (!this.f904c) {
                decorView.postOnAnimation(new Runnable() { // from class: androidx.activity.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.k.a(this.f906a);
                    }
                });
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.f903b;
            if (runnable == null) {
                if (SystemClock.uptimeMillis() > this.f902a) {
                    this.f904c = false;
                    h.this.getWindow().getDecorView().post(this);
                    return;
                }
                return;
            }
            runnable.run();
            this.f903b = null;
            if (h.this.mFullyDrawnReporter.c()) {
                this.f904c = false;
                h.this.getWindow().getDecorView().post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    public h() {
        k2.e eVarA = k2.e.a(this);
        this.mSavedStateRegistryController = eVarA;
        this.mOnBackPressedDispatcher = null;
        j jVarE = e();
        this.mReportFullyDrawnExecutor = jVarE;
        this.mFullyDrawnReporter = new m(jVarE, new Function0() { // from class: androidx.activity.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return h.d(this.f885a);
            }
        });
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new a();
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        getLifecycle().a(new b());
        getLifecycle().a(new c());
        getLifecycle().a(new d());
        eVarA.c();
        c0.c(this);
        getSavedStateRegistry().h(ACTIVITY_RESULT_TAG, new d.c() { // from class: androidx.activity.f
            @Override // k2.d.c
            public final Bundle a() {
                return h.c(this.f886a);
            }
        });
        addOnContextAvailableListener(new d.b() { // from class: androidx.activity.g
            @Override // d.b
            public final void a(Context context) {
                h.b(this.f887a, context);
            }
        });
    }

    public static /* synthetic */ void b(h hVar, Context context) {
        Bundle bundleB = hVar.getSavedStateRegistry().b(ACTIVITY_RESULT_TAG);
        if (bundleB != null) {
            hVar.mActivityResultRegistry.g(bundleB);
        }
    }

    public static /* synthetic */ Bundle c(h hVar) {
        hVar.getClass();
        Bundle bundle = new Bundle();
        hVar.mActivityResultRegistry.h(bundle);
        return bundle;
    }

    public static /* synthetic */ h0 d(h hVar) {
        hVar.reportFullyDrawn();
        return null;
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.G(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override // t0.k
    public void addMenuProvider(t0.p pVar) {
        this.mMenuHostHelper.c(pVar);
    }

    @Override // i0.c
    public final void addOnConfigurationChangedListener(s0.a aVar) {
        this.mOnConfigurationChangedListeners.add(aVar);
    }

    public final void addOnContextAvailableListener(d.b bVar) {
        this.mContextAwareHelper.a(bVar);
    }

    @Override // h0.n
    public final void addOnMultiWindowModeChangedListener(s0.a aVar) {
        this.mOnMultiWindowModeChangedListeners.add(aVar);
    }

    public final void addOnNewIntentListener(s0.a aVar) {
        this.mOnNewIntentListeners.add(aVar);
    }

    @Override // h0.o
    public final void addOnPictureInPictureModeChangedListener(s0.a aVar) {
        this.mOnPictureInPictureModeChangedListeners.add(aVar);
    }

    @Override // i0.d
    public final void addOnTrimMemoryListener(s0.a aVar) {
        this.mOnTrimMemoryListeners.add(aVar);
    }

    public final j e() {
        return new k();
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            i iVar = (i) getLastNonConfigurationInstance();
            if (iVar != null) {
                this.mViewModelStore = iVar.f901b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new l0();
            }
        }
    }

    @Override // e.e
    public final e.d getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.g
    public y1.a getDefaultViewModelCreationExtras() {
        y1.b bVar = new y1.b();
        if (getApplication() != null) {
            bVar.c(j0.a.f2437h, getApplication());
        }
        bVar.c(c0.f2396a, this);
        bVar.c(c0.f2397b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            bVar.c(c0.f2398c, getIntent().getExtras());
        }
        return bVar;
    }

    public j0.b getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new f0(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    public m getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        i iVar = (i) getLastNonConfigurationInstance();
        if (iVar != null) {
            return iVar.f900a;
        }
        return null;
    }

    @Override // androidx.lifecycle.m
    public androidx.lifecycle.i getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.r
    public final p getOnBackPressedDispatcher() {
        if (this.mOnBackPressedDispatcher == null) {
            this.mOnBackPressedDispatcher = new p(new e());
            getLifecycle().a(new f());
        }
        return this.mOnBackPressedDispatcher;
    }

    @Override // k2.f
    public final k2.d getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    @Override // androidx.lifecycle.m0
    public l0 getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        ensureViewModelStore();
        return this.mViewModelStore;
    }

    public void initializeViewTreeOwners() {
        n0.a(getWindow().getDecorView(), this);
        o0.a(getWindow().getDecorView(), this);
        k2.g.a(getWindow().getDecorView(), this);
        u.a(getWindow().getDecorView(), this);
        t.a(getWindow().getDecorView(), this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (this.mActivityResultRegistry.b(i10, i11, intent)) {
            return;
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        getOnBackPressedDispatcher().k();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<s0.a> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // h0.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.d(bundle);
        this.mContextAwareHelper.c(this);
        super.onCreate(bundle);
        x.e(this);
        int i10 = this.mContentLayoutId;
        if (i10 != 0) {
            setContentView(i10);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i10, Menu menu) {
        if (i10 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i10, menu);
        this.mMenuHostHelper.f(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 0) {
            return this.mMenuHostHelper.h(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z10) {
        if (this.mDispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<s0.a> it = this.mOnMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new h0.g(z10));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator<s0.a> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i10, Menu menu) {
        this.mMenuHostHelper.g(menu);
        super.onPanelClosed(i10, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z10) {
        if (this.mDispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<s0.a> it = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new h0.r(z10));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i10, View view, Menu menu) {
        if (i10 != 0) {
            return true;
        }
        super.onPreparePanel(i10, view, menu);
        this.mMenuHostHelper.i(menu);
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (this.mActivityResultRegistry.b(i10, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        i iVar;
        Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        l0 l0Var = this.mViewModelStore;
        if (l0Var == null && (iVar = (i) getLastNonConfigurationInstance()) != null) {
            l0Var = iVar.f901b;
        }
        if (l0Var == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        i iVar2 = new i();
        iVar2.f900a = objOnRetainCustomNonConfigurationInstance;
        iVar2.f901b = l0Var;
        return iVar2;
    }

    @Override // h0.f, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.i lifecycle = getLifecycle();
        if (lifecycle instanceof androidx.lifecycle.n) {
            ((androidx.lifecycle.n) lifecycle).m(i.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.e(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        Iterator<s0.a> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i10));
        }
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.d();
    }

    public final <I, O> e.c registerForActivityResult(f.a aVar, e.d dVar, e.b bVar) {
        return dVar.i("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, aVar, bVar);
    }

    @Override // t0.k
    public void removeMenuProvider(t0.p pVar) {
        this.mMenuHostHelper.j(pVar);
    }

    @Override // i0.c
    public final void removeOnConfigurationChangedListener(s0.a aVar) {
        this.mOnConfigurationChangedListeners.remove(aVar);
    }

    public final void removeOnContextAvailableListener(d.b bVar) {
        this.mContextAwareHelper.e(bVar);
    }

    @Override // h0.n
    public final void removeOnMultiWindowModeChangedListener(s0.a aVar) {
        this.mOnMultiWindowModeChangedListeners.remove(aVar);
    }

    public final void removeOnNewIntentListener(s0.a aVar) {
        this.mOnNewIntentListeners.remove(aVar);
    }

    @Override // h0.o
    public final void removeOnPictureInPictureModeChangedListener(s0.a aVar) {
        this.mOnPictureInPictureModeChangedListeners.remove(aVar);
    }

    @Override // i0.d
    public final void removeOnTrimMemoryListener(s0.a aVar) {
        this.mOnTrimMemoryListeners.remove(aVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (m2.a.h()) {
                m2.a.c("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            this.mFullyDrawnReporter.b();
            m2.a.f();
        } catch (Throwable th) {
            m2.a.f();
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i10) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.G(getWindow().getDecorView());
        super.setContentView(i10);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i10) {
        super.startActivityForResult(intent, i10);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13);
    }

    public void addMenuProvider(t0.p pVar, androidx.lifecycle.m mVar) {
        this.mMenuHostHelper.d(pVar, mVar);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i10, Bundle bundle) {
        super.startActivityForResult(intent, i10, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
    }

    public void addMenuProvider(t0.p pVar, androidx.lifecycle.m mVar, i.b bVar) {
        this.mMenuHostHelper.e(pVar, mVar, bVar);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z10, Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z10, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<s0.a> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new h0.g(z10, configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z10, Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z10, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<s0.a> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new h0.r(z10, configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    public final <I, O> e.c registerForActivityResult(f.a aVar, e.b bVar) {
        return registerForActivityResult(aVar, this.mActivityResultRegistry, bVar);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.G(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.G(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }
}
