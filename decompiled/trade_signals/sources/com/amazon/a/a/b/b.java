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

/* JADX INFO: loaded from: classes.dex */
public class b implements a, d, Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f13678a = new com.amazon.a.a.o.c("CrashManagerImpl");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f13679b = "s-";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f13680c = ".amzst";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f13681d = 99999;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f13682e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private f f13683f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private Application f13684g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f13685h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<c, String> f13686i = new HashMap();

    private String a(c cVar) {
        return com.amazon.a.a.o.c.a.a(cVar);
    }

    private c b(String str) {
        try {
            return (c) com.amazon.a.a.o.c.a.a(c(str));
        } catch (Exception unused) {
            if (!com.amazon.a.a.o.c.f14106b) {
                return null;
            }
            f13678a.b("Failed to load crash report: " + str);
            return null;
        }
    }

    private String c(String str) throws Throwable {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
            while (bufferedReader2.ready()) {
                try {
                    sb.append(bufferedReader2.readLine());
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    com.amazon.a.a.o.a.a(bufferedReader);
                    throw th;
                }
            }
            com.amazon.a.a.o.a.a(bufferedReader2);
            return sb.toString();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void d(String str) {
        try {
            new File(str).delete();
        } catch (Exception e8) {
            if (com.amazon.a.a.o.c.f14106b) {
                f13678a.b("Cannot delete file: " + str, e8);
            }
        }
    }

    private String e(String str) {
        return this.f13684g.getFilesDir().getAbsolutePath() + "/" + str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (com.amazon.a.a.o.c.f14105a) {
            f13678a.a("Crash detected", th);
        }
        try {
            a(th);
            this.f13683f.a(new com.amazon.a.a.b.a.a());
        } catch (Throwable th2) {
            if (com.amazon.a.a.o.c.f14105a) {
                f13678a.a("Error occured while handling exception", th2);
            }
        }
        if (com.amazon.a.a.o.c.f14105a) {
            f13678a.a("Calling previous handler");
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f13685h;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    private void b() {
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof a) {
            return;
        }
        if (com.amazon.a.a.o.c.f14105a) {
            f13678a.a("Registering Crash Handler");
        }
        this.f13685h = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private boolean c() {
        return this.f13686i.size() >= 5;
    }

    private String[] d() {
        return new File(this.f13684g.getFilesDir().getAbsolutePath() + "/").list(new FilenameFilter() { // from class: com.amazon.a.a.b.b.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.endsWith(b.f13680c) && !b.this.f13686i.containsValue(str);
            }
        });
    }

    @Override // com.amazon.a.a.b.a
    public List<c> a() {
        if (c()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        String[] strArrD = d();
        for (int i8 = 0; i8 < strArrD.length && !c(); i8++) {
            String strE = e(strArrD[i8]);
            c cVarB = b(strE);
            if (cVarB != null) {
                this.f13686i.put(cVarB, strE);
                arrayList.add(cVarB);
            } else {
                d(strE);
            }
        }
        return arrayList;
    }

    @Override // com.amazon.a.a.k.d
    public void e() {
        com.amazon.a.a.o.a.a.a();
        b();
    }

    private synchronized void a(String str) {
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            try {
                fileOutputStreamOpenFileOutput = this.f13684g.openFileOutput(f13679b + new Random().nextInt(f13681d) + f13680c, 0);
                fileOutputStreamOpenFileOutput.write(str.getBytes());
            } catch (Exception e8) {
                if (com.amazon.a.a.o.c.f14106b) {
                    f13678a.b("Coud not save crash report to file", e8);
                }
            }
        } finally {
            com.amazon.a.a.o.a.a(fileOutputStreamOpenFileOutput);
        }
    }

    private void a(Throwable th) {
        try {
            a(a(new c(this.f13684g, th)));
        } catch (Throwable th2) {
            if (com.amazon.a.a.o.c.f14106b) {
                f13678a.b("Could not handle uncaught exception", th2);
            }
        }
    }

    @Override // com.amazon.a.a.b.a
    public void a(List<c> list) {
        for (c cVar : list) {
            d(this.f13686i.get(cVar));
            this.f13686i.remove(cVar);
        }
    }
}
