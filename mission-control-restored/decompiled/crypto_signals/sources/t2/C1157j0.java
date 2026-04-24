package t2;

/* JADX INFO: renamed from: t2.j0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1157j0 extends L0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f10142d;

    public C1157j0(int i, String str, String str2, boolean z6) {
        this.f10139a = i;
        this.f10140b = str;
        this.f10141c = str2;
        this.f10142d = z6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof L0) {
            L0 l02 = (L0) obj;
            if (this.f10139a == ((C1157j0) l02).f10139a) {
                C1157j0 c1157j0 = (C1157j0) l02;
                if (this.f10140b.equals(c1157j0.f10140b) && this.f10141c.equals(c1157j0.f10141c) && this.f10142d == c1157j0.f10142d) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f10139a ^ 1000003) * 1000003) ^ this.f10140b.hashCode()) * 1000003) ^ this.f10141c.hashCode()) * 1000003) ^ (this.f10142d ? 1231 : 1237);
    }

    public final String toString() {
        return "OperatingSystem{platform=" + this.f10139a + ", version=" + this.f10140b + ", buildVersion=" + this.f10141c + ", jailbroken=" + this.f10142d + "}";
    }
}
