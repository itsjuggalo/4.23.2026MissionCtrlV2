package okhttp3.internal.cache;

import com.amazon.a.a.o.c.a.b;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import okhttp3.internal.Util;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import w6.InterfaceC2793f;
import w6.InterfaceC2794g;
import w6.L;
import w6.X;
import w6.Z;

/* JADX INFO: loaded from: classes2.dex */
public final class DiskLruCache implements Closeable, Flushable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Pattern f20711u = Pattern.compile("[a-z0-9_-]{1,120}");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileSystem f20712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f20713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f20714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f20715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final File f20716e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f20717f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f20718g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f20719h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f20720i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public InterfaceC2793f f20721j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedHashMap f20722k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f20723l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f20724m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f20725n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f20726o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f20727p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f20728q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f20729r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Executor f20730s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Runnable f20731t;

    /* JADX INFO: renamed from: okhttp3.internal.cache.DiskLruCache$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DiskLruCache f20732a;

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f20732a) {
                DiskLruCache diskLruCache = this.f20732a;
                if ((!diskLruCache.f20725n) || diskLruCache.f20726o) {
                    return;
                }
                try {
                    diskLruCache.B0();
                } catch (IOException unused) {
                    this.f20732a.f20727p = true;
                }
                try {
                    if (this.f20732a.T()) {
                        this.f20732a.y0();
                        this.f20732a.f20723l = 0;
                    }
                } catch (IOException unused2) {
                    DiskLruCache diskLruCache2 = this.f20732a;
                    diskLruCache2.f20728q = true;
                    diskLruCache2.f20721j = L.c(L.b());
                }
            }
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.cache.DiskLruCache$3, reason: invalid class name */
    class AnonymousClass3 implements Iterator<Snapshot> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f20734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Snapshot f20735b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Snapshot f20736c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DiskLruCache f20737d;

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Snapshot next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Snapshot snapshot = this.f20735b;
            this.f20736c = snapshot;
            this.f20735b = null;
            return snapshot;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Snapshot snapshotC;
            if (this.f20735b != null) {
                return true;
            }
            synchronized (this.f20737d) {
                try {
                    if (this.f20737d.f20726o) {
                        return false;
                    }
                    while (this.f20734a.hasNext()) {
                        Entry entry = (Entry) this.f20734a.next();
                        if (entry.f20747e && (snapshotC = entry.c()) != null) {
                            this.f20735b = snapshotC;
                            return true;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            Snapshot snapshot = this.f20736c;
            if (snapshot == null) {
                throw new IllegalStateException("remove() before next()");
            }
            try {
                this.f20737d.z0(snapshot.f20751a);
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.f20736c = null;
                throw th;
            }
            this.f20736c = null;
        }
    }

    public final class Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Entry f20738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f20739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f20740c;

        public Editor(Entry entry) {
            this.f20738a = entry;
            this.f20739b = entry.f20747e ? null : new boolean[DiskLruCache.this.f20719h];
        }

        public void a() {
            synchronized (DiskLruCache.this) {
                try {
                    if (this.f20740c) {
                        throw new IllegalStateException();
                    }
                    if (this.f20738a.f20748f == this) {
                        DiskLruCache.this.i(this, false);
                    }
                    this.f20740c = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void b() {
            synchronized (DiskLruCache.this) {
                try {
                    if (this.f20740c) {
                        throw new IllegalStateException();
                    }
                    if (this.f20738a.f20748f == this) {
                        DiskLruCache.this.i(this, true);
                    }
                    this.f20740c = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void c() {
            if (this.f20738a.f20748f != this) {
                return;
            }
            int i7 = 0;
            while (true) {
                DiskLruCache diskLruCache = DiskLruCache.this;
                if (i7 >= diskLruCache.f20719h) {
                    this.f20738a.f20748f = null;
                    return;
                } else {
                    try {
                        diskLruCache.f20712a.f(this.f20738a.f20746d[i7]);
                    } catch (IOException unused) {
                    }
                    i7++;
                }
            }
        }

        public X d(int i7) {
            synchronized (DiskLruCache.this) {
                try {
                    if (this.f20740c) {
                        throw new IllegalStateException();
                    }
                    Entry entry = this.f20738a;
                    if (entry.f20748f != this) {
                        return L.b();
                    }
                    if (!entry.f20747e) {
                        this.f20739b[i7] = true;
                    }
                    try {
                        return new FaultHidingSink(DiskLruCache.this.f20712a.b(entry.f20746d[i7])) { // from class: okhttp3.internal.cache.DiskLruCache.Editor.1
                            @Override // okhttp3.internal.cache.FaultHidingSink
                            public void h(IOException iOException) {
                                synchronized (DiskLruCache.this) {
                                    Editor.this.c();
                                }
                            }
                        };
                    } catch (FileNotFoundException unused) {
                        return L.b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final class Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f20743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f20744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final File[] f20745c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final File[] f20746d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f20747e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Editor f20748f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f20749g;

        public Entry(String str) {
            this.f20743a = str;
            int i7 = DiskLruCache.this.f20719h;
            this.f20744b = new long[i7];
            this.f20745c = new File[i7];
            this.f20746d = new File[i7];
            StringBuilder sb = new StringBuilder(str);
            sb.append(b.f10001a);
            int length = sb.length();
            for (int i8 = 0; i8 < DiskLruCache.this.f20719h; i8++) {
                sb.append(i8);
                this.f20745c[i8] = new File(DiskLruCache.this.f20713b, sb.toString());
                sb.append(".tmp");
                this.f20746d[i8] = new File(DiskLruCache.this.f20713b, sb.toString());
                sb.setLength(length);
            }
        }

        public final IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public void b(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.f20719h) {
                throw a(strArr);
            }
            for (int i7 = 0; i7 < strArr.length; i7++) {
                try {
                    this.f20744b[i7] = Long.parseLong(strArr[i7]);
                } catch (NumberFormatException unused) {
                    throw a(strArr);
                }
            }
        }

        public Snapshot c() {
            Z z7;
            if (!Thread.holdsLock(DiskLruCache.this)) {
                throw new AssertionError();
            }
            Z[] zArr = new Z[DiskLruCache.this.f20719h];
            long[] jArr = (long[]) this.f20744b.clone();
            int i7 = 0;
            int i8 = 0;
            while (true) {
                try {
                    DiskLruCache diskLruCache = DiskLruCache.this;
                    if (i8 >= diskLruCache.f20719h) {
                        return diskLruCache.new Snapshot(this.f20743a, this.f20749g, zArr, jArr);
                    }
                    zArr[i8] = diskLruCache.f20712a.a(this.f20745c[i8]);
                    i8++;
                } catch (FileNotFoundException unused) {
                    while (true) {
                        DiskLruCache diskLruCache2 = DiskLruCache.this;
                        if (i7 >= diskLruCache2.f20719h || (z7 = zArr[i7]) == null) {
                            try {
                                diskLruCache2.A0(this);
                                return null;
                            } catch (IOException unused2) {
                                return null;
                            }
                        }
                        Util.f(z7);
                        i7++;
                    }
                }
            }
        }

        public void d(InterfaceC2793f interfaceC2793f) {
            for (long j7 : this.f20744b) {
                interfaceC2793f.v(32).q0(j7);
            }
        }
    }

    public final class Snapshot implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f20751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f20752b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Z[] f20753c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long[] f20754d;

        public Snapshot(String str, long j7, Z[] zArr, long[] jArr) {
            this.f20751a = str;
            this.f20752b = j7;
            this.f20753c = zArr;
            this.f20754d = jArr;
        }

        public Z A(int i7) {
            return this.f20753c[i7];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (Z z7 : this.f20753c) {
                Util.f(z7);
            }
        }

        public Editor i() {
            return DiskLruCache.this.H(this.f20751a, this.f20752b);
        }
    }

    public void A() {
        close();
        this.f20712a.c(this.f20713b);
    }

    public boolean A0(Entry entry) {
        Editor editor = entry.f20748f;
        if (editor != null) {
            editor.c();
        }
        for (int i7 = 0; i7 < this.f20719h; i7++) {
            this.f20712a.f(entry.f20745c[i7]);
            long j7 = this.f20720i;
            long[] jArr = entry.f20744b;
            this.f20720i = j7 - jArr[i7];
            jArr[i7] = 0;
        }
        this.f20723l++;
        this.f20721j.I("REMOVE").v(32).I(entry.f20743a).v(10);
        this.f20722k.remove(entry.f20743a);
        if (T()) {
            this.f20730s.execute(this.f20731t);
        }
        return true;
    }

    public void B0() {
        while (this.f20720i > this.f20718g) {
            A0((Entry) this.f20722k.values().iterator().next());
        }
        this.f20727p = false;
    }

    public final void C0(String str) {
        if (f20711u.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public Editor G(String str) {
        return H(str, -1L);
    }

    public synchronized Editor H(String str, long j7) {
        M();
        h();
        C0(str);
        Entry entry = (Entry) this.f20722k.get(str);
        if (j7 != -1 && (entry == null || entry.f20749g != j7)) {
            return null;
        }
        if (entry != null && entry.f20748f != null) {
            return null;
        }
        if (!this.f20727p && !this.f20728q) {
            this.f20721j.I("DIRTY").v(32).I(str).v(10);
            this.f20721j.flush();
            if (this.f20724m) {
                return null;
            }
            if (entry == null) {
                entry = new Entry(str);
                this.f20722k.put(str, entry);
            }
            Editor editor = new Editor(entry);
            entry.f20748f = editor;
            return editor;
        }
        this.f20730s.execute(this.f20731t);
        return null;
    }

    public synchronized Snapshot K(String str) {
        M();
        h();
        C0(str);
        Entry entry = (Entry) this.f20722k.get(str);
        if (entry != null && entry.f20747e) {
            Snapshot snapshotC = entry.c();
            if (snapshotC == null) {
                return null;
            }
            this.f20723l++;
            this.f20721j.I("READ").v(32).I(str).v(10);
            if (T()) {
                this.f20730s.execute(this.f20731t);
            }
            return snapshotC;
        }
        return null;
    }

    public synchronized void M() {
        try {
            if (this.f20725n) {
                return;
            }
            if (this.f20712a.d(this.f20716e)) {
                if (this.f20712a.d(this.f20714c)) {
                    this.f20712a.f(this.f20716e);
                } else {
                    this.f20712a.e(this.f20716e, this.f20714c);
                }
            }
            if (this.f20712a.d(this.f20714c)) {
                try {
                    c0();
                    X();
                    this.f20725n = true;
                    return;
                } catch (IOException e7) {
                    Platform.l().s(5, "DiskLruCache " + this.f20713b + " is corrupt: " + e7.getMessage() + ", removing", e7);
                    try {
                        A();
                        this.f20726o = false;
                        y0();
                        this.f20725n = true;
                    } catch (Throwable th) {
                        this.f20726o = false;
                        throw th;
                    }
                }
            }
            y0();
            this.f20725n = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized boolean O() {
        return this.f20726o;
    }

    public boolean T() {
        int i7 = this.f20723l;
        return i7 >= 2000 && i7 >= this.f20722k.size();
    }

    public final InterfaceC2793f V() {
        return L.c(new FaultHidingSink(this.f20712a.g(this.f20714c)) { // from class: okhttp3.internal.cache.DiskLruCache.2
            @Override // okhttp3.internal.cache.FaultHidingSink
            public void h(IOException iOException) {
                DiskLruCache.this.f20724m = true;
            }
        });
    }

    public final void X() {
        this.f20712a.f(this.f20715d);
        Iterator it = this.f20722k.values().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i7 = 0;
            if (entry.f20748f == null) {
                while (i7 < this.f20719h) {
                    this.f20720i += entry.f20744b[i7];
                    i7++;
                }
            } else {
                entry.f20748f = null;
                while (i7 < this.f20719h) {
                    this.f20712a.f(entry.f20745c[i7]);
                    this.f20712a.f(entry.f20746d[i7]);
                    i7++;
                }
                it.remove();
            }
        }
    }

    public final void c0() {
        InterfaceC2794g interfaceC2794gD = L.d(this.f20712a.a(this.f20714c));
        try {
            String strU = interfaceC2794gD.U();
            String strU2 = interfaceC2794gD.U();
            String strU3 = interfaceC2794gD.U();
            String strU4 = interfaceC2794gD.U();
            String strU5 = interfaceC2794gD.U();
            if (!"libcore.io.DiskLruCache".equals(strU) || !"1".equals(strU2) || !Integer.toString(this.f20717f).equals(strU3) || !Integer.toString(this.f20719h).equals(strU4) || !"".equals(strU5)) {
                throw new IOException("unexpected journal header: [" + strU + ", " + strU2 + ", " + strU4 + ", " + strU5 + "]");
            }
            int i7 = 0;
            while (true) {
                try {
                    i0(interfaceC2794gD.U());
                    i7++;
                } catch (EOFException unused) {
                    this.f20723l = i7 - this.f20722k.size();
                    if (interfaceC2794gD.u()) {
                        this.f20721j = V();
                    } else {
                        y0();
                    }
                    Util.f(interfaceC2794gD);
                    return;
                }
            }
        } catch (Throwable th) {
            Util.f(interfaceC2794gD);
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.f20725n && !this.f20726o) {
                for (Entry entry : (Entry[]) this.f20722k.values().toArray(new Entry[this.f20722k.size()])) {
                    Editor editor = entry.f20748f;
                    if (editor != null) {
                        editor.a();
                    }
                }
                B0();
                this.f20721j.close();
                this.f20721j = null;
                this.f20726o = true;
                return;
            }
            this.f20726o = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() {
        if (this.f20725n) {
            h();
            B0();
            this.f20721j.flush();
        }
    }

    public final synchronized void h() {
        if (O()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void i(Editor editor, boolean z7) {
        Entry entry = editor.f20738a;
        if (entry.f20748f != editor) {
            throw new IllegalStateException();
        }
        if (z7 && !entry.f20747e) {
            for (int i7 = 0; i7 < this.f20719h; i7++) {
                if (!editor.f20739b[i7]) {
                    editor.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i7);
                }
                if (!this.f20712a.d(entry.f20746d[i7])) {
                    editor.a();
                    return;
                }
            }
        }
        for (int i8 = 0; i8 < this.f20719h; i8++) {
            File file = entry.f20746d[i8];
            if (!z7) {
                this.f20712a.f(file);
            } else if (this.f20712a.d(file)) {
                File file2 = entry.f20745c[i8];
                this.f20712a.e(file, file2);
                long j7 = entry.f20744b[i8];
                long jH = this.f20712a.h(file2);
                entry.f20744b[i8] = jH;
                this.f20720i = (this.f20720i - j7) + jH;
            }
        }
        this.f20723l++;
        entry.f20748f = null;
        if (entry.f20747e || z7) {
            entry.f20747e = true;
            this.f20721j.I("CLEAN").v(32);
            this.f20721j.I(entry.f20743a);
            entry.d(this.f20721j);
            this.f20721j.v(10);
            if (z7) {
                long j8 = this.f20729r;
                this.f20729r = 1 + j8;
                entry.f20749g = j8;
            }
        } else {
            this.f20722k.remove(entry.f20743a);
            this.f20721j.I("REMOVE").v(32);
            this.f20721j.I(entry.f20743a);
            this.f20721j.v(10);
        }
        this.f20721j.flush();
        if (this.f20720i > this.f20718g || T()) {
            this.f20730s.execute(this.f20731t);
        }
    }

    public final void i0(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i7 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i7);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i7);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.f20722k.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i7, iIndexOf2);
        }
        Entry entry = (Entry) this.f20722k.get(strSubstring);
        if (entry == null) {
            entry = new Entry(strSubstring);
            this.f20722k.put(strSubstring, entry);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            entry.f20747e = true;
            entry.f20748f = null;
            entry.b(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            entry.f20748f = new Editor(entry);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public synchronized void y0() {
        try {
            InterfaceC2793f interfaceC2793f = this.f20721j;
            if (interfaceC2793f != null) {
                interfaceC2793f.close();
            }
            InterfaceC2793f interfaceC2793fC = L.c(this.f20712a.b(this.f20715d));
            try {
                interfaceC2793fC.I("libcore.io.DiskLruCache").v(10);
                interfaceC2793fC.I("1").v(10);
                interfaceC2793fC.q0(this.f20717f).v(10);
                interfaceC2793fC.q0(this.f20719h).v(10);
                interfaceC2793fC.v(10);
                for (Entry entry : this.f20722k.values()) {
                    if (entry.f20748f != null) {
                        interfaceC2793fC.I("DIRTY").v(32);
                        interfaceC2793fC.I(entry.f20743a);
                        interfaceC2793fC.v(10);
                    } else {
                        interfaceC2793fC.I("CLEAN").v(32);
                        interfaceC2793fC.I(entry.f20743a);
                        entry.d(interfaceC2793fC);
                        interfaceC2793fC.v(10);
                    }
                }
                interfaceC2793fC.close();
                if (this.f20712a.d(this.f20714c)) {
                    this.f20712a.e(this.f20714c, this.f20716e);
                }
                this.f20712a.e(this.f20715d, this.f20714c);
                this.f20712a.f(this.f20716e);
                this.f20721j = V();
                this.f20724m = false;
                this.f20728q = false;
            } catch (Throwable th) {
                interfaceC2793fC.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized boolean z0(String str) {
        M();
        h();
        C0(str);
        Entry entry = (Entry) this.f20722k.get(str);
        if (entry == null) {
            return false;
        }
        boolean zA0 = A0(entry);
        if (zA0 && this.f20720i <= this.f20718g) {
            this.f20727p = false;
        }
        return zA0;
    }
}
