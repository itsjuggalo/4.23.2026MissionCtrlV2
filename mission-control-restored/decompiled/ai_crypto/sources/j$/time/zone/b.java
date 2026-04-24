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

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Comparable, Serializable {
    private static final long serialVersionUID = -6946044323557704546L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f17305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LocalDateTime f17306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ZoneOffset f17307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ZoneOffset f17308d;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Long.compare(this.f17305a, ((b) obj).f17305a);
    }

    b(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f17305a = localDateTime.Y(zoneOffset);
        this.f17306b = localDateTime;
        this.f17307c = zoneOffset;
        this.f17308d = zoneOffset2;
    }

    b(long j7, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f17305a = j7;
        this.f17306b = LocalDateTime.i0(j7, 0, zoneOffset);
        this.f17307c = zoneOffset;
        this.f17308d = zoneOffset2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 2, this);
    }

    final void writeExternal(ObjectOutput objectOutput) {
        a.c(this.f17305a, objectOutput);
        a.d(this.f17307c, objectOutput);
        a.d(this.f17308d, objectOutput);
    }

    public final long O() {
        return this.f17305a;
    }

    public final LocalDateTime r() {
        return this.f17306b;
    }

    public final ZoneOffset S() {
        return this.f17307c;
    }

    public final ZoneOffset J() {
        return this.f17308d;
    }

    public final Duration C() {
        return Duration.S(this.f17308d.Z() - this.f17307c.Z());
    }

    public final LocalDateTime p() {
        return this.f17306b.k0(this.f17308d.Z() - this.f17307c.Z());
    }

    public final boolean W() {
        return this.f17308d.Z() > this.f17307c.Z();
    }

    final List T() {
        return W() ? Collections.emptyList() : j$.time.e.a(new Object[]{this.f17307c, this.f17308d});
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f17305a == bVar.f17305a && this.f17307c.equals(bVar.f17307c) && this.f17308d.equals(bVar.f17308d);
    }

    public final int hashCode() {
        return (this.f17306b.hashCode() ^ this.f17307c.hashCode()) ^ Integer.rotateLeft(this.f17308d.hashCode(), 16);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Transition[");
        sb.append(W() ? "Gap" : "Overlap");
        sb.append(" at ");
        sb.append(this.f17306b);
        sb.append(this.f17307c);
        sb.append(" to ");
        sb.append(this.f17308d);
        sb.append(']');
        return sb.toString();
    }
}
