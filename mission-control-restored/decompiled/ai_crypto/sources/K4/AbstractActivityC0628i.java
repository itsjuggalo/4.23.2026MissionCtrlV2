package K4;

import K4.AbstractC0630k;
import K4.C0629j;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import androidx.lifecycle.AbstractC0963i;
import androidx.lifecycle.C0968n;
import androidx.lifecycle.InterfaceC0967m;
import io.flutter.plugin.platform.C2012i;
import java.util.List;

/* JADX INFO: renamed from: K4.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractActivityC0628i extends Activity implements C0629j.c, InterfaceC0967m {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f3595e = View.generateViewId();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3596a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0629j f3597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0968n f3598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OnBackInvokedCallback f3599d;

    /* JADX INFO: renamed from: K4.i$a */
    public class a implements OnBackAnimationCallback {
        public a() {
        }

        public void onBackCancelled() {
            AbstractActivityC0628i.this.H();
        }

        public void onBackInvoked() {
            AbstractActivityC0628i.this.I();
        }

        public void onBackProgressed(BackEvent backEvent) {
            AbstractActivityC0628i.this.X(backEvent);
        }

        public void onBackStarted(BackEvent backEvent) {
            AbstractActivityC0628i.this.T(backEvent);
        }
    }

    public AbstractActivityC0628i() {
        this.f3599d = Build.VERSION.SDK_INT < 33 ? null : M();
        this.f3598c = new C0968n(this);
    }

    @Override // K4.C0629j.c
    public String A() {
        try {
            Bundle bundleP = P();
            if (bundleP != null) {
                return bundleP.getString("io.flutter.EntrypointUri");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // K4.C0629j.c
    public String B() {
        String dataString;
        if (Q() && "android.intent.action.RUN".equals(getIntent().getAction()) && (dataString = getIntent().getDataString()) != null) {
            return dataString;
        }
        return null;
    }

    @Override // K4.C0629j.c
    public Z4.c D(Activity activity, io.flutter.embedding.engine.a aVar) {
        return new Z4.c(f3595e, activity, aVar.y());
    }

    @Override // K4.C0629j.c
    public L4.k E() {
        return L4.k.a(getIntent());
    }

    @Override // K4.C0629j.c
    public O F() {
        return N() == AbstractC0630k.a.opaque ? O.surface : O.texture;
    }

    @Override // K4.C0629j.c
    public Q G() {
        return N() == AbstractC0630k.a.opaque ? Q.opaque : Q.transparent;
    }

    public void H() {
        if (U("cancelBackGesture")) {
            this.f3597b.h();
        }
    }

    public void I() {
        if (U("commitBackGesture")) {
            this.f3597b.i();
        }
    }

    public final void J() {
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(1073741824);
        window.getDecorView().setSystemUiVisibility(1280);
    }

    public final void K() {
        if (N() == AbstractC0630k.a.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    public final View L() {
        return this.f3597b.u(null, null, null, f3595e, F() == O.surface);
    }

    public final OnBackInvokedCallback M() {
        return Build.VERSION.SDK_INT >= 34 ? new a() : new OnBackInvokedCallback() { // from class: K4.h
            public final void onBackInvoked() {
                this.f3594a.onBackPressed();
            }
        };
    }

    public AbstractC0630k.a N() {
        return getIntent().hasExtra("background_mode") ? AbstractC0630k.a.valueOf(getIntent().getStringExtra("background_mode")) : AbstractC0630k.a.opaque;
    }

    public io.flutter.embedding.engine.a O() {
        return this.f3597b.n();
    }

    public Bundle P() {
        return getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    }

    public final boolean Q() {
        return (getApplicationInfo().flags & 2) != 0;
    }

    public void R() {
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.f3599d);
            this.f3596a = true;
        }
    }

    public void S() {
        W();
        C0629j c0629j = this.f3597b;
        if (c0629j != null) {
            c0629j.J();
            this.f3597b = null;
        }
    }

    public void T(BackEvent backEvent) {
        if (U("startBackGesture")) {
            this.f3597b.L(backEvent);
        }
    }

    public final boolean U(String str) {
        C0629j c0629j = this.f3597b;
        if (c0629j == null) {
            J4.b.g("FlutterActivity", "FlutterActivity " + hashCode() + " " + str + " called after release.");
            return false;
        }
        if (c0629j.o()) {
            return true;
        }
        J4.b.g("FlutterActivity", "FlutterActivity " + hashCode() + " " + str + " called after detach.");
        return false;
    }

    public final void V() {
        try {
            Bundle bundleP = P();
            if (bundleP != null) {
                int i7 = bundleP.getInt("io.flutter.embedding.android.NormalTheme", -1);
                if (i7 != -1) {
                    setTheme(i7);
                }
            } else {
                J4.b.f("FlutterActivity", "Using the launch theme as normal theme.");
            }
        } catch (PackageManager.NameNotFoundException unused) {
            J4.b.b("FlutterActivity", "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
        }
    }

    public void W() {
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.f3599d);
            this.f3596a = false;
        }
    }

    public void X(BackEvent backEvent) {
        if (U("updateBackGestureProgress")) {
            this.f3597b.M(backEvent);
        }
    }

    @Override // K4.C0629j.c, androidx.lifecycle.InterfaceC0967m
    public AbstractC0963i a() {
        return this.f3598c;
    }

    @Override // io.flutter.plugin.platform.C2012i.d
    public boolean b() {
        return false;
    }

    @Override // K4.C0629j.c
    public void d() {
        J4.b.g("FlutterActivity", "FlutterActivity " + this + " connection to the engine " + O() + " evicted by another attaching activity");
        C0629j c0629j = this.f3597b;
        if (c0629j != null) {
            c0629j.v();
            this.f3597b.w();
        }
    }

    @Override // K4.C0629j.c
    public void e() {
        if (Build.VERSION.SDK_INT >= 29) {
            reportFullyDrawn();
        }
    }

    @Override // io.flutter.plugin.platform.C2012i.d
    public void f(boolean z7) {
        if (z7 && !this.f3596a) {
            R();
        } else {
            if (z7 || !this.f3596a) {
                return;
            }
            W();
        }
    }

    @Override // K4.C0629j.c
    public List i() {
        return (List) getIntent().getSerializableExtra("dart_entrypoint_args");
    }

    @Override // K4.C0629j.c
    public String j() {
        return getIntent().getStringExtra("cached_engine_id");
    }

    @Override // K4.C0629j.c
    public boolean k() {
        return getIntent().hasExtra("enable_state_restoration") ? getIntent().getBooleanExtra("enable_state_restoration", false) : j() == null;
    }

    @Override // K4.C0629j.c
    public String l() {
        if (getIntent().hasExtra("dart_entrypoint")) {
            return getIntent().getStringExtra("dart_entrypoint");
        }
        try {
            Bundle bundleP = P();
            String string = bundleP != null ? bundleP.getString("io.flutter.Entrypoint") : null;
            return string != null ? string : "main";
        } catch (PackageManager.NameNotFoundException unused) {
            return "main";
        }
    }

    @Override // K4.C0629j.c
    public C2012i m(Activity activity, io.flutter.embedding.engine.a aVar) {
        return new C2012i(g(), aVar.q(), this);
    }

    @Override // K4.C0629j.c
    public boolean n() {
        try {
            return AbstractC0630k.a(P());
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Override // K4.C0629j.c
    public boolean o() {
        return true;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i7, int i8, Intent intent) {
        if (U("onActivityResult")) {
            this.f3597b.r(i7, i8, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (U("onBackPressed")) {
            this.f3597b.t();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        V();
        super.onCreate(bundle);
        if (bundle != null) {
            f(bundle.getBoolean("enableOnBackInvokedCallbackState"));
        }
        C0629j c0629j = new C0629j(this);
        this.f3597b = c0629j;
        c0629j.s(this);
        this.f3597b.B(bundle);
        this.f3598c.h(AbstractC0963i.a.ON_CREATE);
        K();
        setContentView(L());
        J();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (U("onDestroy")) {
            this.f3597b.v();
            this.f3597b.w();
        }
        S();
        this.f3598c.h(AbstractC0963i.a.ON_DESTROY);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (U("onNewIntent")) {
            this.f3597b.x(intent);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        if (U("onPause")) {
            this.f3597b.y();
        }
        this.f3598c.h(AbstractC0963i.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        if (U("onPostResume")) {
            this.f3597b.z();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i7, String[] strArr, int[] iArr) {
        if (U("onRequestPermissionsResult")) {
            this.f3597b.A(i7, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f3598c.h(AbstractC0963i.a.ON_RESUME);
        if (U("onResume")) {
            this.f3597b.C();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (U("onSaveInstanceState")) {
            this.f3597b.D(bundle);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.f3598c.h(AbstractC0963i.a.ON_START);
        if (U("onStart")) {
            this.f3597b.E();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        if (U("onStop")) {
            this.f3597b.F();
        }
        this.f3598c.h(AbstractC0963i.a.ON_STOP);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i7) {
        super.onTrimMemory(i7);
        if (U("onTrimMemory")) {
            this.f3597b.G(i7);
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        if (U("onUserLeaveHint")) {
            this.f3597b.H();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z7) {
        super.onWindowFocusChanged(z7);
        if (U("onWindowFocusChanged")) {
            this.f3597b.I(z7);
        }
    }

    @Override // K4.C0629j.c
    public io.flutter.embedding.engine.a p(Context context) {
        return null;
    }

    @Override // K4.C0629j.c
    public boolean q() {
        return this.f3596a;
    }

    @Override // K4.C0629j.c
    public void s(io.flutter.embedding.engine.a aVar) {
        if (this.f3597b.p()) {
            return;
        }
        T4.a.a(aVar);
    }

    @Override // K4.C0629j.c
    public String t() {
        return getIntent().getStringExtra("cached_engine_group_id");
    }

    @Override // K4.C0629j.c
    public String u() {
        if (getIntent().hasExtra("route")) {
            return getIntent().getStringExtra("route");
        }
        try {
            Bundle bundleP = P();
            if (bundleP != null) {
                return bundleP.getString("io.flutter.InitialRoute");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // K4.C0629j.c
    public boolean w() {
        return true;
    }

    @Override // K4.C0629j.c
    public boolean x() {
        boolean booleanExtra = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
        return (j() != null || this.f3597b.p()) ? booleanExtra : getIntent().getBooleanExtra("destroy_engine_with_activity", true);
    }

    @Override // K4.C0629j.c
    public boolean y() {
        return true;
    }

    @Override // K4.C0629j.c
    public void c() {
    }

    @Override // K4.C0629j.c
    public Activity g() {
        return this;
    }

    @Override // K4.C0629j.c
    public Context getContext() {
        return this;
    }

    @Override // K4.C0629j.c
    public void C(t tVar) {
    }

    @Override // K4.C0629j.c
    public void r(C0637s c0637s) {
    }

    @Override // K4.C0629j.c
    public void z(io.flutter.embedding.engine.a aVar) {
    }
}
