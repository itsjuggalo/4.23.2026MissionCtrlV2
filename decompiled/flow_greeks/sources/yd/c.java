package yd;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import kotlin.jvm.internal.t;
import wd.h;
import wd.i;
import wd.m;
import wd.q;
import wd.x;
import zd.a0;
import zd.i3;
import zd.j2;
import zd.t2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static final Constructor a(h hVar) {
        ae.h hVarO;
        t.f(hVar, "<this>");
        a0 a0VarB = i3.b(hVar);
        Member memberB = (a0VarB == null || (hVarO = a0VarB.O()) == null) ? null : hVarO.b();
        if (memberB instanceof Constructor) {
            return (Constructor) memberB;
        }
        return null;
    }

    public static final Field b(m mVar) {
        t.f(mVar, "<this>");
        j2 j2VarD = i3.d(mVar);
        if (j2VarD != null) {
            return j2VarD.f0();
        }
        return null;
    }

    public static final Method c(m mVar) {
        t.f(mVar, "<this>");
        return d(mVar.e0());
    }

    public static final Method d(h hVar) {
        ae.h hVarO;
        t.f(hVar, "<this>");
        a0 a0VarB = i3.b(hVar);
        Member memberB = (a0VarB == null || (hVarO = a0VarB.O()) == null) ? null : hVarO.b();
        if (memberB instanceof Method) {
            return (Method) memberB;
        }
        return null;
    }

    public static final Method e(i iVar) {
        t.f(iVar, "<this>");
        return d(iVar.g());
    }

    public static final Type f(q qVar) {
        t.f(qVar, "<this>");
        Type typeK = ((t2) qVar).k();
        return typeK == null ? x.f(qVar) : typeK;
    }
}
