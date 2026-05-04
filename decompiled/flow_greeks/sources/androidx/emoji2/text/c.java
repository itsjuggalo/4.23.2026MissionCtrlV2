package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.google.android.gms.common.api.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Object f1953o = new Object();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Object f1954p = new Object();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile c f1955q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f1957b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f1960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f1961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j f1962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f1963h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f1964i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f1965j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f1966k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f1967l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f1968m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f1969n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReadWriteLock f1956a = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f1958c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f1959d = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile androidx.emoji2.text.d f1970b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile androidx.emoji2.text.f f1971c;

        /* JADX INFO: renamed from: androidx.emoji2.text.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class C0024a extends i {
            public C0024a() {
            }

            @Override // androidx.emoji2.text.c.i
            public void a(Throwable th) {
                a.this.f1973a.n(th);
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
                this.f1973a.f1961f.a(new C0024a());
            } catch (Throwable th) {
                this.f1973a.n(th);
            }
        }

        @Override // androidx.emoji2.text.c.b
        public CharSequence b(CharSequence charSequence, int i10, int i11, int i12, boolean z10) {
            return this.f1970b.h(charSequence, i10, i11, i12, z10);
        }

        @Override // androidx.emoji2.text.c.b
        public void c(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f1971c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f1973a.f1963h);
        }

        public void d(androidx.emoji2.text.f fVar) {
            if (fVar == null) {
                this.f1973a.n(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f1971c = fVar;
            androidx.emoji2.text.f fVar2 = this.f1971c;
            j jVar = this.f1973a.f1962g;
            e eVar = this.f1973a.f1969n;
            c cVar = this.f1973a;
            this.f1970b = new androidx.emoji2.text.d(fVar2, jVar, eVar, cVar.f1964i, cVar.f1965j, q1.d.a());
            this.f1973a.o();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f1973a;

        public b(c cVar) {
            this.f1973a = cVar;
        }

        public abstract void a();

        public abstract CharSequence b(CharSequence charSequence, int i10, int i11, int i12, boolean z10);

        public abstract void c(EditorInfo editorInfo);
    }

    /* JADX INFO: renamed from: androidx.emoji2.text.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class AbstractC0025c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f1974a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j f1975b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1976c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1977d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int[] f1978e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Set f1979f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f1980g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1981h = -16711936;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f1982i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public e f1983j = new androidx.emoji2.text.b();

        public AbstractC0025c(h hVar) {
            s0.f.e(hVar, "metadataLoader cannot be null.");
            this.f1974a = hVar;
        }

        public final h a() {
            return this.f1974a;
        }

        public AbstractC0025c b(int i10) {
            this.f1982i = i10;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d implements j {
        @Override // androidx.emoji2.text.c.j
        public q1.e a(q1.i iVar) {
            return new q1.j(iVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface e {
        boolean a(CharSequence charSequence, int i10, int i11, int i12);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f1984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f1985b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1986c;

        public g(f fVar, int i10) {
            this(Arrays.asList((f) s0.f.e(fVar, "initCallback cannot be null")), i10, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f1984a.size();
            int i10 = 0;
            if (this.f1986c != 1) {
                while (i10 < size) {
                    ((f) this.f1984a.get(i10)).a(this.f1985b);
                    i10++;
                }
            } else {
                while (i10 < size) {
                    ((f) this.f1984a.get(i10)).b();
                    i10++;
                }
            }
        }

        public g(Collection collection, int i10) {
            this(collection, i10, null);
        }

        public g(Collection collection, int i10, Throwable th) {
            s0.f.e(collection, "initCallbacks cannot be null");
            this.f1984a = new ArrayList(collection);
            this.f1986c = i10;
            this.f1985b = th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface h {
        void a(i iVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class i {
        public abstract void a(Throwable th);

        public abstract void b(androidx.emoji2.text.f fVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface j {
        q1.e a(q1.i iVar);
    }

    public c(AbstractC0025c abstractC0025c) {
        this.f1963h = abstractC0025c.f1976c;
        this.f1964i = abstractC0025c.f1977d;
        this.f1965j = abstractC0025c.f1978e;
        this.f1966k = abstractC0025c.f1980g;
        this.f1967l = abstractC0025c.f1981h;
        this.f1961f = abstractC0025c.f1974a;
        this.f1968m = abstractC0025c.f1982i;
        this.f1969n = abstractC0025c.f1983j;
        w.b bVar = new w.b();
        this.f1957b = bVar;
        j jVar = abstractC0025c.f1975b;
        this.f1962g = jVar == null ? new d() : jVar;
        Set set = abstractC0025c.f1979f;
        if (set != null && !set.isEmpty()) {
            bVar.addAll(abstractC0025c.f1979f);
        }
        this.f1960e = new a(this);
        m();
    }

    public static c c() {
        c cVar;
        synchronized (f1953o) {
            cVar = f1955q;
            s0.f.f(cVar != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return cVar;
    }

    public static boolean f(InputConnection inputConnection, Editable editable, int i10, int i11, boolean z10) {
        return androidx.emoji2.text.d.b(inputConnection, editable, i10, i11, z10);
    }

    public static boolean g(Editable editable, int i10, KeyEvent keyEvent) {
        return androidx.emoji2.text.d.c(editable, i10, keyEvent);
    }

    public static c h(AbstractC0025c abstractC0025c) {
        c cVar;
        c cVar2 = f1955q;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (f1953o) {
            try {
                cVar = f1955q;
                if (cVar == null) {
                    cVar = new c(abstractC0025c);
                    f1955q = cVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public static boolean i() {
        return f1955q != null;
    }

    public int d() {
        return this.f1967l;
    }

    public int e() {
        this.f1956a.readLock().lock();
        try {
            return this.f1958c;
        } finally {
            this.f1956a.readLock().unlock();
        }
    }

    public boolean j() {
        return this.f1966k;
    }

    public final boolean k() {
        return e() == 1;
    }

    public void l() {
        s0.f.f(this.f1968m == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (k()) {
            return;
        }
        this.f1956a.writeLock().lock();
        try {
            if (this.f1958c == 0) {
                return;
            }
            this.f1958c = 0;
            this.f1956a.writeLock().unlock();
            this.f1960e.a();
        } finally {
            this.f1956a.writeLock().unlock();
        }
    }

    public final void m() {
        this.f1956a.writeLock().lock();
        try {
            if (this.f1968m == 0) {
                this.f1958c = 0;
            }
            this.f1956a.writeLock().unlock();
            if (e() == 0) {
                this.f1960e.a();
            }
        } catch (Throwable th) {
            this.f1956a.writeLock().unlock();
            throw th;
        }
    }

    public void n(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f1956a.writeLock().lock();
        try {
            this.f1958c = 2;
            arrayList.addAll(this.f1957b);
            this.f1957b.clear();
            this.f1956a.writeLock().unlock();
            this.f1959d.post(new g(arrayList, this.f1958c, th));
        } catch (Throwable th2) {
            this.f1956a.writeLock().unlock();
            throw th2;
        }
    }

    public void o() {
        ArrayList arrayList = new ArrayList();
        this.f1956a.writeLock().lock();
        try {
            this.f1958c = 1;
            arrayList.addAll(this.f1957b);
            this.f1957b.clear();
            this.f1956a.writeLock().unlock();
            this.f1959d.post(new g(arrayList, this.f1958c));
        } catch (Throwable th) {
            this.f1956a.writeLock().unlock();
            throw th;
        }
    }

    public CharSequence p(CharSequence charSequence) {
        return q(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence q(CharSequence charSequence, int i10, int i11) {
        return r(charSequence, i10, i11, a.e.API_PRIORITY_OTHER);
    }

    public CharSequence r(CharSequence charSequence, int i10, int i11, int i12) {
        return s(charSequence, i10, i11, i12, 0);
    }

    public CharSequence s(CharSequence charSequence, int i10, int i11, int i12, int i13) {
        boolean z10;
        s0.f.f(k(), "Not initialized yet");
        s0.f.c(i10, "start cannot be negative");
        s0.f.c(i11, "end cannot be negative");
        s0.f.c(i12, "maxEmojiCount cannot be negative");
        s0.f.a(i10 <= i11, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        s0.f.a(i10 <= charSequence.length(), "start should be < than charSequence length");
        s0.f.a(i11 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i10 == i11) {
            return charSequence;
        }
        if (i13 != 1) {
            z10 = i13 != 2 ? this.f1963h : false;
        } else {
            z10 = true;
        }
        return this.f1960e.b(charSequence, i10, i11, i12, z10);
    }

    public void t(f fVar) {
        s0.f.e(fVar, "initCallback cannot be null");
        this.f1956a.writeLock().lock();
        try {
            if (this.f1958c == 1 || this.f1958c == 2) {
                this.f1959d.post(new g(fVar, this.f1958c));
            } else {
                this.f1957b.add(fVar);
            }
            this.f1956a.writeLock().unlock();
        } catch (Throwable th) {
            this.f1956a.writeLock().unlock();
            throw th;
        }
    }

    public void u(f fVar) {
        s0.f.e(fVar, "initCallback cannot be null");
        this.f1956a.writeLock().lock();
        try {
            this.f1957b.remove(fVar);
        } finally {
            this.f1956a.writeLock().unlock();
        }
    }

    public void v(EditorInfo editorInfo) {
        if (!k() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.f1960e.c(editorInfo);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class f {
        public void b() {
        }

        public void a(Throwable th) {
        }
    }
}
