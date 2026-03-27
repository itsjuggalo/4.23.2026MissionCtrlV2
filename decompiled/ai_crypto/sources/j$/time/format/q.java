package j$.time.format;

import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DateTimeFormatter f17202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f17203b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f17204c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayList f17205d;

    q(DateTimeFormatter dateTimeFormatter) {
        ArrayList arrayList = new ArrayList();
        this.f17205d = arrayList;
        this.f17202a = dateTimeFormatter;
        arrayList.add(new x());
    }

    final q c() {
        q qVar = new q(this.f17202a);
        qVar.f17203b = this.f17203b;
        qVar.f17204c = this.f17204c;
        return qVar;
    }

    final Locale h() {
        return this.f17202a.c();
    }

    final w f() {
        return this.f17202a.b();
    }

    final j$.time.chrono.l g() {
        j$.time.chrono.l lVar = d().f17218c;
        if (lVar != null) {
            return lVar;
        }
        j$.time.chrono.l lVarA = this.f17202a.a();
        return lVarA == null ? j$.time.chrono.s.f17138d : lVarA;
    }

    final boolean a(char c7, char c8) {
        if (this.f17203b) {
            return c7 == c8;
        }
        return b(c7, c8);
    }

    final boolean j() {
        return this.f17203b;
    }

    final void l(boolean z7) {
        this.f17203b = z7;
    }

    final boolean r(CharSequence charSequence, int i7, CharSequence charSequence2, int i8, int i9) {
        if (i7 + i9 > charSequence.length() || i8 + i9 > charSequence2.length()) {
            return false;
        }
        if (this.f17203b) {
            for (int i10 = 0; i10 < i9; i10++) {
                if (charSequence.charAt(i7 + i10) != charSequence2.charAt(i8 + i10)) {
                    return false;
                }
            }
            return true;
        }
        for (int i11 = 0; i11 < i9; i11++) {
            char cCharAt = charSequence.charAt(i7 + i11);
            char cCharAt2 = charSequence2.charAt(i8 + i11);
            if (cCharAt != cCharAt2 && Character.toUpperCase(cCharAt) != Character.toUpperCase(cCharAt2) && Character.toLowerCase(cCharAt) != Character.toLowerCase(cCharAt2)) {
                return false;
            }
        }
        return true;
    }

    static boolean b(char c7, char c8) {
        return c7 == c8 || Character.toUpperCase(c7) == Character.toUpperCase(c8) || Character.toLowerCase(c7) == Character.toLowerCase(c8);
    }

    final boolean k() {
        return this.f17204c;
    }

    final void p(boolean z7) {
        this.f17204c = z7;
    }

    final void q() {
        ArrayList arrayList = this.f17205d;
        x xVarD = d();
        xVarD.getClass();
        x xVar = new x();
        xVar.f17216a.putAll(xVarD.f17216a);
        xVar.f17217b = xVarD.f17217b;
        xVar.f17218c = xVarD.f17218c;
        xVar.f17219d = xVarD.f17219d;
        arrayList.add(xVar);
    }

    final void e(boolean z7) {
        ArrayList arrayList = this.f17205d;
        if (z7) {
            arrayList.remove(arrayList.size() - 2);
        } else {
            arrayList.remove(arrayList.size() - 1);
        }
    }

    private x d() {
        return (x) this.f17205d.get(r0.size() - 1);
    }

    final TemporalAccessor s(y yVar) {
        x xVarD = d();
        xVarD.f17218c = g();
        ZoneId zoneId = xVarD.f17217b;
        if (zoneId == null) {
            this.f17202a.getClass();
            zoneId = null;
        }
        xVarD.f17217b = zoneId;
        xVarD.r(yVar);
        return xVarD;
    }

    final Long i(j$.time.temporal.a aVar) {
        return (Long) d().f17216a.get(aVar);
    }

    final int n(j$.time.temporal.r rVar, long j7, int i7, int i8) {
        Objects.requireNonNull(rVar, "field");
        Long l7 = (Long) d().f17216a.put(rVar, Long.valueOf(j7));
        return (l7 == null || l7.longValue() == j7) ? i8 : ~i7;
    }

    final void m(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        d().f17217b = zoneId;
    }

    final void o() {
        d().f17219d = true;
    }

    public final String toString() {
        return d().toString();
    }
}
