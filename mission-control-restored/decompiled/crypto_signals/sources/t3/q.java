package t3;

import java.io.IOException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f10250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f10251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ q[] f10252c;

    static {
        m mVar = new m();
        f10250a = mVar;
        n nVar = new n();
        f10251b = nVar;
        f10252c = new q[]{mVar, nVar, new q() { // from class: t3.o
            public static Double b(String str, B3.a aVar) throws B3.c {
                try {
                    Double dValueOf = Double.valueOf(str);
                    if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                        boolean z6 = true;
                        if (aVar.f160s != 1) {
                            z6 = false;
                        }
                        if (!z6) {
                            throw new B3.c("JSON forbids NaN and infinities: " + dValueOf + "; at path " + aVar.n());
                        }
                    }
                    return dValueOf;
                } catch (NumberFormatException e) {
                    StringBuilder sbP = a3.d.p("Cannot parse ", str, "; at path ");
                    sbP.append(aVar.n());
                    throw new G4.e(sbP.toString(), e);
                }
            }

            @Override // t3.q
            public final Number a(B3.a aVar) throws IOException {
                String strZ = aVar.z();
                if (strZ.indexOf(46) >= 0) {
                    return b(strZ, aVar);
                }
                try {
                    return Long.valueOf(Long.parseLong(strZ));
                } catch (NumberFormatException unused) {
                    return b(strZ, aVar);
                }
            }
        }, new q() { // from class: t3.p
            @Override // t3.q
            public final Number a(B3.a aVar) throws IOException {
                String strZ = aVar.z();
                try {
                    return v3.d.j(strZ);
                } catch (NumberFormatException e) {
                    StringBuilder sbP = a3.d.p("Cannot parse ", strZ, "; at path ");
                    sbP.append(aVar.n());
                    throw new G4.e(sbP.toString(), e);
                }
            }
        }};
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) f10252c.clone();
    }

    public abstract Number a(B3.a aVar);
}
