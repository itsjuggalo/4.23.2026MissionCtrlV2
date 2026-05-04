package g4;

import android.content.Context;
import android.util.Log;
import g4.c;
import h4.i;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f10038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.b f10039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.a f10040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10041d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f10042e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c.d f10043f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f10044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f10045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f10046c;

        public a(Context context, String str, String str2, c.InterfaceC0181c interfaceC0181c) {
            this.f10044a = context;
            this.f10045b = str;
            this.f10046c = str2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
        
            throw null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() throws java.lang.Throwable {
            /*
                r5 = this;
                r0 = 0
                g4.d r1 = g4.d.this     // Catch: g4.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                android.content.Context r2 = r5.f10044a     // Catch: g4.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                java.lang.String r3 = r5.f10045b     // Catch: g4.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                java.lang.String r4 = r5.f10046c     // Catch: g4.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                g4.d.a(r1, r2, r3, r4)     // Catch: g4.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                throw r0
            Ld:
                throw r0
            Le:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: g4.d.a.run():void");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f10048a;

        public b(String str) {
            this.f10048a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f10048a);
        }
    }

    public d() {
        this(new e(), new g4.a());
    }

    public void b(Context context, String str, String str2) {
        File fileC = c(context);
        File fileD = d(context, str, str2);
        File[] fileArrListFiles = fileC.listFiles(new b(this.f10039b.a(str)));
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (this.f10041d || !file.getAbsolutePath().equals(fileD.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    public File c(Context context) {
        return context.getDir("lib", 0);
    }

    public File d(Context context, String str, String str2) {
        String strA = this.f10039b.a(str);
        if (f.a(str2)) {
            return new File(c(context), strA);
        }
        return new File(c(context), strA + "." + str2);
    }

    public void e(Context context, String str) {
        f(context, str, null, null);
    }

    public void f(Context context, String str, String str2, c.InterfaceC0181c interfaceC0181c) throws Throwable {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if (f.a(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        j("Beginning load of %s...", str);
        if (interfaceC0181c == null) {
            g(context, str, str2);
        } else {
            new Thread(new a(context, str, str2, interfaceC0181c)).start();
        }
    }

    public final void g(Context context, String str, String str2) throws Throwable {
        d dVar;
        Context context2;
        i iVar;
        if (this.f10038a.contains(str) && !this.f10041d) {
            j("%s already loaded previously!", str);
            return;
        }
        try {
            this.f10039b.b(str);
            this.f10038a.add(str);
            j("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e10) {
            j("Loading the library normally failed: %s", Log.getStackTraceString(e10));
            j("%s (%s) was not loaded normally, re-linking...", str, str2);
            File fileD = d(context, str, str2);
            if (!fileD.exists() || this.f10041d) {
                if (this.f10041d) {
                    j("Forcing a re-link of %s (%s)...", str, str2);
                }
                b(context, str, str2);
                dVar = this;
                context2 = context;
                this.f10040c.a(context2, this.f10039b.d(), this.f10039b.a(str), fileD, dVar);
            } else {
                dVar = this;
                context2 = context;
            }
            try {
                if (dVar.f10042e) {
                    try {
                        iVar = new i(fileD);
                        try {
                            List listE = iVar.e();
                            iVar.close();
                            Iterator it = listE.iterator();
                            while (it.hasNext()) {
                                e(context2, dVar.f10039b.c((String) it.next()));
                            }
                        } catch (Throwable th) {
                            th = th;
                            Throwable th2 = th;
                            if (iVar == null) {
                                throw th2;
                            }
                            iVar.close();
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        iVar = null;
                    }
                }
            } catch (IOException unused) {
            }
            dVar.f10039b.e(fileD.getAbsolutePath());
            dVar.f10038a.add(str);
            j("%s (%s) was re-linked!", str, str2);
        }
    }

    public d h(c.d dVar) {
        this.f10043f = dVar;
        return this;
    }

    public void i(String str) {
        c.d dVar = this.f10043f;
        if (dVar != null) {
            dVar.a(str);
        }
    }

    public void j(String str, Object... objArr) {
        i(String.format(Locale.US, str, objArr));
    }

    public d(c.b bVar, c.a aVar) {
        this.f10038a = new HashSet();
        if (bVar == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
        this.f10039b = bVar;
        this.f10040c = aVar;
    }
}
