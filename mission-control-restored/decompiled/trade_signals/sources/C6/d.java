package C6;

import I6.S;
import R5.InterfaceC0844a;

/* JADX INFO: loaded from: classes2.dex */
public class d extends a implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0844a f639c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(InterfaceC0844a interfaceC0844a, S s8, g gVar) {
        super(s8, gVar);
        if (interfaceC0844a == null) {
            b(0);
        }
        if (s8 == null) {
            b(1);
        }
        this.f639c = interfaceC0844a;
    }

    public static /* synthetic */ void b(int i8) {
        String str = i8 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i8 != 2 ? 3 : 2];
        if (i8 == 1) {
            objArr[0] = "receiverType";
        } else if (i8 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else if (i8 != 3) {
            objArr[0] = "callableDescriptor";
        } else {
            objArr[0] = "newType";
        }
        if (i8 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else {
            objArr[1] = "getDeclarationDescriptor";
        }
        if (i8 != 2) {
            if (i8 != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "replaceType";
            }
        }
        String str2 = String.format(str, objArr);
        if (i8 == 2) {
            throw new IllegalStateException(str2);
        }
    }

    public String toString() {
        return getType() + ": Ext {" + this.f639c + "}";
    }
}
