package N5;

import R5.h0;
import a6.H;
import a6.I;
import j6.InterfaceC2260x;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.K;
import p5.AbstractC2595q;
import q6.b;
import q6.c;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5879a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f5880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f5881c;

    static {
        List listL = AbstractC2595q.l(I.f10025a, I.f10036l, I.f10037m, I.f10028d, I.f10030f, I.f10033i);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        b.a aVar = b.f22655d;
        Iterator it = listL.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(aVar.c((c) it.next()));
        }
        f5880b = linkedHashSet;
        b.a aVar2 = b.f22655d;
        c REPEATABLE_ANNOTATION = I.f10034j;
        AbstractC2304t.e(REPEATABLE_ANNOTATION, "REPEATABLE_ANNOTATION");
        f5881c = aVar2.c(REPEATABLE_ANNOTATION);
    }

    public final b a() {
        return f5881c;
    }

    public final Set b() {
        return f5880b;
    }

    public final boolean c(InterfaceC2260x klass) {
        AbstractC2304t.f(klass, "klass");
        K k8 = new K();
        klass.e(new C0083a(k8), null);
        return k8.f20466a;
    }

    /* JADX INFO: renamed from: N5.a$a, reason: collision with other inner class name */
    public static final class C0083a implements InterfaceC2260x.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ K f5882a;

        public C0083a(K k8) {
            this.f5882a = k8;
        }

        @Override // j6.InterfaceC2260x.c
        public InterfaceC2260x.a b(b classId, h0 source) {
            AbstractC2304t.f(classId, "classId");
            AbstractC2304t.f(source, "source");
            if (!AbstractC2304t.b(classId, H.f10020a.a())) {
                return null;
            }
            this.f5882a.f20466a = true;
            return null;
        }

        @Override // j6.InterfaceC2260x.c
        public void a() {
        }
    }
}
