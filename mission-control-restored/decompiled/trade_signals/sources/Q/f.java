package Q;

import Q.g;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import w.i;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w.h f6613a = new w.h(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f6614b = h.a("fonts-androidx", 10, 10000);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f6615c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f6616d = new i();

    public class a implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f6617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f6618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Q.e f6619c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f6620d;

        public a(String str, Context context, Q.e eVar, int i8) {
            this.f6617a = str;
            this.f6618b = context;
            this.f6619c = eVar;
            this.f6620d = i8;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            return f.c(this.f6617a, this.f6618b, this.f6619c, this.f6620d);
        }
    }

    public class b implements S.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Q.a f6621a;

        public b(Q.a aVar) {
            this.f6621a = aVar;
        }

        @Override // S.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f6621a.b(eVar);
        }
    }

    public class c implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f6622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f6623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Q.e f6624c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f6625d;

        public c(String str, Context context, Q.e eVar, int i8) {
            this.f6622a = str;
            this.f6623b = context;
            this.f6624c = eVar;
            this.f6625d = i8;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return f.c(this.f6622a, this.f6623b, this.f6624c, this.f6625d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    public class d implements S.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f6626a;

        public d(String str) {
            this.f6626a = str;
        }

        @Override // S.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            synchronized (f.f6615c) {
                try {
                    i iVar = f.f6616d;
                    ArrayList arrayList = (ArrayList) iVar.get(this.f6626a);
                    if (arrayList == null) {
                        return;
                    }
                    iVar.remove(this.f6626a);
                    for (int i8 = 0; i8 < arrayList.size(); i8++) {
                        ((S.a) arrayList.get(i8)).accept(eVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Typeface f6627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6628b;

        public e(int i8) {
            this.f6627a = null;
            this.f6628b = i8;
        }

        public boolean a() {
            return this.f6628b == 0;
        }

        public e(Typeface typeface) {
            this.f6627a = typeface;
            this.f6628b = 0;
        }
    }

    public static String a(Q.e eVar, int i8) {
        return eVar.d() + "-" + i8;
    }

    public static int b(g.a aVar) {
        int i8 = 1;
        if (aVar.c() != 0) {
            return aVar.c() != 1 ? -3 : -2;
        }
        g.b[] bVarArrB = aVar.b();
        if (bVarArrB != null && bVarArrB.length != 0) {
            i8 = 0;
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
        return i8;
    }

    public static e c(String str, Context context, Q.e eVar, int i8) {
        w.h hVar = f6613a;
        Typeface typeface = (Typeface) hVar.get(str);
        if (typeface != null) {
            return new e(typeface);
        }
        try {
            g.a aVarE = Q.d.e(context, eVar, null);
            int iB = b(aVarE);
            if (iB != 0) {
                return new e(iB);
            }
            Typeface typefaceB = L.d.b(context, null, aVarE.b(), i8);
            if (typefaceB == null) {
                return new e(-3);
            }
            hVar.put(str, typefaceB);
            return new e(typefaceB);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        }
    }

    public static Typeface d(Context context, Q.e eVar, int i8, Executor executor, Q.a aVar) {
        String strA = a(eVar, i8);
        Typeface typeface = (Typeface) f6613a.get(strA);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        }
        b bVar = new b(aVar);
        synchronized (f6615c) {
            try {
                i iVar = f6616d;
                ArrayList arrayList = (ArrayList) iVar.get(strA);
                if (arrayList != null) {
                    arrayList.add(bVar);
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(bVar);
                iVar.put(strA, arrayList2);
                c cVar = new c(strA, context, eVar, i8);
                if (executor == null) {
                    executor = f6614b;
                }
                h.b(executor, cVar, new d(strA));
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Typeface e(Context context, Q.e eVar, Q.a aVar, int i8, int i9) {
        String strA = a(eVar, i8);
        Typeface typeface = (Typeface) f6613a.get(strA);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        }
        if (i9 == -1) {
            e eVarC = c(strA, context, eVar, i8);
            aVar.b(eVarC);
            return eVarC.f6627a;
        }
        try {
            e eVar2 = (e) h.c(f6614b, new a(strA, context, eVar, i8), i9);
            aVar.b(eVar2);
            return eVar2.f6627a;
        } catch (InterruptedException unused) {
            aVar.b(new e(-3));
            return null;
        }
    }
}
