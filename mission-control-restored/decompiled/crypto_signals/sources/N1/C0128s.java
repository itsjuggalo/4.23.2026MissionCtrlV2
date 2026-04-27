package N1;

/* JADX INFO: renamed from: N1.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0128s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f1780d;
    public final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f1781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f1782g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f1783h;
    public final Long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f1784j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f1785k;

    public C0128s(String str, String str2, long j4, long j6, long j7, long j8, long j9, Long l6, Long l7, Long l8, Boolean bool) {
        com.google.android.gms.common.internal.I.d(str);
        com.google.android.gms.common.internal.I.d(str2);
        com.google.android.gms.common.internal.I.b(j4 >= 0);
        com.google.android.gms.common.internal.I.b(j6 >= 0);
        com.google.android.gms.common.internal.I.b(j7 >= 0);
        com.google.android.gms.common.internal.I.b(j9 >= 0);
        this.f1777a = str;
        this.f1778b = str2;
        this.f1779c = j4;
        this.f1780d = j6;
        this.e = j7;
        this.f1781f = j8;
        this.f1782g = j9;
        this.f1783h = l6;
        this.i = l7;
        this.f1784j = l8;
        this.f1785k = bool;
    }

    public final C0128s a(long j4) {
        return new C0128s(this.f1777a, this.f1778b, this.f1779c, this.f1780d, this.e, j4, this.f1782g, this.f1783h, this.i, this.f1784j, this.f1785k);
    }

    public final C0128s b(Long l6, Long l7, Boolean bool) {
        return new C0128s(this.f1777a, this.f1778b, this.f1779c, this.f1780d, this.e, this.f1781f, this.f1782g, this.f1783h, l6, l7, bool);
    }
}
