package j$.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class a extends b implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final a f13130b;
    private static final long serialVersionUID = 6740630888130243051L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ZoneId f13131a;

    a(ZoneId zoneId) {
        this.f13131a = zoneId;
    }

    static {
        System.currentTimeMillis();
        f13130b = new a(ZoneOffset.UTC);
    }

    @Override // j$.time.b
    public final ZoneId a() {
        return this.f13131a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        return this.f13131a.equals(((a) obj).f13131a);
    }

    public final int hashCode() {
        return this.f13131a.hashCode() + 1;
    }

    public final String toString() {
        return "SystemClock[" + this.f13131a + "]";
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
    }
}
