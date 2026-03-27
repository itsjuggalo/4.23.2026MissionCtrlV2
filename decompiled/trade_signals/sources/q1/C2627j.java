package q1;

/* JADX INFO: renamed from: q1.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2627j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class f22535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class f22536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Class f22537c;

    public C2627j() {
    }

    public void a(Class cls, Class cls2, Class cls3) {
        this.f22535a = cls;
        this.f22536b = cls2;
        this.f22537c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2627j c2627j = (C2627j) obj;
        return this.f22535a.equals(c2627j.f22535a) && this.f22536b.equals(c2627j.f22536b) && AbstractC2629l.d(this.f22537c, c2627j.f22537c);
    }

    public int hashCode() {
        int iHashCode = ((this.f22535a.hashCode() * 31) + this.f22536b.hashCode()) * 31;
        Class cls = this.f22537c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f22535a + ", second=" + this.f22536b + '}';
    }

    public C2627j(Class cls, Class cls2, Class cls3) {
        a(cls, cls2, cls3);
    }
}
