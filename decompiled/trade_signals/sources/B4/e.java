package B4;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class e implements FlutterPlugin, ActivityAware {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f168d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public dev.fluttercommunity.plus.share.a f170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MethodChannel f171c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding binding) {
        AbstractC2304t.f(binding, "binding");
        dev.fluttercommunity.plus.share.a aVar = this.f170b;
        d dVar = null;
        if (aVar == null) {
            AbstractC2304t.s("manager");
            aVar = null;
        }
        binding.addActivityResultListener(aVar);
        d dVar2 = this.f169a;
        if (dVar2 == null) {
            AbstractC2304t.s(FirebaseAnalytics.Event.SHARE);
        } else {
            dVar = dVar2;
        }
        dVar.o(binding.getActivity());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        AbstractC2304t.f(binding, "binding");
        this.f171c = new MethodChannel(binding.getBinaryMessenger(), "dev.fluttercommunity.plus/share");
        Context applicationContext = binding.getApplicationContext();
        AbstractC2304t.e(applicationContext, "getApplicationContext(...)");
        this.f170b = new dev.fluttercommunity.plus.share.a(applicationContext);
        Context applicationContext2 = binding.getApplicationContext();
        AbstractC2304t.e(applicationContext2, "getApplicationContext(...)");
        dev.fluttercommunity.plus.share.a aVar = this.f170b;
        MethodChannel methodChannel = null;
        if (aVar == null) {
            AbstractC2304t.s("manager");
            aVar = null;
        }
        d dVar = new d(applicationContext2, null, aVar);
        this.f169a = dVar;
        dev.fluttercommunity.plus.share.a aVar2 = this.f170b;
        if (aVar2 == null) {
            AbstractC2304t.s("manager");
            aVar2 = null;
        }
        B4.a aVar3 = new B4.a(dVar, aVar2);
        MethodChannel methodChannel2 = this.f171c;
        if (methodChannel2 == null) {
            AbstractC2304t.s("methodChannel");
        } else {
            methodChannel = methodChannel2;
        }
        methodChannel.setMethodCallHandler(aVar3);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        d dVar = this.f169a;
        if (dVar == null) {
            AbstractC2304t.s(FirebaseAnalytics.Event.SHARE);
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
        AbstractC2304t.f(binding, "binding");
        MethodChannel methodChannel = this.f171c;
        if (methodChannel == null) {
            AbstractC2304t.s("methodChannel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler(null);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        AbstractC2304t.f(binding, "binding");
        onAttachedToActivity(binding);
    }
}
