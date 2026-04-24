package j$.time.format;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import java.text.ParsePosition;
import java.util.AbstractMap;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class n implements f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile AbstractMap.SimpleImmutableEntry f13229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile AbstractMap.SimpleImmutableEntry f13230d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f13232b;

    public /* synthetic */ n(Object obj, int i4) {
        this.f13231a = i4;
        this.f13232b = obj;
    }

    @Override // j$.time.format.f
    public final boolean p(t tVar, StringBuilder sb) {
        switch (this.f13231a) {
            case 0:
                sb.append((String) this.f13232b);
                break;
            default:
                ZoneId zoneId = (ZoneId) tVar.f((C1558a) this.f13232b);
                if (zoneId != null) {
                    sb.append(zoneId.s());
                    break;
                }
                break;
        }
        return true;
    }

    @Override // j$.time.format.f
    public final int r(q qVar, CharSequence charSequence, int i4) {
        int i5;
        switch (this.f13231a) {
            case 0:
                if (i4 > charSequence.length() || i4 < 0) {
                    throw new IndexOutOfBoundsException();
                }
                String str = (String) this.f13232b;
                return !qVar.r(charSequence, i4, str, 0, str.length()) ? ~i4 : str.length() + i4;
            default:
                int length = charSequence.length();
                if (i4 > length) {
                    throw new IndexOutOfBoundsException();
                }
                if (i4 != length) {
                    char cCharAt = charSequence.charAt(i4);
                    if (cCharAt != '+' && cCharAt != '-') {
                        int i6 = i4 + 2;
                        if (length >= i6) {
                            char cCharAt2 = charSequence.charAt(i4 + 1);
                            if (qVar.a(cCharAt, 'U') && qVar.a(cCharAt2, 'T')) {
                                int i7 = i4 + 3;
                                if (length >= i7 && qVar.a(charSequence.charAt(i6), 'C')) {
                                    return a(qVar, charSequence, i4, i7, j.f13219f);
                                }
                                return a(qVar, charSequence, i4, i6, j.f13219f);
                            }
                            if (qVar.a(cCharAt, 'G') && length >= (i5 = i4 + 3) && qVar.a(cCharAt2, 'M') && qVar.a(charSequence.charAt(i6), 'T')) {
                                int i8 = i4 + 4;
                                if (length >= i8 && qVar.a(charSequence.charAt(i5), '0')) {
                                    qVar.m(ZoneId.of("GMT0"));
                                    return i8;
                                }
                                return a(qVar, charSequence, i4, i5, j.f13219f);
                            }
                        }
                        Set setA = j$.time.zone.j.a();
                        int size = setA.size();
                        AbstractMap.SimpleImmutableEntry simpleImmutableEntry = qVar.j() ? f13229c : f13230d;
                        if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
                            synchronized (this) {
                                try {
                                    simpleImmutableEntry = qVar.j() ? f13229c : f13230d;
                                    if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
                                        simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(Integer.valueOf(size), l.e(setA, qVar));
                                        if (qVar.j()) {
                                            f13229c = simpleImmutableEntry;
                                        } else {
                                            f13230d = simpleImmutableEntry;
                                        }
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                        l lVar = (l) simpleImmutableEntry.getValue();
                        ParsePosition parsePosition = new ParsePosition(i4);
                        String strC = lVar.c(charSequence, parsePosition);
                        if (strC == null) {
                            if (qVar.a(cCharAt, 'Z')) {
                                qVar.m(ZoneOffset.UTC);
                                return i4 + 1;
                            }
                        } else {
                            qVar.m(ZoneId.of(strC));
                            return parsePosition.getIndex();
                        }
                    } else {
                        return a(qVar, charSequence, i4, i4, j.f13218e);
                    }
                    break;
                }
                return ~i4;
        }
    }

    private static int a(q qVar, CharSequence charSequence, int i4, int i5, j jVar) {
        String upperCase = charSequence.subSequence(i4, i5).toString().toUpperCase();
        if (i5 >= charSequence.length()) {
            qVar.m(ZoneId.of(upperCase));
            return i5;
        }
        if (charSequence.charAt(i5) == '0' || qVar.a(charSequence.charAt(i5), 'Z')) {
            qVar.m(ZoneId.of(upperCase));
            return i5;
        }
        q qVarC = qVar.c();
        int iR = jVar.r(qVarC, charSequence, i5);
        try {
            if (iR < 0) {
                if (jVar == j.f13218e) {
                    return ~i4;
                }
                qVar.m(ZoneId.of(upperCase));
                return i5;
            }
            qVar.m(ZoneId.J(upperCase, ZoneOffset.c0((int) qVarC.i(j$.time.temporal.a.OFFSET_SECONDS).longValue())));
            return iR;
        } catch (j$.time.c unused) {
            return ~i4;
        }
    }

    public final String toString() {
        switch (this.f13231a) {
            case 0:
                return "'" + ((String) this.f13232b).replace("'", "''") + "'";
            default:
                return "ZoneRegionId()";
        }
    }
}
