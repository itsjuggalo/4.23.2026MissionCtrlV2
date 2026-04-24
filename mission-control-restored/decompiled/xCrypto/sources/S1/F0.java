package S1;

import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Iterator;
import java.util.Map;
import u.C1853a;

/* JADX INFO: loaded from: classes.dex */
public final class F0 extends H1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f3938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f3939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3940d;

    public F0(C0658q3 c0658q3) {
        super(c0658q3);
        this.f3939c = new C1853a();
        this.f3938b = new C1853a();
    }

    public final void i(String str, long j4) {
        if (str == null || str.length() == 0) {
            this.f4245a.a().o().a("Ad unit id must be a non-empty string");
        } else {
            this.f4245a.b().t(new RunnableC0526a(this, str, j4));
        }
    }

    public final void j(String str, long j4) {
        if (str == null || str.length() == 0) {
            this.f4245a.a().o().a("Ad unit id must be a non-empty string");
        } else {
            this.f4245a.b().t(new C(this, str, j4));
        }
    }

    public final void k(long j4) {
        C0628m5 c0628m5Q = this.f4245a.I().q(false);
        Map map = this.f3938b;
        for (String str : map.keySet()) {
            p(str, j4 - ((Long) map.get(str)).longValue(), c0628m5Q);
        }
        if (!map.isEmpty()) {
            o(j4 - this.f3940d, c0628m5Q);
        }
        n(j4);
    }

    public final /* synthetic */ void l(String str, long j4) {
        h();
        AbstractC0940s.e(str);
        Map map = this.f3939c;
        if (map.isEmpty()) {
            this.f3940d = j4;
        }
        Integer num = (Integer) map.get(str);
        if (num != null) {
            map.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (map.size() >= 100) {
            this.f4245a.a().r().a("Too many ads visible");
        } else {
            map.put(str, 1);
            this.f3938b.put(str, Long.valueOf(j4));
        }
    }

    public final /* synthetic */ void m(String str, long j4) {
        h();
        AbstractC0940s.e(str);
        Map map = this.f3939c;
        Integer num = (Integer) map.get(str);
        if (num == null) {
            this.f4245a.a().o().b("Call to endAdUnitExposure for unknown ad unit id", str);
            return;
        }
        C0628m5 c0628m5Q = this.f4245a.I().q(false);
        int iIntValue = num.intValue() - 1;
        if (iIntValue != 0) {
            map.put(str, Integer.valueOf(iIntValue));
            return;
        }
        map.remove(str);
        Map map2 = this.f3938b;
        Long l4 = (Long) map2.get(str);
        if (l4 == null) {
            this.f4245a.a().o().a("First ad unit exposure time was never set");
        } else {
            long jLongValue = j4 - l4.longValue();
            map2.remove(str);
            p(str, jLongValue, c0628m5Q);
        }
        if (map.isEmpty()) {
            long j5 = this.f3940d;
            if (j5 == 0) {
                this.f4245a.a().o().a("First ad exposure time was never set");
            } else {
                o(j4 - j5, c0628m5Q);
                this.f3940d = 0L;
            }
        }
    }

    public final void o(long j4, C0628m5 c0628m5) {
        if (c0628m5 == null) {
            this.f4245a.a().w().a("Not logging ad exposure. No active activity");
            return;
        }
        if (j4 < 1000) {
            this.f4245a.a().w().b("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j4));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j4);
        l7.k0(c0628m5, bundle, true);
        this.f4245a.B().t("am", "_xa", bundle);
    }

    public final void p(String str, long j4, C0628m5 c0628m5) {
        if (c0628m5 == null) {
            this.f4245a.a().w().a("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j4 < 1000) {
            this.f4245a.a().w().b("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j4));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j4);
        l7.k0(c0628m5, bundle, true);
        this.f4245a.B().t("am", "_xu", bundle);
    }

    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final void n(long j4) {
        Map map = this.f3938b;
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            map.put((String) it.next(), Long.valueOf(j4));
        }
        if (map.isEmpty()) {
            return;
        }
        this.f3940d = j4;
    }
}
