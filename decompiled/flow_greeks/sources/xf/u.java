package xf;

import fe.j1;
import io.flutter.plugins.firebase.analytics.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class u extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fe.e f25076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f25077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Collection f25078f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(fe.e eVar, List list, Collection collection, wf.n nVar) {
        super(nVar);
        if (eVar == null) {
            H(0);
        }
        if (list == null) {
            H(1);
        }
        if (collection == null) {
            H(2);
        }
        if (nVar == null) {
            H(3);
        }
        this.f25076d = eVar;
        this.f25077e = Collections.unmodifiableList(new ArrayList(list));
        this.f25078f = Collections.unmodifiableCollection(collection);
    }

    private static /* synthetic */ void H(int i10) {
        String str = (i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7) ? 2 : 3];
        switch (i10) {
            case 1:
                objArr[0] = Constants.PARAMETERS;
                break;
            case 2:
                objArr[0] = "supertypes";
                break;
            case 3:
                objArr[0] = "storageManager";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
            default:
                objArr[0] = "classDescriptor";
                break;
        }
        if (i10 == 4) {
            objArr[1] = "getParameters";
        } else if (i10 == 5) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i10 == 6) {
            objArr[1] = "computeSupertypes";
        } else if (i10 != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        } else {
            objArr[1] = "getSupertypeLoopChecker";
        }
        if (i10 != 4 && i10 != 5 && i10 != 6 && i10 != 7) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i10 != 4 && i10 != 5 && i10 != 6 && i10 != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // xf.v, xf.u1
    /* JADX INFO: renamed from: I */
    public fe.e b() {
        fe.e eVar = this.f25076d;
        if (eVar == null) {
            H(5);
        }
        return eVar;
    }

    @Override // xf.u1
    public boolean d() {
        return true;
    }

    @Override // xf.u1
    public List getParameters() {
        List list = this.f25077e;
        if (list == null) {
            H(4);
        }
        return list;
    }

    @Override // xf.p
    public Collection r() {
        Collection collection = this.f25078f;
        if (collection == null) {
            H(6);
        }
        return collection;
    }

    public String toString() {
        return jf.i.m(this.f25076d).a();
    }

    @Override // xf.p
    public fe.j1 v() {
        j1.a aVar = j1.a.f9488a;
        if (aVar == null) {
            H(7);
        }
        return aVar;
    }
}
