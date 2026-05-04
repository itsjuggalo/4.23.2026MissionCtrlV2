package e9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f8544b = new j(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8545a;

    public j(String str) {
        this.f8545a = str;
    }

    public String a() {
        return this.f8545a;
    }

    public boolean b() {
        return this.f8545a != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && j.class == obj.getClass()) {
            String str = this.f8545a;
            String str2 = ((j) obj).f8545a;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f8545a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "User(uid:" + this.f8545a + ")";
    }
}
