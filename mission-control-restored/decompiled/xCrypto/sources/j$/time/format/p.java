package j$.time.format;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final C1558a f13237f = new C1558a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private p f13238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p f13239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList f13240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f13241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13242e;

    static {
        HashMap map = new HashMap();
        map.put('G', j$.time.temporal.a.ERA);
        map.put('y', j$.time.temporal.a.YEAR_OF_ERA);
        map.put('u', j$.time.temporal.a.YEAR);
        j$.time.temporal.r rVar = j$.time.temporal.j.f13310a;
        map.put('Q', rVar);
        map.put('q', rVar);
        j$.time.temporal.a aVar = j$.time.temporal.a.MONTH_OF_YEAR;
        map.put('M', aVar);
        map.put('L', aVar);
        map.put('D', j$.time.temporal.a.DAY_OF_YEAR);
        map.put('d', j$.time.temporal.a.DAY_OF_MONTH);
        map.put('F', j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        j$.time.temporal.a aVar2 = j$.time.temporal.a.DAY_OF_WEEK;
        map.put('E', aVar2);
        map.put('c', aVar2);
        map.put('e', aVar2);
        map.put('a', j$.time.temporal.a.AMPM_OF_DAY);
        map.put('H', j$.time.temporal.a.HOUR_OF_DAY);
        map.put('k', j$.time.temporal.a.CLOCK_HOUR_OF_DAY);
        map.put('K', j$.time.temporal.a.HOUR_OF_AMPM);
        map.put('h', j$.time.temporal.a.CLOCK_HOUR_OF_AMPM);
        map.put('m', j$.time.temporal.a.MINUTE_OF_HOUR);
        map.put('s', j$.time.temporal.a.SECOND_OF_MINUTE);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.NANO_OF_SECOND;
        map.put('S', aVar3);
        map.put('A', j$.time.temporal.a.MILLI_OF_DAY);
        map.put('n', aVar3);
        map.put('N', j$.time.temporal.a.NANO_OF_DAY);
        map.put('g', j$.time.temporal.l.f13317a);
    }

    public p() {
        this.f13238a = this;
        this.f13240c = new ArrayList();
        this.f13242e = -1;
        this.f13239b = null;
        this.f13241d = false;
    }

    private p(p pVar) {
        this.f13238a = this;
        this.f13240c = new ArrayList();
        this.f13242e = -1;
        this.f13239b = pVar;
        this.f13241d = true;
    }

    public final void q() {
        d(m.SENSITIVE);
    }

    public final void p() {
        d(m.INSENSITIVE);
    }

    public final void s() {
        d(m.STRICT);
    }

    public final void r() {
        d(m.LENIENT);
    }

    public final void k(j$.time.temporal.r rVar, int i4) {
        Objects.requireNonNull(rVar, "field");
        if (i4 < 1 || i4 > 19) {
            throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i4);
        }
        j(new i(rVar, i4, i4, z.NOT_NEGATIVE));
    }

    public final void l(j$.time.temporal.r rVar, int i4, int i5, z zVar) {
        if (i4 == i5 && zVar == z.NOT_NEGATIVE) {
            k(rVar, i5);
            return;
        }
        Objects.requireNonNull(rVar, "field");
        Objects.requireNonNull(zVar, "signStyle");
        if (i4 < 1 || i4 > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i4);
        }
        if (i5 < 1 || i5 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i5);
        }
        if (i5 < i4) {
            throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i5 + " < " + i4);
        }
        j(new i(rVar, i4, i5, zVar));
    }

    private void j(i iVar) {
        i iVarC;
        p pVar = this.f13238a;
        int i4 = pVar.f13242e;
        if (i4 >= 0) {
            i iVar2 = (i) pVar.f13240c.get(i4);
            int i5 = iVar.f13213b;
            int i6 = iVar.f13214c;
            if (i5 == i6 && iVar.f13215d == z.NOT_NEGATIVE) {
                iVarC = iVar2.d(i6);
                d(iVar.c());
                this.f13238a.f13242e = i4;
            } else {
                iVarC = iVar2.c();
                this.f13238a.f13242e = d(iVar);
            }
            this.f13238a.f13240c.set(i4, iVarC);
            return;
        }
        pVar.f13242e = d(iVar);
    }

    public final void b(j$.time.temporal.a aVar) {
        g gVar = new g(aVar, 0, 9, true, 0);
        Objects.requireNonNull(aVar, "field");
        if (aVar.C().g()) {
            d(gVar);
        } else {
            throw new IllegalArgumentException("Field must have a fixed set of values: " + aVar);
        }
    }

    public final void i(j$.time.temporal.a aVar, HashMap map) {
        Objects.requireNonNull(aVar, "field");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        A a4 = A.FULL;
        d(new o(aVar, a4, new b(new v(Collections.singletonMap(a4, linkedHashMap)))));
    }

    public final void c() {
        d(new h());
    }

    public final void h() {
        d(j.f13218e);
    }

    public final void g(String str, String str2) {
        d(new j(str, str2));
    }

    public final void m() {
        d(new n(f13237f, 1));
    }

    public final void e(char c4) {
        d(new d(c4));
    }

    public final void f(String str) {
        if (str.isEmpty()) {
            return;
        }
        if (str.length() == 1) {
            d(new d(str.charAt(0)));
        } else {
            d(new n(str, 0));
        }
    }

    public final void a(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        d(dateTimeFormatter.f());
    }

    public final void o() {
        p pVar = this.f13238a;
        pVar.f13242e = -1;
        this.f13238a = new p(pVar);
    }

    public final void n() {
        p pVar = this.f13238a;
        if (pVar.f13239b == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        if (pVar.f13240c.size() > 0) {
            p pVar2 = this.f13238a;
            e eVar = new e(pVar2.f13240c, pVar2.f13241d);
            this.f13238a = this.f13238a.f13239b;
            d(eVar);
            return;
        }
        this.f13238a = this.f13238a.f13239b;
    }

    private int d(f fVar) {
        Objects.requireNonNull(fVar, "pp");
        p pVar = this.f13238a;
        pVar.getClass();
        pVar.f13240c.add(fVar);
        this.f13238a.f13242e = -1;
        return r2.f13240c.size() - 1;
    }

    public final DateTimeFormatter t() {
        return v(Locale.getDefault(), y.SMART, null);
    }

    final DateTimeFormatter u(y yVar, j$.time.chrono.s sVar) {
        return v(Locale.getDefault(), yVar, sVar);
    }

    private DateTimeFormatter v(Locale locale, y yVar, j$.time.chrono.s sVar) {
        Objects.requireNonNull(locale, "locale");
        while (this.f13238a.f13239b != null) {
            n();
        }
        e eVar = new e(this.f13240c, false);
        w wVar = w.f13256a;
        return new DateTimeFormatter(eVar, locale, yVar, sVar);
    }
}
