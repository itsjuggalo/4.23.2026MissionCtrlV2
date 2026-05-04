package j$.time.zone;

import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Comparable, Serializable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f13779e = 0;
    private static final long serialVersionUID = -6946044323557704546L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LocalDateTime f13781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ZoneOffset f13782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ZoneOffset f13783d;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Long.compare(this.f13780a, ((b) obj).f13780a);
    }

    public b(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f13780a = localDateTime.w(zoneOffset);
        this.f13781b = localDateTime;
        this.f13782c = zoneOffset;
        this.f13783d = zoneOffset2;
    }

    public b(long j10, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f13780a = j10;
        this.f13781b = LocalDateTime.P(j10, 0, zoneOffset);
        this.f13782c = zoneOffset;
        this.f13783d = zoneOffset2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 2, this);
    }

    public final boolean s() {
        return this.f13783d.f13556b > this.f13782c.f13556b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f13780a == bVar.f13780a && this.f13782c.equals(bVar.f13782c) && this.f13783d.equals(bVar.f13783d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f13781b.hashCode() ^ this.f13782c.f13556b) ^ Integer.rotateLeft(this.f13783d.f13556b, 16);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Transition[");
        sb2.append(s() ? "Gap" : "Overlap");
        sb2.append(" at ");
        sb2.append(this.f13781b);
        sb2.append(this.f13782c);
        sb2.append(" to ");
        sb2.append(this.f13783d);
        sb2.append(']');
        return sb2.toString();
    }
}
