package m1;

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
import m1.AbstractC2229c;
import n1.i;

/* JADX INFO: renamed from: m1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2230d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f18943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC2229c.b f18944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC2229c.a f18945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f18946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f18947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AbstractC2229c.d f18948f;

    /* JADX INFO: renamed from: m1.d$a */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f18949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f18950b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f18951c;

        public a(Context context, String str, String str2, AbstractC2229c.InterfaceC0310c interfaceC0310c) {
            this.f18949a = context;
            this.f18950b = str;
            this.f18951c = str2;
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
                m1.d r1 = m1.C2230d.this     // Catch: m1.C2228b -> Ld java.lang.UnsatisfiedLinkError -> Le
                android.content.Context r2 = r5.f18949a     // Catch: m1.C2228b -> Ld java.lang.UnsatisfiedLinkError -> Le
                java.lang.String r3 = r5.f18950b     // Catch: m1.C2228b -> Ld java.lang.UnsatisfiedLinkError -> Le
                java.lang.String r4 = r5.f18951c     // Catch: m1.C2228b -> Ld java.lang.UnsatisfiedLinkError -> Le
                m1.C2230d.a(r1, r2, r3, r4)     // Catch: m1.C2228b -> Ld java.lang.UnsatisfiedLinkError -> Le
                throw r0
            Ld:
                throw r0
            Le:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: m1.C2230d.a.run():void");
        }
    }

    /* JADX INFO: renamed from: m1.d$b */
    public class b implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18953a;

        public b(String str) {
            this.f18953a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f18953a);
        }
    }

    public C2230d() {
        this(new C2231e(), new C2227a());
    }

    public void b(Context context, String str, String str2) {
        File fileC = c(context);
        File fileD = d(context, str, str2);
        File[] fileArrListFiles = fileC.listFiles(new b(this.f18944b.a(str)));
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (this.f18946d || !file.getAbsolutePath().equals(fileD.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    public File c(Context context) {
        return context.getDir("lib", 0);
    }

    public File d(Context context, String str, String str2) {
        String strA = this.f18944b.a(str);
        if (AbstractC2232f.a(str2)) {
            return new File(c(context), strA);
        }
        return new File(c(context), strA + "." + str2);
    }

    public void e(Context context, String str) {
        f(context, str, null, null);
    }

    public void f(Context context, String str, String str2, AbstractC2229c.InterfaceC0310c interfaceC0310c) throws Throwable {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if (AbstractC2232f.a(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        j("Beginning load of %s...", str);
        if (interfaceC0310c == null) {
            g(context, str, str2);
        } else {
            new Thread(new a(context, str, str2, interfaceC0310c)).start();
        }
    }

    public final void g(Context context, String str, String str2) throws Throwable {
        i iVar;
        if (this.f18943a.contains(str) && !this.f18946d) {
            j("%s already loaded previously!", str);
            return;
        }
        try {
            this.f18944b.b(str);
            this.f18943a.add(str);
            j("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e7) {
            j("Loading the library normally failed: %s", Log.getStackTraceString(e7));
            j("%s (%s) was not loaded normally, re-linking...", str, str2);
            File fileD = d(context, str, str2);
            if (!fileD.exists() || this.f18946d) {
                if (this.f18946d) {
                    j("Forcing a re-link of %s (%s)...", str, str2);
                }
                b(context, str, str2);
                this.f18945c.a(context, this.f18944b.d(), this.f18944b.a(str), fileD, this);
            }
            try {
                if (this.f18947e) {
                    i iVar2 = null;
                    try {
                        iVar = new i(fileD);
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        List listA = iVar.A();
                        iVar.close();
                        Iterator it = listA.iterator();
                        while (it.hasNext()) {
                            e(context, this.f18944b.c((String) it.next()));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        iVar2 = iVar;
                        if (iVar2 != null) {
                            iVar2.close();
                        }
                        throw th;
                    }
                }
            } catch (IOException unused) {
            }
            this.f18944b.e(fileD.getAbsolutePath());
            this.f18943a.add(str);
            j("%s (%s) was re-linked!", str, str2);
        }
    }

    public C2230d h(AbstractC2229c.d dVar) {
        this.f18948f = dVar;
        return this;
    }

    public void i(String str) {
        AbstractC2229c.d dVar = this.f18948f;
        if (dVar != null) {
            dVar.a(str);
        }
    }

    public void j(String str, Object... objArr) {
        i(String.format(Locale.US, str, objArr));
    }

    public C2230d(AbstractC2229c.b bVar, AbstractC2229c.a aVar) {
        this.f18943a = new HashSet();
        if (bVar == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
        this.f18944b = bVar;
        this.f18945c = aVar;
    }
}
