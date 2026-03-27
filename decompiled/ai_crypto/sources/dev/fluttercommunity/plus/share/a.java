package dev.fluttercommunity.plus.share;

import V4.j;
import V4.l;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0231a f13506f = new C0231a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f13507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j.d f13508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AtomicBoolean f13509e;

    /* JADX INFO: renamed from: dev.fluttercommunity.plus.share.a$a, reason: collision with other inner class name */
    public static final class C0231a {
        public /* synthetic */ C0231a(AbstractC2148j abstractC2148j) {
            this();
        }

        public C0231a() {
        }
    }

    public a(Context context) {
        r.f(context, "context");
        this.f13507c = context;
        this.f13509e = new AtomicBoolean(true);
    }

    public final void a() {
        this.f13509e.set(true);
        this.f13508d = null;
    }

    public final void b(String str) {
        j.d dVar;
        if (!this.f13509e.compareAndSet(false, true) || (dVar = this.f13508d) == null) {
            return;
        }
        r.c(dVar);
        dVar.a(str);
        this.f13508d = null;
    }

    public final void c(j.d callback) {
        r.f(callback, "callback");
        if (this.f13509e.compareAndSet(true, false)) {
            SharePlusPendingIntent.f13504a.b("");
            this.f13509e.set(false);
            this.f13508d = callback;
        } else {
            j.d dVar = this.f13508d;
            if (dVar != null) {
                dVar.a("dev.fluttercommunity.plus/share/unavailable");
            }
            SharePlusPendingIntent.f13504a.b("");
            this.f13509e.set(false);
            this.f13508d = callback;
        }
    }

    public final void d() {
        b("dev.fluttercommunity.plus/share/unavailable");
    }

    @Override // V4.l
    public boolean onActivityResult(int i7, int i8, Intent intent) {
        if (i7 != 22643) {
            return false;
        }
        b(SharePlusPendingIntent.f13504a.a());
        return true;
    }
}
