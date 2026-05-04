package i3;

import i3.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f11756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s0.c f11757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f11758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11759d;

    public t(Class cls, Class cls2, Class cls3, List list, s0.c cVar) {
        this.f11756a = cls;
        this.f11757b = cVar;
        this.f11758c = (List) c4.k.d(list);
        this.f11759d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public v a(com.bumptech.glide.load.data.e eVar, g3.h hVar, int i10, int i11, i.a aVar) {
        List list = (List) c4.k.e((List) this.f11757b.b());
        try {
            return b(eVar, hVar, i10, i11, aVar, list);
        } finally {
            this.f11757b.a(list);
        }
    }

    public final v b(com.bumptech.glide.load.data.e eVar, g3.h hVar, int i10, int i11, i.a aVar, List list) throws q {
        int size = this.f11758c.size();
        v vVarA = null;
        for (int i12 = 0; i12 < size; i12++) {
            try {
                vVarA = ((i) this.f11758c.get(i12)).a(eVar, i10, i11, hVar, aVar);
            } catch (q e10) {
                list.add(e10);
            }
            if (vVarA != null) {
                break;
            }
        }
        if (vVarA != null) {
            return vVarA;
        }
        throw new q(this.f11759d, new ArrayList(list));
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f11758c.toArray()) + '}';
    }
}
