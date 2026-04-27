package V0;

import V0.c;
import W0.i;
import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f5292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.b f5293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.a f5294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c.d f5297f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f5299b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f5300c;

        public a(Context context, String str, String str2, c.InterfaceC0074c interfaceC0074c) {
            this.f5298a = context;
            this.f5299b = str;
            this.f5300c = str2;
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
                V0.d r1 = V0.d.this     // Catch: V0.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                android.content.Context r2 = r5.f5298a     // Catch: V0.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                java.lang.String r3 = r5.f5299b     // Catch: V0.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                java.lang.String r4 = r5.f5300c     // Catch: V0.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                V0.d.a(r1, r2, r3, r4)     // Catch: V0.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                throw r0
            Ld:
                throw r0
            Le:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: V0.d.a.run():void");
        }
    }

    public class b implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f5302a;

        public b(String str) {
            this.f5302a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f5302a);
        }
    }

    public d() {
        this(new e(), new V0.a());
    }

    public void b(Context context, String str, String str2) {
        File fileC = c(context);
        File fileD = d(context, str, str2);
        File[] fileArrListFiles = fileC.listFiles(new b(this.f5293b.a(str)));
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (this.f5295d || !file.getAbsolutePath().equals(fileD.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    public File c(Context context) {
        return context.getDir("lib", 0);
    }

    public File d(Context context, String str, String str2) {
        String strA = this.f5293b.a(str);
        if (f.a(str2)) {
            return new File(c(context), strA);
        }
        return new File(c(context), strA + "." + str2);
    }

    public void e(Context context, String str) {
        f(context, str, null, null);
    }

    public void f(Context context, String str, String str2, c.InterfaceC0074c interfaceC0074c) throws Throwable {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if (f.a(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        j("Beginning load of %s...", str);
        if (interfaceC0074c == null) {
            g(context, str, str2);
        } else {
            new Thread(new a(context, str, str2, interfaceC0074c)).start();
        }
    }

    public final void g(Context context, String str, String str2) throws Throwable {
        d dVar;
        Context context2;
        i iVar;
        if (this.f5292a.contains(str) && !this.f5295d) {
            j("%s already loaded previously!", str);
            return;
        }
        try {
            this.f5293b.b(str);
            this.f5292a.add(str);
            j("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e4) {
            j("Loading the library normally failed: %s", Log.getStackTraceString(e4));
            j("%s (%s) was not loaded normally, re-linking...", str, str2);
            File fileD = d(context, str, str2);
            if (!fileD.exists() || this.f5295d) {
                if (this.f5295d) {
                    j("Forcing a re-link of %s (%s)...", str, str2);
                }
                b(context, str, str2);
                dVar = this;
                context2 = context;
                this.f5294c.a(context2, this.f5293b.d(), this.f5293b.a(str), fileD, dVar);
            } else {
                dVar = this;
                context2 = context;
            }
            try {
                if (dVar.f5296e) {
                    try {
                        iVar = new i(fileD);
                        try {
                            List listG = iVar.g();
                            iVar.close();
                            Iterator it = listG.iterator();
                            while (it.hasNext()) {
                                e(context2, dVar.f5293b.c((String) it.next()));
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
            dVar.f5293b.e(fileD.getAbsolutePath());
            dVar.f5292a.add(str);
            j("%s (%s) was re-linked!", str, str2);
        }
    }

    public d h(c.d dVar) {
        this.f5297f = dVar;
        return this;
    }

    public void i(String str) {
        c.d dVar = this.f5297f;
        if (dVar != null) {
            dVar.a(str);
        }
    }

    public void j(String str, Object... objArr) {
        i(String.format(Locale.US, str, objArr));
    }

    public d(c.b bVar, c.a aVar) {
        this.f5292a = new HashSet();
        if (bVar == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
        this.f5293b = bVar;
        this.f5294c = aVar;
    }
}
