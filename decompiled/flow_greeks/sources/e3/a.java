package e3;

import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f8334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f8335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f8336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f8337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f8339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f8340g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Writer f8342i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8344k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f8341h = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashMap f8343j = new LinkedHashMap(0, 0.75f, true);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f8345l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ThreadPoolExecutor f8346m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Callable f8347n = new CallableC0155a();

    /* JADX INFO: renamed from: e3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class CallableC0155a implements Callable {
        public CallableC0155a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (a.this) {
                try {
                    if (a.this.f8342i == null) {
                        return null;
                    }
                    a.this.l0();
                    if (a.this.d0()) {
                        a.this.i0();
                        a.this.f8344k = 0;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements ThreadFactory {
        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        public /* synthetic */ b(CallableC0155a callableC0155a) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f8349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f8350b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8351c;

        public /* synthetic */ c(a aVar, d dVar, CallableC0155a callableC0155a) {
            this(dVar);
        }

        public void a() {
            a.this.N(this, false);
        }

        public void b() {
            if (this.f8351c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void e() {
            a.this.N(this, true);
            this.f8351c = true;
        }

        public File f(int i10) {
            File fileK;
            synchronized (a.this) {
                try {
                    if (this.f8349a.f8358f != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f8349a.f8357e) {
                        this.f8350b[i10] = true;
                    }
                    fileK = this.f8349a.k(i10);
                    a.this.f8334a.mkdirs();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return fileK;
        }

        public c(d dVar) {
            this.f8349a = dVar;
            this.f8350b = dVar.f8357e ? null : new boolean[a.this.f8340g];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f8354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public File[] f8355c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public File[] f8356d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f8357e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public c f8358f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f8359g;

        public /* synthetic */ d(a aVar, String str, CallableC0155a callableC0155a) {
            this(str);
        }

        public File j(int i10) {
            return this.f8355c[i10];
        }

        public File k(int i10) {
            return this.f8356d[i10];
        }

        public String l() {
            StringBuilder sb2 = new StringBuilder();
            for (long j10 : this.f8354b) {
                sb2.append(' ');
                sb2.append(j10);
            }
            return sb2.toString();
        }

        public final IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final void n(String[] strArr) throws IOException {
            if (strArr.length != a.this.f8340g) {
                throw m(strArr);
            }
            for (int i10 = 0; i10 < strArr.length; i10++) {
                try {
                    this.f8354b[i10] = Long.parseLong(strArr[i10]);
                } catch (NumberFormatException unused) {
                    throw m(strArr);
                }
            }
        }

        public d(String str) {
            this.f8353a = str;
            this.f8354b = new long[a.this.f8340g];
            this.f8355c = new File[a.this.f8340g];
            this.f8356d = new File[a.this.f8340g];
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append(com.amazon.a.a.o.c.a.b.f4610a);
            int length = sb2.length();
            for (int i10 = 0; i10 < a.this.f8340g; i10++) {
                sb2.append(i10);
                this.f8355c[i10] = new File(a.this.f8334a, sb2.toString());
                sb2.append(".tmp");
                this.f8356d[i10] = new File(a.this.f8334a, sb2.toString());
                sb2.setLength(length);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f8362b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long[] f8363c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final File[] f8364d;

        public /* synthetic */ e(a aVar, String str, long j10, File[] fileArr, long[] jArr, CallableC0155a callableC0155a) {
            this(str, j10, fileArr, jArr);
        }

        public File a(int i10) {
            return this.f8364d[i10];
        }

        public e(String str, long j10, File[] fileArr, long[] jArr) {
            this.f8361a = str;
            this.f8362b = j10;
            this.f8364d = fileArr;
            this.f8363c = jArr;
        }
    }

    public a(File file, int i10, int i11, long j10) {
        this.f8334a = file;
        this.f8338e = i10;
        this.f8335b = new File(file, "journal");
        this.f8336c = new File(file, "journal.tmp");
        this.f8337d = new File(file, "journal.bkp");
        this.f8340g = i11;
        this.f8339f = j10;
    }

    public static void K(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void R(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void b0(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static a e0(File file, int i10, int i11, long j10) throws IOException {
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i11 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                k0(file2, file3, false);
            }
        }
        a aVar = new a(file, i10, i11, j10);
        if (aVar.f8335b.exists()) {
            try {
                aVar.g0();
                aVar.f0();
                return aVar;
            } catch (IOException e10) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e10.getMessage() + ", removing");
                aVar.O();
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, i10, i11, j10);
        aVar2.i0();
        return aVar2;
    }

    public static void k0(File file, File file2, boolean z10) throws IOException {
        if (z10) {
            R(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public final void H() {
        if (this.f8342i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void N(c cVar, boolean z10) {
        d dVar = cVar.f8349a;
        if (dVar.f8358f != cVar) {
            throw new IllegalStateException();
        }
        if (z10 && !dVar.f8357e) {
            for (int i10 = 0; i10 < this.f8340g; i10++) {
                if (!cVar.f8350b[i10]) {
                    cVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                }
                if (!dVar.k(i10).exists()) {
                    cVar.a();
                    return;
                }
            }
        }
        for (int i11 = 0; i11 < this.f8340g; i11++) {
            File fileK = dVar.k(i11);
            if (!z10) {
                R(fileK);
            } else if (fileK.exists()) {
                File fileJ = dVar.j(i11);
                fileK.renameTo(fileJ);
                long j10 = dVar.f8354b[i11];
                long length = fileJ.length();
                dVar.f8354b[i11] = length;
                this.f8341h = (this.f8341h - j10) + length;
            }
        }
        this.f8344k++;
        dVar.f8358f = null;
        if (dVar.f8357e || z10) {
            dVar.f8357e = true;
            this.f8342i.append((CharSequence) "CLEAN");
            this.f8342i.append(' ');
            this.f8342i.append((CharSequence) dVar.f8353a);
            this.f8342i.append((CharSequence) dVar.l());
            this.f8342i.append('\n');
            if (z10) {
                long j11 = this.f8345l;
                this.f8345l = 1 + j11;
                dVar.f8359g = j11;
            }
        } else {
            this.f8343j.remove(dVar.f8353a);
            this.f8342i.append((CharSequence) "REMOVE");
            this.f8342i.append(' ');
            this.f8342i.append((CharSequence) dVar.f8353a);
            this.f8342i.append('\n');
        }
        b0(this.f8342i);
        if (this.f8341h > this.f8339f || d0()) {
            this.f8346m.submit(this.f8347n);
        }
    }

    public void O() throws IOException {
        close();
        e3.c.b(this.f8334a);
    }

    public c Z(String str) {
        return a0(str, -1L);
    }

    public final synchronized c a0(String str, long j10) {
        H();
        d dVar = (d) this.f8343j.get(str);
        CallableC0155a callableC0155a = null;
        if (j10 != -1 && (dVar == null || dVar.f8359g != j10)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, callableC0155a);
            this.f8343j.put(str, dVar);
        } else if (dVar.f8358f != null) {
            return null;
        }
        c cVar = new c(this, dVar, callableC0155a);
        dVar.f8358f = cVar;
        this.f8342i.append((CharSequence) "DIRTY");
        this.f8342i.append(' ');
        this.f8342i.append((CharSequence) str);
        this.f8342i.append('\n');
        b0(this.f8342i);
        return cVar;
    }

    public synchronized e c0(String str) throws Throwable {
        Throwable th;
        try {
            try {
                H();
                d dVar = (d) this.f8343j.get(str);
                if (dVar == null) {
                    return null;
                }
                if (!dVar.f8357e) {
                    return null;
                }
                for (File file : dVar.f8355c) {
                    try {
                        if (!file.exists()) {
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                this.f8344k++;
                this.f8342i.append((CharSequence) "READ");
                this.f8342i.append(' ');
                this.f8342i.append((CharSequence) str);
                this.f8342i.append('\n');
                if (d0()) {
                    this.f8346m.submit(this.f8347n);
                }
                return new e(this, str, dVar.f8359g, dVar.f8355c, dVar.f8354b, null);
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        th = th;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.f8342i == null) {
                return;
            }
            for (d dVar : new ArrayList(this.f8343j.values())) {
                if (dVar.f8358f != null) {
                    dVar.f8358f.a();
                }
            }
            l0();
            K(this.f8342i);
            this.f8342i = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final boolean d0() {
        int i10 = this.f8344k;
        return i10 >= 2000 && i10 >= this.f8343j.size();
    }

    public final void f0() throws IOException {
        R(this.f8336c);
        Iterator it = this.f8343j.values().iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            int i10 = 0;
            if (dVar.f8358f == null) {
                while (i10 < this.f8340g) {
                    this.f8341h += dVar.f8354b[i10];
                    i10++;
                }
            } else {
                dVar.f8358f = null;
                while (i10 < this.f8340g) {
                    R(dVar.j(i10));
                    R(dVar.k(i10));
                    i10++;
                }
                it.remove();
            }
        }
    }

    public final void g0() {
        e3.b bVar = new e3.b(new FileInputStream(this.f8335b), e3.c.f8372a);
        try {
            String strO = bVar.o();
            String strO2 = bVar.o();
            String strO3 = bVar.o();
            String strO4 = bVar.o();
            String strO5 = bVar.o();
            if (!"libcore.io.DiskLruCache".equals(strO) || !"1".equals(strO2) || !Integer.toString(this.f8338e).equals(strO3) || !Integer.toString(this.f8340g).equals(strO4) || !"".equals(strO5)) {
                throw new IOException("unexpected journal header: [" + strO + ", " + strO2 + ", " + strO4 + ", " + strO5 + "]");
            }
            int i10 = 0;
            while (true) {
                try {
                    h0(bVar.o());
                    i10++;
                } catch (EOFException unused) {
                    this.f8344k = i10 - this.f8343j.size();
                    if (bVar.e()) {
                        i0();
                    } else {
                        this.f8342i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f8335b, true), e3.c.f8372a));
                    }
                    e3.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            e3.c.a(bVar);
            throw th;
        }
    }

    public final void h0(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i10 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i10);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i10);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.f8343j.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i10, iIndexOf2);
        }
        d dVar = (d) this.f8343j.get(strSubstring);
        CallableC0155a callableC0155a = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, callableC0155a);
            this.f8343j.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.f8357e = true;
            dVar.f8358f = null;
            dVar.n(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            dVar.f8358f = new c(this, dVar, callableC0155a);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public final synchronized void i0() {
        try {
            Writer writer = this.f8342i;
            if (writer != null) {
                K(writer);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f8336c), e3.c.f8372a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f8338e));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f8340g));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (d dVar : this.f8343j.values()) {
                    if (dVar.f8358f != null) {
                        bufferedWriter.write("DIRTY " + dVar.f8353a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + dVar.f8353a + dVar.l() + '\n');
                    }
                }
                K(bufferedWriter);
                if (this.f8335b.exists()) {
                    k0(this.f8335b, this.f8337d, true);
                }
                k0(this.f8336c, this.f8335b, false);
                this.f8337d.delete();
                this.f8342i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f8335b, true), e3.c.f8372a));
            } catch (Throwable th) {
                K(bufferedWriter);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized boolean j0(String str) {
        try {
            H();
            d dVar = (d) this.f8343j.get(str);
            if (dVar != null && dVar.f8358f == null) {
                for (int i10 = 0; i10 < this.f8340g; i10++) {
                    File fileJ = dVar.j(i10);
                    if (fileJ.exists() && !fileJ.delete()) {
                        throw new IOException("failed to delete " + fileJ);
                    }
                    this.f8341h -= dVar.f8354b[i10];
                    dVar.f8354b[i10] = 0;
                }
                this.f8344k++;
                this.f8342i.append((CharSequence) "REMOVE");
                this.f8342i.append(' ');
                this.f8342i.append((CharSequence) str);
                this.f8342i.append('\n');
                this.f8343j.remove(str);
                if (d0()) {
                    this.f8346m.submit(this.f8347n);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    public final void l0() {
        while (this.f8341h > this.f8339f) {
            j0((String) ((Map.Entry) this.f8343j.entrySet().iterator().next()).getKey());
        }
    }
}
