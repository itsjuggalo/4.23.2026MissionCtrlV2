package androidx.fragment.app;

import H.InterfaceC0279m;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.AbstractC0846i;
import androidx.lifecycle.C0851n;
import d.InterfaceC1207b;
import d0.AbstractC1208a;
import e.AbstractC1222d;
import e.InterfaceC1223e;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import o0.d;
import w.AbstractC1897a;
import x.InterfaceC1911c;

/* JADX INFO: renamed from: androidx.fragment.app.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractActivityC0832u extends androidx.activity.h implements AbstractC1897a.e {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    boolean mResumed;
    final C0836y mFragments = C0836y.b(new a());
    final C0851n mFragmentLifecycleRegistry = new C0851n(this);
    boolean mStopped = true;

    /* JADX INFO: renamed from: androidx.fragment.app.u$a */
    public class a extends A implements InterfaceC1911c, x.d, w.q, w.r, androidx.lifecycle.N, androidx.activity.s, InterfaceC1223e, o0.f, M, InterfaceC0279m {
        public a() {
            super(AbstractActivityC0832u.this);
        }

        @Override // androidx.fragment.app.M
        public void a(I i4, AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
            AbstractActivityC0832u.this.onAttachFragment(abstractComponentCallbacksC0828p);
        }

        @Override // H.InterfaceC0279m
        public void addMenuProvider(H.r rVar) {
            AbstractActivityC0832u.this.addMenuProvider(rVar);
        }

        @Override // x.InterfaceC1911c
        public void addOnConfigurationChangedListener(G.a aVar) {
            AbstractActivityC0832u.this.addOnConfigurationChangedListener(aVar);
        }

        @Override // w.q
        public void addOnMultiWindowModeChangedListener(G.a aVar) {
            AbstractActivityC0832u.this.addOnMultiWindowModeChangedListener(aVar);
        }

        @Override // w.r
        public void addOnPictureInPictureModeChangedListener(G.a aVar) {
            AbstractActivityC0832u.this.addOnPictureInPictureModeChangedListener(aVar);
        }

        @Override // x.d
        public void addOnTrimMemoryListener(G.a aVar) {
            AbstractActivityC0832u.this.addOnTrimMemoryListener(aVar);
        }

        @Override // androidx.fragment.app.AbstractC0834w
        public View c(int i4) {
            return AbstractActivityC0832u.this.findViewById(i4);
        }

        @Override // androidx.fragment.app.AbstractC0834w
        public boolean d() {
            Window window = AbstractActivityC0832u.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // e.InterfaceC1223e
        public AbstractC1222d getActivityResultRegistry() {
            return AbstractActivityC0832u.this.getActivityResultRegistry();
        }

        @Override // androidx.lifecycle.InterfaceC0850m
        public AbstractC0846i getLifecycle() {
            return AbstractActivityC0832u.this.mFragmentLifecycleRegistry;
        }

        @Override // androidx.activity.s
        public androidx.activity.q getOnBackPressedDispatcher() {
            return AbstractActivityC0832u.this.getOnBackPressedDispatcher();
        }

        @Override // o0.f
        public o0.d getSavedStateRegistry() {
            return AbstractActivityC0832u.this.getSavedStateRegistry();
        }

        @Override // androidx.lifecycle.N
        public androidx.lifecycle.M getViewModelStore() {
            return AbstractActivityC0832u.this.getViewModelStore();
        }

        @Override // androidx.fragment.app.A
        public void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            AbstractActivityC0832u.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.A
        public LayoutInflater k() {
            return AbstractActivityC0832u.this.getLayoutInflater().cloneInContext(AbstractActivityC0832u.this);
        }

        @Override // androidx.fragment.app.A
        public boolean m(String str) {
            return AbstractC1897a.f(AbstractActivityC0832u.this, str);
        }

        @Override // androidx.fragment.app.A
        public void p() {
            q();
        }

        public void q() {
            AbstractActivityC0832u.this.invalidateMenu();
        }

        @Override // androidx.fragment.app.A
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public AbstractActivityC0832u j() {
            return AbstractActivityC0832u.this;
        }

        @Override // H.InterfaceC0279m
        public void removeMenuProvider(H.r rVar) {
            AbstractActivityC0832u.this.removeMenuProvider(rVar);
        }

        @Override // x.InterfaceC1911c
        public void removeOnConfigurationChangedListener(G.a aVar) {
            AbstractActivityC0832u.this.removeOnConfigurationChangedListener(aVar);
        }

        @Override // w.q
        public void removeOnMultiWindowModeChangedListener(G.a aVar) {
            AbstractActivityC0832u.this.removeOnMultiWindowModeChangedListener(aVar);
        }

        @Override // w.r
        public void removeOnPictureInPictureModeChangedListener(G.a aVar) {
            AbstractActivityC0832u.this.removeOnPictureInPictureModeChangedListener(aVar);
        }

        @Override // x.d
        public void removeOnTrimMemoryListener(G.a aVar) {
            AbstractActivityC0832u.this.removeOnTrimMemoryListener(aVar);
        }
    }

    public AbstractActivityC0832u() {
        j();
    }

    public static /* synthetic */ Bundle h(AbstractActivityC0832u abstractActivityC0832u) {
        abstractActivityC0832u.markFragmentsCreated();
        abstractActivityC0832u.mFragmentLifecycleRegistry.h(AbstractC0846i.a.ON_STOP);
        return new Bundle();
    }

    public static boolean k(I i4, AbstractC0846i.b bVar) {
        boolean zK = false;
        for (AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p : i4.v0()) {
            if (abstractComponentCallbacksC0828p != null) {
                if (abstractComponentCallbacksC0828p.getHost() != null) {
                    zK |= k(abstractComponentCallbacksC0828p.getChildFragmentManager(), bVar);
                }
                V v4 = abstractComponentCallbacksC0828p.mViewLifecycleOwner;
                if (v4 != null && v4.getLifecycle().b().c(AbstractC0846i.b.STARTED)) {
                    abstractComponentCallbacksC0828p.mViewLifecycleOwner.f(bVar);
                    zK = true;
                }
                if (abstractComponentCallbacksC0828p.mLifecycleRegistry.b().c(AbstractC0846i.b.STARTED)) {
                    abstractComponentCallbacksC0828p.mLifecycleRegistry.m(bVar);
                    zK = true;
                }
            }
        }
        return zK;
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.n(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (shouldDumpInternalState(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.mCreated);
            printWriter.print(" mResumed=");
            printWriter.print(this.mResumed);
            printWriter.print(" mStopped=");
            printWriter.print(this.mStopped);
            if (getApplication() != null) {
                AbstractC1208a.b(this).a(str2, fileDescriptor, printWriter, strArr);
            }
            this.mFragments.l().X(str, fileDescriptor, printWriter, strArr);
        }
    }

    public I getSupportFragmentManager() {
        return this.mFragments.l();
    }

    @Deprecated
    public AbstractC1208a getSupportLoaderManager() {
        return AbstractC1208a.b(this);
    }

    public final void j() {
        getSavedStateRegistry().h(LIFECYCLE_TAG, new d.c() { // from class: androidx.fragment.app.q
            @Override // o0.d.c
            public final Bundle a() {
                return AbstractActivityC0832u.h(this.f7597a);
            }
        });
        addOnConfigurationChangedListener(new G.a() { // from class: androidx.fragment.app.r
            @Override // G.a
            public final void accept(Object obj) {
                this.f7598a.mFragments.m();
            }
        });
        addOnNewIntentListener(new G.a() { // from class: androidx.fragment.app.s
            @Override // G.a
            public final void accept(Object obj) {
                this.f7599a.mFragments.m();
            }
        });
        addOnContextAvailableListener(new InterfaceC1207b() { // from class: androidx.fragment.app.t
            @Override // d.InterfaceC1207b
            public final void a(Context context) {
                this.f7600a.mFragments.a(null);
            }
        });
    }

    public void markFragmentsCreated() {
        while (k(getSupportFragmentManager(), AbstractC0846i.b.CREATED)) {
        }
    }

    @Override // androidx.activity.h, android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        this.mFragments.m();
        super.onActivityResult(i4, i5, intent);
    }

    @Deprecated
    public void onAttachFragment(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
    }

    @Override // androidx.activity.h, w.g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.h(AbstractC0846i.a.ON_CREATE);
        this.mFragments.e();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.f();
        this.mFragmentLifecycleRegistry.h(AbstractC0846i.a.ON_DESTROY);
    }

    @Override // androidx.activity.h, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i4, MenuItem menuItem) {
        if (super.onMenuItemSelected(i4, menuItem)) {
            return true;
        }
        if (i4 == 6) {
            return this.mFragments.d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.g();
        this.mFragmentLifecycleRegistry.h(AbstractC0846i.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // androidx.activity.h, android.app.Activity
    public void onRequestPermissionsResult(int i4, String[] strArr, int[] iArr) {
        this.mFragments.m();
        super.onRequestPermissionsResult(i4, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.m();
        super.onResume();
        this.mResumed = true;
        this.mFragments.k();
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.h(AbstractC0846i.a.ON_RESUME);
        this.mFragments.h();
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.m();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.c();
        }
        this.mFragments.k();
        this.mFragmentLifecycleRegistry.h(AbstractC0846i.a.ON_START);
        this.mFragments.i();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.m();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.j();
        this.mFragmentLifecycleRegistry.h(AbstractC0846i.a.ON_STOP);
    }

    public void setEnterSharedElementCallback(w.w wVar) {
        AbstractC1897a.d(this, wVar);
    }

    public void setExitSharedElementCallback(w.w wVar) {
        AbstractC1897a.e(this, wVar);
    }

    public void startActivityFromFragment(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p, Intent intent, int i4) {
        startActivityFromFragment(abstractComponentCallbacksC0828p, intent, i4, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p, IntentSender intentSender, int i4, Intent intent, int i5, int i6, int i7, Bundle bundle) throws IntentSender.SendIntentException {
        if (i4 == -1) {
            AbstractC1897a.h(this, intentSender, i4, intent, i5, i6, i7, bundle);
        } else {
            abstractComponentCallbacksC0828p.startIntentSenderForResult(intentSender, i4, intent, i5, i6, i7, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        AbstractC1897a.a(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateMenu();
    }

    public void supportPostponeEnterTransition() {
        AbstractC1897a.b(this);
    }

    public void supportStartPostponedEnterTransition() {
        AbstractC1897a.i(this);
    }

    @Override // w.AbstractC1897a.e
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i4) {
    }

    public void startActivityFromFragment(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p, Intent intent, int i4, Bundle bundle) {
        if (i4 == -1) {
            AbstractC1897a.g(this, intent, -1, bundle);
        } else {
            abstractComponentCallbacksC0828p.startActivityForResult(intent, i4, bundle);
        }
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }
}
