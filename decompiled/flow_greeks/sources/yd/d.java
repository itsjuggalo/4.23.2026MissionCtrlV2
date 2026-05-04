package yd;

import bf.g;
import cd.f;
import df.e;
import fe.f1;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import pd.o;
import tf.k0;
import wd.h;
import zd.h1;
import zd.i3;
import zd.k;
import ze.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a extends q implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f25359a = new a();

        public a() {
            super(2, k0.class, "loadFunction", "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;", 0);
        }

        @Override // pd.o
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final f1 invoke(k0 p02, i p12) {
            t.f(p02, "p0");
            t.f(p12, "p1");
            return p02.s(p12);
        }
    }

    public static final h a(f fVar) {
        t.f(fVar, "<this>");
        Metadata metadata = (Metadata) fVar.getClass().getAnnotation(Metadata.class);
        if (metadata == null) {
            return null;
        }
        String[] strArrD1 = metadata.d1();
        if (strArrD1.length == 0) {
            strArrD1 = null;
        }
        if (strArrD1 == null) {
            return null;
        }
        cd.q qVarJ = df.i.j(strArrD1, metadata.d2());
        df.f fVar2 = (df.f) qVarJ.a();
        i iVar = (i) qVarJ.b();
        e eVar = new e(metadata.mv(), (metadata.xi() & 8) != 0);
        Class<?> cls = fVar.getClass();
        ze.t tVarM0 = iVar.m0();
        t.e(tVarM0, "getTypeTable(...)");
        return new h1(k.f25771d, (f1) i3.h(cls, iVar, fVar2, new g(tVarM0), eVar, a.f25359a));
    }
}
