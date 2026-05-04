package pe;

import bb.d0;
import cd.h0;
import fe.b;
import fe.s1;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import tf.w;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: pe.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0316a extends jf.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f18580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Set f18581b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f18582c;

        /* JADX INFO: renamed from: pe.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class C0317a implements pd.k {
            public C0317a() {
            }

            private static /* synthetic */ void a(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1", "invoke"));
            }

            @Override // pd.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public h0 invoke(fe.b bVar) {
                if (bVar == null) {
                    a(0);
                }
                C0316a.this.f18580a.a(bVar);
                return h0.f3852a;
            }
        }

        public C0316a(w wVar, Set set, boolean z10) {
            this.f18580a = wVar;
            this.f18581b = set;
            this.f18582c = z10;
        }

        private static /* synthetic */ void f(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "fromSuper";
            } else if (i10 == 2) {
                objArr[0] = "fromCurrent";
            } else if (i10 == 3) {
                objArr[0] = "member";
            } else if (i10 != 4) {
                objArr[0] = "fakeOverride";
            } else {
                objArr[0] = "overridden";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
            if (i10 == 1 || i10 == 2) {
                objArr[2] = "conflict";
            } else if (i10 == 3 || i10 == 4) {
                objArr[2] = "setOverriddenDescriptors";
            } else {
                objArr[2] = "addFakeOverride";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // jf.n
        public void a(fe.b bVar) {
            if (bVar == null) {
                f(0);
            }
            jf.o.K(bVar, new C0317a());
            this.f18581b.add(bVar);
        }

        @Override // jf.n
        public void d(fe.b bVar, Collection collection) {
            if (bVar == null) {
                f(3);
            }
            if (collection == null) {
                f(4);
            }
            if (!this.f18582c || bVar.h() == b.a.FAKE_OVERRIDE) {
                super.d(bVar, collection);
            }
        }

        @Override // jf.m
        public void e(fe.b bVar, fe.b bVar2) {
            if (bVar == null) {
                f(1);
            }
            if (bVar2 == null) {
                f(2);
            }
        }
    }

    public static /* synthetic */ void a(int i10) {
        String str = i10 != 18 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i10 != 18 ? 3 : 2];
        switch (i10) {
            case 1:
            case 7:
            case 13:
                objArr[0] = "membersFromSupertypes";
                break;
            case 2:
            case 8:
            case 14:
                objArr[0] = "membersFromCurrent";
                break;
            case 3:
            case 9:
            case 15:
                objArr[0] = "classDescriptor";
                break;
            case 4:
            case 10:
            case 16:
                objArr[0] = "errorReporter";
                break;
            case 5:
            case 11:
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                objArr[0] = "overridingUtil";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "name";
                break;
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            case 20:
                objArr[0] = "annotationClass";
                break;
        }
        if (i10 != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        } else {
            objArr[1] = "resolveOverrides";
        }
        switch (i10) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "resolveOverridesForStaticMembers";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                objArr[2] = "resolveOverrides";
                break;
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                break;
            case 19:
            case 20:
                objArr[2] = "getAnnotationParameterByName";
                break;
            default:
                objArr[2] = "resolveOverridesForNonStaticMembers";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 == 18) {
            throw new IllegalStateException(str2);
        }
    }

    public static s1 b(ef.f fVar, fe.e eVar) {
        if (fVar == null) {
            a(19);
        }
        if (eVar == null) {
            a(20);
        }
        Collection collectionM = eVar.m();
        if (collectionM.size() != 1) {
            return null;
        }
        for (s1 s1Var : ((fe.d) collectionM.iterator().next()).i()) {
            if (s1Var.getName().equals(fVar)) {
                return s1Var;
            }
        }
        return null;
    }

    public static Collection c(ef.f fVar, Collection collection, Collection collection2, fe.e eVar, w wVar, jf.o oVar, boolean z10) {
        if (fVar == null) {
            a(12);
        }
        if (collection == null) {
            a(13);
        }
        if (collection2 == null) {
            a(14);
        }
        if (eVar == null) {
            a(15);
        }
        if (wVar == null) {
            a(16);
        }
        if (oVar == null) {
            a(17);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        oVar.v(fVar, collection, collection2, eVar, new C0316a(wVar, linkedHashSet, z10));
        return linkedHashSet;
    }

    public static Collection d(ef.f fVar, Collection collection, Collection collection2, fe.e eVar, w wVar, jf.o oVar) {
        if (fVar == null) {
            a(0);
        }
        if (collection == null) {
            a(1);
        }
        if (collection2 == null) {
            a(2);
        }
        if (eVar == null) {
            a(3);
        }
        if (wVar == null) {
            a(4);
        }
        if (oVar == null) {
            a(5);
        }
        return c(fVar, collection, collection2, eVar, wVar, oVar, false);
    }

    public static Collection e(ef.f fVar, Collection collection, Collection collection2, fe.e eVar, w wVar, jf.o oVar) {
        if (fVar == null) {
            a(6);
        }
        if (collection == null) {
            a(7);
        }
        if (collection2 == null) {
            a(8);
        }
        if (eVar == null) {
            a(9);
        }
        if (wVar == null) {
            a(10);
        }
        if (oVar == null) {
            a(11);
        }
        return c(fVar, collection, collection2, eVar, wVar, oVar, true);
    }
}
