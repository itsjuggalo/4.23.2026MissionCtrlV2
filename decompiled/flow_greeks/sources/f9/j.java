package f9;

import j9.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f9439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f9440c;

    public j(String str, i iVar, v vVar) {
        this.f9438a = str;
        this.f9439b = iVar;
        this.f9440c = vVar;
    }

    public i a() {
        return this.f9439b;
    }

    public String b() {
        return this.f9438a;
    }

    public v c() {
        return this.f9440c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f9438a.equals(jVar.f9438a) && this.f9439b.equals(jVar.f9439b)) {
            return this.f9440c.equals(jVar.f9440c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f9438a.hashCode() * 31) + this.f9439b.hashCode()) * 31) + this.f9440c.hashCode();
    }
}
