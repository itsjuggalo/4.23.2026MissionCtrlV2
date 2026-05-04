package le;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import le.e0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class w extends y implements ve.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Field f15648a;

    public w(Field member) {
        kotlin.jvm.internal.t.f(member, "member");
        this.f15648a = member;
    }

    @Override // ve.n
    public boolean F() {
        return R().isEnumConstant();
    }

    @Override // ve.n
    public boolean N() {
        return false;
    }

    @Override // le.y
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public Field R() {
        return this.f15648a;
    }

    @Override // ve.n
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public e0 getType() {
        e0.a aVar = e0.f15612a;
        Type genericType = R().getGenericType();
        kotlin.jvm.internal.t.e(genericType, "getGenericType(...)");
        return aVar.a(genericType);
    }
}
