package u1;

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
import u1.AbstractC2768c;
import v1.i;

/* JADX INFO: renamed from: u1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2769d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f23505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC2768c.b f23506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC2768c.a f23507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f23508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f23509e;

    /* JADX INFO: renamed from: u1.d$a */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f23510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f23511b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f23512c;

        public a(Context context, String str, String str2, AbstractC2768c.InterfaceC0409c interfaceC0409c) {
            this.f23510a = context;
            this.f23511b = str;
            this.f23512c = str2;
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
                u1.d r1 = u1.C2769d.this     // Catch: u1.C2767b -> Ld java.lang.UnsatisfiedLinkError -> Le
                android.content.Context r2 = r5.f23510a     // Catch: u1.C2767b -> Ld java.lang.UnsatisfiedLinkError -> Le
                java.lang.String r3 = r5.f23511b     // Catch: u1.C2767b -> Ld java.lang.UnsatisfiedLinkError -> Le
                java.lang.String r4 = r5.f23512c     // Catch: u1.C2767b -> Ld java.lang.UnsatisfiedLinkError -> Le
                u1.C2769d.a(r1, r2, r3, r4)     // Catch: u1.C2767b -> Ld java.lang.UnsatisfiedLinkError -> Le
                throw r0
            Ld:
                throw r0
            Le:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: u1.C2769d.a.run():void");
        }
    }

    /* JADX INFO: renamed from: u1.d$b */
    public class b implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f23514a;

        public b(String str) {
            this.f23514a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f23514a);
        }
    }

    public C2769d() {
        this(new C2770e(), new C2766a());
    }

    public void b(Context context, String str, String str2) {
        File fileC = c(context);
        File fileD = d(context, str, str2);
        File[] fileArrListFiles = fileC.listFiles(new b(this.f23506b.a(str)));
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (this.f23508d || !file.getAbsolutePath().equals(fileD.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    public File c(Context context) {
        return context.getDir("lib", 0);
    }

    public File d(Context context, String str, String str2) {
        String strA = this.f23506b.a(str);
        if (f.a(str2)) {
            return new File(c(context), strA);
        }
        return new File(c(context), strA + "." + str2);
    }

    public void e(Context context, String str) {
        f(context, str, null, null);
    }

    public void f(Context context, String str, String str2, AbstractC2768c.InterfaceC0409c interfaceC0409c) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if (f.a(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        i("Beginning load of %s...", str);
        if (interfaceC0409c == null) {
            g(context, str, str2);
        } else {
            new Thread(new a(context, str, str2, interfaceC0409c)).start();
        }
    }

    public final void g(Context context, String str, String str2) throws Throwable {
        i iVar;
        if (this.f23505a.contains(str) && !this.f23508d) {
            i("%s already loaded previously!", str);
            return;
        }
        try {
            this.f23506b.b(str);
            this.f23505a.add(str);
            i("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e8) {
            i("Loading the library normally failed: %s", Log.getStackTraceString(e8));
            i("%s (%s) was not loaded normally, re-linking...", str, str2);
            File fileD = d(context, str, str2);
            if (!fileD.exists() || this.f23508d) {
                if (this.f23508d) {
                    i("Forcing a re-link of %s (%s)...", str, str2);
                }
                b(context, str, str2);
                this.f23507c.a(context, this.f23506b.d(), this.f23506b.a(str), fileD, this);
            }
            try {
                if (this.f23509e) {
                    i iVar2 = null;
                    try {
                        iVar = new i(fileD);
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        List listE = iVar.e();
                        iVar.close();
                        Iterator it = listE.iterator();
                        while (it.hasNext()) {
                            e(context, this.f23506b.c((String) it.next()));
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
            this.f23506b.e(fileD.getAbsolutePath());
            this.f23505a.add(str);
            i("%s (%s) was re-linked!", str, str2);
        }
    }

    public void i(String str, Object... objArr) {
        h(String.format(Locale.US, str, objArr));
    }

    public C2769d(AbstractC2768c.b bVar, AbstractC2768c.a aVar) {
        this.f23505a = new HashSet();
        if (bVar == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
        this.f23506b = bVar;
        this.f23507c = aVar;
    }

    public void h(String str) {
    }
}
