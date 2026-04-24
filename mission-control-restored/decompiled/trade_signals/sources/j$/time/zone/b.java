package j$.time.zone;

import j$.time.Duration;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Comparable, Serializable {
    private static final long serialVersionUID = -6946044323557704546L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f19882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LocalDateTime f19883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ZoneOffset f19884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ZoneOffset f19885d;

    b(long j8, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f19882a = j8;
        this.f19883b = LocalDateTime.g0(j8, 0, zoneOffset);
        this.f19884c = zoneOffset;
        this.f19885d = zoneOffset2;
    }

    b(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f19882a = localDateTime.W(zoneOffset);
        this.f19883b = localDateTime;
        this.f19884c = zoneOffset;
        this.f19885d = zoneOffset2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 2, this);
    }

    public final Duration A() {
        return Duration.M(this.f19885d.X() - this.f19884c.X());
    }

    public final ZoneOffset H() {
        return this.f19885d;
    }

    public final ZoneOffset M() {
        return this.f19884c;
    }

    public final long N() {
        return this.f19882a;
    }

    final List R() {
        return U() ? Collections.emptyList() : j$.time.e.a(new Object[]{this.f19884c, this.f19885d});
    }

    public final boolean U() {
        return this.f19885d.X() > this.f19884c.X();
    }

    final void X(DataOutput dataOutput) {
        a.c(this.f19882a, dataOutput);
        a.d(this.f19884c, dataOutput);
        a.d(this.f19885d, dataOutput);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Long.compare(this.f19882a, ((b) obj).f19882a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f19882a == bVar.f19882a && this.f19884c.equals(bVar.f19884c) && this.f19885d.equals(bVar.f19885d);
    }

    public final int hashCode() {
        return (this.f19883b.hashCode() ^ this.f19884c.hashCode()) ^ Integer.rotateLeft(this.f19885d.hashCode(), 16);
    }

    public final LocalDateTime o() {
        return this.f19883b.i0(this.f19885d.X() - this.f19884c.X());
    }

    public final LocalDateTime q() {
        return this.f19883b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Transition[");
        sb.append(U() ? "Gap" : "Overlap");
        sb.append(" at ");
        sb.append(this.f19883b);
        sb.append(this.f19884c);
        sb.append(" to ");
        sb.append(this.f19885d);
        sb.append(']');
        return sb.toString();
    }
}
