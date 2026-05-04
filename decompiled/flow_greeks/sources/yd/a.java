package yd;

import ae.h;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.jvm.internal.t;
import wd.i;
import wd.m;
import zd.a0;
import zd.i3;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final boolean a(wd.c cVar) {
        h hVarQ;
        t.f(cVar, "<this>");
        if (cVar instanceof i) {
            m mVar = (m) cVar;
            Field fieldB = c.b(mVar);
            if (fieldB != null ? fieldB.isAccessible() : true) {
                Method methodC = c.c(mVar);
                if (methodC != null ? methodC.isAccessible() : true) {
                    Method methodE = c.e((i) cVar);
                    if (methodE != null ? methodE.isAccessible() : true) {
                        return true;
                    }
                }
            }
            return false;
        }
        if (cVar instanceof m) {
            m mVar2 = (m) cVar;
            Field fieldB2 = c.b(mVar2);
            if (fieldB2 != null ? fieldB2.isAccessible() : true) {
                Method methodC2 = c.c(mVar2);
                if (methodC2 != null ? methodC2.isAccessible() : true) {
                    return true;
                }
            }
            return false;
        }
        if (cVar instanceof m.b) {
            Field fieldB3 = c.b(((m.b) cVar).o());
            if (fieldB3 != null ? fieldB3.isAccessible() : true) {
                Method methodD = c.d((wd.h) cVar);
                if (methodD != null ? methodD.isAccessible() : true) {
                    return true;
                }
            }
            return false;
        }
        if (cVar instanceof i.a) {
            Field fieldB4 = c.b(((i.a) cVar).o());
            if (fieldB4 != null ? fieldB4.isAccessible() : true) {
                Method methodD2 = c.d((wd.h) cVar);
                if (methodD2 != null ? methodD2.isAccessible() : true) {
                    return true;
                }
            }
            return false;
        }
        if (!(cVar instanceof wd.h)) {
            throw new UnsupportedOperationException("Unknown callable: " + cVar + " (" + cVar.getClass() + ')');
        }
        wd.h hVar = (wd.h) cVar;
        Method methodD3 = c.d(hVar);
        if (methodD3 != null ? methodD3.isAccessible() : true) {
            a0 a0VarB = i3.b(cVar);
            Member memberB = (a0VarB == null || (hVarQ = a0VarB.Q()) == null) ? null : hVarQ.b();
            AccessibleObject accessibleObject = memberB instanceof AccessibleObject ? (AccessibleObject) memberB : null;
            if (accessibleObject != null ? accessibleObject.isAccessible() : true) {
                Constructor constructorA = c.a(hVar);
                if (constructorA != null ? constructorA.isAccessible() : true) {
                    return true;
                }
            }
        }
        return false;
    }
}
