package s4;

import android.app.job.JobInfo;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import s4.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public v4.a f19978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f19979b = new HashMap();

        public a a(i4.f fVar, b bVar) {
            this.f19979b.put(fVar, bVar);
            return this;
        }

        public f b() {
            if (this.f19978a == null) {
                throw new NullPointerException("missing required property: clock");
            }
            if (this.f19979b.keySet().size() < i4.f.values().length) {
                throw new IllegalStateException("Not all priorities have been configured");
            }
            Map map = this.f19979b;
            this.f19979b = new HashMap();
            return f.d(this.f19978a, map);
        }

        public a c(v4.a aVar) {
            this.f19978a = aVar;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class b {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static abstract class a {
            public abstract b a();

            public abstract a b(long j10);

            public abstract a c(Set set);

            public abstract a d(long j10);
        }

        public static a a() {
            return new c.b().c(Collections.EMPTY_SET);
        }

        public abstract long b();

        public abstract Set c();

        public abstract long d();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum c {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    public static a b() {
        return new a();
    }

    public static f d(v4.a aVar, Map map) {
        return new s4.b(aVar, map);
    }

    public static f f(v4.a aVar) {
        return b().a(i4.f.DEFAULT, b.a().b(HTTPTimeoutManager.DEFAULT_TIMEOUT_MS).d(86400000L).a()).a(i4.f.HIGHEST, b.a().b(1000L).d(86400000L).a()).a(i4.f.VERY_LOW, b.a().b(86400000L).d(86400000L).c(i(c.DEVICE_IDLE)).a()).c(aVar).b();
    }

    public static Set i(Object... objArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(objArr)));
    }

    public final long a(int i10, long j10) {
        return (long) (Math.pow(3.0d, i10 - 1) * j10 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j10 > 1 ? j10 : 2L) * ((long) r7))));
    }

    public JobInfo.Builder c(JobInfo.Builder builder, i4.f fVar, long j10, int i10) {
        builder.setMinimumLatency(g(fVar, j10, i10));
        j(builder, ((b) h().get(fVar)).c());
        return builder;
    }

    public abstract v4.a e();

    public long g(i4.f fVar, long j10, int i10) {
        long jA = j10 - e().a();
        b bVar = (b) h().get(fVar);
        return Math.min(Math.max(a(i10, bVar.b()), jA), bVar.d());
    }

    public abstract Map h();

    public final void j(JobInfo.Builder builder, Set set) {
        if (set.contains(c.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(c.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(c.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }
}
