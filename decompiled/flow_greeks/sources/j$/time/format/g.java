package j$.time.format;

import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.temporal.TemporalAccessor;
import java.text.ParsePosition;
import java.util.AbstractMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Map.Entry f13640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Map.Entry f13641c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13642a;

    public /* synthetic */ g(int i10) {
        this.f13642a = i10;
    }

    @Override // j$.time.format.e
    public final boolean s(s sVar, StringBuilder sb2) {
        switch (this.f13642a) {
            case 0:
                Long lA = sVar.a(j$.time.temporal.a.INSTANT_SECONDS);
                TemporalAccessor temporalAccessor = sVar.f13680a;
                j$.time.temporal.a aVar = j$.time.temporal.a.NANO_OF_SECOND;
                Long lValueOf = temporalAccessor.h(aVar) ? Long.valueOf(temporalAccessor.i(aVar)) : null;
                int i10 = 0;
                if (lA == null) {
                    return false;
                }
                long jLongValue = lA.longValue();
                int iA = aVar.f13735b.a(lValueOf != null ? lValueOf.longValue() : 0L, aVar);
                if (jLongValue >= -62167219200L) {
                    long j10 = jLongValue - 253402300800L;
                    long jFloorDiv = Math.floorDiv(j10, 315569520000L) + 1;
                    LocalDateTime localDateTimeP = LocalDateTime.P(Math.floorMod(j10, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
                    if (jFloorDiv > 0) {
                        sb2.append('+');
                        sb2.append(jFloorDiv);
                    }
                    sb2.append(localDateTimeP);
                    if (localDateTimeP.f13547b.f13714c == 0) {
                        sb2.append(":00");
                    }
                } else {
                    long j11 = jLongValue + 62167219200L;
                    long j12 = j11 / 315569520000L;
                    long j13 = j11 % 315569520000L;
                    LocalDateTime localDateTimeP2 = LocalDateTime.P(j13 - 62167219200L, 0, ZoneOffset.UTC);
                    int length = sb2.length();
                    sb2.append(localDateTimeP2);
                    if (localDateTimeP2.f13547b.f13714c == 0) {
                        sb2.append(":00");
                    }
                    if (j12 < 0) {
                        if (localDateTimeP2.f13546a.f13701a == -10000) {
                            sb2.replace(length, length + 2, Long.toString(j12 - 1));
                        } else if (j13 == 0) {
                            sb2.insert(length, j12);
                        } else {
                            sb2.insert(length + 1, Math.abs(j12));
                        }
                    }
                }
                if (iA > 0) {
                    sb2.append(com.amazon.a.a.o.c.a.b.f4610a);
                    int i11 = 100000000;
                    while (true) {
                        if (iA > 0 || i10 % 3 != 0 || i10 < -2) {
                            int i12 = iA / i11;
                            sb2.append((char) (i12 + 48));
                            iA -= i12 * i11;
                            i11 /= 10;
                            i10++;
                        }
                    }
                }
                sb2.append('Z');
                return true;
            default:
                j$.time.i iVar = o.f13666f;
                TemporalAccessor temporalAccessor2 = sVar.f13680a;
                Object objB = temporalAccessor2.b(iVar);
                if (objB == null && sVar.f13682c == 0) {
                    throw new j$.time.c("Unable to extract " + iVar + " from temporal " + temporalAccessor2);
                }
                ZoneId zoneId = (ZoneId) objB;
                if (zoneId == null) {
                    return false;
                }
                sb2.append(zoneId.q());
                return true;
        }
    }

    @Override // j$.time.format.e
    public final int A(p pVar, CharSequence charSequence, int i10) {
        int i11;
        int i12 = 1;
        switch (this.f13642a) {
            case 0:
                o oVar = new o();
                oVar.a(DateTimeFormatter.ISO_LOCAL_DATE);
                oVar.c('T');
                j$.time.temporal.a aVar = j$.time.temporal.a.HOUR_OF_DAY;
                oVar.g(aVar, 2);
                oVar.c(':');
                j$.time.temporal.a aVar2 = j$.time.temporal.a.MINUTE_OF_HOUR;
                oVar.g(aVar2, 2);
                oVar.c(':');
                j$.time.temporal.a aVar3 = j$.time.temporal.a.SECOND_OF_MINUTE;
                oVar.g(aVar3, 2);
                j$.time.temporal.a aVar4 = j$.time.temporal.a.NANO_OF_SECOND;
                oVar.b(new f(aVar4));
                oVar.c('Z');
                d dVar = oVar.l(Locale.getDefault(), x.SMART, null).f13628a;
                if (dVar.f13638b) {
                    dVar = new d(dVar.f13637a, false);
                }
                p pVar2 = new p(pVar.f13672a);
                pVar2.f13673b = pVar.f13673b;
                pVar2.f13674c = pVar.f13674c;
                int iA = dVar.A(pVar2, charSequence, i10);
                if (iA < 0) {
                    return iA;
                }
                long jLongValue = pVar2.d(j$.time.temporal.a.YEAR).longValue();
                int iIntValue = pVar2.d(j$.time.temporal.a.MONTH_OF_YEAR).intValue();
                int iIntValue2 = pVar2.d(j$.time.temporal.a.DAY_OF_MONTH).intValue();
                int iIntValue3 = pVar2.d(aVar).intValue();
                int iIntValue4 = pVar2.d(aVar2).intValue();
                Long lD = pVar2.d(aVar3);
                Long lD2 = pVar2.d(aVar4);
                int iIntValue5 = lD != null ? lD.intValue() : 0;
                int iIntValue6 = lD2 != null ? lD2.intValue() : 0;
                if (iIntValue3 == 24 && iIntValue4 == 0 && iIntValue5 == 0 && iIntValue6 == 0) {
                    iIntValue3 = 0;
                } else if (iIntValue3 == 23 && iIntValue4 == 59 && iIntValue5 == 60) {
                    pVar.c().f13689d = true;
                    i12 = 0;
                    iIntValue5 = 59;
                } else {
                    i12 = 0;
                }
                int i13 = ((int) jLongValue) % 10000;
                try {
                    LocalDateTime localDateTime = LocalDateTime.f13544c;
                    return pVar.f(aVar4, iIntValue6, i10, pVar.f(j$.time.temporal.a.INSTANT_SECONDS, new LocalDateTime(j$.time.h.b0(i13, iIntValue, iIntValue2), j$.time.l.P(iIntValue3, iIntValue4, iIntValue5, 0)).plusDays(i12).w(ZoneOffset.UTC) + Math.multiplyExact(jLongValue / 10000, 315569520000L), i10, iA));
                } catch (RuntimeException unused) {
                    return ~i10;
                }
            default:
                int length = charSequence.length();
                if (i10 > length) {
                    throw new IndexOutOfBoundsException();
                }
                if (i10 != length) {
                    char cCharAt = charSequence.charAt(i10);
                    if (cCharAt == '+' || cCharAt == '-') {
                        return a(pVar, charSequence, i10, i10, i.f13650e);
                    }
                    int i14 = i10 + 2;
                    if (length >= i14) {
                        char cCharAt2 = charSequence.charAt(i10 + 1);
                        if (pVar.a(cCharAt, 'U') && pVar.a(cCharAt2, 'T')) {
                            int i15 = i10 + 3;
                            return (length < i15 || !pVar.a(charSequence.charAt(i14), 'C')) ? a(pVar, charSequence, i10, i14, i.f13651f) : a(pVar, charSequence, i10, i15, i.f13651f);
                        }
                        if (pVar.a(cCharAt, 'G') && length >= (i11 = i10 + 3) && pVar.a(cCharAt2, 'M') && pVar.a(charSequence.charAt(i14), 'T')) {
                            int i16 = i10 + 4;
                            if (length < i16 || !pVar.a(charSequence.charAt(i11), '0')) {
                                return a(pVar, charSequence, i10, i11, i.f13651f);
                            }
                            pVar.e(ZoneId.of("GMT0"));
                            return i16;
                        }
                    }
                    Set<String> set = j$.time.zone.i.f13810d;
                    int size = set.size();
                    Map.Entry simpleImmutableEntry = pVar.f13673b ? f13640b : f13641c;
                    if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
                        synchronized (this) {
                            try {
                                simpleImmutableEntry = pVar.f13673b ? f13640b : f13641c;
                                if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
                                    Integer numValueOf = Integer.valueOf(size);
                                    k kVar = pVar.f13673b ? new k("", null, null) : new j("", null, null);
                                    for (String str : set) {
                                        kVar.a(str, str);
                                    }
                                    simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(numValueOf, kVar);
                                    if (pVar.f13673b) {
                                        f13640b = simpleImmutableEntry;
                                    } else {
                                        f13641c = simpleImmutableEntry;
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    k kVar2 = (k) simpleImmutableEntry.getValue();
                    ParsePosition parsePosition = new ParsePosition(i10);
                    String strC = kVar2.c(charSequence, parsePosition);
                    if (strC != null) {
                        pVar.e(ZoneId.of(strC));
                        return parsePosition.getIndex();
                    }
                    if (pVar.a(cCharAt, 'Z')) {
                        pVar.e(ZoneOffset.UTC);
                        return i10 + 1;
                    }
                    break;
                }
                return ~i10;
        }
    }

    public static int a(p pVar, CharSequence charSequence, int i10, int i11, i iVar) {
        String upperCase = charSequence.subSequence(i10, i11).toString().toUpperCase();
        if (i11 >= charSequence.length()) {
            pVar.e(ZoneId.of(upperCase));
            return i11;
        }
        if (charSequence.charAt(i11) != '0' && !pVar.a(charSequence.charAt(i11), 'Z')) {
            p pVar2 = new p(pVar.f13672a);
            pVar2.f13673b = pVar.f13673b;
            pVar2.f13674c = pVar.f13674c;
            int iA = iVar.A(pVar2, charSequence, i11);
            try {
                if (iA < 0) {
                    if (iVar == i.f13650e) {
                        return ~i10;
                    }
                    pVar.e(ZoneId.of(upperCase));
                    return i11;
                }
                pVar.e(ZoneId.F(upperCase, ZoneOffset.Y((int) pVar2.d(j$.time.temporal.a.OFFSET_SECONDS).longValue())));
                return iA;
            } catch (j$.time.c unused) {
                return ~i10;
            }
        }
        pVar.e(ZoneId.of(upperCase));
        return i11;
    }

    public final String toString() {
        switch (this.f13642a) {
            case 0:
                return "Instant()";
            default:
                return "ZoneRegionId()";
        }
    }
}
