package C2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C2.c f961m = new i(0.5f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C2.c f966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C2.c f967f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public C2.c f968g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public C2.c f969h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f970i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f971j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f972k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f973l;

    public interface c {
        C2.c a(C2.c cVar);
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i7, int i8) {
        return c(context, i7, i8, 0);
    }

    public static b c(Context context, int i7, int i8, int i9) {
        return d(context, i7, i8, new C2.a(i9));
    }

    public static b d(Context context, int i7, int i8, C2.c cVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i7);
        if (i8 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i8);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(n2.j.f19601x3);
        try {
            int i9 = typedArrayObtainStyledAttributes.getInt(n2.j.f19608y3, 0);
            int i10 = typedArrayObtainStyledAttributes.getInt(n2.j.f19269B3, i9);
            int i11 = typedArrayObtainStyledAttributes.getInt(n2.j.f19276C3, i9);
            int i12 = typedArrayObtainStyledAttributes.getInt(n2.j.f19262A3, i9);
            int i13 = typedArrayObtainStyledAttributes.getInt(n2.j.f19615z3, i9);
            C2.c cVarM = m(typedArrayObtainStyledAttributes, n2.j.f19283D3, cVar);
            C2.c cVarM2 = m(typedArrayObtainStyledAttributes, n2.j.f19304G3, cVarM);
            C2.c cVarM3 = m(typedArrayObtainStyledAttributes, n2.j.f19311H3, cVarM);
            C2.c cVarM4 = m(typedArrayObtainStyledAttributes, n2.j.f19297F3, cVarM);
            return new b().y(i10, cVarM2).C(i11, cVarM3).u(i12, cVarM4).q(i13, m(typedArrayObtainStyledAttributes, n2.j.f19290E3, cVarM));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i7, int i8) {
        return f(context, attributeSet, i7, i8, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i7, int i8, int i9) {
        return g(context, attributeSet, i7, i8, new C2.a(i9));
    }

    public static b g(Context context, AttributeSet attributeSet, int i7, int i8, C2.c cVar) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n2.j.f19352N2, i7, i8);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(n2.j.f19359O2, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(n2.j.f19366P2, 0);
        typedArrayObtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, cVar);
    }

    public static C2.c m(TypedArray typedArray, int i7, C2.c cVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i7);
        if (typedValuePeekValue == null) {
            return cVar;
        }
        int i8 = typedValuePeekValue.type;
        return i8 == 5 ? new C2.a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics())) : i8 == 6 ? new i(typedValuePeekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public f h() {
        return this.f972k;
    }

    public d i() {
        return this.f965d;
    }

    public C2.c j() {
        return this.f969h;
    }

    public d k() {
        return this.f964c;
    }

    public C2.c l() {
        return this.f968g;
    }

    public f n() {
        return this.f973l;
    }

    public f o() {
        return this.f971j;
    }

    public f p() {
        return this.f970i;
    }

    public d q() {
        return this.f962a;
    }

    public C2.c r() {
        return this.f966e;
    }

    public d s() {
        return this.f963b;
    }

    public C2.c t() {
        return this.f967f;
    }

    public boolean u(RectF rectF) {
        boolean z7 = this.f973l.getClass().equals(f.class) && this.f971j.getClass().equals(f.class) && this.f970i.getClass().equals(f.class) && this.f972k.getClass().equals(f.class);
        float fA = this.f966e.a(rectF);
        return z7 && ((this.f967f.a(rectF) > fA ? 1 : (this.f967f.a(rectF) == fA ? 0 : -1)) == 0 && (this.f969h.a(rectF) > fA ? 1 : (this.f969h.a(rectF) == fA ? 0 : -1)) == 0 && (this.f968g.a(rectF) > fA ? 1 : (this.f968g.a(rectF) == fA ? 0 : -1)) == 0) && ((this.f963b instanceof j) && (this.f962a instanceof j) && (this.f964c instanceof j) && (this.f965d instanceof j));
    }

    public b v() {
        return new b(this);
    }

    public k w(float f7) {
        return v().o(f7).m();
    }

    public k x(C2.c cVar) {
        return v().p(cVar).m();
    }

    public k y(c cVar) {
        return v().B(cVar.a(r())).F(cVar.a(t())).t(cVar.a(j())).x(cVar.a(l())).m();
    }

    public k(b bVar) {
        this.f962a = bVar.f974a;
        this.f963b = bVar.f975b;
        this.f964c = bVar.f976c;
        this.f965d = bVar.f977d;
        this.f966e = bVar.f978e;
        this.f967f = bVar.f979f;
        this.f968g = bVar.f980g;
        this.f969h = bVar.f981h;
        this.f970i = bVar.f982i;
        this.f971j = bVar.f983j;
        this.f972k = bVar.f984k;
        this.f973l = bVar.f985l;
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f974a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f975b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f976c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public d f977d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public C2.c f978e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public C2.c f979f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public C2.c f980g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public C2.c f981h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public f f982i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public f f983j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public f f984k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public f f985l;

        public b() {
            this.f974a = h.b();
            this.f975b = h.b();
            this.f976c = h.b();
            this.f977d = h.b();
            this.f978e = new C2.a(0.0f);
            this.f979f = new C2.a(0.0f);
            this.f980g = new C2.a(0.0f);
            this.f981h = new C2.a(0.0f);
            this.f982i = h.c();
            this.f983j = h.c();
            this.f984k = h.c();
            this.f985l = h.c();
        }

        public static float n(d dVar) {
            if (dVar instanceof j) {
                return ((j) dVar).f960a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).f908a;
            }
            return -1.0f;
        }

        public b A(float f7) {
            this.f978e = new C2.a(f7);
            return this;
        }

        public b B(C2.c cVar) {
            this.f978e = cVar;
            return this;
        }

        public b C(int i7, C2.c cVar) {
            return D(h.a(i7)).F(cVar);
        }

        public b D(d dVar) {
            this.f975b = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                E(fN);
            }
            return this;
        }

        public b E(float f7) {
            this.f979f = new C2.a(f7);
            return this;
        }

        public b F(C2.c cVar) {
            this.f979f = cVar;
            return this;
        }

        public k m() {
            return new k(this);
        }

        public b o(float f7) {
            return A(f7).E(f7).w(f7).s(f7);
        }

        public b p(C2.c cVar) {
            return B(cVar).F(cVar).x(cVar).t(cVar);
        }

        public b q(int i7, C2.c cVar) {
            return r(h.a(i7)).t(cVar);
        }

        public b r(d dVar) {
            this.f977d = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                s(fN);
            }
            return this;
        }

        public b s(float f7) {
            this.f981h = new C2.a(f7);
            return this;
        }

        public b t(C2.c cVar) {
            this.f981h = cVar;
            return this;
        }

        public b u(int i7, C2.c cVar) {
            return v(h.a(i7)).x(cVar);
        }

        public b v(d dVar) {
            this.f976c = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                w(fN);
            }
            return this;
        }

        public b w(float f7) {
            this.f980g = new C2.a(f7);
            return this;
        }

        public b x(C2.c cVar) {
            this.f980g = cVar;
            return this;
        }

        public b y(int i7, C2.c cVar) {
            return z(h.a(i7)).B(cVar);
        }

        public b z(d dVar) {
            this.f974a = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                A(fN);
            }
            return this;
        }

        public b(k kVar) {
            this.f974a = h.b();
            this.f975b = h.b();
            this.f976c = h.b();
            this.f977d = h.b();
            this.f978e = new C2.a(0.0f);
            this.f979f = new C2.a(0.0f);
            this.f980g = new C2.a(0.0f);
            this.f981h = new C2.a(0.0f);
            this.f982i = h.c();
            this.f983j = h.c();
            this.f984k = h.c();
            this.f985l = h.c();
            this.f974a = kVar.f962a;
            this.f975b = kVar.f963b;
            this.f976c = kVar.f964c;
            this.f977d = kVar.f965d;
            this.f978e = kVar.f966e;
            this.f979f = kVar.f967f;
            this.f980g = kVar.f968g;
            this.f981h = kVar.f969h;
            this.f982i = kVar.f970i;
            this.f983j = kVar.f971j;
            this.f984k = kVar.f972k;
            this.f985l = kVar.f973l;
        }
    }

    public k() {
        this.f962a = h.b();
        this.f963b = h.b();
        this.f964c = h.b();
        this.f965d = h.b();
        this.f966e = new C2.a(0.0f);
        this.f967f = new C2.a(0.0f);
        this.f968g = new C2.a(0.0f);
        this.f969h = new C2.a(0.0f);
        this.f970i = h.c();
        this.f971j = h.c();
        this.f972k = h.c();
        this.f973l = h.c();
    }
}
