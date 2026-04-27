package t6;

import R5.InterfaceC0848e;
import R5.InterfaceC0851h;
import R5.InterfaceC0856m;
import R5.N;
import R5.m0;
import java.util.ArrayList;
import kotlin.jvm.internal.AbstractC2304t;
import u6.AbstractC2794i;

/* JADX INFO: renamed from: t6.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC2754b {

    /* JADX INFO: renamed from: t6.b$a */
    public static final class a implements InterfaceC2754b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f23365a = new a();

        @Override // t6.InterfaceC2754b
        public String a(InterfaceC0851h classifier, n renderer) {
            AbstractC2304t.f(classifier, "classifier");
            AbstractC2304t.f(renderer, "renderer");
            if (classifier instanceof m0) {
                q6.f name = ((m0) classifier).getName();
                AbstractC2304t.e(name, "getName(...)");
                return renderer.R(name, false);
            }
            q6.d dVarM = AbstractC2794i.m(classifier);
            AbstractC2304t.e(dVarM, "getFqName(...)");
            return renderer.Q(dVarM);
        }
    }

    /* JADX INFO: renamed from: t6.b$b, reason: collision with other inner class name */
    public static final class C0405b implements InterfaceC2754b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0405b f23366a = new C0405b();

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [R5.h, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v1, types: [R5.J, R5.m] */
        /* JADX WARN: Type inference failed for: r2v2, types: [R5.m] */
        @Override // t6.InterfaceC2754b
        public String a(InterfaceC0851h classifier, n renderer) {
            AbstractC2304t.f(classifier, "classifier");
            AbstractC2304t.f(renderer, "renderer");
            if (classifier instanceof m0) {
                q6.f name = ((m0) classifier).getName();
                AbstractC2304t.e(name, "getName(...)");
                return renderer.R(name, false);
            }
            ArrayList arrayList = new ArrayList();
            do {
                arrayList.add(classifier.getName());
                classifier = classifier.b();
            } while (classifier instanceof InterfaceC0848e);
            return G.c(p5.w.J(arrayList));
        }
    }

    /* JADX INFO: renamed from: t6.b$c */
    public static final class c implements InterfaceC2754b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f23367a = new c();

        @Override // t6.InterfaceC2754b
        public String a(InterfaceC0851h classifier, n renderer) {
            AbstractC2304t.f(classifier, "classifier");
            AbstractC2304t.f(renderer, "renderer");
            return b(classifier);
        }

        public final String b(InterfaceC0851h interfaceC0851h) {
            q6.f name = interfaceC0851h.getName();
            AbstractC2304t.e(name, "getName(...)");
            String strB = G.b(name);
            if (interfaceC0851h instanceof m0) {
                return strB;
            }
            InterfaceC0856m interfaceC0856mB = interfaceC0851h.b();
            AbstractC2304t.e(interfaceC0856mB, "getContainingDeclaration(...)");
            String strC = c(interfaceC0856mB);
            if (strC == null || AbstractC2304t.b(strC, "")) {
                return strB;
            }
            return strC + com.amazon.a.a.o.c.a.b.f14112a + strB;
        }

        public final String c(InterfaceC0856m interfaceC0856m) {
            if (interfaceC0856m instanceof InterfaceC0848e) {
                return b((InterfaceC0851h) interfaceC0856m);
            }
            if (interfaceC0856m instanceof N) {
                return G.a(((N) interfaceC0856m).e().i());
            }
            return null;
        }
    }

    String a(InterfaceC0851h interfaceC0851h, n nVar);
}
