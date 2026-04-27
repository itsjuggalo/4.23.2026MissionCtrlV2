package I0;

import android.app.Activity;
import android.content.Context;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;

/* JADX INFO: loaded from: classes.dex */
public final class m implements FlutterPlugin, ActivityAware {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MethodChannel f841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ActivityPluginBinding f842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f843d;

    public final void a() {
        ActivityPluginBinding activityPluginBinding = this.f842c;
        if (activityPluginBinding != null) {
            activityPluginBinding.removeActivityResultListener(this.f840a);
            this.f842c.removeRequestPermissionsResultListener(this.f840a);
        }
    }

    public final void b() {
        ActivityPluginBinding activityPluginBinding = this.f842c;
        if (activityPluginBinding != null) {
            activityPluginBinding.addActivityResultListener(this.f840a);
            this.f842c.addRequestPermissionsResultListener(this.f840a);
        }
    }

    public final void c(Context context, BinaryMessenger binaryMessenger) {
        this.f841b = new MethodChannel(binaryMessenger, "flutter.baseflow.com/permissions/methods");
        l lVar = new l(context, new a(), this.f840a, new y());
        this.f843d = lVar;
        this.f841b.setMethodCallHandler(lVar);
    }

    public final void d(Activity activity) {
        q qVar = this.f840a;
        if (qVar != null) {
            qVar.h(activity);
        }
    }

    public final void e() {
        this.f841b.setMethodCallHandler(null);
        this.f841b = null;
        this.f843d = null;
    }

    public final void f() {
        q qVar = this.f840a;
        if (qVar != null) {
            qVar.h(null);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        d(activityPluginBinding.getActivity());
        this.f842c = activityPluginBinding;
        b();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f840a = new q(flutterPluginBinding.getApplicationContext());
        c(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        f();
        a();
        this.f842c = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        e();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }
}
