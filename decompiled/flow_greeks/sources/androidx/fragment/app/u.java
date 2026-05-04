package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.i;
import h0.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import k2.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class u extends androidx.activity.h implements a.e {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    boolean mResumed;
    final y mFragments = y.b(new a());
    final androidx.lifecycle.n mFragmentLifecycleRegistry = new androidx.lifecycle.n(this);
    boolean mStopped = true;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends a0 implements i0.c, i0.d, h0.n, h0.o, androidx.lifecycle.m0, androidx.activity.r, e.e, k2.f, m0, t0.k {
        public a() {
            super(u.this);
        }

        @Override // androidx.fragment.app.m0
        public void a(i0 i0Var, p pVar) {
            u.this.onAttachFragment(pVar);
        }

        @Override // t0.k
        public void addMenuProvider(t0.p pVar) {
            u.this.addMenuProvider(pVar);
        }

        @Override // i0.c
        public void addOnConfigurationChangedListener(s0.a aVar) {
            u.this.addOnConfigurationChangedListener(aVar);
        }

        @Override // h0.n
        public void addOnMultiWindowModeChangedListener(s0.a aVar) {
            u.this.addOnMultiWindowModeChangedListener(aVar);
        }

        @Override // h0.o
        public void addOnPictureInPictureModeChangedListener(s0.a aVar) {
            u.this.addOnPictureInPictureModeChangedListener(aVar);
        }

        @Override // i0.d
        public void addOnTrimMemoryListener(s0.a aVar) {
            u.this.addOnTrimMemoryListener(aVar);
        }

        @Override // androidx.fragment.app.w
        public View c(int i10) {
            return u.this.findViewById(i10);
        }

        @Override // androidx.fragment.app.w
        public boolean d() {
            Window window = u.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // e.e
        public e.d getActivityResultRegistry() {
            return u.this.getActivityResultRegistry();
        }

        @Override // androidx.lifecycle.m
        public androidx.lifecycle.i getLifecycle() {
            return u.this.mFragmentLifecycleRegistry;
        }

        @Override // androidx.activity.r
        public androidx.activity.p getOnBackPressedDispatcher() {
            return u.this.getOnBackPressedDispatcher();
        }

        @Override // k2.f
        public k2.d getSavedStateRegistry() {
            return u.this.getSavedStateRegistry();
        }

        @Override // androidx.lifecycle.m0
        public androidx.lifecycle.l0 getViewModelStore() {
            return u.this.getViewModelStore();
        }

        @Override // androidx.fragment.app.a0
        public void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            u.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.a0
        public LayoutInflater k() {
            return u.this.getLayoutInflater().cloneInContext(u.this);
        }

        @Override // androidx.fragment.app.a0
        public boolean m(String str) {
            return h0.a.u(u.this, str);
        }

        @Override // androidx.fragment.app.a0
        public void p() {
            q();
        }

        public void q() {
            u.this.invalidateMenu();
        }

        @Override // androidx.fragment.app.a0
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public u j() {
            return u.this;
        }

        @Override // t0.k
        public void removeMenuProvider(t0.p pVar) {
            u.this.removeMenuProvider(pVar);
        }

        @Override // i0.c
        public void removeOnConfigurationChangedListener(s0.a aVar) {
            u.this.removeOnConfigurationChangedListener(aVar);
        }

        @Override // h0.n
        public void removeOnMultiWindowModeChangedListener(s0.a aVar) {
            u.this.removeOnMultiWindowModeChangedListener(aVar);
        }

        @Override // h0.o
        public void removeOnPictureInPictureModeChangedListener(s0.a aVar) {
            u.this.removeOnPictureInPictureModeChangedListener(aVar);
        }

        @Override // i0.d
        public void removeOnTrimMemoryListener(s0.a aVar) {
            u.this.removeOnTrimMemoryListener(aVar);
        }
    }

    public u() {
        j();
    }

    public static /* synthetic */ Bundle h(u uVar) {
        uVar.markFragmentsCreated();
        uVar.mFragmentLifecycleRegistry.h(i.a.ON_STOP);
        return new Bundle();
    }

    public static boolean k(i0 i0Var, i.b bVar) {
        boolean zK = false;
        for (p pVar : i0Var.v0()) {
            if (pVar != null) {
                if (pVar.getHost() != null) {
                    zK |= k(pVar.getChildFragmentManager(), bVar);
                }
                u0 u0Var = pVar.mViewLifecycleOwner;
                if (u0Var != null && u0Var.getLifecycle().b().b(i.b.STARTED)) {
                    pVar.mViewLifecycleOwner.f(bVar);
                    zK = true;
                }
                if (pVar.mLifecycleRegistry.b().b(i.b.STARTED)) {
                    pVar.mLifecycleRegistry.m(bVar);
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
                z1.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
            }
            this.mFragments.l().X(str, fileDescriptor, printWriter, strArr);
        }
    }

    public i0 getSupportFragmentManager() {
        return this.mFragments.l();
    }

    @Deprecated
    public z1.a getSupportLoaderManager() {
        return z1.a.b(this);
    }

    public final void j() {
        getSavedStateRegistry().h(LIFECYCLE_TAG, new d.c() { // from class: androidx.fragment.app.q
            @Override // k2.d.c
            public final Bundle a() {
                return u.h(this.f2267a);
            }
        });
        addOnConfigurationChangedListener(new s0.a() { // from class: androidx.fragment.app.r
            @Override // s0.a
            public final void accept(Object obj) {
                this.f2296a.mFragments.m();
            }
        });
        addOnNewIntentListener(new s0.a() { // from class: androidx.fragment.app.s
            @Override // s0.a
            public final void accept(Object obj) {
                this.f2300a.mFragments.m();
            }
        });
        addOnContextAvailableListener(new d.b() { // from class: androidx.fragment.app.t
            @Override // d.b
            public final void a(Context context) {
                this.f2317a.mFragments.a(null);
            }
        });
    }

    public void markFragmentsCreated() {
        while (k(getSupportFragmentManager(), i.b.CREATED)) {
        }
    }

    @Override // androidx.activity.h, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        this.mFragments.m();
        super.onActivityResult(i10, i11, intent);
    }

    @Override // androidx.activity.h, h0.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.h(i.a.ON_CREATE);
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
        this.mFragmentLifecycleRegistry.h(i.a.ON_DESTROY);
    }

    @Override // androidx.activity.h, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 6) {
            return this.mFragments.d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.g();
        this.mFragmentLifecycleRegistry.h(i.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // androidx.activity.h, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        this.mFragments.m();
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.m();
        super.onResume();
        this.mResumed = true;
        this.mFragments.k();
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.h(i.a.ON_RESUME);
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
        this.mFragmentLifecycleRegistry.h(i.a.ON_START);
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
        this.mFragmentLifecycleRegistry.h(i.a.ON_STOP);
    }

    public void setEnterSharedElementCallback(h0.t tVar) {
        h0.a.s(this, tVar);
    }

    public void setExitSharedElementCallback(h0.t tVar) {
        h0.a.t(this, tVar);
    }

    public void startActivityFromFragment(p pVar, Intent intent, int i10) {
        startActivityFromFragment(pVar, intent, i10, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(p pVar, IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        if (i10 == -1) {
            h0.a.w(this, intentSender, i10, intent, i11, i12, i13, bundle);
        } else {
            pVar.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        h0.a.p(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateMenu();
    }

    public void supportPostponeEnterTransition() {
        h0.a.q(this);
    }

    public void supportStartPostponedEnterTransition() {
        h0.a.x(this);
    }

    public void startActivityFromFragment(p pVar, Intent intent, int i10, Bundle bundle) {
        if (i10 == -1) {
            h0.a.v(this, intent, -1, bundle);
        } else {
            pVar.startActivityForResult(intent, i10, bundle);
        }
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    @Deprecated
    public void onAttachFragment(p pVar) {
    }

    @Override // h0.a.e
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i10) {
    }
}
