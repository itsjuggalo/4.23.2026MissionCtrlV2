package z4;

import B5.k;
import B5.p;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.PowerManager;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2302q;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;

/* JADX INFO: renamed from: z4.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C3012e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f24793d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f24794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f24795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f24796c;

    /* JADX INFO: renamed from: z4.e$a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX INFO: renamed from: z4.e$b */
    public /* synthetic */ class b extends AbstractC2302q implements k {
        public b(Object obj) {
            super(1, obj, MethodChannel.Result.class, "success", "success(Ljava/lang/Object;)V", 0);
        }

        @Override // B5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m184invoke(obj);
            return C2470H.f21956a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m184invoke(Object obj) {
            ((MethodChannel.Result) this.receiver).success(obj);
        }
    }

    /* JADX INFO: renamed from: z4.e$c */
    public /* synthetic */ class c extends AbstractC2302q implements p {
        public c(Object obj) {
            super(3, obj, MethodChannel.Result.class, "error", "error(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", 0);
        }

        @Override // B5.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            m((String) obj, (String) obj2, obj3);
            return C2470H.f21956a;
        }

        public final void m(String p02, String str, Object obj) {
            AbstractC2304t.f(p02, "p0");
            ((MethodChannel.Result) this.receiver).error(p02, str, obj);
        }
    }

    public C3012e(Context context, k addActivityResultListener, k addRequestPermissionsResultListener) {
        AbstractC2304t.f(context, "context");
        AbstractC2304t.f(addActivityResultListener, "addActivityResultListener");
        AbstractC2304t.f(addRequestPermissionsResultListener, "addRequestPermissionsResultListener");
        this.f24794a = context;
        this.f24795b = addActivityResultListener;
        this.f24796c = addRequestPermissionsResultListener;
    }

    public final boolean a() {
        Object systemService = this.f24794a.getSystemService("power");
        AbstractC2304t.d(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return ((PowerManager) systemService).isIgnoringBatteryOptimizations(this.f24794a.getPackageName());
    }

    public final boolean b() {
        return this.f24794a.checkSelfPermission("android.permission.WAKE_LOCK") == 0;
    }

    public final void c(MethodChannel.Result result, Activity activity) {
        AbstractC2304t.f(result, "result");
        AbstractC2304t.f(activity, "activity");
        Object systemService = this.f24794a.getSystemService("power");
        AbstractC2304t.d(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        if (((PowerManager) systemService).isIgnoringBatteryOptimizations(this.f24794a.getPackageName())) {
            result.success(Boolean.TRUE);
            return;
        }
        if (this.f24794a.checkSelfPermission("android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS") == -1) {
            result.error("flutter_background.PermissionHandler", "The app does not have the REQUEST_IGNORE_BATTERY_OPTIMIZATIONS permission required to ask the user for whitelisting. See the documentation on how to setup this plugin properly.", null);
            return;
        }
        this.f24795b.invoke(new C3011d(new b(result), new c(result)));
        Intent intent = new Intent();
        intent.setAction("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
        intent.setData(Uri.parse("package:" + this.f24794a.getPackageName()));
        activity.startActivityForResult(intent, 5672353);
    }
}
