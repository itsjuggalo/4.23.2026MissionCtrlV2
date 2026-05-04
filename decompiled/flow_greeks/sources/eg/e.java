package eg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f8886a;

    public e(c arrayMap) {
        kotlin.jvm.internal.t.f(arrayMap, "arrayMap");
        this.f8886a = arrayMap;
    }

    @Override // eg.a
    public final c a() {
        return this.f8886a;
    }

    @Override // eg.a
    public final void e(String keyQualifiedName, Object value) {
        kotlin.jvm.internal.t.f(keyQualifiedName, "keyQualifiedName");
        kotlin.jvm.internal.t.f(value, "value");
        int iE = c().e(keyQualifiedName);
        int iA = this.f8886a.a();
        if (iA == 0) {
            c cVar = this.f8886a;
            if (!(cVar instanceof i)) {
                throw new IllegalStateException(g(cVar, 0, "EmptyArrayMap"));
            }
            this.f8886a = new o(value, iE);
            return;
        }
        if (iA == 1) {
            c cVar2 = this.f8886a;
            try {
                kotlin.jvm.internal.t.d(cVar2, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
                o oVar = (o) cVar2;
                if (oVar.e() == iE) {
                    this.f8886a = new o(value, iE);
                    return;
                } else {
                    d dVar = new d();
                    this.f8886a = dVar;
                    dVar.c(oVar.e(), oVar.getValue());
                }
            } catch (ClassCastException e10) {
                throw new IllegalStateException(g(cVar2, 1, "OneElementArrayMap"), e10);
            }
        }
        this.f8886a.c(iE, value);
    }

    public final String g(c cVar, int i10, String str) {
        Object next;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Race condition happened, the size of ArrayMap is " + i10 + " but it isn't an `" + str + '`');
        sb2.append('\n');
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Type: ");
        sb3.append(cVar.getClass());
        sb2.append(sb3.toString());
        sb2.append('\n');
        StringBuilder sb4 = new StringBuilder();
        Map mapB = c().b();
        sb4.append("[");
        sb4.append('\n');
        ArrayList arrayList = new ArrayList(dd.s.u(cVar, 10));
        int i11 = 0;
        for (Object obj : cVar) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                dd.r.t();
            }
            Iterator it = mapB.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((Number) ((Map.Entry) next).getValue()).intValue() == i11) {
                    break;
                }
            }
            sb4.append("  " + ((Map.Entry) next) + '[' + i11 + "]: " + obj);
            sb4.append('\n');
            arrayList.add(sb4);
            i11 = i12;
        }
        sb4.append("]");
        sb4.append('\n');
        sb2.append("Content: " + sb4.toString());
        sb2.append('\n');
        return sb2.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public e() {
        i iVar = i.f8899a;
        kotlin.jvm.internal.t.d(iVar, "null cannot be cast to non-null type org.jetbrains.kotlin.util.ArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
        this(iVar);
    }
}
