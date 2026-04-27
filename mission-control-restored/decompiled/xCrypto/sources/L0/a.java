package L0;

import M0.c;
import M0.e;
import android.content.Context;
import android.os.Build;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class a implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0035a f1391c = new C0035a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f1392d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MethodChannel f1394b;

    /* JADX INFO: renamed from: L0.a$a, reason: collision with other inner class name */
    public static final class C0035a {
        public /* synthetic */ C0035a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final boolean a() {
            return a.f1392d;
        }

        public C0035a() {
        }
    }

    public a() {
        P0.a aVar = P0.a.f3381a;
        aVar.b(new R0.a(0));
        aVar.b(new R0.a(1));
        aVar.b(new S0.a());
        aVar.b(new R0.a(3));
    }

    public final int b(MethodCall methodCall) {
        f1392d = r.b((Boolean) methodCall.arguments(), Boolean.TRUE);
        return 1;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        r.f(binding, "binding");
        this.f1393a = binding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(binding.getBinaryMessenger(), "flutter_image_compress");
        this.f1394b = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        r.f(binding, "binding");
        MethodChannel methodChannel = this.f1394b;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(null);
        }
        this.f1394b = null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        r.f(call, "call");
        r.f(result, "result");
        String str = call.method;
        if (str != null) {
            Context context = null;
            switch (str.hashCode()) {
                case -129880033:
                    if (str.equals("compressWithFileAndGetFile")) {
                        c cVar = new c(call, result);
                        Context context2 = this.f1393a;
                        if (context2 == null) {
                            r.t("context");
                        } else {
                            context = context2;
                        }
                        cVar.i(context);
                        return;
                    }
                    break;
                case 86054116:
                    if (str.equals("compressWithFile")) {
                        c cVar2 = new c(call, result);
                        Context context3 = this.f1393a;
                        if (context3 == null) {
                            r.t("context");
                        } else {
                            context = context3;
                        }
                        cVar2.g(context);
                        return;
                    }
                    break;
                case 86233094:
                    if (str.equals("compressWithList")) {
                        e eVar = new e(call, result);
                        Context context4 = this.f1393a;
                        if (context4 == null) {
                            r.t("context");
                        } else {
                            context = context4;
                        }
                        eVar.f(context);
                        return;
                    }
                    break;
                case 1262746611:
                    if (str.equals("getSystemVersion")) {
                        result.success(Integer.valueOf(Build.VERSION.SDK_INT));
                        return;
                    }
                    break;
                case 2067272455:
                    if (str.equals("showLog")) {
                        result.success(Integer.valueOf(b(call)));
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }
}
