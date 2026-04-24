package E6;

import R5.InterfaceC0845b;
import R5.InterfaceC0848e;
import java.util.List;

/* JADX INFO: renamed from: E6.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC0483w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC0483w f1043a = new a();

    /* JADX INFO: renamed from: E6.w$a */
    public static class a implements InterfaceC0483w {
        public static /* synthetic */ void c(int i8) {
            Object[] objArr = new Object[3];
            if (i8 != 1) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "unresolvedSuperClasses";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1";
            if (i8 != 2) {
                objArr[2] = "reportIncompleteHierarchy";
            } else {
                objArr[2] = "reportCannotInferVisibility";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // E6.InterfaceC0483w
        public void a(InterfaceC0848e interfaceC0848e, List list) {
            if (interfaceC0848e == null) {
                c(0);
            }
            if (list == null) {
                c(1);
            }
        }

        @Override // E6.InterfaceC0483w
        public void b(InterfaceC0845b interfaceC0845b) {
            if (interfaceC0845b == null) {
                c(2);
            }
        }
    }

    void a(InterfaceC0848e interfaceC0848e, List list);

    void b(InterfaceC0845b interfaceC0845b);
}
