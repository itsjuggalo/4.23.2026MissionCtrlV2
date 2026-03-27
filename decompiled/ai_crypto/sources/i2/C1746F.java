package i2;

import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: i2.F, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1746F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f15088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f15089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f15090e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f15091f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f15092g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f15093h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f15094i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f15095j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f15096k;

    public C1746F(String str, String str2, long j7, long j8, long j9, long j10, long j11, Long l7, Long l8, Long l9, Boolean bool) {
        AbstractC1207s.e(str);
        AbstractC1207s.e(str2);
        AbstractC1207s.a(j7 >= 0);
        AbstractC1207s.a(j8 >= 0);
        AbstractC1207s.a(j9 >= 0);
        AbstractC1207s.a(j11 >= 0);
        this.f15086a = str;
        this.f15087b = str2;
        this.f15088c = j7;
        this.f15089d = j8;
        this.f15090e = j9;
        this.f15091f = j10;
        this.f15092g = j11;
        this.f15093h = l7;
        this.f15094i = l8;
        this.f15095j = l9;
        this.f15096k = bool;
    }

    public final C1746F a(long j7) {
        return new C1746F(this.f15086a, this.f15087b, this.f15088c, this.f15089d, this.f15090e, j7, this.f15092g, this.f15093h, this.f15094i, this.f15095j, this.f15096k);
    }

    public final C1746F b(long j7, long j8) {
        return new C1746F(this.f15086a, this.f15087b, this.f15088c, this.f15089d, this.f15090e, this.f15091f, j7, Long.valueOf(j8), this.f15094i, this.f15095j, this.f15096k);
    }

    public final C1746F c(Long l7, Long l8, Boolean bool) {
        return new C1746F(this.f15086a, this.f15087b, this.f15088c, this.f15089d, this.f15090e, this.f15091f, this.f15092g, this.f15093h, l7, l8, bool);
    }
}
