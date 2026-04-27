package t2;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import q2.w;
import t2.l;
import x2.C1925a;
import y2.C1946a;

/* JADX INFO: loaded from: classes.dex */
public final class o extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q2.e f14833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f14834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type f14835c;

    public o(q2.e eVar, w wVar, Type type) {
        this.f14833a = eVar;
        this.f14834b = wVar;
        this.f14835c = type;
    }

    public static Type f(Type type, Object obj) {
        return obj != null ? ((type instanceof Class) || (type instanceof TypeVariable)) ? obj.getClass() : type : type;
    }

    public static boolean g(w wVar) {
        w wVarF;
        while ((wVar instanceof m) && (wVarF = ((m) wVar).f()) != wVar) {
            wVar = wVarF;
        }
        return wVar instanceof l.c;
    }

    @Override // q2.w
    public Object c(C1946a c1946a) {
        return this.f14834b.c(c1946a);
    }

    @Override // q2.w
    public void e(y2.c cVar, Object obj) {
        w wVarL = this.f14834b;
        Type typeF = f(this.f14835c, obj);
        if (typeF != this.f14835c) {
            wVarL = this.f14833a.l(C1925a.b(typeF));
            if ((wVarL instanceof l.c) && !g(this.f14834b)) {
                wVarL = this.f14834b;
            }
        }
        wVarL.e(cVar, obj);
    }
}
