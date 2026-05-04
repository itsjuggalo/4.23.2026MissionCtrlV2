package j$.time.zone;

import j$.time.DayOfWeek;
import j$.time.ZoneOffset;
import j$.time.l;
import j$.time.n;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Serializable {
    private static final long serialVersionUID = 6889046316657758795L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f13786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f13787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DayOfWeek f13788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f13789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f13790e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f13791f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ZoneOffset f13792g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ZoneOffset f13793h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ZoneOffset f13794i;

    public e(n nVar, int i10, DayOfWeek dayOfWeek, l lVar, boolean z10, d dVar, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.f13786a = nVar;
        this.f13787b = (byte) i10;
        this.f13788c = dayOfWeek;
        this.f13789d = lVar;
        this.f13790e = z10;
        this.f13791f = dVar;
        this.f13792g = zoneOffset;
        this.f13793h = zoneOffset2;
        this.f13794i = zoneOffset3;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 3, this);
    }

    public final void b(DataOutput dataOutput) {
        int iE0 = this.f13790e ? 86400 : this.f13789d.e0();
        int i10 = this.f13792g.f13556b;
        int i11 = this.f13793h.f13556b - i10;
        int i12 = this.f13794i.f13556b - i10;
        byte b10 = iE0 % 3600 == 0 ? this.f13790e ? (byte) 24 : this.f13789d.f13712a : (byte) 31;
        int i13 = i10 % 900 == 0 ? (i10 / 900) + 128 : 255;
        int i14 = (i11 == 0 || i11 == 1800 || i11 == 3600) ? i11 / 1800 : 3;
        int i15 = (i12 == 0 || i12 == 1800 || i12 == 3600) ? i12 / 1800 : 3;
        DayOfWeek dayOfWeek = this.f13788c;
        dataOutput.writeInt((this.f13786a.getValue() << 28) + ((this.f13787b + 32) << 22) + ((dayOfWeek == null ? 0 : dayOfWeek.getValue()) << 19) + (b10 << 14) + (this.f13791f.ordinal() << 12) + (i13 << 4) + (i14 << 2) + i15);
        if (b10 == 31) {
            dataOutput.writeInt(iE0);
        }
        if (i13 == 255) {
            dataOutput.writeInt(i10);
        }
        if (i14 == 3) {
            dataOutput.writeInt(this.f13793h.f13556b);
        }
        if (i15 == 3) {
            dataOutput.writeInt(this.f13794i.f13556b);
        }
    }

    public static e a(DataInput dataInput) {
        d dVar;
        l lVarA;
        int i10;
        int i11;
        int i12 = dataInput.readInt();
        n nVarI = n.I(i12 >>> 28);
        int i13 = ((264241152 & i12) >>> 22) - 32;
        int i14 = (3670016 & i12) >>> 19;
        DayOfWeek dayOfWeekS = i14 == 0 ? null : DayOfWeek.s(i14);
        int i15 = (507904 & i12) >>> 14;
        d dVar2 = d.values()[(i12 & 12288) >>> 12];
        int i16 = (i12 & 4080) >>> 4;
        int i17 = (i12 & 12) >>> 2;
        int i18 = i12 & 3;
        if (i15 == 31) {
            long j10 = dataInput.readInt();
            l lVar = l.f13708e;
            j$.time.temporal.a.SECOND_OF_DAY.X(j10);
            int i19 = (int) (j10 / 3600);
            long j11 = j10 - ((long) (i19 * 3600));
            int i20 = (int) (j11 / 60);
            dVar = dVar2;
            lVarA = l.A(i19, i20, (int) (j11 - ((long) (i20 * 60))), 0);
        } else {
            dVar = dVar2;
            int i21 = i15 % 24;
            l lVar2 = l.f13708e;
            j$.time.temporal.a.HOUR_OF_DAY.X(i21);
            lVarA = l.f13711h[i21];
        }
        ZoneOffset zoneOffsetY = ZoneOffset.Y(i16 == 255 ? dataInput.readInt() : (i16 - 128) * 900);
        if (i17 == 3) {
            i10 = dataInput.readInt();
        } else {
            i10 = (i17 * 1800) + zoneOffsetY.f13556b;
        }
        ZoneOffset zoneOffsetY2 = ZoneOffset.Y(i10);
        if (i18 == 3) {
            i11 = dataInput.readInt();
        } else {
            i11 = (i18 * 1800) + zoneOffsetY.f13556b;
        }
        ZoneOffset zoneOffsetY3 = ZoneOffset.Y(i11);
        boolean z10 = i15 == 24;
        Objects.requireNonNull(nVarI, "month");
        Objects.requireNonNull(lVarA, com.amazon.a.a.h.a.f4275b);
        d dVar3 = dVar;
        Objects.requireNonNull(dVar3, "timeDefnition");
        if (i13 < -28 || i13 > 31 || i13 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        }
        if (z10 && !lVarA.equals(l.f13710g)) {
            throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
        }
        if (lVarA.f13715d != 0) {
            throw new IllegalArgumentException("Time's nano-of-second must be zero");
        }
        return new e(nVarI, i13, dayOfWeekS, lVarA, z10, dVar3, zoneOffsetY, zoneOffsetY2, zoneOffsetY3);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f13786a == eVar.f13786a && this.f13787b == eVar.f13787b && this.f13788c == eVar.f13788c && this.f13791f == eVar.f13791f && this.f13789d.equals(eVar.f13789d) && this.f13790e == eVar.f13790e && this.f13792g.equals(eVar.f13792g) && this.f13793h.equals(eVar.f13793h) && this.f13794i.equals(eVar.f13794i)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iE0 = ((this.f13789d.e0() + (this.f13790e ? 1 : 0)) << 15) + (this.f13786a.ordinal() << 11) + ((this.f13787b + 32) << 5);
        DayOfWeek dayOfWeek = this.f13788c;
        return ((this.f13792g.f13556b ^ (this.f13791f.ordinal() + (iE0 + ((dayOfWeek == null ? 7 : dayOfWeek.ordinal()) << 2)))) ^ this.f13793h.f13556b) ^ this.f13794i.f13556b;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("TransitionRule[");
        sb2.append(this.f13794i.f13556b - this.f13793h.f13556b > 0 ? "Gap " : "Overlap ");
        sb2.append(this.f13793h);
        sb2.append(" to ");
        sb2.append(this.f13794i);
        sb2.append(", ");
        DayOfWeek dayOfWeek = this.f13788c;
        if (dayOfWeek != null) {
            byte b10 = this.f13787b;
            if (b10 == -1) {
                sb2.append(dayOfWeek.name());
                sb2.append(" on or before last day of ");
                sb2.append(this.f13786a.name());
            } else if (b10 < 0) {
                sb2.append(dayOfWeek.name());
                sb2.append(" on or before last day minus ");
                sb2.append((-this.f13787b) - 1);
                sb2.append(" of ");
                sb2.append(this.f13786a.name());
            } else {
                sb2.append(dayOfWeek.name());
                sb2.append(" on or after ");
                sb2.append(this.f13786a.name());
                sb2.append(' ');
                sb2.append((int) this.f13787b);
            }
        } else {
            sb2.append(this.f13786a.name());
            sb2.append(' ');
            sb2.append((int) this.f13787b);
        }
        sb2.append(" at ");
        sb2.append(this.f13790e ? "24:00" : this.f13789d.toString());
        sb2.append(" ");
        sb2.append(this.f13791f);
        sb2.append(", standard offset ");
        sb2.append(this.f13792g);
        sb2.append(']');
        return sb2.toString();
    }
}
