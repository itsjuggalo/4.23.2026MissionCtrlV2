package W0;

import W0.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import q1.AbstractC2628k;

/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f9217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final S.d f9218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f9219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9220d;

    public t(Class cls, Class cls2, Class cls3, List list, S.d dVar) {
        this.f9217a = cls;
        this.f9218b = dVar;
        this.f9219c = (List) AbstractC2628k.c(list);
        this.f9220d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public v a(com.bumptech.glide.load.data.e eVar, U0.h hVar, int i8, int i9, i.a aVar) {
        List list = (List) AbstractC2628k.d(this.f9218b.b());
        try {
            return b(eVar, hVar, i8, i9, aVar, list);
        } finally {
            this.f9218b.a(list);
        }
    }

    public final v b(com.bumptech.glide.load.data.e eVar, U0.h hVar, int i8, int i9, i.a aVar, List list) throws q {
        int size = this.f9219c.size();
        v vVarA = null;
        for (int i10 = 0; i10 < size; i10++) {
            try {
                vVarA = ((i) this.f9219c.get(i10)).a(eVar, i8, i9, hVar, aVar);
            } catch (q e8) {
                list.add(e8);
            }
            if (vVarA != null) {
                break;
            }
        }
        if (vVarA != null) {
            return vVarA;
        }
        throw new q(this.f9220d, new ArrayList(list));
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f9219c.toArray()) + '}';
    }
}
