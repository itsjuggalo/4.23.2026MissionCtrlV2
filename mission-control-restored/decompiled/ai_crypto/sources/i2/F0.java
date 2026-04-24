package i2;

import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.Iterator;
import java.util.Map;
import u.C2736a;

/* JADX INFO: loaded from: classes.dex */
public final class F0 extends H1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f15097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f15098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f15099d;

    public F0(C1898q3 c1898q3) {
        super(c1898q3);
        this.f15098c = new C2736a();
        this.f15097b = new C2736a();
    }

    public final void i(String str, long j7) {
        if (str == null || str.length() == 0) {
            this.f15404a.a().o().a("Ad unit id must be a non-empty string");
        } else {
            this.f15404a.b().t(new RunnableC1766a(this, str, j7));
        }
    }

    public final void j(String str, long j7) {
        if (str == null || str.length() == 0) {
            this.f15404a.a().o().a("Ad unit id must be a non-empty string");
        } else {
            this.f15404a.b().t(new RunnableC1743C(this, str, j7));
        }
    }

    public final void k(long j7) {
        C1868m5 c1868m5Q = this.f15404a.I().q(false);
        Map map = this.f15097b;
        for (String str : map.keySet()) {
            p(str, j7 - ((Long) map.get(str)).longValue(), c1868m5Q);
        }
        if (!map.isEmpty()) {
            o(j7 - this.f15099d, c1868m5Q);
        }
        n(j7);
    }

    public final /* synthetic */ void l(String str, long j7) {
        h();
        AbstractC1207s.e(str);
        Map map = this.f15098c;
        if (map.isEmpty()) {
            this.f15099d = j7;
        }
        Integer num = (Integer) map.get(str);
        if (num != null) {
            map.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (map.size() >= 100) {
            this.f15404a.a().r().a("Too many ads visible");
        } else {
            map.put(str, 1);
            this.f15097b.put(str, Long.valueOf(j7));
        }
    }

    public final /* synthetic */ void m(String str, long j7) {
        h();
        AbstractC1207s.e(str);
        Map map = this.f15098c;
        Integer num = (Integer) map.get(str);
        if (num == null) {
            this.f15404a.a().o().b("Call to endAdUnitExposure for unknown ad unit id", str);
            return;
        }
        C1868m5 c1868m5Q = this.f15404a.I().q(false);
        int iIntValue = num.intValue() - 1;
        if (iIntValue != 0) {
            map.put(str, Integer.valueOf(iIntValue));
            return;
        }
        map.remove(str);
        Map map2 = this.f15097b;
        Long l7 = (Long) map2.get(str);
        if (l7 == null) {
            this.f15404a.a().o().a("First ad unit exposure time was never set");
        } else {
            long jLongValue = j7 - l7.longValue();
            map2.remove(str);
            p(str, jLongValue, c1868m5Q);
        }
        if (map.isEmpty()) {
            long j8 = this.f15099d;
            if (j8 == 0) {
                this.f15404a.a().o().a("First ad exposure time was never set");
            } else {
                o(j7 - j8, c1868m5Q);
                this.f15099d = 0L;
            }
        }
    }

    public final void o(long j7, C1868m5 c1868m5) {
        if (c1868m5 == null) {
            this.f15404a.a().w().a("Not logging ad exposure. No active activity");
            return;
        }
        if (j7 < 1000) {
            this.f15404a.a().w().b("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j7));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j7);
        l7.k0(c1868m5, bundle, true);
        this.f15404a.B().t("am", "_xa", bundle);
    }

    public final void p(String str, long j7, C1868m5 c1868m5) {
        if (c1868m5 == null) {
            this.f15404a.a().w().a("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j7 < 1000) {
            this.f15404a.a().w().b("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j7));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j7);
        l7.k0(c1868m5, bundle, true);
        this.f15404a.B().t("am", "_xu", bundle);
    }

    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final void n(long j7) {
        Map map = this.f15097b;
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            map.put((String) it.next(), Long.valueOf(j7));
        }
        if (map.isEmpty()) {
            return;
        }
        this.f15099d = j7;
    }
}
