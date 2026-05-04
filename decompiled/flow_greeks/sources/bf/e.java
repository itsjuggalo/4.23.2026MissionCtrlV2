package bf;

import gf.i;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    public static final Object a(i.d dVar, i.f extension) {
        t.f(dVar, "<this>");
        t.f(extension, "extension");
        if (dVar.x(extension)) {
            return dVar.t(extension);
        }
        return null;
    }

    public static final Object b(i.d dVar, i.f extension, int i10) {
        t.f(dVar, "<this>");
        t.f(extension, "extension");
        if (i10 < dVar.w(extension)) {
            return dVar.v(extension, i10);
        }
        return null;
    }
}
