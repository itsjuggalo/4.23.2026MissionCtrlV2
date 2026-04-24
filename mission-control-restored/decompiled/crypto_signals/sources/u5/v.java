package u5;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class v implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10549b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f10550a;

    static {
        String separator = File.separator;
        kotlin.jvm.internal.j.d(separator, "separator");
        f10549b = separator;
    }

    public v(j bytes) {
        kotlin.jvm.internal.j.e(bytes, "bytes");
        this.f10550a = bytes;
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        int iA = v5.c.a(this);
        j jVar = this.f10550a;
        if (iA == -1) {
            iA = 0;
        } else if (iA < jVar.d() && jVar.i(iA) == 92) {
            iA++;
        }
        int iD = jVar.d();
        int i = iA;
        while (iA < iD) {
            if (jVar.i(iA) == 47 || jVar.i(iA) == 92) {
                arrayList.add(jVar.o(i, iA));
                i = iA + 1;
            }
            iA++;
        }
        if (i < jVar.d()) {
            arrayList.add(jVar.o(i, jVar.d()));
        }
        return arrayList;
    }

    public final String b() {
        j jVar = v5.c.f10656a;
        j jVar2 = v5.c.f10656a;
        j jVarP = this.f10550a;
        int iK = j.k(jVarP, jVar2);
        if (iK == -1) {
            iK = j.k(jVarP, v5.c.f10657b);
        }
        if (iK != -1) {
            jVarP = j.p(jVarP, iK + 1, 0, 2);
        } else if (g() != null && jVarP.d() == 2) {
            jVarP = j.f10527d;
        }
        return jVarP.s();
    }

    public final v c() {
        j jVar = v5.c.f10659d;
        j jVar2 = this.f10550a;
        if (kotlin.jvm.internal.j.a(jVar2, jVar)) {
            return null;
        }
        j jVar3 = v5.c.f10656a;
        if (kotlin.jvm.internal.j.a(jVar2, jVar3)) {
            return null;
        }
        j prefix = v5.c.f10657b;
        if (kotlin.jvm.internal.j.a(jVar2, prefix)) {
            return null;
        }
        j suffix = v5.c.e;
        jVar2.getClass();
        kotlin.jvm.internal.j.e(suffix, "suffix");
        int iD = jVar2.d();
        byte[] bArr = suffix.f10528a;
        if (jVar2.m(iD - bArr.length, suffix, bArr.length) && (jVar2.d() == 2 || jVar2.m(jVar2.d() - 3, jVar3, 1) || jVar2.m(jVar2.d() - 3, prefix, 1))) {
            return null;
        }
        int iK = j.k(jVar2, jVar3);
        if (iK == -1) {
            iK = j.k(jVar2, prefix);
        }
        if (iK == 2 && g() != null) {
            if (jVar2.d() == 3) {
                return null;
            }
            return new v(j.p(jVar2, 0, 3, 1));
        }
        if (iK == 1) {
            kotlin.jvm.internal.j.e(prefix, "prefix");
            if (jVar2.m(0, prefix, prefix.f10528a.length)) {
                return null;
            }
        }
        if (iK != -1 || g() == null) {
            return iK == -1 ? new v(jVar) : iK == 0 ? new v(j.p(jVar2, 0, 1, 1)) : new v(j.p(jVar2, 0, iK, 1));
        }
        if (jVar2.d() == 2) {
            return null;
        }
        return new v(j.p(jVar2, 0, 2, 1));
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        v other = (v) obj;
        kotlin.jvm.internal.j.e(other, "other");
        return this.f10550a.compareTo(other.f10550a);
    }

    public final v d(String child) {
        kotlin.jvm.internal.j.e(child, "child");
        C1250g c1250g = new C1250g();
        c1250g.E(child);
        return v5.c.b(this, v5.c.d(c1250g, false), false);
    }

    public final File e() {
        return new File(this.f10550a.s());
    }

    public final boolean equals(Object obj) {
        return (obj instanceof v) && kotlin.jvm.internal.j.a(((v) obj).f10550a, this.f10550a);
    }

    public final Path f() {
        Path path = Paths.get(this.f10550a.s(), new String[0]);
        kotlin.jvm.internal.j.d(path, "get(toString())");
        return path;
    }

    public final Character g() {
        j jVar = v5.c.f10656a;
        j jVar2 = this.f10550a;
        if (j.g(jVar2, jVar) != -1 || jVar2.d() < 2 || jVar2.i(1) != 58) {
            return null;
        }
        char cI = (char) jVar2.i(0);
        if (('a' > cI || cI >= '{') && ('A' > cI || cI >= '[')) {
            return null;
        }
        return Character.valueOf(cI);
    }

    public final int hashCode() {
        return this.f10550a.hashCode();
    }

    public final String toString() {
        return this.f10550a.s();
    }
}
