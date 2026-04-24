package i3;

/* JADX INFO: loaded from: classes.dex */
public final class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f6840d;

    public G(int i, int i6, String str, boolean z6) {
        this.f6837a = str;
        this.f6838b = i;
        this.f6839c = i6;
        this.f6840d = z6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof G)) {
            return false;
        }
        G g2 = (G) obj;
        return kotlin.jvm.internal.j.a(this.f6837a, g2.f6837a) && this.f6838b == g2.f6838b && this.f6839c == g2.f6839c && this.f6840d == g2.f6840d;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f6840d) + ((Integer.hashCode(this.f6839c) + ((Integer.hashCode(this.f6838b) + (this.f6837a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ProcessDetails(processName=" + this.f6837a + ", pid=" + this.f6838b + ", importance=" + this.f6839c + ", isDefaultProcess=" + this.f6840d + ')';
    }
}
