package j$.time.format;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class o implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j$.time.temporal.a f13233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final A f13234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f13235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile i f13236d;

    o(j$.time.temporal.a aVar, A a4, b bVar) {
        this.f13233a = aVar;
        this.f13234b = a4;
        this.f13235c = bVar;
    }

    @Override // j$.time.format.f
    public final boolean p(t tVar, StringBuilder sb) {
        String strA;
        Long lE = tVar.e(this.f13233a);
        if (lE == null) {
            return false;
        }
        j$.time.chrono.l lVar = (j$.time.chrono.l) tVar.d().a(j$.time.temporal.s.a());
        if (lVar == null || lVar == j$.time.chrono.s.f13177d) {
            long jLongValue = lE.longValue();
            A a4 = this.f13234b;
            tVar.c();
            strA = this.f13235c.f13205a.a(jLongValue, a4);
        } else {
            long jLongValue2 = lE.longValue();
            A a5 = this.f13234b;
            tVar.c();
            strA = this.f13235c.f13205a.a(jLongValue2, a5);
        }
        if (strA != null) {
            sb.append(strA);
            return true;
        }
        if (this.f13236d == null) {
            this.f13236d = new i(this.f13233a, 1, 19, z.NORMAL);
        }
        return this.f13236d.p(tVar, sb);
    }

    @Override // j$.time.format.f
    public final int r(q qVar, CharSequence charSequence, int i4) {
        Iterator itB;
        int length = charSequence.length();
        if (i4 < 0 || i4 > length) {
            throw new IndexOutOfBoundsException();
        }
        A a4 = qVar.k() ? this.f13234b : null;
        j$.time.chrono.l lVarG = qVar.g();
        b bVar = this.f13235c;
        j$.time.temporal.a aVar = this.f13233a;
        if (lVarG == null || lVarG == j$.time.chrono.s.f13177d) {
            qVar.h();
            itB = bVar.f13205a.b(a4);
        } else {
            qVar.h();
            itB = bVar.f13205a.b(a4);
        }
        Iterator it = itB;
        if (it != null) {
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                if (qVar.r(str, 0, charSequence, i4, str.length())) {
                    return qVar.n(this.f13233a, ((Long) entry.getValue()).longValue(), i4, str.length() + i4);
                }
            }
            if (aVar == j$.time.temporal.a.ERA && !qVar.k()) {
                Iterator it2 = lVarG.D().iterator();
                while (it2.hasNext()) {
                    String string = ((j$.time.chrono.m) it2.next()).toString();
                    if (qVar.r(string, 0, charSequence, i4, string.length())) {
                        return qVar.n(this.f13233a, r7.p(), i4, string.length() + i4);
                    }
                }
            }
            if (qVar.k()) {
                return ~i4;
            }
        }
        if (this.f13236d == null) {
            this.f13236d = new i(this.f13233a, 1, 19, z.NORMAL);
        }
        return this.f13236d.r(qVar, charSequence, i4);
    }

    public final String toString() {
        A a4 = A.FULL;
        j$.time.temporal.a aVar = this.f13233a;
        A a5 = this.f13234b;
        if (a5 == a4) {
            return "Text(" + aVar + ")";
        }
        return "Text(" + aVar + com.amazon.a.a.o.b.f.f8804a + a5 + ")";
    }
}
