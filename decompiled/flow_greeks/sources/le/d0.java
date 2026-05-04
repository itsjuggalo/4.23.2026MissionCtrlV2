package le;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends y implements ve.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f15610a;

    public d0(Object recordComponent) {
        kotlin.jvm.internal.t.f(recordComponent, "recordComponent");
        this.f15610a = recordComponent;
    }

    @Override // le.y
    public Member R() throws IllegalAccessException, InvocationTargetException {
        Method methodC = a.f15591a.c(this.f15610a);
        if (methodC != null) {
            return methodC;
        }
        throw new NoSuchMethodError("Can't find `getAccessor` method");
    }

    @Override // ve.w
    public boolean a() {
        return false;
    }

    @Override // ve.w
    public ve.x getType() throws IllegalAccessException, InvocationTargetException {
        Class clsD = a.f15591a.d(this.f15610a);
        if (clsD != null) {
            return new s(clsD);
        }
        throw new NoSuchMethodError("Can't find `getType` method");
    }
}
