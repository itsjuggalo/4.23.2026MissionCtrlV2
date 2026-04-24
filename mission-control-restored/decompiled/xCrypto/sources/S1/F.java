package S1;

import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public final class F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f3930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f3931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f3932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f3933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f3934h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f3935i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f3936j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f3937k;

    public F(String str, String str2, long j4, long j5, long j6, long j7, long j8, Long l4, Long l5, Long l6, Boolean bool) {
        AbstractC0940s.e(str);
        AbstractC0940s.e(str2);
        AbstractC0940s.a(j4 >= 0);
        AbstractC0940s.a(j5 >= 0);
        AbstractC0940s.a(j6 >= 0);
        AbstractC0940s.a(j8 >= 0);
        this.f3927a = str;
        this.f3928b = str2;
        this.f3929c = j4;
        this.f3930d = j5;
        this.f3931e = j6;
        this.f3932f = j7;
        this.f3933g = j8;
        this.f3934h = l4;
        this.f3935i = l5;
        this.f3936j = l6;
        this.f3937k = bool;
    }

    public final F a(long j4) {
        return new F(this.f3927a, this.f3928b, this.f3929c, this.f3930d, this.f3931e, j4, this.f3933g, this.f3934h, this.f3935i, this.f3936j, this.f3937k);
    }

    public final F b(long j4, long j5) {
        return new F(this.f3927a, this.f3928b, this.f3929c, this.f3930d, this.f3931e, this.f3932f, j4, Long.valueOf(j5), this.f3935i, this.f3936j, this.f3937k);
    }

    public final F c(Long l4, Long l5, Boolean bool) {
        return new F(this.f3927a, this.f3928b, this.f3929c, this.f3930d, this.f3931e, this.f3932f, this.f3933g, this.f3934h, l4, l5, bool);
    }
}
