package D3;

import D3.C0443m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f1470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final G3.m f1471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final G3.m f1472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f1473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f1474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r3.e f1475f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f1476g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1477h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1478i;

    public enum a {
        NONE,
        LOCAL,
        SYNCED
    }

    public z0(c0 c0Var, G3.m mVar, G3.m mVar2, List list, boolean z7, r3.e eVar, boolean z8, boolean z9, boolean z10) {
        this.f1470a = c0Var;
        this.f1471b = mVar;
        this.f1472c = mVar2;
        this.f1473d = list;
        this.f1474e = z7;
        this.f1475f = eVar;
        this.f1476g = z8;
        this.f1477h = z9;
        this.f1478i = z10;
    }

    public static z0 c(c0 c0Var, G3.m mVar, r3.e eVar, boolean z7, boolean z8, boolean z9) {
        ArrayList arrayList = new ArrayList();
        Iterator it = mVar.iterator();
        while (it.hasNext()) {
            arrayList.add(C0443m.a(C0443m.a.ADDED, (G3.h) it.next()));
        }
        return new z0(c0Var, mVar, G3.m.c(c0Var.c()), arrayList, z7, eVar, true, z8, z9);
    }

    public boolean a() {
        return this.f1476g;
    }

    public boolean b() {
        return this.f1477h;
    }

    public List d() {
        return this.f1473d;
    }

    public G3.m e() {
        return this.f1471b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z0)) {
            return false;
        }
        z0 z0Var = (z0) obj;
        if (this.f1474e == z0Var.f1474e && this.f1476g == z0Var.f1476g && this.f1477h == z0Var.f1477h && this.f1470a.equals(z0Var.f1470a) && this.f1475f.equals(z0Var.f1475f) && this.f1471b.equals(z0Var.f1471b) && this.f1472c.equals(z0Var.f1472c) && this.f1478i == z0Var.f1478i) {
            return this.f1473d.equals(z0Var.f1473d);
        }
        return false;
    }

    public r3.e f() {
        return this.f1475f;
    }

    public G3.m g() {
        return this.f1472c;
    }

    public c0 h() {
        return this.f1470a;
    }

    public int hashCode() {
        return (((((((((((((((this.f1470a.hashCode() * 31) + this.f1471b.hashCode()) * 31) + this.f1472c.hashCode()) * 31) + this.f1473d.hashCode()) * 31) + this.f1475f.hashCode()) * 31) + (this.f1474e ? 1 : 0)) * 31) + (this.f1476g ? 1 : 0)) * 31) + (this.f1477h ? 1 : 0)) * 31) + (this.f1478i ? 1 : 0);
    }

    public boolean i() {
        return this.f1478i;
    }

    public boolean j() {
        return !this.f1475f.isEmpty();
    }

    public boolean k() {
        return this.f1474e;
    }

    public String toString() {
        return "ViewSnapshot(" + this.f1470a + ", " + this.f1471b + ", " + this.f1472c + ", " + this.f1473d + ", isFromCache=" + this.f1474e + ", mutatedKeys=" + this.f1475f.size() + ", didSyncStateChange=" + this.f1476g + ", excludesMetadataChanges=" + this.f1477h + ", hasCachedResults=" + this.f1478i + ")";
    }
}
