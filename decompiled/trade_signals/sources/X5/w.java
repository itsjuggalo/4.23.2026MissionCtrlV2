package X5;

import X5.E;
import h6.InterfaceC1905n;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends y implements InterfaceC1905n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Field f9449a;

    public w(Field member) {
        AbstractC2304t.f(member, "member");
        this.f9449a = member;
    }

    @Override // h6.InterfaceC1905n
    public boolean F() {
        return S().isEnumConstant();
    }

    @Override // h6.InterfaceC1905n
    public boolean O() {
        return false;
    }

    @Override // X5.y
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public Field S() {
        return this.f9449a;
    }

    @Override // h6.InterfaceC1905n
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public E getType() {
        E.a aVar = E.f9397a;
        Type genericType = S().getGenericType();
        AbstractC2304t.e(genericType, "getGenericType(...)");
        return aVar.a(genericType);
    }
}
