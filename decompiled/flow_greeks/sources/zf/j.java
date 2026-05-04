package zf;

import dd.r;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.t;
import xf.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f26497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f26498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f26499c;

    public j(k kind, String... formatParams) {
        t.f(kind, "kind");
        t.f(formatParams, "formatParams");
        this.f26497a = kind;
        this.f26498b = formatParams;
        String strB = b.f26461g.b();
        String strB2 = kind.b();
        Object[] objArrCopyOf = Arrays.copyOf(formatParams, formatParams.length);
        String str = String.format(strB2, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        t.e(str, "format(...)");
        String str2 = String.format(strB, Arrays.copyOf(new Object[]{str}, 1));
        t.e(str2, "format(...)");
        this.f26499c = str2;
    }

    @Override // xf.u1
    public u1 a(yf.g kotlinTypeRefiner) {
        t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // xf.u1
    public fe.h b() {
        return l.f26552a.h();
    }

    @Override // xf.u1
    public Collection c() {
        return r.k();
    }

    @Override // xf.u1
    public boolean d() {
        return false;
    }

    public final k f() {
        return this.f26497a;
    }

    public final String g(int i10) {
        return this.f26498b[i10];
    }

    @Override // xf.u1
    public List getParameters() {
        return r.k();
    }

    @Override // xf.u1
    public ce.i p() {
        return ce.g.f3898h.a();
    }

    public String toString() {
        return this.f26499c;
    }
}
