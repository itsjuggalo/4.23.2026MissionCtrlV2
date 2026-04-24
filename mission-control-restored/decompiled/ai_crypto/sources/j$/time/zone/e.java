package j$.time.zone;

import j$.time.DayOfWeek;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.chrono.s;
import j$.time.l;
import j$.time.n;
import j$.time.temporal.o;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Serializable {
    private static final long serialVersionUID = 6889046316657758795L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f17311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte f17312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DayOfWeek f17313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final l f17314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f17315e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d f17316f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ZoneOffset f17317g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ZoneOffset f17318h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ZoneOffset f17319i;

    e(n nVar, int i7, DayOfWeek dayOfWeek, l lVar, boolean z7, d dVar, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.f17311a = nVar;
        this.f17312b = (byte) i7;
        this.f17313c = dayOfWeek;
        this.f17314d = lVar;
        this.f17315e = z7;
        this.f17316f = dVar;
        this.f17317g = zoneOffset;
        this.f17318h = zoneOffset2;
        this.f17319i = zoneOffset3;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 3, this);
    }

    final void writeExternal(ObjectOutput objectOutput) {
        l lVar = this.f17314d;
        boolean z7 = this.f17315e;
        int iM0 = z7 ? 86400 : lVar.m0();
        int iZ = this.f17317g.Z();
        ZoneOffset zoneOffset = this.f17318h;
        int iZ2 = zoneOffset.Z() - iZ;
        ZoneOffset zoneOffset2 = this.f17319i;
        int iZ3 = zoneOffset2.Z() - iZ;
        int iT = iM0 % 3600 == 0 ? z7 ? 24 : lVar.T() : 31;
        int i7 = iZ % 900 == 0 ? (iZ / 900) + 128 : 255;
        int i8 = (iZ2 == 0 || iZ2 == 1800 || iZ2 == 3600) ? iZ2 / 1800 : 3;
        int i9 = (iZ3 == 0 || iZ3 == 1800 || iZ3 == 3600) ? iZ3 / 1800 : 3;
        DayOfWeek dayOfWeek = this.f17313c;
        objectOutput.writeInt((this.f17311a.p() << 28) + ((this.f17312b + 32) << 22) + ((dayOfWeek == null ? 0 : dayOfWeek.p()) << 19) + (iT << 14) + (this.f17316f.ordinal() << 12) + (i7 << 4) + (i8 << 2) + i9);
        if (iT == 31) {
            objectOutput.writeInt(iM0);
        }
        if (i7 == 255) {
            objectOutput.writeInt(iZ);
        }
        if (i8 == 3) {
            objectOutput.writeInt(zoneOffset.Z());
        }
        if (i9 == 3) {
            objectOutput.writeInt(zoneOffset2.Z());
        }
    }

    static e b(ObjectInput objectInput) {
        int i7 = objectInput.readInt();
        n nVarS = n.S(i7 >>> 28);
        int i8 = ((264241152 & i7) >>> 22) - 32;
        int i9 = (3670016 & i7) >>> 19;
        DayOfWeek dayOfWeekR = i9 == 0 ? null : DayOfWeek.r(i9);
        int i10 = (507904 & i7) >>> 14;
        d dVar = d.values()[(i7 & 12288) >>> 12];
        int i11 = (i7 & 4080) >>> 4;
        int i12 = (i7 & 12) >>> 2;
        int i13 = i7 & 3;
        l lVarE0 = i10 == 31 ? l.e0(objectInput.readInt()) : l.b0(i10 % 24);
        ZoneOffset zoneOffsetC0 = ZoneOffset.c0(i11 == 255 ? objectInput.readInt() : (i11 - 128) * 900);
        ZoneOffset zoneOffsetC02 = i12 == 3 ? ZoneOffset.c0(objectInput.readInt()) : ZoneOffset.c0((i12 * 1800) + zoneOffsetC0.Z());
        ZoneOffset zoneOffsetC03 = i13 == 3 ? ZoneOffset.c0(objectInput.readInt()) : ZoneOffset.c0((i13 * 1800) + zoneOffsetC0.Z());
        boolean z7 = i10 == 24;
        Objects.requireNonNull(nVarS, "month");
        Objects.requireNonNull(lVarE0, com.amazon.a.a.h.a.f9648b);
        Objects.requireNonNull(dVar, "timeDefnition");
        if (i8 < -28 || i8 > 31 || i8 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        }
        if (z7 && !lVarE0.equals(l.f17238g)) {
            throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
        }
        if (lVarE0.Z() != 0) {
            throw new IllegalArgumentException("Time's nano-of-second must be zero");
        }
        return new e(nVarS, i8, dayOfWeekR, lVarE0, z7, dVar, zoneOffsetC0, zoneOffsetC02, zoneOffsetC03);
    }

    public final b a(int i7) {
        j$.time.h hVarH0;
        n nVar = this.f17311a;
        DayOfWeek dayOfWeek = this.f17313c;
        byte b7 = this.f17312b;
        if (b7 < 0) {
            s.f17138d.getClass();
            hVarH0 = j$.time.h.h0(i7, nVar, nVar.C(s.Z(i7)) + 1 + b7);
            if (dayOfWeek != null) {
                hVarH0 = hVarH0.j(new o(dayOfWeek.p(), 1));
            }
        } else {
            hVarH0 = j$.time.h.h0(i7, nVar, b7);
            if (dayOfWeek != null) {
                hVarH0 = hVarH0.j(new o(dayOfWeek.p(), 0));
            }
        }
        if (this.f17315e) {
            hVarH0 = hVarH0.l0(1L);
        }
        LocalDateTime localDateTimeH0 = LocalDateTime.h0(hVarH0, this.f17314d);
        int i8 = c.f17309a[this.f17316f.ordinal()];
        ZoneOffset zoneOffset = this.f17318h;
        if (i8 == 1) {
            localDateTimeH0 = localDateTimeH0.k0(zoneOffset.Z() - ZoneOffset.UTC.Z());
        } else if (i8 == 2) {
            localDateTimeH0 = localDateTimeH0.k0(zoneOffset.Z() - this.f17317g.Z());
        }
        return new b(localDateTimeH0, zoneOffset, this.f17319i);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f17311a == eVar.f17311a && this.f17312b == eVar.f17312b && this.f17313c == eVar.f17313c && this.f17316f == eVar.f17316f && this.f17314d.equals(eVar.f17314d) && this.f17315e == eVar.f17315e && this.f17317g.equals(eVar.f17317g) && this.f17318h.equals(eVar.f17318h) && this.f17319i.equals(eVar.f17319i);
    }

    public final int hashCode() {
        int iM0 = ((this.f17314d.m0() + (this.f17315e ? 1 : 0)) << 15) + (this.f17311a.ordinal() << 11) + ((this.f17312b + 32) << 5);
        DayOfWeek dayOfWeek = this.f17313c;
        return ((this.f17317g.hashCode() ^ (this.f17316f.ordinal() + (iM0 + ((dayOfWeek == null ? 7 : dayOfWeek.ordinal()) << 2)))) ^ this.f17318h.hashCode()) ^ this.f17319i.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TransitionRule[");
        ZoneOffset zoneOffset = this.f17318h;
        ZoneOffset zoneOffset2 = this.f17319i;
        sb.append(zoneOffset.compareTo(zoneOffset2) > 0 ? "Gap " : "Overlap ");
        sb.append(zoneOffset);
        sb.append(" to ");
        sb.append(zoneOffset2);
        sb.append(", ");
        n nVar = this.f17311a;
        byte b7 = this.f17312b;
        DayOfWeek dayOfWeek = this.f17313c;
        if (dayOfWeek == null) {
            sb.append(nVar.name());
            sb.append(' ');
            sb.append((int) b7);
        } else if (b7 == -1) {
            sb.append(dayOfWeek.name());
            sb.append(" on or before last day of ");
            sb.append(nVar.name());
        } else if (b7 < 0) {
            sb.append(dayOfWeek.name());
            sb.append(" on or before last day minus ");
            sb.append((-b7) - 1);
            sb.append(" of ");
            sb.append(nVar.name());
        } else {
            sb.append(dayOfWeek.name());
            sb.append(" on or after ");
            sb.append(nVar.name());
            sb.append(' ');
            sb.append((int) b7);
        }
        sb.append(" at ");
        sb.append(this.f17315e ? "24:00" : this.f17314d.toString());
        sb.append(" ");
        sb.append(this.f17316f);
        sb.append(", standard offset ");
        sb.append(this.f17317g);
        sb.append(']');
        return sb.toString();
    }
}
