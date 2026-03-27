package j$.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
final class a extends b implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final a f17089b;
    private static final long serialVersionUID = 6740630888130243051L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ZoneId f17090a;

    static {
        System.currentTimeMillis();
        f17089b = new a(ZoneOffset.UTC);
    }

    a(ZoneId zoneId) {
        this.f17090a = zoneId;
    }

    @Override // j$.time.b
    public final ZoneId a() {
        return this.f17090a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        return this.f17090a.equals(((a) obj).f17090a);
    }

    public final int hashCode() {
        return this.f17090a.hashCode() + 1;
    }

    public final String toString() {
        return "SystemClock[" + this.f17090a + "]";
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
    }
}
