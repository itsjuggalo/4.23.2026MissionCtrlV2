package i3;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f11660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f11661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u3.e f11662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s0.c f11663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f11664e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        v a(v vVar);
    }

    public i(Class cls, Class cls2, Class cls3, List list, u3.e eVar, s0.c cVar) {
        this.f11660a = cls;
        this.f11661b = list;
        this.f11662c = eVar;
        this.f11663d = cVar;
        this.f11664e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public v a(com.bumptech.glide.load.data.e eVar, int i10, int i11, g3.h hVar, a aVar) {
        return this.f11662c.a(aVar.a(b(eVar, i10, i11, hVar)), hVar);
    }

    public final v b(com.bumptech.glide.load.data.e eVar, int i10, int i11, g3.h hVar) {
        List list = (List) c4.k.e((List) this.f11663d.b());
        try {
            return c(eVar, i10, i11, hVar, list);
        } finally {
            this.f11663d.a(list);
        }
    }

    public final v c(com.bumptech.glide.load.data.e eVar, int i10, int i11, g3.h hVar, List list) throws q {
        int size = this.f11661b.size();
        v vVarA = null;
        for (int i12 = 0; i12 < size; i12++) {
            g3.j jVar = (g3.j) this.f11661b.get(i12);
            try {
                if (jVar.b(eVar.a(), hVar)) {
                    vVarA = jVar.a(eVar.a(), i10, i11, hVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e10) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + jVar, e10);
                }
                list.add(e10);
            }
            if (vVarA != null) {
                break;
            }
        }
        if (vVarA != null) {
            return vVarA;
        }
        throw new q(this.f11664e, new ArrayList(list));
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f11660a + ", decoders=" + this.f11661b + ", transcoder=" + this.f11662c + '}';
    }
}
