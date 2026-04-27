package X0;

import E5.E;
import Q4.a;
import R4.c;
import V4.i;
import V4.j;
import V4.l;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import t.c;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Q4.a, j.c, R4.a, l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f5473f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static j.d f5474g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Function0 f5475h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5476c = 1001;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f5477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f5478e;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public static final E b(Activity activity) {
        Intent launchIntentForPackage = activity.getPackageManager().getLaunchIntentForPackage(activity.getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setPackage(null);
        }
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setFlags(67108864);
        }
        activity.startActivity(launchIntentForPackage);
        return E.f1657a;
    }

    @Override // V4.l
    public boolean onActivityResult(int i7, int i8, Intent intent) {
        j.d dVar;
        if (i7 != this.f5476c || (dVar = f5474g) == null) {
            return false;
        }
        dVar.b("authorization-error/canceled", "The user closed the Custom Tab", null);
        f5474g = null;
        f5475h = null;
        return false;
    }

    @Override // R4.a
    public void onAttachedToActivity(c binding) {
        r.f(binding, "binding");
        this.f5478e = binding;
        binding.f(this);
    }

    @Override // Q4.a
    public void onAttachedToEngine(a.b flutterPluginBinding) {
        r.f(flutterPluginBinding, "flutterPluginBinding");
        j jVar = new j(flutterPluginBinding.b(), "com.aboutyou.dart_packages.sign_in_with_apple");
        this.f5477d = jVar;
        jVar.e(this);
    }

    @Override // R4.a
    public void onDetachedFromActivity() {
        c cVar = this.f5478e;
        if (cVar != null) {
            cVar.d(this);
        }
        this.f5478e = null;
    }

    @Override // R4.a
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // Q4.a
    public void onDetachedFromEngine(a.b binding) {
        r.f(binding, "binding");
        j jVar = this.f5477d;
        if (jVar != null) {
            jVar.e(null);
        }
        this.f5477d = null;
    }

    @Override // V4.j.c
    public void onMethodCall(i call, j.d result) {
        r.f(call, "call");
        r.f(result, "result");
        String str = call.f5332a;
        if (r.b(str, "isAvailable")) {
            result.a(Boolean.TRUE);
            return;
        }
        if (!r.b(str, "performAuthorizationRequest")) {
            result.c();
            return;
        }
        c cVar = this.f5478e;
        final Activity activityG = cVar != null ? cVar.g() : null;
        if (activityG == null) {
            result.b("MISSING_ACTIVITY", "Plugin is not attached to an activity", call.f5333b);
            return;
        }
        String str2 = (String) call.a("url");
        if (str2 == null) {
            result.b("MISSING_ARG", "Missing 'url' argument", call.f5333b);
            return;
        }
        j.d dVar = f5474g;
        if (dVar != null) {
            dVar.b("NEW_REQUEST", "A new request came in while this was still pending. The previous request (this one) was then cancelled.", null);
        }
        Function0 function0 = f5475h;
        if (function0 != null) {
            r.c(function0);
            function0.invoke();
        }
        f5474g = result;
        f5475h = new Function0() { // from class: X0.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return b.b(activityG);
            }
        };
        t.c cVarA = new c.d().a();
        r.e(cVarA, "build(...)");
        cVarA.f23085a.setData(Uri.parse(str2));
        activityG.startActivityForResult(cVarA.f23085a, this.f5476c, cVarA.f23086b);
    }

    @Override // R4.a
    public void onReattachedToActivityForConfigChanges(R4.c binding) {
        r.f(binding, "binding");
        onAttachedToActivity(binding);
    }
}
