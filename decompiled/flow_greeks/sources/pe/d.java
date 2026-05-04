package pe;

import cd.w;
import ce.o;
import dd.o0;
import ef.b;
import io.flutter.plugins.firebase.database.Constants;
import java.util.Map;
import kotlin.jvm.internal.t;
import oe.i0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f18592a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ef.f f18593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ef.f f18594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ef.f f18595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map f18596e;

    static {
        ef.f fVarK = ef.f.k(Constants.ERROR_MESSAGE);
        t.e(fVarK, "identifier(...)");
        f18593b = fVarK;
        ef.f fVarK2 = ef.f.k("allowedTargets");
        t.e(fVarK2, "identifier(...)");
        f18594c = fVarK2;
        ef.f fVarK3 = ef.f.k("value");
        t.e(fVarK3, "identifier(...)");
        f18595d = fVarK3;
        f18596e = o0.l(w.a(o.a.H, i0.f17984d), w.a(o.a.L, i0.f17986f), w.a(o.a.P, i0.f17989i));
    }

    public static /* synthetic */ ge.c f(d dVar, ve.a aVar, re.k kVar, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return dVar.e(aVar, kVar, z10);
    }

    public final ge.c a(ef.c kotlinName, ve.d annotationOwner, re.k c10) {
        ve.a aVarB;
        t.f(kotlinName, "kotlinName");
        t.f(annotationOwner, "annotationOwner");
        t.f(c10, "c");
        if (t.b(kotlinName, o.a.f4021y)) {
            ef.c DEPRECATED_ANNOTATION = i0.f17988h;
            t.e(DEPRECATED_ANNOTATION, "DEPRECATED_ANNOTATION");
            ve.a aVarB2 = annotationOwner.b(DEPRECATED_ANNOTATION);
            if (aVarB2 != null || annotationOwner.n()) {
                return new h(aVarB2, c10);
            }
        }
        ef.c cVar = (ef.c) f18596e.get(kotlinName);
        if (cVar == null || (aVarB = annotationOwner.b(cVar)) == null) {
            return null;
        }
        return f(f18592a, aVarB, c10, false, 4, null);
    }

    public final ef.f b() {
        return f18593b;
    }

    public final ef.f c() {
        return f18595d;
    }

    public final ef.f d() {
        return f18594c;
    }

    public final ge.c e(ve.a annotation, re.k c10, boolean z10) {
        t.f(annotation, "annotation");
        t.f(c10, "c");
        ef.b bVarG = annotation.g();
        b.a aVar = ef.b.f8779d;
        ef.c TARGET_ANNOTATION = i0.f17984d;
        t.e(TARGET_ANNOTATION, "TARGET_ANNOTATION");
        if (t.b(bVarG, aVar.c(TARGET_ANNOTATION))) {
            return new n(annotation, c10);
        }
        ef.c RETENTION_ANNOTATION = i0.f17986f;
        t.e(RETENTION_ANNOTATION, "RETENTION_ANNOTATION");
        if (t.b(bVarG, aVar.c(RETENTION_ANNOTATION))) {
            return new l(annotation, c10);
        }
        ef.c DOCUMENTED_ANNOTATION = i0.f17989i;
        t.e(DOCUMENTED_ANNOTATION, "DOCUMENTED_ANNOTATION");
        if (t.b(bVarG, aVar.c(DOCUMENTED_ANNOTATION))) {
            return new c(c10, annotation, o.a.P);
        }
        ef.c DEPRECATED_ANNOTATION = i0.f17988h;
        t.e(DEPRECATED_ANNOTATION, "DEPRECATED_ANNOTATION");
        if (t.b(bVarG, aVar.c(DEPRECATED_ANNOTATION))) {
            return null;
        }
        return new se.j(c10, annotation, z10);
    }
}
