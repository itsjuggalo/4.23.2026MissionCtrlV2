package S0;

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

/* JADX INFO: loaded from: classes.dex */
public final class b implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f7294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f7295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f7296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f7297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f7298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f7299f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f7300g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Writer f7302i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f7304k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f7301h = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashMap f7303j = new LinkedHashMap(0, 0.75f, true);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f7305l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ThreadPoolExecutor f7306m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0106b(null));

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Callable f7307n = new a();

    public class a implements Callable {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (b.this) {
                try {
                    if (b.this.f7302i == null) {
                        return null;
                    }
                    b.this.v0();
                    if (b.this.U()) {
                        b.this.m0();
                        b.this.f7304k = 0;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: renamed from: S0.b$b, reason: collision with other inner class name */
    public static final class ThreadFactoryC0106b implements ThreadFactory {
        public ThreadFactoryC0106b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        public /* synthetic */ ThreadFactoryC0106b(a aVar) {
            this();
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f7309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f7310b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f7311c;

        public c(d dVar) {
            this.f7309a = dVar;
            this.f7310b = dVar.f7317e ? null : new boolean[b.this.f7300g];
        }

        public void a() {
            b.this.M(this, false);
        }

        public void b() {
            if (this.f7311c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void e() {
            b.this.M(this, true);
            this.f7311c = true;
        }

        public File f(int i8) {
            File fileK;
            synchronized (b.this) {
                try {
                    if (this.f7309a.f7318f != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f7309a.f7317e) {
                        this.f7310b[i8] = true;
                    }
                    fileK = this.f7309a.k(i8);
                    b.this.f7294a.mkdirs();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return fileK;
        }

        public /* synthetic */ c(b bVar, d dVar, a aVar) {
            this(dVar);
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f7314b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public File[] f7315c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public File[] f7316d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f7317e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public c f7318f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f7319g;

        public d(String str) {
            this.f7313a = str;
            this.f7314b = new long[b.this.f7300g];
            this.f7315c = new File[b.this.f7300g];
            this.f7316d = new File[b.this.f7300g];
            StringBuilder sb = new StringBuilder(str);
            sb.append(com.amazon.a.a.o.c.a.b.f14112a);
            int length = sb.length();
            for (int i8 = 0; i8 < b.this.f7300g; i8++) {
                sb.append(i8);
                this.f7315c[i8] = new File(b.this.f7294a, sb.toString());
                sb.append(".tmp");
                this.f7316d[i8] = new File(b.this.f7294a, sb.toString());
                sb.setLength(length);
            }
        }

        public File j(int i8) {
            return this.f7315c[i8];
        }

        public File k(int i8) {
            return this.f7316d[i8];
        }

        public String l() {
            StringBuilder sb = new StringBuilder();
            for (long j8 : this.f7314b) {
                sb.append(' ');
                sb.append(j8);
            }
            return sb.toString();
        }

        public final IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final void n(String[] strArr) throws IOException {
            if (strArr.length != b.this.f7300g) {
                throw m(strArr);
            }
            for (int i8 = 0; i8 < strArr.length; i8++) {
                try {
                    this.f7314b[i8] = Long.parseLong(strArr[i8]);
                } catch (NumberFormatException unused) {
                    throw m(strArr);
                }
            }
        }

        public /* synthetic */ d(b bVar, String str, a aVar) {
            this(str);
        }
    }

    public final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f7322b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long[] f7323c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final File[] f7324d;

        public e(String str, long j8, File[] fileArr, long[] jArr) {
            this.f7321a = str;
            this.f7322b = j8;
            this.f7324d = fileArr;
            this.f7323c = jArr;
        }

        public File a(int i8) {
            return this.f7324d[i8];
        }

        public /* synthetic */ e(b bVar, String str, long j8, File[] fileArr, long[] jArr, a aVar) {
            this(str, j8, fileArr, jArr);
        }
    }

    public b(File file, int i8, int i9, long j8) {
        this.f7294a = file;
        this.f7298e = i8;
        this.f7295b = new File(file, "journal");
        this.f7296c = new File(file, "journal.tmp");
        this.f7297d = new File(file, "journal.bkp");
        this.f7300g = i9;
        this.f7299f = j8;
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

    public static void O(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void S(Writer writer) throws IOException {
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

    public static b W(File file, int i8, int i9, long j8) throws IOException {
        if (j8 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i9 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                s0(file2, file3, false);
            }
        }
        b bVar = new b(file, i8, i9, j8);
        if (bVar.f7295b.exists()) {
            try {
                bVar.b0();
                bVar.X();
                return bVar;
            } catch (IOException e8) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e8.getMessage() + ", removing");
                bVar.N();
            }
        }
        file.mkdirs();
        b bVar2 = new b(file, i8, i9, j8);
        bVar2.m0();
        return bVar2;
    }

    public static void s0(File file, File file2, boolean z7) throws IOException {
        if (z7) {
            O(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public final void E() {
        if (this.f7302i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void M(c cVar, boolean z7) {
        d dVar = cVar.f7309a;
        if (dVar.f7318f != cVar) {
            throw new IllegalStateException();
        }
        if (z7 && !dVar.f7317e) {
            for (int i8 = 0; i8 < this.f7300g; i8++) {
                if (!cVar.f7310b[i8]) {
                    cVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i8);
                }
                if (!dVar.k(i8).exists()) {
                    cVar.a();
                    return;
                }
            }
        }
        for (int i9 = 0; i9 < this.f7300g; i9++) {
            File fileK = dVar.k(i9);
            if (!z7) {
                O(fileK);
            } else if (fileK.exists()) {
                File fileJ = dVar.j(i9);
                fileK.renameTo(fileJ);
                long j8 = dVar.f7314b[i9];
                long length = fileJ.length();
                dVar.f7314b[i9] = length;
                this.f7301h = (this.f7301h - j8) + length;
            }
        }
        this.f7304k++;
        dVar.f7318f = null;
        if (dVar.f7317e || z7) {
            dVar.f7317e = true;
            this.f7302i.append((CharSequence) "CLEAN");
            this.f7302i.append(' ');
            this.f7302i.append((CharSequence) dVar.f7313a);
            this.f7302i.append((CharSequence) dVar.l());
            this.f7302i.append('\n');
            if (z7) {
                long j9 = this.f7305l;
                this.f7305l = 1 + j9;
                dVar.f7319g = j9;
            }
        } else {
            this.f7303j.remove(dVar.f7313a);
            this.f7302i.append((CharSequence) "REMOVE");
            this.f7302i.append(' ');
            this.f7302i.append((CharSequence) dVar.f7313a);
            this.f7302i.append('\n');
        }
        S(this.f7302i);
        if (this.f7301h > this.f7299f || U()) {
            this.f7306m.submit(this.f7307n);
        }
    }

    public void N() throws IOException {
        close();
        S0.d.b(this.f7294a);
    }

    public c Q(String str) {
        return R(str, -1L);
    }

    public final synchronized c R(String str, long j8) {
        E();
        d dVar = (d) this.f7303j.get(str);
        a aVar = null;
        if (j8 != -1 && (dVar == null || dVar.f7319g != j8)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, aVar);
            this.f7303j.put(str, dVar);
        } else if (dVar.f7318f != null) {
            return null;
        }
        c cVar = new c(this, dVar, aVar);
        dVar.f7318f = cVar;
        this.f7302i.append((CharSequence) "DIRTY");
        this.f7302i.append(' ');
        this.f7302i.append((CharSequence) str);
        this.f7302i.append('\n');
        S(this.f7302i);
        return cVar;
    }

    public synchronized e T(String str) {
        E();
        d dVar = (d) this.f7303j.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f7317e) {
            return null;
        }
        for (File file : dVar.f7315c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f7304k++;
        this.f7302i.append((CharSequence) "READ");
        this.f7302i.append(' ');
        this.f7302i.append((CharSequence) str);
        this.f7302i.append('\n');
        if (U()) {
            this.f7306m.submit(this.f7307n);
        }
        return new e(this, str, dVar.f7319g, dVar.f7315c, dVar.f7314b, null);
    }

    public final boolean U() {
        int i8 = this.f7304k;
        return i8 >= 2000 && i8 >= this.f7303j.size();
    }

    public final void X() throws IOException {
        O(this.f7296c);
        Iterator it = this.f7303j.values().iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            int i8 = 0;
            if (dVar.f7318f == null) {
                while (i8 < this.f7300g) {
                    this.f7301h += dVar.f7314b[i8];
                    i8++;
                }
            } else {
                dVar.f7318f = null;
                while (i8 < this.f7300g) {
                    O(dVar.j(i8));
                    O(dVar.k(i8));
                    i8++;
                }
                it.remove();
            }
        }
    }

    public final void b0() {
        S0.c cVar = new S0.c(new FileInputStream(this.f7295b), S0.d.f7332a);
        try {
            String strF = cVar.f();
            String strF2 = cVar.f();
            String strF3 = cVar.f();
            String strF4 = cVar.f();
            String strF5 = cVar.f();
            if (!"libcore.io.DiskLruCache".equals(strF) || !"1".equals(strF2) || !Integer.toString(this.f7298e).equals(strF3) || !Integer.toString(this.f7300g).equals(strF4) || !"".equals(strF5)) {
                throw new IOException("unexpected journal header: [" + strF + ", " + strF2 + ", " + strF4 + ", " + strF5 + "]");
            }
            int i8 = 0;
            while (true) {
                try {
                    i0(cVar.f());
                    i8++;
                } catch (EOFException unused) {
                    this.f7304k = i8 - this.f7303j.size();
                    if (cVar.e()) {
                        m0();
                    } else {
                        this.f7302i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f7295b, true), S0.d.f7332a));
                    }
                    S0.d.a(cVar);
                    return;
                }
            }
        } catch (Throwable th) {
            S0.d.a(cVar);
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.f7302i == null) {
                return;
            }
            for (d dVar : new ArrayList(this.f7303j.values())) {
                if (dVar.f7318f != null) {
                    dVar.f7318f.a();
                }
            }
            v0();
            K(this.f7302i);
            this.f7302i = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void i0(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i8 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i8);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i8);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.f7303j.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i8, iIndexOf2);
        }
        d dVar = (d) this.f7303j.get(strSubstring);
        a aVar = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, aVar);
            this.f7303j.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.f7317e = true;
            dVar.f7318f = null;
            dVar.n(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            dVar.f7318f = new c(this, dVar, aVar);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public final synchronized void m0() {
        try {
            Writer writer = this.f7302i;
            if (writer != null) {
                K(writer);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f7296c), S0.d.f7332a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f7298e));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f7300g));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (d dVar : this.f7303j.values()) {
                    bufferedWriter.write(dVar.f7318f != null ? "DIRTY " + dVar.f7313a + '\n' : "CLEAN " + dVar.f7313a + dVar.l() + '\n');
                }
                K(bufferedWriter);
                if (this.f7295b.exists()) {
                    s0(this.f7295b, this.f7297d, true);
                }
                s0(this.f7296c, this.f7295b, false);
                this.f7297d.delete();
                this.f7302i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f7295b, true), S0.d.f7332a));
            } catch (Throwable th) {
                K(bufferedWriter);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized boolean r0(String str) {
        try {
            E();
            d dVar = (d) this.f7303j.get(str);
            if (dVar != null && dVar.f7318f == null) {
                for (int i8 = 0; i8 < this.f7300g; i8++) {
                    File fileJ = dVar.j(i8);
                    if (fileJ.exists() && !fileJ.delete()) {
                        throw new IOException("failed to delete " + fileJ);
                    }
                    this.f7301h -= dVar.f7314b[i8];
                    dVar.f7314b[i8] = 0;
                }
                this.f7304k++;
                this.f7302i.append((CharSequence) "REMOVE");
                this.f7302i.append(' ');
                this.f7302i.append((CharSequence) str);
                this.f7302i.append('\n');
                this.f7303j.remove(str);
                if (U()) {
                    this.f7306m.submit(this.f7307n);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    public final void v0() {
        while (this.f7301h > this.f7299f) {
            r0((String) ((Map.Entry) this.f7303j.entrySet().iterator().next()).getKey());
        }
    }
}
