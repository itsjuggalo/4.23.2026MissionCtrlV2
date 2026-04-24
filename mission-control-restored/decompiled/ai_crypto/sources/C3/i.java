package C3;

import D3.c0;
import D3.h0;

/* JADX INFO: loaded from: classes.dex */
public class i implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f1058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0.a f1059b;

    public i(h0 h0Var, c0.a aVar) {
        this.f1058a = h0Var;
        this.f1059b = aVar;
    }

    public c0.a a() {
        return this.f1059b;
    }

    public h0 b() {
        return this.f1058a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f1058a.equals(iVar.f1058a) && this.f1059b == iVar.f1059b;
    }

    public int hashCode() {
        return (this.f1058a.hashCode() * 31) + this.f1059b.hashCode();
    }
}
