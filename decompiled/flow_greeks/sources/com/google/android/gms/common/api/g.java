package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.api.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f5491a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Account f5492a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f5495d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f5496e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f5497f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f5498g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Context f5500i;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Looper f5503l;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set f5493b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set f5494c = new HashSet();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Map f5499h = new w.a();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Map f5501j = new w.a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f5502k = -1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public m5.e f5504m = m5.e.n();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public a.AbstractC0094a f5505n = g6.d.f10085c;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final ArrayList f5506o = new ArrayList();

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final ArrayList f5507p = new ArrayList();

        public a(Context context) {
            this.f5500i = context;
            this.f5503l = context.getMainLooper();
            this.f5497f = context.getPackageName();
            this.f5498g = context.getClass().getName();
        }

        public final com.google.android.gms.common.internal.e a() {
            g6.a aVar = g6.a.f10073j;
            Map map = this.f5501j;
            com.google.android.gms.common.api.a aVar2 = g6.d.f10089g;
            if (map.containsKey(aVar2)) {
                aVar = (g6.a) map.get(aVar2);
            }
            return new com.google.android.gms.common.internal.e(this.f5492a, this.f5493b, this.f5499h, this.f5495d, this.f5496e, this.f5497f, this.f5498g, aVar, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b extends com.google.android.gms.common.api.internal.f {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface c extends com.google.android.gms.common.api.internal.n {
    }

    public static Set c() {
        Set set = f5491a;
        synchronized (set) {
        }
        return set;
    }

    public abstract com.google.android.gms.common.api.internal.d a(com.google.android.gms.common.api.internal.d dVar);

    public abstract com.google.android.gms.common.api.internal.d b(com.google.android.gms.common.api.internal.d dVar);

    public a.f d(a.c cVar) {
        throw new UnsupportedOperationException();
    }

    public abstract Context e();

    public abstract Looper f();

    public boolean g(com.google.android.gms.common.api.internal.r rVar) {
        throw new UnsupportedOperationException();
    }

    public void h() {
        throw new UnsupportedOperationException();
    }
}
