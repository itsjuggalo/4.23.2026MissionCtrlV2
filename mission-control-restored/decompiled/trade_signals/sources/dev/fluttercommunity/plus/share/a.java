package dev.fluttercommunity.plus.share;

import android.content.Context;
import android.content.Intent;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class a implements PluginRegistry.ActivityResultListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0287a f17085d = new C0287a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f17086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MethodChannel.Result f17087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AtomicBoolean f17088c;

    /* JADX INFO: renamed from: dev.fluttercommunity.plus.share.a$a, reason: collision with other inner class name */
    public static final class C0287a {
        public C0287a() {
        }

        public /* synthetic */ C0287a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public a(Context context) {
        AbstractC2304t.f(context, "context");
        this.f17086a = context;
        this.f17088c = new AtomicBoolean(true);
    }

    public final void a() {
        this.f17088c.set(true);
        this.f17087b = null;
    }

    public final void b(String str) {
        MethodChannel.Result result;
        if (!this.f17088c.compareAndSet(false, true) || (result = this.f17087b) == null) {
            return;
        }
        AbstractC2304t.c(result);
        result.success(str);
        this.f17087b = null;
    }

    public final void c(MethodChannel.Result callback) {
        MethodChannel.Result result;
        AbstractC2304t.f(callback, "callback");
        if (!this.f17088c.compareAndSet(true, false) && (result = this.f17087b) != null) {
            result.success("dev.fluttercommunity.plus/share/unavailable");
        }
        SharePlusPendingIntent.f17083a.b("");
        this.f17088c.set(false);
        this.f17087b = callback;
    }

    public final void d() {
        b("dev.fluttercommunity.plus/share/unavailable");
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int i8, int i9, Intent intent) {
        if (i8 != 22643) {
            return false;
        }
        b(SharePlusPendingIntent.f17083a.a());
        return true;
    }
}
