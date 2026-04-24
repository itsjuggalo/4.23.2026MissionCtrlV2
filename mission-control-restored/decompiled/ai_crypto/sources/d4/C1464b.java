package d4;

import a6.C0929a;
import android.content.Context;
import android.os.Bundle;
import d4.m;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: d4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1464b implements m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f13343b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f13344a;

    /* JADX INFO: renamed from: d4.b$a */
    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public C1464b(Context appContext) {
        r.f(appContext, "appContext");
        Bundle bundle = appContext.getPackageManager().getApplicationInfo(appContext.getPackageName(), 128).metaData;
        this.f13344a = bundle == null ? Bundle.EMPTY : bundle;
    }

    @Override // d4.m
    public Boolean a() {
        if (this.f13344a.containsKey("firebase_sessions_enabled")) {
            return Boolean.valueOf(this.f13344a.getBoolean("firebase_sessions_enabled"));
        }
        return null;
    }

    @Override // d4.m
    public Object b(H5.d dVar) {
        return m.a.a(this, dVar);
    }

    @Override // d4.m
    public C0929a c() {
        if (this.f13344a.containsKey("firebase_sessions_sessions_restart_timeout")) {
            return C0929a.i(a6.c.s(this.f13344a.getInt("firebase_sessions_sessions_restart_timeout"), a6.d.f6410e));
        }
        return null;
    }

    @Override // d4.m
    public Double d() {
        if (this.f13344a.containsKey("firebase_sessions_sampling_rate")) {
            return Double.valueOf(this.f13344a.getDouble("firebase_sessions_sampling_rate"));
        }
        return null;
    }
}
