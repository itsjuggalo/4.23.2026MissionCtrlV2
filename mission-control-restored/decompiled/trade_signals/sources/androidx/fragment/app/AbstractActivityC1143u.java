package androidx.fragment.app;

import H.a;
import T.InterfaceC0930l;
import T.InterfaceC0935q;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.AbstractC1157i;
import androidx.lifecycle.C1162n;
import d.InterfaceC1608b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import q0.AbstractC2617a;
import z0.d;

/* JADX INFO: renamed from: androidx.fragment.app.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractActivityC1143u extends androidx.activity.h implements a.e {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    boolean mResumed;
    final C1147y mFragments = C1147y.b(new a());
    final C1162n mFragmentLifecycleRegistry = new C1162n(this);
    boolean mStopped = true;

    /* JADX INFO: renamed from: androidx.fragment.app.u$a */
    public class a extends A implements I.c, I.d, H.o, H.p, androidx.lifecycle.N, androidx.activity.s, e.e, z0.f, M, InterfaceC0930l {
        public a() {
            super(AbstractActivityC1143u.this);
        }

        @Override // androidx.fragment.app.M
        public void a(I i8, AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
            AbstractActivityC1143u.this.onAttachFragment(abstractComponentCallbacksC1139p);
        }

        @Override // T.InterfaceC0930l
        public void addMenuProvider(InterfaceC0935q interfaceC0935q) {
            AbstractActivityC1143u.this.addMenuProvider(interfaceC0935q);
        }

        @Override // I.c
        public void addOnConfigurationChangedListener(S.a aVar) {
            AbstractActivityC1143u.this.addOnConfigurationChangedListener(aVar);
        }

        @Override // H.o
        public void addOnMultiWindowModeChangedListener(S.a aVar) {
            AbstractActivityC1143u.this.addOnMultiWindowModeChangedListener(aVar);
        }

        @Override // H.p
        public void addOnPictureInPictureModeChangedListener(S.a aVar) {
            AbstractActivityC1143u.this.addOnPictureInPictureModeChangedListener(aVar);
        }

        @Override // I.d
        public void addOnTrimMemoryListener(S.a aVar) {
            AbstractActivityC1143u.this.addOnTrimMemoryListener(aVar);
        }

        @Override // androidx.fragment.app.AbstractC1145w
        public View c(int i8) {
            return AbstractActivityC1143u.this.findViewById(i8);
        }

        @Override // androidx.fragment.app.AbstractC1145w
        public boolean d() {
            Window window = AbstractActivityC1143u.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // e.e
        public e.d getActivityResultRegistry() {
            return AbstractActivityC1143u.this.getActivityResultRegistry();
        }

        @Override // androidx.lifecycle.InterfaceC1161m
        public AbstractC1157i getLifecycle() {
            return AbstractActivityC1143u.this.mFragmentLifecycleRegistry;
        }

        @Override // androidx.activity.s
        public androidx.activity.q getOnBackPressedDispatcher() {
            return AbstractActivityC1143u.this.getOnBackPressedDispatcher();
        }

        @Override // z0.f
        public z0.d getSavedStateRegistry() {
            return AbstractActivityC1143u.this.getSavedStateRegistry();
        }

        @Override // androidx.lifecycle.N
        public androidx.lifecycle.M getViewModelStore() {
            return AbstractActivityC1143u.this.getViewModelStore();
        }

        @Override // androidx.fragment.app.A
        public void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            AbstractActivityC1143u.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.A
        public LayoutInflater k() {
            return AbstractActivityC1143u.this.getLayoutInflater().cloneInContext(AbstractActivityC1143u.this);
        }

        @Override // androidx.fragment.app.A
        public boolean m(String str) {
            return H.a.t(AbstractActivityC1143u.this, str);
        }

        @Override // androidx.fragment.app.A
        public void p() {
            q();
        }

        public void q() {
            AbstractActivityC1143u.this.invalidateMenu();
        }

        @Override // androidx.fragment.app.A
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public AbstractActivityC1143u j() {
            return AbstractActivityC1143u.this;
        }

        @Override // T.InterfaceC0930l
        public void removeMenuProvider(InterfaceC0935q interfaceC0935q) {
            AbstractActivityC1143u.this.removeMenuProvider(interfaceC0935q);
        }

        @Override // I.c
        public void removeOnConfigurationChangedListener(S.a aVar) {
            AbstractActivityC1143u.this.removeOnConfigurationChangedListener(aVar);
        }

        @Override // H.o
        public void removeOnMultiWindowModeChangedListener(S.a aVar) {
            AbstractActivityC1143u.this.removeOnMultiWindowModeChangedListener(aVar);
        }

        @Override // H.p
        public void removeOnPictureInPictureModeChangedListener(S.a aVar) {
            AbstractActivityC1143u.this.removeOnPictureInPictureModeChangedListener(aVar);
        }

        @Override // I.d
        public void removeOnTrimMemoryListener(S.a aVar) {
            AbstractActivityC1143u.this.removeOnTrimMemoryListener(aVar);
        }
    }

    public AbstractActivityC1143u() {
        m();
    }

    public static boolean r(I i8, AbstractC1157i.b bVar) {
        boolean zR = false;
        for (AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p : i8.v0()) {
            if (abstractComponentCallbacksC1139p != null) {
                if (abstractComponentCallbacksC1139p.getHost() != null) {
                    zR |= r(abstractComponentCallbacksC1139p.getChildFragmentManager(), bVar);
                }
                V v8 = abstractComponentCallbacksC1139p.mViewLifecycleOwner;
                if (v8 != null && v8.getLifecycle().b().b(AbstractC1157i.b.STARTED)) {
                    abstractComponentCallbacksC1139p.mViewLifecycleOwner.f(bVar);
                    zR = true;
                }
                if (abstractComponentCallbacksC1139p.mLifecycleRegistry.b().b(AbstractC1157i.b.STARTED)) {
                    abstractComponentCallbacksC1139p.mLifecycleRegistry.m(bVar);
                    zR = true;
                }
            }
        }
        return zR;
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
                AbstractC2617a.b(this).a(str2, fileDescriptor, printWriter, strArr);
            }
            this.mFragments.l().X(str, fileDescriptor, printWriter, strArr);
        }
    }

    public I getSupportFragmentManager() {
        return this.mFragments.l();
    }

    @Deprecated
    public AbstractC2617a getSupportLoaderManager() {
        return AbstractC2617a.b(this);
    }

    public final void m() {
        getSavedStateRegistry().h(LIFECYCLE_TAG, new d.c() { // from class: androidx.fragment.app.q
            @Override // z0.d.c
            public final Bundle a() {
                return this.f11893a.n();
            }
        });
        addOnConfigurationChangedListener(new S.a() { // from class: androidx.fragment.app.r
            @Override // S.a
            public final void accept(Object obj) {
                this.f11894a.o((Configuration) obj);
            }
        });
        addOnNewIntentListener(new S.a() { // from class: androidx.fragment.app.s
            @Override // S.a
            public final void accept(Object obj) {
                this.f11895a.p((Intent) obj);
            }
        });
        addOnContextAvailableListener(new InterfaceC1608b() { // from class: androidx.fragment.app.t
            @Override // d.InterfaceC1608b
            public final void a(Context context) {
                this.f11896a.q(context);
            }
        });
    }

    public void markFragmentsCreated() {
        while (r(getSupportFragmentManager(), AbstractC1157i.b.CREATED)) {
        }
    }

    public final /* synthetic */ Bundle n() {
        markFragmentsCreated();
        this.mFragmentLifecycleRegistry.h(AbstractC1157i.a.ON_STOP);
        return new Bundle();
    }

    public final /* synthetic */ void o(Configuration configuration) {
        this.mFragments.m();
    }

    @Override // androidx.activity.h, android.app.Activity
    public void onActivityResult(int i8, int i9, Intent intent) {
        this.mFragments.m();
        super.onActivityResult(i8, i9, intent);
    }

    @Deprecated
    public void onAttachFragment(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
    }

    @Override // androidx.activity.h, H.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.h(AbstractC1157i.a.ON_CREATE);
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
        this.mFragmentLifecycleRegistry.h(AbstractC1157i.a.ON_DESTROY);
    }

    @Override // androidx.activity.h, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i8, MenuItem menuItem) {
        if (super.onMenuItemSelected(i8, menuItem)) {
            return true;
        }
        if (i8 == 6) {
            return this.mFragments.d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.g();
        this.mFragmentLifecycleRegistry.h(AbstractC1157i.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // androidx.activity.h, android.app.Activity
    public void onRequestPermissionsResult(int i8, String[] strArr, int[] iArr) {
        this.mFragments.m();
        super.onRequestPermissionsResult(i8, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.m();
        super.onResume();
        this.mResumed = true;
        this.mFragments.k();
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.h(AbstractC1157i.a.ON_RESUME);
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
        this.mFragmentLifecycleRegistry.h(AbstractC1157i.a.ON_START);
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
        this.mFragmentLifecycleRegistry.h(AbstractC1157i.a.ON_STOP);
    }

    public final /* synthetic */ void p(Intent intent) {
        this.mFragments.m();
    }

    public final /* synthetic */ void q(Context context) {
        this.mFragments.a(null);
    }

    public void setEnterSharedElementCallback(H.u uVar) {
        H.a.r(this, uVar);
    }

    public void setExitSharedElementCallback(H.u uVar) {
        H.a.s(this, uVar);
    }

    public void startActivityFromFragment(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p, Intent intent, int i8) {
        startActivityFromFragment(abstractComponentCallbacksC1139p, intent, i8, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p, IntentSender intentSender, int i8, Intent intent, int i9, int i10, int i11, Bundle bundle) throws IntentSender.SendIntentException {
        if (i8 == -1) {
            H.a.v(this, intentSender, i8, intent, i9, i10, i11, bundle);
        } else {
            abstractComponentCallbacksC1139p.startIntentSenderForResult(intentSender, i8, intent, i9, i10, i11, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        H.a.o(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateMenu();
    }

    public void supportPostponeEnterTransition() {
        H.a.p(this);
    }

    public void supportStartPostponedEnterTransition() {
        H.a.w(this);
    }

    @Override // H.a.e
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i8) {
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    public void startActivityFromFragment(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p, Intent intent, int i8, Bundle bundle) {
        if (i8 == -1) {
            H.a.u(this, intent, -1, bundle);
        } else {
            abstractComponentCallbacksC1139p.startActivityForResult(intent, i8, bundle);
        }
    }
}
