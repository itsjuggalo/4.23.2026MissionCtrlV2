package F2;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements FlutterPlugin {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MethodChannel f434a;

    public final void a(BinaryMessenger binaryMessenger, Context context) {
        this.f434a = new MethodChannel(binaryMessenger, "dev.fluttercommunity.plus/device_info");
        PackageManager packageManager = context.getPackageManager();
        r.e(packageManager, "getPackageManager(...)");
        Object systemService = context.getSystemService("activity");
        r.d(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        c cVar = new c(packageManager, (ActivityManager) systemService);
        MethodChannel methodChannel = this.f434a;
        if (methodChannel == null) {
            r.t("methodChannel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler(cVar);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        r.f(binding, "binding");
        BinaryMessenger binaryMessenger = binding.getBinaryMessenger();
        r.e(binaryMessenger, "getBinaryMessenger(...)");
        Context applicationContext = binding.getApplicationContext();
        r.e(applicationContext, "getApplicationContext(...)");
        a(binaryMessenger, applicationContext);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        r.f(binding, "binding");
        MethodChannel methodChannel = this.f434a;
        if (methodChannel == null) {
            r.t("methodChannel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler(null);
    }
}
