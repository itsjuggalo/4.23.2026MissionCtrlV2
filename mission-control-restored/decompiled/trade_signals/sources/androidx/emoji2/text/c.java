package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import h0.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Object f11459o = new Object();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Object f11460p = new Object();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile c f11461q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f11463b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f11466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f11467f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j f11468g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f11469h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f11470i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f11471j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f11472k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f11473l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f11474m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f11475n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReadWriteLock f11462a = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f11464c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f11465d = new Handler(Looper.getMainLooper());

    public static final class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile androidx.emoji2.text.d f11476b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile androidx.emoji2.text.f f11477c;

        /* JADX INFO: renamed from: androidx.emoji2.text.c$a$a, reason: collision with other inner class name */
        public class C0183a extends i {
            public C0183a() {
            }

            @Override // androidx.emoji2.text.c.i
            public void a(Throwable th) {
                a.this.f11479a.n(th);
            }

            @Override // androidx.emoji2.text.c.i
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
                this.f11479a.f11467f.a(new C0183a());
            } catch (Throwable th) {
                this.f11479a.n(th);
            }
        }

        @Override // androidx.emoji2.text.c.b
        public CharSequence b(CharSequence charSequence, int i8, int i9, int i10, boolean z7) {
            return this.f11476b.h(charSequence, i8, i9, i10, z7);
        }

        @Override // androidx.emoji2.text.c.b
        public void c(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f11477c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f11479a.f11469h);
        }

        public void d(androidx.emoji2.text.f fVar) {
            if (fVar == null) {
                this.f11479a.n(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f11477c = fVar;
            androidx.emoji2.text.f fVar2 = this.f11477c;
            j jVar = this.f11479a.f11468g;
            e eVar = this.f11479a.f11475n;
            c cVar = this.f11479a;
            this.f11476b = new androidx.emoji2.text.d(fVar2, jVar, eVar, cVar.f11470i, cVar.f11471j, h0.e.a());
            this.f11479a.o();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f11479a;

        public b(c cVar) {
            this.f11479a = cVar;
        }

        public abstract void a();

        public abstract CharSequence b(CharSequence charSequence, int i8, int i9, int i10, boolean z7);

        public abstract void c(EditorInfo editorInfo);
    }

    /* JADX INFO: renamed from: androidx.emoji2.text.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0184c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f11480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j f11481b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f11482c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f11483d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int[] f11484e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Set f11485f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f11486g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f11487h = -16711936;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f11488i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public e f11489j = new androidx.emoji2.text.b();

        public AbstractC0184c(h hVar) {
            S.g.e(hVar, "metadataLoader cannot be null.");
            this.f11480a = hVar;
        }

        public final h a() {
            return this.f11480a;
        }

        public AbstractC0184c b(int i8) {
            this.f11488i = i8;
            return this;
        }
    }

    public static class d implements j {
        @Override // androidx.emoji2.text.c.j
        public h0.f a(h0.j jVar) {
            return new k(jVar);
        }
    }

    public interface e {
        boolean a(CharSequence charSequence, int i8, int i9, int i10);
    }

    public static abstract class f {
        public void a(Throwable th) {
        }

        public void b() {
        }
    }

    public static class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f11490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f11491b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f11492c;

        public g(f fVar, int i8) {
            this(Arrays.asList((f) S.g.e(fVar, "initCallback cannot be null")), i8, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f11490a.size();
            int i8 = 0;
            if (this.f11492c != 1) {
                while (i8 < size) {
                    ((f) this.f11490a.get(i8)).a(this.f11491b);
                    i8++;
                }
            } else {
                while (i8 < size) {
                    ((f) this.f11490a.get(i8)).b();
                    i8++;
                }
            }
        }

        public g(Collection collection, int i8) {
            this(collection, i8, null);
        }

        public g(Collection collection, int i8, Throwable th) {
            S.g.e(collection, "initCallbacks cannot be null");
            this.f11490a = new ArrayList(collection);
            this.f11492c = i8;
            this.f11491b = th;
        }
    }

    public interface h {
        void a(i iVar);
    }

    public static abstract class i {
        public abstract void a(Throwable th);

        public abstract void b(androidx.emoji2.text.f fVar);
    }

    public interface j {
        h0.f a(h0.j jVar);
    }

    public c(AbstractC0184c abstractC0184c) {
        this.f11469h = abstractC0184c.f11482c;
        this.f11470i = abstractC0184c.f11483d;
        this.f11471j = abstractC0184c.f11484e;
        this.f11472k = abstractC0184c.f11486g;
        this.f11473l = abstractC0184c.f11487h;
        this.f11467f = abstractC0184c.f11480a;
        this.f11474m = abstractC0184c.f11488i;
        this.f11475n = abstractC0184c.f11489j;
        w.b bVar = new w.b();
        this.f11463b = bVar;
        j jVar = abstractC0184c.f11481b;
        this.f11468g = jVar == null ? new d() : jVar;
        Set set = abstractC0184c.f11485f;
        if (set != null && !set.isEmpty()) {
            bVar.addAll(abstractC0184c.f11485f);
        }
        this.f11466e = new a(this);
        m();
    }

    public static c c() {
        c cVar;
        synchronized (f11459o) {
            cVar = f11461q;
            S.g.f(cVar != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return cVar;
    }

    public static boolean f(InputConnection inputConnection, Editable editable, int i8, int i9, boolean z7) {
        return androidx.emoji2.text.d.b(inputConnection, editable, i8, i9, z7);
    }

    public static boolean g(Editable editable, int i8, KeyEvent keyEvent) {
        return androidx.emoji2.text.d.c(editable, i8, keyEvent);
    }

    public static c h(AbstractC0184c abstractC0184c) {
        c cVar = f11461q;
        if (cVar == null) {
            synchronized (f11459o) {
                try {
                    cVar = f11461q;
                    if (cVar == null) {
                        cVar = new c(abstractC0184c);
                        f11461q = cVar;
                    }
                } finally {
                }
            }
        }
        return cVar;
    }

    public static boolean i() {
        return f11461q != null;
    }

    public int d() {
        return this.f11473l;
    }

    public int e() {
        this.f11462a.readLock().lock();
        try {
            return this.f11464c;
        } finally {
            this.f11462a.readLock().unlock();
        }
    }

    public boolean j() {
        return this.f11472k;
    }

    public final boolean k() {
        return e() == 1;
    }

    public void l() {
        S.g.f(this.f11474m == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (k()) {
            return;
        }
        this.f11462a.writeLock().lock();
        try {
            if (this.f11464c == 0) {
                return;
            }
            this.f11464c = 0;
            this.f11462a.writeLock().unlock();
            this.f11466e.a();
        } finally {
            this.f11462a.writeLock().unlock();
        }
    }

    public final void m() {
        this.f11462a.writeLock().lock();
        try {
            if (this.f11474m == 0) {
                this.f11464c = 0;
            }
            this.f11462a.writeLock().unlock();
            if (e() == 0) {
                this.f11466e.a();
            }
        } catch (Throwable th) {
            this.f11462a.writeLock().unlock();
            throw th;
        }
    }

    public void n(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f11462a.writeLock().lock();
        try {
            this.f11464c = 2;
            arrayList.addAll(this.f11463b);
            this.f11463b.clear();
            this.f11462a.writeLock().unlock();
            this.f11465d.post(new g(arrayList, this.f11464c, th));
        } catch (Throwable th2) {
            this.f11462a.writeLock().unlock();
            throw th2;
        }
    }

    public void o() {
        ArrayList arrayList = new ArrayList();
        this.f11462a.writeLock().lock();
        try {
            this.f11464c = 1;
            arrayList.addAll(this.f11463b);
            this.f11463b.clear();
            this.f11462a.writeLock().unlock();
            this.f11465d.post(new g(arrayList, this.f11464c));
        } catch (Throwable th) {
            this.f11462a.writeLock().unlock();
            throw th;
        }
    }

    public CharSequence p(CharSequence charSequence) {
        return q(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence q(CharSequence charSequence, int i8, int i9) {
        return r(charSequence, i8, i9, Integer.MAX_VALUE);
    }

    public CharSequence r(CharSequence charSequence, int i8, int i9, int i10) {
        return s(charSequence, i8, i9, i10, 0);
    }

    public CharSequence s(CharSequence charSequence, int i8, int i9, int i10, int i11) {
        boolean z7;
        S.g.f(k(), "Not initialized yet");
        S.g.c(i8, "start cannot be negative");
        S.g.c(i9, "end cannot be negative");
        S.g.c(i10, "maxEmojiCount cannot be negative");
        S.g.a(i8 <= i9, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        S.g.a(i8 <= charSequence.length(), "start should be < than charSequence length");
        S.g.a(i9 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i8 == i9) {
            return charSequence;
        }
        if (i11 != 1) {
            z7 = i11 != 2 ? this.f11469h : false;
        } else {
            z7 = true;
        }
        return this.f11466e.b(charSequence, i8, i9, i10, z7);
    }

    public void t(f fVar) {
        S.g.e(fVar, "initCallback cannot be null");
        this.f11462a.writeLock().lock();
        try {
            if (this.f11464c == 1 || this.f11464c == 2) {
                this.f11465d.post(new g(fVar, this.f11464c));
            } else {
                this.f11463b.add(fVar);
            }
            this.f11462a.writeLock().unlock();
        } catch (Throwable th) {
            this.f11462a.writeLock().unlock();
            throw th;
        }
    }

    public void u(f fVar) {
        S.g.e(fVar, "initCallback cannot be null");
        this.f11462a.writeLock().lock();
        try {
            this.f11463b.remove(fVar);
        } finally {
            this.f11462a.writeLock().unlock();
        }
    }

    public void v(EditorInfo editorInfo) {
        if (!k() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.f11466e.c(editorInfo);
    }
}
