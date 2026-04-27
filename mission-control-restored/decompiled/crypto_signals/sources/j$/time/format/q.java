package j$.time.format;

import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DateTimeFormatter f7482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7483b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7484c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayList f7485d;

    q(DateTimeFormatter dateTimeFormatter) {
        ArrayList arrayList = new ArrayList();
        this.f7485d = arrayList;
        this.f7482a = dateTimeFormatter;
        arrayList.add(new x());
    }

    final q c() {
        q qVar = new q(this.f7482a);
        qVar.f7483b = this.f7483b;
        qVar.f7484c = this.f7484c;
        return qVar;
    }

    final Locale h() {
        return this.f7482a.c();
    }

    final w f() {
        return this.f7482a.b();
    }

    final j$.time.chrono.l g() {
        j$.time.chrono.l lVar = d().f7498c;
        if (lVar != null) {
            return lVar;
        }
        j$.time.chrono.l lVarA = this.f7482a.a();
        return lVarA == null ? j$.time.chrono.s.f7422d : lVarA;
    }

    final boolean a(char c6, char c7) {
        if (this.f7483b) {
            return c6 == c7;
        }
        return b(c6, c7);
    }

    final boolean j() {
        return this.f7483b;
    }

    final void l(boolean z6) {
        this.f7483b = z6;
    }

    final boolean r(CharSequence charSequence, int i, CharSequence charSequence2, int i6, int i7) {
        if (i + i7 <= charSequence.length() && i6 + i7 <= charSequence2.length()) {
            if (this.f7483b) {
                for (int i8 = 0; i8 < i7; i8++) {
                    if (charSequence.charAt(i + i8) == charSequence2.charAt(i6 + i8)) {
                    }
                }
                return true;
            }
            for (int i9 = 0; i9 < i7; i9++) {
                char cCharAt = charSequence.charAt(i + i9);
                char cCharAt2 = charSequence2.charAt(i6 + i9);
                if (cCharAt == cCharAt2 || Character.toUpperCase(cCharAt) == Character.toUpperCase(cCharAt2) || Character.toLowerCase(cCharAt) == Character.toLowerCase(cCharAt2)) {
                }
            }
            return true;
        }
        return false;
    }

    static boolean b(char c6, char c7) {
        return c6 == c7 || Character.toUpperCase(c6) == Character.toUpperCase(c7) || Character.toLowerCase(c6) == Character.toLowerCase(c7);
    }

    final boolean k() {
        return this.f7484c;
    }

    final void p(boolean z6) {
        this.f7484c = z6;
    }

    final void q() {
        ArrayList arrayList = this.f7485d;
        x xVarD = d();
        xVarD.getClass();
        x xVar = new x();
        xVar.f7496a.putAll(xVarD.f7496a);
        xVar.f7497b = xVarD.f7497b;
        xVar.f7498c = xVarD.f7498c;
        xVar.f7499d = xVarD.f7499d;
        arrayList.add(xVar);
    }

    final void e(boolean z6) {
        ArrayList arrayList = this.f7485d;
        if (z6) {
            arrayList.remove(arrayList.size() - 2);
        } else {
            arrayList.remove(arrayList.size() - 1);
        }
    }

    private x d() {
        return (x) this.f7485d.get(r0.size() - 1);
    }

    final TemporalAccessor s(y yVar) {
        x xVarD = d();
        xVarD.f7498c = g();
        ZoneId zoneId = xVarD.f7497b;
        if (zoneId == null) {
            this.f7482a.getClass();
            zoneId = null;
        }
        xVarD.f7497b = zoneId;
        xVarD.r(yVar);
        return xVarD;
    }

    final Long i(j$.time.temporal.a aVar) {
        return (Long) d().f7496a.get(aVar);
    }

    final int n(j$.time.temporal.r rVar, long j4, int i, int i6) {
        Objects.requireNonNull(rVar, "field");
        Long l6 = (Long) d().f7496a.put(rVar, Long.valueOf(j4));
        return (l6 == null || l6.longValue() == j4) ? i6 : ~i;
    }

    final void m(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        d().f7497b = zoneId;
    }

    final void o() {
        d().f7499d = true;
    }

    public final String toString() {
        return d().toString();
    }
}
