package pb;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u0012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lpb/e;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "<init>", "()V", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "binding", "Lcd/h0;", "onAttachedToEngine", "(Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;)V", "onDetachedFromEngine", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "onAttachedToActivity", "(Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;)V", "onDetachedFromActivity", "onReattachedToActivityForConfigChanges", "onDetachedFromActivityForConfigChanges", "Lpb/d;", "a", "Lpb/d;", FirebaseAnalytics.Event.SHARE, "Ldev/fluttercommunity/plus/share/a;", "b", "Ldev/fluttercommunity/plus/share/a;", "manager", "Lio/flutter/plugin/common/MethodChannel;", "c", "Lio/flutter/plugin/common/MethodChannel;", "methodChannel", "d", "share_plus_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e implements FlutterPlugin, ActivityAware {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public d share;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public dev.fluttercommunity.plus.share.a manager;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public MethodChannel methodChannel;

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding binding) {
        t.f(binding, "binding");
        dev.fluttercommunity.plus.share.a aVar = this.manager;
        d dVar = null;
        if (aVar == null) {
            t.s("manager");
            aVar = null;
        }
        binding.addActivityResultListener(aVar);
        d dVar2 = this.share;
        if (dVar2 == null) {
            t.s(FirebaseAnalytics.Event.SHARE);
        } else {
            dVar = dVar2;
        }
        dVar.o(binding.getActivity());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        t.f(binding, "binding");
        this.methodChannel = new MethodChannel(binding.getBinaryMessenger(), "dev.fluttercommunity.plus/share");
        Context applicationContext = binding.getApplicationContext();
        t.e(applicationContext, "getApplicationContext(...)");
        this.manager = new dev.fluttercommunity.plus.share.a(applicationContext);
        Context applicationContext2 = binding.getApplicationContext();
        t.e(applicationContext2, "getApplicationContext(...)");
        dev.fluttercommunity.plus.share.a aVar = this.manager;
        MethodChannel methodChannel = null;
        if (aVar == null) {
            t.s("manager");
            aVar = null;
        }
        d dVar = new d(applicationContext2, null, aVar);
        this.share = dVar;
        dev.fluttercommunity.plus.share.a aVar2 = this.manager;
        if (aVar2 == null) {
            t.s("manager");
            aVar2 = null;
        }
        a aVar3 = new a(dVar, aVar2);
        MethodChannel methodChannel2 = this.methodChannel;
        if (methodChannel2 == null) {
            t.s("methodChannel");
        } else {
            methodChannel = methodChannel2;
        }
        methodChannel.setMethodCallHandler(aVar3);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        d dVar = this.share;
        if (dVar == null) {
            t.s(FirebaseAnalytics.Event.SHARE);
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
        t.f(binding, "binding");
        MethodChannel methodChannel = this.methodChannel;
        if (methodChannel == null) {
            t.s("methodChannel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler(null);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        t.f(binding, "binding");
        onAttachedToActivity(binding);
    }
}
