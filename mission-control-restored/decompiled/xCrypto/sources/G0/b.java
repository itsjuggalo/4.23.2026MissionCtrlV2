package G0;

import W2.E;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import t.c;

/* JADX INFO: loaded from: classes.dex */
public final class b implements FlutterPlugin, MethodChannel.MethodCallHandler, ActivityAware, PluginRegistry.ActivityResultListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f451d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static MethodChannel.Result f452e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Function0 f453f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f454a = 1001;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MethodChannel f455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ActivityPluginBinding f456c;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
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
        return E.f5463a;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int i4, int i5, Intent intent) {
        MethodChannel.Result result;
        if (i4 != this.f454a || (result = f452e) == null) {
            return false;
        }
        result.error("authorization-error/canceled", "The user closed the Custom Tab", null);
        f452e = null;
        f453f = null;
        return false;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding binding) {
        r.f(binding, "binding");
        this.f456c = binding;
        binding.addActivityResultListener(this);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        r.f(flutterPluginBinding, "flutterPluginBinding");
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "com.aboutyou.dart_packages.sign_in_with_apple");
        this.f455b = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        ActivityPluginBinding activityPluginBinding = this.f456c;
        if (activityPluginBinding != null) {
            activityPluginBinding.removeActivityResultListener(this);
        }
        this.f456c = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        r.f(binding, "binding");
        MethodChannel methodChannel = this.f455b;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(null);
        }
        this.f455b = null;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        r.f(call, "call");
        r.f(result, "result");
        String str = call.method;
        if (r.b(str, "isAvailable")) {
            result.success(Boolean.TRUE);
            return;
        }
        if (!r.b(str, "performAuthorizationRequest")) {
            result.notImplemented();
            return;
        }
        ActivityPluginBinding activityPluginBinding = this.f456c;
        final Activity activity = activityPluginBinding != null ? activityPluginBinding.getActivity() : null;
        if (activity == null) {
            result.error("MISSING_ACTIVITY", "Plugin is not attached to an activity", call.arguments);
            return;
        }
        String str2 = (String) call.argument("url");
        if (str2 == null) {
            result.error("MISSING_ARG", "Missing 'url' argument", call.arguments);
            return;
        }
        MethodChannel.Result result2 = f452e;
        if (result2 != null) {
            result2.error("NEW_REQUEST", "A new request came in while this was still pending. The previous request (this one) was then cancelled.", null);
        }
        Function0 function0 = f453f;
        if (function0 != null) {
            r.c(function0);
            function0.invoke();
        }
        f452e = result;
        f453f = new Function0() { // from class: G0.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return b.b(activity);
            }
        };
        c cVarA = new c.d().a();
        r.e(cVarA, "build(...)");
        cVarA.f14704a.setData(Uri.parse(str2));
        activity.startActivityForResult(cVarA.f14704a, this.f454a, cVarA.f14705b);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        r.f(binding, "binding");
        onAttachedToActivity(binding);
    }
}
