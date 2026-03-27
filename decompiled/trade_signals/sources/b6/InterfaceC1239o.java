package b6;

import I6.S;
import R5.InterfaceC0845b;
import R5.InterfaceC0848e;
import com.google.firebase.analytics.FirebaseAnalytics;
import h6.r;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: b6.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC1239o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC1239o f13213a = new a();

    /* JADX INFO: renamed from: b6.o$a */
    public static class a implements InterfaceC1239o {
        public static /* synthetic */ void c(int i8) {
            Object[] objArr = new Object[3];
            switch (i8) {
                case 1:
                    objArr[0] = "owner";
                    break;
                case 2:
                    objArr[0] = "returnType";
                    break;
                case 3:
                    objArr[0] = "valueParameters";
                    break;
                case 4:
                    objArr[0] = "typeParameters";
                    break;
                case 5:
                    objArr[0] = "descriptor";
                    break;
                case 6:
                    objArr[0] = "signatureErrors";
                    break;
                default:
                    objArr[0] = FirebaseAnalytics.Param.METHOD;
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1";
            if (i8 == 5 || i8 == 6) {
                objArr[2] = "reportSignatureErrors";
            } else {
                objArr[2] = "resolvePropagatedSignature";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // b6.InterfaceC1239o
        public void a(InterfaceC0845b interfaceC0845b, List list) {
            if (interfaceC0845b == null) {
                c(5);
            }
            if (list == null) {
                c(6);
            }
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // b6.InterfaceC1239o
        public b b(r rVar, InterfaceC0848e interfaceC0848e, S s8, S s9, List list, List list2) {
            if (rVar == null) {
                c(0);
            }
            if (interfaceC0848e == null) {
                c(1);
            }
            if (s8 == null) {
                c(2);
            }
            if (list == null) {
                c(3);
            }
            if (list2 == null) {
                c(4);
            }
            return new b(s8, s9, list, list2, Collections.emptyList(), false);
        }
    }

    /* JADX INFO: renamed from: b6.o$b */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final S f13214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final S f13215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f13216c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f13217d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List f13218e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f13219f;

        public b(S s8, S s9, List list, List list2, List list3, boolean z7) {
            if (s8 == null) {
                a(0);
            }
            if (list == null) {
                a(1);
            }
            if (list2 == null) {
                a(2);
            }
            if (list3 == null) {
                a(3);
            }
            this.f13214a = s8;
            this.f13215b = s9;
            this.f13216c = list;
            this.f13217d = list2;
            this.f13218e = list3;
            this.f13219f = z7;
        }

        public static /* synthetic */ void a(int i8) {
            String str = (i8 == 4 || i8 == 5 || i8 == 6 || i8 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i8 == 4 || i8 == 5 || i8 == 6 || i8 == 7) ? 2 : 3];
            switch (i8) {
                case 1:
                    objArr[0] = "valueParameters";
                    break;
                case 2:
                    objArr[0] = "typeParameters";
                    break;
                case 3:
                    objArr[0] = "signatureErrors";
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
                    break;
                default:
                    objArr[0] = "returnType";
                    break;
            }
            if (i8 == 4) {
                objArr[1] = "getReturnType";
            } else if (i8 == 5) {
                objArr[1] = "getValueParameters";
            } else if (i8 == 6) {
                objArr[1] = "getTypeParameters";
            } else if (i8 != 7) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
            } else {
                objArr[1] = "getErrors";
            }
            if (i8 != 4 && i8 != 5 && i8 != 6 && i8 != 7) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i8 != 4 && i8 != 5 && i8 != 6 && i8 != 7) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        public List b() {
            List list = this.f13218e;
            if (list == null) {
                a(7);
            }
            return list;
        }

        public S c() {
            return this.f13215b;
        }

        public S d() {
            S s8 = this.f13214a;
            if (s8 == null) {
                a(4);
            }
            return s8;
        }

        public List e() {
            List list = this.f13217d;
            if (list == null) {
                a(6);
            }
            return list;
        }

        public List f() {
            List list = this.f13216c;
            if (list == null) {
                a(5);
            }
            return list;
        }

        public boolean g() {
            return this.f13219f;
        }
    }

    void a(InterfaceC0845b interfaceC0845b, List list);

    b b(r rVar, InterfaceC0848e interfaceC0848e, S s8, S s9, List list, List list2);
}
