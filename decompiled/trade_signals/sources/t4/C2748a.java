package t4;

import I.b;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Parcelable;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.r;
import p5.z;

/* JADX INFO: renamed from: t4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2748a implements FlutterPlugin, ActivityAware, MethodChannel.MethodCallHandler, PluginRegistry.ActivityResultListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0403a f23322b = new C0403a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Activity f23323c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MethodChannel.Result f23324a;

    /* JADX INFO: renamed from: t4.a$a, reason: collision with other inner class name */
    public static final class C0403a {
        public C0403a() {
        }

        public /* synthetic */ C0403a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public final String[] a(ArrayList arrayList) {
        Object[] array = arrayList.toArray(new String[arrayList.size()]);
        AbstractC2304t.e(array, "toArray(...)");
        return (String[]) array;
    }

    public final void b(MethodCall methodCall, MethodChannel.Result result) {
        CharSequence charSequenceA;
        String str;
        if (f23323c == null) {
            result.error("error", "Activity == null!", null);
            return;
        }
        String str2 = (String) methodCall.argument("body");
        Boolean bool = (Boolean) methodCall.argument("is_html");
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        ArrayList<String> arrayList = (ArrayList) methodCall.argument("attachment_paths");
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        String str3 = (String) methodCall.argument("subject");
        ArrayList arrayList2 = (ArrayList) methodCall.argument("recipients");
        ArrayList arrayList3 = (ArrayList) methodCall.argument("cc");
        ArrayList arrayList4 = (ArrayList) methodCall.argument("bcc");
        if (str2 == null) {
            charSequenceA = null;
            str = null;
        } else if (zBooleanValue) {
            str = str2;
            charSequenceA = R.a.a(str2, 0);
        } else {
            str = null;
            charSequenceA = str2;
        }
        ArrayList arrayList5 = new ArrayList(r.s(arrayList, 10));
        for (String str4 : arrayList) {
            Activity activity = f23323c;
            AbstractC2304t.c(activity);
            StringBuilder sb = new StringBuilder();
            Activity activity2 = f23323c;
            AbstractC2304t.c(activity2);
            sb.append(activity2.getPackageName());
            sb.append(".file_provider");
            arrayList5.add(b.h(activity, sb.toString(), new File(str4)));
        }
        Intent intent = new Intent();
        if (arrayList5.isEmpty()) {
            intent.setAction("android.intent.action.SENDTO");
            intent.setData(Uri.parse("mailto:"));
        } else {
            intent.addFlags(1);
            if (arrayList5.size() == 1) {
                intent.setAction("android.intent.action.SEND");
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra("android.intent.extra.STREAM", (Parcelable) z.Y(arrayList5));
                intent.setSelector(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:")));
                ArrayList arrayList6 = new ArrayList(r.s(arrayList5, 10));
                Iterator it = arrayList5.iterator();
                while (it.hasNext()) {
                    arrayList6.add(new ClipData.Item((Uri) it.next()));
                }
                ClipData clipData = new ClipData(new ClipDescription("", new String[]{"application/octet-stream"}), (ClipData.Item) z.Y(arrayList6));
                Iterator it2 = z.S(arrayList6, 1).iterator();
                while (it2.hasNext()) {
                    clipData.addItem((ClipData.Item) it2.next());
                }
                intent.setClipData(clipData);
            } else {
                intent.setAction("android.intent.action.SEND_MULTIPLE");
                intent.setType("text/plain");
                AbstractC2304t.c(intent.putParcelableArrayListExtra("android.intent.extra.STREAM", new ArrayList<>(arrayList5)));
            }
        }
        if (charSequenceA != null) {
            intent.putExtra("android.intent.extra.TEXT", charSequenceA);
        }
        if (str != null) {
            intent.putExtra("android.intent.extra.HTML_TEXT", str);
        }
        if (str3 != null) {
            intent.putExtra("android.intent.extra.SUBJECT", str3);
        }
        if (arrayList2 != null) {
            intent.putExtra("android.intent.extra.EMAIL", a(arrayList2));
        }
        if (arrayList3 != null) {
            intent.putExtra("android.intent.extra.CC", a(arrayList3));
        }
        if (arrayList4 != null) {
            intent.putExtra("android.intent.extra.BCC", a(arrayList4));
        }
        Activity activity3 = f23323c;
        PackageManager packageManager = activity3 != null ? activity3.getPackageManager() : null;
        if ((packageManager != null ? packageManager.resolveActivity(intent, 0) : null) == null) {
            result.error("not_available", "No email clients found!", null);
            return;
        }
        Activity activity4 = f23323c;
        if (activity4 != null) {
            activity4.startActivityForResult(intent, 607);
        }
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int i8, int i9, Intent intent) {
        if (i8 != 607) {
            return false;
        }
        MethodChannel.Result result = this.f23324a;
        if (result != null) {
            result.success(null);
        }
        this.f23324a = null;
        return true;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        AbstractC2304t.f(activityPluginBinding, "activityPluginBinding");
        f23323c = activityPluginBinding.getActivity();
        activityPluginBinding.addActivityResultListener(this);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        AbstractC2304t.f(binding, "binding");
        new MethodChannel(binding.getBinaryMessenger(), "flutter_email_sender").setMethodCallHandler(this);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        f23323c = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        f23323c = null;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        AbstractC2304t.f(binding, "binding");
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        AbstractC2304t.f(call, "call");
        AbstractC2304t.f(result, "result");
        if (!AbstractC2304t.b(call.method, "send")) {
            result.notImplemented();
        } else {
            this.f23324a = result;
            b(call, result);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        AbstractC2304t.f(activityPluginBinding, "activityPluginBinding");
        f23323c = activityPluginBinding.getActivity();
        activityPluginBinding.addActivityResultListener(this);
    }
}
