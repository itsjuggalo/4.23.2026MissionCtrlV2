package bf;

import cd.v;
import dd.a0;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.t;
import ze.o;
import ze.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f3344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f3345b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3346a;

        static {
            int[] iArr = new int[o.c.EnumC0495c.values().length];
            try {
                iArr[o.c.EnumC0495c.CLASS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[o.c.EnumC0495c.PACKAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[o.c.EnumC0495c.LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f3346a = iArr;
        }
    }

    public d(p strings, o qualifiedNames) {
        t.f(strings, "strings");
        t.f(qualifiedNames, "qualifiedNames");
        this.f3344a = strings;
        this.f3345b = qualifiedNames;
    }

    @Override // bf.c
    public String a(int i10) {
        v vVarC = c(i10);
        List list = (List) vVarC.a();
        String strI0 = a0.i0((List) vVarC.b(), ".", null, null, 0, null, null, 62, null);
        if (list.isEmpty()) {
            return strI0;
        }
        return a0.i0(list, "/", null, null, 0, null, null, 62, null) + '/' + strI0;
    }

    @Override // bf.c
    public boolean b(int i10) {
        return ((Boolean) c(i10).d()).booleanValue();
    }

    public final v c(int i10) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z10 = false;
        while (i10 != -1) {
            o.c cVarV = this.f3345b.v(i10);
            String strV = this.f3344a.v(cVarV.z());
            o.c.EnumC0495c enumC0495cX = cVarV.x();
            t.c(enumC0495cX);
            int i11 = a.f3346a[enumC0495cX.ordinal()];
            if (i11 == 1) {
                linkedList2.addFirst(strV);
            } else if (i11 == 2) {
                linkedList.addFirst(strV);
            } else {
                if (i11 != 3) {
                    throw new cd.o();
                }
                linkedList2.addFirst(strV);
                z10 = true;
            }
            i10 = cVarV.y();
        }
        return new v(linkedList, linkedList2, Boolean.valueOf(z10));
    }

    @Override // bf.c
    public String getString(int i10) {
        String strV = this.f3344a.v(i10);
        t.e(strV, "getString(...)");
        return strV;
    }
}
