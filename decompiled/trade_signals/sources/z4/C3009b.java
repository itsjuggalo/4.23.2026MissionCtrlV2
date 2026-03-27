package z4;

import B5.k;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2302q;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;

/* JADX INFO: renamed from: z4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C3009b implements FlutterPlugin, MethodChannel.MethodCallHandler, ActivityAware {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f24773p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MethodChannel f24779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Activity f24780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C3012e f24781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f24782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f24762e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f24763f = "android.notificationTitle";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f24764g = "android.notificationIconName";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f24765h = "android.notificationIconDefType";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f24766i = "android.notificationText";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f24767j = "android.notificationImportance";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f24768k = "android.enableWifiLock";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f24769l = "android.showBadge";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f24770m = "android.shouldRequestBatteryOptimizationsOff";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f24771n = "flutter_background foreground service";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f24772o = "Keeps the flutter app running in the background";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static String f24774q = "ic_launcher";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static String f24775r = "mipmap";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f24776s = true;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f24777t = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f24778u = true;

    /* JADX INFO: renamed from: z4.b$a */
    public static final class a {
        public a() {
        }

        public final String a() {
            return C3009b.f24768k;
        }

        public final boolean b() {
            return C3009b.f24776s;
        }

        public final String c() {
            return C3009b.f24765h;
        }

        public final String d() {
            return C3009b.f24764g;
        }

        public final String e() {
            return C3009b.f24767j;
        }

        public final String f() {
            return C3009b.f24766i;
        }

        public final String g() {
            return C3009b.f24763f;
        }

        public final String h() {
            return C3009b.f24775r;
        }

        public final String i() {
            return C3009b.f24774q;
        }

        public final int j() {
            return C3009b.f24773p;
        }

        public final String k() {
            return C3009b.f24772o;
        }

        public final String l() {
            return C3009b.f24771n;
        }

        public final String m() {
            return C3009b.f24769l;
        }

        public final boolean n() {
            return C3009b.f24777t;
        }

        public final void o(Context context) {
            SharedPreferences sharedPreferences;
            if (context != null) {
                sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
            } else {
                sharedPreferences = null;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences != null ? sharedPreferences.edit() : null;
            if (editorEdit != null) {
                a aVar = C3009b.f24762e;
                editorEdit.putString(aVar.g(), aVar.l());
            }
            if (editorEdit != null) {
                a aVar2 = C3009b.f24762e;
                editorEdit.putString(aVar2.f(), aVar2.k());
            }
            if (editorEdit != null) {
                a aVar3 = C3009b.f24762e;
                editorEdit.putInt(aVar3.e(), aVar3.j());
            }
            if (editorEdit != null) {
                a aVar4 = C3009b.f24762e;
                editorEdit.putString(aVar4.d(), aVar4.i());
            }
            if (editorEdit != null) {
                a aVar5 = C3009b.f24762e;
                editorEdit.putString(aVar5.c(), aVar5.h());
            }
            if (editorEdit != null) {
                a aVar6 = C3009b.f24762e;
                editorEdit.putBoolean(aVar6.a(), aVar6.b());
            }
            if (editorEdit != null) {
                a aVar7 = C3009b.f24762e;
                editorEdit.putBoolean(aVar7.m(), aVar7.n());
            }
            if (editorEdit != null) {
                editorEdit.apply();
            }
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX INFO: renamed from: z4.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C0441b extends AbstractC2302q implements k {
        public C0441b(Object obj) {
            super(1, obj, ActivityPluginBinding.class, "addActivityResultListener", "addActivityResultListener(Lio/flutter/plugin/common/PluginRegistry$ActivityResultListener;)V", 0);
        }

        @Override // B5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m((PluginRegistry.ActivityResultListener) obj);
            return C2470H.f21956a;
        }

        public final void m(PluginRegistry.ActivityResultListener p02) {
            AbstractC2304t.f(p02, "p0");
            ((ActivityPluginBinding) this.receiver).addActivityResultListener(p02);
        }
    }

    /* JADX INFO: renamed from: z4.b$c */
    public /* synthetic */ class c extends AbstractC2302q implements k {
        public c(Object obj) {
            super(1, obj, ActivityPluginBinding.class, "addRequestPermissionsResultListener", "addRequestPermissionsResultListener(Lio/flutter/plugin/common/PluginRegistry$RequestPermissionsResultListener;)V", 0);
        }

        @Override // B5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m((PluginRegistry.RequestPermissionsResultListener) obj);
            return C2470H.f21956a;
        }

        public final void m(PluginRegistry.RequestPermissionsResultListener p02) {
            AbstractC2304t.f(p02, "p0");
            ((ActivityPluginBinding) this.receiver).addRequestPermissionsResultListener(p02);
        }
    }

    public final void o(Context context, BinaryMessenger binaryMessenger) {
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "flutter_background");
        this.f24779a = methodChannel;
        AbstractC2304t.c(methodChannel);
        methodChannel.setMethodCallHandler(this);
        this.f24782d = context;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding binding) {
        AbstractC2304t.f(binding, "binding");
        Activity activity = binding.getActivity();
        AbstractC2304t.e(activity, "getActivity(...)");
        p(activity, new C0441b(binding), new c(binding));
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        AbstractC2304t.f(binding, "binding");
        Context applicationContext = binding.getApplicationContext();
        AbstractC2304t.e(applicationContext, "getApplicationContext(...)");
        BinaryMessenger binaryMessenger = binding.getBinaryMessenger();
        AbstractC2304t.e(binaryMessenger, "getBinaryMessenger(...)");
        o(applicationContext, binaryMessenger);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        r();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        AbstractC2304t.f(binding, "binding");
        q();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0118, code lost:
    
        if (r12.a() != false) goto L59;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x019e A[PHI: r12
      0x019e: PHI (r12v6 android.content.Intent) = (r12v3 android.content.Intent), (r12v12 android.content.Intent) binds: [B:94:0x01d1, B:86:0x019c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a7 A[PHI: r12
      0x01a7: PHI (r12v4 android.content.Intent) = (r12v3 android.content.Intent), (r12v12 android.content.Intent) binds: [B:94:0x01d1, B:86:0x019c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r12, io.flutter.plugin.common.MethodChannel.Result r13) {
        /*
            Method dump skipped, instruction units count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z4.C3009b.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        AbstractC2304t.f(binding, "binding");
        onAttachedToActivity(binding);
    }

    public final void p(Activity activity, k kVar, k kVar2) {
        this.f24780b = activity;
        Context applicationContext = activity.getApplicationContext();
        AbstractC2304t.e(applicationContext, "getApplicationContext(...)");
        this.f24781c = new C3012e(applicationContext, kVar, kVar2);
    }

    public final void q() {
        MethodChannel methodChannel = this.f24779a;
        AbstractC2304t.c(methodChannel);
        methodChannel.setMethodCallHandler(null);
        this.f24779a = null;
        this.f24782d = null;
    }

    public final void r() {
        this.f24780b = null;
        this.f24781c = null;
    }
}
