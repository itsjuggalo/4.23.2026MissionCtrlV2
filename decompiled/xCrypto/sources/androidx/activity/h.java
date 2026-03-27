package androidx.activity;

import H.C0282p;
import H.InterfaceC0279m;
import W2.E;
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
import androidx.lifecycle.AbstractC0846i;
import androidx.lifecycle.C0851n;
import androidx.lifecycle.D;
import androidx.lifecycle.G;
import androidx.lifecycle.InterfaceC0844g;
import androidx.lifecycle.InterfaceC0848k;
import androidx.lifecycle.InterfaceC0850m;
import androidx.lifecycle.K;
import androidx.lifecycle.M;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.P;
import androidx.lifecycle.x;
import c0.AbstractC0870a;
import c0.C0871b;
import d.C1206a;
import d.InterfaceC1207b;
import e.AbstractC1221c;
import e.AbstractC1222d;
import e.C1224f;
import e.InterfaceC1220b;
import e.InterfaceC1223e;
import f.AbstractC1238a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;
import o0.d;
import q0.AbstractC1718a;
import w.AbstractC1897a;
import w.AbstractC1898b;
import x.InterfaceC1911c;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends w.g implements InterfaceC0850m, N, InterfaceC0844g, o0.f, s, InterfaceC1223e, InterfaceC1911c, x.d, w.q, w.r, InterfaceC0279m, o {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final AbstractC1222d mActivityResultRegistry;
    private int mContentLayoutId;
    private K.b mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    final n mFullyDrawnReporter;
    private final AtomicInteger mNextLocalRequestCode;
    private q mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<G.a> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<G.a> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<G.a> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<G.a> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<G.a> mOnTrimMemoryListeners;
    final j mReportFullyDrawnExecutor;
    final o0.e mSavedStateRegistryController;
    private M mViewModelStore;
    final C1206a mContextAwareHelper = new C1206a();
    private final C0282p mMenuHostHelper = new C0282p(new Runnable() { // from class: androidx.activity.d
        @Override // java.lang.Runnable
        public final void run() {
            this.f6256a.invalidateMenu();
        }
    });
    private final C0851n mLifecycleRegistry = new C0851n(this);

    public class a extends AbstractC1222d {

        /* JADX INFO: renamed from: androidx.activity.h$a$a, reason: collision with other inner class name */
        public class RunnableC0092a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f6261a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AbstractC1238a.C0191a f6262b;

            public RunnableC0092a(int i4, AbstractC1238a.C0191a c0191a) {
                this.f6261a = i4;
                this.f6262b = c0191a;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c(this.f6261a, this.f6262b.a());
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f6264a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ IntentSender.SendIntentException f6265b;

            public b(int i4, IntentSender.SendIntentException sendIntentException) {
                this.f6264a = i4;
                this.f6265b = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b(this.f6264a, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f6265b));
            }
        }

        public a() {
        }

        @Override // e.AbstractC1222d
        public void f(int i4, AbstractC1238a abstractC1238a, Object obj, AbstractC1898b abstractC1898b) {
            Bundle bundleExtra;
            int i5;
            h hVar = h.this;
            AbstractC1238a.C0191a c0191aB = abstractC1238a.b(hVar, obj);
            if (c0191aB != null) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0092a(i4, c0191aB));
                return;
            }
            Intent intentA = abstractC1238a.a(hVar, obj);
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
                AbstractC1897a.c(hVar, stringArrayExtra, i4);
                return;
            }
            if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentA.getAction())) {
                AbstractC1897a.g(hVar, intentA, i4, bundle);
                return;
            }
            C1224f c1224f = (C1224f) intentA.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                i5 = i4;
            } catch (IntentSender.SendIntentException e4) {
                e = e4;
                i5 = i4;
            }
            try {
                AbstractC1897a.h(hVar, c1224f.d(), i5, c1224f.a(), c1224f.b(), c1224f.c(), 0, bundle);
            } catch (IntentSender.SendIntentException e5) {
                e = e5;
                new Handler(Looper.getMainLooper()).post(new b(i5, e));
            }
        }
    }

    public class b implements InterfaceC0848k {
        public b() {
        }

        @Override // androidx.lifecycle.InterfaceC0848k
        public void a(InterfaceC0850m interfaceC0850m, AbstractC0846i.a aVar) {
            if (aVar == AbstractC0846i.a.ON_STOP) {
                Window window = h.this.getWindow();
                View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                if (viewPeekDecorView != null) {
                    g.a(viewPeekDecorView);
                }
            }
        }
    }

    public class c implements InterfaceC0848k {
        public c() {
        }

        @Override // androidx.lifecycle.InterfaceC0848k
        public void a(InterfaceC0850m interfaceC0850m, AbstractC0846i.a aVar) {
            if (aVar == AbstractC0846i.a.ON_DESTROY) {
                h.this.mContextAwareHelper.b();
                if (!h.this.isChangingConfigurations()) {
                    h.this.getViewModelStore().a();
                }
                h.this.mReportFullyDrawnExecutor.g();
            }
        }
    }

    public class d implements InterfaceC0848k {
        public d() {
        }

        @Override // androidx.lifecycle.InterfaceC0848k
        public void a(InterfaceC0850m interfaceC0850m, AbstractC0846i.a aVar) {
            h.this.ensureViewModelStore();
            h.this.getLifecycle().c(this);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                h.super.onBackPressed();
            } catch (IllegalStateException e4) {
                if (!TextUtils.equals(e4.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e4;
                }
            } catch (NullPointerException e5) {
                if (!TextUtils.equals(e5.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                    throw e5;
                }
            }
        }
    }

    public class f implements InterfaceC0848k {
        public f() {
        }

        @Override // androidx.lifecycle.InterfaceC0848k
        public void a(InterfaceC0850m interfaceC0850m, AbstractC0846i.a aVar) {
            if (aVar != AbstractC0846i.a.ON_CREATE || Build.VERSION.SDK_INT < 33) {
                return;
            }
            h.this.mOnBackPressedDispatcher.n(C0093h.a((h) interfaceC0850m));
        }
    }

    public static class g {
        public static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    /* JADX INFO: renamed from: androidx.activity.h$h, reason: collision with other inner class name */
    public static class C0093h {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public M f6273b;
    }

    public interface j extends Executor {
        void E(View view);

        void g();
    }

    public class k implements j, ViewTreeObserver.OnDrawListener, Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Runnable f6275b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f6274a = SystemClock.uptimeMillis() + 10000;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6276c = false;

        public k() {
        }

        public static /* synthetic */ void a(k kVar) {
            Runnable runnable = kVar.f6275b;
            if (runnable != null) {
                runnable.run();
                kVar.f6275b = null;
            }
        }

        @Override // androidx.activity.h.j
        public void E(View view) {
            if (this.f6276c) {
                return;
            }
            this.f6276c = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f6275b = runnable;
            View decorView = h.this.getWindow().getDecorView();
            if (!this.f6276c) {
                decorView.postOnAnimation(new Runnable() { // from class: androidx.activity.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.k.a(this.f6278a);
                    }
                });
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // androidx.activity.h.j
        public void g() {
            h.this.getWindow().getDecorView().removeCallbacks(this);
            h.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.f6275b;
            if (runnable == null) {
                if (SystemClock.uptimeMillis() > this.f6274a) {
                    this.f6276c = false;
                    h.this.getWindow().getDecorView().post(this);
                    return;
                }
                return;
            }
            runnable.run();
            this.f6275b = null;
            if (h.this.mFullyDrawnReporter.c()) {
                this.f6276c = false;
                h.this.getWindow().getDecorView().post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    public h() {
        o0.e eVarA = o0.e.a(this);
        this.mSavedStateRegistryController = eVarA;
        this.mOnBackPressedDispatcher = null;
        j jVarE = e();
        this.mReportFullyDrawnExecutor = jVarE;
        this.mFullyDrawnReporter = new n(jVarE, new Function0() { // from class: androidx.activity.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return h.d(this.f6257a);
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
        D.c(this);
        getSavedStateRegistry().h(ACTIVITY_RESULT_TAG, new d.c() { // from class: androidx.activity.f
            @Override // o0.d.c
            public final Bundle a() {
                return h.c(this.f6258a);
            }
        });
        addOnContextAvailableListener(new InterfaceC1207b() { // from class: androidx.activity.g
            @Override // d.InterfaceC1207b
            public final void a(Context context) {
                h.b(this.f6259a, context);
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

    public static /* synthetic */ E d(h hVar) {
        hVar.reportFullyDrawn();
        return null;
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.E(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override // H.InterfaceC0279m
    public void addMenuProvider(H.r rVar) {
        this.mMenuHostHelper.c(rVar);
    }

    @Override // x.InterfaceC1911c
    public final void addOnConfigurationChangedListener(G.a aVar) {
        this.mOnConfigurationChangedListeners.add(aVar);
    }

    public final void addOnContextAvailableListener(InterfaceC1207b interfaceC1207b) {
        this.mContextAwareHelper.a(interfaceC1207b);
    }

    @Override // w.q
    public final void addOnMultiWindowModeChangedListener(G.a aVar) {
        this.mOnMultiWindowModeChangedListeners.add(aVar);
    }

    public final void addOnNewIntentListener(G.a aVar) {
        this.mOnNewIntentListeners.add(aVar);
    }

    @Override // w.r
    public final void addOnPictureInPictureModeChangedListener(G.a aVar) {
        this.mOnPictureInPictureModeChangedListeners.add(aVar);
    }

    @Override // x.d
    public final void addOnTrimMemoryListener(G.a aVar) {
        this.mOnTrimMemoryListeners.add(aVar);
    }

    public final j e() {
        return new k();
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            i iVar = (i) getLastNonConfigurationInstance();
            if (iVar != null) {
                this.mViewModelStore = iVar.f6273b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new M();
            }
        }
    }

    @Override // e.InterfaceC1223e
    public final AbstractC1222d getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.InterfaceC0844g
    public AbstractC0870a getDefaultViewModelCreationExtras() {
        C0871b c0871b = new C0871b();
        if (getApplication() != null) {
            c0871b.c(K.a.f7651h, getApplication());
        }
        c0871b.c(D.f7627a, this);
        c0871b.c(D.f7628b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            c0871b.c(D.f7629c, getIntent().getExtras());
        }
        return c0871b;
    }

    public K.b getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new G(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    public n getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        i iVar = (i) getLastNonConfigurationInstance();
        if (iVar != null) {
            return iVar.f6272a;
        }
        return null;
    }

    @Override // androidx.lifecycle.InterfaceC0850m
    public AbstractC0846i getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.s
    public final q getOnBackPressedDispatcher() {
        if (this.mOnBackPressedDispatcher == null) {
            this.mOnBackPressedDispatcher = new q(new e());
            getLifecycle().a(new f());
        }
        return this.mOnBackPressedDispatcher;
    }

    @Override // o0.f
    public final o0.d getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    @Override // androidx.lifecycle.N
    public M getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        ensureViewModelStore();
        return this.mViewModelStore;
    }

    public void initializeViewTreeOwners() {
        O.a(getWindow().getDecorView(), this);
        P.a(getWindow().getDecorView(), this);
        o0.g.a(getWindow().getDecorView(), this);
        v.a(getWindow().getDecorView(), this);
        u.a(getWindow().getDecorView(), this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        if (this.mActivityResultRegistry.b(i4, i5, intent)) {
            return;
        }
        super.onActivityResult(i4, i5, intent);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onBackPressed() {
        getOnBackPressedDispatcher().k();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<G.a> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // w.g, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.d(bundle);
        this.mContextAwareHelper.c(this);
        super.onCreate(bundle);
        x.e(this);
        int i4 = this.mContentLayoutId;
        if (i4 != 0) {
            setContentView(i4);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i4, Menu menu) {
        if (i4 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i4, menu);
        this.mMenuHostHelper.f(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i4, MenuItem menuItem) {
        if (super.onMenuItemSelected(i4, menuItem)) {
            return true;
        }
        if (i4 == 0) {
            return this.mMenuHostHelper.h(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z4) {
        if (this.mDispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<G.a> it = this.mOnMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new w.i(z4));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator<G.a> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i4, Menu menu) {
        this.mMenuHostHelper.g(menu);
        super.onPanelClosed(i4, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z4) {
        if (this.mDispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<G.a> it = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new w.u(z4));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i4, View view, Menu menu) {
        if (i4 != 0) {
            return true;
        }
        super.onPreparePanel(i4, view, menu);
        this.mMenuHostHelper.i(menu);
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i4, String[] strArr, int[] iArr) {
        if (this.mActivityResultRegistry.b(i4, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i4, strArr, iArr);
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        i iVar;
        Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        M m4 = this.mViewModelStore;
        if (m4 == null && (iVar = (i) getLastNonConfigurationInstance()) != null) {
            m4 = iVar.f6273b;
        }
        if (m4 == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        i iVar2 = new i();
        iVar2.f6272a = objOnRetainCustomNonConfigurationInstance;
        iVar2.f6273b = m4;
        return iVar2;
    }

    @Override // w.g, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        AbstractC0846i lifecycle = getLifecycle();
        if (lifecycle instanceof C0851n) {
            ((C0851n) lifecycle).m(AbstractC0846i.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.e(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i4) {
        super.onTrimMemory(i4);
        Iterator<G.a> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i4));
        }
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.d();
    }

    public final <I, O> AbstractC1221c registerForActivityResult(AbstractC1238a abstractC1238a, AbstractC1222d abstractC1222d, InterfaceC1220b interfaceC1220b) {
        return abstractC1222d.i("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, abstractC1238a, interfaceC1220b);
    }

    @Override // H.InterfaceC0279m
    public void removeMenuProvider(H.r rVar) {
        this.mMenuHostHelper.j(rVar);
    }

    @Override // x.InterfaceC1911c
    public final void removeOnConfigurationChangedListener(G.a aVar) {
        this.mOnConfigurationChangedListeners.remove(aVar);
    }

    public final void removeOnContextAvailableListener(InterfaceC1207b interfaceC1207b) {
        this.mContextAwareHelper.e(interfaceC1207b);
    }

    @Override // w.q
    public final void removeOnMultiWindowModeChangedListener(G.a aVar) {
        this.mOnMultiWindowModeChangedListeners.remove(aVar);
    }

    public final void removeOnNewIntentListener(G.a aVar) {
        this.mOnNewIntentListeners.remove(aVar);
    }

    @Override // w.r
    public final void removeOnPictureInPictureModeChangedListener(G.a aVar) {
        this.mOnPictureInPictureModeChangedListeners.remove(aVar);
    }

    @Override // x.d
    public final void removeOnTrimMemoryListener(G.a aVar) {
        this.mOnTrimMemoryListeners.remove(aVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (AbstractC1718a.h()) {
                AbstractC1718a.c("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            this.mFullyDrawnReporter.b();
            AbstractC1718a.f();
        } catch (Throwable th) {
            AbstractC1718a.f();
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i4) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.E(getWindow().getDecorView());
        super.setContentView(i4);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i4) {
        super.startActivityForResult(intent, i4);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i4, Intent intent, int i5, int i6, int i7) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i4, intent, i5, i6, i7);
    }

    public void addMenuProvider(H.r rVar, InterfaceC0850m interfaceC0850m) {
        this.mMenuHostHelper.d(rVar, interfaceC0850m);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i4, Bundle bundle) {
        super.startActivityForResult(intent, i4, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i4, Intent intent, int i5, int i6, int i7, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i4, intent, i5, i6, i7, bundle);
    }

    public void addMenuProvider(H.r rVar, InterfaceC0850m interfaceC0850m, AbstractC0846i.b bVar) {
        this.mMenuHostHelper.e(rVar, interfaceC0850m, bVar);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z4, Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z4, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<G.a> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new w.i(z4, configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z4, Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z4, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<G.a> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new w.u(z4, configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    public final <I, O> AbstractC1221c registerForActivityResult(AbstractC1238a abstractC1238a, InterfaceC1220b interfaceC1220b) {
        return registerForActivityResult(abstractC1238a, this.mActivityResultRegistry, interfaceC1220b);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.E(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.E(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }
}
