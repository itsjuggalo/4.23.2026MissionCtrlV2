package E;

import E.g;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import u.C1857e;
import u.C1859g;
import z.AbstractC1964c;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1857e f344a = new C1857e(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f345b = h.a("fonts-androidx", 10, 10000);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f346c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1859g f347d = new C1859g();

    public class a implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ E.e f350c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f351d;

        public a(String str, Context context, E.e eVar, int i4) {
            this.f348a = str;
            this.f349b = context;
            this.f350c = eVar;
            this.f351d = i4;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            return f.c(this.f348a, this.f349b, this.f350c, this.f351d);
        }
    }

    public class b implements G.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ E.a f352a;

        public b(E.a aVar) {
            this.f352a = aVar;
        }

        @Override // G.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f352a.b(eVar);
        }
    }

    public class c implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ E.e f355c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f356d;

        public c(String str, Context context, E.e eVar, int i4) {
            this.f353a = str;
            this.f354b = context;
            this.f355c = eVar;
            this.f356d = i4;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return f.c(this.f353a, this.f354b, this.f355c, this.f356d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    public class d implements G.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f357a;

        public d(String str) {
            this.f357a = str;
        }

        @Override // G.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            synchronized (f.f346c) {
                try {
                    C1859g c1859g = f.f347d;
                    ArrayList arrayList = (ArrayList) c1859g.get(this.f357a);
                    if (arrayList == null) {
                        return;
                    }
                    c1859g.remove(this.f357a);
                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                        ((G.a) arrayList.get(i4)).accept(eVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static String a(E.e eVar, int i4) {
        return eVar.d() + "-" + i4;
    }

    public static int b(g.a aVar) {
        int i4 = 1;
        if (aVar.c() != 0) {
            return aVar.c() != 1 ? -3 : -2;
        }
        g.b[] bVarArrB = aVar.b();
        if (bVarArrB != null && bVarArrB.length != 0) {
            i4 = 0;
            for (g.b bVar : bVarArrB) {
                int iB = bVar.b();
                if (iB != 0) {
                    if (iB < 0) {
                        return -3;
                    }
                    return iB;
                }
            }
        }
        return i4;
    }

    public static e c(String str, Context context, E.e eVar, int i4) {
        C1857e c1857e = f344a;
        Typeface typeface = (Typeface) c1857e.get(str);
        if (typeface != null) {
            return new e(typeface);
        }
        try {
            g.a aVarE = E.d.e(context, eVar, null);
            int iB = b(aVarE);
            if (iB != 0) {
                return new e(iB);
            }
            Typeface typefaceB = AbstractC1964c.b(context, null, aVarE.b(), i4);
            if (typefaceB == null) {
                return new e(-3);
            }
            c1857e.put(str, typefaceB);
            return new e(typefaceB);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        }
    }

    public static Typeface d(Context context, E.e eVar, int i4, Executor executor, E.a aVar) {
        String strA = a(eVar, i4);
        Typeface typeface = (Typeface) f344a.get(strA);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        }
        b bVar = new b(aVar);
        synchronized (f346c) {
            try {
                C1859g c1859g = f347d;
                ArrayList arrayList = (ArrayList) c1859g.get(strA);
                if (arrayList != null) {
                    arrayList.add(bVar);
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(bVar);
                c1859g.put(strA, arrayList2);
                c cVar = new c(strA, context, eVar, i4);
                if (executor == null) {
                    executor = f345b;
                }
                h.b(executor, cVar, new d(strA));
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Typeface e(Context context, E.e eVar, E.a aVar, int i4, int i5) {
        String strA = a(eVar, i4);
        Typeface typeface = (Typeface) f344a.get(strA);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        }
        if (i5 == -1) {
            e eVarC = c(strA, context, eVar, i4);
            aVar.b(eVarC);
            return eVarC.f358a;
        }
        try {
            e eVar2 = (e) h.c(f345b, new a(strA, context, eVar, i4), i5);
            aVar.b(eVar2);
            return eVar2.f358a;
        } catch (InterruptedException unused) {
            aVar.b(new e(-3));
            return null;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Typeface f358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f359b;

        public e(int i4) {
            this.f358a = null;
            this.f359b = i4;
        }

        public boolean a() {
            return this.f359b == 0;
        }

        public e(Typeface typeface) {
            this.f358a = typeface;
            this.f359b = 0;
        }
    }
}
