package j$.time.zone;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.firestore.local.SQLitePersistence;
import j$.time.DayOfWeek;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.chrono.s;
import j$.time.k;
import j$.time.m;
import j$.time.temporal.o;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Serializable {
    private static final long serialVersionUID = 6889046316657758795L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f13350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte f13351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DayOfWeek f13352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final k f13353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f13354e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d f13355f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ZoneOffset f13356g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ZoneOffset f13357h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ZoneOffset f13358i;

    e(m mVar, int i4, DayOfWeek dayOfWeek, k kVar, boolean z4, d dVar, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.f13350a = mVar;
        this.f13351b = (byte) i4;
        this.f13352c = dayOfWeek;
        this.f13353d = kVar;
        this.f13354e = z4;
        this.f13355f = dVar;
        this.f13356g = zoneOffset;
        this.f13357h = zoneOffset2;
        this.f13358i = zoneOffset3;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 3, this);
    }

    final void writeExternal(ObjectOutput objectOutput) {
        k kVar = this.f13353d;
        boolean z4 = this.f13354e;
        int iM0 = z4 ? 86400 : kVar.m0();
        int iZ = this.f13356g.Z();
        ZoneOffset zoneOffset = this.f13357h;
        int iZ2 = zoneOffset.Z() - iZ;
        ZoneOffset zoneOffset2 = this.f13358i;
        int iZ3 = zoneOffset2.Z() - iZ;
        int iT = iM0 % 3600 == 0 ? z4 ? 24 : kVar.T() : 31;
        int i4 = iZ % SQLitePersistence.MAX_ARGS == 0 ? (iZ / SQLitePersistence.MAX_ARGS) + UserMetadata.MAX_ROLLOUT_ASSIGNMENTS : 255;
        int i5 = (iZ2 == 0 || iZ2 == 1800 || iZ2 == 3600) ? iZ2 / 1800 : 3;
        int i6 = (iZ3 == 0 || iZ3 == 1800 || iZ3 == 3600) ? iZ3 / 1800 : 3;
        DayOfWeek dayOfWeek = this.f13352c;
        objectOutput.writeInt((this.f13350a.p() << 28) + ((this.f13351b + 32) << 22) + ((dayOfWeek == null ? 0 : dayOfWeek.p()) << 19) + (iT << 14) + (this.f13355f.ordinal() << 12) + (i4 << 4) + (i5 << 2) + i6);
        if (iT == 31) {
            objectOutput.writeInt(iM0);
        }
        if (i4 == 255) {
            objectOutput.writeInt(iZ);
        }
        if (i5 == 3) {
            objectOutput.writeInt(zoneOffset.Z());
        }
        if (i6 == 3) {
            objectOutput.writeInt(zoneOffset2.Z());
        }
    }

    static e b(ObjectInput objectInput) {
        int i4 = objectInput.readInt();
        m mVarS = m.S(i4 >>> 28);
        int i5 = ((264241152 & i4) >>> 22) - 32;
        int i6 = (3670016 & i4) >>> 19;
        DayOfWeek dayOfWeekR = i6 == 0 ? null : DayOfWeek.r(i6);
        int i7 = (507904 & i4) >>> 14;
        d dVar = d.values()[(i4 & 12288) >>> 12];
        int i8 = (i4 & 4080) >>> 4;
        int i9 = (i4 & 12) >>> 2;
        int i10 = i4 & 3;
        k kVarE0 = i7 == 31 ? k.e0(objectInput.readInt()) : k.b0(i7 % 24);
        ZoneOffset zoneOffsetC0 = ZoneOffset.c0(i8 == 255 ? objectInput.readInt() : (i8 - 128) * SQLitePersistence.MAX_ARGS);
        ZoneOffset zoneOffsetC02 = ZoneOffset.c0(i9 == 3 ? objectInput.readInt() : (i9 * 1800) + zoneOffsetC0.Z());
        ZoneOffset zoneOffsetC03 = i10 == 3 ? ZoneOffset.c0(objectInput.readInt()) : ZoneOffset.c0((i10 * 1800) + zoneOffsetC0.Z());
        boolean z4 = i7 == 24;
        Objects.requireNonNull(mVarS, "month");
        Objects.requireNonNull(kVarE0, com.amazon.a.a.h.a.f8463b);
        Objects.requireNonNull(dVar, "timeDefnition");
        if (i5 < -28 || i5 > 31 || i5 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        }
        if (z4 && !kVarE0.equals(k.f13277g)) {
            throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
        }
        if (kVarE0.Z() != 0) {
            throw new IllegalArgumentException("Time's nano-of-second must be zero");
        }
        return new e(mVarS, i5, dayOfWeekR, kVarE0, z4, dVar, zoneOffsetC0, zoneOffsetC02, zoneOffsetC03);
    }

    public final b a(int i4) {
        j$.time.g gVarH0;
        m mVar = this.f13350a;
        DayOfWeek dayOfWeek = this.f13352c;
        byte b4 = this.f13351b;
        if (b4 < 0) {
            s.f13177d.getClass();
            gVarH0 = j$.time.g.h0(i4, mVar, mVar.C(s.Z(i4)) + 1 + b4);
            if (dayOfWeek != null) {
                gVarH0 = gVarH0.j(new o(dayOfWeek.p(), 1));
            }
        } else {
            gVarH0 = j$.time.g.h0(i4, mVar, b4);
            if (dayOfWeek != null) {
                gVarH0 = gVarH0.j(new o(dayOfWeek.p(), 0));
            }
        }
        if (this.f13354e) {
            gVarH0 = gVarH0.l0(1L);
        }
        LocalDateTime localDateTimeH0 = LocalDateTime.h0(gVarH0, this.f13353d);
        int i5 = c.f13348a[this.f13355f.ordinal()];
        ZoneOffset zoneOffset = this.f13357h;
        if (i5 == 1) {
            localDateTimeH0 = localDateTimeH0.k0(zoneOffset.Z() - ZoneOffset.UTC.Z());
        } else if (i5 == 2) {
            localDateTimeH0 = localDateTimeH0.k0(zoneOffset.Z() - this.f13356g.Z());
        }
        return new b(localDateTimeH0, zoneOffset, this.f13358i);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f13350a == eVar.f13350a && this.f13351b == eVar.f13351b && this.f13352c == eVar.f13352c && this.f13355f == eVar.f13355f && this.f13353d.equals(eVar.f13353d) && this.f13354e == eVar.f13354e && this.f13356g.equals(eVar.f13356g) && this.f13357h.equals(eVar.f13357h) && this.f13358i.equals(eVar.f13358i)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iM0 = ((this.f13353d.m0() + (this.f13354e ? 1 : 0)) << 15) + (this.f13350a.ordinal() << 11) + ((this.f13351b + 32) << 5);
        DayOfWeek dayOfWeek = this.f13352c;
        return ((this.f13356g.hashCode() ^ (this.f13355f.ordinal() + (iM0 + ((dayOfWeek == null ? 7 : dayOfWeek.ordinal()) << 2)))) ^ this.f13357h.hashCode()) ^ this.f13358i.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TransitionRule[");
        ZoneOffset zoneOffset = this.f13357h;
        ZoneOffset zoneOffset2 = this.f13358i;
        sb.append(zoneOffset.compareTo(zoneOffset2) > 0 ? "Gap " : "Overlap ");
        sb.append(zoneOffset);
        sb.append(" to ");
        sb.append(zoneOffset2);
        sb.append(", ");
        m mVar = this.f13350a;
        byte b4 = this.f13351b;
        DayOfWeek dayOfWeek = this.f13352c;
        if (dayOfWeek == null) {
            sb.append(mVar.name());
            sb.append(' ');
            sb.append((int) b4);
        } else if (b4 == -1) {
            sb.append(dayOfWeek.name());
            sb.append(" on or before last day of ");
            sb.append(mVar.name());
        } else if (b4 < 0) {
            sb.append(dayOfWeek.name());
            sb.append(" on or before last day minus ");
            sb.append((-b4) - 1);
            sb.append(" of ");
            sb.append(mVar.name());
        } else {
            sb.append(dayOfWeek.name());
            sb.append(" on or after ");
            sb.append(mVar.name());
            sb.append(' ');
            sb.append((int) b4);
        }
        sb.append(" at ");
        sb.append(this.f13354e ? "24:00" : this.f13353d.toString());
        sb.append(" ");
        sb.append(this.f13355f);
        sb.append(", standard offset ");
        sb.append(this.f13356g);
        sb.append(']');
        return sb.toString();
    }
}
