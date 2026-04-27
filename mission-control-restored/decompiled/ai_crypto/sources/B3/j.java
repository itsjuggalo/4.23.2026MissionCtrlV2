package B3;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f745b = new j(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f746a;

    public j(String str) {
        this.f746a = str;
    }

    public String a() {
        return this.f746a;
    }

    public boolean b() {
        return this.f746a != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        String str = this.f746a;
        String str2 = ((j) obj).f746a;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.f746a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "User(uid:" + this.f746a + ")";
    }
}
