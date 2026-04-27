package y1;

import android.app.job.JobInfo;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import o1.EnumC2294f;
import y1.C2836c;

/* JADX INFO: renamed from: y1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2839f {

    /* JADX INFO: renamed from: y1.f$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public B1.a f25470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f25471b = new HashMap();

        public a a(EnumC2294f enumC2294f, b bVar) {
            this.f25471b.put(enumC2294f, bVar);
            return this;
        }

        public AbstractC2839f b() {
            if (this.f25470a == null) {
                throw new NullPointerException("missing required property: clock");
            }
            if (this.f25471b.keySet().size() < EnumC2294f.values().length) {
                throw new IllegalStateException("Not all priorities have been configured");
            }
            Map map = this.f25471b;
            this.f25471b = new HashMap();
            return AbstractC2839f.d(this.f25470a, map);
        }

        public a c(B1.a aVar) {
            this.f25470a = aVar;
            return this;
        }
    }

    /* JADX INFO: renamed from: y1.f$b */
    public static abstract class b {

        /* JADX INFO: renamed from: y1.f$b$a */
        public static abstract class a {
            public abstract b a();

            public abstract a b(long j7);

            public abstract a c(Set set);

            public abstract a d(long j7);
        }

        public static a a() {
            return new C2836c.b().c(Collections.emptySet());
        }

        public abstract long b();

        public abstract Set c();

        public abstract long d();
    }

    /* JADX INFO: renamed from: y1.f$c */
    public enum c {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    public static a b() {
        return new a();
    }

    public static AbstractC2839f d(B1.a aVar, Map map) {
        return new C2835b(aVar, map);
    }

    public static AbstractC2839f f(B1.a aVar) {
        return b().a(EnumC2294f.DEFAULT, b.a().b(30000L).d(86400000L).a()).a(EnumC2294f.HIGHEST, b.a().b(1000L).d(86400000L).a()).a(EnumC2294f.VERY_LOW, b.a().b(86400000L).d(86400000L).c(i(c.DEVICE_IDLE)).a()).c(aVar).b();
    }

    public static Set i(Object... objArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(objArr)));
    }

    public final long a(int i7, long j7) {
        return (long) (Math.pow(3.0d, i7 - 1) * j7 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j7 > 1 ? j7 : 2L) * ((long) r7))));
    }

    public JobInfo.Builder c(JobInfo.Builder builder, EnumC2294f enumC2294f, long j7, int i7) {
        builder.setMinimumLatency(g(enumC2294f, j7, i7));
        j(builder, ((b) h().get(enumC2294f)).c());
        return builder;
    }

    public abstract B1.a e();

    public long g(EnumC2294f enumC2294f, long j7, int i7) {
        long jA = j7 - e().a();
        b bVar = (b) h().get(enumC2294f);
        return Math.min(Math.max(a(i7, bVar.b()), jA), bVar.d());
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
