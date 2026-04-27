package j$.time.zone;

import j$.time.DayOfWeek;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.chrono.s;
import j$.time.l;
import j$.time.n;
import j$.time.temporal.o;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Serializable {
    private static final long serialVersionUID = 6889046316657758795L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f19888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte f19889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DayOfWeek f19890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final l f19891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f19892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d f19893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ZoneOffset f19894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ZoneOffset f19895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ZoneOffset f19896i;

    e(n nVar, int i8, DayOfWeek dayOfWeek, l lVar, boolean z7, d dVar, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.f19888a = nVar;
        this.f19889b = (byte) i8;
        this.f19890c = dayOfWeek;
        this.f19891d = lVar;
        this.f19892e = z7;
        this.f19893f = dVar;
        this.f19894g = zoneOffset;
        this.f19895h = zoneOffset2;
        this.f19896i = zoneOffset3;
    }

    static e b(DataInput dataInput) {
        int i8 = dataInput.readInt();
        n nVarM = n.M(i8 >>> 28);
        int i9 = ((264241152 & i8) >>> 22) - 32;
        int i10 = (3670016 & i8) >>> 19;
        DayOfWeek dayOfWeekQ = i10 == 0 ? null : DayOfWeek.q(i10);
        int i11 = (507904 & i8) >>> 14;
        d dVar = d.values()[(i8 & 12288) >>> 12];
        int i12 = (i8 & 4080) >>> 4;
        int i13 = (i8 & 12) >>> 2;
        int i14 = i8 & 3;
        l lVarC0 = i11 == 31 ? l.c0(dataInput.readInt()) : l.Z(i11 % 24);
        ZoneOffset zoneOffsetA0 = ZoneOffset.a0(i12 == 255 ? dataInput.readInt() : (i12 - 128) * 900);
        ZoneOffset zoneOffsetA02 = i13 == 3 ? ZoneOffset.a0(dataInput.readInt()) : ZoneOffset.a0((i13 * 1800) + zoneOffsetA0.X());
        ZoneOffset zoneOffsetA03 = i14 == 3 ? ZoneOffset.a0(dataInput.readInt()) : ZoneOffset.a0((i14 * 1800) + zoneOffsetA0.X());
        boolean z7 = i11 == 24;
        Objects.requireNonNull(nVarM, "month");
        Objects.requireNonNull(lVarC0, com.amazon.a.a.h.a.f13759b);
        Objects.requireNonNull(dVar, "timeDefnition");
        if (i9 < -28 || i9 > 31 || i9 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        }
        if (z7 && !lVarC0.equals(l.f19815g)) {
            throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
        }
        if (lVarC0.X() == 0) {
            return new e(nVarM, i9, dayOfWeekQ, lVarC0, z7, dVar, zoneOffsetA0, zoneOffsetA02, zoneOffsetA03);
        }
        throw new IllegalArgumentException("Time's nano-of-second must be zero");
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 3, this);
    }

    public final b a(int i8) {
        j$.time.h hVarF0;
        o oVar;
        int iX;
        ZoneOffset zoneOffset;
        DayOfWeek dayOfWeek = this.f19890c;
        n nVar = this.f19888a;
        byte b8 = this.f19889b;
        if (b8 < 0) {
            s.f19713d.getClass();
            hVarF0 = j$.time.h.f0(i8, nVar, nVar.A(s.X(i8)) + 1 + b8);
            if (dayOfWeek != null) {
                oVar = new o(dayOfWeek.o(), 1);
                hVarF0 = hVarF0.j(oVar);
            }
        } else {
            hVarF0 = j$.time.h.f0(i8, nVar, b8);
            if (dayOfWeek != null) {
                oVar = new o(dayOfWeek.o(), 0);
                hVarF0 = hVarF0.j(oVar);
            }
        }
        if (this.f19892e) {
            hVarF0 = hVarF0.j0(1L);
        }
        LocalDateTime localDateTimeF0 = LocalDateTime.f0(hVarF0, this.f19891d);
        d dVar = this.f19893f;
        dVar.getClass();
        int i9 = c.f19886a[dVar.ordinal()];
        ZoneOffset zoneOffset2 = this.f19895h;
        if (i9 != 1) {
            if (i9 == 2) {
                iX = zoneOffset2.X();
                zoneOffset = this.f19894g;
            }
            return new b(localDateTimeF0, zoneOffset2, this.f19896i);
        }
        iX = zoneOffset2.X();
        zoneOffset = ZoneOffset.UTC;
        localDateTimeF0 = localDateTimeF0.i0(iX - zoneOffset.X());
        return new b(localDateTimeF0, zoneOffset2, this.f19896i);
    }

    final void c(DataOutput dataOutput) {
        l lVar = this.f19891d;
        boolean z7 = this.f19892e;
        int iK0 = z7 ? 86400 : lVar.k0();
        int iX = this.f19894g.X();
        ZoneOffset zoneOffset = this.f19895h;
        int iX2 = zoneOffset.X() - iX;
        ZoneOffset zoneOffset2 = this.f19896i;
        int iX3 = zoneOffset2.X() - iX;
        int iR = iK0 % 3600 == 0 ? z7 ? 24 : lVar.R() : 31;
        int i8 = iX % 900 == 0 ? (iX / 900) + 128 : 255;
        int i9 = (iX2 == 0 || iX2 == 1800 || iX2 == 3600) ? iX2 / 1800 : 3;
        int i10 = (iX3 == 0 || iX3 == 1800 || iX3 == 3600) ? iX3 / 1800 : 3;
        DayOfWeek dayOfWeek = this.f19890c;
        dataOutput.writeInt((this.f19888a.o() << 28) + ((this.f19889b + 32) << 22) + ((dayOfWeek == null ? 0 : dayOfWeek.o()) << 19) + (iR << 14) + (this.f19893f.ordinal() << 12) + (i8 << 4) + (i9 << 2) + i10);
        if (iR == 31) {
            dataOutput.writeInt(iK0);
        }
        if (i8 == 255) {
            dataOutput.writeInt(iX);
        }
        if (i9 == 3) {
            dataOutput.writeInt(zoneOffset.X());
        }
        if (i10 == 3) {
            dataOutput.writeInt(zoneOffset2.X());
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f19888a == eVar.f19888a && this.f19889b == eVar.f19889b && this.f19890c == eVar.f19890c && this.f19893f == eVar.f19893f && this.f19891d.equals(eVar.f19891d) && this.f19892e == eVar.f19892e && this.f19894g.equals(eVar.f19894g) && this.f19895h.equals(eVar.f19895h) && this.f19896i.equals(eVar.f19896i);
    }

    public final int hashCode() {
        int iK0 = ((this.f19891d.k0() + (this.f19892e ? 1 : 0)) << 15) + (this.f19888a.ordinal() << 11) + ((this.f19889b + 32) << 5);
        DayOfWeek dayOfWeek = this.f19890c;
        return ((this.f19894g.hashCode() ^ (this.f19893f.ordinal() + (iK0 + ((dayOfWeek == null ? 7 : dayOfWeek.ordinal()) << 2)))) ^ this.f19895h.hashCode()) ^ this.f19896i.hashCode();
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("TransitionRule[");
        ZoneOffset zoneOffset = this.f19895h;
        ZoneOffset zoneOffset2 = this.f19896i;
        sb.append(zoneOffset.compareTo(zoneOffset2) > 0 ? "Gap " : "Overlap ");
        sb.append(zoneOffset);
        sb.append(" to ");
        sb.append(zoneOffset2);
        sb.append(", ");
        n nVar = this.f19888a;
        byte b8 = this.f19889b;
        DayOfWeek dayOfWeek = this.f19890c;
        if (dayOfWeek == null) {
            sb.append(nVar.name());
            sb.append(' ');
            sb.append((int) b8);
        } else {
            if (b8 == -1) {
                sb.append(dayOfWeek.name());
                str = " on or before last day of ";
            } else if (b8 < 0) {
                sb.append(dayOfWeek.name());
                sb.append(" on or before last day minus ");
                sb.append((-b8) - 1);
                str = " of ";
            } else {
                sb.append(dayOfWeek.name());
                sb.append(" on or after ");
                sb.append(nVar.name());
                sb.append(' ');
                sb.append((int) b8);
            }
            sb.append(str);
            sb.append(nVar.name());
        }
        sb.append(" at ");
        sb.append(this.f19892e ? "24:00" : this.f19891d.toString());
        sb.append(" ");
        sb.append(this.f19893f);
        sb.append(", standard offset ");
        sb.append(this.f19894g);
        sb.append(']');
        return sb.toString();
    }
}
