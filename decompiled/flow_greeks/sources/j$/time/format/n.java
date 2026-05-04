package j$.time.format;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j$.time.temporal.q f13662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f13663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f13664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile h f13665d;

    public n(j$.time.temporal.q qVar, z zVar, a aVar) {
        this.f13662a = qVar;
        this.f13663b = zVar;
        this.f13664c = aVar;
    }

    @Override // j$.time.format.e
    public final boolean s(s sVar, StringBuilder sb2) {
        String strA;
        Long lA = sVar.a(this.f13662a);
        DateTimeFormatter dateTimeFormatter = sVar.f13681b;
        if (lA == null) {
            return false;
        }
        j$.time.chrono.l lVar = (j$.time.chrono.l) sVar.f13680a.b(j$.time.temporal.r.f13754b);
        if (lVar == null || lVar == j$.time.chrono.s.f13607c) {
            a aVar = this.f13664c;
            long jLongValue = lA.longValue();
            z zVar = this.f13663b;
            Locale locale = dateTimeFormatter.f13629b;
            strA = aVar.f13634a.a(jLongValue, zVar);
        } else {
            a aVar2 = this.f13664c;
            long jLongValue2 = lA.longValue();
            z zVar2 = this.f13663b;
            Locale locale2 = dateTimeFormatter.f13629b;
            strA = aVar2.f13634a.a(jLongValue2, zVar2);
        }
        if (strA != null) {
            sb2.append(strA);
            return true;
        }
        if (this.f13665d == null) {
            this.f13665d = new h(this.f13662a, 1, 19, y.NORMAL);
        }
        return this.f13665d.s(sVar, sb2);
    }

    @Override // j$.time.format.e
    public final int A(p pVar, CharSequence charSequence, int i10) {
        a aVar = this.f13664c;
        j$.time.temporal.q qVar = this.f13662a;
        int length = charSequence.length();
        if (i10 >= 0 && i10 <= length) {
            boolean z10 = pVar.f13674c;
            DateTimeFormatter dateTimeFormatter = pVar.f13672a;
            Iterator it = null;
            z zVar = z10 ? this.f13663b : null;
            j$.time.chrono.l lVar = pVar.c().f13688c;
            if (lVar == null && (lVar = pVar.f13672a.f13632e) == null) {
                lVar = j$.time.chrono.s.f13607c;
            }
            if (lVar == null || lVar == j$.time.chrono.s.f13607c) {
                Locale locale = dateTimeFormatter.f13629b;
                List list = (List) ((HashMap) aVar.f13634a.f13684b).get(zVar);
                it = list != null ? list.iterator() : null;
            } else {
                Locale locale2 = dateTimeFormatter.f13629b;
                List list2 = (List) ((HashMap) aVar.f13634a.f13684b).get(zVar);
                if (list2 != null) {
                    it = list2.iterator();
                }
            }
            Iterator it2 = it;
            if (it2 != null) {
                while (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    String str = (String) entry.getKey();
                    if (pVar.g(str, 0, charSequence, i10, str.length())) {
                        return pVar.f(this.f13662a, ((Long) entry.getValue()).longValue(), i10, str.length() + i10);
                    }
                }
                if (qVar == j$.time.temporal.a.ERA && !pVar.f13674c) {
                    Iterator it3 = lVar.z().iterator();
                    while (it3.hasNext()) {
                        String string = ((j$.time.chrono.m) it3.next()).toString();
                        if (pVar.g(string, 0, charSequence, i10, string.length())) {
                            return pVar.f(this.f13662a, r7.getValue(), i10, string.length() + i10);
                        }
                    }
                }
                if (pVar.f13674c) {
                    return ~i10;
                }
            }
            if (this.f13665d == null) {
                this.f13665d = new h(this.f13662a, 1, 19, y.NORMAL);
            }
            return this.f13665d.A(pVar, charSequence, i10);
        }
        throw new IndexOutOfBoundsException();
    }

    public final String toString() {
        z zVar = z.FULL;
        j$.time.temporal.q qVar = this.f13662a;
        z zVar2 = this.f13663b;
        if (zVar2 == zVar) {
            return "Text(" + qVar + ")";
        }
        return "Text(" + qVar + com.amazon.a.a.o.b.f.f4598a + zVar2 + ")";
    }
}
