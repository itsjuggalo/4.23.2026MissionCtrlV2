package e4;

import a3.InterfaceC0841b;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.Random;

/* JADX INFO: renamed from: e4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1481c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Random f13622f = new Random();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static InterfaceC1483e f13623g = new C1484f();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static W1.d f13624h = W1.g.d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0841b f13626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Y2.b f13627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f13628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f13629e;

    public C1481c(Context context, InterfaceC0841b interfaceC0841b, Y2.b bVar, long j7) {
        this.f13625a = context;
        this.f13626b = interfaceC0841b;
        this.f13627c = bVar;
        this.f13628d = j7;
    }

    public void a() {
        this.f13629e = true;
    }

    public boolean b(int i7) {
        return (i7 >= 500 && i7 < 600) || i7 == -2 || i7 == 429 || i7 == 408;
    }

    public void c() {
        this.f13629e = false;
    }

    public void d(f4.e eVar) {
        e(eVar, true);
    }

    public void e(f4.e eVar, boolean z7) {
        AbstractC1207s.k(eVar);
        long jB = f13624h.b() + this.f13628d;
        if (z7) {
            eVar.B(i.c(this.f13626b), i.b(this.f13627c), this.f13625a);
        } else {
            eVar.D(i.c(this.f13626b), i.b(this.f13627c));
        }
        int i7 = 1000;
        while (f13624h.b() + ((long) i7) <= jB && !eVar.v() && b(eVar.o())) {
            try {
                f13623g.a(f13622f.nextInt(250) + i7);
                if (i7 < 30000) {
                    if (eVar.o() != -2) {
                        i7 *= 2;
                        Log.w("ExponenentialBackoff", "network error occurred, backing off/sleeping.");
                    } else {
                        Log.w("ExponenentialBackoff", "network unavailable, sleeping.");
                        i7 = 1000;
                    }
                }
                if (this.f13629e) {
                    return;
                }
                eVar.F();
                if (z7) {
                    eVar.B(i.c(this.f13626b), i.b(this.f13627c), this.f13625a);
                } else {
                    eVar.D(i.c(this.f13626b), i.b(this.f13627c));
                }
            } catch (InterruptedException unused) {
                Log.w("ExponenentialBackoff", "thread interrupted during exponential backoff.");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
