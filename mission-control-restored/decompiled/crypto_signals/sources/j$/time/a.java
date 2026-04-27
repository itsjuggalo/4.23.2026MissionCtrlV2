package j$.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class a extends b implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final a f7378b;
    private static final long serialVersionUID = 6740630888130243051L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ZoneId f7379a;

    a(ZoneId zoneId) {
        this.f7379a = zoneId;
    }

    static {
        System.currentTimeMillis();
        f7378b = new a(ZoneOffset.UTC);
    }

    @Override // j$.time.b
    public final ZoneId a() {
        return this.f7379a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        return this.f7379a.equals(((a) obj).f7379a);
    }

    public final int hashCode() {
        return this.f7379a.hashCode() + 1;
    }

    public final String toString() {
        return "SystemClock[" + this.f7379a + "]";
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
    }
}
