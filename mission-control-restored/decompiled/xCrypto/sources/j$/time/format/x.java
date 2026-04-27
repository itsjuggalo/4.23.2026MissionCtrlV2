package j$.time.format;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.InterfaceC1549b;
import j$.time.temporal.TemporalAccessor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class x implements TemporalAccessor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ZoneId f13258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    j$.time.chrono.l f13259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f13260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private y f13261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private InterfaceC1549b f13262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private j$.time.k f13263g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final HashMap f13257a = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    j$.time.r f13264h = j$.time.r.f13292d;

    x() {
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.r rVar) {
        if (this.f13257a.containsKey(rVar)) {
            return true;
        }
        InterfaceC1549b interfaceC1549b = this.f13262f;
        if (interfaceC1549b != null && interfaceC1549b.f(rVar)) {
            return true;
        }
        j$.time.k kVar = this.f13263g;
        if (kVar == null || !kVar.f(rVar)) {
            return (rVar == null || (rVar instanceof j$.time.temporal.a) || !rVar.W(this)) ? false : true;
        }
        return true;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        Objects.requireNonNull(rVar, "field");
        Long l4 = (Long) this.f13257a.get(rVar);
        if (l4 != null) {
            return l4.longValue();
        }
        InterfaceC1549b interfaceC1549b = this.f13262f;
        if (interfaceC1549b != null && interfaceC1549b.f(rVar)) {
            return this.f13262f.g(rVar);
        }
        j$.time.k kVar = this.f13263g;
        if (kVar != null && kVar.f(rVar)) {
            return this.f13263g.g(rVar);
        }
        if (rVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.v(j$.time.d.a("Unsupported field: ", rVar));
        }
        return rVar.r(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object a(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.s.g()) {
            return this.f13258b;
        }
        if (tVar == j$.time.temporal.s.a()) {
            return this.f13259c;
        }
        if (tVar == j$.time.temporal.s.b()) {
            InterfaceC1549b interfaceC1549b = this.f13262f;
            if (interfaceC1549b != null) {
                return j$.time.g.J(interfaceC1549b);
            }
            return null;
        }
        if (tVar == j$.time.temporal.s.c()) {
            return this.f13263g;
        }
        if (tVar == j$.time.temporal.s.d()) {
            Long l4 = (Long) this.f13257a.get(j$.time.temporal.a.OFFSET_SECONDS);
            if (l4 != null) {
                return ZoneOffset.c0(l4.intValue());
            }
            ZoneId zoneId = this.f13258b;
            return zoneId instanceof ZoneOffset ? zoneId : tVar.j(this);
        }
        if (tVar == j$.time.temporal.s.f()) {
            return tVar.j(this);
        }
        if (tVar == j$.time.temporal.s.e()) {
            return null;
        }
        return tVar.j(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x01b9  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void r(j$.time.format.y r27) {
        /*
            Method dump skipped, instruction units count: 755
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.x.r(j$.time.format.y):void");
    }

    private void C(j$.time.temporal.r rVar, j$.time.temporal.a aVar, Long l4) {
        Long l5 = (Long) this.f13257a.put(aVar, l4);
        if (l5 == null || l5.longValue() == l4.longValue()) {
            return;
        }
        throw new j$.time.c("Conflict found: " + aVar + " " + l5 + " differs from " + aVar + " " + l4 + " while resolving  " + rVar);
    }

    private void s() {
        HashMap map = this.f13257a;
        if (map.containsKey(j$.time.temporal.a.INSTANT_SECONDS)) {
            ZoneId zoneId = this.f13258b;
            if (zoneId != null) {
                t(zoneId);
                return;
            }
            Long l4 = (Long) map.get(j$.time.temporal.a.OFFSET_SECONDS);
            if (l4 != null) {
                t(ZoneOffset.c0(l4.intValue()));
            }
        }
    }

    private void t(ZoneId zoneId) {
        HashMap map = this.f13257a;
        j$.time.temporal.a aVar = j$.time.temporal.a.INSTANT_SECONDS;
        A(this.f13259c.y(Instant.J(((Long) map.remove(aVar)).longValue()), zoneId).o());
        C(aVar, j$.time.temporal.a.SECOND_OF_DAY, Long.valueOf(r5.n().m0()));
    }

    private void A(InterfaceC1549b interfaceC1549b) {
        InterfaceC1549b interfaceC1549b2 = this.f13262f;
        if (interfaceC1549b2 != null) {
            if (interfaceC1549b == null || interfaceC1549b2.equals(interfaceC1549b)) {
                return;
            }
            throw new j$.time.c("Conflict found: Fields resolved to two different dates: " + this.f13262f + " " + interfaceC1549b);
        }
        if (interfaceC1549b != null) {
            if (!this.f13259c.equals(interfaceC1549b.h())) {
                throw new j$.time.c("ChronoLocalDate must use the effective parsed chronology: " + this.f13259c);
            }
            this.f13262f = interfaceC1549b;
        }
    }

    private void x() {
        HashMap map = this.f13257a;
        j$.time.temporal.a aVar = j$.time.temporal.a.CLOCK_HOUR_OF_DAY;
        if (map.containsKey(aVar)) {
            long jLongValue = ((Long) map.remove(aVar)).longValue();
            y yVar = this.f13261e;
            if (yVar == y.STRICT || (yVar == y.SMART && jLongValue != 0)) {
                aVar.a0(jLongValue);
            }
            j$.time.temporal.a aVar2 = j$.time.temporal.a.HOUR_OF_DAY;
            if (jLongValue == 24) {
                jLongValue = 0;
            }
            C(aVar, aVar2, Long.valueOf(jLongValue));
        }
        j$.time.temporal.a aVar3 = j$.time.temporal.a.CLOCK_HOUR_OF_AMPM;
        if (map.containsKey(aVar3)) {
            long jLongValue2 = ((Long) map.remove(aVar3)).longValue();
            y yVar2 = this.f13261e;
            if (yVar2 == y.STRICT || (yVar2 == y.SMART && jLongValue2 != 0)) {
                aVar3.a0(jLongValue2);
            }
            C(aVar3, j$.time.temporal.a.HOUR_OF_AMPM, Long.valueOf(jLongValue2 != 12 ? jLongValue2 : 0L));
        }
        j$.time.temporal.a aVar4 = j$.time.temporal.a.AMPM_OF_DAY;
        if (map.containsKey(aVar4)) {
            j$.time.temporal.a aVar5 = j$.time.temporal.a.HOUR_OF_AMPM;
            if (map.containsKey(aVar5)) {
                long jLongValue3 = ((Long) map.remove(aVar4)).longValue();
                long jLongValue4 = ((Long) map.remove(aVar5)).longValue();
                if (this.f13261e == y.LENIENT) {
                    C(aVar4, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(Math.addExact(Math.multiplyExact(jLongValue3, 12), jLongValue4)));
                } else {
                    aVar4.a0(jLongValue3);
                    aVar5.a0(jLongValue3);
                    C(aVar4, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf((jLongValue3 * 12) + jLongValue4));
                }
            }
        }
        j$.time.temporal.a aVar6 = j$.time.temporal.a.NANO_OF_DAY;
        if (map.containsKey(aVar6)) {
            long jLongValue5 = ((Long) map.remove(aVar6)).longValue();
            if (this.f13261e != y.LENIENT) {
                aVar6.a0(jLongValue5);
            }
            C(aVar6, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(jLongValue5 / 3600000000000L));
            C(aVar6, j$.time.temporal.a.MINUTE_OF_HOUR, Long.valueOf((jLongValue5 / 60000000000L) % 60));
            C(aVar6, j$.time.temporal.a.SECOND_OF_MINUTE, Long.valueOf((jLongValue5 / 1000000000) % 60));
            C(aVar6, j$.time.temporal.a.NANO_OF_SECOND, Long.valueOf(jLongValue5 % 1000000000));
        }
        j$.time.temporal.a aVar7 = j$.time.temporal.a.MICRO_OF_DAY;
        if (map.containsKey(aVar7)) {
            long jLongValue6 = ((Long) map.remove(aVar7)).longValue();
            if (this.f13261e != y.LENIENT) {
                aVar7.a0(jLongValue6);
            }
            C(aVar7, j$.time.temporal.a.SECOND_OF_DAY, Long.valueOf(jLongValue6 / 1000000));
            C(aVar7, j$.time.temporal.a.MICRO_OF_SECOND, Long.valueOf(jLongValue6 % 1000000));
        }
        j$.time.temporal.a aVar8 = j$.time.temporal.a.MILLI_OF_DAY;
        if (map.containsKey(aVar8)) {
            long jLongValue7 = ((Long) map.remove(aVar8)).longValue();
            if (this.f13261e != y.LENIENT) {
                aVar8.a0(jLongValue7);
            }
            C(aVar8, j$.time.temporal.a.SECOND_OF_DAY, Long.valueOf(jLongValue7 / 1000));
            C(aVar8, j$.time.temporal.a.MILLI_OF_SECOND, Long.valueOf(jLongValue7 % 1000));
        }
        j$.time.temporal.a aVar9 = j$.time.temporal.a.SECOND_OF_DAY;
        if (map.containsKey(aVar9)) {
            long jLongValue8 = ((Long) map.remove(aVar9)).longValue();
            if (this.f13261e != y.LENIENT) {
                aVar9.a0(jLongValue8);
            }
            C(aVar9, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(jLongValue8 / 3600));
            C(aVar9, j$.time.temporal.a.MINUTE_OF_HOUR, Long.valueOf((jLongValue8 / 60) % 60));
            C(aVar9, j$.time.temporal.a.SECOND_OF_MINUTE, Long.valueOf(jLongValue8 % 60));
        }
        j$.time.temporal.a aVar10 = j$.time.temporal.a.MINUTE_OF_DAY;
        if (map.containsKey(aVar10)) {
            long jLongValue9 = ((Long) map.remove(aVar10)).longValue();
            if (this.f13261e != y.LENIENT) {
                aVar10.a0(jLongValue9);
            }
            C(aVar10, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(jLongValue9 / 60));
            C(aVar10, j$.time.temporal.a.MINUTE_OF_HOUR, Long.valueOf(jLongValue9 % 60));
        }
        j$.time.temporal.a aVar11 = j$.time.temporal.a.NANO_OF_SECOND;
        if (map.containsKey(aVar11)) {
            long jLongValue10 = ((Long) map.get(aVar11)).longValue();
            y yVar3 = this.f13261e;
            y yVar4 = y.LENIENT;
            if (yVar3 != yVar4) {
                aVar11.a0(jLongValue10);
            }
            j$.time.temporal.a aVar12 = j$.time.temporal.a.MICRO_OF_SECOND;
            if (map.containsKey(aVar12)) {
                long jLongValue11 = ((Long) map.remove(aVar12)).longValue();
                if (this.f13261e != yVar4) {
                    aVar12.a0(jLongValue11);
                }
                jLongValue10 = (jLongValue10 % 1000) + (jLongValue11 * 1000);
                C(aVar12, aVar11, Long.valueOf(jLongValue10));
            }
            j$.time.temporal.a aVar13 = j$.time.temporal.a.MILLI_OF_SECOND;
            if (map.containsKey(aVar13)) {
                long jLongValue12 = ((Long) map.remove(aVar13)).longValue();
                if (this.f13261e != yVar4) {
                    aVar13.a0(jLongValue12);
                }
                C(aVar13, aVar11, Long.valueOf((jLongValue10 % 1000000) + (jLongValue12 * 1000000)));
            }
        }
        j$.time.temporal.a aVar14 = j$.time.temporal.a.HOUR_OF_DAY;
        if (map.containsKey(aVar14)) {
            j$.time.temporal.a aVar15 = j$.time.temporal.a.MINUTE_OF_HOUR;
            if (map.containsKey(aVar15)) {
                j$.time.temporal.a aVar16 = j$.time.temporal.a.SECOND_OF_MINUTE;
                if (map.containsKey(aVar16) && map.containsKey(aVar11)) {
                    w(((Long) map.remove(aVar14)).longValue(), ((Long) map.remove(aVar15)).longValue(), ((Long) map.remove(aVar16)).longValue(), ((Long) map.remove(aVar11)).longValue());
                }
            }
        }
    }

    private void w(long j4, long j5, long j6, long j7) {
        if (this.f13261e == y.LENIENT) {
            long jAddExact = Math.addExact(Math.addExact(Math.addExact(Math.multiplyExact(j4, 3600000000000L), Math.multiplyExact(j5, 60000000000L)), Math.multiplyExact(j6, 1000000000L)), j7);
            y(j$.time.k.d0(Math.floorMod(jAddExact, 86400000000000L)), j$.time.r.b((int) Math.floorDiv(jAddExact, 86400000000000L)));
            return;
        }
        int iZ = j$.time.temporal.a.MINUTE_OF_HOUR.Z(j5);
        int iZ2 = j$.time.temporal.a.NANO_OF_SECOND.Z(j7);
        if (this.f13261e == y.SMART && j4 == 24 && iZ == 0 && j6 == 0 && iZ2 == 0) {
            y(j$.time.k.f13277g, j$.time.r.b(1));
        } else {
            y(j$.time.k.c0(j$.time.temporal.a.HOUR_OF_DAY.Z(j4), iZ, j$.time.temporal.a.SECOND_OF_MINUTE.Z(j6), iZ2), j$.time.r.f13292d);
        }
    }

    private void y(j$.time.k kVar, j$.time.r rVar) {
        j$.time.k kVar2 = this.f13263g;
        if (kVar2 != null) {
            if (!kVar2.equals(kVar)) {
                throw new j$.time.c("Conflict found: Fields resolved to different times: " + this.f13263g + " " + kVar);
            }
            j$.time.r rVar2 = this.f13264h;
            rVar2.getClass();
            j$.time.r rVar3 = j$.time.r.f13292d;
            if (rVar2 != rVar3 && rVar != rVar3 && !this.f13264h.equals(rVar)) {
                throw new j$.time.c("Conflict found: Fields resolved to different excess periods: " + this.f13264h + " " + rVar);
            }
            this.f13264h = rVar;
            return;
        }
        this.f13263g = kVar;
        this.f13264h = rVar;
    }

    private void q(TemporalAccessor temporalAccessor) {
        Iterator it = this.f13257a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            j$.time.temporal.r rVar = (j$.time.temporal.r) entry.getKey();
            if (temporalAccessor.f(rVar)) {
                try {
                    long jG = temporalAccessor.g(rVar);
                    long jLongValue = ((Long) entry.getValue()).longValue();
                    if (jG != jLongValue) {
                        throw new j$.time.c("Conflict found: Field " + rVar + " " + jG + " differs from " + rVar + " " + jLongValue + " derived from " + temporalAccessor);
                    }
                    it.remove();
                } catch (RuntimeException unused) {
                    continue;
                }
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(this.f13257a);
        sb.append(',');
        sb.append(this.f13259c);
        if (this.f13258b != null) {
            sb.append(',');
            sb.append(this.f13258b);
        }
        if (this.f13262f != null || this.f13263g != null) {
            sb.append(" resolved to ");
            InterfaceC1549b interfaceC1549b = this.f13262f;
            if (interfaceC1549b != null) {
                sb.append(interfaceC1549b);
                if (this.f13263g != null) {
                    sb.append('T');
                    sb.append(this.f13263g);
                }
            } else {
                sb.append(this.f13263g);
            }
        }
        return sb.toString();
    }
}
