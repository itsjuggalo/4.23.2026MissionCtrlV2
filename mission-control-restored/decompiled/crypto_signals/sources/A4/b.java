package A4;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f68a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f69b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f70c;

    public b(a aVar) {
        String str = (String) aVar.f66c;
        this.f68a = (String) aVar.f67d;
        int i = aVar.f65b;
        this.f69b = i == -1 ? str.equals("http") ? 80 : str.equals("https") ? 443 : -1 : i;
        this.f70c = aVar.toString();
    }

    public static int a(char c6) {
        if (c6 >= '0' && c6 <= '9') {
            return c6 - '0';
        }
        if (c6 >= 'a' && c6 <= 'f') {
            return c6 - 'W';
        }
        if (c6 < 'A' || c6 > 'F') {
            return -1;
        }
        return c6 - '7';
    }

    public final boolean equals(Object obj) {
        return (obj instanceof b) && ((b) obj).f70c.equals(this.f70c);
    }

    public final int hashCode() {
        return this.f70c.hashCode();
    }

    public final String toString() {
        return this.f70c;
    }
}
