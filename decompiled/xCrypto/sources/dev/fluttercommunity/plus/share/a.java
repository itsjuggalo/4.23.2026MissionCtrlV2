package dev.fluttercommunity.plus.share;

import android.content.Context;
import android.content.Intent;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements PluginRegistry.ActivityResultListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0185a f11434d = new C0185a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MethodChannel.Result f11436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AtomicBoolean f11437c;

    /* JADX INFO: renamed from: dev.fluttercommunity.plus.share.a$a, reason: collision with other inner class name */
    public static final class C0185a {
        public /* synthetic */ C0185a(AbstractC1585j abstractC1585j) {
            this();
        }

        public C0185a() {
        }
    }

    public a(Context context) {
        r.f(context, "context");
        this.f11435a = context;
        this.f11437c = new AtomicBoolean(true);
    }

    public final void a() {
        this.f11437c.set(true);
        this.f11436b = null;
    }

    public final void b(String str) {
        MethodChannel.Result result;
        if (!this.f11437c.compareAndSet(false, true) || (result = this.f11436b) == null) {
            return;
        }
        r.c(result);
        result.success(str);
        this.f11436b = null;
    }

    public final void c(MethodChannel.Result callback) {
        r.f(callback, "callback");
        if (this.f11437c.compareAndSet(true, false)) {
            SharePlusPendingIntent.f11432a.b("");
            this.f11437c.set(false);
            this.f11436b = callback;
        } else {
            MethodChannel.Result result = this.f11436b;
            if (result != null) {
                result.success("dev.fluttercommunity.plus/share/unavailable");
            }
            SharePlusPendingIntent.f11432a.b("");
            this.f11437c.set(false);
            this.f11436b = callback;
        }
    }

    public final void d() {
        b("dev.fluttercommunity.plus/share/unavailable");
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int i4, int i5, Intent intent) {
        if (i4 != 22643) {
            return false;
        }
        b(SharePlusPendingIntent.f11432a.a());
        return true;
    }
}
