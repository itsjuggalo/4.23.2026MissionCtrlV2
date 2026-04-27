package C6;

import I6.S;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f634b;

    public a(S s8, g gVar) {
        if (s8 == null) {
            b(0);
        }
        this.f633a = s8;
        this.f634b = gVar == null ? this : gVar;
    }

    private static /* synthetic */ void b(int i8) {
        String str = (i8 == 1 || i8 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i8 == 1 || i8 == 2) ? 2 : 3];
        if (i8 == 1 || i8 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[0] = "receiverType";
        }
        if (i8 == 1) {
            objArr[1] = "getType";
        } else if (i8 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i8 != 1 && i8 != 2) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i8 != 1 && i8 != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // C6.g
    public S getType() {
        S s8 = this.f633a;
        if (s8 == null) {
            b(1);
        }
        return s8;
    }
}
