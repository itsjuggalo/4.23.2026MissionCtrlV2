package c4;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class f3594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class f3595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Class f3596c;

    public j() {
    }

    public void a(Class cls, Class cls2, Class cls3) {
        this.f3594a = cls;
        this.f3595b = cls2;
        this.f3596c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.f3594a.equals(jVar.f3594a) && this.f3595b.equals(jVar.f3595b) && l.d(this.f3596c, jVar.f3596c);
    }

    public int hashCode() {
        int iHashCode = ((this.f3594a.hashCode() * 31) + this.f3595b.hashCode()) * 31;
        Class cls = this.f3596c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f3594a + ", second=" + this.f3595b + '}';
    }

    public j(Class cls, Class cls2, Class cls3) {
        a(cls, cls2, cls3);
    }
}
