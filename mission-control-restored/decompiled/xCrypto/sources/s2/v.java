package s2;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import q2.C1722a;
import r2.InterfaceC1751a;
import v2.AbstractC1896a;
import x2.C1925a;
import y2.C1946a;

/* JADX INFO: loaded from: classes.dex */
public final class v implements q2.x, Cloneable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final v f14637g = new v();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f14638a = -1.0d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14639b = 136;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14640c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f14642e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f14643f;

    public class a extends q2.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile q2.w f14644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f14645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f14646c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ q2.e f14647d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ C1925a f14648e;

        public a(boolean z4, boolean z5, q2.e eVar, C1925a c1925a) {
            this.f14645b = z4;
            this.f14646c = z5;
            this.f14647d = eVar;
            this.f14648e = c1925a;
        }

        @Override // q2.w
        public Object c(C1946a c1946a) throws IOException {
            if (!this.f14645b) {
                return f().c(c1946a);
            }
            c1946a.B0();
            return null;
        }

        @Override // q2.w
        public void e(y2.c cVar, Object obj) throws IOException {
            if (this.f14646c) {
                cVar.e0();
            } else {
                f().e(cVar, obj);
            }
        }

        public final q2.w f() {
            q2.w wVar = this.f14644a;
            if (wVar != null) {
                return wVar;
            }
            q2.w wVarM = this.f14647d.m(v.this, this.f14648e);
            this.f14644a = wVarM;
            return wVarM;
        }
    }

    public v() {
        List list = Collections.EMPTY_LIST;
        this.f14642e = list;
        this.f14643f = list;
    }

    public static boolean d(Class cls) {
        return cls.isMemberClass() && !AbstractC1896a.n(cls);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public v clone() {
        try {
            return (v) super.clone();
        } catch (CloneNotSupportedException e4) {
            throw new AssertionError(e4);
        }
    }

    public boolean b(Class cls, boolean z4) {
        if (this.f14638a != -1.0d && !g((r2.d) cls.getAnnotation(r2.d.class), (r2.e) cls.getAnnotation(r2.e.class))) {
            return true;
        }
        if (!this.f14640c && d(cls)) {
            return true;
        }
        if (!z4 && !Enum.class.isAssignableFrom(cls) && AbstractC1896a.l(cls)) {
            return true;
        }
        Iterator it = (z4 ? this.f14642e : this.f14643f).iterator();
        if (!it.hasNext()) {
            return false;
        }
        android.support.v4.media.session.b.a(it.next());
        throw null;
    }

    public boolean c(Field field, boolean z4) {
        InterfaceC1751a interfaceC1751a;
        if ((this.f14639b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f14638a != -1.0d && !g((r2.d) field.getAnnotation(r2.d.class), (r2.e) field.getAnnotation(r2.e.class))) || field.isSynthetic()) {
            return true;
        }
        if ((this.f14641d && ((interfaceC1751a = (InterfaceC1751a) field.getAnnotation(InterfaceC1751a.class)) == null || (!z4 ? interfaceC1751a.deserialize() : interfaceC1751a.serialize()))) || b(field.getType(), z4)) {
            return true;
        }
        List list = z4 ? this.f14642e : this.f14643f;
        if (list.isEmpty()) {
            return false;
        }
        new C1722a(field);
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return false;
        }
        android.support.v4.media.session.b.a(it.next());
        throw null;
    }

    @Override // q2.x
    public q2.w create(q2.e eVar, C1925a c1925a) {
        Class clsC = c1925a.c();
        boolean zB = b(clsC, true);
        boolean zB2 = b(clsC, false);
        if (zB || zB2) {
            return new a(zB2, zB, eVar, c1925a);
        }
        return null;
    }

    public final boolean e(r2.d dVar) {
        if (dVar != null) {
            return this.f14638a >= dVar.value();
        }
        return true;
    }

    public final boolean f(r2.e eVar) {
        if (eVar != null) {
            return this.f14638a < eVar.value();
        }
        return true;
    }

    public final boolean g(r2.d dVar, r2.e eVar) {
        return e(dVar) && f(eVar);
    }
}
