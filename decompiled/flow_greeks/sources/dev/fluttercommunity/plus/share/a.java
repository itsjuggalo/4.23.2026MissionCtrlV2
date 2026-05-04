package dev.fluttercommunity.plus.share;

import android.content.Context;
import android.content.Intent;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements PluginRegistry.ActivityResultListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0149a f8081d = new C0149a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MethodChannel.Result f8083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AtomicBoolean f8084c;

    /* JADX INFO: renamed from: dev.fluttercommunity.plus.share.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0149a {
        public /* synthetic */ C0149a(k kVar) {
            this();
        }

        public C0149a() {
        }
    }

    public a(Context context) {
        t.f(context, "context");
        this.f8082a = context;
        this.f8084c = new AtomicBoolean(true);
    }

    public final void a() {
        this.f8084c.set(true);
        this.f8083b = null;
    }

    public final void b(String str) {
        MethodChannel.Result result;
        if (!this.f8084c.compareAndSet(false, true) || (result = this.f8083b) == null) {
            return;
        }
        t.c(result);
        result.success(str);
        this.f8083b = null;
    }

    public final void c(MethodChannel.Result callback) {
        t.f(callback, "callback");
        if (this.f8084c.compareAndSet(true, false)) {
            SharePlusPendingIntent.INSTANCE.b("");
            this.f8084c.set(false);
            this.f8083b = callback;
        } else {
            MethodChannel.Result result = this.f8083b;
            if (result != null) {
                result.success("dev.fluttercommunity.plus/share/unavailable");
            }
            SharePlusPendingIntent.INSTANCE.b("");
            this.f8084c.set(false);
            this.f8083b = callback;
        }
    }

    public final void d() {
        b("dev.fluttercommunity.plus/share/unavailable");
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int i10, int i11, Intent intent) {
        if (i10 != 22643) {
            return false;
        }
        b(SharePlusPendingIntent.INSTANCE.a());
        return true;
    }
}
