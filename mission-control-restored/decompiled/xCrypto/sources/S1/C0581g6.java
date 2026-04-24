package S1;

import android.content.pm.PackageManager;
import android.util.Pair;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import m1.C1602a;

/* JADX INFO: renamed from: S1.g6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0581g6 extends M6 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f4638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final N2 f4639e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final N2 f4640f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final N2 f4641g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final N2 f4642h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final N2 f4643i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final N2 f4644j;

    public C0581g6(b7 b7Var) {
        super(b7Var);
        this.f4638d = new HashMap();
        Q2 q2X = this.f4245a.x();
        Objects.requireNonNull(q2X);
        this.f4639e = new N2(q2X, "last_delete_stale", 0L);
        Q2 q2X2 = this.f4245a.x();
        Objects.requireNonNull(q2X2);
        this.f4640f = new N2(q2X2, "last_delete_stale_batch", 0L);
        Q2 q2X3 = this.f4245a.x();
        Objects.requireNonNull(q2X3);
        this.f4641g = new N2(q2X3, "backoff", 0L);
        Q2 q2X4 = this.f4245a.x();
        Objects.requireNonNull(q2X4);
        this.f4642h = new N2(q2X4, "last_upload", 0L);
        Q2 q2X5 = this.f4245a.x();
        Objects.requireNonNull(q2X5);
        this.f4643i = new N2(q2X5, "last_upload_attempt", 0L);
        Q2 q2X6 = this.f4245a.x();
        Objects.requireNonNull(q2X6);
        this.f4644j = new N2(q2X6, "midnight_offset", 0L);
    }

    @Override // S1.M6
    public final boolean l() {
        return false;
    }

    public final Pair m(String str, C0531a4 c0531a4) {
        return c0531a4.o(Z3.AD_STORAGE) ? n(str) : new Pair("", Boolean.FALSE);
    }

    public final Pair n(String str) {
        C0573f6 c0573f6;
        C1602a.C0210a c0210aA;
        h();
        C0658q3 c0658q3 = this.f4245a;
        long jA = c0658q3.f().a();
        C0573f6 c0573f62 = (C0573f6) this.f4638d.get(str);
        if (c0573f62 != null && jA < c0573f62.f4627c) {
            return new Pair(c0573f62.f4625a, Boolean.valueOf(c0573f62.f4626b));
        }
        C1602a.b(true);
        long jD = c0658q3.w().D(str, AbstractC0569f2.f4557b) + jA;
        try {
            try {
                c0210aA = C1602a.a(c0658q3.e());
            } catch (PackageManager.NameNotFoundException unused) {
                c0210aA = null;
                if (c0573f62 != null && jA < c0573f62.f4627c + this.f4245a.w().D(str, AbstractC0569f2.f4560c)) {
                    return new Pair(c0573f62.f4625a, Boolean.valueOf(c0573f62.f4626b));
                }
            }
        } catch (Exception e4) {
            this.f4245a.a().v().b("Unable to get advertising id", e4);
            c0573f6 = new C0573f6("", false, jD);
        }
        if (c0210aA == null) {
            return new Pair("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
        }
        String strA = c0210aA.a();
        c0573f6 = strA != null ? new C0573f6(strA, c0210aA.b(), jD) : new C0573f6("", c0210aA.b(), jD);
        this.f4638d.put(str, c0573f6);
        C1602a.b(false);
        return new Pair(c0573f6.f4625a, Boolean.valueOf(c0573f6.f4626b));
    }

    public final String o(String str, boolean z4) {
        h();
        String str2 = z4 ? (String) n(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest messageDigestC = l7.C();
        if (messageDigestC == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestC.digest(str2.getBytes())));
    }
}
