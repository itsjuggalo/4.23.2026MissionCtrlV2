package j$.time.format;

import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DateTimeFormatter f13243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f13244b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13245c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayList f13246d;

    q(DateTimeFormatter dateTimeFormatter) {
        ArrayList arrayList = new ArrayList();
        this.f13246d = arrayList;
        this.f13243a = dateTimeFormatter;
        arrayList.add(new x());
    }

    final q c() {
        q qVar = new q(this.f13243a);
        qVar.f13244b = this.f13244b;
        qVar.f13245c = this.f13245c;
        return qVar;
    }

    final Locale h() {
        return this.f13243a.c();
    }

    final w f() {
        return this.f13243a.b();
    }

    final j$.time.chrono.l g() {
        j$.time.chrono.l lVar = d().f13259c;
        if (lVar != null) {
            return lVar;
        }
        j$.time.chrono.l lVarA = this.f13243a.a();
        return lVarA == null ? j$.time.chrono.s.f13177d : lVarA;
    }

    final boolean a(char c4, char c5) {
        if (this.f13244b) {
            return c4 == c5;
        }
        return b(c4, c5);
    }

    final boolean j() {
        return this.f13244b;
    }

    final void l(boolean z4) {
        this.f13244b = z4;
    }

    final boolean r(CharSequence charSequence, int i4, CharSequence charSequence2, int i5, int i6) {
        if (i4 + i6 <= charSequence.length() && i5 + i6 <= charSequence2.length()) {
            if (this.f13244b) {
                for (int i7 = 0; i7 < i6; i7++) {
                    if (charSequence.charAt(i4 + i7) == charSequence2.charAt(i5 + i7)) {
                    }
                }
                return true;
            }
            for (int i8 = 0; i8 < i6; i8++) {
                char cCharAt = charSequence.charAt(i4 + i8);
                char cCharAt2 = charSequence2.charAt(i5 + i8);
                if (cCharAt == cCharAt2 || Character.toUpperCase(cCharAt) == Character.toUpperCase(cCharAt2) || Character.toLowerCase(cCharAt) == Character.toLowerCase(cCharAt2)) {
                }
            }
            return true;
        }
        return false;
    }

    static boolean b(char c4, char c5) {
        return c4 == c5 || Character.toUpperCase(c4) == Character.toUpperCase(c5) || Character.toLowerCase(c4) == Character.toLowerCase(c5);
    }

    final boolean k() {
        return this.f13245c;
    }

    final void p(boolean z4) {
        this.f13245c = z4;
    }

    final void q() {
        ArrayList arrayList = this.f13246d;
        x xVarD = d();
        xVarD.getClass();
        x xVar = new x();
        xVar.f13257a.putAll(xVarD.f13257a);
        xVar.f13258b = xVarD.f13258b;
        xVar.f13259c = xVarD.f13259c;
        xVar.f13260d = xVarD.f13260d;
        arrayList.add(xVar);
    }

    final void e(boolean z4) {
        ArrayList arrayList = this.f13246d;
        if (z4) {
            arrayList.remove(arrayList.size() - 2);
        } else {
            arrayList.remove(arrayList.size() - 1);
        }
    }

    private x d() {
        return (x) this.f13246d.get(r0.size() - 1);
    }

    final TemporalAccessor s(y yVar) {
        x xVarD = d();
        xVarD.f13259c = g();
        ZoneId zoneId = xVarD.f13258b;
        if (zoneId == null) {
            this.f13243a.getClass();
            zoneId = null;
        }
        xVarD.f13258b = zoneId;
        xVarD.r(yVar);
        return xVarD;
    }

    final Long i(j$.time.temporal.a aVar) {
        return (Long) d().f13257a.get(aVar);
    }

    final int n(j$.time.temporal.r rVar, long j4, int i4, int i5) {
        Objects.requireNonNull(rVar, "field");
        Long l4 = (Long) d().f13257a.put(rVar, Long.valueOf(j4));
        return (l4 == null || l4.longValue() == j4) ? i5 : ~i4;
    }

    final void m(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        d().f13258b = zoneId;
    }

    final void o() {
        d().f13260d = true;
    }

    public final String toString() {
        return d().toString();
    }
}
