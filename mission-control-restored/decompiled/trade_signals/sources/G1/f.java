package G1;

import G1.c;
import android.app.job.JobInfo;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import w1.EnumC2903f;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public J1.a f2101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f2102b = new HashMap();

        public a a(EnumC2903f enumC2903f, b bVar) {
            this.f2102b.put(enumC2903f, bVar);
            return this;
        }

        public f b() {
            if (this.f2101a == null) {
                throw new NullPointerException("missing required property: clock");
            }
            if (this.f2102b.keySet().size() < EnumC2903f.values().length) {
                throw new IllegalStateException("Not all priorities have been configured");
            }
            Map map = this.f2102b;
            this.f2102b = new HashMap();
            return f.d(this.f2101a, map);
        }

        public a c(J1.a aVar) {
            this.f2101a = aVar;
            return this;
        }
    }

    public static abstract class b {

        public static abstract class a {
            public abstract b a();

            public abstract a b(long j8);

            public abstract a c(Set set);

            public abstract a d(long j8);
        }

        public static a a() {
            return new c.b().c(Collections.emptySet());
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

    public static f d(J1.a aVar, Map map) {
        return new G1.b(aVar, map);
    }

    public static f f(J1.a aVar) {
        return b().a(EnumC2903f.DEFAULT, b.a().b(30000L).d(86400000L).a()).a(EnumC2903f.HIGHEST, b.a().b(1000L).d(86400000L).a()).a(EnumC2903f.VERY_LOW, b.a().b(86400000L).d(86400000L).c(i(c.DEVICE_IDLE)).a()).c(aVar).b();
    }

    public static Set i(Object... objArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(objArr)));
    }

    public final long a(int i8, long j8) {
        return (long) (Math.pow(3.0d, i8 - 1) * j8 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j8 > 1 ? j8 : 2L) * ((long) r7))));
    }

    public JobInfo.Builder c(JobInfo.Builder builder, EnumC2903f enumC2903f, long j8, int i8) {
        builder.setMinimumLatency(g(enumC2903f, j8, i8));
        j(builder, ((b) h().get(enumC2903f)).c());
        return builder;
    }

    public abstract J1.a e();

    public long g(EnumC2903f enumC2903f, long j8, int i8) {
        long jA = j8 - e().a();
        b bVar = (b) h().get(enumC2903f);
        return Math.min(Math.max(a(i8, bVar.b()), jA), bVar.d());
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
