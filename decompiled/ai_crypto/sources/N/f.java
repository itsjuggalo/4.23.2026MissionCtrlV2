package N;

import N.g;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import u.C2740e;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2740e f3910a = new C2740e(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f3911b = h.a("fonts-androidx", 10, 10000);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f3912c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u.g f3913d = new u.g();

    public class a implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f3914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f3915b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ N.e f3916c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f3917d;

        public a(String str, Context context, N.e eVar, int i7) {
            this.f3914a = str;
            this.f3915b = context;
            this.f3916c = eVar;
            this.f3917d = i7;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            return f.c(this.f3914a, this.f3915b, this.f3916c, this.f3917d);
        }
    }

    public class b implements P.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ N.a f3918a;

        public b(N.a aVar) {
            this.f3918a = aVar;
        }

        @Override // P.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f3918a.b(eVar);
        }
    }

    public class c implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f3919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f3920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ N.e f3921c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f3922d;

        public c(String str, Context context, N.e eVar, int i7) {
            this.f3919a = str;
            this.f3920b = context;
            this.f3921c = eVar;
            this.f3922d = i7;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return f.c(this.f3919a, this.f3920b, this.f3921c, this.f3922d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    public class d implements P.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f3923a;

        public d(String str) {
            this.f3923a = str;
        }

        @Override // P.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            synchronized (f.f3912c) {
                try {
                    u.g gVar = f.f3913d;
                    ArrayList arrayList = (ArrayList) gVar.get(this.f3923a);
                    if (arrayList == null) {
                        return;
                    }
                    gVar.remove(this.f3923a);
                    for (int i7 = 0; i7 < arrayList.size(); i7++) {
                        ((P.a) arrayList.get(i7)).accept(eVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static String a(N.e eVar, int i7) {
        return eVar.d() + "-" + i7;
    }

    public static int b(g.a aVar) {
        int i7 = 1;
        if (aVar.c() != 0) {
            return aVar.c() != 1 ? -3 : -2;
        }
        g.b[] bVarArrB = aVar.b();
        if (bVarArrB != null && bVarArrB.length != 0) {
            i7 = 0;
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
        return i7;
    }

    public static e c(String str, Context context, N.e eVar, int i7) {
        C2740e c2740e = f3910a;
        Typeface typeface = (Typeface) c2740e.get(str);
        if (typeface != null) {
            return new e(typeface);
        }
        try {
            g.a aVarE = N.d.e(context, eVar, null);
            int iB = b(aVarE);
            if (iB != 0) {
                return new e(iB);
            }
            Typeface typefaceB = I.d.b(context, null, aVarE.b(), i7);
            if (typefaceB == null) {
                return new e(-3);
            }
            c2740e.put(str, typefaceB);
            return new e(typefaceB);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        }
    }

    public static Typeface d(Context context, N.e eVar, int i7, Executor executor, N.a aVar) {
        String strA = a(eVar, i7);
        Typeface typeface = (Typeface) f3910a.get(strA);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        }
        b bVar = new b(aVar);
        synchronized (f3912c) {
            try {
                u.g gVar = f3913d;
                ArrayList arrayList = (ArrayList) gVar.get(strA);
                if (arrayList != null) {
                    arrayList.add(bVar);
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(bVar);
                gVar.put(strA, arrayList2);
                c cVar = new c(strA, context, eVar, i7);
                if (executor == null) {
                    executor = f3911b;
                }
                h.b(executor, cVar, new d(strA));
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Typeface e(Context context, N.e eVar, N.a aVar, int i7, int i8) {
        String strA = a(eVar, i7);
        Typeface typeface = (Typeface) f3910a.get(strA);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        }
        if (i8 == -1) {
            e eVarC = c(strA, context, eVar, i7);
            aVar.b(eVarC);
            return eVarC.f3924a;
        }
        try {
            e eVar2 = (e) h.c(f3911b, new a(strA, context, eVar, i7), i8);
            aVar.b(eVar2);
            return eVar2.f3924a;
        } catch (InterruptedException unused) {
            aVar.b(new e(-3));
            return null;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Typeface f3924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3925b;

        public e(int i7) {
            this.f3924a = null;
            this.f3925b = i7;
        }

        public boolean a() {
            return this.f3925b == 0;
        }

        public e(Typeface typeface) {
            this.f3924a = typeface;
            this.f3925b = 0;
        }
    }
}
