package X5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class D extends y implements h6.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9396a;

    public D(Object recordComponent) {
        AbstractC2304t.f(recordComponent, "recordComponent");
        this.f9396a = recordComponent;
    }

    @Override // X5.y
    public Member S() throws IllegalAccessException, InvocationTargetException {
        Method methodC = C0985a.f9406a.c(this.f9396a);
        if (methodC != null) {
            return methodC;
        }
        throw new NoSuchMethodError("Can't find `getAccessor` method");
    }

    @Override // h6.w
    public h6.x getType() throws IllegalAccessException, InvocationTargetException {
        Class clsD = C0985a.f9406a.d(this.f9396a);
        if (clsD != null) {
            return new s(clsD);
        }
        throw new NoSuchMethodError("Can't find `getType` method");
    }

    @Override // h6.w
    public boolean j() {
        return false;
    }
}
