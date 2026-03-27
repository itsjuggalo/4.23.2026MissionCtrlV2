package u4;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: u4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2773a implements FlutterPlugin, MethodChannel.MethodCallHandler, ActivityAware {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f23518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MethodChannel f23519b;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void a(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        Boolean bool = (Boolean) methodCall.argument("asAnotherTask");
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        String str2 = (String) methodCall.argument("type");
        if (str2 != null) {
            switch (str2.hashCode()) {
                case -2045253606:
                    if (str2.equals("batteryOptimization")) {
                        f(result, zBooleanValue);
                        return;
                    }
                    break;
                case -1928150741:
                    if (str2.equals("generalSettings")) {
                        str = "android.settings.SETTINGS";
                    }
                    break;
                case -1770066084:
                    if (str2.equals("manageUnknownAppSources")) {
                        str = "android.settings.MANAGE_UNKNOWN_APP_SOURCES";
                    }
                    break;
                case -1335157162:
                    if (str2.equals("device")) {
                        str = "android.settings.DEVICE_INFO_SETTINGS";
                    }
                    break;
                case -1000044642:
                    if (str2.equals("wireless")) {
                        str = "android.settings.WIRELESS_SETTINGS";
                    }
                    break;
                case -213139122:
                    if (str2.equals("accessibility")) {
                        str = "android.settings.ACCESSIBILITY_SETTINGS";
                    }
                    break;
                case -114233073:
                    if (str2.equals("dataRoaming")) {
                        str = "android.settings.DATA_ROAMING_SETTINGS";
                    }
                    break;
                case -80681014:
                    if (str2.equals("developer")) {
                        str = "android.settings.APPLICATION_DEVELOPMENT_SETTINGS";
                    }
                    break;
                case 96799:
                    if (str2.equals("apn")) {
                        str = "android.settings.APN_SETTINGS";
                    }
                    break;
                case 108971:
                    if (str2.equals("nfc")) {
                        str = "android.settings.NFC_SETTINGS";
                    }
                    break;
                case 116980:
                    if (str2.equals("vpn")) {
                        k(result, zBooleanValue);
                        return;
                    }
                    break;
                case 3076014:
                    if (str2.equals("date")) {
                        str = "android.settings.DATE_SETTINGS";
                    }
                    break;
                case 3649301:
                    if (str2.equals("wifi")) {
                        str = "android.settings.WIFI_SETTINGS";
                    }
                    break;
                case 92895825:
                    if (str2.equals("alarm")) {
                        c(result, zBooleanValue);
                        return;
                    }
                    break;
                case 109627663:
                    if (str2.equals("sound")) {
                        str = "android.settings.SOUND_SETTINGS";
                    }
                    break;
                case 595233003:
                    if (str2.equals("notification")) {
                        h(result, zBooleanValue);
                        return;
                    }
                    break;
                case 949122880:
                    if (str2.equals("security")) {
                        str = "android.settings.SECURITY_SETTINGS";
                    }
                    break;
                case 1039955198:
                    if (str2.equals("internalStorage")) {
                        str = "android.settings.INTERNAL_STORAGE_SETTINGS";
                    }
                    break;
                case 1099603663:
                    if (str2.equals("hotspot")) {
                        g(result, zBooleanValue);
                        return;
                    }
                    break;
                case 1214667623:
                    if (str2.equals("lockAndPassword")) {
                        str = "android.app.action.SET_NEW_PASSWORD";
                    }
                    break;
                case 1294374875:
                    if (str2.equals("appLocale")) {
                        d(result, zBooleanValue);
                        return;
                    }
                    break;
                case 1434631203:
                    if (str2.equals("settings")) {
                        e(result, zBooleanValue);
                        return;
                    }
                    break;
                case 1671764162:
                    if (str2.equals("display")) {
                        str = "android.settings.DISPLAY_SETTINGS";
                    }
                    break;
                case 1901043637:
                    if (str2.equals(FirebaseAnalytics.Param.LOCATION)) {
                        str = "android.settings.LOCATION_SOURCE_SETTINGS";
                    }
                    break;
                case 1968882350:
                    if (str2.equals("bluetooth")) {
                        str = "android.settings.BLUETOOTH_SETTINGS";
                    }
                    break;
            }
            i(str, result, zBooleanValue);
            return;
        }
        result.notImplemented();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void b(MethodCall methodCall, MethodChannel.Result result) {
        Intent intent;
        if (Build.VERSION.SDK_INT < 29) {
            result.success(null);
            return;
        }
        Activity activity = this.f23518a;
        if (activity != null) {
            String str = (String) methodCall.argument("type");
            if (str != null) {
                switch (str.hashCode()) {
                    case -810883302:
                        if (str.equals("volume")) {
                            intent = new Intent("android.settings.panel.action.VOLUME");
                            activity.startActivity(intent);
                        }
                        break;
                    case 108971:
                        if (str.equals("nfc")) {
                            intent = new Intent("android.settings.panel.action.NFC");
                            activity.startActivity(intent);
                        }
                        break;
                    case 3649301:
                        if (str.equals("wifi")) {
                            intent = new Intent("android.settings.panel.action.WIFI");
                            activity.startActivity(intent);
                        }
                        break;
                    case 21015448:
                        if (str.equals("internetConnectivity")) {
                            intent = new Intent("android.settings.panel.action.INTERNET_CONNECTIVITY");
                            activity.startActivity(intent);
                        }
                        break;
                }
                return;
            }
            result.notImplemented();
            return;
        }
        result.success(null);
    }

    public final void c(MethodChannel.Result result, boolean z7) {
        if (Build.VERSION.SDK_INT < 31) {
            e(result, z7);
            return;
        }
        Activity activity = this.f23518a;
        Uri uriFromParts = activity != null ? Uri.fromParts("package", activity.getPackageName(), null) : null;
        if (uriFromParts == null) {
            result.success(null);
        } else {
            j(new Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM", uriFromParts), result, z7);
        }
    }

    public final void d(MethodChannel.Result result, boolean z7) {
        if (Build.VERSION.SDK_INT < 33) {
            result.success(null);
            return;
        }
        Intent intent = new Intent("android.settings.APP_LOCALE_SETTINGS");
        if (z7) {
            intent.addFlags(268435456);
        }
        Activity activity = this.f23518a;
        if (activity != null) {
            intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
            activity.startActivity(intent);
        }
        result.success(null);
    }

    public final void e(MethodChannel.Result result, boolean z7) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        if (z7) {
            intent.addFlags(268435456);
        }
        Activity activity = this.f23518a;
        if (activity != null) {
            intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
            activity.startActivity(intent);
        }
        result.success(null);
    }

    public final void f(MethodChannel.Result result, boolean z7) {
        i("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS", result, z7);
    }

    public final void g(MethodChannel.Result result, boolean z7) {
        Intent className = new Intent().setClassName("com.android.settings", "com.android.settings.TetherSettings");
        AbstractC2304t.e(className, "setClassName(...)");
        j(className, result, z7);
    }

    public final void h(MethodChannel.Result result, boolean z7) {
        if (Build.VERSION.SDK_INT < 26) {
            e(result, z7);
            return;
        }
        Activity activity = this.f23518a;
        if (activity != null) {
            Intent intentPutExtra = new Intent("android.settings.APP_NOTIFICATION_SETTINGS").putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
            AbstractC2304t.e(intentPutExtra, "putExtra(...)");
            if (z7) {
                intentPutExtra.addFlags(268435456);
            }
            activity.startActivity(intentPutExtra);
        }
        result.success(null);
    }

    public final void i(String str, MethodChannel.Result result, boolean z7) {
        try {
            Intent intent = new Intent(str);
            if (z7) {
                intent.addFlags(268435456);
            }
            Activity activity = this.f23518a;
            if (activity != null) {
                activity.startActivity(intent);
            }
            result.success(null);
        } catch (Exception unused) {
            e(result, z7);
        }
    }

    public final void j(Intent intent, MethodChannel.Result result, boolean z7) {
        if (z7) {
            try {
                intent.addFlags(268435456);
            } catch (Exception unused) {
                e(result, z7);
                return;
            }
        }
        Activity activity = this.f23518a;
        if (activity != null) {
            activity.startActivity(intent);
        }
        result.success(null);
    }

    public final void k(MethodChannel.Result result, boolean z7) {
        i("android.settings.VPN_SETTINGS", result, z7);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding binding) {
        AbstractC2304t.f(binding, "binding");
        this.f23518a = binding.getActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        AbstractC2304t.f(flutterPluginBinding, "flutterPluginBinding");
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "com.spencerccf.app_settings/methods");
        this.f23519b = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        this.f23518a = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        this.f23518a = null;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        AbstractC2304t.f(binding, "binding");
        MethodChannel methodChannel = this.f23519b;
        if (methodChannel == null) {
            AbstractC2304t.s("channel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler(null);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        AbstractC2304t.f(call, "call");
        AbstractC2304t.f(result, "result");
        String str = call.method;
        if (AbstractC2304t.b(str, "openSettings")) {
            a(call, result);
        } else if (AbstractC2304t.b(str, "openSettingsPanel")) {
            b(call, result);
        } else {
            result.notImplemented();
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        AbstractC2304t.f(binding, "binding");
        this.f23518a = binding.getActivity();
    }
}
