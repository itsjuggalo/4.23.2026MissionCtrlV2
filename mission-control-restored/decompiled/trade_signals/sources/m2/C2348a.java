package m2;

import android.app.PendingIntent;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: m2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2348a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f21349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f21350e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f21351f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f21352g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f21353h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f21354i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f21355j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PendingIntent f21356k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PendingIntent f21357l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PendingIntent f21358m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final PendingIntent f21359n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map f21360o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f21361p = false;

    public C2348a(String str, int i8, int i9, int i10, Integer num, int i11, long j8, long j9, long j10, long j11, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4, Map map) {
        this.f21346a = str;
        this.f21347b = i8;
        this.f21348c = i9;
        this.f21349d = i10;
        this.f21350e = num;
        this.f21351f = i11;
        this.f21352g = j8;
        this.f21353h = j9;
        this.f21354i = j10;
        this.f21355j = j11;
        this.f21356k = pendingIntent;
        this.f21357l = pendingIntent2;
        this.f21358m = pendingIntent3;
        this.f21359n = pendingIntent4;
        this.f21360o = map;
    }

    public static C2348a k(String str, int i8, int i9, int i10, Integer num, int i11, long j8, long j9, long j10, long j11, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4, Map map) {
        return new C2348a(str, i8, i9, i10, num, i11, j8, j9, j10, j11, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4, map);
    }

    public static Set n(Set set) {
        return set == null ? new HashSet() : set;
    }

    public int a() {
        return this.f21347b;
    }

    public Integer b() {
        return this.f21350e;
    }

    public Set c(AbstractC2351d abstractC2351d) {
        Map map;
        String str;
        boolean zA = abstractC2351d.a();
        int iB = abstractC2351d.b();
        if (zA) {
            if (iB == 0) {
                map = this.f21360o;
                str = "nonblocking.destructive.intent";
            } else {
                map = this.f21360o;
                str = "blocking.destructive.intent";
            }
        } else if (iB == 0) {
            map = this.f21360o;
            str = "nonblocking.intent";
        } else {
            map = this.f21360o;
            str = "blocking.intent";
        }
        return n((Set) map.get(str));
    }

    public int d() {
        return this.f21349d;
    }

    public boolean e(int i8) {
        return j(AbstractC2351d.c(i8)) != null;
    }

    public boolean f(AbstractC2351d abstractC2351d) {
        return j(abstractC2351d) != null;
    }

    public String g() {
        return this.f21346a;
    }

    public int h() {
        return this.f21348c;
    }

    public int i() {
        return this.f21351f;
    }

    public final PendingIntent j(AbstractC2351d abstractC2351d) {
        if (abstractC2351d.b() == 0) {
            PendingIntent pendingIntent = this.f21357l;
            if (pendingIntent != null) {
                return pendingIntent;
            }
            if (o(abstractC2351d)) {
                return this.f21359n;
            }
            return null;
        }
        if (abstractC2351d.b() == 1) {
            PendingIntent pendingIntent2 = this.f21356k;
            if (pendingIntent2 != null) {
                return pendingIntent2;
            }
            if (o(abstractC2351d)) {
                return this.f21358m;
            }
        }
        return null;
    }

    public final void l() {
        this.f21361p = true;
    }

    public final boolean m() {
        return this.f21361p;
    }

    public final boolean o(AbstractC2351d abstractC2351d) {
        return abstractC2351d.a() && this.f21354i <= this.f21355j;
    }
}
