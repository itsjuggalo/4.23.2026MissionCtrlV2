package j4;

import android.content.Context;
import android.os.Bundle;
import j4.o;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import s5.InterfaceC2707e;

/* JADX INFO: renamed from: j4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2215b implements o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f20029b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f20030a;

    /* JADX INFO: renamed from: j4.b$a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public C2215b(Context appContext) {
        AbstractC2304t.f(appContext, "appContext");
        Bundle bundle = appContext.getPackageManager().getApplicationInfo(appContext.getPackageName(), 128).metaData;
        this.f20030a = bundle == null ? Bundle.EMPTY : bundle;
    }

    @Override // j4.o
    public Boolean a() {
        if (this.f20030a.containsKey("firebase_sessions_enabled")) {
            return Boolean.valueOf(this.f20030a.getBoolean("firebase_sessions_enabled"));
        }
        return null;
    }

    @Override // j4.o
    public W6.a b() {
        if (this.f20030a.containsKey("firebase_sessions_sessions_restart_timeout")) {
            return W6.a.k(W6.c.s(this.f20030a.getInt("firebase_sessions_sessions_restart_timeout"), W6.d.f9316e));
        }
        return null;
    }

    @Override // j4.o
    public Double c() {
        if (this.f20030a.containsKey("firebase_sessions_sampling_rate")) {
            return Double.valueOf(this.f20030a.getDouble("firebase_sessions_sampling_rate"));
        }
        return null;
    }

    @Override // j4.o
    public Object d(InterfaceC2707e interfaceC2707e) {
        return o.a.a(this, interfaceC2707e);
    }
}
