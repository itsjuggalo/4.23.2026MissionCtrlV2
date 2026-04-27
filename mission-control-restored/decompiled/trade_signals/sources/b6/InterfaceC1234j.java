package b6;

import R5.InterfaceC0848e;
import R5.InterfaceC0855l;
import R5.Z;
import R5.g0;
import h6.InterfaceC1898g;
import h6.InterfaceC1903l;
import h6.InterfaceC1905n;
import h6.q;

/* JADX INFO: renamed from: b6.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC1234j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC1234j f13206a = new a();

    /* JADX INFO: renamed from: b6.j$a */
    public static class a implements InterfaceC1234j {
        public static /* synthetic */ void f(int i8) {
            Object[] objArr = new Object[3];
            switch (i8) {
                case 1:
                    objArr[0] = "member";
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                    objArr[0] = "descriptor";
                    break;
                case 3:
                    objArr[0] = "element";
                    break;
                case 5:
                    objArr[0] = "field";
                    break;
                case 7:
                    objArr[0] = "javaClass";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1";
            switch (i8) {
                case 1:
                case 2:
                    objArr[2] = "recordMethod";
                    break;
                case 3:
                case 4:
                    objArr[2] = "recordConstructor";
                    break;
                case 5:
                case 6:
                    objArr[2] = "recordField";
                    break;
                case 7:
                case 8:
                    objArr[2] = "recordClass";
                    break;
                default:
                    objArr[2] = "getClassResolvedFromSource";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // b6.InterfaceC1234j
        public void a(q qVar, g0 g0Var) {
            if (qVar == null) {
                f(1);
            }
            if (g0Var == null) {
                f(2);
            }
        }

        @Override // b6.InterfaceC1234j
        public void b(InterfaceC1905n interfaceC1905n, Z z7) {
            if (interfaceC1905n == null) {
                f(5);
            }
            if (z7 == null) {
                f(6);
            }
        }

        @Override // b6.InterfaceC1234j
        public void c(InterfaceC1903l interfaceC1903l, InterfaceC0855l interfaceC0855l) {
            if (interfaceC1903l == null) {
                f(3);
            }
            if (interfaceC0855l == null) {
                f(4);
            }
        }

        @Override // b6.InterfaceC1234j
        public void d(InterfaceC1898g interfaceC1898g, InterfaceC0848e interfaceC0848e) {
            if (interfaceC1898g == null) {
                f(7);
            }
            if (interfaceC0848e == null) {
                f(8);
            }
        }

        @Override // b6.InterfaceC1234j
        public InterfaceC0848e e(q6.c cVar) {
            if (cVar != null) {
                return null;
            }
            f(0);
            return null;
        }
    }

    void a(q qVar, g0 g0Var);

    void b(InterfaceC1905n interfaceC1905n, Z z7);

    void c(InterfaceC1903l interfaceC1903l, InterfaceC0855l interfaceC0855l);

    void d(InterfaceC1898g interfaceC1898g, InterfaceC0848e interfaceC0848e);

    InterfaceC0848e e(q6.c cVar);
}
