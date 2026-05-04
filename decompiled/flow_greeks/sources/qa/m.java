package qa;

import android.content.Context;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f19004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.firebase.remoteconfig.internal.d f19005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.firebase.remoteconfig.internal.c f19006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a7.g f19007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ga.h f19008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f19009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f19010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f19011h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.google.firebase.remoteconfig.internal.e f19012i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ScheduledExecutorService f19013j;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements pa.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final pa.c f19014a;

        public a(pa.c cVar) {
            this.f19014a = cVar;
        }

        @Override // pa.d
        public void remove() {
            m.this.d(this.f19014a);
        }
    }

    public m(a7.g gVar, ga.h hVar, com.google.firebase.remoteconfig.internal.c cVar, e eVar, Context context, String str, com.google.firebase.remoteconfig.internal.e eVar2, ScheduledExecutorService scheduledExecutorService) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.f19004a = linkedHashSet;
        this.f19005b = new com.google.firebase.remoteconfig.internal.d(gVar, hVar, cVar, eVar, context, str, linkedHashSet, eVar2, scheduledExecutorService);
        this.f19007d = gVar;
        this.f19006c = cVar;
        this.f19008e = hVar;
        this.f19009f = eVar;
        this.f19010g = context;
        this.f19011h = str;
        this.f19012i = eVar2;
        this.f19013j = scheduledExecutorService;
    }

    public synchronized pa.d b(pa.c cVar) {
        this.f19004a.add(cVar);
        c();
        return new a(cVar);
    }

    public final synchronized void c() {
        if (!this.f19004a.isEmpty()) {
            this.f19005b.C();
        }
    }

    public final synchronized void d(pa.c cVar) {
        this.f19004a.remove(cVar);
    }

    public synchronized void e(boolean z10) {
        this.f19005b.z(z10);
        if (!z10) {
            c();
        }
    }
}
