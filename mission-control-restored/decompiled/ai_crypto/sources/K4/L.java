package K4;

import U4.j;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import com.google.android.gms.common.api.a;
import io.flutter.plugin.editing.l;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class L implements l.a, j.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d[] f3543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet f3544b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f3545c;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3546a = 0;

        public Character a(int i7) {
            char c7 = (char) i7;
            if ((Integer.MIN_VALUE & i7) != 0) {
                int i8 = i7 & a.e.API_PRIORITY_OTHER;
                int i9 = this.f3546a;
                if (i9 != 0) {
                    this.f3546a = KeyCharacterMap.getDeadChar(i9, i8);
                } else {
                    this.f3546a = i8;
                }
            } else {
                int i10 = this.f3546a;
                if (i10 != 0) {
                    int deadChar = KeyCharacterMap.getDeadChar(i10, i7);
                    if (deadChar > 0) {
                        c7 = (char) deadChar;
                    }
                    this.f3546a = 0;
                }
            }
            return Character.valueOf(c7);
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final KeyEvent f3547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f3549c = false;

        public class a implements d.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f3551a;

            public a() {
                this.f3551a = false;
            }

            @Override // K4.L.d.a
            public void a(boolean z7) {
                if (this.f3551a) {
                    throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
                }
                this.f3551a = true;
                c cVar = c.this;
                int i7 = cVar.f3548b - 1;
                cVar.f3548b = i7;
                boolean z8 = z7 | cVar.f3549c;
                cVar.f3549c = z8;
                if (i7 != 0 || z8) {
                    return;
                }
                L.this.e(cVar.f3547a);
            }
        }

        public c(KeyEvent keyEvent) {
            this.f3548b = L.this.f3543a.length;
            this.f3547a = keyEvent;
        }

        public d.a a() {
            return new a();
        }
    }

    public interface d {

        public interface a {
            void a(boolean z7);
        }

        void a(KeyEvent keyEvent, a aVar);
    }

    public interface e {
        void b(KeyEvent keyEvent);

        boolean c(KeyEvent keyEvent);

        V4.b getBinaryMessenger();
    }

    public L(e eVar) {
        this.f3545c = eVar;
        this.f3543a = new d[]{new K(eVar.getBinaryMessenger()), new F(new U4.i(eVar.getBinaryMessenger()))};
        new U4.j(eVar.getBinaryMessenger()).b(this);
    }

    @Override // io.flutter.plugin.editing.l.a
    public boolean a(KeyEvent keyEvent) {
        if (this.f3544b.remove(keyEvent)) {
            return false;
        }
        if (this.f3543a.length <= 0) {
            e(keyEvent);
            return true;
        }
        c cVar = new c(keyEvent);
        for (d dVar : this.f3543a) {
            dVar.a(keyEvent, cVar.a());
        }
        return true;
    }

    @Override // U4.j.b
    public Map b() {
        return ((K) this.f3543a[0]).h();
    }

    public void d() {
        int size = this.f3544b.size();
        if (size > 0) {
            J4.b.g("KeyboardManager", "A KeyboardManager was destroyed with " + String.valueOf(size) + " unhandled redispatch event(s).");
        }
    }

    public final void e(KeyEvent keyEvent) {
        e eVar = this.f3545c;
        if (eVar == null || eVar.c(keyEvent)) {
            return;
        }
        this.f3544b.add(keyEvent);
        this.f3545c.b(keyEvent);
        if (this.f3544b.remove(keyEvent)) {
            J4.b.g("KeyboardManager", "A redispatched key event was consumed before reaching KeyboardManager");
        }
    }
}
