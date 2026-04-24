package W0;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import q1.AbstractC2628k;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f9121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f9122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i1.e f9123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final S.d f9124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f9125e;

    public interface a {
        v a(v vVar);
    }

    public i(Class cls, Class cls2, Class cls3, List list, i1.e eVar, S.d dVar) {
        this.f9121a = cls;
        this.f9122b = list;
        this.f9123c = eVar;
        this.f9124d = dVar;
        this.f9125e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public v a(com.bumptech.glide.load.data.e eVar, int i8, int i9, U0.h hVar, a aVar) {
        return this.f9123c.a(aVar.a(b(eVar, i8, i9, hVar)), hVar);
    }

    public final v b(com.bumptech.glide.load.data.e eVar, int i8, int i9, U0.h hVar) {
        List list = (List) AbstractC2628k.d(this.f9124d.b());
        try {
            return c(eVar, i8, i9, hVar, list);
        } finally {
            this.f9124d.a(list);
        }
    }

    public final v c(com.bumptech.glide.load.data.e eVar, int i8, int i9, U0.h hVar, List list) throws q {
        int size = this.f9122b.size();
        v vVarA = null;
        for (int i10 = 0; i10 < size; i10++) {
            U0.j jVar = (U0.j) this.f9122b.get(i10);
            try {
                if (jVar.b(eVar.a(), hVar)) {
                    vVarA = jVar.a(eVar.a(), i8, i9, hVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e8) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + jVar, e8);
                }
                list.add(e8);
            }
            if (vVarA != null) {
                break;
            }
        }
        if (vVarA != null) {
            return vVarA;
        }
        throw new q(this.f9125e, new ArrayList(list));
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f9121a + ", decoders=" + this.f9122b + ", transcoder=" + this.f9123c + '}';
    }
}
