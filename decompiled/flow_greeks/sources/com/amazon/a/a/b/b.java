package com.amazon.a.a.b;

import android.app.Application;
import com.amazon.a.a.c.f;
import com.amazon.a.a.k.d;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b implements a, d, Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f4203a = new com.amazon.a.a.o.c("CrashManagerImpl");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4204b = "s-";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f4205c = ".amzst";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f4206d = 99999;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f4207e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private f f4208f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private Application f4209g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f4210h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<c, String> f4211i = new HashMap();

    private void b() {
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof a) {
            return;
        }
        if (com.amazon.a.a.o.c.f4603a) {
            f4203a.a("Registering Crash Handler");
        }
        this.f4210h = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private boolean c() {
        return this.f4211i.size() >= 5;
    }

    private String[] d() {
        return new File(this.f4209g.getFilesDir().getAbsolutePath() + "/").list(new FilenameFilter() { // from class: com.amazon.a.a.b.b.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.endsWith(b.f4205c) && !b.this.f4211i.containsValue(str);
            }
        });
    }

    @Override // com.amazon.a.a.k.d
    public void e() {
        com.amazon.a.a.o.a.a.a();
        b();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (com.amazon.a.a.o.c.f4603a) {
            f4203a.a("Crash detected", th);
        }
        try {
            a(th);
            this.f4208f.a(new com.amazon.a.a.b.a.a());
        } catch (Throwable th2) {
            if (com.amazon.a.a.o.c.f4603a) {
                f4203a.a("Error occured while handling exception", th2);
            }
        }
        if (com.amazon.a.a.o.c.f4603a) {
            f4203a.a("Calling previous handler");
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f4210h;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    private void a(Throwable th) {
        try {
            a(a(new c(this.f4209g, th)));
        } catch (Throwable th2) {
            if (com.amazon.a.a.o.c.f4604b) {
                f4203a.b("Could not handle uncaught exception", th2);
            }
        }
    }

    private String c(String str) throws Throwable {
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
            while (bufferedReader2.ready()) {
                try {
                    sb2.append(bufferedReader2.readLine());
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    com.amazon.a.a.o.a.a(bufferedReader);
                    throw th;
                }
            }
            com.amazon.a.a.o.a.a(bufferedReader2);
            return sb2.toString();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private String e(String str) {
        return this.f4209g.getFilesDir().getAbsolutePath() + "/" + str;
    }

    private void d(String str) {
        try {
            new File(str).delete();
        } catch (Exception e10) {
            if (com.amazon.a.a.o.c.f4604b) {
                f4203a.b("Cannot delete file: " + str, e10);
            }
        }
    }

    private c b(String str) {
        try {
            return (c) com.amazon.a.a.o.c.a.a(c(str));
        } catch (Exception unused) {
            if (!com.amazon.a.a.o.c.f4604b) {
                return null;
            }
            f4203a.b("Failed to load crash report: " + str);
            return null;
        }
    }

    private String a(c cVar) {
        return com.amazon.a.a.o.c.a.a(cVar);
    }

    private synchronized void a(String str) {
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            try {
                fileOutputStreamOpenFileOutput = this.f4209g.openFileOutput(f4204b + new Random().nextInt(f4206d) + f4205c, 0);
                fileOutputStreamOpenFileOutput.write(str.getBytes());
            } catch (Exception e10) {
                if (com.amazon.a.a.o.c.f4604b) {
                    f4203a.b("Coud not save crash report to file", e10);
                }
            }
        } finally {
            com.amazon.a.a.o.a.a(fileOutputStreamOpenFileOutput);
        }
    }

    @Override // com.amazon.a.a.b.a
    public List<c> a() {
        if (c()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        String[] strArrD = d();
        for (int i10 = 0; i10 < strArrD.length && !c(); i10++) {
            String strE = e(strArrD[i10]);
            c cVarB = b(strE);
            if (cVarB != null) {
                this.f4211i.put(cVarB, strE);
                arrayList.add(cVarB);
            } else {
                d(strE);
            }
        }
        return arrayList;
    }

    @Override // com.amazon.a.a.b.a
    public void a(List<c> list) {
        for (c cVar : list) {
            d(this.f4211i.get(cVar));
            this.f4211i.remove(cVar);
        }
    }
}
