package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.google.android.gms.common.api.a;
import h0.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import u.C2737b;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Object f7647n = new Object();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Object f7648o = new Object();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile c f7649p;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f7651b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f7654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f7655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f7656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f7657h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f7658i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f7659j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f7660k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f7661l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f7662m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReadWriteLock f7650a = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f7652c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f7653d = new Handler(Looper.getMainLooper());

    public static final class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile androidx.emoji2.text.d f7663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile androidx.emoji2.text.f f7664c;

        /* JADX INFO: renamed from: androidx.emoji2.text.c$a$a, reason: collision with other inner class name */
        public class C0126a extends h {
            public C0126a() {
            }

            @Override // androidx.emoji2.text.c.h
            public void a(Throwable th) {
                a.this.f7666a.m(th);
            }

            @Override // androidx.emoji2.text.c.h
            public void b(androidx.emoji2.text.f fVar) {
                a.this.d(fVar);
            }
        }

        public a(c cVar) {
            super(cVar);
        }

        @Override // androidx.emoji2.text.c.b
        public void a() {
            try {
                this.f7666a.f7655f.a(new C0126a());
            } catch (Throwable th) {
                this.f7666a.m(th);
            }
        }

        @Override // androidx.emoji2.text.c.b
        public CharSequence b(CharSequence charSequence, int i7, int i8, int i9, boolean z7) {
            return this.f7663b.h(charSequence, i7, i8, i9, z7);
        }

        @Override // androidx.emoji2.text.c.b
        public void c(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f7664c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f7666a.f7656g);
        }

        public void d(androidx.emoji2.text.f fVar) {
            if (fVar == null) {
                this.f7666a.m(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f7664c = fVar;
            androidx.emoji2.text.f fVar2 = this.f7664c;
            i iVar = new i();
            d dVar = this.f7666a.f7662m;
            c cVar = this.f7666a;
            this.f7663b = new androidx.emoji2.text.d(fVar2, iVar, dVar, cVar.f7657h, cVar.f7658i);
            this.f7666a.n();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f7666a;

        public b(c cVar) {
            this.f7666a = cVar;
        }

        public abstract void a();

        public abstract CharSequence b(CharSequence charSequence, int i7, int i8, int i9, boolean z7);

        public abstract void c(EditorInfo editorInfo);
    }

    /* JADX INFO: renamed from: androidx.emoji2.text.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0127c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f7667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7668b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f7669c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int[] f7670d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Set f7671e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f7672f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7673g = -16711936;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f7674h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public d f7675i = new androidx.emoji2.text.b();

        public AbstractC0127c(g gVar) {
            P.f.h(gVar, "metadataLoader cannot be null.");
            this.f7667a = gVar;
        }

        public final g a() {
            return this.f7667a;
        }

        public AbstractC0127c b(int i7) {
            this.f7674h = i7;
            return this;
        }
    }

    public interface d {
        boolean a(CharSequence charSequence, int i7, int i8, int i9);
    }

    public static abstract class e {
        public void a(Throwable th) {
        }

        public void b() {
        }
    }

    public static class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f7676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f7677b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f7678c;

        public f(e eVar, int i7) {
            this(Arrays.asList((e) P.f.h(eVar, "initCallback cannot be null")), i7, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f7676a.size();
            int i7 = 0;
            if (this.f7678c != 1) {
                while (i7 < size) {
                    ((e) this.f7676a.get(i7)).a(this.f7677b);
                    i7++;
                }
            } else {
                while (i7 < size) {
                    ((e) this.f7676a.get(i7)).b();
                    i7++;
                }
            }
        }

        public f(Collection collection, int i7) {
            this(collection, i7, null);
        }

        public f(Collection collection, int i7, Throwable th) {
            P.f.h(collection, "initCallbacks cannot be null");
            this.f7676a = new ArrayList(collection);
            this.f7678c = i7;
            this.f7677b = th;
        }
    }

    public interface g {
        void a(h hVar);
    }

    public static abstract class h {
        public abstract void a(Throwable th);

        public abstract void b(androidx.emoji2.text.f fVar);
    }

    public static class i {
        public h0.f a(h0.e eVar) {
            return new j(eVar);
        }
    }

    public c(AbstractC0127c abstractC0127c) {
        this.f7656g = abstractC0127c.f7668b;
        this.f7657h = abstractC0127c.f7669c;
        this.f7658i = abstractC0127c.f7670d;
        this.f7659j = abstractC0127c.f7672f;
        this.f7660k = abstractC0127c.f7673g;
        this.f7655f = abstractC0127c.f7667a;
        this.f7661l = abstractC0127c.f7674h;
        this.f7662m = abstractC0127c.f7675i;
        C2737b c2737b = new C2737b();
        this.f7651b = c2737b;
        Set set = abstractC0127c.f7671e;
        if (set != null && !set.isEmpty()) {
            c2737b.addAll(abstractC0127c.f7671e);
        }
        this.f7654e = new a(this);
        l();
    }

    public static c b() {
        c cVar;
        synchronized (f7647n) {
            cVar = f7649p;
            P.f.i(cVar != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return cVar;
    }

    public static boolean e(InputConnection inputConnection, Editable editable, int i7, int i8, boolean z7) {
        return androidx.emoji2.text.d.c(inputConnection, editable, i7, i8, z7);
    }

    public static boolean f(Editable editable, int i7, KeyEvent keyEvent) {
        return androidx.emoji2.text.d.d(editable, i7, keyEvent);
    }

    public static c g(AbstractC0127c abstractC0127c) {
        c cVar = f7649p;
        if (cVar == null) {
            synchronized (f7647n) {
                try {
                    cVar = f7649p;
                    if (cVar == null) {
                        cVar = new c(abstractC0127c);
                        f7649p = cVar;
                    }
                } finally {
                }
            }
        }
        return cVar;
    }

    public static boolean h() {
        return f7649p != null;
    }

    public int c() {
        return this.f7660k;
    }

    public int d() {
        this.f7650a.readLock().lock();
        try {
            return this.f7652c;
        } finally {
            this.f7650a.readLock().unlock();
        }
    }

    public boolean i() {
        return this.f7659j;
    }

    public final boolean j() {
        return d() == 1;
    }

    public void k() {
        P.f.i(this.f7661l == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (j()) {
            return;
        }
        this.f7650a.writeLock().lock();
        try {
            if (this.f7652c == 0) {
                return;
            }
            this.f7652c = 0;
            this.f7650a.writeLock().unlock();
            this.f7654e.a();
        } finally {
            this.f7650a.writeLock().unlock();
        }
    }

    public final void l() {
        this.f7650a.writeLock().lock();
        try {
            if (this.f7661l == 0) {
                this.f7652c = 0;
            }
            this.f7650a.writeLock().unlock();
            if (d() == 0) {
                this.f7654e.a();
            }
        } catch (Throwable th) {
            this.f7650a.writeLock().unlock();
            throw th;
        }
    }

    public void m(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f7650a.writeLock().lock();
        try {
            this.f7652c = 2;
            arrayList.addAll(this.f7651b);
            this.f7651b.clear();
            this.f7650a.writeLock().unlock();
            this.f7653d.post(new f(arrayList, this.f7652c, th));
        } catch (Throwable th2) {
            this.f7650a.writeLock().unlock();
            throw th2;
        }
    }

    public void n() {
        ArrayList arrayList = new ArrayList();
        this.f7650a.writeLock().lock();
        try {
            this.f7652c = 1;
            arrayList.addAll(this.f7651b);
            this.f7651b.clear();
            this.f7650a.writeLock().unlock();
            this.f7653d.post(new f(arrayList, this.f7652c));
        } catch (Throwable th) {
            this.f7650a.writeLock().unlock();
            throw th;
        }
    }

    public CharSequence o(CharSequence charSequence) {
        return p(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence p(CharSequence charSequence, int i7, int i8) {
        return q(charSequence, i7, i8, a.e.API_PRIORITY_OTHER);
    }

    public CharSequence q(CharSequence charSequence, int i7, int i8, int i9) {
        return r(charSequence, i7, i8, i9, 0);
    }

    public CharSequence r(CharSequence charSequence, int i7, int i8, int i9, int i10) {
        boolean z7;
        P.f.i(j(), "Not initialized yet");
        P.f.e(i7, "start cannot be negative");
        P.f.e(i8, "end cannot be negative");
        P.f.e(i9, "maxEmojiCount cannot be negative");
        P.f.a(i7 <= i8, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        P.f.a(i7 <= charSequence.length(), "start should be < than charSequence length");
        P.f.a(i8 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i7 == i8) {
            return charSequence;
        }
        if (i10 != 1) {
            z7 = i10 != 2 ? this.f7656g : false;
        } else {
            z7 = true;
        }
        return this.f7654e.b(charSequence, i7, i8, i9, z7);
    }

    public void s(e eVar) {
        P.f.h(eVar, "initCallback cannot be null");
        this.f7650a.writeLock().lock();
        try {
            if (this.f7652c == 1 || this.f7652c == 2) {
                this.f7653d.post(new f(eVar, this.f7652c));
            } else {
                this.f7651b.add(eVar);
            }
            this.f7650a.writeLock().unlock();
        } catch (Throwable th) {
            this.f7650a.writeLock().unlock();
            throw th;
        }
    }

    public void t(e eVar) {
        P.f.h(eVar, "initCallback cannot be null");
        this.f7650a.writeLock().lock();
        try {
            this.f7651b.remove(eVar);
        } finally {
            this.f7650a.writeLock().unlock();
        }
    }

    public void u(EditorInfo editorInfo) {
        if (!j() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.f7654e.c(editorInfo);
    }
}
