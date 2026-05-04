package com.amazon.a.b.a;

import com.amazon.a.a.d.b;
import com.amazon.a.a.o.b.f;
import com.amazon.a.a.o.d.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f4649a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f4650b;

    public a(c cVar) {
        super("LICENSE_VERIFICATION_FAILURE", "VERIFICATION_ERRORS", a(cVar));
        com.amazon.a.a.o.a.a.a(cVar.a(), "Created a verification exception with a Verifier that has no errors");
        this.f4650b = cVar;
    }

    private static String a(c cVar) {
        StringBuilder sb2 = new StringBuilder();
        for (com.amazon.a.a.o.d.a aVar : cVar) {
            if (sb2.length() != 0) {
                sb2.append(f.f4598a);
            }
            sb2.append(aVar.a().a());
        }
        return sb2.toString();
    }

    public c d() {
        return this.f4650b;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return this.f4650b.toString();
    }
}
