package h1;

import android.app.job.JobInfo;
import h1.C1280c;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import k1.InterfaceC1567a;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InterfaceC1567a f12106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f12107b = new HashMap();

        public a a(X0.f fVar, b bVar) {
            this.f12107b.put(fVar, bVar);
            return this;
        }

        public f b() {
            if (this.f12106a == null) {
                throw new NullPointerException("missing required property: clock");
            }
            if (this.f12107b.keySet().size() < X0.f.values().length) {
                throw new IllegalStateException("Not all priorities have been configured");
            }
            Map map = this.f12107b;
            this.f12107b = new HashMap();
            return f.d(this.f12106a, map);
        }

        public a c(InterfaceC1567a interfaceC1567a) {
            this.f12106a = interfaceC1567a;
            return this;
        }
    }

    public static abstract class b {

        public static abstract class a {
            public abstract b a();

            public abstract a b(long j4);

            public abstract a c(Set set);

            public abstract a d(long j4);
        }

        public static a a() {
            return new C1280c.b().c(Collections.EMPTY_SET);
        }

        public abstract long b();

        public abstract Set c();

        public abstract long d();
    }

    public enum c {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    public static a b() {
        return new a();
    }

    public static f d(InterfaceC1567a interfaceC1567a, Map map) {
        return new C1279b(interfaceC1567a, map);
    }

    public static f f(InterfaceC1567a interfaceC1567a) {
        return b().a(X0.f.DEFAULT, b.a().b(30000L).d(86400000L).a()).a(X0.f.HIGHEST, b.a().b(1000L).d(86400000L).a()).a(X0.f.VERY_LOW, b.a().b(86400000L).d(86400000L).c(i(c.DEVICE_IDLE)).a()).c(interfaceC1567a).b();
    }

    public static Set i(Object... objArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(objArr)));
    }

    public final long a(int i4, long j4) {
        return (long) (Math.pow(3.0d, i4 - 1) * j4 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j4 > 1 ? j4 : 2L) * ((long) r7))));
    }

    public JobInfo.Builder c(JobInfo.Builder builder, X0.f fVar, long j4, int i4) {
        builder.setMinimumLatency(g(fVar, j4, i4));
        j(builder, ((b) h().get(fVar)).c());
        return builder;
    }

    public abstract InterfaceC1567a e();

    public long g(X0.f fVar, long j4, int i4) {
        long jA = j4 - e().a();
        b bVar = (b) h().get(fVar);
        return Math.min(Math.max(a(i4, bVar.b()), jA), bVar.d());
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
