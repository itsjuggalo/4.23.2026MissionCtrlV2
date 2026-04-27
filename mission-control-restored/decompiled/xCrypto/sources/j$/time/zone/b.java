package j$.time.zone;

import j$.time.Duration;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Comparable, Serializable {
    private static final long serialVersionUID = -6946044323557704546L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f13344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LocalDateTime f13345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ZoneOffset f13346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ZoneOffset f13347d;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Long.compare(this.f13344a, ((b) obj).f13344a);
    }

    b(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f13344a = localDateTime.Y(zoneOffset);
        this.f13345b = localDateTime;
        this.f13346c = zoneOffset;
        this.f13347d = zoneOffset2;
    }

    b(long j4, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f13344a = j4;
        this.f13345b = LocalDateTime.i0(j4, 0, zoneOffset);
        this.f13346c = zoneOffset;
        this.f13347d = zoneOffset2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 2, this);
    }

    final void writeExternal(ObjectOutput objectOutput) {
        a.c(this.f13344a, objectOutput);
        a.d(this.f13346c, objectOutput);
        a.d(this.f13347d, objectOutput);
    }

    public final long O() {
        return this.f13344a;
    }

    public final LocalDateTime r() {
        return this.f13345b;
    }

    public final ZoneOffset S() {
        return this.f13346c;
    }

    public final ZoneOffset J() {
        return this.f13347d;
    }

    public final Duration C() {
        return Duration.S(this.f13347d.Z() - this.f13346c.Z());
    }

    public final LocalDateTime p() {
        return this.f13345b.k0(this.f13347d.Z() - this.f13346c.Z());
    }

    public final boolean W() {
        return this.f13347d.Z() > this.f13346c.Z();
    }

    final List T() {
        return W() ? Collections.EMPTY_LIST : j$.time.b.b(new Object[]{this.f13346c, this.f13347d});
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f13344a == bVar.f13344a && this.f13346c.equals(bVar.f13346c) && this.f13347d.equals(bVar.f13347d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f13345b.hashCode() ^ this.f13346c.hashCode()) ^ Integer.rotateLeft(this.f13347d.hashCode(), 16);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Transition[");
        sb.append(W() ? "Gap" : "Overlap");
        sb.append(" at ");
        sb.append(this.f13345b);
        sb.append(this.f13346c);
        sb.append(" to ");
        sb.append(this.f13347d);
        sb.append(']');
        return sb.toString();
    }
}
