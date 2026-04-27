package t2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import q2.w;
import q2.x;
import s2.AbstractC1772b;
import x2.C1925a;
import y2.C1946a;

/* JADX INFO: renamed from: t2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1784a extends w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x f14748c = new C0240a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f14749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f14750b;

    /* JADX INFO: renamed from: t2.a$a, reason: collision with other inner class name */
    public class C0240a implements x {
        @Override // q2.x
        public w create(q2.e eVar, C1925a c1925a) {
            Type typeD = c1925a.d();
            if (!(typeD instanceof GenericArrayType) && (!(typeD instanceof Class) || !((Class) typeD).isArray())) {
                return null;
            }
            Type typeG = AbstractC1772b.g(typeD);
            return new C1784a(eVar, eVar.l(C1925a.b(typeG)), AbstractC1772b.k(typeG));
        }
    }

    public C1784a(q2.e eVar, w wVar, Class cls) {
        this.f14750b = new o(eVar, wVar, cls);
        this.f14749a = cls;
    }

    @Override // q2.w
    public Object c(C1946a c1946a) throws IOException {
        if (c1946a.r0() == y2.b.NULL) {
            c1946a.n0();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        c1946a.f();
        while (c1946a.d0()) {
            arrayList.add(this.f14750b.c(c1946a));
        }
        c1946a.E();
        int size = arrayList.size();
        if (!this.f14749a.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.f14749a, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) this.f14749a, size);
        for (int i4 = 0; i4 < size; i4++) {
            Array.set(objNewInstance, i4, arrayList.get(i4));
        }
        return objNewInstance;
    }

    @Override // q2.w
    public void e(y2.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.e0();
            return;
        }
        cVar.p();
        int length = Array.getLength(obj);
        for (int i4 = 0; i4 < length; i4++) {
            this.f14750b.e(cVar, Array.get(obj, i4));
        }
        cVar.E();
    }
}
