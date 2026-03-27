package n6;

import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import l6.o;
import l6.p;
import o5.C2487o;
import o5.v;
import p5.z;

/* JADX INFO: renamed from: n6.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2430d implements InterfaceC2429c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f21671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f21672b;

    /* JADX INFO: renamed from: n6.d$a */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21673a;

        static {
            int[] iArr = new int[o.c.EnumC0353c.values().length];
            try {
                iArr[o.c.EnumC0353c.CLASS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[o.c.EnumC0353c.PACKAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[o.c.EnumC0353c.LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f21673a = iArr;
        }
    }

    public C2430d(p strings, o qualifiedNames) {
        AbstractC2304t.f(strings, "strings");
        AbstractC2304t.f(qualifiedNames, "qualifiedNames");
        this.f21671a = strings;
        this.f21672b = qualifiedNames;
    }

    @Override // n6.InterfaceC2429c
    public String a(int i8) {
        v vVarD = d(i8);
        List list = (List) vVarD.a();
        String strH0 = z.h0((List) vVarD.b(), ".", null, null, 0, null, null, 62, null);
        if (list.isEmpty()) {
            return strH0;
        }
        return z.h0(list, "/", null, null, 0, null, null, 62, null) + '/' + strH0;
    }

    @Override // n6.InterfaceC2429c
    public String b(int i8) {
        String strW = this.f21671a.w(i8);
        AbstractC2304t.e(strW, "getString(...)");
        return strW;
    }

    @Override // n6.InterfaceC2429c
    public boolean c(int i8) {
        return ((Boolean) d(i8).d()).booleanValue();
    }

    public final v d(int i8) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z7 = false;
        while (i8 != -1) {
            o.c cVarW = this.f21672b.w(i8);
            String strW = this.f21671a.w(cVarW.A());
            o.c.EnumC0353c enumC0353cY = cVarW.y();
            AbstractC2304t.c(enumC0353cY);
            int i9 = a.f21673a[enumC0353cY.ordinal()];
            if (i9 == 1) {
                linkedList2.addFirst(strW);
            } else if (i9 == 2) {
                linkedList.addFirst(strW);
            } else {
                if (i9 != 3) {
                    throw new C2487o();
                }
                linkedList2.addFirst(strW);
                z7 = true;
            }
            i8 = cVarW.z();
        }
        return new v(linkedList, linkedList2, Boolean.valueOf(z7));
    }
}
