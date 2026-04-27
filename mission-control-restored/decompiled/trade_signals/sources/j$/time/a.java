package j$.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
final class a extends b implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final a f19664b;
    private static final long serialVersionUID = 6740630888130243051L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ZoneId f19665a;

    static {
        System.currentTimeMillis();
        f19664b = new a(ZoneOffset.UTC);
    }

    a(ZoneId zoneId) {
        this.f19665a = zoneId;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
    }

    @Override // j$.time.b
    public final ZoneId a() {
        return this.f19665a;
    }

    @Override // j$.time.b
    public final long b() {
        return System.currentTimeMillis();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        return this.f19665a.equals(((a) obj).f19665a);
    }

    public final int hashCode() {
        return this.f19665a.hashCode() + 1;
    }

    public final String toString() {
        return "SystemClock[" + this.f19665a + "]";
    }
}
