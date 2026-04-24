package C3;

import G3.v;

/* JADX INFO: loaded from: classes.dex */
public class j implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f1061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f1062c;

    public j(String str, i iVar, v vVar) {
        this.f1060a = str;
        this.f1061b = iVar;
        this.f1062c = vVar;
    }

    public i a() {
        return this.f1061b;
    }

    public String b() {
        return this.f1060a;
    }

    public v c() {
        return this.f1062c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f1060a.equals(jVar.f1060a) && this.f1061b.equals(jVar.f1061b)) {
            return this.f1062c.equals(jVar.f1062c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f1060a.hashCode() * 31) + this.f1061b.hashCode()) * 31) + this.f1062c.hashCode();
    }
}
