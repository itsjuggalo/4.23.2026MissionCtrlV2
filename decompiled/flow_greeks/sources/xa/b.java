package xa;

import android.content.Context;
import android.os.Bundle;
import kotlin.jvm.internal.t;
import xa.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f24709b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f24710a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public b(Context appContext) {
        t.f(appContext, "appContext");
        Bundle bundle = appContext.getPackageManager().getApplicationInfo(appContext.getPackageName(), 128).metaData;
        this.f24710a = bundle == null ? Bundle.EMPTY : bundle;
    }

    @Override // xa.o
    public Boolean a() {
        if (this.f24710a.containsKey("firebase_sessions_enabled")) {
            return Boolean.valueOf(this.f24710a.getBoolean("firebase_sessions_enabled"));
        }
        return null;
    }

    @Override // xa.o
    public lg.a b() {
        if (this.f24710a.containsKey("firebase_sessions_sessions_restart_timeout")) {
            return lg.a.i(lg.c.s(this.f24710a.getInt("firebase_sessions_sessions_restart_timeout"), lg.d.f15689e));
        }
        return null;
    }

    @Override // xa.o
    public Object c(gd.e eVar) {
        return o.a.a(this, eVar);
    }

    @Override // xa.o
    public Double d() {
        if (this.f24710a.containsKey("firebase_sessions_sampling_rate")) {
            return Double.valueOf(this.f24710a.getDouble("firebase_sessions_sampling_rate"));
        }
        return null;
    }
}
