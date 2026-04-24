package P6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e extends AbstractC0788a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f6492a;

    /* JADX WARN: Illegal instructions before constructor call */
    public e() {
        i iVar = i.f6505a;
        AbstractC2304t.d(iVar, "null cannot be cast to non-null type org.jetbrains.kotlin.util.ArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
        this(iVar);
    }

    @Override // P6.AbstractC0788a
    public final c a() {
        return this.f6492a;
    }

    @Override // P6.AbstractC0788a
    public final void f(String keyQualifiedName, Object value) {
        AbstractC2304t.f(keyQualifiedName, "keyQualifiedName");
        AbstractC2304t.f(value, "value");
        int iF = d().f(keyQualifiedName);
        int iA = this.f6492a.a();
        if (iA == 0) {
            c cVar = this.f6492a;
            if (!(cVar instanceof i)) {
                throw new IllegalStateException(h(cVar, 0, "EmptyArrayMap"));
            }
            this.f6492a = new o(value, iF);
            return;
        }
        if (iA == 1) {
            c cVar2 = this.f6492a;
            try {
                AbstractC2304t.d(cVar2, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
                o oVar = (o) cVar2;
                if (oVar.e() == iF) {
                    this.f6492a = new o(value, iF);
                    return;
                } else {
                    d dVar = new d();
                    this.f6492a = dVar;
                    dVar.d(oVar.e(), oVar.getValue());
                }
            } catch (ClassCastException e8) {
                throw new IllegalStateException(h(cVar2, 1, "OneElementArrayMap"), e8);
            }
        }
        this.f6492a.d(iF, value);
    }

    public final String h(c cVar, int i8, String str) {
        Object next;
        StringBuilder sb = new StringBuilder();
        sb.append("Race condition happened, the size of ArrayMap is " + i8 + " but it isn't an `" + str + '`');
        sb.append('\n');
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Type: ");
        sb2.append(cVar.getClass());
        sb.append(sb2.toString());
        sb.append('\n');
        StringBuilder sb3 = new StringBuilder();
        Map mapB = d().b();
        sb3.append("[");
        sb3.append('\n');
        ArrayList arrayList = new ArrayList(p5.r.s(cVar, 10));
        int i9 = 0;
        for (Object obj : cVar) {
            int i10 = i9 + 1;
            if (i9 < 0) {
                AbstractC2595q.r();
            }
            Iterator it = mapB.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((Number) ((Map.Entry) next).getValue()).intValue() == i9) {
                    break;
                }
            }
            sb3.append("  " + ((Map.Entry) next) + '[' + i9 + "]: " + obj);
            sb3.append('\n');
            arrayList.add(sb3);
            i9 = i10;
        }
        sb3.append("]");
        sb3.append('\n');
        sb.append("Content: " + sb3.toString());
        sb.append('\n');
        return sb.toString();
    }

    public e(c arrayMap) {
        AbstractC2304t.f(arrayMap, "arrayMap");
        this.f6492a = arrayMap;
    }
}
