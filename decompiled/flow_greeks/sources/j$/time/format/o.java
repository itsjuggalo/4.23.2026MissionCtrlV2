package j$.time.format;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j$.time.i f13666f = new j$.time.i(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f13667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f13668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f13669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f13670d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13671e;

    static {
        HashMap map = new HashMap();
        map.put('G', j$.time.temporal.a.ERA);
        map.put('y', j$.time.temporal.a.YEAR_OF_ERA);
        map.put('u', j$.time.temporal.a.YEAR);
        j$.time.temporal.h hVar = j$.time.temporal.j.f13743a;
        map.put('Q', hVar);
        map.put('q', hVar);
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
        map.put('g', j$.time.temporal.l.f13750a);
    }

    public o() {
        this.f13667a = this;
        this.f13669c = new ArrayList();
        this.f13671e = -1;
        this.f13668b = null;
        this.f13670d = false;
    }

    public o(o oVar) {
        this.f13667a = this;
        this.f13669c = new ArrayList();
        this.f13671e = -1;
        this.f13668b = oVar;
        this.f13670d = true;
    }

    public final void g(j$.time.temporal.q qVar, int i10) {
        Objects.requireNonNull(qVar, "field");
        if (i10 < 1 || i10 > 19) {
            throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i10);
        }
        f(new h(qVar, i10, i10, y.NOT_NEGATIVE));
    }

    public final void h(j$.time.temporal.q qVar, int i10, int i11, y yVar) {
        if (i10 == i11 && yVar == y.NOT_NEGATIVE) {
            g(qVar, i11);
            return;
        }
        Objects.requireNonNull(qVar, "field");
        Objects.requireNonNull(yVar, "signStyle");
        if (i10 < 1 || i10 > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i10);
        }
        if (i11 < 1 || i11 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i11);
        }
        if (i11 < i10) {
            throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i11 + " < " + i10);
        }
        f(new h(qVar, i10, i11, yVar));
    }

    public final void f(h hVar) {
        h hVarB;
        o oVar = this.f13667a;
        int i10 = oVar.f13671e;
        if (i10 < 0) {
            oVar.f13671e = b(hVar);
            return;
        }
        h hVar2 = (h) ((ArrayList) oVar.f13669c).get(i10);
        int i11 = hVar.f13645b;
        int i12 = hVar.f13646c;
        if (i11 == i12 && hVar.f13647d == y.NOT_NEGATIVE) {
            hVarB = hVar2.c(i12);
            b(hVar.b());
            this.f13667a.f13671e = i10;
        } else {
            hVarB = hVar2.b();
            this.f13667a.f13671e = b(hVar);
        }
        ((ArrayList) this.f13667a.f13669c).set(i10, hVarB);
    }

    public final void e(j$.time.temporal.a aVar, Map map) {
        Objects.requireNonNull(aVar, "field");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        z zVar = z.FULL;
        b(new n(aVar, zVar, new a(new u(Collections.singletonMap(zVar, linkedHashMap)))));
    }

    public final void c(char c10) {
        b(new c(c10));
    }

    public final void d(String str) {
        if (str.isEmpty()) {
            return;
        }
        if (str.length() == 1) {
            b(new c(str.charAt(0)));
        } else {
            b(new m(str));
        }
    }

    public final void a(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        d dVar = dateTimeFormatter.f13628a;
        if (dVar.f13638b) {
            dVar = new d(dVar.f13637a, false);
        }
        b(dVar);
    }

    public final void j() {
        o oVar = this.f13667a;
        oVar.f13671e = -1;
        this.f13667a = new o(oVar);
    }

    public final void i() {
        o oVar = this.f13667a;
        if (oVar.f13668b == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        if (((ArrayList) oVar.f13669c).size() > 0) {
            o oVar2 = this.f13667a;
            d dVar = new d(oVar2.f13669c, oVar2.f13670d);
            this.f13667a = this.f13667a.f13668b;
            b(dVar);
            return;
        }
        this.f13667a = this.f13667a.f13668b;
    }

    public final int b(e eVar) {
        Objects.requireNonNull(eVar, "pp");
        o oVar = this.f13667a;
        oVar.getClass();
        ((ArrayList) oVar.f13669c).add(eVar);
        this.f13667a.f13671e = -1;
        return ((ArrayList) r2.f13669c).size() - 1;
    }

    public final DateTimeFormatter k(x xVar, j$.time.chrono.l lVar) {
        return l(Locale.getDefault(), xVar, lVar);
    }

    public final DateTimeFormatter l(Locale locale, x xVar, j$.time.chrono.l lVar) {
        Objects.requireNonNull(locale, "locale");
        while (this.f13667a.f13668b != null) {
            i();
        }
        d dVar = new d(this.f13669c, false);
        v vVar = v.f13685a;
        return new DateTimeFormatter(dVar, locale, xVar, lVar);
    }
}
