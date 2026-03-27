package j$.time.format;

import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DateTimeFormatter f19779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f19780b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f19781c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayList f19782d;

    q(DateTimeFormatter dateTimeFormatter) {
        ArrayList arrayList = new ArrayList();
        this.f19782d = arrayList;
        this.f19779a = dateTimeFormatter;
        arrayList.add(new x());
    }

    static boolean b(char c8, char c9) {
        return c8 == c9 || Character.toUpperCase(c8) == Character.toUpperCase(c9) || Character.toLowerCase(c8) == Character.toLowerCase(c9);
    }

    private x d() {
        return (x) this.f19782d.get(r0.size() - 1);
    }

    final boolean a(char c8, char c9) {
        return this.f19780b ? c8 == c9 : b(c8, c9);
    }

    final q c() {
        q qVar = new q(this.f19779a);
        qVar.f19780b = this.f19780b;
        qVar.f19781c = this.f19781c;
        return qVar;
    }

    final void e(boolean z7) {
        this.f19782d.remove(z7 ? r0.size() - 2 : r0.size() - 1);
    }

    final w f() {
        return this.f19779a.b();
    }

    final j$.time.chrono.l g() {
        j$.time.chrono.l lVar = d().f19795c;
        if (lVar != null) {
            return lVar;
        }
        j$.time.chrono.l lVarA = this.f19779a.a();
        return lVarA == null ? j$.time.chrono.s.f19713d : lVarA;
    }

    final Locale h() {
        return this.f19779a.c();
    }

    final Long i(j$.time.temporal.r rVar) {
        return (Long) d().f19793a.get(rVar);
    }

    final boolean j() {
        return this.f19780b;
    }

    final boolean k() {
        return this.f19781c;
    }

    final void l(boolean z7) {
        this.f19780b = z7;
    }

    final void m(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        d().f19794b = zoneId;
    }

    final int n(j$.time.temporal.r rVar, long j8, int i8, int i9) {
        Objects.requireNonNull(rVar, "field");
        Long l8 = (Long) d().f19793a.put(rVar, Long.valueOf(j8));
        return (l8 == null || l8.longValue() == j8) ? i9 : ~i8;
    }

    final void o() {
        d().f19796d = true;
    }

    final void p(boolean z7) {
        this.f19781c = z7;
    }

    final void q() {
        ArrayList arrayList = this.f19782d;
        x xVarD = d();
        xVarD.getClass();
        x xVar = new x();
        xVar.f19793a.putAll(xVarD.f19793a);
        xVar.f19794b = xVarD.f19794b;
        xVar.f19795c = xVarD.f19795c;
        xVar.f19796d = xVarD.f19796d;
        arrayList.add(xVar);
    }

    final boolean r(CharSequence charSequence, int i8, CharSequence charSequence2, int i9, int i10) {
        if (i8 + i10 > charSequence.length() || i9 + i10 > charSequence2.length()) {
            return false;
        }
        if (this.f19780b) {
            for (int i11 = 0; i11 < i10; i11++) {
                if (charSequence.charAt(i8 + i11) != charSequence2.charAt(i9 + i11)) {
                    return false;
                }
            }
            return true;
        }
        for (int i12 = 0; i12 < i10; i12++) {
            char cCharAt = charSequence.charAt(i8 + i12);
            char cCharAt2 = charSequence2.charAt(i9 + i12);
            if (cCharAt != cCharAt2 && Character.toUpperCase(cCharAt) != Character.toUpperCase(cCharAt2) && Character.toLowerCase(cCharAt) != Character.toLowerCase(cCharAt2)) {
                return false;
            }
        }
        return true;
    }

    final TemporalAccessor s(y yVar, Set set) {
        x xVarD = d();
        xVarD.f19795c = g();
        ZoneId zoneIdD = xVarD.f19794b;
        if (zoneIdD == null) {
            zoneIdD = this.f19779a.d();
        }
        xVarD.f19794b = zoneIdD;
        xVarD.q(yVar, set);
        return xVarD;
    }

    public final String toString() {
        return d().toString();
    }
}
