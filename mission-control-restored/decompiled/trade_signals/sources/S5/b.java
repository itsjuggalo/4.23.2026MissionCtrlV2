package S5;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f7641a;

    public b(h hVar) {
        if (hVar == null) {
            I(0);
        }
        this.f7641a = hVar;
    }

    private static /* synthetic */ void I(int i8) {
        String str = i8 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i8 != 1 ? 3 : 2];
        if (i8 != 1) {
            objArr[0] = "annotations";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        }
        if (i8 != 1) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        } else {
            objArr[1] = "getAnnotations";
        }
        if (i8 != 1) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i8 == 1) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // S5.a
    public h getAnnotations() {
        h hVar = this.f7641a;
        if (hVar == null) {
            I(1);
        }
        return hVar;
    }
}
