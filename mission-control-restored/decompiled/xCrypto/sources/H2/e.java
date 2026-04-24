package H2;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements FlutterPlugin, ActivityAware {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f722d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public dev.fluttercommunity.plus.share.a f724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MethodChannel f725c;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding binding) {
        r.f(binding, "binding");
        dev.fluttercommunity.plus.share.a aVar = this.f724b;
        d dVar = null;
        if (aVar == null) {
            r.t("manager");
            aVar = null;
        }
        binding.addActivityResultListener(aVar);
        d dVar2 = this.f723a;
        if (dVar2 == null) {
            r.t(FirebaseAnalytics.Event.SHARE);
        } else {
            dVar = dVar2;
        }
        dVar.o(binding.getActivity());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        r.f(binding, "binding");
        this.f725c = new MethodChannel(binding.getBinaryMessenger(), "dev.fluttercommunity.plus/share");
        Context applicationContext = binding.getApplicationContext();
        r.e(applicationContext, "getApplicationContext(...)");
        this.f724b = new dev.fluttercommunity.plus.share.a(applicationContext);
        Context applicationContext2 = binding.getApplicationContext();
        r.e(applicationContext2, "getApplicationContext(...)");
        dev.fluttercommunity.plus.share.a aVar = this.f724b;
        MethodChannel methodChannel = null;
        if (aVar == null) {
            r.t("manager");
            aVar = null;
        }
        d dVar = new d(applicationContext2, null, aVar);
        this.f723a = dVar;
        dev.fluttercommunity.plus.share.a aVar2 = this.f724b;
        if (aVar2 == null) {
            r.t("manager");
            aVar2 = null;
        }
        H2.a aVar3 = new H2.a(dVar, aVar2);
        MethodChannel methodChannel2 = this.f725c;
        if (methodChannel2 == null) {
            r.t("methodChannel");
        } else {
            methodChannel = methodChannel2;
        }
        methodChannel.setMethodCallHandler(aVar3);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        d dVar = this.f723a;
        if (dVar == null) {
            r.t(FirebaseAnalytics.Event.SHARE);
            dVar = null;
        }
        dVar.o(null);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        r.f(binding, "binding");
        MethodChannel methodChannel = this.f725c;
        if (methodChannel == null) {
            r.t("methodChannel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler(null);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        r.f(binding, "binding");
        onAttachedToActivity(binding);
    }
}
