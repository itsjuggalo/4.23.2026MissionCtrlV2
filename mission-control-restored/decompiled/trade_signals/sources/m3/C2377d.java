package m3;

import h3.AbstractC1872h;
import h3.C1875k;
import m3.e;

/* JADX INFO: renamed from: m3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2377d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e.a f21409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC1872h f21410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c3.b f21411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f21412d;

    public C2377d(e.a aVar, AbstractC1872h abstractC1872h, c3.b bVar, String str) {
        this.f21409a = aVar;
        this.f21410b = abstractC1872h;
        this.f21411c = bVar;
        this.f21412d = str;
    }

    @Override // m3.e
    public void a() {
        this.f21410b.d(this);
    }

    public e.a b() {
        return this.f21409a;
    }

    public C1875k c() {
        C1875k c1875kS = this.f21411c.g().s();
        return this.f21409a == e.a.VALUE ? c1875kS : c1875kS.Q();
    }

    public String d() {
        return this.f21412d;
    }

    public c3.b e() {
        return this.f21411c;
    }

    @Override // m3.e
    public String toString() {
        StringBuilder sb;
        if (this.f21409a == e.a.VALUE) {
            sb = new StringBuilder();
            sb.append(c());
            sb.append(": ");
            sb.append(this.f21409a);
            sb.append(": ");
            sb.append(this.f21411c.i(true));
        } else {
            sb = new StringBuilder();
            sb.append(c());
            sb.append(": ");
            sb.append(this.f21409a);
            sb.append(": { ");
            sb.append(this.f21411c.e());
            sb.append(": ");
            sb.append(this.f21411c.i(true));
            sb.append(" }");
        }
        return sb.toString();
    }
}
