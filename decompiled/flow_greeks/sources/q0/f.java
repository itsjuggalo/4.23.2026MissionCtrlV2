package q0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import q0.g;
import w.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w.h f18721a = new w.h(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f18722b = h.a("fonts-androidx", 10, 10000);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f18723c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f18724d = new i();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f18726b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ q0.e f18727c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f18728d;

        public a(String str, Context context, q0.e eVar, int i10) {
            this.f18725a = str;
            this.f18726b = context;
            this.f18727c = eVar;
            this.f18728d = i10;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            return f.c(this.f18725a, this.f18726b, l0.f.a(new Object[]{this.f18727c}), this.f18728d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements s0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q0.a f18729a;

        public b(q0.a aVar) {
            this.f18729a = aVar;
        }

        @Override // s0.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f18729a.b(eVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f18731b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f18732c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f18733d;

        public c(String str, Context context, List list, int i10) {
            this.f18730a = str;
            this.f18731b = context;
            this.f18732c = list;
            this.f18733d = i10;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return f.c(this.f18730a, this.f18731b, this.f18732c, this.f18733d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements s0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18734a;

        public d(String str) {
            this.f18734a = str;
        }

        @Override // s0.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            synchronized (f.f18723c) {
                try {
                    i iVar = f.f18724d;
                    ArrayList arrayList = (ArrayList) iVar.get(this.f18734a);
                    if (arrayList == null) {
                        return;
                    }
                    iVar.remove(this.f18734a);
                    for (int i10 = 0; i10 < arrayList.size(); i10++) {
                        ((s0.a) arrayList.get(i10)).accept(eVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static String a(List list, int i10) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < list.size(); i11++) {
            sb2.append(((q0.e) list.get(i11)).d());
            sb2.append("-");
            sb2.append(i10);
            if (i11 < list.size() - 1) {
                sb2.append(";");
            }
        }
        return sb2.toString();
    }

    public static int b(g.a aVar) {
        int i10 = 1;
        if (aVar.e() != 0) {
            return aVar.e() != 1 ? -3 : -2;
        }
        g.b[] bVarArrC = aVar.c();
        if (bVarArrC != null && bVarArrC.length != 0) {
            i10 = 0;
            for (g.b bVar : bVarArrC) {
                int iB = bVar.b();
                if (iB != 0) {
                    if (iB < 0) {
                        return -3;
                    }
                    return iB;
                }
            }
        }
        return i10;
    }

    public static e c(String str, Context context, List list, int i10) {
        m2.a.c("getFontSync");
        try {
            w.h hVar = f18721a;
            Typeface typeface = (Typeface) hVar.get(str);
            if (typeface != null) {
                return new e(typeface);
            }
            g.a aVarE = q0.d.e(context, list, null);
            int iB = b(aVarE);
            if (iB != 0) {
                return new e(iB);
            }
            Typeface typefaceB = (!aVarE.f() || Build.VERSION.SDK_INT < 29) ? l0.g.b(context, null, aVarE.c(), i10) : l0.g.c(context, null, aVarE.d(), i10);
            if (typefaceB == null) {
                return new e(-3);
            }
            hVar.put(str, typefaceB);
            return new e(typefaceB);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        } finally {
            m2.a.f();
        }
    }

    public static Typeface d(Context context, List list, int i10, Executor executor, q0.a aVar) {
        String strA = a(list, i10);
        Typeface typeface = (Typeface) f18721a.get(strA);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        }
        b bVar = new b(aVar);
        synchronized (f18723c) {
            try {
                i iVar = f18724d;
                ArrayList arrayList = (ArrayList) iVar.get(strA);
                if (arrayList != null) {
                    arrayList.add(bVar);
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(bVar);
                iVar.put(strA, arrayList2);
                c cVar = new c(strA, context, list, i10);
                if (executor == null) {
                    executor = f18722b;
                }
                h.c(executor, cVar, new d(strA));
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Typeface e(Context context, q0.e eVar, q0.a aVar, int i10, int i11) {
        String strA = a(l0.f.a(new Object[]{eVar}), i10);
        Typeface typeface = (Typeface) f18721a.get(strA);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        }
        if (i11 == -1) {
            e eVarC = c(strA, context, l0.f.a(new Object[]{eVar}), i10);
            aVar.b(eVarC);
            return eVarC.f18735a;
        }
        try {
            e eVar2 = (e) h.d(f18722b, new a(strA, context, eVar, i10), i11);
            aVar.b(eVar2);
            return eVar2.f18735a;
        } catch (InterruptedException unused) {
            aVar.b(new e(-3));
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Typeface f18735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f18736b;

        public e(int i10) {
            this.f18735a = null;
            this.f18736b = i10;
        }

        public boolean a() {
            return this.f18736b == 0;
        }

        public e(Typeface typeface) {
            this.f18735a = typeface;
            this.f18736b = 0;
        }
    }
}
