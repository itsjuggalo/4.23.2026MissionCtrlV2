package j$.time.format;

import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.temporal.TemporalAccessor;

/* JADX INFO: loaded from: classes2.dex */
final class h implements f {
    @Override // j$.time.format.f
    public final boolean p(t tVar, StringBuilder sb) {
        boolean z4;
        Long lE = tVar.e(j$.time.temporal.a.INSTANT_SECONDS);
        TemporalAccessor temporalAccessorD = tVar.d();
        j$.time.temporal.a aVar = j$.time.temporal.a.NANO_OF_SECOND;
        Long lValueOf = temporalAccessorD.f(aVar) ? Long.valueOf(tVar.d().g(aVar)) : null;
        int i4 = 0;
        if (lE == null) {
            return false;
        }
        long jLongValue = lE.longValue();
        int iZ = aVar.Z(lValueOf != null ? lValueOf.longValue() : 0L);
        if (jLongValue >= -62167219200L) {
            long j4 = jLongValue - 253402300800L;
            long jFloorDiv = Math.floorDiv(j4, 315569520000L) + 1;
            LocalDateTime localDateTimeI0 = LocalDateTime.i0(Math.floorMod(j4, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
            if (jFloorDiv > 0) {
                sb.append('+');
                sb.append(jFloorDiv);
            }
            sb.append(localDateTimeI0);
            if (localDateTimeI0.b0() == 0) {
                sb.append(":00");
            }
            z4 = true;
        } else {
            long j5 = jLongValue + 62167219200L;
            z4 = true;
            long j6 = j5 / 315569520000L;
            long j7 = j5 % 315569520000L;
            LocalDateTime localDateTimeI02 = LocalDateTime.i0(j7 - 62167219200L, 0, ZoneOffset.UTC);
            int length = sb.length();
            sb.append(localDateTimeI02);
            if (localDateTimeI02.b0() == 0) {
                sb.append(":00");
            }
            if (j6 < 0) {
                if (localDateTimeI02.c0() == -10000) {
                    sb.replace(length, length + 2, Long.toString(j6 - 1));
                } else if (j7 == 0) {
                    sb.insert(length, j6);
                } else {
                    sb.insert(length + 1, Math.abs(j6));
                }
            }
        }
        if (iZ > 0) {
            sb.append(com.amazon.a.a.o.c.a.b.f8816a);
            int i5 = 100000000;
            while (true) {
                if (iZ <= 0 && i4 % 3 == 0 && i4 >= -2) {
                    break;
                }
                int i6 = iZ / i5;
                sb.append((char) (i6 + 48));
                iZ -= i6 * i5;
                i5 /= 10;
                i4++;
            }
        }
        sb.append('Z');
        return z4;
    }

    @Override // j$.time.format.f
    public final int r(q qVar, CharSequence charSequence, int i4) {
        int i5;
        int i6;
        p pVar = new p();
        pVar.a(DateTimeFormatter.ISO_LOCAL_DATE);
        pVar.e('T');
        j$.time.temporal.a aVar = j$.time.temporal.a.HOUR_OF_DAY;
        pVar.k(aVar, 2);
        pVar.e(':');
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MINUTE_OF_HOUR;
        pVar.k(aVar2, 2);
        pVar.e(':');
        j$.time.temporal.a aVar3 = j$.time.temporal.a.SECOND_OF_MINUTE;
        pVar.k(aVar3, 2);
        j$.time.temporal.a aVar4 = j$.time.temporal.a.NANO_OF_SECOND;
        pVar.b(aVar4);
        pVar.e('Z');
        e eVarF = pVar.t().f();
        q qVarC = qVar.c();
        int iR = eVarF.r(qVarC, charSequence, i4);
        if (iR < 0) {
            return iR;
        }
        long jLongValue = qVarC.i(j$.time.temporal.a.YEAR).longValue();
        int iIntValue = qVarC.i(j$.time.temporal.a.MONTH_OF_YEAR).intValue();
        int iIntValue2 = qVarC.i(j$.time.temporal.a.DAY_OF_MONTH).intValue();
        int iIntValue3 = qVarC.i(aVar).intValue();
        int iIntValue4 = qVarC.i(aVar2).intValue();
        Long lI = qVarC.i(aVar3);
        Long lI2 = qVarC.i(aVar4);
        int i7 = 0;
        int iIntValue5 = lI != null ? lI.intValue() : 0;
        int iIntValue6 = lI2 != null ? lI2.intValue() : 0;
        if (iIntValue3 == 24 && iIntValue4 == 0 && iIntValue5 == 0 && iIntValue6 == 0) {
            i6 = iIntValue5;
            i5 = 0;
            i7 = 1;
        } else if (iIntValue3 == 23 && iIntValue4 == 59 && iIntValue5 == 60) {
            qVar.o();
            i5 = iIntValue3;
            i6 = 59;
        } else {
            i5 = iIntValue3;
            i6 = iIntValue5;
        }
        try {
            return qVar.n(aVar4, iIntValue6, i4, qVar.n(j$.time.temporal.a.INSTANT_SECONDS, LocalDateTime.g0(((int) jLongValue) % 10000, iIntValue, iIntValue2, i5, iIntValue4, i6, 0).plusDays(i7).Y(ZoneOffset.UTC) + Math.multiplyExact(jLongValue / 10000, 315569520000L), i4, iR));
        } catch (RuntimeException unused) {
            return ~i4;
        }
    }

    public final String toString() {
        return "Instant()";
    }
}
