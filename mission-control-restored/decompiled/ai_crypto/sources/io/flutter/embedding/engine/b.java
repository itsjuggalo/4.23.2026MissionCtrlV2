package io.flutter.embedding.engine;

import M4.a;
import O4.f;
import android.content.Context;
import io.flutter.embedding.engine.a;
import io.flutter.plugin.platform.C2025w;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f16523a = new ArrayList();

    public class a implements a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ io.flutter.embedding.engine.a f16524a;

        public a(io.flutter.embedding.engine.a aVar) {
            this.f16524a = aVar;
        }

        @Override // io.flutter.embedding.engine.a.b
        public void a() {
            b.this.f16523a.remove(this.f16524a);
        }

        @Override // io.flutter.embedding.engine.a.b
        public void b() {
        }
    }

    /* JADX INFO: renamed from: io.flutter.embedding.engine.b$b, reason: collision with other inner class name */
    public static class C0257b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f16526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a.c f16527b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f16528c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f16529d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public C2025w f16530e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f16531f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f16532g = false;

        public C0257b(Context context) {
            this.f16526a = context;
        }

        public boolean a() {
            return this.f16531f;
        }

        public Context b() {
            return this.f16526a;
        }

        public a.c c() {
            return this.f16527b;
        }

        public List d() {
            return this.f16529d;
        }

        public String e() {
            return this.f16528c;
        }

        public C2025w f() {
            return this.f16530e;
        }

        public boolean g() {
            return this.f16532g;
        }

        public C0257b h(boolean z7) {
            this.f16531f = z7;
            return this;
        }

        public C0257b i(a.c cVar) {
            this.f16527b = cVar;
            return this;
        }

        public C0257b j(List list) {
            this.f16529d = list;
            return this;
        }

        public C0257b k(String str) {
            this.f16528c = str;
            return this;
        }

        public C0257b l(boolean z7) {
            this.f16532g = z7;
            return this;
        }
    }

    public b(Context context, String[] strArr) {
        f fVarC = J4.a.e().c();
        if (fVarC.n()) {
            return;
        }
        fVarC.r(context.getApplicationContext());
        fVarC.h(context.getApplicationContext(), strArr);
    }

    public io.flutter.embedding.engine.a a(C0257b c0257b) {
        io.flutter.embedding.engine.a aVarE;
        Context contextB = c0257b.b();
        a.c cVarC = c0257b.c();
        String strE = c0257b.e();
        List listD = c0257b.d();
        C2025w c2025wF = c0257b.f();
        if (c2025wF == null) {
            c2025wF = new C2025w();
        }
        C2025w c2025w = c2025wF;
        boolean zA = c0257b.a();
        boolean zG = c0257b.g();
        a.c cVarA = cVarC == null ? a.c.a() : cVarC;
        if (this.f16523a.size() == 0) {
            aVarE = b(contextB, c2025w, zA, zG);
            if (strE != null) {
                aVarE.p().c(strE);
            }
            aVarE.l().j(cVarA, listD);
        } else {
            aVarE = ((io.flutter.embedding.engine.a) this.f16523a.get(0)).E(contextB, cVarA, strE, listD, c2025w, zA, zG);
        }
        this.f16523a.add(aVarE);
        aVarE.f(new a(aVarE));
        return aVarE;
    }

    public io.flutter.embedding.engine.a b(Context context, C2025w c2025w, boolean z7, boolean z8) {
        return new io.flutter.embedding.engine.a(context, null, null, c2025w, null, z7, z8, this);
    }
}
